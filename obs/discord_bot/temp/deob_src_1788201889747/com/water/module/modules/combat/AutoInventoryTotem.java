/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.util.Random;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1802;
import net.minecraft.class_437;
import net.minecraft.class_490;

public final class AutoInventoryTotem
extends Module {
    private final Setting<Float> field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Float> field_2;
    private final Setting<Boolean> field_3;
    private final Setting<Boolean> field_4;
    private final Setting<Float> field_5;
    private int field_6;
    private int field_7;
    private boolean field_8;
    private final Random field_9;

    public AutoInventoryTotem() {
        super("Auto Inv Totem", Category.a);
        this.aq = new Setting<Float>("Delay", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(20.0f));
        this.ar = new Setting<Boolean>("Hotbar", false);
        this.as = new Setting<Float>("Totem Slot", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(9.0f));
        this.at = new Setting<Boolean>("Force Totem", false);
        this.au = new Setting<Boolean>("Auto Open", false);
        this.av = new Setting<Float>("Close Delay", Float.valueOf(3.0f), Float.valueOf(0.0f), Float.valueOf(20.0f));
        this.j = 0;
        this.k = 0;
        this.o = true;
        this.b = new Random();
        this.addSetting(this.aq);
        this.addSetting(this.ar);
        this.addSetting(this.as);
        this.addSetting(this.at);
        this.addSetting(this.au);
        this.addSetting(this.av);
    }

    @Override
    public void onEnable() {
        this.j = 0;
        this.k = 0;
        this.o = true;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.j = 0;
        this.k = 0;
        super.onDisable();
    }

    @Override
    public void onTick() {
        boolean bl;
        if (AutoInventoryTotem.mc.field_1724 == null || AutoInventoryTotem.mc.field_1761 == null) {
            return;
        }
        class_1661 class_16612 = AutoInventoryTotem.mc.field_1724.method_31548();
        boolean bl2 = bl = AutoInventoryTotem.mc.field_1724.method_6079().method_7909() == class_1802.field_8288;
        if (((Boolean)this.au.getValue()).booleanValue()) {
            this.a(class_16612, bl);
            this.o = bl;
            return;
        }
        this.o = bl;
        if (!(AutoInventoryTotem.mc.field_1755 instanceof class_490)) {
            this.k = 0;
            return;
        }
        if (this.k < ((Float)this.aq.getValue()).intValue() + this.f()) {
            ++this.k;
            return;
        }
        if (!bl && this.a(class_16612)) {
            this.k = 0;
            return;
        }
        if (((Boolean)this.ar.getValue()).booleanValue()) {
            this.b(class_16612);
        }
        this.k = 0;
    }

    private void method_0(class_1661 class_16612, boolean bl) {
        switch (this.j) {
            case 0: {
                if (this.o && !bl && this.a(class_16612) != -1) {
                    this.j = 1;
                    int n = this.k = ((Float)this.aq.getValue()).intValue() <= 0 ? 1 + this.b.nextInt(2) : 1 + this.b.nextInt(3);
                }
                if (bl || this.j != 0 || AutoInventoryTotem.mc.field_1755 instanceof class_490 || this.a(class_16612) == -1) break;
                this.j = 1;
                this.k = ((Float)this.aq.getValue()).intValue() <= 0 ? 1 + this.b.nextInt(2) : 1 + this.b.nextInt(3);
                break;
            }
            case 1: {
                if (this.k > 0) {
                    --this.k;
                    return;
                }
                if (!(AutoInventoryTotem.mc.field_1755 instanceof class_490)) {
                    mc.method_1507((class_437)new class_490((class_1657)AutoInventoryTotem.mc.field_1724));
                }
                this.j = 2;
                this.k = ((Float)this.aq.getValue()).intValue() + this.f();
                break;
            }
            case 2: {
                if (!(AutoInventoryTotem.mc.field_1755 instanceof class_490)) {
                    this.j = 0;
                    return;
                }
                if (this.k > 0) {
                    --this.k;
                    return;
                }
                boolean bl2 = false;
                if (!bl) {
                    bl2 = this.a(class_16612);
                }
                boolean bl3 = false;
                if (((Boolean)this.ar.getValue()).booleanValue()) {
                    bl3 = this.b(class_16612);
                }
                if (bl2 || bl3 || bl) {
                    this.j = 3;
                    this.k = ((Float)this.av.getValue()).intValue() + this.f();
                    break;
                }
                this.j = 3;
                this.k = 1;
                break;
            }
            case 3: {
                if (this.k > 0) {
                    --this.k;
                    return;
                }
                if (AutoInventoryTotem.mc.field_1755 instanceof class_490) {
                    AutoInventoryTotem.mc.field_1724.method_7346();
                    mc.method_1507(null);
                }
                this.j = 0;
            }
        }
    }

    private boolean method_1(class_1661 class_16612) {
        int n = this.a(class_16612);
        if (n == -1) {
            return false;
        }
        n = AutoInventoryTotem.e((int)n);
        AutoInventoryTotem.mc.field_1761.method_2906(AutoInventoryTotem.mc.field_1724.field_7512.field_7763, n, 40, class_1713.field_7791, (class_1657)AutoInventoryTotem.mc.field_1724);
        return true;
    }

    private boolean method_2(class_1661 class_16612) {
        int n = ((Float)this.as.getValue()).intValue() - 1;
        if (class_16612.method_5438(n).method_7909() == class_1802.field_8288) {
            return false;
        }
        if (!class_16612.method_5438(n).method_7960() && !((Boolean)this.at.getValue()).booleanValue()) {
            return false;
        }
        int n2 = this.b(class_16612);
        if (n2 == -1) {
            return false;
        }
        n2 = AutoInventoryTotem.e((int)n2);
        AutoInventoryTotem.mc.field_1761.method_2906(AutoInventoryTotem.mc.field_1724.field_7512.field_7763, n2, n, class_1713.field_7791, (class_1657)AutoInventoryTotem.mc.field_1724);
        return true;
    }

    private int method_3(class_1661 class_16612) {
        int n;
        for (n = 9; n < 36; ++n) {
            if (class_16612.method_5438(n).method_7909() != class_1802.field_8288) continue;
            return n;
        }
        for (n = 0; n < 9; ++n) {
            if (class_16612.method_5438(n).method_7909() != class_1802.field_8288) continue;
            return n;
        }
        return -1;
    }

    private int method_4(class_1661 class_16612) {
        for (int i = 9; i < 36; ++i) {
            if (class_16612.method_5438(i).method_7909() != class_1802.field_8288) continue;
            return i;
        }
        return -1;
    }

    private static int method_5(int n) {
        if (n < 9) {
            return 36 + n;
        }
        return n;
    }

    private int method_6() {
        if (((Float)this.aq.getValue()).intValue() <= 0) {
            return 0;
        }
        return this.b.nextInt(2);
    }
}

