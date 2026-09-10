/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.class_7172;

public final class AutoRender
extends Module {
    private final Setting<Float> field_0;
    private final Setting<Float> field_1;
    private final Setting<Float> field_2;
    private final Setting<Float> field_3;
    private final Setting<Float> field_4;
    private int field_5;
    private int field_6;
    private int field_7;
    private double field_8;
    private double field_9;
    private boolean field_10;
    private boolean field_11;
    private boolean field_12;
    private static Field field_13;

    public AutoRender() {
        super("AUTO RENDER", Category.c);
        this.aA = new Setting<Float>("Low Chunks", Float.valueOf(2.0f), Float.valueOf(2.0f), Float.valueOf(32.0f));
        this.aB = new Setting<Float>("High Chunks", Float.valueOf(8.0f), Float.valueOf(2.0f), Float.valueOf(32.0f));
        this.aC = new Setting<Float>("Low Ticks", Float.valueOf(8.0f), Float.valueOf(1.0f), Float.valueOf(40.0f));
        this.aD = new Setting<Float>("Reset Up Y", Float.valueOf(4.0f), Float.valueOf(1.0f), Float.valueOf(32.0f));
        this.aE = new Setting<Float>("Trigger Down Y", Float.valueOf(3.0f), Float.valueOf(1.0f), Float.valueOf(32.0f));
        this.aj = -1;
        this.ak = 0;
        this.al = -1;
        this.b = 0.0;
        this.c = 0.0;
        this.ac = false;
        this.ad = false;
        this.ae = false;
        this.addSetting(this.aA);
        this.addSetting(this.aB);
        this.addSetting(this.aC);
        this.addSetting(this.aD);
        this.addSetting(this.aE);
    }

    @Override
    public void onEnable() {
        if (AutoRender.mc.field_1690 == null || AutoRender.mc.field_1724 == null) {
            return;
        }
        this.aj = AutoRender.mc.field_1690.method_38521();
        this.al = -1;
        this.c = this.b = AutoRender.mc.field_1724.method_23318();
        this.an();
    }

    @Override
    public void onDisable() {
        if (AutoRender.mc.field_1690 == null) {
            return;
        }
        if (this.aj >= 2) {
            this.j(this.aj);
        }
        this.aj = -1;
        this.ak = 0;
        this.al = -1;
        this.ac = false;
        this.ad = false;
        this.ae = false;
    }

    @Override
    public void onTick() {
        if (AutoRender.mc.field_1690 == null || AutoRender.mc.field_1687 == null || AutoRender.mc.field_1724 == null) {
            return;
        }
        double d2 = AutoRender.mc.field_1724.method_23318();
        if (this.ac) {
            --this.ak;
            if (this.ak <= 0) {
                this.ap();
                this.ac = false;
                this.ad = true;
                this.ae = false;
                this.c = d2;
            } else {
                this.ao();
            }
            this.b = d2;
            return;
        }
        if (this.ad) {
            if (d2 > this.c) {
                this.c = d2;
            }
            if (d2 >= this.b + (double)((Float)this.aD.getValue()).floatValue()) {
                this.ae = true;
            }
            if (this.ae && this.c - d2 >= (double)((Float)this.aE.getValue()).floatValue()) {
                this.an();
            }
        }
        this.b = d2;
    }

    private void method_0() {
        this.ac = true;
        this.ad = false;
        this.ae = false;
        this.ak = Math.max(1, ((Float)this.aC.getValue()).intValue());
        this.ao();
    }

    private void method_1() {
        int n = this.a(((Float)this.aA.getValue()).intValue(), 2, 32);
        this.i(n);
    }

    private void method_2() {
        int n = this.a(((Float)this.aA.getValue()).intValue(), 2, 32);
        int n2 = this.a(((Float)this.aB.getValue()).intValue(), 2, 32);
        if (n2 < n) {
            n2 = n;
        }
        this.i(n2);
    }

    private void method_3(int n) {
        if (this.al == (n = this.a(n, 2, 32)) && AutoRender.mc.field_1690.method_38521() == n) {
            return;
        }
        this.al = n;
        this.j(n);
    }

    private void method_4(int n) {
        n = this.a(n, 2, 32);
        class_7172 class_71722 = AutoRender.mc.field_1690.method_42503();
        Field field = a;
        if (field == null) {
            a = field = this.a(class_71722);
        }
        if (field != null) {
            try {
                field.set(class_71722, n);
                if (Integer.valueOf(n).equals(class_71722.method_41753())) {
                    this.aq();
                    return;
                }
                a = null;
            }
            catch (Exception exception) {}
        }
        try {
            class_71722.method_41748((Object)n);
        }
        catch (Exception exception) {}
        this.aq();
    }

    private void method_5() {
        if (AutoRender.mc.field_1769 != null) {
            AutoRender.mc.field_1769.method_3292();
        }
    }

    private Field method_6(class_7172<?> class_71722) {
        Object object;
        try {
            object = class_71722.method_41753();
        }
        catch (Exception exception) {
            object = null;
        }
        Field field = null;
        for (Field field2 : class_7172.class.getDeclaredFields()) {
            if (Modifier.isStatic(field2.getModifiers())) continue;
            if ("value".equals(field2.getName())) {
                field = field2;
            }
            field2.setAccessible(true);
            try {
                Object object2 = field2.get(class_71722);
                if (!(object == null ? object2 == null : object.equals(object2))) continue;
                return field2;
            }
            catch (Exception exception) {}
        }
        if (field != null) {
            field.setAccessible(true);
            return field;
        }
        return null;
    }

    private int method_7(int n, int n2, int n3) {
        return Math.max(n2, Math.min(n3, n));
    }
}

