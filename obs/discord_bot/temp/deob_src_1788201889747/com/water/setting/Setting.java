/*
 * Decompiled with CFR 0.152.
 */
package com.water.setting;

import com.water.module.ModuleManager;
import java.util.Objects;
import java.util.function.Supplier;

public class Setting<T> {
    private final String name;
    private final T defaultValue;
    private T value;
    private T min;
    private T max;
    private Supplier<Boolean> visibility = () -> true;

    public Setting(String string, T t) {
        this.name = string;
        this.value = t;
        this.defaultValue = t;
    }

    public Setting(String string, T t, T t2, T t3) {
        this.name = string;
        this.value = t;
        this.defaultValue = t;
        this.min = t2;
        this.max = t3;
    }

    public String getName() {
        return this.name;
    }

    public T getValue() {
        return this.value;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public boolean matchesName(String string) {
        return this.name.equalsIgnoreCase(string);
    }

    public Setting<T> visibleWhen(Supplier<Boolean> supplier) {
        this.visibility = supplier == null ? () -> true : supplier;
        return this;
    }

    public boolean isVisible() {
        try {
            return this.visibility == null || this.visibility.get() != false;
        }
        catch (Exception exception) {
            return true;
        }
    }

    public void setValue(T t) {
        if (Objects.equals(this.value, t)) {
            return;
        }
        this.value = t;
        ModuleManager.INSTANCE.c();
    }

    public T getMin() {
        return this.min;
    }

    public T getMax() {
        return this.max;
    }

    static String _cf6ce2f6d19() {
        return "1";
    }
}

