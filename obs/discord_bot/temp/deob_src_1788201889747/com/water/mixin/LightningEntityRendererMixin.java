/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.render.NoRender;
import net.minecraft.class_10041;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.class_4587;
import net.minecraft.class_919;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_919.class})
public class LightningEntityRendererMixin {
    @Inject(method={"render(Lnet/minecraft/client/render/entity/state/LightningEntityRenderState;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/render/state/CameraRenderState;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$hideLightningEntity(class_10041 class_100412, class_4587 class_45872, class_11659 class_116592, class_12075 class_120752, CallbackInfo callbackInfo) {
        if (NoRender.hideThunder()) {
            callbackInfo.cancel();
        }
    }
}

