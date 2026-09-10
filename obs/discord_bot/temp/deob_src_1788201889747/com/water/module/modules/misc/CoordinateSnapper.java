/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.water.WaterClient;
import com.water.gui.ToastManager;
import com.water.module.ActivatableModule;
import com.water.module.Category;
import com.water.setting.Setting;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import net.minecraft.class_156;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_642;

public final class CoordinateSnapper
extends ActivatableModule {
    private static final Duration field_0;
    private static final class_1799 field_1;
    private static final DateTimeFormatter field_2;
    private static final HttpClient field_3;
    private final Setting<String> field_4;
    private final Setting<Boolean> field_5;
    private volatile long field_6;

    public CoordinateSnapper() {
        super("CoordSnapper", Category.c);
        this.a = new Setting<String>(this, "Webhook", ""){

            @Override
            public boolean matchesName(String string) {
                return super.matchesName(string) || "Webhook URL".equalsIgnoreCase(string);
            }
        };
        this.aF = new Setting<Boolean>("Notification", true);
        this.addSetting(this.a);
        this.addSetting(this.aF);
    }

    @Override
    public void method_0() {
        if (!this.isEnabled() || CoordinateSnapper.mc.field_1724 == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.w < 250L) {
            return;
        }
        this.w = l;
        Object object = this.e((String)this.a.getValue());
        if (!this.b((String)object)) {
            this.a("Webhook invalid", "Set a Discord webhook URL.", -1002662);
            return;
        }
        object = this.a((String)object);
        CompletableFuture.runAsync((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, b(com.water.module.modules.misc.CoordinateSnapper$a ), ()V)((CoordinateSnapper)this, (a)object), class_156.method_27958().method_64116("coordsnapper-send")).whenComplete((BiConsumer)(BiConsumer<Void, Throwable>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)V, a(com.water.module.modules.misc.CoordinateSnapper$a java.lang.Void java.lang.Throwable ), (Ljava/lang/Void;Ljava/lang/Throwable;)V)((CoordinateSnapper)this, (a)object));
    }

    private a method_1(String string) {
        int n = CoordinateSnapper.mc.field_1724.method_31477();
        int n2 = CoordinateSnapper.mc.field_1724.method_31478();
        int n3 = CoordinateSnapper.mc.field_1724.method_31479();
        String string2 = CoordinateSnapper.mc.field_1724.method_5477().getString();
        String string3 = this.e();
        String string4 = b.format(ZonedDateTime.now());
        String string5 = this.f(string2);
        string5 = "https://mc-heads.net/body/" + string5;
        return new a(string, string2, n, n2, n3, string3, string4, string5);
    }

    private void method_2(a object) {
        Object object2 = new JsonObject();
        object2.addProperty("username", "CoordSnapper");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", "CoordSnapper");
        jsonObject.addProperty("color", (Number)5624994);
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement)this.a("Name", ((a)object).playerName(), false));
        jsonArray.add((JsonElement)this.a("Coords", object.o(), false));
        jsonArray.add((JsonElement)this.a("IP", object.k(), true));
        jsonArray.add((JsonElement)this.a("Time", object.l(), true));
        jsonObject.add("fields", (JsonElement)jsonArray);
        jsonArray = new JsonObject();
        jsonArray.addProperty("url", object.m());
        jsonObject.add("thumbnail", (JsonElement)jsonArray);
        jsonArray = new JsonArray();
        jsonArray.add((JsonElement)jsonObject);
        object2.add("embeds", (JsonElement)jsonArray);
        object2 = HttpRequest.newBuilder(this.a(object.f())).timeout(b).header("Content-Type", "application/json").header("Accept", "application/json").header("User-Agent", "Water-CoordSnapper").POST(HttpRequest.BodyPublishers.ofString(object2.toString())).build();
        try {
            object2 = b.send((HttpRequest)object2, HttpResponse.BodyHandlers.ofString());
        }
        catch (Exception exception) {
            WaterClient.a.error("CoordSnapper webhook request failed", (Throwable)exception);
            throw new IllegalStateException("Webhook request failed", exception);
        }
        int n = object2.statusCode();
        if (n >= 200 && n < 300) {
            WaterClient.a.info("CoordSnapper sent coords for {}", (Object)((a)object).playerName());
            return;
        }
        object = (String)object2.body();
        if (object != null && !((String)object).isBlank()) {
            WaterClient.a.warn("CoordSnapper webhook rejected with status {} and body {}", (Object)n, (Object)this.a((String)object, 240));
            throw new IllegalStateException("HTTP " + n + ": " + this.a((String)object, 120));
        }
        WaterClient.a.warn("CoordSnapper webhook rejected with status {}", (Object)n);
        throw new IllegalStateException("HTTP " + n);
    }

    private JsonObject method_3(String string, String string2, boolean bl) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", string);
        jsonObject.addProperty("value", string2 == null || string2.isBlank() ? "-" : string2);
        jsonObject.addProperty("inline", Boolean.valueOf(bl));
        return jsonObject;
    }

    private String method_4() {
        Object object = mc.method_1558();
        if (object == null || ((class_642)object).field_3761 == null || ((class_642)object).field_3761.isBlank()) {
            return "Singleplayer";
        }
        object = this.d(((class_642)object).field_3761);
        return ((String)object).isEmpty() ? "Singleplayer" : object;
    }

    private String method_5(String string) {
        int n = (string = string == null ? "" : string.trim().toLowerCase(Locale.ROOT)).indexOf(47);
        if (n >= 0) {
            string = string.substring(0, n);
        }
        if ((n = string.indexOf(58)) >= 0) {
            string = string.substring(0, n);
        }
        return string;
    }

    private String method_6(String string) {
        return string == null ? "" : string.trim();
    }

    private String method_7(String string) {
        if (string == null || string.isBlank()) {
            return "Steve";
        }
        return string.trim();
    }

    private URI method_8(String string) {
        URI uRI = URI.create(string);
        String string2 = uRI.getQuery();
        if (string2 == null || string2.isBlank()) {
            return URI.create(string + "?wait=true");
        }
        if (string2.contains("wait=")) {
            return uRI;
        }
        return URI.create(string + "&wait=true");
    }

    private boolean method_9(String object) {
        if (((String)object).isEmpty()) {
            return false;
        }
        try {
            object = URI.create((String)object);
            String string = ((URI)object).getScheme();
            String string2 = ((URI)object).getHost();
            object = ((URI)object).getPath();
            return ("https".equalsIgnoreCase(string) || "http".equalsIgnoreCase(string)) && string2 != null && !string2.isBlank() && object != null && ((String)object).contains("/api/webhooks/");
        }
        catch (Exception exception) {
            return false;
        }
    }

    private void method_10(String string, String string2, int n) {
        if (mc == null || !((Boolean)this.aF.getValue()).booleanValue()) {
            return;
        }
        mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, b(java.lang.String java.lang.String int ), ()V)((String)string, (String)string2, (int)n));
    }

    private String getRootMessage(Throwable throwable) {
        while (throwable.getCause() != null) {
            throwable = throwable.getCause();
        }
        String string = throwable.getMessage();
        return string == null || string.isBlank() ? throwable.getClass().getSimpleName() : this.a(string, 120);
    }

    private String method_11(String string, int n) {
        if (string == null) {
            return "";
        }
        if ((string = string.replace('\n', ' ').replace('\r', ' ').trim()).length() <= n) {
            return string;
        }
        return string.substring(0, Math.max(0, n - 3)) + "...";
    }

    private static /* synthetic */ void method_12(String string, String string2, int n) {
        ToastManager.INSTANCE.push(string, string2, a, n);
    }

    private /* synthetic */ void method_13(a a2, Void void_, Throwable throwable) {
        mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(java.lang.Throwable com.water.module.modules.misc.CoordinateSnapper$a ), ()V)((CoordinateSnapper)this, (Throwable)throwable, (a)a2));
    }

    private /* synthetic */ void method_14(Throwable throwable, a a2) {
        if (throwable != null) {
            this.a("Send failed", this.getRootMessage(throwable), -1938838);
            return;
        }
        this.a("Coords sent", a2.p(), -11152222);
    }

    private /* synthetic */ void method_15(a a2) {
        this.a(a2);
    }

    static {
        b = Duration.ofSeconds(8L);
        a = new class_1799((class_1935)class_1802.field_38747);
        b = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z", Locale.ROOT);
        b = HttpClient.newBuilder().connectTimeout(b).followRedirects(HttpClient.Redirect.NORMAL).build();
    }

    private static final class a
    extends Record {
        private final String field_0;
        private final String field_1;
        private final int field_2;
        private final int field_3;
        private final int field_4;
        private final String field_5;
        private final String field_6;
        private final String field_7;

        private a(String string, String string2, int n, int n2, int n3, String string3, String string4, String string5) {
            this.v = string;
            this.w = string2;
            this.am = n;
            this.an = n2;
            this.ao = n3;
            this.x = string3;
            this.y = string4;
            this.z = string5;
        }

        private String method_0() {
            return "X: " + this.am + " Y: " + this.an + " Z: " + this.ao;
        }

        private String method_1() {
            return this.am + ", " + this.an + ", " + this.ao;
        }

        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{a.class, "webhook;playerName;x;y;z;serverIp;time;skinRenderUrl", "v", "w", "am", "an", "ao", "x", "y", "z"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{a.class, "webhook;playerName;x;y;z;serverIp;time;skinRenderUrl", "v", "w", "am", "an", "ao", "x", "y", "z"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{a.class, "webhook;playerName;x;y;z;serverIp;time;skinRenderUrl", "v", "w", "am", "an", "ao", "x", "y", "z"}, this, object);
        }

        public String method_2() {
            return this.v;
        }

        public String playerName() {
            return this.w;
        }

        public String method_3() {
            return this.x;
        }

        public String method_4() {
            return this.y;
        }

        public String method_5() {
            return this.z;
        }
    }
}

