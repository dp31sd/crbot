/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1802;

public final class AutoTotem
extends Module {
    private final Setting<Float> field_0;
    private int field_1;

    public AutoTotem() {
        super("Auto Totem", Category.a);
        this.aw = new Setting<Float>("Delay", Float.valueOf(1.0f), Float.valueOf(0.0f), Float.valueOf(5.0f));
        this.addSetting(this.aw);
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onTick() {
        if (AutoTotem.mc.field_1724 == null) {
            return;
        }
        int n = this.g();
        if (AutoTotem.mc.field_1724.method_6079().method_7909() == class_1802.field_8288) {
            this.l = n;
            return;
        }
        if (this.l > 0) {
            --this.l;
            return;
        }
        int n2 = this.a(class_1802.field_8288);
        if (n2 == -1) {
            return;
        }
        AutoTotem.mc.field_1761.method_2906(AutoTotem.mc.field_1724.field_7512.field_7763, AutoTotem.f((int)n2), 40, class_1713.field_7791, (class_1657)AutoTotem.mc.field_1724);
        this.l = n;
    }

    private int method_0() {
        double d2 = ((Float)this.aw.getValue()).floatValue();
        return (int)Math.round(d2 * 20.0);
    }

    public int method_1(class_1792 class_17922) {
        if (AutoTotem.mc.field_1724 == null) {
            return -1;
        }
        for (int i = 0; i < 36; ++i) {
            if (!AutoTotem.mc.field_1724.method_31548().method_5438(i).method_31574(class_17922)) continue;
            return i;
        }
        return -1;
    }

    private static int method_2(int n) {
        if (n < 9) {
            return 36 + n;
        }
        return n;
    }
}

