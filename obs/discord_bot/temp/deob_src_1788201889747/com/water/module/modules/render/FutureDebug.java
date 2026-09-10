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
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

public final class FutureDebug
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Integer> field_1;
    private final Setting<Integer> field_2;
    private final Setting<Color> field_3;
    private final Setting<Integer> field_4;
    private final Set<Long> field_5;
    private final Set<class_1923> field_6;
    private ExecutorService field_7;
    private final AtomicBoolean field_8;
    private int field_9;
    private static final int[][] field_10;
    private final Map<Long, int[]> field_11;
    private final Set<Long> field_12;

    public FutureDebug() {
        super("FutureDebug", Category.b);
        this.bE = new Setting<Boolean>("Smart Check", true);
        this.bF = new Setting<Integer>("Sensitivity", 5, 1, 10);
        this.bG = new Setting<Integer>("Scan Radius", 1, 1, 5);
        this.bH = new Setting<Color>("Fill Color", new Color(180, 60, 60, 255));
        this.bI = new Setting<Integer>("Fill Alpha", 30, 0, 255);
        this.o = ConcurrentHashMap.newKeySet();
        this.p = ConcurrentHashMap.newKeySet();
        this.f = new AtomicBoolean(false);
        this.p = 0;
        this.q = new ConcurrentHashMap();
        this.q = ConcurrentHashMap.newKeySet();
        this.addSetting(this.bE);
        this.addSetting(this.bF);
        this.addSetting(this.bG);
        this.addSetting(this.bH);
        this.addSetting(this.bI);
    }

    @Override
    public void onEnable() {
        this.o.clear();
        this.p.clear();
        this.q.clear();
        this.q.clear();
        this.p = 0;
        this.f.set(false);
    }

    @Override
    public void onDisable() {
        this.o.clear();
        this.p.clear();
        this.q.clear();
        this.q.clear();
        if (this.b != null) {
            this.b.shutdownNow();
        }
    }

    private int method_0() {
        return (int)(40.0 - (double)((Integer)this.bF.getValue() - 1) * 3.5555555555555554);
    }

    private float method_1() {
        return 0.015f - (float)((Integer)this.bF.getValue() - 1) * 0.0013333333f;
    }

    private int method_2() {
        return (int)(15.0 - (double)((Integer)this.bF.getValue() - 1) * 1.3333333333333333);
    }

    private float method_3() {
        return 0.08f + (float)((Integer)this.bF.getValue() - 1) * 0.027f;
    }

    private float method_4() {
        return 6.0f + (float)((Integer)this.bF.getValue() - 1) * 0.44444445f;
    }

    private boolean method_5(class_2818 class_28182) {
        Object object2;
        int n;
        int n2;
        class_2826[] class_2826Array = class_28182.method_12006();
        int n3 = class_28182.method_31607();
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        byte[][][] byArray = new byte[16][128][16];
        for (n2 = 0; n2 < class_2826Array.length; ++n2) {
            class_2826 class_28262;
            n = n3 + n2 * 16;
            if (n > 48 || n + 16 < -64 || (class_28262 = class_2826Array[n2]) == null || class_28262.method_38292()) continue;
            for (int i = 0; i < 16; ++i) {
                for (int j = 0; j < 16; ++j) {
                    int n12;
                    int n13 = n + j;
                    if (n13 < -64 || n13 > 48 || (n12 = n13 + 64) < 0 || n12 >= 128) continue;
                    for (int k = 0; k < 16; ++k) {
                        object2 = class_28262.method_12254(i, j, k);
                        if (object2.method_27852(class_2246.field_27160)) {
                            return false;
                        }
                        if (this.j((class_2680)object2)) {
                            byArray[i][n12][k] = 1;
                            ++n4;
                            n9 += i;
                            n10 += n13;
                            n11 += k;
                            arrayList.add(new int[]{i, n13, k});
                            continue;
                        }
                        if (object2.method_27852(class_2246.field_27114)) {
                            byArray[i][n12][k] = 2;
                            ++n5;
                            continue;
                        }
                        if (object2.method_27852(class_2246.field_29032)) {
                            byArray[i][n12][k] = 3;
                            ++n6;
                            continue;
                        }
                        byArray[i][n12][k] = object2.method_26215() || object2.method_27852(class_2246.field_10543) || object2.method_27852(class_2246.field_10243) ? 4 : 5;
                    }
                }
            }
        }
        if (n4 == 0) {
            return false;
        }
        if (!((Boolean)this.bE.getValue()).booleanValue()) {
            return n4 >= this.q();
        }
        n2 = Integer.MAX_VALUE;
        n = Integer.MIN_VALUE;
        for (int[] nArray : arrayList) {
            if (nArray[1] < n2) {
                n2 = nArray[1];
            }
            if (nArray[1] <= n) continue;
            n = nArray[1];
        }
        float f = (float)n4 / (256.0f * (float)Math.max(1, n - n2 + 1));
        float f2 = (float)n9 / (float)n4;
        float f3 = (float)n10 / (float)n4;
        float f4 = (float)n11 / (float)n4;
        float f5 = 0.0f;
        for (Object object2 : arrayList) {
            float f6 = (float)object2[0] - f2;
            float f7 = (float)object2[1] - f3;
            float f8 = (float)object2[2] - f4;
            f5 += (float)Math.sqrt(f6 * f6 + f7 * f7 + f8 * f8);
        }
        f5 /= (float)n4;
        Object object3 = new int[]{1, -1, 0, 0, 0, 0};
        object2 = new int[]{0, 0, 1, -1, 0, 0};
        int[] nArray = new int[]{0, 0, 0, 0, 1, -1};
        for (int[] nArray2 : arrayList) {
            n10 = nArray2[0];
            n11 = nArray2[1] + 64;
            n9 = nArray2[2];
            for (int i = 0; i < 6; ++i) {
                n2 = n10 + object3[i];
                n = n11 + object2[i];
                int n14 = n9 + nArray[i];
                if (n2 < 0 || n2 > 15 || n < 0 || n >= 128 || n14 < 0 || n14 > 15) continue;
                if ((n2 = byArray[n2][n][n14]) == 4) {
                    ++n7;
                    continue;
                }
                if (n2 < 2) continue;
                ++n8;
            }
        }
        int n15 = n7 + n8;
        float f9 = n15 > 0 ? (float)n7 / (float)n15 : 0.0f;
        return n4 >= this.q() && f >= this.d() && n5 + n6 >= this.r() && f5 <= this.f() && f9 <= this.e();
    }

    private boolean method_6(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_27161) || class_26802.method_27852(class_2246.field_27162) || class_26802.method_27852(class_2246.field_27163) || class_26802.method_27852(class_2246.field_27164) || class_26802.method_27852(class_2246.field_27159);
    }

    private boolean method_7(class_2818 class_28182) {
        int n;
        int n2 = 0;
        class_2826[] class_2826Array = class_28182.method_12006();
        int n3 = class_28182.method_31607();
        for (int i = 0; i < class_2826Array.length && (n = n3 + i * 16) < 0; ++i) {
            class_2826 class_28262 = class_2826Array[i];
            if (class_28262 == null || class_28262.method_38292() || !class_28262.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, k(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)())) continue;
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
    public void onTick() {
        if (FutureDebug.mc.field_1687 == null || FutureDebug.mc.field_1724 == null) {
            return;
        }
        class_1923 class_19232 = FutureDebug.mc.field_1724.method_31476();
        int n = (Integer)this.bG.getValue() * 5;
        this.o.removeIf((Predicate<Long>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(net.minecraft.class_1923 int java.lang.Long ), (Ljava/lang/Long;)Z)((class_1923)class_19232, (int)n));
        this.p.removeIf((Predicate<class_1923>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, c(net.minecraft.class_1923 int net.minecraft.class_1923 ), (Lnet/minecraft/class_1923;)Z)((class_1923)class_19232, (int)n));
        if (++this.p % 5 != 0) {
            return;
        }
        if (!this.f.compareAndSet(false, true)) {
            return;
        }
        if (this.b == null || this.b.isShutdown()) {
            this.b = Executors.newSingleThreadExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, e(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
        }
        ArrayList<class_1923> arrayList = new ArrayList<class_1923>();
        ArrayList<class_2818> arrayList2 = new ArrayList<class_2818>();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                class_1923 class_19233 = new class_1923(class_19232.field_9181 + i, class_19232.field_9180 + j);
                class_2818 class_28182 = FutureDebug.mc.field_1687.method_2935().method_12126(class_19233.field_9181, class_19233.field_9180, false);
                if (class_28182 == null || class_28182.method_12223()) continue;
                arrayList.add(class_19233);
                arrayList2.add(class_28182);
            }
        }
        this.b.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, c(java.util.List java.util.List ), ()V)((FutureDebug)this, arrayList, arrayList2));
    }

    private int[] method_8(long l) {
        if (this.q.containsKey(l)) {
            return (int[])this.q.get(l);
        }
        int n = class_1923.method_8325((long)l);
        int n2 = class_1923.method_8332((long)l);
        Object object = new ArrayList(Arrays.asList(b));
        Collections.shuffle(object);
        object = object.iterator();
        while (object.hasNext()) {
            int n3;
            int n4;
            int[] nArray = (int[])object.next();
            int n5 = nArray[0];
            int n6 = nArray[1];
            boolean bl = true;
            block1: for (n4 = 0; n4 < n5; ++n4) {
                for (n3 = 0; n3 < n6; ++n3) {
                    long l2 = class_1923.method_8331((int)(n + n4), (int)(n2 + n3));
                    if (!this.q.contains(l2)) continue;
                    bl = false;
                    break block1;
                }
            }
            if (!bl) continue;
            for (n4 = 0; n4 < n5; ++n4) {
                for (n3 = 0; n3 < n6; ++n3) {
                    this.q.add(class_1923.method_8331((int)(n + n4), (int)(n2 + n3)));
                }
            }
            this.q.put(l, new int[]{n5, n6});
            return new int[]{n5, n6};
        }
        this.q.add(l);
        this.q.put(l, new int[]{1, 1});
        return new int[]{1, 1};
    }

    @Override
    public void onRender(class_4587 object, float f) {
        if (FutureDebug.mc.field_1687 == null || FutureDebug.mc.field_1724 == null) {
            return;
        }
        if (this.o.isEmpty() && this.p.isEmpty()) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        double d2 = 63.0 - class_41842.field_1351;
        double d3 = d2 + 0.1;
        Color color = (Color)this.bH.getValue();
        color = new Color(color.getRed(), color.getGreen(), color.getBlue(), (Integer)this.bI.getValue());
        object = RenderUtils.beginWorldBatch((class_4587)object);
        Iterator iterator = this.o.iterator();
        while (iterator.hasNext()) {
            long l = (Long)iterator.next();
            int n = class_1923.method_8325((long)l);
            int n2 = class_1923.method_8332((long)l);
            int[] nArray = this.a(l);
            int n3 = nArray[0];
            int n4 = nArray[1];
            double d4 = (double)(n << 4) - class_41842.field_1352;
            double d5 = (double)(n2 << 4) - class_41842.field_1350;
            double d6 = d4 + (double)n3 * 16.0;
            double d7 = d5 + (double)n4 * 16.0;
            ((RenderUtils.WorldBatch)object).renderFilledBox(d4, d2, d5, d6, d3, d7, color);
        }
        ((RenderUtils.WorldBatch)object).flush();
    }

    private /* synthetic */ void method_9(List list, List list2) {
        try {
            for (int i = 0; i < list.size(); ++i) {
                class_1923 class_19232 = (class_1923)list.get(i);
                class_2818 class_28182 = (class_2818)list2.get(i);
                long l = class_19232.method_8324();
                if (this.b(class_28182)) {
                    this.o.add(l);
                }
                if (!this.a(class_28182)) continue;
                this.p.add(class_19232);
            }
        }
        catch (Exception exception) {
        }
        finally {
            this.f.set(false);
        }
    }

    private static /* synthetic */ Thread method_10(Runnable runnable) {
        runnable = new Thread(runnable, "futuredebug-scan");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    private static /* synthetic */ boolean method_11(class_1923 class_19232, int n, class_1923 class_19233) {
        return Math.abs(class_19233.field_9181 - class_19232.field_9181) > n + 2 || Math.abs(class_19233.field_9180 - class_19232.field_9180) > n + 2;
    }

    private static /* synthetic */ boolean method_12(class_1923 class_19232, int n, Long l) {
        int n2 = class_1923.method_8325((long)l);
        int n3 = class_1923.method_8332((long)l);
        return Math.abs(n2 - class_19232.field_9181) > n + 3 || Math.abs(n3 - class_19232.field_9180) > n + 3;
    }

    private static /* synthetic */ boolean method_13(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10034) || class_26802.method_27852(class_2246.field_10380);
    }

    static {
        b = new int[][]{{1, 3}, {1, 4}, {1, 5}, {2, 3}, {3, 3}, {4, 3}, {5, 3}, {4, 4}, {5, 5}};
    }
}

