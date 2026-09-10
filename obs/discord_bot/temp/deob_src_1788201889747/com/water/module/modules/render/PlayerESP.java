/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.mojang.authlib.GameProfile;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.Friends;
import com.water.module.modules.render.Freecam;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.class_1657;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;

public final class PlayerESP
extends Module {
    private final Setting<Double> field_0;
    private final Setting<Double> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Double> field_3;
    private final Setting<Color> field_4;
    private final Setting<Color> field_5;
    private RenderUtils.PersistentBatch field_6;
    private RenderUtils.PersistentBatch field_7;

    public PlayerESP() {
        super("Player ESP", Category.b);
        this.ca = new Setting<Double>("Fill Alpha", 180.0, 0.0, 255.0);
        this.cb = new Setting<Double>("Range", 256.0, 16.0, 512.0);
        this.cc = new Setting<Boolean>("Tracers", false);
        this.cd = new Setting<Double>("Tracer Width", 0.5, 0.1, 2.0);
        this.ce = new Setting<Color>("Fill color", new Color(255, 0, 0));
        this.cf = new Setting<Color>("Tracer color", new Color(255, 0, 0));
        this.addSetting(this.ca);
        this.addSetting(this.cb);
        this.addSetting(this.cc);
        this.addSetting(this.cd);
        this.addSetting(this.ce);
        this.addSetting(this.cf);
    }

    @Override
    public void onEnable() {
        this.a = RenderUtils.createPersistentBatch();
        this.b = RenderUtils.createPersistentBatch();
    }

    @Override
    public void onDisable() {
        if (this.a != null) {
            this.a.close();
            this.a = null;
        }
        if (this.b != null) {
            this.b.close();
            this.b = null;
        }
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        Object object;
        Object object22;
        if (PlayerESP.mc.field_1687 == null || PlayerESP.mc.field_1724 == null) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        if (this.a == null) {
            this.a = RenderUtils.createPersistentBatch();
        }
        if (this.b == null) {
            this.b = RenderUtils.createPersistentBatch();
        }
        Object object3 = RenderUtils.getCameraPos(class_41842);
        class_41842 = RenderUtils.getCameraForward(class_41842);
        double d2 = ((class_243)object3).field_1352;
        double d3 = ((class_243)object3).field_1351;
        double d4 = ((class_243)object3).field_1350;
        double d5 = (Double)this.cb.getValue() * (Double)this.cb.getValue();
        int n = this.a((Double)this.ca.getValue());
        boolean bl = (Boolean)this.cc.getValue();
        Object object4 = Freecam.resolveTracerOrigin((class_243)object3, f);
        class_41842 = object4.equals(object3) ? class_41842.method_1021(0.1) : object4.method_1020((class_243)object3);
        object3 = new ArrayList();
        for (Object object22 : PlayerESP.mc.field_1687.method_18456()) {
            if (object22 == PlayerESP.mc.field_1724 || !object22.method_5805() || object22.method_7325()) continue;
            boolean bl2 = Friends.b() && Friends.a((String)this.a((class_1657)object22));
            object = this.a((class_1657)object22, f);
            double d6 = object.field_1352 - d2;
            double d7 = object.field_1351 - d3;
            double d8 = object.field_1350 - d4;
            if (d6 * d6 + d7 * d7 + d8 * d8 > d5) continue;
            object = bl2 ? Friends.a() : (Color)this.ce.getValue();
            Color color = bl2 ? Friends.a() : (Color)this.cf.getValue();
            object3.add(new a(d6, d7, d8, d7 + (double)object22.method_17682() * 0.5, (double)object22.method_17681() / 2.0, object22.method_17682(), this.b((Color)object, n), this.b(color, 255)));
        }
        if (object3.isEmpty()) {
            return;
        }
        this.a.begin(class_45872);
        object4 = object3.iterator();
        while (object4.hasNext()) {
            object22 = (a)object4.next();
            this.a.addFilledBox(((a)object22).p - ((a)object22).t, ((a)object22).q, ((a)object22).r - ((a)object22).t, ((a)object22).p + ((a)object22).t, ((a)object22).q + ((a)object22).u, ((a)object22).r + ((a)object22).t, ((a)object22).e);
        }
        this.a.flush();
        if (bl) {
            float f2 = ((Double)this.cd.getValue()).floatValue();
            this.b.begin(class_45872);
            object22 = object3.iterator();
            while (object22.hasNext()) {
                a a2 = (a)object22.next();
                object = new class_243(a2.p, a2.s, a2.r);
                Color color = a2.f;
                this.b.addLine((class_243)class_41842, (class_243)object, PlayerESP.a((Color)color, (int)25), f2 + 0.8f);
                this.b.addLine((class_243)class_41842, (class_243)object, PlayerESP.a((Color)color, (int)200), f2);
                this.b.addLine((class_243)class_41842, (class_243)object, PlayerESP.a((Color)PlayerESP.a((Color)color, (float)0.6f), (int)150), Math.max(f2 - 0.2f, 0.2f));
            }
            this.b.flush();
        }
    }

    private static Color method_0(Color color, int n) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.max(0, Math.min(255, n)));
    }

    private static Color method_1(Color color, float f) {
        int n = (int)((float)color.getRed() + (float)(255 - color.getRed()) * f);
        int n2 = (int)((float)color.getGreen() + (float)(255 - color.getGreen()) * f);
        int n3 = (int)((float)color.getBlue() + (float)(255 - color.getBlue()) * f);
        return new Color(n, n2, n3);
    }

    private int method_2(double d2) {
        return Math.max(0, Math.min(255, (int)Math.round(d2)));
    }

    private Color method_3(Color color, int n) {
        n = Math.max(0, Math.min(255, Math.round((float)color.getAlpha() / 255.0f * (float)n)));
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), n);
    }

    private class_243 method_4(class_1657 class_16572, float f) {
        try {
            return class_16572.method_30950(f);
        }
        catch (Throwable throwable) {
            return new class_243(class_3532.method_16436((double)f, (double)class_16572.field_6038, (double)class_16572.method_23317()), class_3532.method_16436((double)f, (double)class_16572.field_5971, (double)class_16572.method_23318()), class_3532.method_16436((double)f, (double)class_16572.field_5989, (double)class_16572.method_23321()));
        }
    }

    private String method_5(class_1657 class_16572) {
        block9: {
            if (class_16572 == null) {
                return "";
            }
            try {
                Object object;
                GameProfile gameProfile = class_16572.method_7334();
                if (gameProfile == null) break block9;
                try {
                    object = gameProfile.getClass().getMethod("getName", new Class[0]).invoke((Object)gameProfile, new Object[0]);
                    if (object instanceof String && !((String)(object = (String)object)).isBlank()) {
                        return object;
                    }
                }
                catch (Throwable throwable) {}
                try {
                    object = gameProfile.getClass().getMethod("name", new Class[0]).invoke((Object)gameProfile, new Object[0]);
                    if (object instanceof String && !((String)(object = (String)object)).isBlank()) {
                        return object;
                    }
                }
                catch (Throwable throwable) {}
            }
            catch (Throwable throwable) {}
        }
        return class_16572.method_5477().getString();
    }

    private static final class a {
        final double field_0;
        final double field_1;
        final double field_2;
        final double field_3;
        final double field_4;
        final double field_5;
        final Color field_6;
        final Color field_7;

        a(double d2, double d3, double d4, double d5, double d6, double d7, Color color, Color color2) {
            this.p = d2;
            this.q = d3;
            this.r = d4;
            this.s = d5;
            this.t = d6;
            this.u = d7;
            this.e = color;
            this.f = color2;
        }
    }
}

