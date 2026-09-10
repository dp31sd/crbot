/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import net.minecraft.class_10017;
import net.minecraft.class_1799;
import net.minecraft.class_2561;

public final class NametagRenderState {
    private static final Set<class_10017> OVERRIDDEN_LABELS = Collections.newSetFromMap(new WeakHashMap());

    private NametagRenderState() {
    }

    public static void clear(class_10017 class_100172) {
        OVERRIDDEN_LABELS.remove(class_100172);
    }

    public static void mark(class_10017 class_100172) {
        OVERRIDDEN_LABELS.add(class_100172);
    }

    public static boolean hasEntry(class_10017 class_100172) {
        return OVERRIDDEN_LABELS.contains(class_100172);
    }

    public static boolean isOutlinedLabel(class_2561 class_25612) {
        return false;
    }

    public record ItemEntry(class_1799 stack) {
    }
}

