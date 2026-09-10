/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.lang.invoke.LambdaMetafactory;
import net.minecraft.class_2561;
import net.minecraft.class_634;

public final class AutoChunkLoader
extends Module {
    private final Setting<Float> field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Integer> field_2;
    private boolean field_3;
    private long field_4;

    public AutoChunkLoader() {
        super("AUTO CHUNK LOADER", Category.d);
        this.F = new Setting<Float>("Home Slot", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(5.0f));
        this.G = new Setting<Boolean>("Chat Feedback", true);
        this.H = new Setting<Integer>("Cooldown", 3500, 500, 10000);
        this.u = false;
        this.n = 0L;
        this.addSetting(this.F);
        this.addSetting(this.G);
        this.addSetting(this.H);
    }

    @Override
    public void onDisable() {
        this.u = false;
        this.n = 0L;
    }

    @Override
    public void onTick() {
        if (AutoChunkLoader.mc.field_1687 == null || AutoChunkLoader.mc.field_1724 == null) {
            return;
        }
        if (this.u) {
            return;
        }
        if (System.currentTimeMillis() < this.n) {
            return;
        }
        double d2 = AutoChunkLoader.mc.field_1724.method_23318();
        if (d2 >= -3.0) {
            return;
        }
        this.u = true;
        int n = Math.round(((Float)this.F.getValue()).floatValue());
        if (((Boolean)this.G.getValue()).booleanValue() && AutoChunkLoader.mc.field_1705 != null) {
            AutoChunkLoader.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)""));
        }
        new Thread((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, d(int ), ()V)((AutoChunkLoader)this, (int)n), "RtpReset-Thread").start();
    }

    private void method_0(String string) {
        if (mc == null || AutoChunkLoader.mc.field_1724 == null) {
            return;
        }
        class_634 class_6342 = null;
        try {
            class_6342 = AutoChunkLoader.mc.field_1724.field_3944;
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
        try {
            mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, g(int ), ()V)((AutoChunkLoader)this, (int)n));
            Thread.sleep(800L);
            mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, f(int ), ()V)((AutoChunkLoader)this, (int)n));
            Thread.sleep(300L);
            mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, ad(), ()V)((AutoChunkLoader)this));
            Thread.sleep(((Integer)this.H.getValue()).intValue());
            mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, e(int ), ()V)((AutoChunkLoader)this, (int)n));
        }
        catch (InterruptedException interruptedException) {
            this.u = false;
        }
    }

    private /* synthetic */ void method_2(int n) {
        this.p("/home " + n);
        if (((Boolean)this.G.getValue()).booleanValue() && AutoChunkLoader.mc.field_1705 != null) {
            AutoChunkLoader.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)""));
        }
        this.n = System.currentTimeMillis() + 15000L;
        this.u = false;
    }

    private /* synthetic */ void method_3() {
        this.p("/home 3");
        if (((Boolean)this.G.getValue()).booleanValue() && AutoChunkLoader.mc.field_1705 != null) {
            AutoChunkLoader.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)""));
        }
    }

    private /* synthetic */ void method_4(int n) {
        this.p("/sethome " + n);
        if (((Boolean)this.G.getValue()).booleanValue() && AutoChunkLoader.mc.field_1705 != null) {
            AutoChunkLoader.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)""));
        }
    }

    private /* synthetic */ void method_5(int n) {
        this.p("/delhome " + n);
    }
}

