/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.water.WaterClient;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.Friends;
import com.water.setting.Setting;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.ToDoubleFunction;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_156;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1887;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_3965;
import net.minecraft.class_642;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import net.minecraft.class_7924;

public final class SpawnerProtect
extends Module {
    private static final Duration field_0;
    private static final DateTimeFormatter field_1;
    private static final HttpClient field_2;
    private final Setting<Integer> field_3;
    private final Setting<String> field_4;
    private class_2338 field_5;
    private boolean field_6;
    private int field_7;

    public SpawnerProtect() {
        super("SpawnerProtect", Category.d);
        this.I = new Setting<Integer>("Critical Distance", 5, 1, 20);
        this.a = new Setting<String>(this, "Webhook", ""){

            @Override
            public boolean matchesName(String string) {
                return super.matchesName(string) || "Webhook URL".equalsIgnoreCase(string);
            }
        };
        this.addSetting(this.I);
        this.addSetting(this.a);
    }

    @Override
    public void onEnable() {
        this.ag();
        if (!this.l()) {
            this.q("Need a Silk Touch pickaxe in hotbar");
        }
    }

    @Override
    public void onDisable() {
        this.af();
    }

    @Override
    public void onTick() {
        if (SpawnerProtect.mc.field_1724 == null || SpawnerProtect.mc.field_1687 == null || SpawnerProtect.mc.field_1761 == null) {
            return;
        }
        if (this.v) {
            return;
        }
        if (!this.l()) {
            this.q("Need a Silk Touch pickaxe in hotbar");
            return;
        }
        a a2 = this.a();
        if (a2.n()) {
            this.a(this.a(a2.b(), a2.a()));
            return;
        }
        if (!a2.m()) {
            this.af();
            return;
        }
        int n = this.i();
        if (n == -1) {
            this.q("Need a Silk Touch pickaxe in hotbar");
            return;
        }
        this.h(n);
        this.ae();
        if (this.b == null || !this.b(this.b) || !SpawnerProtect.mc.field_1724.method_56093(this.b, 5.0)) {
            this.b = this.a();
            if (this.b == null) {
                this.a(this.a());
                return;
            }
        }
        class_2350 class_23502 = this.a(this.b);
        this.a(this.b, class_23502);
        SpawnerProtect.mc.field_1761.method_2902(this.b, class_23502);
        SpawnerProtect.mc.field_1687.method_74254(this.b, class_23502);
        SpawnerProtect.mc.field_1724.method_6104(class_1268.field_5808);
        if (!this.b(this.b)) {
            ++this.q;
            this.b = null;
        }
    }

    private a method_0() {
        double d2 = SpawnerProtect.a((int)((Integer)this.I.getValue()));
        boolean bl = false;
        boolean bl2 = false;
        class_1657 class_16572 = null;
        double d3 = -1.0;
        for (class_1657 class_16573 : SpawnerProtect.mc.field_1687.method_18456()) {
            if (class_16573 == SpawnerProtect.mc.field_1724 || class_16573.method_7325() || class_16573.method_5722((class_1297)SpawnerProtect.mc.field_1724) || Friends.d() && Friends.a((String)class_16573.method_5477().getString())) continue;
            bl = true;
            double d4 = SpawnerProtect.mc.field_1724.method_5858((class_1297)class_16573);
            if (!(d4 <= d2)) continue;
            bl2 = true;
            double d5 = Math.sqrt(d4);
            class_16572 = class_16573;
            d3 = d5;
            break;
        }
        return new a(bl, bl2, class_16572, d3);
    }

    private class_2338 method_1() {
        ArrayList<class_2338> arrayList = new ArrayList<class_2338>();
        class_2338 class_23382 = SpawnerProtect.mc.field_1724.method_24515();
        for (int i = -32; i <= 32; ++i) {
            for (int j = -32; j <= 32; ++j) {
                for (int k = -32; k <= 32; ++k) {
                    class_2338 class_23383;
                    int n = i * i + j * j + k * k;
                    if (n > 1024 || !this.b(class_23383 = class_23382.method_10069(i, j, k)) || !SpawnerProtect.mc.field_1724.method_56093(class_23383, 5.0)) continue;
                    arrayList.add(class_23383.method_10062());
                }
            }
        }
        return arrayList.stream().min(Comparator.comparingDouble((ToDoubleFunction<class_2338>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)D, a(net.minecraft.class_2338 ), (Lnet/minecraft/class_2338;)D)((SpawnerProtect)this))).orElse(null);
    }

    private boolean method_2() {
        return this.i() != -1;
    }

    private int method_3() {
        for (int i = 0; i < 9; ++i) {
            if (!this.a(SpawnerProtect.mc.field_1724.method_31548().method_5438(i))) continue;
            return i;
        }
        return -1;
    }

    private boolean method_4(class_1799 class_17992) {
        if (class_17992 == null || class_17992.method_7960()) {
            return false;
        }
        String string = class_7923.field_41178.method_10221((Object)class_17992.method_7909()).method_12832();
        if (!string.endsWith("_pickaxe")) {
            return false;
        }
        string = SpawnerProtect.mc.field_1687.method_30349().method_30530(class_7924.field_41265).method_47983((Object)((class_1887)SpawnerProtect.mc.field_1687.method_30349().method_30530(class_7924.field_41265).method_29107(class_1893.field_9099)));
        return string != null && class_1890.method_8225((class_6880)string, (class_1799)class_17992) > 0;
    }

    private boolean method_5(class_2338 class_23382) {
        return SpawnerProtect.mc.field_1687 != null && SpawnerProtect.mc.field_1687.method_8320(class_23382).method_27852(class_2246.field_10260);
    }

    private class_2350 method_6(class_2338 class_23382) {
        class_23382 = SpawnerProtect.mc.field_1724.method_33571().method_1020(class_243.method_24953((class_2382)class_23382));
        return class_2350.method_10142((double)class_23382.field_1352, (double)class_23382.field_1351, (double)class_23382.field_1350);
    }

    private void method_7(class_2338 class_23382, class_2350 class_23502) {
        class_243 class_2432 = SpawnerProtect.mc.field_1724.method_33571();
        class_243 class_2433 = class_243.method_24953((class_2382)class_23382);
        double d2 = class_2433.field_1352 - class_2432.field_1352;
        double d3 = class_2433.field_1351 - class_2432.field_1351;
        double d4 = class_2433.field_1350 - class_2432.field_1350;
        double d5 = Math.sqrt(d2 * d2 + d4 * d4);
        float f = (float)(Math.toDegrees(Math.atan2(d4, d2)) - 90.0);
        float f2 = (float)(-Math.toDegrees(Math.atan2(d3, d5)));
        SpawnerProtect.mc.field_1724.method_36456(f);
        SpawnerProtect.mc.field_1724.method_36457(f2);
        SpawnerProtect.mc.field_1765 = new class_3965(class_2433, class_23502, class_23382, false);
    }

    private void method_8(int n) {
        if (n >= 0 && n < 9 && SpawnerProtect.mc.field_1724.method_31548().method_67532() != n) {
            SpawnerProtect.mc.field_1724.method_31548().method_61496(n);
        }
    }

    private void method_9() {
        SpawnerProtect.mc.field_1690.field_1832.method_23481(true);
        SpawnerProtect.mc.field_1724.method_5660(true);
    }

    private void method_10() {
        this.b = null;
        if (SpawnerProtect.mc.field_1761 != null && SpawnerProtect.mc.field_1761.method_2923()) {
            SpawnerProtect.mc.field_1761.method_2925();
        }
        if (SpawnerProtect.mc.field_1724 != null) {
            SpawnerProtect.mc.field_1690.field_1832.method_23481(false);
            SpawnerProtect.mc.field_1724.method_5660(false);
        }
    }

    private void method_11(b b2) {
        this.af();
        String string = this.e((String)this.a.getValue());
        if (!this.b(string)) {
            this.v = false;
            this.q(b2.n());
            return;
        }
        this.v = true;
        CompletableFuture.runAsync((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, c(com.water.module.modules.donut.SpawnerProtect$b ), ()V)((SpawnerProtect)this, (b)b2), class_156.method_27958().method_64116("coordsnapper-send")).whenComplete((BiConsumer)(BiConsumer<Void, Throwable>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)V, a(com.water.module.modules.donut.SpawnerProtect$b java.lang.Void java.lang.Throwable ), (Ljava/lang/Void;Ljava/lang/Throwable;)V)((SpawnerProtect)this, (b)b2));
    }

    private b method_12() {
        String string = this.e((String)this.a.getValue());
        return new b(string, "[SpawnerProtect]", "All your spawners have been collected.", 5624994, SpawnerProtect.mc.field_1724.method_5477().getString(), "", "", this.j(), true, this.e(), a.format(LocalTime.now()), "https://mc-heads.net/body/" + this.f(SpawnerProtect.mc.field_1724.method_5477().getString()), "SpawnerProtect finished");
    }

    private b method_13(class_1657 object, double d2) {
        String string = this.e((String)this.a.getValue());
        object = object != null ? object.method_5477().getString() : "Unknown";
        return new b(string, "[SpawnerProtect]", (String)object + " came too close.", 14838378, SpawnerProtect.mc.field_1724.method_5477().getString(), (String)object, String.format(Locale.ROOT, "%.1f", d2), this.j(), false, this.e(), a.format(LocalTime.now()), "https://mc-heads.net/body/" + this.f((String)object), "Enemy within critical distance");
    }

    private void method_14(b object) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", "SpawnerProtect");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("title", object.g());
        jsonObject2.addProperty("description", object.h());
        jsonObject2.addProperty("color", (Number)object.k());
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement)this.a("Player", ((b)object).playerName(), false));
        jsonArray.add((JsonElement)this.a("Time", object.l(), true));
        jsonArray.add((JsonElement)this.a("Server", object.k(), true));
        jsonArray.add((JsonElement)this.a("All spawners mined", object.o() ? "\u2705 Yes" : "\u274c No", false));
        jsonArray.add((JsonElement)this.a("Spawners in bag", object.l() + " spawners", false));
        if (!object.i().isBlank()) {
            jsonArray.add((JsonElement)this.a("Threat", object.i() + " (" + object.j() + " blocks)", false));
        }
        jsonObject2.add("fields", (JsonElement)jsonArray);
        jsonArray = new JsonObject();
        jsonArray.addProperty("url", object.m());
        jsonObject2.add("thumbnail", (JsonElement)jsonArray);
        jsonArray = new JsonArray();
        jsonArray.add((JsonElement)jsonObject2);
        jsonObject.add("embeds", (JsonElement)jsonArray);
        object = HttpRequest.newBuilder(this.a(object.f())).timeout(a).header("Content-Type", "application/json").header("Accept", "application/json").header("User-Agent", "Water-CoordSnapper").POST(HttpRequest.BodyPublishers.ofString(jsonObject.toString())).build();
        try {
            object = a.send((HttpRequest)object, HttpResponse.BodyHandlers.ofString());
        }
        catch (Exception exception) {
            WaterClient.a.error("SpawnerProtect webhook request failed", (Throwable)exception);
            throw new IllegalStateException("Webhook request failed", exception);
        }
        int n = object.statusCode();
        if (n >= 200 && n < 300) {
            WaterClient.a.info("SpawnerProtect webhook sent");
            return;
        }
        if ((object = object.body()) != null && !((String)object).isBlank()) {
            WaterClient.a.warn("SpawnerProtect webhook rejected with status {} and body {}", (Object)n, (Object)this.a((String)object, 240));
            throw new IllegalStateException("HTTP " + n + ": " + this.a((String)object, 120));
        }
        WaterClient.a.warn("SpawnerProtect webhook rejected with status {}", (Object)n);
        throw new IllegalStateException("HTTP " + n);
    }

    private JsonObject method_15(String string, String string2, boolean bl) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", string);
        jsonObject.addProperty("value", string2 == null || string2.isBlank() ? "-" : string2);
        jsonObject.addProperty("inline", Boolean.valueOf(bl));
        return jsonObject;
    }

    private String method_16() {
        Object object = mc.method_1558();
        if (object == null || ((class_642)object).field_3761 == null || ((class_642)object).field_3761.isBlank()) {
            return "Singleplayer";
        }
        object = this.d(((class_642)object).field_3761);
        return ((String)object).isEmpty() ? "Singleplayer" : object;
    }

    private String method_17(String string) {
        int n = (string = string == null ? "" : string.trim().toLowerCase(Locale.ROOT)).indexOf(47);
        if (n >= 0) {
            string = string.substring(0, n);
        }
        if ((n = string.indexOf(58)) >= 0) {
            string = string.substring(0, n);
        }
        return string;
    }

    private String method_18(String string) {
        return string == null ? "" : string.trim();
    }

    private String method_19(String string) {
        if (string == null || string.isBlank()) {
            return "Steve";
        }
        return string.trim();
    }

    private URI method_20(String string) {
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

    private boolean method_21(String object) {
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

    private String method_22(String string, int n) {
        if (string == null) {
            return "";
        }
        if ((string = string.replace('\n', ' ').replace('\r', ' ').trim()).length() <= n) {
            return string;
        }
        return string.substring(0, Math.max(0, n - 3)) + "...";
    }

    private int method_23() {
        int n = 0;
        for (int i = 0; i < SpawnerProtect.mc.field_1724.method_31548().method_5439(); ++i) {
            class_1799 class_17992 = SpawnerProtect.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || !class_17992.method_31574(class_2246.field_10260.method_8389())) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private void method_24(String string) {
        if (mc.method_1562() != null && mc.method_1562().method_48296() != null) {
            mc.method_1562().method_48296().method_10747((class_2561)class_2561.method_43470((String)string));
        }
        this.setEnabled(false);
    }

    private double method_25(class_2338 class_23382) {
        return SpawnerProtect.mc.field_1724.method_5707(class_243.method_24953((class_2382)class_23382));
    }

    private static double method_26(int n) {
        return (double)n * (double)n;
    }

    private void method_27() {
        this.b = null;
        this.v = false;
        this.q = 0;
    }

    private /* synthetic */ void method_28(b b2, Void void_, Throwable throwable) {
        mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(java.lang.Throwable com.water.module.modules.donut.SpawnerProtect$b ), ()V)((SpawnerProtect)this, (Throwable)throwable, (b)b2));
    }

    private /* synthetic */ void method_29(Throwable throwable, b b2) {
        if (throwable != null) {
            WaterClient.a.error("SpawnerProtect webhook failed", throwable);
        }
        this.v = false;
        this.q(b2.n());
    }

    private /* synthetic */ void method_30(b b2) {
        this.b(b2);
    }

    static {
        a = Duration.ofSeconds(8L);
        a = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ROOT);
        a = HttpClient.newBuilder().connectTimeout(a).followRedirects(HttpClient.Redirect.NORMAL).build();
    }

    private static final class a
    extends Record {
        private final boolean field_0;
        private final boolean field_1;
        private final class_1657 field_2;
        private final double field_3;

        private a(boolean bl, boolean bl2, class_1657 class_16572, double d2) {
            this.w = bl;
            this.x = bl2;
            this.a = class_16572;
            this.a = d2;
        }

        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{a.class, "hasAnyEnemy;hasCriticalThreat;threat;distance", "w", "x", "a", "a"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{a.class, "hasAnyEnemy;hasCriticalThreat;threat;distance", "w", "x", "a", "a"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{a.class, "hasAnyEnemy;hasCriticalThreat;threat;distance", "w", "x", "a", "a"}, this, object);
        }

        public boolean method_0() {
            return this.w;
        }

        public boolean method_1() {
            return this.x;
        }

        public class_1657 method_2() {
            return this.a;
        }

        public double method_3() {
            return this.a;
        }
    }

    private static final class b
    extends Record {
        private final String field_0;
        private final String field_1;
        private final String field_2;
        private final int field_3;
        private final String field_4;
        private final String field_5;
        private final String field_6;
        private final int field_7;
        private final boolean field_8;
        private final String field_9;
        private final String field_10;
        private final String field_11;
        private final String field_12;

        private b(String string, String string2, String string3, int n, String string4, String string5, String string6, int n2, boolean bl, String string7, String string8, String string9, String string10) {
            this.j = string;
            this.k = string2;
            this.l = string3;
            this.r = n;
            this.m = string4;
            this.n = string5;
            this.o = string6;
            this.s = n2;
            this.y = bl;
            this.p = string7;
            this.q = string8;
            this.r = string9;
            this.s = string10;
        }

        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{b.class, "webhook;title;description;color;playerName;threatName;distance;spawnersInInventory;allMined;serverIp;time;skinRenderUrl;disconnectReason", "j", "k", "l", "r", "m", "n", "o", "s", "y", "p", "q", "r", "s"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{b.class, "webhook;title;description;color;playerName;threatName;distance;spawnersInInventory;allMined;serverIp;time;skinRenderUrl;disconnectReason", "j", "k", "l", "r", "m", "n", "o", "s", "y", "p", "q", "r", "s"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{b.class, "webhook;title;description;color;playerName;threatName;distance;spawnersInInventory;allMined;serverIp;time;skinRenderUrl;disconnectReason", "j", "k", "l", "r", "m", "n", "o", "s", "y", "p", "q", "r", "s"}, this, object);
        }

        public String method_0() {
            return this.j;
        }

        public String method_1() {
            return this.k;
        }

        public String method_2() {
            return this.l;
        }

        public int method_3() {
            return this.r;
        }

        public String playerName() {
            return this.m;
        }

        public String method_4() {
            return this.n;
        }

        public String method_5() {
            return this.o;
        }

        public int method_6() {
            return this.s;
        }

        public boolean method_7() {
            return this.y;
        }

        public String method_8() {
            return this.p;
        }

        public String method_9() {
            return this.q;
        }

        public String method_10() {
            return this.r;
        }

        public String method_11() {
            return this.s;
        }
    }
}

