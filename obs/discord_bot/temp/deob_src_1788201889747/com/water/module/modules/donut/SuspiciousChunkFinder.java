/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import net.minecraft.class_1923;
import net.minecraft.class_2246;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import org.lwjgl.opengl.GL11;

public final class SuspiciousChunkFinder
extends Module {
    private final Setting<Integer> field_0;
    private final Setting<Integer> field_1;
    private final Setting<Color> field_2;
    private final Setting<Integer> field_3;
    private final Set<class_1923> field_4;
    private final Set<class_1923> field_5;
    private volatile Set<class_1923> field_6;
    private volatile long field_7;
    private ExecutorService field_8;
    private final AtomicBoolean field_9;
    private int field_10;

    public SuspiciousChunkFinder() {
        super("SUS CHUNK FINDER", Category.d);
        this.B = new Setting<Integer>("Scan Radius", 1, 1, 5);
        this.C = new Setting<Integer>("Sim Chunks", 10, 1, 10);
        this.D = new Setting<Color>("Fill Color", new Color(180, 60, 60, 40));
        this.E = new Setting<Integer>("Fill Alpha", 40, 0, 255);
        this.c = ConcurrentHashMap.newKeySet();
        this.d = ConcurrentHashMap.newKeySet();
        this.e = Collections.emptySet();
        this.m = 0L;
        this.b = new AtomicBoolean(false);
        this.p = 0;
        this.addSetting(this.B);
        this.addSetting(this.C);
        this.addSetting(this.D);
        this.addSetting(this.E);
    }

    @Override
    public void onEnable() {
        this.ac();
    }

    @Override
    public void onDisable() {
        this.ac();
        if (this.b != null) {
            this.b.shutdownNow();
        }
    }

    private void method_0() {
        this.c.clear();
        this.d.clear();
        this.e = Collections.emptySet();
        this.p = 0;
        this.b.set(false);
        this.m = 0L;
    }

    @Override
    public void onTick() {
        if (SuspiciousChunkFinder.mc.field_1687 == null || SuspiciousChunkFinder.mc.field_1724 == null) {
            return;
        }
        class_1923 class_19232 = SuspiciousChunkFinder.mc.field_1724.method_31476();
        int n = (Integer)this.B.getValue() * 5;
        this.c.removeIf((Predicate<class_1923>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, b(net.minecraft.class_1923 int net.minecraft.class_1923 ), (Lnet/minecraft/class_1923;)Z)((class_1923)class_19232, (int)n));
        this.d.removeIf((Predicate<class_1923>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(net.minecraft.class_1923 int net.minecraft.class_1923 ), (Lnet/minecraft/class_1923;)Z)((class_1923)class_19232, (int)n));
        if (++this.p % 5 != 0) {
            return;
        }
        if (!this.b.compareAndSet(false, true)) {
            return;
        }
        if (this.b == null || this.b.isShutdown()) {
            this.b = Executors.newSingleThreadExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, d(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
        }
        ArrayList<class_1923> arrayList = new ArrayList<class_1923>();
        ArrayList<class_2818> arrayList2 = new ArrayList<class_2818>();
        int n2 = (Integer)this.C.getValue();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                class_1923 class_19233 = new class_1923(class_19232.field_9181 + i, class_19232.field_9180 + j);
                class_2818 class_28182 = SuspiciousChunkFinder.mc.field_1687.method_2935().method_12126(class_19233.field_9181, class_19233.field_9180, false);
                if (class_28182 == null || class_28182.method_12223()) continue;
                arrayList.add(class_19233);
                arrayList2.add(class_28182);
            }
        }
        this.b.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(java.util.List java.util.List int net.minecraft.class_1923 ), ()V)((SuspiciousChunkFinder)this, arrayList, arrayList2, (int)n2, (class_1923)class_19232));
    }

    private Set<class_1923> method_1(Map<class_1923, Integer> iterator, class_1923 class_19232, int n) {
        iterator = new ArrayList<Map.Entry<class_1923, Integer>>(iterator.entrySet());
        iterator.sort((Comparator)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)I, a(net.minecraft.class_1923 java.util.Map$Entry java.util.Map$Entry ), (Ljava/util/Map$Entry;Ljava/util/Map$Entry;)I)((SuspiciousChunkFinder)this, (class_1923)class_19232));
        int n2 = Math.max(3, 33 - n * 3);
        LinkedHashSet<class_1923> linkedHashSet = new LinkedHashSet<class_1923>();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (linkedHashSet.size() >= n2) break;
            linkedHashSet.add((class_1923)entry.getKey());
        }
        return linkedHashSet;
    }

    private int method_2(class_1923 class_19232, class_1923 class_19233) {
        int n = class_19232.field_9181 - class_19233.field_9181;
        int n2 = class_19232.field_9180 - class_19233.field_9180;
        return n * n + n2 * n2;
    }

    private Set<class_1923> method_3(Set<class_1923> object, int n) {
        HashSet<class_1923> hashSet = new HashSet<class_1923>();
        if (n >= 10) {
            hashSet.addAll((Collection<class_1923>)object);
            return hashSet;
        }
        int[][] nArrayArray = new int[][]{{1, 4}, {2, 4}, {1, 2}, {3, 1}, {5, 4}, {5, 6}};
        object = object.iterator();
        while (object.hasNext()) {
            class_1923 class_19232 = (class_1923)object.next();
            Random random = new Random(Math.abs(class_19232.hashCode()));
            int[] nArray = nArrayArray[random.nextInt(nArrayArray.length)];
            int n2 = nArray[0];
            int n3 = nArray[1];
            if (random.nextBoolean()) {
                int n4 = n2;
                n2 = n3;
                n3 = n4;
            }
            int n5 = -(n2 / 2);
            int n6 = -(n3 / 2);
            for (int i = 0; i < n2; ++i) {
                for (int j = 0; j < n3; ++j) {
                    hashSet.add(new class_1923(class_19232.field_9181 + n5 + i, class_19232.field_9180 + n6 + j));
                }
            }
        }
        return hashSet;
    }

    private int method_4(class_2818 class_28182) {
        int n;
        int n2 = 0;
        class_2826[] class_2826Array = class_28182.method_12006();
        int n3 = class_28182.method_31607();
        for (int i = 0; i < class_2826Array.length && (n = n3 + i * 16) <= 32; ++i) {
            class_2826 class_28262 = class_2826Array[i];
            if (class_28262 == null || class_28262.method_38292() || !class_28262.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)((SuspiciousChunkFinder)this))) continue;
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    for (int i2 = 0; i2 < 16; ++i2) {
                        if (!this.a(class_28262.method_12254(j, k, i2))) continue;
                        ++n2;
                    }
                }
            }
        }
        return n2;
    }

    private boolean method_5(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_27161) || class_26802.method_27852(class_2246.field_27159);
    }

    private boolean method_6(class_2818 class_28182) {
        int n;
        int n2 = 0;
        class_2826[] class_2826Array = class_28182.method_12006();
        int n3 = class_28182.method_31607();
        for (int i = 0; i < class_2826Array.length && (n = n3 + i * 16) < 0; ++i) {
            class_2826 class_28262 = class_2826Array[i];
            if (class_28262 == null || class_28262.method_38292() || !class_28262.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, b(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)())) continue;
            n = Math.min(15, -n - 1);
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    for (int i2 = 0; i2 <= n; ++i2) {
                        class_2680 class_26802 = class_28262.method_12254(j, i2, k);
                        if (!class_26802.method_27852(class_2246.field_10034) && !class_26802.method_27852(class_2246.field_10380) || ++n2 < 10) continue;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        if (SuspiciousChunkFinder.mc.field_1687 == null || SuspiciousChunkFinder.mc.field_1724 == null) {
            return;
        }
        if (this.e.isEmpty() && this.d.isEmpty()) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        double d2 = 47.0 - class_41842.field_1351;
        double d3 = d2 + 0.1;
        Color color = (Color)this.D.getValue();
        int n = (Integer)this.E.getValue();
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), n);
        n = 0;
        int n2 = 0;
        if (!this.d.isEmpty()) {
            long l;
            long l2 = System.currentTimeMillis();
            if (this.m == 0L) {
                this.m = l2;
            }
            if ((l = (l2 - this.m) % 400L) < 150L) {
                n = 1;
                float f2 = (float)l / 150.0f;
                n2 = (int)((1.0f - f2) * 200.0f);
            }
        } else {
            this.m = 0L;
        }
        class_45872.method_22903();
        GL11.glDisable((int)2929);
        RenderUtils.WorldBatch worldBatch = RenderUtils.beginWorldBatch(class_45872);
        for (class_1923 class_19232 : this.e) {
            double d4 = (double)(class_19232.field_9181 << 4) - class_41842.field_1352;
            double d5 = (double)(class_19232.field_9180 << 4) - class_41842.field_1350;
            double d6 = d4 + 16.0;
            double d7 = d5 + 16.0;
            worldBatch.renderFilledBox(d4, d2, d5, d6, d3, d7, color);
        }
        if (n != 0 && n2 > 0) {
            Color color2 = new Color(255, 255, 255, n2);
            for (class_1923 class_19233 : this.d) {
                double d8 = (double)(class_19233.field_9181 << 4) - class_41842.field_1352;
                double d9 = (double)(class_19233.field_9180 << 4) - class_41842.field_1350;
                double d10 = d8 + 16.0;
                double d11 = d9 + 16.0;
                worldBatch.renderFilledBox(d8, d2, d9, d10, d3 + 0.3, d11, color2);
            }
        }
        worldBatch.flush();
        GL11.glEnable((int)2929);
        class_45872.method_22909();
    }

    private static /* synthetic */ boolean method_7(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10034) || class_26802.method_27852(class_2246.field_10380);
    }

    private /* synthetic */ int method_8(class_1923 class_19232, Map.Entry entry, Map.Entry entry2) {
        int n = Integer.compare((Integer)entry2.getValue(), (Integer)entry.getValue());
        if (n != 0) {
            return n;
        }
        int n2 = this.a(class_19232, (class_1923)entry.getKey());
        int n3 = this.a(class_19232, (class_1923)entry2.getKey());
        return Integer.compare(n2, n3);
    }

    private /* synthetic */ void method_9(List list, List list2, int n, class_1923 class_19232) {
        try {
            boolean bl;
            Object object;
            HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
            HashSet<Object> hashSet = new HashSet<Object>();
            for (int i = 0; i < list.size(); ++i) {
                object = (class_1923)list.get(i);
                class_2818 class_28182 = (class_2818)list2.get(i);
                int n2 = this.a(class_28182);
                if (n2 >= n) {
                    hashMap.put(object, n2);
                }
                if (!this.a(class_28182)) continue;
                hashSet.add(object);
            }
            Set set = this.a(hashMap, class_19232, n);
            object = this.a(set, n);
            boolean bl2 = bl = SuspiciousChunkFinder.mc.field_1724 != null && SuspiciousChunkFinder.mc.field_1724.method_23318() <= -2.0;
            if (bl) {
                object.removeIf((Predicate<class_1923>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(java.util.Set net.minecraft.class_1923 ), (Lnet/minecraft/class_1923;)Z)(hashSet));
            }
            if (!(set.equals(this.c) && hashSet.equals(this.d) && object.equals(this.e))) {
                this.e = Collections.unmodifiableSet(object);
            }
            this.c.clear();
            this.c.addAll(set);
            this.d.clear();
            this.d.addAll(hashSet);
        }
        catch (Exception exception) {
        }
        finally {
            this.b.set(false);
        }
    }

    private static /* synthetic */ boolean method_10(Set set, class_1923 class_19232) {
        return !set.contains(class_19232);
    }

    private static /* synthetic */ Thread method_11(Runnable runnable) {
        runnable = new Thread(runnable, "collosionsensor-scan");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    private static /* synthetic */ boolean method_12(class_1923 class_19232, int n, class_1923 class_19233) {
        return Math.abs(class_19233.field_9181 - class_19232.field_9181) > n + 2 || Math.abs(class_19233.field_9180 - class_19232.field_9180) > n + 2;
    }

    private static /* synthetic */ boolean method_13(class_1923 class_19232, int n, class_1923 class_19233) {
        return Math.abs(class_19233.field_9181 - class_19232.field_9181) > n + 2 || Math.abs(class_19233.field_9180 - class_19232.field_9180) > n + 2;
    }
}

