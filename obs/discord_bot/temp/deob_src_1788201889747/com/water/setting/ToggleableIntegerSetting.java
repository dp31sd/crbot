/*
 * Decompiled with CFR 0.152.
 */
package com.water.setting;

import com.water.setting.Setting;

public final class ToggleableIntegerSetting
extends Setting<Integer> {
    private boolean enabled;

    public ToggleableIntegerSetting(String string, boolean bl, int n, int n2, int n3) {
        super(string, n, n2, n3);
        this.enabled = bl;
    }

    public String method_0() {
        return this.enabled + "|" + this.getValue();
    }

    public void method_1(String string) {
        if (string == null || string.isBlank()) {
            return;
        }
        String[] stringArray = string.split("\\|", 2);
        try {
            if (stringArray.length == 2) {
                this.enabled = Boolean.parseBoolean(stringArray[0]);
                this.setValue(Integer.parseInt(stringArray[1]));
                return;
            }
            this.setValue(Integer.parseInt(string));
        }
        catch (NumberFormatException numberFormatException) {}
    }
}

