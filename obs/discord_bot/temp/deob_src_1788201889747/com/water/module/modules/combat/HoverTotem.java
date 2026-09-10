/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.mixin.HandledScreenAccessor;
import com.water.module.Category;
import com.water.module.Module;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1802;
import net.minecraft.class_437;
import net.minecraft.class_465;

public final class HoverTotem
extends Module {
    private int field_0;

    public HoverTotem() {
        super("Hover Totem", Category.a);
        this.n = -1;
    }

    @Override
    public void onDisable() {
        this.n = -1;
        super.onDisable();
    }

    @Override
    public void onTick() {
        if (HoverTotem.mc.field_1724 == null || HoverTotem.mc.field_1761 == null) {
            return;
        }
        class_437 class_4372 = HoverTotem.mc.field_1755;
        if (!(class_4372 instanceof class_465)) {
            this.n = -1;
            return;
        }
        class_4372 = (class_465)class_4372;
        class_4372 = ((HandledScreenAccessor)class_4372).water$getFocusedSlot();
        if (class_4372 == null || class_4372.method_7677().method_7960()) {
            this.n = -1;
            return;
        }
        if (!class_4372.method_7677().method_31574(class_1802.field_8288)) {
            this.n = -1;
            return;
        }
        if (HoverTotem.mc.field_1724.method_6079().method_31574(class_1802.field_8288)) {
            return;
        }
        if (class_4372.field_7874 == this.n) {
            return;
        }
        int n = HoverTotem.mc.field_1724.field_7512.field_7763;
        HoverTotem.mc.field_1761.method_2906(n, class_4372.field_7874, 40, class_1713.field_7791, (class_1657)HoverTotem.mc.field_1724);
        this.n = class_4372.field_7874;
    }
}

