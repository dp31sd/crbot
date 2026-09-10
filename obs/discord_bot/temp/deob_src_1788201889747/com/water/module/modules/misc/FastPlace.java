/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.mixin.MinecraftClientAccessor;
import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1811;
import net.minecraft.class_9334;

public final class FastPlace
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Float> field_3;

    public FastPlace() {
        super("Fast Place", Category.c);
        this.aG = new Setting<Boolean>("Only XP", false);
        this.aH = new Setting<Boolean>("Blocks", true);
        this.aI = new Setting<Boolean>("Items", true);
        this.aJ = new Setting<Float>("Delay", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(10.0f));
        this.addSetting(this.aG);
        this.addSetting(this.aH);
        this.addSetting(this.aI);
        this.addSetting(this.aJ);
    }

    @Override
    public void onTick() {
        class_1799 class_17992;
        if (FastPlace.mc.field_1724 == null || FastPlace.mc.field_1755 != null) {
            return;
        }
        if (!FastPlace.mc.field_1690.field_1904.method_1434()) {
            return;
        }
        Object object = FastPlace.mc.field_1724.method_6047();
        if (!this.a((class_1799)object, class_17992 = FastPlace.mc.field_1724.method_6079())) {
            return;
        }
        object = (MinecraftClientAccessor)mc;
        int n = Math.max(0, ((Float)this.aJ.getValue()).intValue());
        if (object.water$getItemUseCooldown() != n) {
            object.water$setItemUseCooldown(n);
        }
    }

    private boolean method_0(class_1799 class_17992, class_1799 class_17993) {
        boolean bl;
        boolean bl2 = class_17992.method_31574(class_1802.field_8287);
        boolean bl3 = class_17993.method_31574(class_1802.field_8287);
        if (((Boolean)this.aG.getValue()).booleanValue()) {
            return bl2 || bl3;
        }
        class_1792 class_17922 = class_17992.method_7909();
        class_1792 class_17923 = class_17993.method_7909();
        if (this.e(class_17992) || this.e(class_17993)) {
            return false;
        }
        if (class_17992.method_31574(class_1802.field_23141) || class_17992.method_31574(class_1802.field_8801) || class_17993.method_31574(class_1802.field_23141) || class_17993.method_31574(class_1802.field_8801)) {
            return false;
        }
        if (class_17922 instanceof class_1811 || class_17923 instanceof class_1811) {
            return false;
        }
        boolean bl4 = bl = class_17922 instanceof class_1747 || class_17923 instanceof class_1747;
        if (bl) {
            return (Boolean)this.aH.getValue();
        }
        return (Boolean)this.aI.getValue();
    }

    private boolean method_1(class_1799 class_17992) {
        return class_17992.method_57353().method_57832(class_9334.field_50075);
    }
}

