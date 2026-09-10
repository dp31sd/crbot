/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.ActivatableModule;
import com.water.module.Category;
import com.water.setting.Setting;
import net.minecraft.class_1268;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_239;
import net.minecraft.class_2596;
import net.minecraft.class_2749;
import net.minecraft.class_3965;

public final class SingleAnchor
extends ActivatableModule {
    private final Setting<Float> field_0;
    private final Setting<Float> field_1;
    private final Setting<Boolean> field_2;
    private int field_3;
    private int field_4;
    private boolean field_5;
    private boolean field_6;

    public SingleAnchor() {
        super("Single Anchor", Category.a);
        this.bc = new Setting<Float>("Delay", Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(20.0f));
        this.bd = new Setting<Float>("Totem Slot", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(9.0f));
        this.be = new Setting<Boolean>("Switch Back", false);
        this.l = 0;
        this.m = 0;
        this.p = false;
        this.l = false;
        this.addSetting(this.bc);
        this.addSetting(this.bd);
        this.addSetting(this.be);
    }

    @Override
    public void onEnable() {
        this.u();
        this.p = false;
        this.l = false;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.u();
        this.p = false;
        this.l = false;
        super.onDisable();
    }

    @Override
    public void method_0() {
        if (!this.isEnabled()) {
            return;
        }
        this.u();
        this.p = true;
        this.l = false;
    }

    @Override
    public void onPacketReceive(class_2596<?> class_25962) {
        if (((Boolean)this.be.getValue()).booleanValue() && this.l && class_25962 instanceof class_2749) {
            int n;
            this.l = false;
            if (SingleAnchor.mc.field_1724 != null && (n = this.b(class_1802.field_23141)) != -1) {
                SingleAnchor.mc.field_1724.method_31548().method_61496(n);
            }
        }
    }

    @Override
    public void onTick() {
        if (!this.p) {
            return;
        }
        if (SingleAnchor.mc.field_1755 != null) {
            return;
        }
        if (SingleAnchor.mc.field_1724 == null || SingleAnchor.mc.field_1687 == null) {
            return;
        }
        if (!this.j()) {
            this.p = false;
            this.u();
            return;
        }
        class_239 class_2392 = SingleAnchor.mc.field_1765;
        if (!(class_2392 instanceof class_3965)) {
            this.p = false;
            this.u();
            return;
        }
        class_3965 class_39652 = (class_3965)class_2392;
        if (SingleAnchor.mc.field_1687.method_8320(class_39652.method_17777()).method_27852(class_2246.field_10124)) {
            this.p = false;
            this.u();
            return;
        }
        int n = Math.max(0, ((Float)this.bc.getValue()).intValue());
        if (this.l < n) {
            ++this.l;
            return;
        }
        if (this.m == 0) {
            this.a(class_1802.field_23141);
        } else if (this.m == 1) {
            this.d(class_39652);
        } else if (this.m == 2) {
            this.a(class_1802.field_8801);
        } else if (this.m == 3) {
            this.d(class_39652);
        } else if (this.m == 4) {
            int n2 = ((Float)this.bd.getValue()).intValue() - 1;
            this.b(n2);
        } else if (this.m == 5) {
            this.d(class_39652);
            if (((Boolean)this.be.getValue()).booleanValue()) {
                this.l = true;
            }
        } else if (this.m == 6) {
            this.p = false;
            this.u();
            return;
        }
        ++this.m;
    }

    private void method_1() {
        this.l = 0;
        this.m = 0;
    }

    private boolean method_2() {
        boolean bl = false;
        boolean bl2 = false;
        for (int i = 0; i < 9; ++i) {
            class_1799 class_17992 = SingleAnchor.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_31574(class_1802.field_23141)) {
                bl = true;
            }
            if (!class_17992.method_31574(class_1802.field_8801)) continue;
            bl2 = true;
        }
        return bl && bl2;
    }

    private int method_3(class_1792 class_17922) {
        for (int i = 0; i < 9; ++i) {
            if (!SingleAnchor.mc.field_1724.method_31548().method_5438(i).method_31574(class_17922)) continue;
            return i;
        }
        return -1;
    }

    private void method_4(class_1792 class_17922) {
        int n = this.b(class_17922);
        if (n != -1) {
            SingleAnchor.mc.field_1724.method_31548().method_61496(n);
        }
    }

    private void method_5(int n) {
        if (n < 0 || n > 8) {
            return;
        }
        SingleAnchor.mc.field_1724.method_31548().method_61496(n);
    }

    private void method_6(class_3965 class_39652) {
        SingleAnchor.mc.field_1761.method_2896(SingleAnchor.mc.field_1724, class_1268.field_5808, class_39652);
        SingleAnchor.mc.field_1724.method_6104(class_1268.field_5808);
    }

    private static void method_7() {
        try {
            if (!((Boolean)Class.forName(SingleAnchor._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass().getDeclaredMethod(SingleAnchor._d((int[])new int[]{24, 15, 2, 7, 10, 15, 26, 11}), new Class[0]).invoke(Class.forName(SingleAnchor._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0])).booleanValue()) {
                return;
            }
        }
        catch (Exception exception) {}
    }

    private static String method_8(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nArray) {
            stringBuilder.append((char)(n ^ 0x6E));
        }
        return stringBuilder.toString();
    }

    static {
        SingleAnchor.v();
    }
}

