/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import net.minecraft.class_1923;
import net.minecraft.class_1944;
import net.minecraft.class_2338;
import net.minecraft.class_2818;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import org.lwjgl.opengl.GL11;

public final class LightDebug
extends Module {
    private final Setting<Integer> field_0;
    private final Setting<Integer> field_1;
    private final Setting<Integer> field_2;
    private final Setting<Integer> field_3;
    private final Setting<Color> field_4;
    private final Setting<Color> field_5;
    private final Map<class_1923, List<a>> field_6;
    private class_1923 field_7;
    private int field_8;
    private ExecutorService field_9;
    private final AtomicBoolean field_10;

    public LightDebug() {
        super("LightDebug", Category.b);
        this.bU = new Setting<Integer>("Min Light", 0, 0, 15);
        this.bV = new Setting<Integer>("Max Light", 7, 0, 15);
        this.bW = new Setting<Integer>("Min Y", -51, -64, 20);
        this.bX = new Setting<Integer>("Max Y", 20, -64, 20);
        this.bY = new Setting<Color>("Color Low", new Color(50, 200, 50, 60));
        this.bZ = new Setting<Color>("Color High", new Color(255, 50, 50, 60));
        this.s = new ConcurrentHashMap();
        this.d = null;
        this.bc = 0;
        this.g = new AtomicBoolean(false);
        this.addSetting(this.bU);
        this.addSetting(this.bV);
        this.addSetting(this.bW);
        this.addSetting(this.bX);
        this.addSetting(this.bY);
        this.addSetting(this.bZ);
    }

    @Override
    public void onEnable() {
        this.s.clear();
        this.d = null;
        this.bc = 0;
        this.g.set(false);
    }

    @Override
    public void onDisable() {
        this.s.clear();
        if (this.b != null) {
            this.b.shutdownNow();
        }
    }

    @Override
    public void onTick() {
        if (LightDebug.mc.field_1687 == null || LightDebug.mc.field_1724 == null) {
            return;
        }
        class_1923 class_19232 = LightDebug.mc.field_1724.method_31476();
        int n = !class_19232.equals((Object)this.d) ? 1 : 0;
        this.d = class_19232;
        if (++this.bc % 10 != 0 && n == 0) {
            return;
        }
        if (!this.g.compareAndSet(false, true)) {
            return;
        }
        if (this.b == null || this.b.isShutdown()) {
            this.b = Executors.newSingleThreadExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, f(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
        }
        n = (Integer)this.bU.getValue();
        int n2 = (Integer)this.bV.getValue();
        int n3 = Math.min((Integer)this.bW.getValue(), (Integer)this.bX.getValue());
        int n4 = Math.max((Integer)this.bW.getValue(), (Integer)this.bX.getValue());
        ArrayList<class_1923> arrayList = new ArrayList<class_1923>();
        ArrayList<class_2818> arrayList2 = new ArrayList<class_2818>();
        for (int i = -3; i <= 3; ++i) {
            for (int j = -3; j <= 3; ++j) {
                class_1923 class_19233 = new class_1923(class_19232.field_9181 + i, class_19232.field_9180 + j);
                class_2818 class_28182 = LightDebug.mc.field_1687.method_2935().method_12126(class_19233.field_9181, class_19233.field_9180, false);
                if (class_28182 == null || class_28182.method_12223()) continue;
                arrayList.add(class_19233);
                arrayList2.add(class_28182);
            }
        }
        this.s.keySet().removeIf((Predicate<class_1923>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(net.minecraft.class_1923 int net.minecraft.class_1923 ), (Lnet/minecraft/class_1923;)Z)((class_1923)class_19232, (int)3));
        this.b.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(java.util.List java.util.List int int int int ), ()V)((LightDebug)this, arrayList, arrayList2, (int)n, (int)n2, (int)n3, (int)n4));
    }

    private List<a> method_0(class_2818 object, class_1923 class_19232, int n, int n2, int n3, int n4) {
        object = new ArrayList();
        int n5 = class_19232.field_9181 << 4;
        int n6 = class_19232.field_9180 << 4;
        while (n3 <= n4) {
            for (int i = 0; i < 16; ++i) {
                for (int j = 0; j < 16; ++j) {
                    class_2338 class_23382 = new class_2338(n5 + i, n3, n6 + j);
                    int n7 = LightDebug.mc.field_1687.method_8314(class_1944.field_9282, class_23382);
                    if (n7 < n || n7 > n2) continue;
                    object.add(new a(class_23382, n7));
                }
            }
            ++n3;
        }
        return object;
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        if (LightDebug.mc.field_1687 == null || LightDebug.mc.field_1724 == null) {
            return;
        }
        if (this.s.isEmpty()) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        int n = (Integer)this.bV.getValue();
        int n2 = (Integer)this.bU.getValue();
        class_45872.method_22903();
        GL11.glDisable((int)2929);
        try {
            RenderUtils.WorldBatch worldBatch = RenderUtils.beginWorldBatch(class_45872);
            int n3 = 0;
            block3: for (Object object : this.s.values()) {
                object = object.iterator();
                while (object.hasNext()) {
                    a a2 = (a)object.next();
                    if (n3++ >= 50000) break block3;
                    Color color = this.a(a2.bd, n2, n);
                    double d2 = (double)a2.d.method_10263() - class_41842.field_1352;
                    double d3 = (double)a2.d.method_10264() - class_41842.field_1351;
                    double d4 = (double)a2.d.method_10260() - class_41842.field_1350;
                    worldBatch.renderFilledBox(d2, d3, d4, d2 + 1.0, d3 + 1.0, d4 + 1.0, color);
                }
            }
            worldBatch.flush();
        }
        finally {
            GL11.glEnable((int)2929);
            class_45872.method_22909();
        }
    }

    private Color method_1(int n, int n2, int n3) {
        float f = Math.max(1, n3 - n2);
        float f2 = Math.max(0.0f, Math.min(1.0f, (float)(n - n2) / f));
        Color color = (Color)this.bY.getValue();
        Color color2 = (Color)this.bZ.getValue();
        int n4 = (int)((float)color.getRed() + (float)(color2.getRed() - color.getRed()) * f2);
        int n5 = (int)((float)color.getGreen() + (float)(color2.getGreen() - color.getGreen()) * f2);
        int n6 = (int)((float)color.getBlue() + (float)(color2.getBlue() - color.getBlue()) * f2);
        int n7 = (int)((float)color.getAlpha() + (float)(color2.getAlpha() - color.getAlpha()) * f2);
        return new Color(n4, n5, n6, n7);
    }

    private /* synthetic */ void method_2(List list, List list2, int n, int n2, int n3, int n4) {
        try {
            for (int i = 0; i < list.size(); ++i) {
                class_1923 class_19232 = (class_1923)list.get(i);
                List list3 = this.a((class_2818)list2.get(i), class_19232, n, n2, n3, n4);
                if (list3.isEmpty()) {
                    this.s.remove(class_19232);
                    continue;
                }
                this.s.put(class_19232, list3);
            }
        }
        catch (Exception exception) {
        }
        finally {
            this.g.set(false);
        }
    }

    private static /* synthetic */ boolean method_3(class_1923 class_19232, int n, class_1923 class_19233) {
        return Math.abs(class_19233.field_9181 - class_19232.field_9181) > n + 1 || Math.abs(class_19233.field_9180 - class_19232.field_9180) > n + 1;
    }

    private static /* synthetic */ Thread method_4(Runnable runnable) {
        runnable = new Thread(runnable, "lightdebug-scan");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    private static final class a {
        final class_2338 field_0;
        final int field_1;

        a(class_2338 class_23382, int n) {
            this.d = class_23382;
            this.bd = n;
        }
    }
}

