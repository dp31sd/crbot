/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.ModeSetting;
import com.water.setting.Setting;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_2596;
import net.minecraft.class_2743;

public final class AutoTPA
extends Module {
    private final Setting<String> field_0;
    private final ModeSetting field_1;
    private final Setting<Float> field_2;
    private final Setting<Float> field_3;
    private int field_4;
    private int field_5;
    private boolean field_6;
    private int field_7;
    private int field_8;

    public AutoTPA() {
        super("AutoTPA", Category.c);
        this.N = new Setting<String>("Player", "Player");
        this.b = new ModeSetting("Mode", "tpahere", "tpa", "tpahere");
        this.O = new Setting<Float>("Min Delay", Float.valueOf(10.0f), Float.valueOf(1.0f), Float.valueOf(100.0f));
        this.P = new Setting<Float>("Max Delay", Float.valueOf(30.0f), Float.valueOf(1.0f), Float.valueOf(100.0f));
        this.l = 0;
        this.ag = 0;
        this.ab = false;
        this.ah = -1;
        this.ai = -1;
        this.addSetting(this.N);
        this.addSetting(this.b);
        this.addSetting(this.O);
        this.addSetting(this.P);
    }

    @Override
    public void onEnable() {
        this.l = 0;
        this.ag = 0;
        this.ab = false;
        this.ah = AutoTPA.mc.field_1724 != null ? AutoTPA.mc.field_1724.method_6117() : -1;
        this.ai = AutoTPA.mc.field_1724 != null ? AutoTPA.mc.field_1724.method_6083() : -1;
    }

    @Override
    public void onDisable() {
        this.l = 0;
        this.ag = 0;
        this.ab = false;
        this.ah = -1;
        this.ai = -1;
    }

    @Override
    public void onPacketReceive(class_2596<?> class_27432) {
        if (AutoTPA.mc.field_1724 == null) {
            return;
        }
        if (class_27432 instanceof class_2743 && (class_27432 = (class_2743)class_27432).method_11818() == AutoTPA.mc.field_1724.method_5628()) {
            this.al();
        }
    }

    @Override
    public void onTick() {
        if (AutoTPA.mc.field_1724 == null || mc.method_1562() == null) {
            return;
        }
        int n = AutoTPA.mc.field_1724.method_6117();
        if (n > 0 && n != this.ah) {
            this.ah = n;
            class_1309 class_13092 = AutoTPA.mc.field_1724.method_49107();
            if (class_13092 instanceof class_1657 && (class_13092 = (class_1657)class_13092) != AutoTPA.mc.field_1724 && !class_13092.method_7325()) {
                this.al();
            }
        }
        if ((n = AutoTPA.mc.field_1724.method_6083()) > 0 && n != this.ai) {
            this.ai = n;
            this.al();
        }
        if (this.ab) {
            if (this.ag > 0) {
                --this.ag;
                return;
            }
            this.ab = false;
            this.l = 0;
        }
        if (this.l > 0) {
            --this.l;
            return;
        }
        mc.method_1562().method_45730((String)this.b.getValue() + " " + ((String)this.N.getValue()).trim());
        n = ((Float)this.O.getValue()).intValue();
        int n2 = Math.max(n, ((Float)this.P.getValue()).intValue());
        this.l = n + (int)(Math.random() * (double)(n2 - n + 1));
    }

    private void method_0() {
        this.ab = true;
        this.ag = 400;
        this.l = 0;
    }
}

