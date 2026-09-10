/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.combat.SpearSwap;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_310.class})
public class MinecraftClientAttackMixin {
    @Inject(method={"handleInputEvents"}, at={@At(value="HEAD")}, require=0)
    private void water$preInput(CallbackInfo callbackInfo) {
        SpearSwap spearSwap = SpearSwap.INSTANCE;
        if (spearSwap == null || !spearSwap.isEnabled()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1724 == null || class_3102.field_1690 == null) {
            return;
        }
        if (class_3102.field_1755 != null) {
            return;
        }
        if (class_3102.field_1690.field_1886.method_1434()) {
            spearSwap.preAttack();
        } else {
            spearSwap.noAttack();
        }
    }
}

