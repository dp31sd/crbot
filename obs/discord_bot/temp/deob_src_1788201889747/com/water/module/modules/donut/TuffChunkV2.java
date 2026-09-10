/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.WaterPlus;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import net.minecraft.class_1802;
import net.minecraft.class_1923;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2462;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_310;
import net.minecraft.class_3417;
import net.minecraft.class_3481;
import net.minecraft.class_4184;
import net.minecraft.class_4482;
import net.minecraft.class_4587;

public final class TuffChunkV2
extends Module {
    private final ConcurrentHashMap<class_1923, String> field_0;
    private final AtomicBoolean field_1;
    private final AtomicBoolean field_2;
    private ExecutorService field_3;
    private long field_4;
    private long field_5;
    private long field_6;
    private long field_7;
    private boolean field_8;
    private volatile a field_9;

    public TuffChunkV2() {
        super("Tuff Chunk V2", Category.b);
        this.a = new ConcurrentHashMap();
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.o = 0L;
        this.p = 0L;
        this.q = 0L;
        this.r = 0L;
        this.z = false;
    }

    @Override
    public void onEnable() {
        this.a.clear();
        this.o = 0L;
        this.p = 0L;
        this.z = false;
        this.a = null;
    }

    @Override
    public void onDisable() {
        this.a.clear();
        if (this.c != null) {
            this.c.shutdownNow();
        }
        this.c.set(false);
        this.d.set(false);
        this.z = false;
        this.a = null;
    }

    @Override
    public void onTick() {
        class_2818 class_28182;
        class_1923 class_19232;
        int n;
        int n2;
        ArrayList<class_2818> arrayList;
        ArrayList<class_1923> arrayList2;
        int n3;
        class_1923 class_19233;
        long l;
        if (TuffChunkV2.mc.field_1687 == null || TuffChunkV2.mc.field_1724 == null) {
            return;
        }
        if (this.z && (float)(System.currentTimeMillis() - this.r) > 800.0f) {
            this.z = false;
        }
        if ((l = System.currentTimeMillis()) - this.q >= 200L && !this.c.get() && this.d.compareAndSet(false, true)) {
            this.q = l;
            try {
                class_19233 = TuffChunkV2.mc.field_1724.method_31476();
                n3 = Math.min(TuffChunkV2.mc.field_1690.method_38521(), 8);
                arrayList2 = new ArrayList<class_1923>();
                arrayList = new ArrayList<class_2818>();
                for (n2 = -n3; n2 <= n3; ++n2) {
                    for (n = -n3; n <= n3; ++n) {
                        class_19232 = new class_1923(class_19233.field_9181 + n2, class_19233.field_9180 + n);
                        class_28182 = TuffChunkV2.mc.field_1687.method_2935().method_12126(class_19232.field_9181, class_19232.field_9180, false);
                        if (class_28182 == null || class_28182.method_12223()) continue;
                        arrayList2.add(class_19232);
                        arrayList.add(class_28182);
                    }
                }
                if (this.c == null || this.c.isShutdown()) {
                    this.c = Executors.newSingleThreadExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, f(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
                }
                this.c.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, b(java.util.List java.util.List ), ()V)((TuffChunkV2)this, arrayList2, arrayList));
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                this.d.set(false);
            }
            catch (Throwable throwable) {
                this.d.set(false);
            }
        }
        if (l - this.p < 20000L) {
            return;
        }
        if (!this.c.compareAndSet(false, true)) {
            return;
        }
        if (this.c == null || this.c.isShutdown()) {
            this.c = Executors.newSingleThreadExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, e(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
        }
        this.p = l;
        this.z = true;
        this.r = l;
        class_19233 = TuffChunkV2.mc.field_1724.method_31476();
        n3 = Math.min(TuffChunkV2.mc.field_1690.method_38521(), 8);
        arrayList2 = new ArrayList();
        arrayList = new ArrayList();
        for (n2 = -n3; n2 <= n3; ++n2) {
            for (n = -n3; n <= n3; ++n) {
                class_19232 = new class_1923(class_19233.field_9181 + n2, class_19233.field_9180 + n);
                class_28182 = TuffChunkV2.mc.field_1687.method_2935().method_12126(class_19232.field_9181, class_19232.field_9180, false);
                if (class_28182 == null || class_28182.method_12223()) continue;
                arrayList2.add(class_19232);
                arrayList.add(class_28182);
            }
        }
        try {
            this.c.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(java.util.List java.util.List ), ()V)((TuffChunkV2)this, arrayList2, arrayList));
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            this.c.set(false);
        }
        catch (Throwable throwable) {
            this.c.set(false);
        }
    }

    private a method_0(class_1923 class_19232, List<class_1923> list, List<class_2818> list2) {
        int n;
        if (class_19232 == null || list == null || list2 == null || list.isEmpty()) {
            return null;
        }
        class_1923 class_19233 = class_19232;
        int n2 = -1;
        int n3 = 0;
        b b2 = null;
        int n4 = Math.min(list.size(), list2.size());
        for (n = 0; n < n4; ++n) {
            class_1923 class_19234 = list.get(n);
            if (Math.abs(class_19234.field_9181 - class_19232.field_9181) > 7 || Math.abs(class_19234.field_9180 - class_19232.field_9180) > 7) continue;
            b b3 = this.a(list2.get(n));
            int n5 = b3.score();
            int n6 = Math.abs(class_19234.field_9181 - class_19232.field_9181) + Math.abs(class_19234.field_9180 - class_19232.field_9180);
            if ((n6 = Math.max(0, n5 - n6 * 3)) <= n2) continue;
            n2 = n6;
            n3 = n5;
            class_19233 = class_19234;
            b2 = b3;
        }
        n = b2 == null ? 35 : Math.max(20, Math.min(99, 25 + n3 / 2));
        return new a(class_19232, class_19233, n, n3);
    }

    private b method_1(class_2818 class_28182) {
        class_2826 class_28262;
        b b2 = new b();
        if (class_28182 == null || class_28182.method_12223()) {
            return b2;
        }
        for (class_2586 class_25862 : class_28182.method_12214().values()) {
            class_2680 class_26802 = class_28182.method_8320(class_25862.method_11016());
            if (class_26802.method_27852(class_2246.field_20422) || class_26802.method_27852(class_2246.field_20421)) {
                ++b2.u;
                if (!(class_25862 instanceof class_4482)) continue;
                class_28262 = (class_4482)class_25862;
                b2.v += Math.max(0, class_28262.method_23903());
                continue;
            }
            if (!TuffChunkV2.a((class_2248)class_26802.method_26204())) continue;
            ++b2.ac;
        }
        class_2826[] class_2826Array = class_28182.method_12006();
        int n = class_28182.method_31607();
        for (int i = 0; i < class_2826Array.length; ++i) {
            class_28262 = class_2826Array[i];
            if (class_28262 == null || class_28262.method_38292()) continue;
            int n2 = n + i * 16;
            int n3 = class_28262.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, c(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)());
            if (n3 == 0) continue;
            for (n3 = 0; n3 < 16; ++n3) {
                for (int j = 0; j < 16; ++j) {
                    for (int k = 0; k < 16; ++k) {
                        int n4 = n2 + k;
                        class_2680 class_26803 = class_28262.method_12254(n3, k, j);
                        if ((class_26803.method_27852(class_2246.field_10376) || class_26803.method_27852(class_2246.field_10238)) && n4 <= 70) {
                            ++b2.y;
                            continue;
                        }
                        if (class_26803.method_26164(class_3481.field_20339) && n4 <= 70) {
                            ++b2.z;
                            continue;
                        }
                        if (class_26803.method_27852(class_2246.field_10597)) {
                            ++b2.x;
                            continue;
                        }
                        if (class_26803.method_27852(class_2246.field_29031) && n4 >= 0 && n4 <= 20) {
                            ++b2.w;
                            continue;
                        }
                        if (class_26803.method_27852(class_2246.field_10450)) {
                            ++b2.aa;
                            if (!((Boolean)class_26803.method_11654((class_2769)class_2462.field_10911)).booleanValue()) continue;
                            ++b2.ab;
                            continue;
                        }
                        if (!TuffChunkV2.a((class_2248)class_26803.method_26204())) continue;
                        ++b2.ac;
                    }
                }
            }
        }
        return b2;
    }

    private static boolean method_2(class_2248 class_22482) {
        return class_22482 == class_2246.field_10034 || class_22482 == class_2246.field_10380 || class_22482 == class_2246.field_16328 || class_22482 == class_2246.field_10443 || class_22482 == class_2246.field_10181 || class_22482 == class_2246.field_16333 || class_22482 == class_2246.field_16334 || class_22482 == class_2246.field_9980 || class_22482 == class_2246.field_10485 || class_22482 == class_2246.field_10535 || class_22482 == class_2246.field_10105 || class_22482 == class_2246.field_10414;
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        if (TuffChunkV2.mc.field_1687 == null || TuffChunkV2.mc.field_1724 == null) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        double d2 = 63.0 - class_41842.field_1351;
        double d3 = d2 + 0.01;
        class_45872.method_22903();
        try {
            double d4;
            double d5;
            RenderUtils.WorldBatch worldBatch = RenderUtils.beginWorldBatch(class_45872);
            if (this.z) {
                float f2 = Math.min(1.0f, (float)(System.currentTimeMillis() - this.r) / 800.0f);
                float f3 = 1.0f - (1.0f - f2) * (1.0f - f2);
                float class_19232 = f3 * 140.0f;
                int n = (int)(120.0f * (1.0f - f2));
                if (n > 0 && class_19232 > 0.0f) {
                    d5 = TuffChunkV2.mc.field_1724.method_23317() - class_41842.field_1352;
                    d4 = TuffChunkV2.mc.field_1724.method_23321() - class_41842.field_1350;
                    Color color = new Color(255, 255, 255, n);
                    worldBatch.renderFilledBox(d5 - (double)class_19232, d2, d4 - (double)class_19232, d5 + (double)class_19232, d3, d4 - (double)class_19232 + 5.0, color);
                    worldBatch.renderFilledBox(d5 - (double)class_19232, d2, d4 + (double)class_19232 - 5.0, d5 + (double)class_19232, d3, d4 + (double)class_19232, color);
                    worldBatch.renderFilledBox(d5 - (double)class_19232, d2, d4 - (double)class_19232, d5 - (double)class_19232 + 5.0, d3, d4 + (double)class_19232, color);
                    worldBatch.renderFilledBox(d5 + (double)class_19232 - 5.0, d2, d4 - (double)class_19232, d5 + (double)class_19232, d3, d4 + (double)class_19232, color);
                }
            }
            for (Map.Entry object : this.a.entrySet()) {
                class_1923 class_19232 = (class_1923)object.getKey();
                String string = (String)object.getValue();
                d5 = (double)(class_19232.field_9181 << 4) + 8.0 - class_41842.field_1352;
                d4 = (double)(class_19232.field_9180 << 4) + 8.0 - class_41842.field_1350;
                if ("repeater".equals(string)) {
                    worldBatch.renderFilledBox(d5 - 32.0, d2, d4 - 32.0, d5 + 32.0, d3, d4 + 32.0, TuffChunkV2.a((int)40));
                    worldBatch.renderOutlineBox(d5 - 32.0, d2, d4 - 32.0, d5 + 32.0, d3, d4 + 32.0, TuffChunkV2.a((int)255));
                    worldBatch.renderFilledBox(d5 - 8.0, d2, d4 - 8.0, d5 + 8.0, d3, d4 + 8.0, TuffChunkV2.a((int)100));
                    worldBatch.renderOutlineBox(d5 - 8.0, d2, d4 - 8.0, d5 + 8.0, d3, d4 + 8.0, TuffChunkV2.a((int)255));
                    continue;
                }
                worldBatch.renderFilledBox(d5 - 32.0, d2, d4 - 32.0, d5 + 32.0, d3, d4 + 32.0, TuffChunkV2.a((int)120));
                worldBatch.renderOutlineBox(d5 - 32.0, d2, d4 - 32.0, d5 + 32.0, d3, d4 + 32.0, TuffChunkV2.a((int)255));
            }
            worldBatch.flush();
        }
        finally {
            class_45872.method_22909();
        }
    }

    private static Color method_3(int n) {
        return new Color(0, 255, 0, Math.max(0, Math.min(255, n)));
    }

    private static /* synthetic */ boolean method_4(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10376) || class_26802.method_27852(class_2246.field_10238) || class_26802.method_26164(class_3481.field_20339) || class_26802.method_27852(class_2246.field_10597) || class_26802.method_27852(class_2246.field_29031) || class_26802.method_27852(class_2246.field_10450) || TuffChunkV2.a((class_2248)class_26802.method_26204());
    }

    private /* synthetic */ void method_5(List list, List list2) {
        try {
            int n;
            int n15;
            int class_2826Array;
            int n14;
            int n5;
            Object object2;
            class_1923 class_19232 = null;
            block4: for (int i = 0; i < list.size(); ++i) {
                object2 = (class_2818)list2.get(i);
                n5 = 0;
                for (class_2826 class_28262 : object2.method_12006()) {
                    if (class_28262 == null || class_28262.method_38292() || !class_28262.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, h(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)())) continue;
                    for (n14 = 0; n14 < 16; ++n14) {
                        for (class_2826Array = 0; class_2826Array < 16; ++class_2826Array) {
                            for (n15 = 0; n15 < 16; ++n15) {
                                class_2680 class_26802 = class_28262.method_12254(n14, n15, class_2826Array);
                                if (!class_26802.method_27852(class_2246.field_10450) || !((Boolean)class_26802.method_11654((class_2769)class_2462.field_10911)).booleanValue() || ++n5 < 3) continue;
                                class_19232 = (class_1923)list.get(i);
                                break block4;
                            }
                        }
                    }
                }
            }
            if (class_19232 != null) {
                this.o = System.currentTimeMillis();
                this.a.clear();
                this.a.put(class_19232, "repeater");
                this.a = this.a(class_19232, list, list2);
                return;
            }
            class_1923 object3 = null;
            object2 = "normal";
            for (n5 = 0; n5 < list.size(); ++n5) {
                int n2;
                int n3;
                int n4;
                int n6;
                int n7;
                int n8;
                class_2826 class_282632;
                int n12;
                int n9;
                class_1923 class_19233 = (class_1923)list.get(n5);
                class_2818 class_28182 = (class_2818)list2.get(n5);
                n = 0;
                for (class_2586 class_25862 : class_28182.method_12214().values()) {
                    class_4482 class_44822;
                    class_2680 class_26803 = class_28182.method_8320(class_25862.method_11016());
                    if (!class_26803.method_27852(class_2246.field_20422) && !class_26803.method_27852(class_2246.field_20421) || !(class_25862 instanceof class_4482) || (class_44822 = (class_4482)class_25862).method_23903() <= 0) continue;
                    n = 1;
                    break;
                }
                boolean bl = false;
                if (n == 0) {
                    int n10 = 0;
                    class_2826[] class_2826Array2 = class_28182.method_12006();
                    int n11 = class_28182.method_31607();
                    block11: for (n9 = 0; n9 < class_2826Array2.length && (n12 = n11 + n9 * 16) <= 20; ++n9) {
                        if (n12 + 16 < 0 || (class_282632 = class_2826Array2[n9]) == null || class_282632.method_38292() || !class_282632.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, g(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)())) continue;
                        for (n8 = 0; n8 < 16; ++n8) {
                            for (n7 = 0; n7 < 16; ++n7) {
                                for (n6 = 0; n6 < 16; ++n6) {
                                    n4 = n12 + n6;
                                    if (n4 < 0 || n4 > 20 || !class_282632.method_12254(n8, n6, n7).method_27852(class_2246.field_29031) || ++n10 < 50) continue;
                                    bl = true;
                                    break block11;
                                }
                            }
                        }
                    }
                }
                n14 = 0;
                if (n == 0) {
                    int n13 = 0;
                    for (class_2826 class_282632 : class_28182.method_12006()) {
                        if (class_282632 == null || class_282632.method_38292() || !class_282632.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, f(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)())) continue;
                        for (n8 = 0; n8 < 16; ++n8) {
                            block17: for (n7 = 0; n7 < 16; ++n7) {
                                for (n6 = 0; n6 < 16; ++n6) {
                                    if (!class_282632.method_12254(n8, n6, n7).method_27852(class_2246.field_10597) || ++n13 < 150) continue;
                                    n14 = 1;
                                    continue block17;
                                }
                            }
                        }
                    }
                }
                class_2826Array = 0;
                n15 = 0;
                if (n == 0 && n14 == 0) {
                    n9 = 0;
                    n12 = 0;
                    class_282632 = class_28182.method_12006();
                    n8 = class_28182.method_31607();
                    block19: for (n7 = 0; n7 < ((class_2826[])class_282632).length && n8 + n7 * 16 <= 70; ++n7) {
                        class_2826 class_28264 = class_282632[n7];
                        if (class_28264 == null || class_28264.method_38292() || !class_28264.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, e(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)())) continue;
                        for (n4 = 0; n4 < 16; ++n4) {
                            for (n3 = 0; n3 < 16; ++n3) {
                                for (n2 = 0; n2 < 16; ++n2) {
                                    class_2680 class_26804 = class_28264.method_12254(n4, n2, n3);
                                    if (class_26804.method_27852(class_2246.field_10376) || class_26804.method_27852(class_2246.field_10238)) {
                                        if (++n9 >= 70) {
                                            class_2826Array = 1;
                                        }
                                    } else if (class_26804.method_26164(class_3481.field_20339) && ++n12 >= 6) {
                                        n15 = 1;
                                    }
                                    if (class_2826Array != 0 || n15 != 0) break block19;
                                }
                            }
                        }
                    }
                }
                n9 = 0;
                if (n == 0 && n14 == 0 && class_2826Array == 0 && !bl) {
                    n12 = 0;
                    class_282632 = class_28182.method_12006();
                    n8 = ((class_2826[])class_282632).length;
                    block23: for (n7 = 0; n7 < n8; ++n7) {
                        class_2826 class_28265 = class_282632[n7];
                        if (class_28265 == null || class_28265.method_38292() || !class_28265.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, d(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)())) continue;
                        for (n4 = 0; n4 < 16; ++n4) {
                            for (n3 = 0; n3 < 16; ++n3) {
                                for (n2 = 0; n2 < 16; ++n2) {
                                    if (!class_28265.method_12254(n4, n2, n3).method_27852(class_2246.field_10450) || ++n12 < 3) continue;
                                    n9 = 1;
                                    break block23;
                                }
                            }
                        }
                    }
                }
                if (n == 0 && n14 == 0 && class_2826Array == 0 && n15 == 0 && !bl && n9 == 0) continue;
                object3 = class_19233;
                object2 = n9 != 0 ? "repeater" : "normal";
                break;
            }
            if (object3 != null && "repeater".equals(object2)) {
                this.o = System.currentTimeMillis();
                this.a.clear();
                this.a.put(object3, object2);
                this.a = this.a(object3, list, list2);
                class_310.method_1551().execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, ai(), ()V)());
            } else if (object3 != null) {
                int n16 = n5 = System.currentTimeMillis() - this.o >= 50000L ? 1 : 0;
                if (n5 != 0) {
                    a a2;
                    this.o = System.currentTimeMillis();
                    this.a.clear();
                    this.a.put(object3, object2);
                    this.a = a2 = this.a(object3, list, list2);
                    n = a2 != null ? a2.t : 40;
                    class_310.method_1551().execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(int com.water.module.modules.donut.TuffChunkV2$a ), ()V)((int)n, (a)a2));
                }
            }
        }
        finally {
            this.c.set(false);
        }
    }

    private static /* synthetic */ void method_6(int n, a a2) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 != null) {
            class_3102.field_1724.method_5783(class_3417.field_14627, 1.0f, 1.0f);
            class_3102.field_1724.method_7353((class_2561)class_2561.method_43470((String)("\u00a78\u00a77Chunk found! \u00a7aBase chance: \u00a7f" + n + "%" + (a2 != null ? " \u00a77near chunk \u00a7f" + a2.b.field_9181 + ", " + a2.b.field_9180 : ""))), false);
        }
        ToastManager.INSTANCE.push("Tuff Chunk V2", a2 != null ? "Base chance: " + n + "% near " + a2.b.field_9181 + ", " + a2.b.field_9180 : "Base chance: " + n + "%", class_1802.field_8839.method_7854(), WaterPlus.getAccentARGB());
    }

    private static /* synthetic */ void method_7() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 != null) {
            class_3102.field_1724.method_5783(class_3417.field_14627, 1.0f, 1.0f);
            class_3102.field_1724.method_7353((class_2561)class_2561.method_43470((String)"\u00a78\u00a77Repeater chunk found!"), false);
        }
        ToastManager.INSTANCE.push("Tuff Chunk V2", "Repeater chunk found!", class_1802.field_8619.method_7854(), WaterPlus.getAccentARGB());
    }

    private static /* synthetic */ boolean method_8(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10450);
    }

    private static /* synthetic */ boolean method_9(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10376) || class_26802.method_27852(class_2246.field_10238) || class_26802.method_26164(class_3481.field_20339);
    }

    private static /* synthetic */ boolean method_10(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10597);
    }

    private static /* synthetic */ boolean method_11(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_29031);
    }

    private static /* synthetic */ boolean method_12(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10450);
    }

    private static /* synthetic */ Thread method_13(Runnable runnable) {
        runnable = new Thread(runnable, "tuff-chunk-scan");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    private /* synthetic */ void method_14(List list, List list2) {
        block8: {
            try {
                for (int i = 0; i < list.size(); ++i) {
                    class_2826[] class_2826Array = (class_2826[])list2.get(i);
                    int n = 0;
                    for (class_2826 class_28262 : class_2826Array.method_12006()) {
                        if (class_28262 == null || class_28262.method_38292() || !class_28262.method_19523((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, i(net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)())) continue;
                        for (int j = 0; j < 16; ++j) {
                            for (int k = 0; k < 16; ++k) {
                                for (int i2 = 0; i2 < 16; ++i2) {
                                    class_2680 class_26802 = class_28262.method_12254(j, i2, k);
                                    if (!class_26802.method_27852(class_2246.field_10450) || !((Boolean)class_26802.method_11654((class_2769)class_2462.field_10911)).booleanValue() || ++n < 3) continue;
                                    this.a.clear();
                                    this.a.put((class_1923)list.get(i), "repeater");
                                    this.a = this.a((class_1923)list.get(i), list, list2);
                                    break block8;
                                }
                            }
                        }
                    }
                }
            }
            finally {
                this.d.set(false);
            }
        }
    }

    private static /* synthetic */ boolean method_15(class_2680 class_26802) {
        return class_26802.method_27852(class_2246.field_10450);
    }

    private static /* synthetic */ Thread method_16(Runnable runnable) {
        runnable = new Thread(runnable, "tuff-scan");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    private static final class a {
        private class_1923 field_0;
        final class_1923 field_1;
        final int field_2;
        private int score;

        a(class_1923 class_19232, class_1923 class_19233, int n, int n2) {
            this.a = class_19232;
            this.b = class_19233;
            this.t = n;
            this.score = n2;
        }
    }

    private static final class b {
        int field_0;
        int field_1;
        int field_2;
        int field_3;
        int field_4;
        int field_5;
        int field_6;
        int field_7;
        int field_8;

        private b() {
        }

        int score() {
            int n = 0 + Math.min(90, this.u * 22 + this.v * 10);
            n += Math.min(65, this.w / 2);
            n += Math.min(55, this.x / 4);
            n += Math.min(70, this.y);
            n += Math.min(75, this.z * 12);
            n += Math.min(90, this.aa * 16 + this.ab * 28);
            return n += Math.min(100, this.ac * 18);
        }
    }
}

