/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1743;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_239;
import net.minecraft.class_3966;

public final class ShieldBreaker
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Float> field_1;
    private boolean field_2;
    private long field_3;
    private boolean field_4;
    private boolean field_5;
    private int previousSlot;

    public ShieldBreaker() {
        super("Shield Breaker", Category.a);
        this.ba = new Setting<Boolean>("Switch Back", true);
        this.bb = new Setting<Float>("Switch Delay", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(500.0f));
        this.q = false;
        this.j = -1L;
        this.r = false;
        this.s = false;
        this.previousSlot = -1;
        this.addSetting(this.ba);
        this.addSetting(this.bb);
    }

    @Override
    public void onEnable() {
        this.u();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        if (this.r && ((Boolean)this.ba.getValue()).booleanValue() && this.s && ShieldBreaker.mc.field_1724 != null) {
            this.c(this.previousSlot);
        }
        this.u();
        super.onDisable();
    }

    private void method_0() {
        this.q = false;
        this.j = -1L;
        this.r = false;
        this.s = false;
        this.previousSlot = -1;
    }

    @Override
    public void onTick() {
        if (ShieldBreaker.mc.field_1724 == null || ShieldBreaker.mc.field_1687 == null) {
            return;
        }
        class_1657 class_16572 = this.a();
        if (class_16572 != null && class_16572.method_6039()) {
            int n;
            if (!this.q) {
                this.q = true;
                this.j = System.currentTimeMillis();
            }
            long l = ((Float)this.bb.getValue()).longValue();
            if (!this.r && this.j >= 0L && System.currentTimeMillis() - this.j >= l && (n = this.h()) != -1) {
                this.previousSlot = ShieldBreaker.mc.field_1724.method_31548().method_67532();
                if (this.previousSlot != n) {
                    this.c(n);
                    this.s = true;
                }
                ShieldBreaker.mc.field_1761.method_2918((class_1657)ShieldBreaker.mc.field_1724, (class_1297)class_16572);
                ShieldBreaker.mc.field_1724.method_6104(class_1268.field_5808);
                this.r = true;
            }
        } else {
            if (this.q) {
                this.q = false;
                this.j = -1L;
            }
            if (this.r) {
                if (((Boolean)this.ba.getValue()).booleanValue() && this.s && this.previousSlot != -1) {
                    this.c(this.previousSlot);
                }
                this.r = false;
                this.s = false;
                this.previousSlot = -1;
            }
        }
    }

    private class_1657 method_1() {
        class_1297 class_12972;
        if (ShieldBreaker.mc.field_1765 != null && ShieldBreaker.mc.field_1765.method_17783() == class_239.class_240.field_1331 && (class_12972 = ((class_3966)ShieldBreaker.mc.field_1765).method_17782()) instanceof class_1657 && (class_12972 = (class_1657)class_12972) != ShieldBreaker.mc.field_1724) {
            return class_12972;
        }
        return null;
    }

    private int method_2() {
        int n = -1;
        int n2 = -1;
        for (int i = 0; i < 9; ++i) {
            int n3;
            class_1799 class_17992 = ShieldBreaker.mc.field_1724.method_31548().method_5438(i);
            if (!(class_17992.method_7909() instanceof class_1743) || (n3 = this.a(class_17992)) <= n) continue;
            n = n3;
            n2 = i;
        }
        return n2;
    }

    private int method_3(class_1799 class_17992) {
        if (class_17992.method_31574(class_1802.field_22025)) {
            return 6;
        }
        if (class_17992.method_31574(class_1802.field_8556)) {
            return 5;
        }
        if (class_17992.method_31574(class_1802.field_8475)) {
            return 4;
        }
        if (class_17992.method_31574(class_1802.field_8825)) {
            return 3;
        }
        if (class_17992.method_31574(class_1802.field_8062)) {
            return 2;
        }
        if (class_17992.method_31574(class_1802.field_8406)) {
            return 1;
        }
        return 0;
    }

    private void method_4(int n) {
        if (ShieldBreaker.mc.field_1724 == null) {
            return;
        }
        if (n < 0 || n > 8) {
            return;
        }
        ShieldBreaker.mc.field_1724.method_31548().method_61496(n);
    }
}

