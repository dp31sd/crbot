/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_243;
import net.minecraft.class_4184;
import net.minecraft.class_4587;

public final class JumpCircles
extends Module {
    private final Setting<Float> field_0;
    private final Setting<Float> field_1;
    private final Setting<Float> field_2;
    private final Setting<Float> field_3;
    private final Setting<Color> field_4;
    private final Setting<Boolean> field_5;
    private final Setting<Boolean> field_6;
    private final List<a> field_7;
    private boolean field_8;
    private double field_9;
    private double field_10;
    private double field_11;

    public JumpCircles() {
        super("JumpCircles", Category.b);
        this.bN = new Setting<Float>("Lifetime (s)", Float.valueOf(1.5f), Float.valueOf(0.1f), Float.valueOf(5.0f));
        this.bO = new Setting<Float>("Start Radius", Float.valueOf(0.55f), Float.valueOf(0.1f), Float.valueOf(3.0f));
        this.bP = new Setting<Float>("End Radius", Float.valueOf(1.8f), Float.valueOf(0.2f), Float.valueOf(6.0f));
        this.bQ = new Setting<Float>("Line Width", Float.valueOf(2.0f), Float.valueOf(0.5f), Float.valueOf(6.0f));
        this.bR = new Setting<Color>("Color", new Color(120, 220, 255, 255));
        this.bS = new Setting<Boolean>("Glow Mode", false);
        this.bT = new Setting<Boolean>("Glow Filled", false);
        this.f = new ArrayList();
        this.am = true;
        this.j = 0.0;
        this.k = 0.0;
        this.l = 0.0;
        this.addSetting(this.bN);
        this.addSetting(this.bO);
        this.addSetting(this.bP);
        this.addSetting(this.bQ);
        this.addSetting(this.bR);
        this.addSetting(this.bS);
        this.addSetting(this.bT);
    }

    @Override
    public void onEnable() {
        this.f.clear();
        this.am = true;
    }

    @Override
    public void onDisable() {
        this.f.clear();
    }

    @Override
    public void onTick() {
        if (JumpCircles.mc.field_1724 == null) {
            return;
        }
        boolean bl = JumpCircles.mc.field_1724.method_24828();
        if (bl) {
            this.j = JumpCircles.mc.field_1724.method_23317();
            this.k = JumpCircles.mc.field_1724.method_23318();
            this.l = JumpCircles.mc.field_1724.method_23321();
        }
        if (this.am && !bl && JumpCircles.mc.field_1724.method_18798().field_1351 > 0.0) {
            this.f.add(new a(this.j, this.k + 0.02, this.l, System.currentTimeMillis()));
        }
        this.am = bl;
        long l = System.currentTimeMillis();
        long l2 = (long)(((Float)this.bN.getValue()).floatValue() * 1000.0f);
        Iterator iterator = this.f.iterator();
        while (iterator.hasNext()) {
            if (l - ((a)iterator.next()).z < l2) continue;
            iterator.remove();
        }
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        if (JumpCircles.mc.field_1687 == null || JumpCircles.mc.field_1724 == null || this.f.isEmpty()) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        long l = System.currentTimeMillis();
        long l2 = (long)(((Float)this.bN.getValue()).floatValue() * 1000.0f);
        double d2 = ((Float)this.bO.getValue()).floatValue();
        double d3 = ((Float)this.bP.getValue()).floatValue();
        float f2 = ((Float)this.bQ.getValue()).floatValue();
        Color color = (Color)this.bR.getValue();
        int n = color.getAlpha();
        class_45872.method_22903();
        RenderUtils.WorldBatch worldBatch = RenderUtils.beginWorldBatch(class_45872);
        for (class_243[] class_243Array : this.f) {
            Color color2;
            int n2;
            int n3;
            float f3 = (float)(l - class_243Array.z) / (float)l2;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            if (f3 > 1.0f) {
                f3 = 1.0f;
            }
            f3 = 1.0f - (1.0f - f3) * (1.0f - f3) * (1.0f - f3);
            double d4 = d2 + (d3 - d2) * (double)f3;
            int n4 = (int)((float)n * (1.0f - f3));
            if (n4 <= 0) continue;
            Color color3 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n4);
            double d5 = class_243Array.m - class_41842.field_1352;
            double d6 = class_243Array.n - class_41842.field_1351;
            double d7 = class_243Array.o - class_41842.field_1350;
            class_243Array = new class_243[129];
            for (n3 = 0; n3 <= 128; ++n3) {
                double d8 = Math.PI * 2 * ((double)n3 / 128.0);
                class_243Array[n3] = new class_243(d5 + Math.cos(d8) * d4, d6, d7 + Math.sin(d8) * d4);
            }
            if (((Boolean)this.bT.getValue()).booleanValue()) {
                n3 = color.getRed();
                int n5 = color.getGreen();
                n2 = color.getBlue();
                float f4 = f2 * 8.0f;
                for (int i = 1; i <= 32; ++i) {
                    double d9 = (double)i / 32.0;
                    double d10 = d4 * (1.0 - d9);
                    if (d10 < 0.05) continue;
                    int n6 = Math.max(1, (int)((double)n4 * (1.0 - d9 * 0.6) * 0.55));
                    color2 = new Color(n3, n5, n2, n6);
                    class_243[] class_243Array2 = new class_243[129];
                    for (int j = 0; j <= 128; ++j) {
                        double d11 = Math.PI * 2 * ((double)j / 128.0);
                        class_243Array2[j] = new class_243(d5 + Math.cos(d11) * d10, d6, d7 + Math.sin(d11) * d10);
                    }
                    JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array2, (Color)color2, (float)f4);
                }
            }
            if (((Boolean)this.bS.getValue()).booleanValue()) {
                n3 = color.getRed();
                int n7 = color.getGreen();
                n2 = color.getBlue();
                color3 = new Color(n3, n7, n2, Math.max(1, n4 / 16));
                Color color4 = new Color(n3, n7, n2, Math.max(1, n4 / 12));
                Color color5 = new Color(n3, n7, n2, Math.max(1, n4 / 9));
                Color color6 = new Color(n3, n7, n2, Math.max(1, n4 / 6));
                Color color7 = new Color(n3, n7, n2, Math.max(1, n4 / 4));
                Color color8 = new Color(n3, n7, n2, Math.max(1, n4 / 2));
                Color color9 = new Color(n3, n7, n2, Math.min(255, (int)((float)n4 * 1.0f)));
                color2 = new Color(255, 255, 255, Math.min(255, (int)((float)n4 * 1.4f)));
                JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color3, (float)(f2 * 18.0f));
                JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color4, (float)(f2 * 14.0f));
                JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color5, (float)(f2 * 11.0f));
                JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color6, (float)(f2 * 8.5f));
                JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color7, (float)(f2 * 6.0f));
                JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color8, (float)(f2 * 4.0f));
                JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color9, (float)(f2 * 2.8f));
                JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color2, (float)(f2 * 1.6f));
                continue;
            }
            JumpCircles.a((RenderUtils.WorldBatch)worldBatch, (class_243[])class_243Array, (Color)color3, (float)f2);
        }
        worldBatch.flush();
        class_45872.method_22909();
    }

    private static void method_0(RenderUtils.WorldBatch worldBatch, class_243[] class_243Array, Color color, float f) {
        for (int i = 1; i < class_243Array.length; ++i) {
            worldBatch.renderLine(color, class_243Array[i - 1], class_243Array[i], f);
        }
    }

    private static final class a {
        final double field_0;
        final double field_1;
        final double field_2;
        final long field_3;

        a(double d2, double d3, double d4, long l) {
            this.m = d2;
            this.n = d3;
            this.o = d4;
            this.z = l;
        }
    }
}

