/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.ActivatableModule;
import com.water.module.Category;
import com.water.setting.Setting;
import net.minecraft.class_1268;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1819;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_2596;
import net.minecraft.class_2749;
import net.minecraft.class_2769;
import net.minecraft.class_3965;
import net.minecraft.class_4969;
import net.minecraft.class_9334;
import org.lwjgl.glfw.GLFW;

public final class AnchorMacro
extends ActivatableModule {
    private final Setting<Float> field_0;
    private final Setting<Float> field_1;
    private final Setting<Float> field_2;
    private final Setting<Float> field_3;
    private final Setting<Boolean> field_4;
    private int field_5;
    private int field_6;
    private int field_7;
    private boolean field_8;

    public AnchorMacro() {
        super("Anchor Macro", Category.a);
        this.ab = new Setting<Float>("Switch Delay", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(20.0f));
        this.ac = new Setting<Float>("Glowstone Delay", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(20.0f));
        this.ad = new Setting<Float>("Explode Delay", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(20.0f));
        this.ae = new Setting<Float>("Totem Slot", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(9.0f));
        this.af = new Setting<Boolean>("Switch Back", false);
        this.l = false;
        this.addSetting(this.ab);
        this.addSetting(this.ac);
        this.addSetting(this.ad);
        this.addSetting(this.ae);
        this.addSetting(this.af);
    }

    @Override
    public void onEnable() {
        this.t();
        this.l = false;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.t();
        this.l = false;
        super.onDisable();
    }

    @Override
    public void onPacketReceive(class_2596<?> class_25962) {
        if (((Boolean)this.af.getValue()).booleanValue() && this.l && class_25962 instanceof class_2749) {
            int n;
            this.l = false;
            if (AnchorMacro.mc.field_1724 != null && (n = this.a(class_1802.field_23141)) != -1) {
                AnchorMacro.mc.field_1724.method_31548().method_61496(n);
            }
        }
    }

    @Override
    public void onTick() {
        if (AnchorMacro.mc.field_1724 == null || AnchorMacro.mc.field_1687 == null || AnchorMacro.mc.field_1761 == null) {
            return;
        }
        if (AnchorMacro.mc.field_1755 != null) {
            return;
        }
        if (this.f()) {
            return;
        }
        if (!this.g()) {
            this.t();
            return;
        }
        this.s();
    }

    private boolean method_0() {
        boolean bl = AnchorMacro.mc.field_1724.method_6047().method_7909().method_57347().method_57832(class_9334.field_50075) || AnchorMacro.mc.field_1724.method_6079().method_7909().method_57347().method_57832(class_9334.field_50075);
        boolean bl2 = AnchorMacro.mc.field_1724.method_6047().method_7909() instanceof class_1819 || AnchorMacro.mc.field_1724.method_6079().method_7909() instanceof class_1819;
        boolean bl3 = this.g();
        return (bl || bl2) && bl3;
    }

    private boolean method_1() {
        return mc.method_22683() != null && GLFW.glfwGetMouseButton((long)mc.method_22683().method_4490(), (int)1) == 1;
    }

    private void method_2() {
        class_239 class_2392 = AnchorMacro.mc.field_1765;
        if (!(class_2392 instanceof class_3965)) {
            return;
        }
        class_3965 class_39652 = (class_3965)class_2392;
        if (class_39652.method_17783() != class_239.class_240.field_1332) {
            return;
        }
        class_2392 = class_39652.method_17777();
        if (!(class_2392 = AnchorMacro.mc.field_1687.method_8320((class_2338)class_2392)).method_27852(class_2246.field_23152)) {
            return;
        }
        AnchorMacro.mc.field_1690.field_1904.method_23481(false);
        int n = (Integer)class_2392.method_11654((class_2769)class_4969.field_23153);
        if (n == 0) {
            this.a(class_39652);
        } else {
            this.b(class_39652);
        }
    }

    private void method_3(class_3965 class_39652) {
        if (!AnchorMacro.mc.field_1724.method_6047().method_31574(class_1802.field_8801)) {
            if (this.d < ((Float)this.ab.getValue()).intValue()) {
                ++this.d;
                return;
            }
            this.d = 0;
            if (!this.a(class_1802.field_8801)) {
                return;
            }
        }
        if (AnchorMacro.mc.field_1724.method_6047().method_31574(class_1802.field_8801)) {
            if (this.e < ((Float)this.ac.getValue()).intValue()) {
                ++this.e;
                return;
            }
            this.e = 0;
            this.c(class_39652);
        }
    }

    private void method_4(class_3965 class_39652) {
        int n = Math.max(0, Math.min(8, ((Float)this.ae.getValue()).intValue() - 1));
        if (AnchorMacro.mc.field_1724.method_31548().method_67532() != n) {
            if (this.d < ((Float)this.ab.getValue()).intValue()) {
                ++this.d;
                return;
            }
            this.d = 0;
            AnchorMacro.mc.field_1724.method_31548().method_61496(n);
        }
        if (AnchorMacro.mc.field_1724.method_31548().method_67532() == n) {
            if (this.f < ((Float)this.ad.getValue()).intValue()) {
                ++this.f;
                return;
            }
            this.f = 0;
            this.c(class_39652);
            if (((Boolean)this.af.getValue()).booleanValue()) {
                this.l = true;
            }
        }
    }

    private int method_5(class_1792 class_17922) {
        for (int i = 0; i < 9; ++i) {
            if (!AnchorMacro.mc.field_1724.method_31548().method_5438(i).method_31574(class_17922)) continue;
            return i;
        }
        return -1;
    }

    private boolean method_6(class_1792 class_17922) {
        int n = this.a(class_17922);
        if (n != -1) {
            AnchorMacro.mc.field_1724.method_31548().method_61496(n);
            return true;
        }
        return false;
    }

    private void method_7(class_3965 class_39652) {
        AnchorMacro.mc.field_1761.method_2896(AnchorMacro.mc.field_1724, class_1268.field_5808, class_39652);
        AnchorMacro.mc.field_1724.method_6104(class_1268.field_5808);
    }

    private void method_8() {
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }
}

