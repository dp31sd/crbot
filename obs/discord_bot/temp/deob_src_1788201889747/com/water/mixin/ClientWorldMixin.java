/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.render.NoRender;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_638.class})
public class ClientWorldMixin {
    @Inject(method={"getLightningTicksLeft"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$hideLightningFlash(CallbackInfoReturnable<Integer> callbackInfoReturnable) {
        if (NoRender.hideThunder()) {
            callbackInfoReturnable.setReturnValue((Object)0);
        }
    }
}

