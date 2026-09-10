/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.ModeSetting;
import com.water.setting.Setting;
import net.minecraft.class_1799;
import net.minecraft.class_2561;

public final class WeatherNotifier
extends Module {
    private final ModeSetting field_0;
    private final Setting<Boolean> field_1;
    private Boolean field_2;
    private Boolean field_3;

    public WeatherNotifier() {
        super("WeatherNotifier", Category.c);
        this.f = new ModeSetting("Notification Mode", "Both", "Chat", "Toast", "Both");
        this.br = new Setting<Boolean>("Notify Thunder", true);
        this.a = null;
        this.b = null;
        this.addSetting(this.f);
        this.addSetting(this.br);
    }

    @Override
    public void onEnable() {
        this.a = null;
        this.b = null;
    }

    @Override
    public void onDisable() {
        this.a = null;
        this.b = null;
    }

    @Override
    public void onTick() {
        if (WeatherNotifier.mc.field_1687 == null || WeatherNotifier.mc.field_1724 == null) {
            return;
        }
        boolean bl = WeatherNotifier.mc.field_1687.method_8419();
        boolean bl2 = WeatherNotifier.mc.field_1687.method_8546();
        if (this.a == null) {
            this.a = bl;
            this.b = bl2;
            return;
        }
        if (bl && !this.a.booleanValue()) {
            this.c("The rain started.", "Rain Started", -10835482);
        } else if (!bl && this.a.booleanValue()) {
            this.c("The rain stopped.", "Rain Stopped", -340971);
        }
        if (((Boolean)this.br.getValue()).booleanValue()) {
            if (bl2 && !this.b.booleanValue()) {
                this.c("A thunderstorm started.", "Thunder Started", -4879105);
            } else if (!bl2 && this.b.booleanValue()) {
                this.c("The thunderstorm ended.", "Thunder Ended", -340971);
            }
        }
        this.a = bl;
        this.b = bl2;
    }

    private void method_0(String string, String string2, int n) {
        boolean bl;
        String string3 = (String)this.f.getValue();
        boolean bl2 = "Chat".equalsIgnoreCase(string3) || "Both".equalsIgnoreCase(string3);
        boolean bl3 = bl = "Toast".equalsIgnoreCase(string3) || "Both".equalsIgnoreCase(string3);
        if (bl2) {
            try {
                WeatherNotifier.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)("[WeatherNotifier] " + string)));
            }
            catch (Throwable throwable) {}
        }
        if (bl) {
            ToastManager.INSTANCE.push("WeatherNotifier", string2, class_1799.field_8037, n);
        }
    }
}

