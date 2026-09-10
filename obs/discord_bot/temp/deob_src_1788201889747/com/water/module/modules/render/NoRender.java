/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import net.minecraft.class_1959;
import net.minecraft.class_3414;
import net.minecraft.class_3417;

public final class NoRender
extends Module {
    public static NoRender instance;
    private final Setting<Boolean> rain = new Setting<Boolean>("Rain", true);
    private final Setting<Boolean> snow = new Setting<Boolean>("Snow", true);
    private final Setting<Boolean> thunder = new Setting<Boolean>("Thunder", true);

    public NoRender() {
        super("NoRender", Category.b);
        instance = this;
        this.addSetting(this.rain);
        this.addSetting(this.snow);
        this.addSetting(this.thunder);
    }

    public static boolean isActive() {
        return instance != null && instance.isEnabled() && mc != null && NoRender.mc.field_1687 != null;
    }

    public static boolean hideRain() {
        return NoRender.isActive() && NoRender.instance.rain.getValue() != false;
    }

    public static boolean hideSnow() {
        return NoRender.isActive() && NoRender.instance.snow.getValue() != false;
    }

    public static boolean hideThunder() {
        return NoRender.isActive() && NoRender.instance.thunder.getValue() != false;
    }

    public static boolean hideAllPrecipitation() {
        return NoRender.hideRain() && NoRender.hideSnow();
    }

    public static boolean hideRainGradient() {
        return NoRender.hideAllPrecipitation();
    }

    public static class_1959.class_1963 filterPrecipitation(class_1959.class_1963 class_19632) {
        if (!NoRender.isActive() || class_19632 == null) {
            return class_19632;
        }
        if (class_19632 == class_1959.class_1963.field_9382 && NoRender.hideRain()) {
            return class_1959.class_1963.field_9384;
        }
        if (class_19632 == class_1959.class_1963.field_9383 && NoRender.hideSnow()) {
            return class_1959.class_1963.field_9384;
        }
        return class_19632;
    }

    public static boolean shouldCancelWeatherSound(class_3414 class_34142) {
        if (!NoRender.isActive() || class_34142 == null) {
            return false;
        }
        if (NoRender.hideRain() && (class_34142 == class_3417.field_14946 || class_34142 == class_3417.field_15020)) {
            return true;
        }
        return NoRender.hideThunder() && (class_34142 == class_3417.field_14865 || class_34142 == class_3417.field_14956);
    }
}

