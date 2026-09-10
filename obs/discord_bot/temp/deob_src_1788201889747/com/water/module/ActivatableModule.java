/*
 * Decompiled with CFR 0.152.
 */
package com.water.module;

import com.water.module.Category;
import com.water.module.Module;
import com.water.module.ModuleManager;

public abstract class ActivatableModule
extends Module {
    private int field_0;
    public boolean field_1;

    public ActivatableModule(String string, Category category) {
        super(string, category);
        this.a = 0;
        this.a = false;
    }

    public void method_0() {
        this.toggle();
    }

    public int getActivationKey() {
        return this.a;
    }

    public void setActivationKey(int n) {
        this.a = n;
        ModuleManager.INSTANCE.f();
    }

    void method_1(int n) {
        this.a = n;
    }
}

