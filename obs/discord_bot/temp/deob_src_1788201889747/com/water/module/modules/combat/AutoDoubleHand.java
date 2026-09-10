/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import net.minecraft.class_1661;
import net.minecraft.class_1802;

public final class AutoDoubleHand
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Float> field_2;
    private final Setting<Float> field_3;
    private boolean field_4;
    private int field_5;
    private int previousSlot;

    public AutoDoubleHand() {
        super("AutoDoubleHand", Category.a);
        this.am = new Setting<Boolean>("On Totem Pop", true);
        this.an = new Setting<Boolean>("On Health", true);
        this.ao = new Setting<Float>("Health Threshold", Float.valueOf(6.0f), Float.valueOf(1.0f), Float.valueOf(20.0f));
        this.ap = new Setting<Float>("Cooldown", Float.valueOf(5.0f), Float.valueOf(0.0f), Float.valueOf(40.0f));
        this.n = false;
        this.i = 0;
        this.previousSlot = -1;
        this.addSetting(this.am);
        this.addSetting(this.an);
        this.addSetting(this.ao);
        this.addSetting(this.ap);
    }

    @Override
    public void onEnable() {
        this.n = false;
        this.i = 0;
        this.previousSlot = -1;
    }

    @Override
    public void onDisable() {
        this.n = false;
        this.i = 0;
        this.previousSlot = -1;
    }

    @Override
    public void onTick() {
        if (AutoDoubleHand.mc.field_1724 == null || AutoDoubleHand.mc.field_1761 == null) {
            return;
        }
        if (this.i > 0) {
            --this.i;
        }
        class_1661 class_16612 = AutoDoubleHand.mc.field_1724.method_31548();
        int n = AutoDoubleHand.mc.field_1724.method_6047().method_7909() == class_1802.field_8288 ? 1 : 0;
        boolean bl = AutoDoubleHand.mc.field_1724.method_6079().method_7909() == class_1802.field_8288;
        bl = n != 0 || bl;
        boolean bl2 = this.n && !bl;
        this.n = bl;
        if (this.i > 0) {
            return;
        }
        bl = false;
        if (((Boolean)this.am.getValue()).booleanValue() && bl2) {
            bl = true;
        }
        if (((Boolean)this.an.getValue()).booleanValue() && AutoDoubleHand.mc.field_1724.method_6032() <= ((Float)this.ao.getValue()).floatValue()) {
            bl = true;
        }
        if (!bl) {
            return;
        }
        if (n != 0) {
            return;
        }
        n = this.e();
        if (n < 0) {
            return;
        }
        if (class_16612.method_67532() == n) {
            return;
        }
        this.previousSlot = class_16612.method_67532();
        class_16612.method_61496(n);
        this.i = ((Float)this.ap.getValue()).intValue();
    }

    private int method_0() {
        class_1661 class_16612 = AutoDoubleHand.mc.field_1724.method_31548();
        for (int i = 0; i < 9; ++i) {
            if (!class_16612.method_5438(i).method_31574(class_1802.field_8288)) continue;
            return i;
        }
        return -1;
    }
}

