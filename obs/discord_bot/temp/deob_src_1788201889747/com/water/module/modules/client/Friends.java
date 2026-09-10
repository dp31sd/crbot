/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.client;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

public final class Friends
extends Module {
    private static Friends field_0;
    private final Setting<String> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Boolean> field_3;
    private final Setting<Boolean> field_4;
    private final Setting<Boolean> field_5;
    private final Setting<Color> field_6;

    public Friends() {
        super("Friends", Category.e);
        this.a = new Setting<String>("Names", "");
        this.b = new Setting<Boolean>("Anti Triggerbot", true);
        this.c = new Setting<Boolean>("ESP Color", true);
        this.d = new Setting<Boolean>("Auto Log", true);
        this.e = new Setting<Boolean>("Spawner Protect", true);
        this.f = new Setting<Color>("Friend Color", new Color(0, 200, 255));
        this.addSetting(this.a);
        this.addSetting(this.b);
        this.addSetting(this.c);
        this.addSetting(this.d);
        this.addSetting(this.e);
        this.addSetting(this.f);
        a = this;
    }

    public static boolean method_0(String string) {
        if (a == null || !a.isEnabled() || string == null || string.isEmpty()) {
            return false;
        }
        string = string.trim().toLowerCase(Locale.ROOT);
        for (String string2 : Friends.a((String)((String)Friends.a.a.getValue()))) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }

    public static boolean method_1() {
        return a != null && (Boolean)Friends.a.b.getValue() != false;
    }

    public static boolean method_2() {
        return a != null && (Boolean)Friends.a.c.getValue() != false;
    }

    public static boolean method_3() {
        return a != null && (Boolean)Friends.a.d.getValue() != false;
    }

    public static boolean method_4() {
        return a != null && (Boolean)Friends.a.e.getValue() != false;
    }

    public static Color method_5() {
        if (a == null) {
            return new Color(0, 200, 255);
        }
        Color color = (Color)Friends.a.f.getValue();
        if (color == null) {
            return new Color(0, 200, 255);
        }
        if (color.getAlpha() == 0) {
            return new Color(color.getRed(), color.getGreen(), color.getBlue(), 255);
        }
        return color;
    }

    private static List<String> method_6(String stringArray) {
        if (stringArray == null || stringArray.isBlank()) {
            return List.of();
        }
        stringArray = stringArray.replace('\n', ',').replace('\r', ',');
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        for (String string : stringArray.split(",")) {
            String string2 = string = string == null ? "" : string.trim();
            if (string.isEmpty()) continue;
            linkedHashSet.add(string.toLowerCase(Locale.ROOT));
        }
        return new ArrayList<String>(linkedHashSet);
    }
}

