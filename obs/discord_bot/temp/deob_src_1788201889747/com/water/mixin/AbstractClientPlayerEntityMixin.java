/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.misc.SkinChanger;
import net.minecraft.class_742;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_742.class})
public abstract class AbstractClientPlayerEntityMixin {
    @Inject(method={"getSkin"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$overrideOwnSkin(CallbackInfoReturnable<class_8685> callbackInfoReturnable) {
        class_742 class_7422 = (class_742)this;
        class_8685 class_86852 = SkinChanger.getOverrideSkin(class_7422.method_5667());
        if (class_86852 != null) {
            callbackInfoReturnable.setReturnValue((Object)class_86852);
        }
    }
}

