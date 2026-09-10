/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Base64;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.class_10538;
import net.minecraft.class_12079;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_7920;
import net.minecraft.class_8685;

public final class SkinChanger
extends Module {
    private static final Duration HTTP_TIMEOUT = Duration.ofSeconds(10L);
    private static final long INPUT_DEBOUNCE_MS = 600L;
    private static final String PRIMARY_LOOKUP_URL = "https://api.mojang.com/users/profiles/minecraft/";
    private static final String FALLBACK_LOOKUP_URL = "https://api.minecraftservices.com/minecraft/profile/lookup/name/";
    private static final String PROFILE_LOOKUP_URL = "https://sessionserver.mojang.com/session/minecraft/profile/";
    private static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().connectTimeout(HTTP_TIMEOUT).followRedirects(HttpClient.Redirect.NORMAL).build();
    private static volatile class_8685 overrideSkin;
    private static volatile class_12079.class_12081 overrideTextureAsset;
    private final Setting<String> playerName = new Setting<String>("Player Name", "");
    private final AtomicInteger requestGeneration = new AtomicInteger();
    private class_10538 skinDownloader;
    private String lastObservedName = "";
    private String lastRequestedName = "";
    private long lastNameEditAt;

    public SkinChanger() {
        super("SkinChanger", Category.c);
        this.addSetting(this.playerName);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.lastObservedName = SkinChanger.normalizeName(this.playerName.getValue());
        this.lastRequestedName = "";
        this.lastNameEditAt = System.currentTimeMillis();
        if (this.lastObservedName.isEmpty()) {
            SkinChanger.clearOverride();
            return;
        }
        this.requestSkin(this.lastObservedName);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.requestGeneration.incrementAndGet();
        this.lastRequestedName = "";
        SkinChanger.clearOverride();
    }

    @Override
    public void onTick() {
        String string = SkinChanger.normalizeName(this.playerName.getValue());
        if (!Objects.equals(string, this.lastObservedName)) {
            this.lastObservedName = string;
            this.lastNameEditAt = System.currentTimeMillis();
            return;
        }
        if (string.isEmpty()) {
            if (overrideSkin != null || overrideTextureAsset != null) {
                this.lastRequestedName = "";
                SkinChanger.clearOverride();
            }
            return;
        }
        if (!Objects.equals(string, this.lastRequestedName) && System.currentTimeMillis() - this.lastNameEditAt >= 600L) {
            this.requestSkin(string);
        }
    }

    public static class_8685 getOverrideSkin(UUID uUID) {
        if (overrideSkin == null || uUID == null) {
            return null;
        }
        UUID uUID2 = SkinChanger.getLocalPlayerUuid();
        return uUID2 != null && uUID2.equals(uUID) ? overrideSkin : null;
    }

    private void requestSkin(String string) {
        this.lastRequestedName = string;
        int n = this.requestGeneration.incrementAndGet();
        ((CompletableFuture)CompletableFuture.supplyAsync(() -> this.lookupSkin(string), class_156.method_27958().method_64116("skinchanger-lookup")).thenCompose(skinLookup -> this.getSkinDownloader().method_65861(this.createTextureId((SkinLookup)skinLookup), this.getCacheFile(skinLookup.uuid()), skinLookup.textureUrl(), true).thenApply(class_120812 -> new ResolvedSkin((SkinLookup)skinLookup, (class_12079.class_12081)class_120812)))).whenComplete((resolvedSkin, throwable) -> mc.execute(() -> {
            if (n != this.requestGeneration.get() || !this.isEnabled()) {
                if (resolvedSkin != null) {
                    SkinChanger.destroyTexture(resolvedSkin.textureAsset());
                }
                return;
            }
            if (throwable != null) {
                this.sendFeedback("Failed to apply skin for " + string + ": " + SkinChanger.getRootMessage(throwable));
                return;
            }
            SkinChanger.applyOverride(resolvedSkin.textureAsset(), resolvedSkin.lookup().skinType());
            this.sendFeedback("Applied skin from " + resolvedSkin.lookup().playerName() + ".");
        }));
    }

    private class_10538 getSkinDownloader() {
        if (this.skinDownloader == null) {
            this.skinDownloader = new class_10538(mc.method_1487(), mc.method_1531(), arg_0 -> ((class_310)mc).execute(arg_0));
        }
        return this.skinDownloader;
    }

    private SkinLookup lookupSkin(String string) {
        try {
            UUID uUID = this.lookupUuid(string);
            TexturePayload texturePayload = this.lookupTexturePayload(uUID);
            return new SkinLookup(string, uUID, texturePayload.textureUrl(), texturePayload.skinType());
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Request interrupted", interruptedException);
        }
        catch (IOException iOException) {
            throw new IllegalStateException(iOException.getMessage(), iOException);
        }
    }

    private UUID lookupUuid(String string) throws IOException, InterruptedException {
        JsonObject jsonObject = this.requestJson(PRIMARY_LOOKUP_URL + this.encodeName(string));
        if (jsonObject == null) {
            jsonObject = this.requestJson(FALLBACK_LOOKUP_URL + this.encodeName(string));
        }
        if (jsonObject == null || !jsonObject.has("id")) {
            throw new IOException("Player not found");
        }
        return SkinChanger.parseUuid(jsonObject.get("id").getAsString());
    }

    private TexturePayload lookupTexturePayload(UUID object) throws IOException, InterruptedException {
        object = this.requestJson(PROFILE_LOOKUP_URL + ((UUID)object).toString().replace("-", ""));
        if (object == null || !object.has("properties")) {
            throw new IOException("Skin profile not found");
        }
        object = object.getAsJsonArray("properties");
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (JsonElement)object.next();
            if (!object2.isJsonObject() || !"textures".equalsIgnoreCase(SkinChanger.getString((JsonObject)(object2 = object2.getAsJsonObject()), "name")) || !object2.has("value")) continue;
            object = new String(Base64.getDecoder().decode(object2.get("value").getAsString()), StandardCharsets.UTF_8);
            object = JsonParser.parseString((String)object).getAsJsonObject();
            Object object3 = object = (object = object.getAsJsonObject("textures")) != null ? object.getAsJsonObject("SKIN") : null;
            if (object == null || !object.has("url")) break;
            object2 = null;
            JsonObject jsonObject = object.getAsJsonObject("metadata");
            if (jsonObject != null && jsonObject.has("model")) {
                object2 = jsonObject.get("model").getAsString();
            }
            object2 = "slim".equalsIgnoreCase((String)object2) ? class_7920.field_41122 : class_7920.field_41123;
            return new TexturePayload(object.get("url").getAsString(), (class_7920)object2);
        }
        throw new IOException("No usable skin texture found");
    }

    private JsonObject requestJson(String object) throws IOException, InterruptedException {
        object = HttpRequest.newBuilder(URI.create((String)object)).timeout(HTTP_TIMEOUT).header("Accept", "application/json").header("User-Agent", "Water-SkinChanger").GET().build();
        int n = (object = HTTP_CLIENT.send((HttpRequest)object, HttpResponse.BodyHandlers.ofString())).statusCode();
        if (n == 404 || n == 204) {
            return null;
        }
        if (n < 200 || n >= 300) {
            throw new IOException("HTTP " + n);
        }
        if ((object = object.body()) == null || ((String)object).isBlank()) {
            return null;
        }
        return JsonParser.parseString((String)object).getAsJsonObject();
    }

    private static synchronized void applyOverride(class_12079.class_12081 class_120812, class_7920 class_79202) {
        SkinChanger.destroyTexture(overrideTextureAsset);
        overrideTextureAsset = class_120812;
        overrideSkin = class_8685.method_74884((class_12079.class_12081)class_120812, null, null, (class_7920)class_79202);
    }

    private static synchronized void clearOverride() {
        SkinChanger.destroyTexture(overrideTextureAsset);
        overrideTextureAsset = null;
        overrideSkin = null;
    }

    private static void destroyTexture(class_12079.class_12081 class_120812) {
        if (class_120812 == null || mc == null) {
            return;
        }
        try {
            mc.method_1531().method_4615(class_120812.comp_3627());
        }
        catch (Throwable throwable) {}
        try {
            if (!class_120812.comp_3626().equals((Object)class_120812.comp_3627())) {
                mc.method_1531().method_4615(class_120812.comp_3626());
            }
        }
        catch (Throwable throwable) {}
    }

    private void sendFeedback(String string) {
        if (mc == null || SkinChanger.mc.field_1705 == null) {
            return;
        }
        try {
            SkinChanger.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)("[SkinChanger] " + string)));
        }
        catch (Throwable throwable) {}
    }

    private class_2960 createTextureId(SkinLookup skinLookup) {
        String string = skinLookup.playerName().toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9_]", "");
        if (string.isEmpty()) {
            string = "player";
        }
        return class_2960.method_60655((String)"water", (String)("skins/" + string + "_" + skinLookup.uuid().toString().replace("-", "")));
    }

    private Path getCacheFile(UUID uUID) {
        return SkinChanger.mc.field_1697.toPath().resolve("water-cache").resolve("skins").resolve(uUID.toString().replace("-", "") + ".png");
    }

    private String encodeName(String string) {
        return URLEncoder.encode(string, StandardCharsets.UTF_8);
    }

    private static UUID parseUuid(String string) {
        string = string.replace("-", "");
        return UUID.fromString(string.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
    }

    private static String normalizeName(String string) {
        return string == null ? "" : string.trim();
    }

    private static String getString(JsonObject jsonObject, String string) {
        return jsonObject.has(string) ? jsonObject.get(string).getAsString() : "";
    }

    private static String getRootMessage(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        String string = throwable.getMessage();
        return string == null || string.isBlank() ? throwable.getClass().getSimpleName() : string;
    }

    private static UUID getLocalPlayerUuid() {
        if (mc == null) {
            return null;
        }
        if (SkinChanger.mc.field_1724 != null) {
            return SkinChanger.mc.field_1724.method_5667();
        }
        return mc.method_1548() != null ? mc.method_1548().method_44717() : null;
    }

    private record TexturePayload(String textureUrl, class_7920 skinType) {
    }

    private record SkinLookup(String playerName, UUID uuid, String textureUrl, class_7920 skinType) {
    }

    private record ResolvedSkin(SkinLookup lookup, class_12079.class_12081 textureAsset) {
    }
}

