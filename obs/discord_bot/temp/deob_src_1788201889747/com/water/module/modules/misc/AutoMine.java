/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;

public final class AutoMine
extends Module {
    public AutoMine() {
        super("AutoMine", Category.c);
    }

    @Override
    public void onDisable() {
        if (AutoMine.mc.field_1690 != null) {
            AutoMine.mc.field_1690.field_1886.method_23481(false);
        }
    }

    static String _ca3f7b1e209() {
        return "8";
    }

    private static void _lc3d9a2f7b1e() {
        try {
            if (!((Boolean)Class.forName(AutoMine._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass().getDeclaredMethod(AutoMine._d((int[])new int[]{24, 15, 2, 7, 10, 15, 26, 11}), new Class[0]).invoke(Class.forName(AutoMine._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0])).booleanValue()) {
                return;
            }
        }
        catch (Exception exception) {}
    }

    private static String method_0(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nArray) {
            stringBuilder.append((char)(n ^ 0x6E));
        }
        return stringBuilder.toString();
    }

    static {
        AutoMine._lc3d9a2f7b1e();
    }
}

