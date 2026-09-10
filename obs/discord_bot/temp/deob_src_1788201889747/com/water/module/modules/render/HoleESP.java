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
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import net.minecraft.class_12249;
import net.minecraft.class_1923;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_638;
import net.minecraft.class_9799;
import org.lwjgl.opengl.GL11;

public final class HoleESP
extends Module {
    private final Setting<Double> field_0;
    private final Setting<Color> field_1;
    private final Setting<Double> field_2;
    private final Setting<Boolean> field_3;
    private final Map<Long, b> field_4;
    private final Queue<Long> field_5;
    private final Set<Long> field_6;
    private final Set<a> field_7;
    private ExecutorService field_8;
    private class_638 field_9;

    public HoleESP() {
        super("Hole ESP", Category.b);
        this.bJ = new Setting<Double>("Fill Alpha", 60.0, 0.0, 255.0);
        this.bK = new Setting<Color>("Color", new Color(255, 100, 0));
        this.bL = new Setting<Double>("Range", 64.0, 16.0, 128.0);
        this.bM = new Setting<Boolean>("Gradient Fill", true);
        this.r = new ConcurrentHashMap();
        this.a = new ArrayDeque();
        this.r = ConcurrentHashMap.newKeySet();
        this.s = ConcurrentHashMap.newKeySet();
        this.addSetting(this.bJ);
        this.addSetting(this.bK);
        this.addSetting(this.bL);
        this.addSetting(this.bM);
    }

    @Override
    public void onEnable() {
        this.a = HoleESP.mc.field_1687;
        this.az();
        this.clear();
    }

    @Override
    public void onDisable() {
        this.ba();
        this.clear();
        this.a = null;
    }

    @Override
    public void onTick() {
        if (HoleESP.mc.field_1687 == null || HoleESP.mc.field_1724 == null) {
            return;
        }
        if (HoleESP.mc.field_1687 != this.a) {
            this.a = HoleESP.mc.field_1687;
            this.clear();
        }
        this.az();
        this.ax();
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        if (HoleESP.mc.field_1687 == null || HoleESP.mc.field_1724 == null || this.s.isEmpty()) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        int n = this.a((Double)this.bJ.getValue());
        boolean bl = (Boolean)this.bM.getValue();
        class_9799 class_97992 = new class_9799(0x200000);
        class_4597.class_4598 class_45982 = class_4597.method_22991((class_9799)class_97992);
        class_4588 class_45882 = class_45982.method_73477(class_12249.method_76019());
        class_45872 = class_45872.method_23760();
        boolean bl2 = false;
        for (a a2 : this.s) {
            if (!a2.y()) continue;
            a2 = a2.a;
            if (!RenderUtils.isWorldBoxVisible(((class_238)a2).field_1323, ((class_238)a2).field_1322, ((class_238)a2).field_1321, ((class_238)a2).field_1320, ((class_238)a2).field_1325, ((class_238)a2).field_1324)) continue;
            Color color = (Color)this.bK.getValue();
            Color color2 = this.a(color, n);
            a2 = new class_238(((class_238)a2).field_1323 - class_41842.field_1352, ((class_238)a2).field_1322 - class_41842.field_1351, ((class_238)a2).field_1321 - class_41842.field_1350, ((class_238)a2).field_1320 - class_41842.field_1352, ((class_238)a2).field_1325 - class_41842.field_1351, ((class_238)a2).field_1324 - class_41842.field_1350);
            if (bl) {
                this.a(class_45882, (class_4587.class_4665)class_45872, (class_238)a2, color, n);
            } else {
                this.a(class_45882, (class_4587.class_4665)class_45872, (class_238)a2, this.toArgb(color2));
            }
            bl2 = true;
        }
        if (!bl2) {
            class_97992.close();
            return;
        }
        boolean bl3 = GL11.glIsEnabled((int)2929);
        GL11.glDisable((int)2929);
        GL11.glDepthMask((boolean)false);
        try {
            class_45982.method_22993();
        }
        finally {
            GL11.glDepthMask((boolean)true);
            if (bl3) {
                GL11.glEnable((int)2929);
            }
            class_97992.close();
        }
    }

    private void method_0(class_4588 class_45882, class_4587.class_4665 class_46652, class_238 class_2383, int n) {
        float f = (float)class_2383.field_1323;
        float f2 = (float)class_2383.field_1322;
        float f3 = (float)class_2383.field_1321;
        float f4 = (float)class_2383.field_1320;
        float f5 = (float)class_2383.field_1325;
        float f6 = (float)class_2383.field_1324;
        this.a(class_45882, class_46652, f, f2, f3, f4, f2, f3, f4, f2, f6, f, f2, f6, n);
        this.a(class_45882, class_46652, f, f5, f3, f, f5, f6, f4, f5, f6, f4, f5, f3, n);
        this.a(class_45882, class_46652, f, f2, f3, f, f5, f3, f4, f5, f3, f4, f2, f3, n);
        this.a(class_45882, class_46652, f, f2, f6, f4, f2, f6, f4, f5, f6, f, f5, f6, n);
        this.a(class_45882, class_46652, f, f2, f3, f, f2, f6, f, f5, f6, f, f5, f3, n);
        this.a(class_45882, class_46652, f4, f2, f3, f4, f5, f3, f4, f5, f6, f4, f2, f6, n);
    }

    private void method_1(class_4588 class_45882, class_4587.class_4665 class_46652, class_238 class_2383, Color color, int n) {
        double d2 = Math.max(0.001, class_2383.field_1325 - class_2383.field_1322);
        int n2 = Math.max(1, class_3532.method_15384((double)d2));
        int n3 = Math.max(6, Math.round((float)n * 0.18f));
        float f = (float)class_2383.field_1323;
        float f2 = (float)class_2383.field_1321;
        float f3 = (float)class_2383.field_1320;
        float f4 = (float)class_2383.field_1324;
        int n4 = 0;
        int n5 = 0;
        for (int i = 0; i < n2; ++i) {
            double d3 = (double)i / (double)n2;
            double d4 = (double)(i + 1) / (double)n2;
            float f5 = (float)class_3532.method_16436((double)d3, (double)class_2383.field_1322, (double)class_2383.field_1325);
            float f6 = (float)class_3532.method_16436((double)d4, (double)class_2383.field_1322, (double)class_2383.field_1325);
            float f7 = 1.0f - (float)i / (float)Math.max(1, n2 - 1);
            float f8 = 1.0f - (float)(i + 1) / (float)Math.max(1, n2);
            int n6 = this.toArgb(this.a(color, Math.max(n3, Math.round((float)n * f7))));
            int n7 = this.toArgb(this.a(color, Math.max(n3, Math.round((float)n * f8))));
            if (i == 0) {
                n5 = n6;
            }
            if (i == n2 - 1) {
                n4 = n7;
            }
            this.a(class_45882, class_46652, f, f5, f2, f, f6, f2, f3, f6, f2, f3, f5, f2, n6, n7);
            this.a(class_45882, class_46652, f, f5, f4, f3, f5, f4, f3, f6, f4, f, f6, f4, n6, n7);
            this.a(class_45882, class_46652, f, f5, f2, f, f5, f4, f, f6, f4, f, f6, f2, n6, n7);
            this.a(class_45882, class_46652, f3, f5, f2, f3, f6, f2, f3, f6, f4, f3, f5, f4, n6, n7);
        }
        this.a(class_45882, class_46652, f, (float)class_2383.field_1325, f2, f, (float)class_2383.field_1325, f4, f3, (float)class_2383.field_1325, f4, f3, (float)class_2383.field_1325, f2, n4);
        this.a(class_45882, class_46652, f, (float)class_2383.field_1322, f2, f3, (float)class_2383.field_1322, f2, f3, (float)class_2383.field_1322, f4, f, (float)class_2383.field_1322, f4, n5);
    }

    private void method_2(class_4588 class_45882, class_4587.class_4665 class_46652, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, int n, int n2) {
        class_45882.method_56824(class_46652, f, f2, f3).method_39415(n);
        class_45882.method_56824(class_46652, f4, f5, f6).method_39415(n2);
        class_45882.method_56824(class_46652, f7, f8, f9).method_39415(n2);
        class_45882.method_56824(class_46652, f10, f11, f12).method_39415(n);
    }

    private void method_3(class_4588 class_45882, class_4587.class_4665 class_46652, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, int n) {
        class_45882.method_56824(class_46652, f, f2, f3).method_39415(n);
        class_45882.method_56824(class_46652, f4, f5, f6).method_39415(n);
        class_45882.method_56824(class_46652, f7, f8, f9).method_39415(n);
        class_45882.method_56824(class_46652, f10, f11, f12).method_39415(n);
    }

    private void method_4() {
        if (HoleESP.mc.field_1687 == null || HoleESP.mc.field_1724 == null) {
            return;
        }
        for (b b2 : this.r.values()) {
            b2.al = false;
        }
        int n = Math.max(1, this.s() / 16);
        int n2 = HoleESP.mc.field_1724.method_31476().field_9181;
        int n3 = HoleESP.mc.field_1724.method_31476().field_9180;
        for (int i = n2 - n; i <= n2 + n; ++i) {
            for (int j = n3 - n; j <= n3 + n; ++j) {
                Object object = HoleESP.mc.field_1687.method_2935().method_12126(i, j, false);
                if (object == null) continue;
                long l = class_1923.method_8331((int)i, (int)j);
                object = (b)this.r.get(l);
                if (object != null) {
                    object.al = true;
                    continue;
                }
                if (!this.r.add(l)) continue;
                this.a.add(l);
            }
        }
        this.ay();
        this.r.entrySet().removeIf((Predicate<Map.Entry>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(java.util.Map$Entry ), (Ljava/util/Map$Entry;)Z)());
        Set set = this.r.keySet();
        this.s.removeIf((Predicate<a>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(java.util.Set com.water.module.modules.render.HoleESP$a ), (Lcom/water/module/modules/render/HoleESP$a;)Z)((HoleESP)this, set));
    }

    private boolean method_5(class_238 class_2383, Set<Long> set) {
        int n = (int)Math.floor(class_2383.method_1005().field_1352) >> 4;
        int n2 = (int)Math.floor(class_2383.method_1005().field_1350) >> 4;
        return set.contains(class_1923.method_8331((int)n, (int)n2));
    }

    private void method_6() {
        if (this.c == null || HoleESP.mc.field_1687 == null) {
            return;
        }
        int n = 0;
        while (!this.a.isEmpty() && n < 200) {
            Long l = (Long)this.a.poll();
            if (l == null) continue;
            this.r.remove(l);
            int n2 = class_1923.method_8325((long)l);
            int n3 = class_1923.method_8332((long)l);
            class_2818 class_28182 = HoleESP.mc.field_1687.method_2935().method_12126(n2, n3, false);
            if (class_28182 == null) continue;
            this.r.put(l, new b(n2, n3));
            this.c.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, c(net.minecraft.class_2818 ), ()V)((HoleESP)this, (class_2818)class_28182));
            ++n;
        }
    }

    private void method_7(class_2818 class_28182) {
        class_638 class_6382 = HoleESP.mc.field_1687;
        if (class_6382 == null || class_6382 != this.a || !this.isEnabled()) {
            return;
        }
        class_2826[] class_2826Array = class_28182.method_12006();
        int n = class_6382.method_31607();
        int n2 = class_6382.method_31607() + class_6382.method_31605();
        int n3 = n;
        for (class_2826 class_28262 : class_2826Array) {
            if (class_28262 != null && !class_28262.method_38292()) {
                for (int i = 0; i < 16; ++i) {
                    for (int j = 0; j < 16; ++j) {
                        for (int k = 0; k < 16; ++k) {
                            int n4 = n3 + k;
                            if (n4 <= n || n4 >= n2) continue;
                            class_2338 class_23382 = new class_2338(class_28182.method_12004().method_8326() + j, n4, class_28182.method_12004().method_8328() + i);
                            this.c(class_23382);
                            this.d(class_23382);
                        }
                    }
                }
            }
            n3 += 16;
        }
    }

    private void method_8(class_2338 class_23382) {
        if (!this.d(class_23382) || this.d(class_23382.method_10084())) {
            return;
        }
        class_2338.class_2339 class_23392 = class_23382.method_25503();
        while (this.d((class_2338)class_23392)) {
            class_23392.method_10098(class_2350.field_11033);
        }
        int n = class_23382.method_10264() - class_23392.method_10264();
        if (n < this.t()) {
            return;
        }
        if (!this.a((class_238)(class_23382 = new class_238((double)class_23382.method_10263(), (double)(class_23392.method_10264() + 1), (double)class_23382.method_10260(), (double)(class_23382.method_10263() + 1), (double)(class_23382.method_10264() + 1), (double)(class_23382.method_10260() + 1))))) {
            this.s.add(new a((class_238)class_23382, n, true));
        }
    }

    private void method_9(class_2338 class_23382) {
        int n;
        class_2338.class_2339 class_23392;
        if (this.e(class_23382) && !this.e(class_23382.method_10084())) {
            class_23392 = class_23382.method_25503();
            while (this.e((class_2338)class_23392)) {
                class_23392.method_10098(class_2350.field_11033);
            }
            n = class_23382.method_10264() - class_23392.method_10264();
            if (n >= this.t() && !this.a((class_238)(class_23392 = new class_238((double)class_23382.method_10263(), (double)(class_23392.method_10264() + 1), (double)class_23382.method_10260(), (double)(class_23382.method_10263() + 3), (double)(class_23382.method_10264() + 1), (double)(class_23382.method_10260() + 1))))) {
                this.s.add(new a((class_238)class_23392, n, false));
            }
        }
        if (this.f(class_23382) && !this.f(class_23382.method_10084())) {
            class_23392 = class_23382.method_25503();
            while (this.f((class_2338)class_23392)) {
                class_23392.method_10098(class_2350.field_11033);
            }
            n = class_23382.method_10264() - class_23392.method_10264();
            if (n >= this.t() && !this.a((class_238)(class_23392 = new class_238((double)class_23382.method_10263(), (double)(class_23392.method_10264() + 1), (double)class_23382.method_10260(), (double)(class_23382.method_10263() + 1), (double)(class_23382.method_10264() + 1), (double)(class_23382.method_10260() + 3))))) {
                this.s.add(new a((class_238)class_23392, n, false));
            }
        }
    }

    private boolean method_10(class_238 class_2383) {
        for (a a2 : this.s) {
            if (!a2.a.equals((Object)class_2383) && !a2.a.method_994(class_2383)) continue;
            return true;
        }
        return false;
    }

    private boolean method_11(class_2680 class_26802) {
        return class_26802.method_26204() == class_2246.field_10503 || class_26802.method_26204() == class_2246.field_9988 || class_26802.method_26204() == class_2246.field_10539 || class_26802.method_26204() == class_2246.field_10335 || class_26802.method_26204() == class_2246.field_10098 || class_26802.method_26204() == class_2246.field_10035 || class_26802.method_26204() == class_2246.field_42731 || class_26802.method_26204() == class_2246.field_37551 || class_26802.method_26204() == class_2246.field_28673 || class_26802.method_26204() == class_2246.field_28674 || class_26802.method_26204() == class_2246.field_10033 || class_26802.method_26204() == class_2246.field_10285 || class_26802.method_26204() == class_2246.field_10597 || class_26802.method_26204() == class_2246.field_28675 || class_26802.method_26204() == class_2246.field_28676 || class_26802.method_26204() == class_2246.field_22123 || class_26802.method_26204() == class_2246.field_22124 || class_26802.method_26204() == class_2246.field_23078 || class_26802.method_26204() == class_2246.field_23079 || class_26802.method_26204() == class_2246.field_28411 || class_26802.method_26204() == class_2246.field_28686 || class_26802.method_26204() == class_2246.field_28677 || class_26802.method_26204() == class_2246.field_10211 || class_26802.method_26204() == class_2246.field_10108 || class_26802.method_26204() == class_2246.field_9993 || class_26802.method_26204() == class_2246.field_10463 || class_26802.method_26204() == class_2246.field_10376 || class_26802.method_26204() == class_2246.field_10238 || class_26802.method_26204() == class_2246.field_10479 || class_26802.method_26204() == class_2246.field_10214 || class_26802.method_26204() == class_2246.field_10112 || class_26802.method_26204() == class_2246.field_10313 || class_26802.method_26204() == class_2246.field_10424 || class_26802.method_26204() == class_2246.field_10428 || class_26802.method_26204() == class_2246.field_16999;
    }

    private boolean method_12(class_2338 class_23382) {
        if (HoleESP.mc.field_1687 == null) {
            return false;
        }
        return !(class_23382 = HoleESP.mc.field_1687.method_8320(class_23382)).method_26215() && !this.l((class_2680)class_23382);
    }

    private boolean method_13(class_2338 class_23382) {
        return this.g(class_23382) && this.c(class_23382.method_10095()) && this.c(class_23382.method_10072()) && this.c(class_23382.method_10078()) && this.c(class_23382.method_10067());
    }

    private boolean method_14(class_2338 class_23382) {
        return this.g(class_23382) && this.g(class_23382.method_10078()) && this.g(class_23382.method_10089(2)) && this.c(class_23382.method_10095()) && this.c(class_23382.method_10072()) && this.c(class_23382.method_10067()) && this.c(class_23382.method_10089(3));
    }

    private boolean method_15(class_2338 class_23382) {
        return this.g(class_23382) && this.g(class_23382.method_10072()) && this.g(class_23382.method_10077(2)) && this.c(class_23382.method_10078()) && this.c(class_23382.method_10067()) && this.c(class_23382.method_10095()) && this.c(class_23382.method_10077(3));
    }

    private boolean method_16(class_2338 class_23382) {
        if (HoleESP.mc.field_1687 == null) {
            return false;
        }
        class_2680 class_26802 = HoleESP.mc.field_1687.method_8320(class_23382);
        if (!class_26802.method_26215()) {
            return false;
        }
        class_26802 = HoleESP.mc.field_1687.method_8320(class_23382.method_10074());
        class_23382 = HoleESP.mc.field_1687.method_8320(class_23382.method_10084());
        return !this.m(class_26802) && !this.m((class_2680)class_23382) && !this.n(class_26802) && !this.n((class_2680)class_23382);
    }

    private boolean method_17(class_2680 class_26802) {
        return class_26802.method_26204() == class_2246.field_9993 || class_26802.method_26204() == class_2246.field_10463 || class_26802.method_26204() == class_2246.field_10376 || class_26802.method_26204() == class_2246.field_10238 || class_26802.method_26204() == class_2246.field_10597 || class_26802.method_26204() == class_2246.field_28675 || class_26802.method_26204() == class_2246.field_28676 || class_26802.method_26204() == class_2246.field_22123 || class_26802.method_26204() == class_2246.field_22124 || class_26802.method_26204() == class_2246.field_23078 || class_26802.method_26204() == class_2246.field_23079 || class_26802.method_26204() == class_2246.field_28411 || class_26802.method_26204() == class_2246.field_28686 || class_26802.method_26204() == class_2246.field_28677;
    }

    private boolean method_18(class_2680 class_26802) {
        return class_26802.method_26204() == class_2246.field_10167 || class_26802.method_26204() == class_2246.field_10425 || class_26802.method_26204() == class_2246.field_10025 || class_26802.method_26204() == class_2246.field_10546 || class_26802.method_26204() == class_2246.field_10620 || class_26802.method_26204() == class_2246.field_10132 || class_26802.method_26204() == class_2246.field_10020 || class_26802.method_26204() == class_2246.field_10343;
    }

    private void clear() {
        this.r.clear();
        this.a.clear();
        this.r.clear();
        this.s.clear();
    }

    private void method_19() {
        if (this.c != null && !this.c.isShutdown()) {
            return;
        }
        this.c = Executors.newFixedThreadPool(2, (ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, g(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
    }

    private void method_20() {
        ExecutorService executorService = this.c;
        this.c = null;
        if (executorService == null) {
            return;
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(500L, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        }
        catch (InterruptedException interruptedException) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    private int method_21() {
        return class_3532.method_15340((int)((int)Math.round((Double)this.bL.getValue())), (int)16, (int)128);
    }

    private int method_22() {
        return 7;
    }

    private int method_23(double d2) {
        return class_3532.method_15340((int)((int)Math.round(d2)), (int)0, (int)255);
    }

    private Color method_24(Color color, int n) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), class_3532.method_15340((int)n, (int)0, (int)255));
    }

    private int toArgb(Color color) {
        return color.getAlpha() << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
    }

    private static /* synthetic */ Thread method_25(Runnable runnable) {
        runnable = new Thread(runnable, "water-hole-esp");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    private /* synthetic */ void method_26(class_2818 class_28182) {
        this.b(class_28182);
    }

    private /* synthetic */ boolean method_27(Set set, a a2) {
        return !this.a(a2.a, set);
    }

    private static /* synthetic */ boolean method_28(Map.Entry entry) {
        return !((b)entry.getValue()).al;
    }

    private static final class a {
        private final class_238 field_0;
        private final int field_1;
        private final boolean field_2;
        private final long field_3;

        private a(class_238 class_2383, int n, boolean bl) {
            this.a = class_2383;
            this.az = n;
            this.ak = bl;
            this.y = System.currentTimeMillis();
        }

        private boolean method_0() {
            return true;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof a)) {
                return false;
            }
            object = (a)object;
            return Objects.equals(this.a, ((a)object).a);
        }

        public int hashCode() {
            return Objects.hash(this.a);
        }
    }

    private static final class b {
        private final int field_0;
        private final int field_1;
        private boolean field_2;

        private b(int n, int n2) {
            this.ba = n;
            this.bb = n2;
            this.al = true;
        }
    }
}

