/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;

public final class Hitbox
extends Module {
    public static Hitbox INSTANCE;
    public final Setting<Float> size = new Setting<Float>("Expand", Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(2.0f));

    public Hitbox() {
        super("Hitbox", Category.a);
        this.addSetting(this.size);
        INSTANCE = this;
    }
}

