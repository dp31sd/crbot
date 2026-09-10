/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.lang.invoke.LambdaMetafactory;
import net.minecraft.class_2561;
import net.minecraft.class_634;

public final class HomeSetter
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Float> field_1;
    private volatile boolean field_2;

    public HomeSetter() {
        super("HomeSetter", Category.c);
        this.aK = new Setting<Boolean>("Chat Feedback", true);
        this.aL = new Setting<Float>("Home Slot", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(5.0f));
        this.af = false;
        this.addSetting(this.aK);
        this.addSetting(this.aL);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if (this.af) {
            return;
        }
        if (mc == null || HomeSetter.mc.field_1724 == null || HomeSetter.mc.field_1687 == null) {
            this.toggle();
            return;
        }
        this.af = true;
        int n = Math.round(((Float)this.aL.getValue()).floatValue());
        mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, k(int ), ()V)((HomeSetter)this, (int)n));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.af = false;
    }

    private void method_0(String string) {
        if (mc == null) {
            return;
        }
        class_634 class_6342 = null;
        try {
            if (HomeSetter.mc.field_1724 != null) {
                class_6342 = HomeSetter.mc.field_1724.field_3944;
            }
        }
        catch (Throwable throwable) {}
        if (class_6342 == null) {
            try {
                class_6342 = mc.method_1562();
            }
            catch (Throwable throwable) {}
        }
        if (class_6342 == null) {
            return;
        }
        String string2 = string.startsWith("/") ? string.substring(1) : string;
        try {
            class_6342.method_45730(string2);
            return;
        }
        catch (Throwable throwable) {
            try {
                class_6342.method_45729(string);
            }
            catch (Throwable throwable2) {}
            return;
        }
    }

    private /* synthetic */ void method_1(int n) {
        this.o("/delhome " + n);
        new Thread((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, l(int ), ()V)((HomeSetter)this, (int)n), "HomeSetter-DelayThread").start();
    }

    private /* synthetic */ void method_2(int n) {
        try {
            Thread.sleep(750L);
        }
        catch (InterruptedException interruptedException) {}
        mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, m(int ), ()V)((HomeSetter)this, (int)n));
    }

    private /* synthetic */ void method_3(int n) {
        this.o("/sethome " + n);
        if (((Boolean)this.aK.getValue()).booleanValue()) {
            try {
                HomeSetter.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)("\u00a7aHome " + n + " deleted and set successfully!")));
            }
            catch (Exception exception) {}
        }
        this.af = false;
        this.toggle();
    }
}

