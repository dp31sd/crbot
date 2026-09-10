/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.module.Category;
import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.render.Freecam;
import com.water.setting.BlocksSetting;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
import net.minecraft.class_1923;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_2595;
import net.minecraft.class_2596;
import net.minecraft.class_2605;
import net.minecraft.class_2611;
import net.minecraft.class_2614;
import net.minecraft.class_2626;
import net.minecraft.class_2627;
import net.minecraft.class_2636;
import net.minecraft.class_2637;
import net.minecraft.class_2646;
import net.minecraft.class_2669;
import net.minecraft.class_2672;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_3719;
import net.minecraft.class_3720;
import net.minecraft.class_3723;
import net.minecraft.class_3866;
import net.minecraft.class_4184;
import net.minecraft.class_4587;

public final class StorageESP
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Boolean> field_3;
    private final Setting<Boolean> field_4;
    private final Setting<Boolean> field_5;
    private final Setting<Boolean> field_6;
    private final Setting<Boolean> field_7;
    private final Setting<Boolean> field_8;
    private final Setting<Boolean> field_9;
    private final Setting<Boolean> field_10;
    private final Setting<Boolean> field_11;
    private final Setting<Double> field_12;
    private final Setting<Double> field_13;
    private final Setting<Double> field_14;
    private final BlocksSetting field_15;
    private final Map<class_2248, Color> field_16;
    private final Map<class_2338, class_2248> field_17;
    private final Map<class_2338, Color> field_18;
    private final ExecutorService field_19;
    private final AtomicBoolean field_20;
    private int field_21;
    private final Set<Long> field_22;
    private int field_23;
    private int field_24;
    private RenderUtils.PersistentBatch field_25;
    private RenderUtils.PersistentBatch field_26;
    private boolean field_27;
    private boolean field_28;
    private boolean field_29;
    private boolean field_30;
    private boolean field_31;
    private boolean field_32;
    private boolean field_33;
    private boolean field_34;
    private boolean field_35;
    private boolean field_36;
    private int field_37;

    public StorageESP() {
        super("Storage ESP", Category.b);
        this.cp = new Setting<Boolean>("New Style", true);
        this.cq = new Setting<Boolean>("Chest", true);
        this.cr = new Setting<Boolean>("Ender Chest", true);
        this.cs = new Setting<Boolean>("Spawner", true);
        this.ct = new Setting<Boolean>("Shulker Box", true);
        this.cu = new Setting<Boolean>("Use Shulker Dyes", true);
        this.cv = new Setting<Boolean>("Furnace", true);
        this.cw = new Setting<Boolean>("Barrel", true);
        this.cx = new Setting<Boolean>("Enchanting Table", true);
        this.cy = new Setting<Boolean>("Moving Piston", true);
        this.cz = new Setting<Boolean>("Hopper", true);
        this.cA = new Setting<Boolean>("Tracers", true);
        this.cB = new Setting<Double>("Tracer Weight", 0.3, 0.1, 2.0);
        this.cC = new Setting<Double>("Fill Alpha", 15.0, 0.0, 255.0);
        this.cD = new Setting<Double>("Opacity", 220.0, 0.0, 255.0);
        this.c = new BlocksSetting("Blocks", new class_2248[0]);
        this.u = new ConcurrentHashMap();
        this.v = new ConcurrentHashMap();
        this.w = new ConcurrentHashMap();
        this.e = Executors.newFixedThreadPool(Math.max(2, Math.min(4, Runtime.getRuntime().availableProcessors())), runnable -> {
            runnable = new Thread(runnable, "storageESP-scan");
            ((Thread)runnable).setDaemon(true);
            ((Thread)runnable).setPriority(5);
            return runnable;
        });
        this.h = new AtomicBoolean(false);
        this.aw = 0;
        this.u = Collections.synchronizedSet(new HashSet());
        this.ax = Integer.MIN_VALUE;
        this.ay = Integer.MIN_VALUE;
        this.aw = true;
        this.bi = 0;
        this.addSetting(this.cp);
        this.addSetting(this.cq);
        this.addSetting(this.cr);
        this.addSetting(this.cs);
        this.addSetting(this.ct);
        this.addSetting(this.cu);
        this.addSetting(this.cv);
        this.addSetting(this.cw);
        this.addSetting(this.cx);
        this.addSetting(this.cy);
        this.addSetting(this.cz);
        this.addSetting(this.cA);
        this.addSetting(this.cB);
        this.addSetting(this.cC);
        this.addSetting(this.cD);
        this.addSetting(this.c);
    }

    public Map<class_2248, Color> method_0() {
        LinkedHashMap<class_2248, Color> linkedHashMap = new LinkedHashMap<class_2248, Color>();
        if (((Boolean)this.cq.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_10034, this.u.getOrDefault(class_2246.field_10034, new Color(210, 140, 60)));
            linkedHashMap.put(class_2246.field_10380, this.u.getOrDefault(class_2246.field_10380, new Color(220, 120, 40)));
        }
        if (((Boolean)this.cr.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_10443, this.u.getOrDefault(class_2246.field_10443, new Color(140, 80, 220)));
        }
        if (((Boolean)this.cs.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_10260, this.u.getOrDefault(class_2246.field_10260, new Color(160, 150, 180)));
        }
        if (((Boolean)this.ct.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_10268, this.u.getOrDefault(class_2246.field_10268, new Color(160, 60, 180)));
        }
        if (((Boolean)this.cv.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_10181, this.u.getOrDefault(class_2246.field_10181, new Color(150, 150, 150)));
        }
        if (((Boolean)this.cw.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_16328, this.u.getOrDefault(class_2246.field_16328, new Color(200, 130, 100)));
        }
        if (((Boolean)this.cx.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_10485, this.u.getOrDefault(class_2246.field_10485, new Color(100, 100, 240)));
        }
        if (((Boolean)this.cy.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_10560, this.u.getOrDefault(class_2246.field_10560, new Color(80, 200, 80)));
        }
        if (((Boolean)this.cz.getValue()).booleanValue()) {
            linkedHashMap.put(class_2246.field_10312, this.u.getOrDefault(class_2246.field_10312, new Color(120, 120, 120)));
        }
        return linkedHashMap;
    }

    public void method_1(class_2248 class_22482, Color color) {
        if (class_22482 == null || color == null) {
            return;
        }
        this.u.put(class_22482, color);
        this.bb();
        ModuleManager.INSTANCE.c();
    }

    public Map<class_2248, Color> method_2() {
        return new LinkedHashMap<class_2248, Color>(this.u);
    }

    public void method_3(Map<class_2248, Color> object) {
        this.u.clear();
        if (object != null) {
            for (Map.Entry entry : object.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) continue;
                this.u.put((class_2248)entry.getKey(), (Color)entry.getValue());
            }
        }
        this.bb();
        ModuleManager.INSTANCE.c();
    }

    private void method_4() {
        this.w.clear();
        this.u.clear();
    }

    @Override
    public void onEnable() {
        this.v.clear();
        this.w.clear();
        this.u.clear();
        this.aw = 0;
        this.a = RenderUtils.createPersistentBatch();
        this.b = RenderUtils.createPersistentBatch();
        this.an = (Boolean)this.cq.getValue();
        this.ao = (Boolean)this.cr.getValue();
        this.ap = (Boolean)this.cs.getValue();
        this.aq = (Boolean)this.ct.getValue();
        this.ar = (Boolean)this.cv.getValue();
        this.as = (Boolean)this.cw.getValue();
        this.at = (Boolean)this.cx.getValue();
        this.au = (Boolean)this.cy.getValue();
        this.av = (Boolean)this.cz.getValue();
        this.aw = (Boolean)this.cp.getValue();
    }

    @Override
    public void onDisable() {
        this.v.clear();
        this.w.clear();
        this.u.clear();
        if (this.a != null) {
            this.a.close();
            this.a = null;
        }
        if (this.b != null) {
            this.b.close();
            this.b = null;
        }
    }

    private void method_5() {
        boolean bl;
        boolean bl2 = bl = (Boolean)this.cq.getValue() != this.an || (Boolean)this.cr.getValue() != this.ao || (Boolean)this.cs.getValue() != this.ap || (Boolean)this.ct.getValue() != this.aq || (Boolean)this.cv.getValue() != this.ar || (Boolean)this.cw.getValue() != this.as || (Boolean)this.cx.getValue() != this.at || (Boolean)this.cy.getValue() != this.au || (Boolean)this.cz.getValue() != this.av || (Boolean)this.cp.getValue() != this.aw;
        if (bl) {
            this.v.clear();
            this.w.clear();
            this.u.clear();
            this.an = (Boolean)this.cq.getValue();
            this.ao = (Boolean)this.cr.getValue();
            this.ap = (Boolean)this.cs.getValue();
            this.aq = (Boolean)this.ct.getValue();
            this.ar = (Boolean)this.cv.getValue();
            this.as = (Boolean)this.cw.getValue();
            this.at = (Boolean)this.cx.getValue();
            this.au = (Boolean)this.cy.getValue();
            this.av = (Boolean)this.cz.getValue();
            this.aw = (Boolean)this.cp.getValue();
        }
    }

    @Override
    public void onTick() {
        if (StorageESP.mc.field_1687 == null || StorageESP.mc.field_1724 == null) {
            this.v.clear();
            this.w.clear();
            return;
        }
        this.bc();
        this.bd();
        if (++this.bi >= 5) {
            this.bi = 0;
            if (StorageESP.mc.field_1724 != null) {
                int n = StorageESP.mc.field_1724.method_31476().field_9181;
                int n2 = StorageESP.mc.field_1724.method_31476().field_9180;
                for (int i = -2; i <= 2; ++i) {
                    for (int j = -2; j <= 2; ++j) {
                        this.c(class_1923.method_8331((int)(n + i), (int)(n2 + j)));
                    }
                }
            }
        }
        if (++this.aw >= 1 && !this.h.get()) {
            this.aw = 0;
            this.aw();
        }
    }

    @Override
    public void onPacketReceive(class_2596<?> class_26722) {
        if (StorageESP.mc.field_1687 == null) {
            return;
        }
        if (class_26722 instanceof class_2672) {
            class_26722 = class_26722;
            this.c(class_1923.method_8331((int)class_26722.method_11523(), (int)class_26722.method_11524()));
        } else if (class_26722 instanceof class_2637) {
            class_26722 = (class_2637)class_26722;
            class_26722.method_30621((BiConsumer<class_2338, class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)V, a(net.minecraft.class_2338 net.minecraft.class_2680 ), (Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V)((StorageESP)this));
        } else if (class_26722 instanceof class_2626) {
            class_26722 = (class_2626)class_26722;
            this.c(new class_1923(class_26722.method_11309()).method_8324());
        }
    }

    private void method_6() {
        this.h.set(true);
        if (StorageESP.mc.field_1687 == null || StorageESP.mc.field_1724 == null) {
            this.h.set(false);
            return;
        }
        class_2338 class_23382 = StorageESP.mc.field_1724.method_24515();
        int n = class_23382.method_10263() >> 4;
        int n2 = class_23382.method_10260() >> 4;
        if (Math.abs(n - this.ax) > 1 || Math.abs(n2 - this.ay) > 1) {
            this.u.clear();
            this.ax = n;
            this.ay = n2;
        }
        boolean bl = this.c.size() > 0;
        ArrayList<class_2818> arrayList = new ArrayList<class_2818>();
        try {
            for (int i = n - 20; i <= n + 20; ++i) {
                for (int j = n2 - 20; j <= n2 + 20; ++j) {
                    long l;
                    class_2818 class_28182 = StorageESP.mc.field_1687.method_2935().method_12126(i, j, false);
                    if (class_28182 == null || this.u.contains(l = (long)i << 32 | (long)j & 0xFFFFFFFFL)) continue;
                    arrayList.add(class_28182);
                }
            }
        }
        catch (Exception exception) {
            this.h.set(false);
            return;
        }
        if (arrayList.isEmpty()) {
            this.h.set(false);
            return;
        }
        this.e.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(java.util.List boolean ), ()V)((StorageESP)this, arrayList, (boolean)bl));
    }

    private void method_7() {
        if (StorageESP.mc.field_1724 == null) {
            return;
        }
        int n = StorageESP.mc.field_1724.method_31476().field_9181;
        int n2 = StorageESP.mc.field_1724.method_31476().field_9180;
        this.v.keySet().removeIf((Predicate<class_2338>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, b(int int net.minecraft.class_2338 ), (Lnet/minecraft/class_2338;)Z)((int)n, (int)n2));
        this.w.keySet().removeIf((Predicate<class_2338>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(int int net.minecraft.class_2338 ), (Lnet/minecraft/class_2338;)Z)((int)n, (int)n2));
        this.u.removeIf((Predicate<Long>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(int int java.lang.Long ), (Ljava/lang/Long;)Z)((int)n, (int)n2));
    }

    private void method_8(long l) {
        this.u.remove(l);
    }

    private boolean method_9(class_2586 class_25862) {
        if (class_25862 instanceof class_2595 && ((Boolean)this.cq.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_2646 && ((Boolean)this.cq.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_2611 && ((Boolean)this.cr.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_2636 && ((Boolean)this.cs.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_2627 && ((Boolean)this.ct.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_3866 && ((Boolean)this.cv.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_3720 && ((Boolean)this.cv.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_3723 && ((Boolean)this.cv.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_3719 && ((Boolean)this.cw.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_2605 && ((Boolean)this.cx.getValue()).booleanValue()) {
            return true;
        }
        if (class_25862 instanceof class_2669 && ((Boolean)this.cy.getValue()).booleanValue()) {
            return true;
        }
        return class_25862 instanceof class_2614 && (Boolean)this.cz.getValue() != false;
    }

    private Color method_10(class_2586 object) {
        class_2248 class_22482 = object.method_11010().method_26204();
        if (this.u.containsKey(class_22482)) {
            return (Color)this.u.get(class_22482);
        }
        if (object instanceof class_2627 && ((Boolean)this.ct.getValue()).booleanValue()) {
            if (((Boolean)this.cu.getValue()).booleanValue() && (object = this.a(class_22482)) != null) {
                return object;
            }
            return new Color(160, 60, 180);
        }
        if (object instanceof class_2646) {
            return new Color(220, 120, 40);
        }
        if (object instanceof class_2595) {
            return new Color(210, 140, 60);
        }
        if (object instanceof class_2611) {
            return new Color(140, 80, 220);
        }
        if (object instanceof class_2636) {
            return new Color(160, 150, 180);
        }
        if (object instanceof class_3866 || object instanceof class_3720 || object instanceof class_3723) {
            return new Color(150, 150, 150);
        }
        if (object instanceof class_3719) {
            return new Color(200, 130, 100);
        }
        if (object instanceof class_2605) {
            return new Color(100, 100, 240);
        }
        if (object instanceof class_2669) {
            return new Color(80, 200, 80);
        }
        if (object instanceof class_2614) {
            return new Color(120, 120, 120);
        }
        return new Color(100, 200, 255);
    }

    private Color method_11(class_2248 class_22482) {
        if (class_22482 == class_2246.field_10199) {
            return new Color(15789802);
        }
        if (class_22482 == class_2246.field_10407) {
            return new Color(15242794);
        }
        if (class_22482 == class_2246.field_10063) {
            return new Color(12274357);
        }
        if (class_22482 == class_2246.field_10203) {
            return new Color(3845832);
        }
        if (class_22482 == class_2246.field_10600) {
            return new Color(15253016);
        }
        if (class_22482 == class_2246.field_10275) {
            return new Color(6991400);
        }
        if (class_22482 == class_2246.field_10051) {
            return new Color(14708912);
        }
        if (class_22482 == class_2246.field_10140) {
            return new Color(4738128);
        }
        if (class_22482 == class_2246.field_10320) {
            return new Color(10000544);
        }
        if (class_22482 == class_2246.field_10532) {
            return new Color(0x228888);
        }
        if (class_22482 == class_2246.field_10268) {
            return new Color(7878832);
        }
        if (class_22482 == class_2246.field_10605) {
            return new Color(2767016);
        }
        if (class_22482 == class_2246.field_10373) {
            return new Color(7883824);
        }
        if (class_22482 == class_2246.field_10055) {
            return new Color(5005344);
        }
        if (class_22482 == class_2246.field_10068) {
            return new Color(9969696);
        }
        if (class_22482 == class_2246.field_10371) {
            return new Color(0x1A1A22);
        }
        return null;
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        class_4184 class_41842;
        if (StorageESP.mc.field_1687 == null || StorageESP.mc.field_1724 == null || this.v.isEmpty()) {
            return;
        }
        if (this.a == null) {
            this.a = RenderUtils.createPersistentBatch();
        }
        if (this.b == null) {
            this.b = RenderUtils.createPersistentBatch();
        }
        if ((class_41842 = RenderUtils.getCamera()) == null) {
            return;
        }
        class_243 class_2432 = RenderUtils.getCameraPos(class_41842);
        class_41842 = RenderUtils.getCameraForward(class_41842);
        class_243 class_2433 = Freecam.resolveTracerOrigin(class_2432, f);
        class_2433 = class_2433.equals((Object)class_2432) ? class_41842.method_1021(0.1) : class_2433.method_1020(class_2432);
        double d2 = StorageESP.mc.field_1724.method_23317();
        StorageESP.mc.field_1724.method_23318();
        double d3 = StorageESP.mc.field_1724.method_23321();
        if (((Boolean)this.cp.getValue()).booleanValue()) {
            Object object;
            int n = this.k((int)Math.round((Double)this.cC.getValue()));
            if (((Boolean)this.cA.getValue()).booleanValue()) {
                float f2 = ((Double)this.cB.getValue()).floatValue();
                this.b.begin(class_45872);
                for (Map.Entry object2 : this.v.entrySet()) {
                    double d4;
                    double d5;
                    object = (class_2338)object2.getKey();
                    Color entry = (Color)this.w.get(object);
                    if (entry == null || (d5 = (double)object.method_10263() - d2) * d5 + (d4 = (double)object.method_10260() - d3) * d4 > 73984.0) continue;
                    double d6 = (double)object.method_10263() - class_2432.field_1352;
                    double d7 = (double)object.method_10264() - class_2432.field_1351;
                    double d8 = (double)object.method_10260() - class_2432.field_1350;
                    if (!Double.isFinite(d6) || !Double.isFinite(d7) || !Double.isFinite(d8)) continue;
                    class_243 class_2434 = new class_243(d6 + 0.5, d7 + 0.5, d8 + 0.5);
                    this.b.addLine(class_2433, class_2434, StorageESP.a((Color)entry, (int)70), f2 + 2.4f);
                    this.b.addLine(class_2433, class_2434, StorageESP.a((Color)entry, (int)145), f2 + 1.4f);
                    this.b.addLine(class_2433, class_2434, StorageESP.a((Color)entry, (int)255), f2);
                }
                this.b.flush();
            }
            this.a.begin(class_45872);
            for (Map.Entry entry : this.v.entrySet()) {
                double d8;
                double d9;
                class_2338 class_23382 = (class_2338)entry.getKey();
                object = (Color)this.w.get(class_23382);
                if (object == null || (d9 = (double)class_23382.method_10263() - d2) * d9 + (d8 = (double)class_23382.method_10260() - d3) * d8 > 73984.0) continue;
                double d10 = (double)class_23382.method_10263() - class_2432.field_1352;
                double d11 = (double)class_23382.method_10264() - class_2432.field_1351;
                double d12 = (double)class_23382.method_10260() - class_2432.field_1350;
                if (!Double.isFinite(d10) || !Double.isFinite(d11) || !Double.isFinite(d12) || n <= 0) continue;
                this.a.addFilledBox(d10 + 0.1, d11 + 0.1, d12 + 0.1, d10 + 0.9, d11 + 0.9, d12 + 0.9, StorageESP.a((Color)object, (int)n));
            }
            this.a.flushFill();
        } else {
            int n = this.k((int)Math.round((Double)this.cD.getValue()));
            int n2 = this.k((int)Math.round((Double)this.cC.getValue()));
            RenderUtils.WorldBatch worldBatch = RenderUtils.beginWorldBatch(class_45872);
            RenderUtils.WorldBatch worldBatch2 = n2 > 0 ? RenderUtils.beginWorldBatch(class_45872) : null;
            for (Map.Entry entry : this.v.entrySet()) {
                double d13;
                double d14;
                class_2338 class_23383 = (class_2338)entry.getKey();
                Color color = (Color)this.w.get(class_23383);
                if (color == null || (d14 = (double)class_23383.method_10263() - d2) * d14 + (d13 = (double)class_23383.method_10260() - d3) * d13 > 73984.0) continue;
                double d15 = (double)class_23383.method_10263() - class_2432.field_1352;
                double d17 = (double)class_23383.method_10264() - class_2432.field_1351;
                double d18 = (double)class_23383.method_10260() - class_2432.field_1350;
                if (!Double.isFinite(d15) || !Double.isFinite(d17) || !Double.isFinite(d18)) continue;
                worldBatch.renderOutlineBox(d15 + 0.0625, d17, d18 + 0.0625, d15 + 0.9375, d17 + 1.0, d18 + 0.9375, StorageESP.a((Color)color, (int)n));
                if (worldBatch2 != null) {
                    worldBatch2.renderFilledBox(d15 + 0.0625, d17, d18 + 0.0625, d15 + 0.9375, d17 + 1.0, d18 + 0.9375, StorageESP.a((Color)color, (int)n2));
                }
                if (!((Boolean)this.cA.getValue()).booleanValue()) continue;
                class_45872 = new class_243(d15 + 0.5, d17 + 0.5, d18 + 0.5);
                worldBatch.renderLine(StorageESP.a((Color)color, (int)70), class_2433, (class_243)class_45872, ((Double)this.cB.getValue()).floatValue() + 2.4f);
                worldBatch.renderLine(StorageESP.a((Color)color, (int)145), class_2433, (class_243)class_45872, ((Double)this.cB.getValue()).floatValue() + 1.4f);
                worldBatch.renderLine(StorageESP.a((Color)color, (int)255), class_2433, (class_243)class_45872, ((Double)this.cB.getValue()).floatValue());
            }
            if (worldBatch2 != null) {
                worldBatch2.flush();
            }
            worldBatch.flush();
        }
    }

    private static Color method_12(Color color, int n) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), n);
    }

    private int method_13(int n) {
        return Math.max(0, Math.min(255, n));
    }

    private static /* synthetic */ boolean method_14(int n, int n2, Long l) {
        return Math.max(Math.abs(class_1923.method_8325((long)l) - n), Math.abs(class_1923.method_8332((long)l) - n2)) > 20;
    }

    private static /* synthetic */ boolean method_15(int n, int n2, class_2338 class_23382) {
        return Math.max(Math.abs((class_23382.method_10263() >> 4) - n), Math.abs((class_23382.method_10260() >> 4) - n2)) > 20;
    }

    private static /* synthetic */ boolean method_16(int n, int n2, class_2338 class_23382) {
        return Math.max(Math.abs((class_23382.method_10263() >> 4) - n), Math.abs((class_23382.method_10260() >> 4) - n2)) > 20;
    }

    private /* synthetic */ void method_17(List list, boolean bl) {
        try {
            HashMap<class_2338, class_2248> hashMap = new HashMap<class_2338, class_2248>();
            HashMap<class_2338, Color> hashMap2 = new HashMap<class_2338, Color>();
            for (class_2818 class_28182 : list) {
                try {
                    for (Map.Entry entry : new HashMap(class_28182.method_12214()).entrySet()) {
                        class_2586 class_25862 = (class_2586)entry.getValue();
                        if (class_25862 == null || !this.b(class_25862)) continue;
                        hashMap.put((class_2338)entry.getKey(), class_25862.method_11010().method_26204());
                        hashMap2.put((class_2338)entry.getKey(), this.a(class_25862));
                    }
                }
                catch (Exception exception) {}
                if (!bl) continue;
                try {
                    class_2826[] class_2826Array = class_28182.method_12006();
                    int n = class_28182.method_31607();
                    int n2 = class_28182.method_12004().field_9181 << 4;
                    int n3 = class_28182.method_12004().field_9180 << 4;
                    for (int i = 0; i < class_2826Array.length; ++i) {
                        class_2826 class_28262 = class_2826Array[i];
                        if (class_28262 == null || class_28262.method_38292()) continue;
                        int n4 = n + i * 16;
                        for (int j = 0; j < 16; ++j) {
                            for (int k = 0; k < 16; ++k) {
                                for (int i2 = 0; i2 < 16; ++i2) {
                                    class_2338 class_23382;
                                    class_2248 class_22482 = class_28262.method_12254(j, i2, k).method_26204();
                                    if (!this.c.contains(class_22482) || hashMap.containsKey(class_23382 = new class_2338(n2 + j, n4 + i2, n3 + k))) continue;
                                    hashMap.put(class_23382, class_22482);
                                    hashMap2.put(class_23382, this.u.getOrDefault(class_22482, new Color(0, 200, 255)));
                                }
                            }
                        }
                    }
                }
                catch (Exception exception) {
                }
            }
            this.v.putAll(hashMap);
            this.w.putAll(hashMap2);
            for (class_2818 class_28183 : list) {
                this.u.add(class_28183.method_12004().method_8324());
            }
            this.bd();
        }
        catch (Exception exception) {
        }
        finally {
            this.h.set(false);
        }
    }

    private /* synthetic */ void method_18(class_2338 class_23382, class_2680 class_26802) {
        this.c(new class_1923(class_23382).method_8324());
    }
}

