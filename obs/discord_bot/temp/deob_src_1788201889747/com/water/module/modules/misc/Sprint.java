/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;

public final class Sprint
extends Module {
    private boolean field_0;

    public Sprint() {
        super("Sprint", Category.c);
        this.ag = false;
    }

    @Override
    public void onEnable() {
        if (mc == null || Sprint.mc.field_1690 == null) {
            return;
        }
        this.ag = this.w();
        this.a(false);
    }

    @Override
    public void onDisable() {
        if (mc == null || Sprint.mc.field_1690 == null) {
            return;
        }
        this.a(this.ag);
        try {
            Sprint.mc.field_1690.field_1867.method_23481(false);
        }
        catch (Throwable throwable) {}
    }

    @Override
    public void onTick() {
        if (mc == null || Sprint.mc.field_1724 == null || Sprint.mc.field_1690 == null) {
            return;
        }
        this.a(false);
        try {
            Sprint.mc.field_1690.field_1867.method_23481(true);
        }
        catch (Throwable throwable) {}
    }

    private boolean method_0() {
        try {
            Object object = Sprint.mc.field_1690.getClass().getMethod("getSprintToggled", new Class[0]).invoke((Object)Sprint.mc.field_1690, new Object[0]);
            if (object == null) {
                return false;
            }
            return (object = object.getClass().getMethod("getValue", new Class[0]).invoke(object, new Object[0])) instanceof Boolean && ((Boolean)(object = (Boolean)object)).booleanValue();
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private void method_1(boolean bl) {
        try {
            Object object = Sprint.mc.field_1690.getClass().getMethod("getSprintToggled", new Class[0]).invoke((Object)Sprint.mc.field_1690, new Object[0]);
            if (object == null) {
                return;
            }
            object.getClass().getMethod("setValue", Object.class).invoke(object, bl);
        }
        catch (Throwable throwable) {}
    }
}

