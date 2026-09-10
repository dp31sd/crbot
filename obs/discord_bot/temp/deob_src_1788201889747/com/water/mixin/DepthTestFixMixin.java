/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import net.minecraft.class_757;
import net.minecraft.class_9779;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_757.class})
public class DepthTestFixMixin {
    @Inject(method={"renderHand"}, at={@At(value="HEAD")})
    private void onBeforeRenderHand(float f, boolean bl, Matrix4f matrix4f, CallbackInfo callbackInfo) {
        GL11.glDepthMask((boolean)true);
    }

    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void onRenderReturn(class_9779 class_97792, boolean bl, CallbackInfo callbackInfo) {
        GL11.glDepthMask((boolean)true);
    }
}

