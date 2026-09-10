/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.ModeSetting;
import com.water.setting.Setting;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.ToIntFunction;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_239;
import net.minecraft.class_3965;
import net.minecraft.class_465;
import net.minecraft.class_634;

public final class BoneDropper
extends Module {
    private final ModeSetting field_0;
    private final Setting<Integer> field_1;
    private a field_2;
    private String field_3;
    private long field_4;
    private int field_5;
    private long field_6;
    private boolean field_7;

    public BoneDropper() {
        super("BoneDropper", Category.d);
        this.a = new ModeSetting("Mode", "Spawner", "Spawner", "Orders");
        this.A = new Setting<Integer>("Delay", 300, 100, 2000);
        this.a = a.b;
        this.i = (String)this.a.getValue();
        this.addSetting(this.a);
        this.addSetting(this.A);
    }

    @Override
    public void onEnable() {
        this.u();
    }

    @Override
    public void onDisable() {
        this.a = a.b;
        this.k = 0L;
    }

    @Override
    public void onTick() {
        long l;
        if (BoneDropper.mc.field_1724 == null || BoneDropper.mc.field_1687 == null || BoneDropper.mc.field_1761 == null) {
            return;
        }
        if (BoneDropper.mc.field_1755 != null && !(BoneDropper.mc.field_1755 instanceof class_465)) {
            return;
        }
        if (!((String)this.a.getValue()).equalsIgnoreCase(this.i)) {
            this.u();
        }
        if ((l = System.currentTimeMillis()) < this.k) {
            return;
        }
        ModeSetting modeSetting = this.a;
        if ("J\ufffd\ufffd\ufffd\ufffd" != false) {
            this.x();
        } else {
            this.y();
        }
    }

    private void method_0() {
        switch (this.a.ordinal()) {
            case 0: {
                if (this.k()) {
                    this.a = a.c;
                    this.ab();
                    return;
                }
                this.z();
                this.a = a.c;
                this.ab();
                break;
            }
            case 1: {
                if (!this.k()) {
                    this.a = a.b;
                    this.ab();
                    return;
                }
                this.a = a.d;
                this.ab();
                break;
            }
            case 2: {
                class_1703 class_17032 = this.a();
                if (class_17032 == null) {
                    this.a = a.b;
                    this.ab();
                    return;
                }
                if (!this.a(class_17032)) {
                    this.ab();
                    return;
                }
                this.a = a.e;
                this.ab();
                break;
            }
            case 3: {
                class_1703 class_17033 = this.a();
                if (class_17033 == null) {
                    this.a = a.b;
                    this.ab();
                    return;
                }
                class_1735 class_17352 = this.a(class_17033);
                if (class_17352 == null) {
                    this.ab();
                    return;
                }
                this.t = this.a(class_17033);
                if (!this.t) {
                    this.a = a.d;
                    this.ab();
                    return;
                }
                this.o = this.c(class_1802.field_8606);
                this.l = System.currentTimeMillis();
                this.a(class_17352);
                this.a = a.f;
                this.ab();
                break;
            }
            case 4: {
                boolean bl;
                long l = System.currentTimeMillis();
                class_1703 class_17034 = this.a();
                boolean bl2 = this.t && class_17034 != null && !this.a(class_17034);
                boolean bl3 = bl = this.c(class_1802.field_8606) > this.o;
                if (bl2 || bl) {
                    if (class_17034 != null) {
                        this.aa();
                    }
                    this.a = a.g;
                    this.k = Long.MAX_VALUE;
                    return;
                }
                if (this.l > 0L && l - this.l > 4000L) {
                    this.a = class_17034 == null ? a.b : a.d;
                    this.ab();
                    return;
                }
                this.ab();
                break;
            }
            case 5: {
                break;
            }
            default: {
                this.a = a.b;
                this.ab();
            }
        }
    }

    private void method_1() {
        switch (this.a.ordinal()) {
            case 6: {
                if (!this.k()) {
                    BoneDropper boneDropper = this;
                    String string = "\ufffd\u0407 ";
                    this.a = a.i;
                    this.ab();
                    return;
                }
                this.a = a.j;
                this.ab();
                break;
            }
            case 7: {
                if (!this.k()) {
                    BoneDropper boneDropper = this;
                    String string = "\ufffd\u0407 ";
                    this.ab();
                    return;
                }
                this.a = a.j;
                this.ab();
                break;
            }
            case 8: {
                this.a(b.b, a.k);
                break;
            }
            case 9: {
                this.a(b.a, a.l);
                break;
            }
            case 10: {
                this.a(b.b, a.m);
                break;
            }
            case 11: {
                this.a(b.c, a.n);
                break;
            }
            case 12: {
                this.a(b.d, a.o);
                break;
            }
            case 13: {
                this.a(b.c, a.j);
                break;
            }
            default: {
                this.a = a.h;
                this.ab();
            }
        }
    }

    private void method_2(b b2, a a2) {
        class_1703 class_17032 = this.a();
        if (class_17032 == null) {
            BoneDropper boneDropper = this;
            String string = "\ufffd\u0407 ";
            this.ab();
            return;
        }
        if ((b2 = this.a(class_17032, b2, b2 == b.c || b2 == b.d)) == null) {
            this.ab();
            return;
        }
        this.a((class_1735)b2);
        this.a = a2;
        this.ab();
    }

    private boolean method_3(class_1703 object) {
        if ((object = this.a((class_1703)object)).isEmpty()) {
            return false;
        }
        object = object.iterator();
        while (object.hasNext()) {
            class_1735 class_17352 = (class_1735)object.next();
            if (!class_17352.method_7682() || !(class_17352 = class_17352.method_7677()).method_7960() && this.a((class_1799)class_17352, b.a)) continue;
            return false;
        }
        return true;
    }

    private List<class_1735> method_4(class_1703 object) {
        if ((object = this.b((class_1703)object)).isEmpty()) {
            return List.of();
        }
        int n = object.stream().mapToInt((ToIntFunction<class_1735>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)I, b(net.minecraft.class_1735 ), (Lnet/minecraft/class_1735;)I)()).max().orElse(Integer.MIN_VALUE);
        ArrayList<class_1735> arrayList = new ArrayList<class_1735>();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            class_1735 class_17352 = (class_1735)iterator.next();
            if (class_17352.field_7872 >= n) continue;
            arrayList.add(class_17352);
        }
        return arrayList.isEmpty() ? object : arrayList;
    }

    private class_1735 method_5(class_1703 object) {
        if ((object = this.b((class_1703)object)).isEmpty()) {
            return null;
        }
        int n = object.stream().mapToInt((ToIntFunction<class_1735>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)I, a(net.minecraft.class_1735 ), (Lnet/minecraft/class_1735;)I)()).max().orElse(Integer.MIN_VALUE);
        class_1735 class_17352 = this.a((List)object, b.c, true, n);
        if (class_17352 != null) {
            return class_17352;
        }
        class_17352 = this.a((List)object, b.c, true, Integer.MIN_VALUE);
        if (class_17352 != null) {
            return class_17352;
        }
        for (int i = object.size() - 1; i >= 0; --i) {
            class_1735 class_17353 = (class_1735)object.get(i);
            if (!class_17353.method_7682()) continue;
            return class_17353;
        }
        return null;
    }

    private class_1735 method_6(class_1703 class_17032, b b2, boolean bl) {
        return this.a(this.b(class_17032), b2, bl, Integer.MIN_VALUE);
    }

    private class_1735 method_7(List<class_1735> object, b b2, boolean bl, int n) {
        class_1735 class_17352 = null;
        object = object.iterator();
        while (object.hasNext()) {
            class_1735 class_17353 = (class_1735)object.next();
            if (!class_17353.method_7682() || n != Integer.MIN_VALUE && class_17353.field_7872 != n || !this.a(class_17353.method_7677(), b2)) continue;
            if (class_17352 == null) {
                class_17352 = class_17353;
                continue;
            }
            if (bl) {
                if (class_17353.field_7872 <= class_17352.field_7872 && (class_17353.field_7872 != class_17352.field_7872 || class_17353.field_7873 < class_17352.field_7873)) continue;
                class_17352 = class_17353;
                continue;
            }
            if (class_17353.field_7872 >= class_17352.field_7872 && (class_17353.field_7872 != class_17352.field_7872 || class_17353.field_7873 >= class_17352.field_7873)) continue;
            class_17352 = class_17353;
        }
        return class_17352;
    }

    private boolean method_8(class_1799 object, b b2) {
        if (object == null || object.method_7960()) {
            return false;
        }
        class_1792 class_17922 = object.method_7909();
        object = object.method_7964().getString().toLowerCase(Locale.ROOT);
        return switch (b2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> {
                if (class_17922 == class_1802.field_8606 || ((String)object).contains("bone")) {
                    yield true;
                }
                yield false;
            }
            case 1 -> {
                if (class_17922 == class_1802.field_8106 || class_17922 == class_1802.field_8247 || class_17922 == class_1802.field_8466 || ((String)object).contains("chest") || ((String)object).contains("truhe")) {
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (class_17922 == class_1802.field_8878 || ((String)object).contains("dropper")) {
                    yield true;
                }
                yield false;
            }
            case 3 -> class_17922 == class_1802.field_8107 || ((String)object).contains("arrow") || ((String)object).contains("pfeil");
        };
    }

    private List<class_1735> method_9(class_1703 class_17032) {
        if (class_17032 == null || class_17032.field_7761 == null || class_17032.field_7761.isEmpty()) {
            return List.of();
        }
        int n = Math.max(0, class_17032.field_7761.size() - 36);
        if (n == 0) {
            n = class_17032.field_7761.size();
        }
        ArrayList<class_1735> arrayList = new ArrayList<class_1735>(n);
        for (int i = 0; i < n; ++i) {
            arrayList.add((class_1735)class_17032.field_7761.get(i));
        }
        return arrayList;
    }

    private int method_10(class_1792 class_17922) {
        if (BoneDropper.mc.field_1724 == null) {
            return 0;
        }
        int n = 0;
        for (int i = 0; i < BoneDropper.mc.field_1724.method_31548().method_5439(); ++i) {
            class_1799 class_17992 = BoneDropper.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || !class_17992.method_31574(class_17922)) continue;
            n += class_17992.method_7947();
        }
        return n;
    }

    private void method_11(class_1735 class_17352) {
        if (class_17352 == null || BoneDropper.mc.field_1724 == null || BoneDropper.mc.field_1761 == null) {
            return;
        }
        BoneDropper.mc.field_1761.method_2906(BoneDropper.mc.field_1724.field_7512.field_7763, class_17352.field_7874, 0, class_1713.field_7790, (class_1657)BoneDropper.mc.field_1724);
    }

    private void method_12() {
        class_239 class_2392;
        block3: {
            block2: {
                class_2392 = BoneDropper.mc.field_1765;
                if (!(class_2392 instanceof class_3965)) break block2;
                class_2392 = (class_3965)class_2392;
                if (BoneDropper.mc.field_1765.method_17783() == class_239.class_240.field_1332) break block3;
            }
            return;
        }
        BoneDropper.mc.field_1761.method_2896(BoneDropper.mc.field_1724, class_1268.field_5808, (class_3965)class_2392);
        BoneDropper.mc.field_1724.method_6104(class_1268.field_5808);
    }

    private void method_13() {
        if (BoneDropper.mc.field_1724 == null) {
            return;
        }
        if (BoneDropper.mc.field_1755 instanceof class_465) {
            BoneDropper.mc.field_1724.method_7346();
            mc.method_1507(null);
        }
    }

    private class_1703 method_14() {
        if (!(BoneDropper.mc.field_1755 instanceof class_465) || BoneDropper.mc.field_1724 == null) {
            return null;
        }
        return BoneDropper.mc.field_1724.field_7512;
    }

    private boolean method_15() {
        return this.a() != null;
    }

    private void method_16(String string) {
        class_634 class_6342;
        class_634 class_6343 = class_6342 = BoneDropper.mc.field_1724 != null ? BoneDropper.mc.field_1724.field_3944 : mc.method_1562();
        if (class_6342 == null) {
            return;
        }
        String string2 = string.startsWith("/") ? string.substring(1) : string;
        try {
            class_6342.method_45730(string2);
        }
        catch (Throwable throwable) {
            class_6342.method_45729(string);
        }
    }

    private void method_17() {
        this.i = (String)this.a.getValue();
        BoneDropper boneDropper = this;
        ((BoneDropper)((Object)this.a)).a = "J\ufffd\ufffd\ufffd\ufffd" != false ? a.b : a.h;
        this.k = 0L;
        this.o = 0;
        this.l = 0L;
        this.t = false;
    }

    private void method_18() {
        this.k = System.currentTimeMillis() + (long)((Integer)this.A.getValue()).intValue();
    }

    private static /* synthetic */ int method_19(class_1735 class_17352) {
        return class_17352.field_7872;
    }

    private static /* synthetic */ int method_20(class_1735 class_17352) {
        return class_17352.field_7872;
    }

    private static final class a
    extends Enum<a> {
        public static final /* enum */ a field_0;
        public static final /* enum */ a field_1;
        public static final /* enum */ a field_2;
        public static final /* enum */ a field_3;
        public static final /* enum */ a field_4;
        public static final /* enum */ a field_5;
        public static final /* enum */ a field_6;
        public static final /* enum */ a field_7;
        public static final /* enum */ a field_8;
        public static final /* enum */ a field_9;
        public static final /* enum */ a field_10;
        public static final /* enum */ a field_11;
        public static final /* enum */ a field_12;
        public static final /* enum */ a field_13;
        private static final /* synthetic */ a[] field_14;

        public static a[] values() {
            return (a[])a.clone();
        }

        public static a valueOf(String string) {
            return Enum.valueOf(a.class, string);
        }

        private static /* synthetic */ a[] method_0() {
            return new a[]{b, c, d, e, f, g, h, i, j, k, l, m, n, o};
        }

        static {
            b = new a();
            c = new a();
            d = new a();
            e = new a();
            f = new a();
            g = new a();
            h = new a();
            i = new a();
            j = new a();
            k = new a();
            l = new a();
            m = new a();
            n = new a();
            o = new a();
            a = a.a();
        }
    }

    private static final class b
    extends Enum<b> {
        public static final /* enum */ b field_0;
        public static final /* enum */ b field_1;
        public static final /* enum */ b field_2;
        public static final /* enum */ b field_3;
        private static final /* synthetic */ b[] field_4;

        public static b[] values() {
            return (b[])a.clone();
        }

        public static b valueOf(String string) {
            return Enum.valueOf(b.class, string);
        }

        private static /* synthetic */ b[] method_0() {
            return new b[]{a, b, c, d};
        }

        static {
            a = new b();
            b = new b();
            c = new b();
            d = new b();
            a = b.a();
        }
    }
}

