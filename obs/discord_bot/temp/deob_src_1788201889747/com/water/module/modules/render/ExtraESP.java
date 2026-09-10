/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.render.Freecam;
import com.water.setting.BlocksSetting;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import net.minecraft.class_1297;
import net.minecraft.class_1799;
import net.minecraft.class_1923;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2672;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_7923;

public final class ExtraESP
extends Module {
    private final BlocksSetting field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Double> field_3;
    private final Setting<Double> field_4;
    private final Setting<Double> field_5;
    private final Map<Long, Set<class_2338>> field_6;
    private final Map<class_2338, class_2248> field_7;
    private final Map<Long, Long> field_8;
    private final Map<class_2248, Color> field_9;
    private final ArrayDeque<Long> field_10;
    private final Set<Long> field_11;
    private final Object field_12;
    private volatile Set<class_2248> field_13;
    private long field_14;
    private int field_15;
    private boolean field_16;
    private class_1923 field_17;
    private int field_18;
    private final List<a> field_19;
    private final ExecutorService field_20;
    private final AtomicBoolean field_21;
    private final Set<Long> field_22;
    private int field_23;
    private int field_24;
    private int field_25;

    public ExtraESP() {
        super("Extra ESP", Category.b);
        this.b = new BlocksSetting("Blocks", class_2246.field_10260);
        this.bz = new Setting<Boolean>("Notify", true);
        this.bA = new Setting<Boolean>("Tracers", true);
        this.bB = new Setting<Double>("Tracer Weight", 0.8, 0.1, 4.0);
        this.bC = new Setting<Double>("Opacity", 190.0, 0.0, 255.0);
        this.bD = new Setting<Double>("Fill Alpha", 35.0, 0.0, 255.0);
        this.m = new ConcurrentHashMap();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.p = new ConcurrentHashMap();
        this.b = new ArrayDeque();
        this.m = new HashSet();
        this.b = new Object();
        this.l = Collections.emptySet();
        this.x = -1L;
        this.ai = true;
        this.av = -1;
        this.e = new ArrayList();
        this.d = Executors.newFixedThreadPool(Math.max(2, Math.min(4, Runtime.getRuntime().availableProcessors())), runnable -> {
            runnable = new Thread(runnable, "extraESP-scan");
            ((Thread)runnable).setDaemon(true);
            ((Thread)runnable).setPriority(5);
            return runnable;
        });
        this.e = new AtomicBoolean(false);
        this.n = Collections.synchronizedSet(new HashSet());
        this.ax = Integer.MIN_VALUE;
        this.ay = Integer.MIN_VALUE;
        this.addSetting(this.b);
        this.addSetting(this.bz);
        this.addSetting(this.bA);
        this.addSetting(this.bB);
        this.addSetting(this.bC);
        this.addSetting(this.bD);
    }

    @Override
    public void onEnable() {
        this.av();
        this.x = -1L;
        this.ai = true;
        this.k = 0;
        this.aw = 0;
        this.c = null;
        this.av = -1;
        this.ax = Integer.MIN_VALUE;
        this.ay = Integer.MIN_VALUE;
    }

    @Override
    public void onDisable() {
        this.av();
        this.c = null;
        this.av = -1;
    }

    @Override
    public void onTick() {
        if (ExtraESP.mc.field_1687 == null || ExtraESP.mc.field_1724 == null) {
            return;
        }
        this.au();
        if (this.l.isEmpty()) {
            this.av();
            return;
        }
        ++this.k;
        if (this.ai || this.k % 120 == 0) {
            this.n.clear();
            this.ai = false;
        }
        if (++this.aw >= 1 && !this.e.get()) {
            this.aw = 0;
            this.aw();
        }
    }

    @Override
    public void onPacketReceive(class_2596<?> class_26722) {
        if (ExtraESP.mc.field_1687 == null) {
            return;
        }
        if (class_26722 instanceof class_2672) {
            class_26722 = class_26722;
            this.c(class_1923.method_8331((int)class_26722.method_11523(), (int)class_26722.method_11524()));
        } else if (class_26722 instanceof class_2637) {
            class_26722 = (class_2637)class_26722;
            class_26722.method_30621((BiConsumer<class_2338, class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)V, a(net.minecraft.class_2338 net.minecraft.class_2680 ), (Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V)((ExtraESP)this));
        } else if (class_26722 instanceof class_2626) {
            class_26722 = (class_2626)class_26722;
            this.c(new class_1923(class_26722.method_11309()).method_8324());
        }
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        a a2;
        class_2248 class_22482;
        Object object3;
        if (ExtraESP.mc.field_1687 == null || ExtraESP.mc.field_1724 == null || this.m.isEmpty()) {
            return;
        }
        Set set = this.l;
        if (set.isEmpty()) {
            return;
        }
        Object object2 = RenderUtils.getCamera();
        if (object2 == null) {
            return;
        }
        class_243 class_2432 = RenderUtils.getCameraPos((class_4184)object2);
        object2 = RenderUtils.getCameraForward((class_4184)object2);
        class_243 class_2433 = Freecam.resolveTracerOrigin(class_2432, f);
        class_2433 = class_2433.equals((Object)class_2432) ? object2.method_1021(0.1) : class_2433.method_1020(class_2432);
        double d2 = ExtraESP.mc.field_1724.method_23317();
        double d3 = ExtraESP.mc.field_1724.method_23321();
        this.e.clear();
        for (Set set2 : this.m.values()) {
            for (Object object3 : set2) {
                double d4;
                double d5 = (double)object3.method_10263() - d2;
                double d6 = d5 * d5 + (d4 = (double)object3.method_10260() - d3) * d4;
                if (d6 > 73984.0 || (class_22482 = (class_2248)this.n.get(object3)) == null || !set.contains(class_22482)) continue;
                this.e.add(new a((double)object3.method_10263() - class_2432.field_1352, (double)object3.method_10264() - class_2432.field_1351, (double)object3.method_10260() - class_2432.field_1350, d6, class_22482));
            }
        }
        if (this.e.isEmpty()) {
            return;
        }
        this.e.sort(Comparator.comparingDouble((ToDoubleFunction<a>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)D, a(com.water.module.modules.render.ExtraESP$a ), (Lcom/water/module/modules/render/ExtraESP$a;)D)()));
        int n = Math.min(this.e.size(), 5000);
        int n2 = ExtraESP.i((int)((int)Math.round((Double)this.bC.getValue())));
        int n3 = ExtraESP.i((int)((int)Math.round((Double)this.bD.getValue())));
        if (((Boolean)this.bA.getValue()).booleanValue() || n2 > 0) {
            object3 = RenderUtils.beginWorldBatch(class_45872);
            for (int i = n - 1; i >= 0; --i) {
                a2 = (a)this.e.get(i);
                Color color = this.a(a2.a, n2);
                Color color2 = this.a(a2.a, 255);
                Color color3 = this.a(a2.a, 70);
                Color color4 = this.a(a2.a, 145);
                ((RenderUtils.WorldBatch)object3).renderOutlineBox(a2.e + 0.0, a2.f + 0.0, a2.g + 0.0, a2.e + 1.0 - 0.0, a2.f + 1.0 - 0.0, a2.g + 1.0 - 0.0, color);
                if (!((Boolean)this.bA.getValue()).booleanValue()) continue;
                class_22482 = new class_243(a2.e + 0.5, a2.f + 0.5, a2.g + 0.5);
                ((RenderUtils.WorldBatch)object3).renderLine(color3, class_2433, (class_243)class_22482, ((Double)this.bB.getValue()).floatValue() + 2.4f);
                ((RenderUtils.WorldBatch)object3).renderLine(color4, class_2433, (class_243)class_22482, ((Double)this.bB.getValue()).floatValue() + 1.4f);
                ((RenderUtils.WorldBatch)object3).renderLine(color2, class_2433, (class_243)class_22482, ((Double)this.bB.getValue()).floatValue());
            }
            ((RenderUtils.WorldBatch)object3).flush();
        }
        if (n3 > 0) {
            object3 = RenderUtils.beginWorldBatch(class_45872);
            for (int i = n - 1; i >= 0; --i) {
                a2 = (a)this.e.get(i);
                ((RenderUtils.WorldBatch)object3).renderFilledBox(a2.e + 0.0, a2.f + 0.0, a2.g + 0.0, a2.e + 1.0 - 0.0, a2.f + 1.0 - 0.0, a2.g + 1.0 - 0.0, this.a(a2.a, n3));
            }
            ((RenderUtils.WorldBatch)object3).flush();
        }
    }

    private void method_0() {
        long l = this.b.getVersion();
        if (l == this.x) {
            return;
        }
        this.x = l;
        this.l = Set.copyOf(this.b.getSelectedBlocks());
        this.av();
        this.ai = true;
    }

    private void method_1() {
        if (!this.e.compareAndSet(false, true)) {
            return;
        }
        if (ExtraESP.mc.field_1687 == null || ExtraESP.mc.field_1724 == null) {
            this.e.set(false);
            return;
        }
        class_1923 class_19232 = ExtraESP.mc.field_1724.method_31476();
        int n = this.p();
        if (Math.abs(class_19232.field_9181 - this.ax) > 1 || Math.abs(class_19232.field_9180 - this.ay) > 1) {
            this.n.clear();
            this.ax = class_19232.field_9181;
            this.ay = class_19232.field_9180;
        }
        this.c = class_19232;
        this.av = n;
        ArrayList<class_2818> arrayList = new ArrayList<class_2818>();
        HashSet<Long> hashSet = new HashSet<Long>();
        try {
            for (int i = class_19232.field_9181 - n; i <= class_19232.field_9181 + n; ++i) {
                for (int j = class_19232.field_9180 - n; j <= class_19232.field_9180 + n; ++j) {
                    class_2818 class_28182 = ExtraESP.mc.field_1687.method_2935().method_12126(i, j, false);
                    if (class_28182 == null) continue;
                    long l = class_28182.method_12004().method_8324();
                    hashSet.add(l);
                    if (this.n.contains(l)) continue;
                    arrayList.add(class_28182);
                }
            }
        }
        catch (Throwable throwable) {
            this.e.set(false);
            return;
        }
        this.d(hashSet);
        this.a(class_19232, n);
        if (arrayList.isEmpty()) {
            this.e.set(false);
            return;
        }
        arrayList.sort(Comparator.comparingInt((ToIntFunction<class_2818>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)I, b(net.minecraft.class_1923 net.minecraft.class_2818 ), (Lnet/minecraft/class_2818;)I)((ExtraESP)this, (class_1923)class_19232)));
        this.d.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(java.util.List ), ()V)((ExtraESP)this, arrayList));
    }

    private void method_2(long l) {
        this.n.remove(l);
    }

    private void method_3(Set<Long> set) {
        ArrayList<Long> arrayList = new ArrayList<Long>();
        for (Long l : this.m.keySet()) {
            if (set.contains(l)) continue;
            arrayList.add(l);
        }
        for (Long l : arrayList) {
            this.b(l);
            this.o.remove(l);
            this.n.remove(l);
        }
    }

    private void method_4(class_2818 class_2826Array) {
        Set set = this.l;
        if (set.isEmpty() || ExtraESP.mc.field_1687 == null) {
            return;
        }
        int n = ExtraESP.mc.field_1687.method_31607();
        int n2 = ExtraESP.mc.field_1687.method_31607() + ExtraESP.mc.field_1687.method_31605();
        int n3 = ExtraESP.mc.field_1687.method_32891();
        class_1923 class_19232 = class_2826Array.method_12004();
        long l = class_19232.method_8324();
        Set set2 = (Set)this.m.get(l);
        HashSet<class_2338> hashSet = new HashSet<class_2338>();
        class_2248 class_22482 = null;
        class_2338 class_23382 = null;
        class_2826Array = class_2826Array.method_12006();
        for (int i = 0; i < class_2826Array.length; ++i) {
            int n4;
            class_2826 class_28262 = class_2826Array[i];
            if (class_28262 == null || class_28262.method_38292() || (n4 = (n3 + i) * 16) + 16 <= n || n4 >= n2 || !class_28262.method_12265().method_19526((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, b(java.util.Set net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)((Set)set))) continue;
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    for (int i2 = 0; i2 < 16; ++i2) {
                        class_2248 class_22483 = class_28262.method_12254(j, i2, k).method_26204();
                        if (!set.contains(class_22483)) continue;
                        class_2338 class_23383 = new class_2338(class_19232.method_8326() + j, n4 + i2, class_19232.method_8328() + k);
                        hashSet.add(class_23383);
                        this.n.put(class_23383, class_22483);
                        if (class_22482 != null || set2 != null && set2.contains(class_23383)) continue;
                        class_22482 = class_22483;
                        class_23382 = class_23383;
                    }
                }
            }
        }
        if (set2 != null && !hashSet.isEmpty()) {
            for (class_2826 class_28262 : set2) {
                if (hashSet.contains(class_28262)) continue;
                this.n.remove(class_28262);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        this.m.put(l, hashSet);
        if (class_22482 != null) {
            this.a(l, class_22482, class_23382);
        }
    }

    private void method_5(long l, class_2248 class_22482, class_2338 class_23382) {
        long l2;
        if (!((Boolean)this.bz.getValue()).booleanValue() || ExtraESP.mc.field_1724 == null || ExtraESP.mc.field_1687 == null || class_23382 == null) {
            return;
        }
        long l3 = System.currentTimeMillis();
        if (l3 - (l2 = this.o.getOrDefault(l, 0L).longValue()) < 900L) {
            return;
        }
        this.o.put(l, l3);
        ToastManager.INSTANCE.push(this.a(class_22482) + " found", "X " + class_23382.method_10263() + "  Y " + class_23382.method_10264() + "  Z " + class_23382.method_10260(), this.a(class_22482), this.a(class_22482, 255).getRGB());
        ExtraESP.mc.field_1687.method_43128((class_1297)ExtraESP.mc.field_1724, ExtraESP.mc.field_1724.method_23317(), ExtraESP.mc.field_1724.method_23318(), ExtraESP.mc.field_1724.method_23321(), class_3417.field_14627, class_3419.field_15250, 0.45f, 1.05f);
    }

    private void method_6() {
        this.m.clear();
        this.n.clear();
        this.o.clear();
        this.n.clear();
        Object object = this.b;
        synchronized (object) {
            this.b.clear();
            this.m.clear();
        }
    }

    private void method_7(class_1923 class_19232, int n) {
        ArrayList<Long> arrayList = new ArrayList<Long>();
        for (Long l : this.m.keySet()) {
            class_1923 class_19233 = new class_1923(class_1923.method_8325((long)l), class_1923.method_8332((long)l));
            if (Math.abs(class_19233.field_9181 - class_19232.field_9181) <= n && Math.abs(class_19233.field_9180 - class_19232.field_9180) <= n) continue;
            arrayList.add(l);
        }
        for (Long l : arrayList) {
            this.b(l);
            this.o.remove(l);
        }
    }

    private void method_8(long l) {
        Set set = (Set)this.m.remove(l);
        if (set != null) {
            set.forEach(this.n::remove);
        }
    }

    private class_1799 method_9(class_2248 class_22482) {
        return (class_22482 = new class_1799((class_1935)class_22482.method_8389())).method_7960() ? class_1799.field_8037 : class_22482;
    }

    private Color method_10(class_2248 class_22482, int n) {
        Object object = (Color)this.p.get(class_22482);
        if (object != null) {
            return new Color(((Color)object).getRed(), ((Color)object).getGreen(), ((Color)object).getBlue(), n);
        }
        object = class_7923.field_41175.method_10221((Object)class_22482);
        Object object2 = object = object == null ? "" : object.method_12832();
        if (class_22482 == class_2246.field_10260) {
            return new Color(138, 126, 166, n);
        }
        if (((String)object).contains("diamond")) {
            return new Color(0, 255, 255, n);
        }
        if (((String)object).contains("ancient_debris")) {
            return new Color(196, 120, 72, n);
        }
        if (((String)object).contains("emerald")) {
            return new Color(0, 255, 127, n);
        }
        if (((String)object).contains("gold")) {
            return new Color(255, 215, 0, n);
        }
        if (((String)object).contains("iron")) {
            return new Color(213, 213, 213, n);
        }
        if (((String)object).contains("redstone")) {
            return new Color(255, 70, 70, n);
        }
        if (((String)object).contains("lapis")) {
            return new Color(70, 110, 255, n);
        }
        if (((String)object).contains("chest")) {
            return new Color(210, 140, 60, n);
        }
        if (((String)object).contains("barrel")) {
            return new Color(200, 130, 100, n);
        }
        return new Color(177, 92, 255, n);
    }

    public void method_11(Map<class_2248, Color> object) {
        this.p.clear();
        if (object != null) {
            for (Map.Entry entry : object.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) continue;
                this.p.put((class_2248)entry.getKey(), (Color)entry.getValue());
            }
        }
        ModuleManager.INSTANCE.c();
    }

    public Map<class_2248, Color> method_12() {
        return new LinkedHashMap<class_2248, Color>(this.p);
    }

    private String method_13(class_2248 class_22482) {
        try {
            return class_22482.method_9518().getString();
        }
        catch (Throwable throwable) {
            class_22482 = class_7923.field_41175.method_10221((Object)class_22482);
            return class_22482 == null ? "Block" : class_22482.method_12832();
        }
    }

    private int method_14(class_1923 class_19232, class_1923 class_19233) {
        int n = class_19233.field_9181 - class_19232.field_9181;
        int n2 = class_19233.field_9180 - class_19232.field_9180;
        return n * n + n2 * n2;
    }

    private int method_15() {
        return 20;
    }

    private static int method_16(int n) {
        return Math.max(0, Math.min(255, n));
    }

    private static /* synthetic */ boolean method_17(Set set, class_2680 class_26802) {
        return set.contains(class_26802.method_26204());
    }

    private /* synthetic */ void method_18(List object) {
        try {
            object = object.iterator();
            while (object.hasNext()) {
                class_2818 class_28182 = (class_2818)object.next();
                this.a(class_28182);
                this.n.add(class_28182.method_12004().method_8324());
            }
        }
        finally {
            this.e.set(false);
        }
    }

    private /* synthetic */ int method_19(class_1923 class_19232, class_2818 class_28182) {
        return this.b(class_19232, class_28182.method_12004());
    }

    private static /* synthetic */ double method_20(a a2) {
        return a2.h;
    }

    private /* synthetic */ void method_21(class_2338 class_23382, class_2680 class_26802) {
        this.c(new class_1923(class_23382).method_8324());
    }

    private static final class a {
        final double field_0;
        final double field_1;
        final double field_2;
        final double field_3;
        final class_2248 field_4;

        a(double d2, double d3, double d4, double d5, class_2248 class_22482) {
            this.e = d2;
            this.f = d3;
            this.g = d4;
            this.h = d5;
            this.a = class_22482;
        }
    }
}

