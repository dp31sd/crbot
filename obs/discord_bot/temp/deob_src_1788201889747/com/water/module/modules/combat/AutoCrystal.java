/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.ActivatableModule;
import com.water.module.Category;
import com.water.setting.Setting;
import java.util.Random;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_7923;
import org.lwjgl.glfw.GLFW;

public final class AutoCrystal
extends ActivatableModule {
    private final Setting<Float> field_0;
    private final Setting<Float> field_1;
    private final Setting<Float> field_2;
    private final Setting<Float> field_3;
    private final Setting<Boolean> field_4;
    private final Setting<Boolean> field_5;
    private final Random field_6;
    private boolean field_7;
    private int field_8;
    private int field_9;

    public AutoCrystal() {
        super("Auto Crystal", Category.a);
        this.ag = new Setting<Float>("Place Delay", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(20.0f));
        this.ah = new Setting<Float>("Break Delay", Float.valueOf(2.0f), Float.valueOf(0.0f), Float.valueOf(20.0f));
        this.ai = new Setting<Float>("Place Chance", Float.valueOf(100.0f), Float.valueOf(0.0f), Float.valueOf(100.0f));
        this.aj = new Setting<Float>("Break Chance", Float.valueOf(100.0f), Float.valueOf(0.0f), Float.valueOf(100.0f));
        this.ak = new Setting<Boolean>("Fake Punch", false);
        this.al = new Setting<Boolean>("Anti-Weakness", false);
        this.a = new Random();
        this.m = false;
        this.g = 0;
        this.h = 0;
        this.addSetting(this.ag);
        this.addSetting(this.ah);
        this.addSetting(this.ai);
        this.addSetting(this.aj);
        this.addSetting(this.ak);
        this.addSetting(this.al);
    }

    @Override
    public void onEnable() {
        this.g = 0;
        this.h = 0;
        this.m = false;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.g = 0;
        this.h = 0;
        this.m = false;
    }

    @Override
    public void method_0() {
    }

    private boolean method_1() {
        int n = this.getActivationKey();
        if (n == 0) {
            return true;
        }
        if (mc.method_22683() == null) {
            return false;
        }
        try {
            return GLFW.glfwGetKey((long)mc.method_22683().method_4490(), (int)n) == 1;
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
    public void onTick() {
        int n;
        int n2;
        class_2338 class_23382;
        class_3965 class_39652;
        boolean bl;
        if (AutoCrystal.mc.field_1724 == null || AutoCrystal.mc.field_1687 == null || AutoCrystal.mc.field_1755 != null) {
            return;
        }
        boolean bl2 = this.g != 0;
        boolean bl3 = bl = this.h != 0;
        if (bl2) {
            --this.g;
        }
        if (bl) {
            --this.h;
        }
        if (AutoCrystal.mc.field_1724.method_29504()) {
            return;
        }
        if (!this.h()) {
            this.g = 0;
            this.h = 0;
            this.m = false;
            return;
        }
        this.m = true;
        if (AutoCrystal.mc.field_1724.method_6047().method_7909() != class_1802.field_8301) {
            return;
        }
        class_239 class_2392 = AutoCrystal.mc.field_1765;
        int n3 = this.a.nextInt(100) + 1;
        if (class_2392 instanceof class_3965 && (class_39652 = (class_3965)class_2392).method_17783() == class_239.class_240.field_1332) {
            class_23382 = class_39652.method_17777();
            n2 = AutoCrystal.mc.field_1687.method_8320(class_23382).method_27852(class_2246.field_10540);
            n = AutoCrystal.mc.field_1687.method_8320(class_23382).method_27852(class_2246.field_9987);
            if (n2 != 0 || n != 0) {
                boolean bl4 = this.a(class_23382);
                if (!bl2 && (float)n3 <= ((Float)this.ai.getValue()).floatValue()) {
                    if (bl4) {
                        AutoCrystal.mc.field_1761.method_2896(AutoCrystal.mc.field_1724, class_1268.field_5808, class_39652);
                        AutoCrystal.mc.field_1724.method_6104(class_1268.field_5808);
                        this.g = ((Float)this.ag.getValue()).intValue();
                    }
                    if (((Boolean)this.ak.getValue()).booleanValue() && !bl && (float)n3 <= ((Float)this.aj.getValue()).floatValue()) {
                        AutoCrystal.mc.field_1761.method_2910(class_23382, class_39652.method_17780());
                        AutoCrystal.mc.field_1724.method_6104(class_1268.field_5808);
                        this.h = ((Float)this.ah.getValue()).intValue();
                    }
                }
            }
        }
        n3 = this.a.nextInt(100) + 1;
        if (class_2392 instanceof class_3966 && (class_23382 = (class_39652 = (class_3966)class_2392).method_17782()) instanceof class_1511 && !bl && (float)n3 <= ((Float)this.aj.getValue()).floatValue()) {
            n2 = AutoCrystal.mc.field_1724.method_31548().method_67532();
            if (((Boolean)this.al.getValue()).booleanValue() && this.i()) {
                for (n = 0; n < 9; ++n) {
                    class_1799 class_17992 = AutoCrystal.mc.field_1724.method_31548().method_5438(n);
                    String string = class_7923.field_41178.method_10221((Object)class_17992.method_7909()).method_12832();
                    if (!string.endsWith("_sword")) continue;
                    AutoCrystal.mc.field_1724.method_31548().method_61496(n);
                    break;
                }
            }
            AutoCrystal.mc.field_1761.method_2918((class_1657)AutoCrystal.mc.field_1724, (class_1297)class_23382);
            AutoCrystal.mc.field_1724.method_6104(class_1268.field_5808);
            this.h = ((Float)this.ah.getValue()).intValue();
            if (((Boolean)this.al.getValue()).booleanValue()) {
                AutoCrystal.mc.field_1724.method_31548().method_61496(n2);
            }
        }
    }

    private boolean method_2(class_2338 class_23382) {
        if (!AutoCrystal.mc.field_1687.method_22347(class_23382 = class_23382.method_10084())) {
            return false;
        }
        class_23382 = new class_238((double)class_23382.method_10263(), (double)class_23382.method_10264(), (double)class_23382.method_10260(), (double)class_23382.method_10263() + 1.0, (double)class_23382.method_10264() + 2.0, (double)class_23382.method_10260() + 1.0);
        return AutoCrystal.mc.field_1687.method_8335(null, (class_238)class_23382).isEmpty();
    }

    private boolean method_3() {
        if (AutoCrystal.mc.field_1724 == null) {
            return false;
        }
        int n = AutoCrystal.mc.field_1724.method_6059(class_1294.field_5911);
        if (n == 0) {
            return false;
        }
        n = AutoCrystal.mc.field_1724.method_6059(class_1294.field_5910);
        int n2 = AutoCrystal.mc.field_1724.method_6112(class_1294.field_5911).method_5578();
        n = n != 0 ? AutoCrystal.mc.field_1724.method_6112(class_1294.field_5910).method_5578() : -1;
        return n <= n2;
    }
}

