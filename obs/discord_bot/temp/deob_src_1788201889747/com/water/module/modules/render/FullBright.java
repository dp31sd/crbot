/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.module.Category;
import com.water.module.Module;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import net.minecraft.class_7172;

public final class FullBright
extends Module {
    private double field_0;
    private boolean field_1;
    private static Field field_2;

    public FullBright() {
        super("FullBright", Category.b);
        this.i = 1.0;
        this.aj = false;
    }

    @Override
    public void onEnable() {
        if (FullBright.mc.field_1690 == null) {
            return;
        }
        this.i = (Double)FullBright.mc.field_1690.method_42473().method_41753();
        this.a(10.0);
        this.aj = true;
    }

    @Override
    public void onDisable() {
        if (FullBright.mc.field_1690 == null) {
            return;
        }
        this.a(this.aj ? this.i : 1.0);
        this.aj = false;
    }

    @Override
    public void onTick() {
        if (FullBright.mc.field_1690 == null) {
            return;
        }
        if (!this.aj) {
            this.i = (Double)FullBright.mc.field_1690.method_42473().method_41753();
            if (Math.abs(this.i - 10.0) < 1.0E-4) {
                this.i = 1.0;
            }
            this.a(10.0);
            this.aj = true;
            return;
        }
        try {
            double d2 = (Double)FullBright.mc.field_1690.method_42473().method_41753();
            if (Math.abs(d2 - 10.0) > 1.0E-4) {
                this.a(10.0);
            }
        }
        catch (Exception exception) {}
    }

    private void method_0(double d2) {
        class_7172 class_71722 = FullBright.mc.field_1690.method_42473();
        Object object = a;
        if (object == null) {
            object = this.a(class_71722);
            a = object;
        }
        if (object != null) {
            try {
                ((Field)object).set(class_71722, d2);
                object = (Double)class_71722.method_41753();
                if (object != null && Math.abs((Double)object - d2) <= 1.0E-4) {
                    return;
                }
                a = null;
            }
            catch (Exception exception) {}
        }
        try {
            class_71722.method_41748((Object)d2);
        }
        catch (Exception exception) {}
    }

    private Field method_1(class_7172<?> class_71722) {
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
}

