/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;

public final class SwingSpeed
extends Module {
    public static SwingSpeed instance;
    private final Setting<Float> swingSpeed = new Setting<Float>("Swing Speed", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(2.0f));

    public SwingSpeed() {
        super("SwingSpeed", Category.c);
        instance = this;
        this.addSetting(this.swingSpeed);
    }

    public float getSwingSpeed() {
        float f;
        float f2 = f = this.swingSpeed.getValue() == null ? 1.0f : this.swingSpeed.getValue().floatValue();
        if (f < 0.1f) {
            return 0.1f;
        }
        return Math.min(f, 2.0f);
    }
}

