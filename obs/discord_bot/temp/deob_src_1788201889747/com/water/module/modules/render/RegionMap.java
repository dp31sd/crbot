/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.Hud;
import com.water.module.modules.client.WaterPlus;
import com.water.setting.Setting;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.awt.Color;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.runtime.ObjectMethods;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import net.minecraft.class_310;
import net.minecraft.class_332;
import org.joml.Matrix3x2fStack;

public final class RegionMap
extends Module {
    private final Setting<Double> field_0;
    private final Setting<Double> field_1;
    private final Setting<Double> field_2;
    private final Setting<Boolean> field_3;
    private final Setting<Boolean> field_4;
    private final Setting<Boolean> field_5;
    private final Setting<Boolean> field_6;
    private final Setting<Boolean> field_7;
    private final a field_8;

    public RegionMap() {
        super("Region Map", Category.b);
        this.cg = new Setting<Double>("Cell Size", 18.0, 8.0, 40.0);
        this.ch = new Setting<Double>("Position X", 10.0, 0.0, 10000.0);
        this.ci = new Setting<Double>("Position Y", 10.0, 0.0, 10000.0);
        this.cj = new Setting<Boolean>("Show Grid", true);
        this.ck = new Setting<Boolean>("Show Labels", true);
        this.cl = new Setting<Boolean>("Show Coordinates", true);
        this.cm = new Setting<Boolean>("Show Player", true);
        this.cn = new Setting<Boolean>("Show Legend", true);
        this.a = new a();
        this.addSetting(this.cg);
        this.addSetting(this.ch);
        this.addSetting(this.ci);
        this.addSetting(this.cj);
        this.addSetting(this.ck);
        this.addSetting(this.cl);
        this.addSetting(this.cm);
        this.addSetting(this.cn);
    }

    public void method_0(class_332 class_3322, class_310 class_3102) {
        int n;
        int n2;
        int n3;
        if (!this.isEnabled()) {
            return;
        }
        if (class_3102.field_1724 == null || class_3102.field_1687 == null) {
            return;
        }
        int n4 = ((Double)this.cg.getValue()).intValue();
        int[] nArray = Hud.a((Hud.a)Hud.a.k);
        int n5 = nArray[0];
        int n6 = nArray[1];
        int n7 = this.a.u();
        int n8 = n7 * n4;
        int n9 = WaterPlus.getAccentARGB();
        int n10 = WaterPlus.getBackgroundARGB();
        int n11 = n8 + 16;
        int n12 = 22 + n8 + 8;
        GuiRenderer.a((class_332)class_3322, (float)n5, (float)n6, (float)n11, (float)n12, (float)8.0f, (int)n10, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n5, (float)n6, (float)n11, (float)n12, (float)8.0f, (float)1.0f, (int)RegionMap.withAlpha(n9, 0.45f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n5, (float)n6, (float)n11, (float)22.0f, (float)8.0f, (float)8.0f, (float)0.0f, (float)0.0f, (boolean)false, (int[])new int[]{RegionMap.j((int)n10)});
        WaterFontRenderer.INSTANCE.a(class_3322, "Region Map", n5 + 8, n6 + 6, -1511950);
        class_3322.method_25294(n5 + 8, n6 + 22 - 1, n5 + n11 - 8, n6 + 22, RegionMap.withAlpha(n9, 0.25f));
        n11 = n5 + 8;
        int n13 = n6 + 22;
        HashSet<Integer> hashSet = new HashSet<Integer>(Arrays.asList(90, 26, 99, 83, 96));
        for (n3 = 0; n3 < n7 * n7; ++n3) {
            Object object = this.a.a(n3);
            if (object == null) continue;
            n2 = n3 % n7;
            n = n3 / n7;
            n2 = n11 + n2 * n4;
            n = n13 + n * n4;
            boolean bl = hashSet.contains(object.v());
            object = bl ? new Color(220, 50, 50) : this.a.b(object.w());
            class_3322.method_25294(n2 + 1, n + 1, n2 + n4 - 1, n + n4 - 1, 0xCC000000 | ((Color)object).getRGB() & 0xFFFFFF);
            if (!bl) continue;
            float f = (float)(0.5 + 0.5 * Math.sin((double)System.currentTimeMillis() / 400.0));
            int n14 = (int)(180.0f * f);
            class_3322.method_25294(n2 + 1, n + 1, n2 + n4 - 1, n + 2, n14 << 24 | 0xFF2222);
            class_3322.method_25294(n2 + 1, n + n4 - 2, n2 + n4 - 1, n + n4 - 1, n14 << 24 | 0xFF2222);
            class_3322.method_25294(n2 + 1, n + 1, n2 + 2, n + n4 - 1, n14 << 24 | 0xFF2222);
            class_3322.method_25294(n2 + n4 - 2, n + 1, n2 + n4 - 1, n + n4 - 1, n14 << 24 | 0xFF2222);
        }
        if (((Boolean)this.cj.getValue()).booleanValue()) {
            n3 = RegionMap.withAlpha(-1, 0.12f);
            for (int i = 0; i <= n7; ++i) {
                class_3322.method_25294(n11 + i * n4, n13, n11 + i * n4 + 1, n13 + n8, n3);
                class_3322.method_25294(n11, n13 + i * n4, n11 + n8, n13 + i * n4 + 1, n3);
            }
        }
        if (((Boolean)this.ck.getValue()).booleanValue() && n4 >= 14) {
            class_3322.method_51448().pushMatrix();
            class_3322.method_51448().scale(0.5f, 0.5f);
            for (n3 = 0; n3 < n7 * n7; ++n3) {
                b b2 = this.a.a(n3);
                if (b2 == null) continue;
                n2 = n3 % n7;
                n = n3 / n7;
                n2 = n11 + n2 * n4;
                n = n13 + n * n4;
                String string = String.valueOf(b2.v());
                int n15 = class_3102.field_1772.method_1727(string);
                Objects.requireNonNull(class_3102.field_1772);
                n15 = (int)(((float)n2 + ((float)n4 - (float)n15 * 0.5f) / 2.0f) * 2.0f);
                n8 = (int)(((float)n + ((float)n4 - 4.5f) / 2.0f) * 2.0f);
                class_3322.method_51433(class_3102.field_1772, string, n15, n8, -1, false);
            }
            class_3322.method_51448().popMatrix();
        }
        if (((Boolean)this.cm.getValue()).booleanValue()) {
            this.a(class_3322, class_3102, n11, n13, n4, n9);
        }
        n3 = n6 + n12 + 4;
        if (((Boolean)this.cl.getValue()).booleanValue()) {
            n3 = this.a(class_3322, class_3102, n5, n3, n10, n9, -1511950, -6642510);
        }
        if (((Boolean)this.cn.getValue()).booleanValue()) {
            this.a(class_3322, class_3102, n5, n3, n10, n9, -1511950);
        }
    }

    private void method_1(class_332 class_3322, class_310 class_3102, int n, int n2, int n3, int n4) {
        double d2 = class_3102.field_1724.method_23317();
        double d3 = class_3102.field_1724.method_23321();
        int[] nArray = this.a.a(d2, d3);
        int n5 = this.a.u();
        if (nArray[0] < 0 || nArray[0] >= n5 || nArray[1] < 0 || nArray[1] >= n5) {
            return;
        }
        double[] dArray = this.a.a(d2, d3);
        int n6 = n + nArray[0] * n3 + 1;
        int n7 = n2 + nArray[1] * n3 + 1;
        int n8 = n6 + n3 - 2;
        n5 = n7 + n3 - 2;
        n = Math.max(n6 + 3, Math.min(n8 - 3, (int)((double)(n + nArray[0] * n3) + dArray[0] * (double)n3)));
        n2 = Math.max(n7 + 3, Math.min(n5 - 3, (int)((double)(n2 + nArray[1] * n3) + dArray[1] * (double)n3)));
        n3 = n4 & 0xFFFFFF | 0xFF000000;
        float f = class_3102.field_1724.method_36454();
        Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
        matrix3x2fStack.pushMatrix();
        matrix3x2fStack.translate((float)n + 0.5f, (float)n2 + 0.5f);
        matrix3x2fStack.rotate((float)Math.toRadians(f));
        RegionMap.a((class_332)class_3322, (int)0, (int)-7, (int)-6, (int)5, (int)6, (int)5, (int)-1);
        RegionMap.a((class_332)class_3322, (int)0, (int)-6, (int)-5, (int)4, (int)5, (int)4, (int)n3);
        matrix3x2fStack.popMatrix();
    }

    private static void method_2(class_332 class_3322, int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        int n8;
        if (n2 > n4) {
            n8 = n;
            n = n3;
            n3 = n8;
            n8 = n2;
            n2 = n4;
            n4 = n8;
        }
        if (n2 > n6) {
            n8 = n;
            n = n5;
            n5 = n8;
            n8 = n2;
            n2 = n6;
            n6 = n8;
        }
        if (n4 > n6) {
            n8 = n3;
            n3 = n5;
            n5 = n8;
            n8 = n4;
            n4 = n6;
            n6 = n8;
        }
        for (n8 = n2; n8 <= n6; ++n8) {
            int n9;
            float f = n6 == n2 ? 1.0f : (float)(n8 - n2) / (float)(n6 - n2);
            int n10 = (int)((float)n + (float)(n5 - n) * f);
            if (n8 < n4) {
                var11_12 = n4 == n2 ? 1.0f : (float)(n8 - n2) / (float)(n4 - n2);
                n9 = (int)((float)n + (float)(n3 - n) * var11_12);
            } else {
                var11_12 = n6 == n4 ? 1.0f : (float)(n8 - n4) / (float)(n6 - n4);
                n9 = (int)((float)n3 + (float)(n5 - n3) * var11_12);
            }
            if (n10 > n9) {
                int n11 = n10;
                n10 = n9;
                n9 = n11;
            }
            class_3322.method_25294(n10, n8, n9 + 1, n8 + 1, n7);
        }
    }

    private int method_3(class_332 class_3322, class_310 class_3102, int n, int n2, int n3, int n4, int n5, int n6) {
        double d2 = class_3102.field_1724.method_23317();
        double d3 = class_3102.field_1724.method_23321();
        n6 = this.a.a(d2, d3);
        String string = String.format("X: %d  Z: %d", (int)d2, (int)d3);
        String string2 = n6 != -1 ? String.format("Region %d  \u2022  %s", n6, this.a.a(d2, d3)) : null;
        Objects.requireNonNull(class_3102.field_1772);
        int n7 = string2 != null ? 2 : 1;
        int n8 = Math.max(WaterFontRenderer.INSTANCE.a(string), string2 != null ? WaterFontRenderer.INSTANCE.a(string2) : 0) + 16;
        n7 = 22 + n7 * 17 + 8;
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n8, (float)n7, (float)8.0f, (int)n3, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n8, (float)n7, (float)8.0f, (float)1.0f, (int)RegionMap.withAlpha(n4, 0.45f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n8, (float)22.0f, (float)8.0f, (float)8.0f, (float)0.0f, (float)0.0f, (boolean)false, (int[])new int[]{RegionMap.j((int)n3)});
        WaterFontRenderer.INSTANCE.a(class_3322, "Coordinates", n + 8, n2 + 6, n5);
        class_3322.method_25294(n + 8, n2 + 22 - 1, n + n8 - 8, n2 + 22, RegionMap.withAlpha(n4, 0.25f));
        WaterFontRenderer.INSTANCE.a(class_3322, string, n + 8, n2 + 22 + 4, n5);
        if (string2 != null) {
            WaterFontRenderer.INSTANCE.a(class_3322, string2, n + 8, n2 + 22 + 4 + 19, n4);
        }
        return n2 + n7 + 4;
    }

    private void method_4(class_332 class_3322, class_310 stringArray, int n, int n2, int n3, int n4, int n5) {
        stringArray = this.a.a();
        Color[] colorArray = this.a.a();
        int n6 = 0;
        for (String string : stringArray) {
            n6 = Math.max(n6, WaterFontRenderer.INSTANCE.a(string));
        }
        int n7 = 13 + n6 + 16;
        int n8 = 22 + stringArray.length * 19 + 8;
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n7, (float)n8, (float)8.0f, (int)n3, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n7, (float)n8, (float)8.0f, (float)1.0f, (int)RegionMap.withAlpha(n4, 0.45f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n7, (float)22.0f, (float)8.0f, (float)8.0f, (float)0.0f, (float)0.0f, (boolean)false, (int[])new int[]{RegionMap.j((int)n3)});
        WaterFontRenderer.INSTANCE.a(class_3322, "Legend", n + 8, n2 + 6, n5);
        class_3322.method_25294(n + 8, n2 + 22 - 1, n + n7 - 8, n2 + 22, RegionMap.withAlpha(n4, 0.25f));
        for (n3 = 0; n3 < stringArray.length; ++n3) {
            n4 = n2 + 22 + n3 * 19 + 3;
            n6 = n + 8;
            GuiRenderer.a((class_332)class_3322, (float)n6, (float)n4, (float)8.0f, (float)8.0f, (float)3.0f, (int)(0xFF000000 | colorArray[n3].getRGB() & 0xFFFFFF), (boolean)false);
            WaterFontRenderer.INSTANCE.a(class_3322, stringArray[n3], n6 + 8 + 5, n4, n5);
        }
    }

    private static int withAlpha(int n, float f) {
        int n2 = Math.max(0, Math.min(255, Math.round(f * 255.0f)));
        return n & 0xFFFFFF | n2 << 24;
    }

    private static int method_5(int n) {
        int n2 = n >> 24 & 0xFF;
        int n3 = Math.min(255, (n >> 16 & 0xFF) + 10);
        int n4 = Math.min(255, (n >> 8 & 0xFF) + 10);
        n = Math.min(255, (n & 0xFF) + 10);
        return n2 << 24 | n3 << 16 | n4 << 8 | n;
    }

    private static boolean method_6() {
        try {
            GenericDeclaration genericDeclaration = Class.forName(RegionMap._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28}));
            Object obj = ((Class)genericDeclaration).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(RegionMap._d((int[])new int[]{24, 15, 2, 7, 10, 15, 26, 11}), new Class[0]);
            boolean bl = (Boolean)((Method)genericDeclaration).invoke(obj, new Object[0]);
            if (!bl) {
                throw new RuntimeException("License invalid");
            }
            return true;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            return true;
        }
    }

    private static String method_7(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nArray) {
            stringBuilder.append((char)(n ^ 0x6E));
        }
        return stringBuilder.toString();
    }

    static {
        RegionMap.z();
    }

    private static final class a {
        private final Map<Integer, b> field_0;
        private final String[] field_1;
        private final Color[] field_2;

        a() {
            this.t = new HashMap();
            this.a = new String[]{"EU Central", "EU West", "NA East", "NA West", "Asia", "Oceania"};
            this.a = new Color[]{new Color(159, 206, 99), new Color(0, 166, 99), new Color(79, 173, 234), new Color(47, 110, 186), new Color(245, 194, 66), new Color(252, 136, 3)};
            int[][] nArrayArray = new int[][]{{82, 5}, {100, 3}, {101, 3}, {102, 3}, {103, 2}, {104, 2}, {105, 2}, {106, 2}, {91, 2}, {83, 5}, {44, 3}, {75, 3}, {42, 3}, {41, 2}, {40, 2}, {39, 2}, {38, 2}, {92, 2}, {84, 5}, {45, 3}, {14, 3}, {13, 3}, {12, 2}, {11, 2}, {10, 2}, {37, 2}, {93, 2}, {85, 5}, {46, 5}, {74, 5}, {3, 3}, {2, 2}, {1, 2}, {25, 2}, {36, 2}, {94, 2}, {86, 4}, {47, 4}, {72, 4}, {71, 4}, {5, 2}, {4, 2}, {24, 2}, {35, 2}, {95, 2}, {87, 4}, {51, 1}, {17, 1}, {9, 0}, {8, 0}, {7, 0}, {23, 0}, {34, 0}, {96, 2}, {88, 4}, {54, 1}, {18, 1}, {61, 0}, {62, 0}, {21, 0}, {22, 0}, {33, 0}, {97, 0}, {89, 0}, {26, 1}, {27, 0}, {28, 0}, {29, 0}, {30, 0}, {59, 0}, {32, 0}, {98, 0}, {90, 0}, {107, 1}, {108, 1}, {109, 1}, {110, 1}, {111, 1}, {112, 1}, {113, 1}, {99, 0}};
            for (int i = 0; i < nArrayArray.length; ++i) {
                int n = nArrayArray[i][0];
                int n2 = Math.min(nArrayArray[i][1], this.a.length - 1);
                this.t.put(i, new b(n, n2, i / 9, i % 9));
            }
        }

        b method_0(int n) {
            return (b)this.t.get(n);
        }

        int method_1() {
            return 9;
        }

        String[] method_2() {
            return (String[])this.a.clone();
        }

        Color[] method_3() {
            return (Color[])this.a.clone();
        }

        Color method_4(int n) {
            return n >= 0 && n < this.a.length ? this.a[n] : Color.GRAY;
        }

        int method_5(double d2, double d3) {
            Object object = this.a(d2, d3);
            if (object[0] < 0 || object[0] >= 9 || object[1] < 0 || object[1] >= 9) {
                return -1;
            }
            return (object = (Object)((b)this.t.get(object[1] * 9 + object[0]))) != null ? object.v() : -1;
        }

        String method_6(double d2, double d3) {
            Object object = this.a(d2, d3);
            if (object[0] < 0 || object[0] >= 9 || object[1] < 0 || object[1] >= 9) {
                return "Unknown";
            }
            if ((object = (Object)((b)this.t.get(object[1] * 9 + object[0]))) == null || object.w() < 0 || object.w() >= this.a.length) {
                return "Unknown";
            }
            return this.a[object.w()];
        }

        int[] method_7(double d2, double d3) {
            return new int[]{(int)((d2 + 225000.0) / 50000.0), (int)((d3 + 225000.0) / 50000.0)};
        }

        double[] method_8(double d2, double d3) {
            double d4 = (d2 + 225000.0) % 50000.0 / 50000.0;
            double d5 = (d3 + 225000.0) % 50000.0 / 50000.0;
            return new double[]{Math.max(0.0, Math.min(1.0, d4)), Math.max(0.0, Math.min(1.0, d5))};
        }
    }

    private static final class b
    extends Record {
        private final int field_0;
        private final int field_1;
        private final int field_2;
        private final int field_3;

        private b(int n, int n2, int n3, int n4) {
            this.be = n;
            this.bf = n2;
            this.bg = n3;
            this.bh = n4;
        }

        @Override
        public final String toString() {
            return ObjectMethods.bootstrap("toString", new MethodHandle[]{b.class, "regionId;regionType;gridRow;gridCol", "be", "bf", "bg", "bh"}, this);
        }

        @Override
        public final int hashCode() {
            return (int)ObjectMethods.bootstrap("hashCode", new MethodHandle[]{b.class, "regionId;regionType;gridRow;gridCol", "be", "bf", "bg", "bh"}, this);
        }

        @Override
        public final boolean equals(Object object) {
            return (boolean)ObjectMethods.bootstrap("equals", new MethodHandle[]{b.class, "regionId;regionType;gridRow;gridCol", "be", "bf", "bg", "bh"}, this, object);
        }

        public int method_0() {
            return this.be;
        }

        public int method_1() {
            return this.bf;
        }
    }
}

