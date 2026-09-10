/*
 * Decompiled with CFR 0.152.
 */
package com.water.setting;

import com.water.setting.Setting;
import java.util.List;

public final class ModeSetting
extends Setting<String> {
    private final List<String> field_0;
    private final List<String> field_1;

    public ModeSetting(String string, String string2, String ... stringArray) {
        this(string, string2, new String[0], stringArray);
    }

    public ModeSetting(String string, String string2, String[] stringArray, String ... stringArray2) {
        super(string, string2);
        if (stringArray2 == null || stringArray2.length == 0) {
            throw new IllegalArgumentException("ModeSetting requires at least one mode");
        }
        this.g = List.of(stringArray2);
        this.h = stringArray == null ? List.of() : List.of(stringArray);
        this.setValue(string2);
    }

    public void method_0() {
        this.setValue(this.c(1));
    }

    public void method_1() {
        this.setValue(this.c(-1));
    }

    public boolean method_2(String string) {
        return this.h(string).equalsIgnoreCase((String)this.getValue());
    }

    @Override
    public void setValue(String string) {
        super.setValue(this.g(string));
    }

    @Override
    public boolean matchesName(String string) {
        if (super.matchesName(string)) {
            return true;
        }
        string = this.h(string);
        for (String string2 : this.h) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return true;
        }
        return false;
    }

    private String method_3(int n) {
        int n2 = this.g.size();
        if (n2 == 0) {
            return "";
        }
        String string = (String)this.getValue();
        for (int i = 0; i < n2; ++i) {
            if (!((String)this.g.get(i)).equalsIgnoreCase(string)) continue;
            n = Math.floorMod(i + n, n2);
            return (String)this.g.get(n);
        }
        return (String)this.g.getFirst();
    }

    private String method_4(String string) {
        string = this.h(string);
        for (String string2 : this.g) {
            if (!string2.equalsIgnoreCase(string)) continue;
            return string2;
        }
        return (String)this.g.getFirst();
    }

    private String method_5(String string) {
        return string == null ? "" : string.trim();
    }
}

