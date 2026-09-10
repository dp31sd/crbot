/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;
import java.lang.invoke.LambdaMetafactory;
import java.util.function.Predicate;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1820;
import net.minecraft.class_2202;
import net.minecraft.class_2211;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_2397;
import net.minecraft.class_2680;
import net.minecraft.class_3481;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import net.minecraft.class_7923;
import net.minecraft.class_9285;
import net.minecraft.class_9334;

public final class AutoTool
extends Module {
    public AutoTool() {
        super("Auto Tool", Category.c);
    }

    @Override
    public void onTick() {
        if (AutoTool.mc.field_1724 == null || AutoTool.mc.field_1687 == null || AutoTool.mc.field_1761 == null) {
            return;
        }
        if (!AutoTool.mc.field_1690.field_1886.method_1434() || AutoTool.mc.field_1765 == null) {
            return;
        }
        class_239 class_2392 = AutoTool.mc.field_1765;
        if (class_2392.method_17783() == class_239.class_240.field_1331 && class_2392 instanceof class_3966) {
            this.am();
            return;
        }
        if (class_2392.method_17783() == class_239.class_240.field_1332 && class_2392 instanceof class_3965) {
            class_2392 = (class_3965)class_2392;
            this.a(class_2392.method_17777());
        }
    }

    private void method_0(class_2338 class_23382) {
        class_23382 = AutoTool.mc.field_1687.method_8320(class_23382);
        class_1799 class_17992 = AutoTool.mc.field_1724.method_6047();
        int n = -1;
        double d2 = -1.0;
        for (int i = 0; i < 9; ++i) {
            class_1799 class_17993 = AutoTool.mc.field_1724.method_31548().method_5438(i);
            double d3 = AutoTool.a((class_1799)class_17993, (class_2680)class_23382, (Predicate<class_1799>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, d(net.minecraft.class_1799 ), (Lnet/minecraft/class_1799;)Z)());
            if (!(d3 > d2)) continue;
            d2 = d3;
            n = i;
        }
        if (n == -1) {
            return;
        }
        double d4 = AutoTool.a((class_1799)class_17992, (class_2680)class_23382, (Predicate<class_1799>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, c(net.minecraft.class_1799 ), (Lnet/minecraft/class_1799;)Z)());
        if (d2 > d4 || !AutoTool.b((class_1799)class_17992)) {
            this.c(n);
        }
    }

    private void method_1() {
        int n = -1;
        double d2 = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 9; ++i) {
            double d3;
            class_1799 class_17992 = AutoTool.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || !((d3 = this.a(class_17992)) > d2)) continue;
            d2 = d3;
            n = i;
        }
        if (n != -1) {
            this.c(n);
        }
    }

    private double method_2(class_1799 class_17992) {
        Object object = (class_9285)class_17992.method_58694(class_9334.field_49636);
        double d2 = 0.0;
        if (object != null) {
            for (class_9285.class_9287 class_92872 : object.comp_2393()) {
                if (!class_92872.comp_2395().toString().contains("attack_damage")) continue;
                d2 += class_92872.comp_2396().comp_2449();
            }
        }
        if (d2 > 0.0) {
            return d2;
        }
        object = class_7923.field_41178.method_10221((Object)class_17992.method_7909()).method_12832();
        if (((String)object).endsWith("_sword")) {
            return 10.0 + this.a((String)object);
        }
        if (((String)object).endsWith("_axe")) {
            return 5.0 + this.a((String)object);
        }
        return 0.0;
    }

    private void method_3(int n) {
        if (n < 0 || n > 8) {
            return;
        }
        if (AutoTool.mc.field_1724.method_31548().method_67532() != n) {
            AutoTool.mc.field_1724.method_31548().method_61496(n);
        }
    }

    public static double method_4(class_1799 class_17992, class_2680 class_26802, Predicate<class_1799> object) {
        if (!object.test((class_1799)class_17992) || !AutoTool.b((class_1799)class_17992)) {
            return -1.0;
        }
        object = class_7923.field_41178.method_10221((Object)class_17992.method_7909()).method_12832();
        boolean bl = ((String)object).endsWith("_sword");
        if (!(class_17992.method_7951(class_26802) || bl && (class_26802.method_26204() instanceof class_2211 || class_26802.method_26204() instanceof class_2202) || class_17992.method_7909() instanceof class_1820 && class_26802.method_26204() instanceof class_2397 || class_26802.method_26164(class_3481.field_15481))) {
            return -1.0;
        }
        return class_17992.method_7924(class_26802) * 1000.0f;
    }

    public static boolean method_5(class_1799 class_17992) {
        return AutoTool.b((class_1792)class_17992.method_7909());
    }

    public static boolean method_6(class_1792 object) {
        if (object instanceof class_1820) {
            return true;
        }
        return ((String)(object = class_7923.field_41178.method_10221(object).method_12832())).endsWith("_pickaxe") || ((String)object).endsWith("_axe") || ((String)object).endsWith("_shovel") || ((String)object).endsWith("_hoe") || ((String)object).endsWith("_sword");
    }

    private double method_7(String string) {
        if (string.startsWith("netherite_")) {
            return 6.0;
        }
        if (string.startsWith("diamond_")) {
            return 5.0;
        }
        if (string.startsWith("iron_")) {
            return 4.0;
        }
        if (string.startsWith("golden_")) {
            return 3.0;
        }
        if (string.startsWith("stone_")) {
            return 2.0;
        }
        if (string.startsWith("wooden_")) {
            return 1.0;
        }
        return 0.0;
    }

    private static /* synthetic */ boolean method_8(class_1799 class_17992) {
        return true;
    }

    private static /* synthetic */ boolean method_9(class_1799 class_17992) {
        return true;
    }
}

