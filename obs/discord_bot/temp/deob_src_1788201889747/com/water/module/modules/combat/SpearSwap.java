/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.combat;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import net.minecraft.class_1661;
import net.minecraft.class_1743;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1893;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import net.minecraft.class_9304;
import net.minecraft.class_9334;

public final class SpearSwap
extends Module {
    public static SpearSwap INSTANCE;
    private final Setting<Boolean> lunge = new Setting<Boolean>("Lunge", true);
    private final Setting<Boolean> sharpness = new Setting<Boolean>("Sharpness", false);
    private final Setting<Boolean> onlySword = new Setting<Boolean>("Only Sword", false);
    private final Setting<Boolean> onlyAxe = new Setting<Boolean>("Only Axe", false);
    private final Setting<Boolean> switchBack = new Setting<Boolean>("Switch Back", true);
    private final Setting<Float> switchDelay = new Setting<Float>("Switch Delay", Float.valueOf(1.0f), Float.valueOf(1.0f), Float.valueOf(20.0f));
    private int previousSlot = -1;
    private int countdown = 0;
    private boolean attackHeldLastCheck = false;

    public SpearSwap() {
        super("SpearSwap", Category.a);
        this.addSetting(this.lunge);
        this.addSetting(this.sharpness);
        this.addSetting(this.onlySword);
        this.addSetting(this.onlyAxe);
        this.addSetting(this.switchBack);
        this.addSetting(this.switchDelay);
        INSTANCE = this;
    }

    public void preAttack() {
        if (SpearSwap.mc.field_1724 == null) {
            return;
        }
        boolean bl = this.attackHeldLastCheck;
        this.attackHeldLastCheck = true;
        if (bl) {
            return;
        }
        if (this.countdown > 0) {
            return;
        }
        class_1661 class_16612 = SpearSwap.mc.field_1724.method_31548();
        int n = this.findBestWeaponSlot();
        if (n < 0) {
            return;
        }
        if (class_16612.method_67532() == n) {
            return;
        }
        this.previousSlot = class_16612.method_67532();
        class_16612.method_61496(n);
        this.countdown = Math.max(1, this.switchDelay.getValue().intValue());
    }

    public void noAttack() {
        this.attackHeldLastCheck = false;
    }

    @Override
    public void onEnable() {
        this.previousSlot = -1;
        this.countdown = 0;
    }

    @Override
    public void onDisable() {
        this.previousSlot = -1;
        this.countdown = 0;
    }

    @Override
    public void onTick() {
        if (SpearSwap.mc.field_1724 == null || SpearSwap.mc.field_1690 == null) {
            return;
        }
        class_1661 class_16612 = SpearSwap.mc.field_1724.method_31548();
        if (this.countdown > 0) {
            --this.countdown;
            if (this.countdown == 0) {
                if (this.switchBack.getValue().booleanValue() && this.previousSlot >= 0 && this.previousSlot < 9 && class_16612.method_67532() != this.previousSlot) {
                    class_16612.method_61496(this.previousSlot);
                }
                this.previousSlot = -1;
            }
        }
        if (SpearSwap.mc.field_1690.field_1886.method_1434()) {
            this.preAttack();
        } else {
            this.noAttack();
        }
    }

    private int findBestWeaponSlot() {
        class_1661 class_16612 = SpearSwap.mc.field_1724.method_31548();
        boolean bl = this.onlySword.getValue();
        boolean bl2 = this.onlyAxe.getValue();
        boolean bl3 = this.lunge.getValue();
        boolean bl4 = this.sharpness.getValue();
        int n = -1;
        int n2 = Integer.MIN_VALUE;
        for (int i = 0; i < 9; ++i) {
            class_1799 class_17992 = class_16612.method_5438(i);
            if (class_17992.method_7960()) continue;
            String string = class_7923.field_41178.method_10221((Object)class_17992.method_7909()).method_12832();
            String string2 = "";
            try {
                string2 = class_17992.method_7964().getString().toLowerCase();
            }
            catch (Throwable throwable) {}
            boolean bl5 = string.endsWith("_sword");
            boolean bl6 = class_17992.method_7909() instanceof class_1743;
            boolean bl7 = class_17992.method_7909() == class_1802.field_8547 || class_17992.method_7909() == class_1802.field_49814 || string.contains("spear") || string2.contains("spear");
            boolean bl8 = this.hasLungeEnchant(class_17992);
            boolean bl9 = bl8 = bl3 && bl8;
            if (bl && !bl5 || bl2 && !bl6 || !bl && !bl2 && !bl5 && !bl6 && !bl7 && !bl8) continue;
            int n3 = 0;
            if (bl8) {
                n3 += 500;
            }
            if (bl7) {
                n3 += 300;
            } else if (bl5) {
                n3 += 200;
            } else if (bl6) {
                n3 += 100;
            }
            if (bl4) {
                n3 += this.sharpnessLevel(class_17992) * 60;
            }
            if (n3 <= n2) continue;
            n2 = n3;
            n = i;
        }
        return n;
    }

    private boolean hasLungeEnchant(class_1799 object) {
        try {
            object = (class_9304)object.method_58694(class_9334.field_49633);
            if (object == null) {
                return false;
            }
            for (Object object2 : object.method_57534()) {
                if ((object2 = (class_5321)object2.method_40230().orElse(null)) == null) continue;
                if (object2.equals(class_1893.field_50159) || object2.equals(class_1893.field_50157) || object2.equals(class_1893.field_9104)) {
                    return true;
                }
                if (!((String)(object2 = object2.method_29177().toString().toLowerCase())).contains("lunge")) continue;
                return true;
            }
        }
        catch (Throwable throwable) {}
        return false;
    }

    private int sharpnessLevel(class_1799 class_17992) {
        try {
            class_17992 = (class_9304)class_17992.method_58694(class_9334.field_49633);
            if (class_17992 == null) {
                return 0;
            }
            for (class_6880 class_68802 : class_17992.method_57534()) {
                class_5321 class_53212 = class_68802.method_40230().orElse(null);
                if (class_53212 == null || !class_53212.equals(class_1893.field_9118)) continue;
                return class_17992.method_57536(class_68802);
            }
        }
        catch (Throwable throwable) {}
        return 0;
    }
}

