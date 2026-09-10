/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.class_1297;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1923;
import net.minecraft.class_1935;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2680;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4184;
import net.minecraft.class_4587;

public final class ActivityDebug
extends Module {
    private final Setting<Float> field_0;
    private final Setting<Boolean> field_1;
    private final Set<class_1923> field_2;
    private final Map<Long, Long> field_3;
    private static final Color field_4;
    private static final Color field_5;
    private final Map<Class<?>, List<Field>> field_6;
    private final Map<Class<?>, List<Field>> field_7;
    private final Map<Class<?>, List<Field>> field_8;
    private final Map<Class<?>, List<Field>> field_9;
    private final ThreadLocal<Set<Integer>> field_10;

    public ActivityDebug() {
        super("ActivityDebug", Category.d);
        this.bh = new Setting<Float>("y-level", Float.valueOf(16.0f), Float.valueOf(-64.0f), Float.valueOf(320.0f));
        this.bi = new Setting<Boolean>("Notification", false);
        this.b = Collections.newSetFromMap(new ConcurrentHashMap());
        this.b = new ConcurrentHashMap();
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.a = ThreadLocal.withInitial((Supplier<Set>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, a(), ()Ljava/util/Set;)());
        this.addSetting(this.bh);
        this.addSetting(this.bi);
    }

    @Override
    public void onDisable() {
        this.b.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
    }

    @Override
    public void onPacketReceive(class_2596<?> class_26372) {
        if (class_26372 instanceof class_2637) {
            class_26372 = class_26372;
            class_26372.method_30621((BiConsumer<class_2338, class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)V, a(net.minecraft.class_2338 net.minecraft.class_2680 ), (Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V)((ActivityDebug)this));
            return;
        }
        if (class_26372 instanceof class_2626) {
            class_26372 = (class_2626)class_26372;
            class_26372 = class_26372.method_11309();
            this.a(class_26372.method_10263(), class_26372.method_10264(), class_26372.method_10260());
            return;
        }
        ((Set)this.a.get()).clear();
        this.a(class_26372, 0);
    }

    private void method_0(Object object, int n) {
        Object object22;
        if (object == null || n > 3) {
            return;
        }
        int n2 = System.identityHashCode(object);
        if (!((Set)this.a.get()).add(n2)) {
            return;
        }
        Class<?> clazz = object.getClass();
        this.e.computeIfAbsent(clazz, (Function<Class, List>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, d(java.lang.Class ), (Ljava/lang/Class;)Ljava/util/List;)((ActivityDebug)this));
        this.f.computeIfAbsent(clazz, (Function<Class, List>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, c(java.lang.Class ), (Ljava/lang/Class;)Ljava/util/List;)((ActivityDebug)this));
        this.c.computeIfAbsent(clazz, (Function<Class, List>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, b(java.lang.Class ), (Ljava/lang/Class;)Ljava/util/List;)((ActivityDebug)this));
        this.d.computeIfAbsent(clazz, (Function<Class, List>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, a(java.lang.Class ), (Ljava/lang/Class;)Ljava/util/List;)());
        for (Field field : (List)this.e.get(clazz)) {
            try {
                object22 = (class_2338)field.get(object);
                if (object22 == null) continue;
                this.a(object22.method_10263(), object22.method_10264(), object22.method_10260());
            }
            catch (Exception exception) {}
        }
        for (Field field : (List)this.f.get(clazz)) {
            try {
                object22 = (class_243)field.get(object);
                if (object22 == null) continue;
                this.a(((class_243)object22).field_1352, ((class_243)object22).field_1351, ((class_243)object22).field_1350);
            }
            catch (Exception exception) {}
        }
        List list = (List)this.c.get(clazz);
        if (list.size() >= 3) {
            try {
                double d2 = ((Field)list.get(0)).getDouble(object);
                double d3 = ((Field)list.get(1)).getDouble(object);
                double d4 = ((Field)list.get(2)).getDouble(object);
                if (Math.abs(d2) < 3.0E7 && Math.abs(d4) < 3.0E7 && d3 > -2048.0 && d3 < 2048.0) {
                    this.a(d2, d3, d4);
                }
            }
            catch (Exception exception) {}
        }
        for (Object object22 : (List)this.d.get(clazz)) {
            try {
                Object object3 = ((Field)object22).get(object);
                if (object3 == null) continue;
                this.a(object3, n + 1);
            }
            catch (Exception exception) {}
        }
    }

    private List<Field> method_1(Class<?> clazz, Class<?> clazz2) {
        ArrayList<Field> arrayList = new ArrayList<Field>();
        while (clazz != null && clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType() != clazz2) continue;
                field.setAccessible(true);
                arrayList.add(field);
            }
            clazz = clazz.getSuperclass();
        }
        return arrayList;
    }

    private void method_2(double d2, double d3, double d4) {
        class_1923 class_19232;
        if (ActivityDebug.mc.field_1724 != null && ActivityDebug.mc.field_1724.method_23318() < 0.0) {
            return;
        }
        if (d3 <= (double)((Float)this.bh.getValue()).floatValue() && this.b.add(class_19232 = new class_1923((int)Math.floor(d2) >> 4, (int)Math.floor(d4) >> 4))) {
            this.a(class_19232, d3);
        }
    }

    private void method_3(class_1923 class_19232, double d2) {
        long l;
        if (!((Boolean)this.bi.getValue()).booleanValue() || ActivityDebug.mc.field_1724 == null || ActivityDebug.mc.field_1687 == null) {
            return;
        }
        long l2 = class_19232.method_8324();
        long l3 = System.currentTimeMillis();
        if (l3 - (l = this.b.getOrDefault(l2, 0L).longValue()) < 1250L) {
            return;
        }
        this.b.put(l2, l3);
        ToastManager.INSTANCE.push("Activity detected", "Chunk " + class_19232.field_9181 + ", " + class_19232.field_9180 + "  Y " + (int)Math.floor(d2), new class_1799((class_1935)class_1802.field_8251), c.getRGB());
        ActivityDebug.mc.field_1687.method_43128((class_1297)ActivityDebug.mc.field_1724, ActivityDebug.mc.field_1724.method_23317(), ActivityDebug.mc.field_1724.method_23318(), ActivityDebug.mc.field_1724.method_23321(), class_3417.field_14627, class_3419.field_15250, 0.6f, 1.05f);
    }

    @Override
    public void onRender(class_4587 object, float f) {
        if (ActivityDebug.mc.field_1687 == null) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        double d2 = Math.max((double)ActivityDebug.mc.field_1687.method_31607(), Math.min(57.0, (double)ActivityDebug.mc.field_1687.method_31600()));
        object = RenderUtils.beginWorldBatch((class_4587)object);
        for (class_1923 class_19232 : this.b) {
            if (!RenderUtils.isWorldBoxVisible(class_19232.method_8326(), 57.0, class_19232.method_8328(), class_19232.method_8327(), 57.05, class_19232.method_8329())) continue;
            double d3 = (double)class_19232.method_8326() - class_41842.field_1352;
            double d4 = (double)class_19232.method_8328() - class_41842.field_1350;
            double d5 = d2 - class_41842.field_1351;
            double d6 = d3 + 16.0;
            double d7 = d5 + 0.05;
            double d8 = d4 + 16.0;
            ((RenderUtils.WorldBatch)object).renderFilledBox(d3, d5, d4, d6, d7, d8, b);
        }
        ((RenderUtils.WorldBatch)object).flush();
    }

    private static /* synthetic */ List method_4(Class clazz) {
        ArrayList<Field> arrayList = new ArrayList<Field>();
        while (clazz != null && clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType().isPrimitive() || field.getType().getName().startsWith("java.") || field.getType().isEnum()) continue;
                field.setAccessible(true);
                arrayList.add(field);
            }
            clazz = clazz.getSuperclass();
        }
        return arrayList;
    }

    private /* synthetic */ List method_5(Class clazz) {
        return this.a(clazz, Double.TYPE);
    }

    private /* synthetic */ List method_6(Class clazz) {
        return this.a(clazz, class_243.class);
    }

    private /* synthetic */ List method_7(Class clazz) {
        return this.a(clazz, class_2338.class);
    }

    private /* synthetic */ void method_8(class_2338 class_23382, class_2680 class_26802) {
        this.a(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
    }

    private static /* synthetic */ Set method_9() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    static {
        b = new Color(255, 220, 0, 180);
        c = new Color(255, 220, 0, 255);
    }
}

