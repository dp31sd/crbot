/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.class_1297;
import net.minecraft.class_1299;

public final class AntiTrap
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Boolean> field_3;

    public AntiTrap() {
        super("AntiTrap", Category.d);
        this.bj = new Setting<Boolean>("Armor Stands", true);
        this.bk = new Setting<Boolean>("Minecarts", true);
        this.bl = new Setting<Boolean>("Chest Minecarts", true);
        this.bm = new Setting<Boolean>("Hopper Minecarts", true);
        this.addSetting(this.bj);
        this.addSetting(this.bk);
        this.addSetting(this.bl);
        this.addSetting(this.bm);
    }

    @Override
    public void onEnable() {
        this.w();
    }

    @Override
    public void onTick() {
        this.w();
    }

    private void method_0() {
        if (AntiTrap.mc.field_1687 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        AntiTrap.mc.field_1687.method_18112().forEach((Consumer<class_1297>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, a(java.util.List net.minecraft.class_1297 ), (Lnet/minecraft/class_1297;)V)((AntiTrap)this, arrayList));
        arrayList.forEach((Consumer<class_1297>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, b(net.minecraft.class_1297 ), (Lnet/minecraft/class_1297;)V)());
    }

    private boolean method_1(class_1299<?> class_12992) {
        if (class_12992 == null) {
            return false;
        }
        if (((Boolean)this.bj.getValue()).booleanValue() && class_12992.equals((Object)class_1299.field_6131)) {
            return true;
        }
        if (((Boolean)this.bk.getValue()).booleanValue() && class_12992.equals((Object)class_1299.field_6096)) {
            return true;
        }
        if (((Boolean)this.bl.getValue()).booleanValue() && class_12992.equals((Object)class_1299.field_6126)) {
            return true;
        }
        return (Boolean)this.bm.getValue() != false && class_12992.equals((Object)class_1299.field_6058);
    }

    private static /* synthetic */ void method_2(class_1297 class_12972) {
        if (!class_12972.method_31481()) {
            class_12972.method_5650(class_1297.class_5529.field_26999);
        }
    }

    private /* synthetic */ void method_3(List list, class_1297 class_12972) {
        if (class_12972 != null && this.a(class_12972.method_5864())) {
            list.add(class_12972);
        }
    }
}

