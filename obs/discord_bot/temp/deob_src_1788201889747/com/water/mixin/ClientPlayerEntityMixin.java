/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_746.class})
public class ClientPlayerEntityMixin {
    @Inject(method={"tickMovement"}, at={@At(value="HEAD")})
    private void onTickMovement(CallbackInfo callbackInfo) {
    }
}

