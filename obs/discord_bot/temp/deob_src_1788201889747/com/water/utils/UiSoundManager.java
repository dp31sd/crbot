/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils;

import com.water.module.modules.client.WaterPlus;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3414;

public final class UiSoundManager {
    private static final class_2960 field_0;

    public static void method_0() {
        UiSoundManager.a((class_2960)c, (float)0.7f, (float)1.0f);
    }

    private static void method_1(class_2960 class_29602, float f, float f2) {
        if (!WaterPlus.uiSoundsEnabled()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1724 == null) {
            return;
        }
        try {
            class_3102.field_1724.method_5783(class_3414.method_47908((class_2960)class_29602), f, f2);
        }
        catch (Throwable throwable) {}
    }

    static {
        class_2960.method_60655((String)"water", (String)"ui.gui_open");
        class_2960.method_60655((String)"water", (String)"ui.gui_close");
        c = class_2960.method_60655((String)"water", (String)"ui.module_on");
    }
}

