/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.misc.SwingSpeed;
import net.minecraft.class_1268;
import net.minecraft.class_1292;
import net.minecraft.class_1294;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1309.class})
public class LivingEntityMixin {
    @Inject(method={"getHandSwingDuration"}, at={@At(value="HEAD")}, cancellable=true)
    private void onGetHandSwingDuration(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        SwingSpeed swingSpeed = SwingSpeed.instance;
        if (swingSpeed == null || !swingSpeed.isEnabled()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null || this != class_3102.field_1724) {
            return;
        }
        class_1309 class_13092 = (class_1309)this;
        class_1799 class_17992 = class_13092.method_5998(class_1268.field_5808);
        int n = class_17992.method_75218().comp_4976();
        if (class_1292.method_5576((class_1309)class_13092)) {
            n -= 1 + class_1292.method_5575((class_1309)class_13092);
        } else if (class_13092.method_6059(class_1294.field_5901)) {
            n += (1 + class_13092.method_6112(class_1294.field_5901).method_5578()) * 2;
        }
        float f = swingSpeed.getSwingSpeed();
        int n2 = Math.max(1, Math.round((float)n / f));
        callbackInfoReturnable.setReturnValue((Object)n2);
    }
}

