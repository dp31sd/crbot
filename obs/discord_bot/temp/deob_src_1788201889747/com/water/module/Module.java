/*
 * Decompiled with CFR 0.152.
 */
package com.water.module;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.ModuleManager;
import com.water.module.modules.client.WaterPlus;
import com.water.setting.Setting;
import com.water.utils.UiSoundManager;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2596;
import net.minecraft.class_310;
import net.minecraft.class_4587;

public abstract class Module {
    private final String name;
    private final Category category;
    private boolean enabled;
    private int bind = 0;
    private boolean expanded = false;
    public boolean wasBindPressed = false;
    private final List<Setting<?>> settings = new ArrayList();
    protected static final class_310 field_0;

    public Module(String string, Category category) {
        this.name = string;
        this.category = category;
        this.enabled = false;
    }

    public void addSetting(Setting<?> setting) {
        this.settings.add(setting);
    }

    public List<Setting<?>> getSettings() {
        return this.settings;
    }

    public String getName() {
        return this.name;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
        if (bl) {
            UiSoundManager.bj();
            this.onEnable();
        } else {
            this.onDisable();
        }
        ModuleManager.INSTANCE.f();
        try {
            if (WaterPlus.notificationsEnabled()) {
                ToastManager.INSTANCE.pushToggle(this.name, bl, this.getModuleIcon());
            }
        }
        catch (Exception exception) {}
    }

    public class_1799 getModuleIcon() {
        class_1792 class_17922 = Module.resolveItemByName(this.name);
        if (class_17922 != null && class_17922 != class_1802.field_8162) {
            return new class_1799((class_1935)class_17922);
        }
        return new class_1799((class_1935)this.categoryDefaultItem());
    }

    private static class_1792 resolveItemByName(String string) {
        return switch (string.toLowerCase().replace(" ", "_")) {
            case "fullbright" -> class_1802.field_8801;
            case "storage_esp" -> class_1802.field_8106;
            case "extra_esp" -> class_1802.field_8280;
            case "nametags" -> class_1802.field_8448;
            case "sprint" -> class_1802.field_8153;
            case "freecam" -> class_1802.field_8449;
            case "killaura" -> class_1802.field_8802;
            case "auto_crystal" -> class_1802.field_8301;
            case "triggerbot" -> class_1802.field_8102;
            case "hitbox" -> class_1802.field_8077;
            case "auto_totem" -> class_1802.field_8288;
            case "hover_totem" -> class_1802.field_8288;
            case "auto_inv_totem" -> class_1802.field_8288;
            case "elytra_swap" -> class_1802.field_8833;
            case "shield_breaker" -> class_1802.field_8255;
            case "anchor_macro" -> class_1802.field_23141;
            case "mace_swap" -> class_1802.field_49814;
            case "double_anchor" -> class_1802.field_23141;
            case "auto_double_hand" -> class_1802.field_8255;
            case "speraswap" -> class_1802.field_49814;
            case "freelook" -> class_1802.field_27070;
            case "skinscraper" -> class_1802.field_8577;
            case "skin_changer" -> class_1802.field_8577;
            case "auto_tool" -> class_1802.field_8377;
            case "fast_place" -> class_1802.field_8249;
            case "coordsnapper" -> class_1802.field_8251;
            case "nameprotect" -> class_1802.field_8529;
            case "autolog" -> class_1802.field_8407;
            case "autotpa" -> class_1802.field_8634;
            case "tunnel_base_finder" -> class_1802.field_8377;
            case "tab_detector" -> class_1802.field_8575;
            case "chat_macro" -> class_1802.field_8674;
            case "weather_notifier" -> class_1802.field_27051;
            case "spawner_notifier" -> class_1802.field_8849;
            case "block_esp" -> class_1802.field_8280;
            case "spawner_protect" -> class_1802.field_8849;
            case "homesetter" -> class_1802.field_8789;
            case "swing_speed" -> class_1802.field_8557;
            case "hud" -> class_1802.field_8895;
            case "water_+" -> class_1802.field_8705;
            case "friends" -> class_1802.field_8575;
            case "fakeroles" -> class_1802.field_8407;
            case "fakestats" -> class_1802.field_8407;
            case "antitrap" -> class_1802.field_8366;
            case "activitydebug" -> class_1802.field_8688;
            case "bonedropper" -> class_1802.field_8606;
            case "auto_chunk_loader" -> class_1802.field_8466;
            case "sus_chunk_finder" -> class_1802.field_42689;
            case "radiusdebug" -> class_1802.field_8600;
            case "spotify_hud" -> class_1802.field_8565;
            default -> null;
        };
    }

    private class_1792 categoryDefaultItem() {
        return switch (1.a[this.category.ordinal()]) {
            case 1 -> class_1802.field_8802;
            case 2 -> class_1802.field_8449;
            case 3 -> class_1802.field_8251;
            case 4 -> class_1802.field_8705;
            default -> class_1802.field_8407;
        };
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void toggle() {
        this.setEnabled(!this.enabled);
    }

    public void onBindPressed() {
        this.toggle();
    }

    public int getBind() {
        return this.bind;
    }

    public void setBind(int n) {
        this.bind = n;
        ModuleManager.INSTANCE.f();
    }

    void applyBind(int n) {
        this.bind = n;
    }

    void applyEnabled(boolean bl) {
        this.enabled = bl;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public void setExpanded(boolean bl) {
        this.expanded = bl;
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void onTick() {
    }

    public void onRender(class_4587 class_45872, float f) {
    }

    public void onPacketReceive(class_2596<?> class_25962) {
    }

    public boolean onPacketSend(class_2596<?> class_25962) {
        return false;
    }

    static String _c8cc94c8a16() {
        return "_";
    }

    static {
        mc = class_310.method_1551();
    }
}

