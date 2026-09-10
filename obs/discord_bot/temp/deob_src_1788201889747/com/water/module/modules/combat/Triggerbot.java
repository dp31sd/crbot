/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.Friends;
import com.water.setting.Setting;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_239;
import net.minecraft.class_3966;

public final class Triggerbot
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Boolean> field_1;
    private int field_2;

    public Triggerbot() {
        super("Triggerbot", Category.a);
        this.bf = new Setting<Boolean>("Only Crit", false);
        this.bg = new Setting<Boolean>("Check Shield", false);
        this.l = 0;
        this.addSetting(this.bf);
        this.addSetting(this.bg);
    }

    @Override
    public void onEnable() {
        this.l = 0;
    }

    @Override
    public void onDisable() {
        this.l = 0;
    }

    @Override
    public void onTick() {
        if (Triggerbot.mc.field_1724 == null || Triggerbot.mc.field_1687 == null) {
            return;
        }
        if (Triggerbot.mc.field_1755 != null) {
            return;
        }
        if (this.l > 0) {
            --this.l;
            return;
        }
        if (Triggerbot.mc.field_1765 == null || Triggerbot.mc.field_1765.method_17783() != class_239.class_240.field_1331) {
            return;
        }
        class_239 class_2392 = Triggerbot.mc.field_1765;
        if (!(class_2392 instanceof class_3966)) {
            return;
        }
        class_2392 = (class_3966)class_2392;
        class_2392 = class_2392.method_17782();
        if (!(class_2392 instanceof class_1309)) {
            return;
        }
        if (class_2392 == Triggerbot.mc.field_1724) {
            return;
        }
        if (class_2392 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_2392;
            if (Friends.a() && Friends.a((String)class_16572.method_5477().getString())) {
                return;
            }
        }
        if (Triggerbot.mc.field_1690.field_1886.method_1434()) {
            return;
        }
        if (!this.a((class_1309)class_2392)) {
            return;
        }
        this.a((class_1297)class_2392);
        this.l = 9;
    }

    private boolean method_0(class_1309 class_13092) {
        if (((Boolean)this.bf.getValue()).booleanValue() && !this.a((class_1657)Triggerbot.mc.field_1724)) {
            return false;
        }
        return (Boolean)this.bg.getValue() == false || !this.b(class_13092);
    }

    private boolean method_1(class_1309 class_13092) {
        class_1799 class_17992 = class_13092.method_6047();
        class_13092 = class_13092.method_6079();
        return class_17992.method_7909() == class_1802.field_8255 || class_13092.method_7909() == class_1802.field_8255;
    }

    private boolean method_2(class_1657 class_16572) {
        if (class_16572.field_6017 <= (double)0.05f) {
            return false;
        }
        if (class_16572.method_24828()) {
            return false;
        }
        if (class_16572.method_5799() || class_16572.method_5771() || class_16572.method_6101() || class_16572.method_5765()) {
            return false;
        }
        return !class_16572.method_5624();
    }

    private void method_3(class_1297 class_12972) {
        Triggerbot.mc.field_1761.method_2918((class_1657)Triggerbot.mc.field_1724, class_12972);
        Triggerbot.mc.field_1724.method_6104(class_1268.field_5808);
    }
}

