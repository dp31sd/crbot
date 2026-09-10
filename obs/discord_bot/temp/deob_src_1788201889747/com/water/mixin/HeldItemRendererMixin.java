/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.misc.Freelook;
import net.minecraft.class_759;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_759.class})
public class HeldItemRendererMixin {
    @Inject(method={"renderFirstPersonItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderFirstPersonItem(CallbackInfo callbackInfo) {
        if (Freelook.instance != null && Freelook.instance.isCameraActive()) {
            callbackInfo.cancel();
        }
    }
}

