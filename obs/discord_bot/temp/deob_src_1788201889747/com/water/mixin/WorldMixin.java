/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.render.NoRender;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1937.class})
public class WorldMixin {
    @Inject(method={"getRainGradient"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$hideRainGradient(float f, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (NoRender.hideRainGradient()) {
            callbackInfoReturnable.setReturnValue((Object)Float.valueOf(0.0f));
        }
    }

    @Inject(method={"getThunderGradient"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$hideThunderGradient(float f, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        if (NoRender.hideThunder()) {
            callbackInfoReturnable.setReturnValue((Object)Float.valueOf(0.0f));
        }
    }

    @Inject(method={"playSoundClient(DDDLnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFZ)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$cancelWeatherPointSound(double d2, double d3, double d4, class_3414 class_34142, class_3419 class_34192, float f, float f2, boolean bl, CallbackInfo callbackInfo) {
        if (NoRender.shouldCancelWeatherSound(class_34142)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"playSoundAtBlockCenterClient(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FFZ)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$cancelWeatherBlockSound(class_2338 class_23382, class_3414 class_34142, class_3419 class_34192, float f, float f2, boolean bl, CallbackInfo callbackInfo) {
        if (NoRender.shouldCancelWeatherSound(class_34142)) {
            callbackInfo.cancel();
        }
    }
}

