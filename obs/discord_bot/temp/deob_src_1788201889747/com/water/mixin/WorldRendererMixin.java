/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.water.module.ModuleManager;
import com.water.module.modules.render.NoRender;
import com.water.utils.RenderUtils;
import com.water.utils.renderer.ProjectionUtil;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_761;
import net.minecraft.class_9779;
import net.minecraft.class_9909;
import net.minecraft.class_9922;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_761.class})
public class WorldRendererMixin {
    private static final Matrix4f capturedMatrix = new Matrix4f();
    private static boolean hasCapturedMatrix;
    private static float capturedTickDelta;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void captureRenderState(class_9922 class_99222, class_9779 class_97792, boolean bl, class_4184 class_41842, Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3, GpuBufferSlice gpuBufferSlice, Vector4f vector4f, boolean bl2, CallbackInfo callbackInfo) {
        capturedMatrix.set((Matrix4fc)matrix4f);
        ProjectionUtil.modelViewMatrix.set((Matrix4fc)matrix4f);
        ProjectionUtil.positionMatrix.set((Matrix4fc)matrix4f);
        ProjectionUtil.projectionMatrix.set((Matrix4fc)matrix4f2);
        RenderUtils.updateFrustum(matrix4f, matrix4f2, class_41842.method_71156());
        hasCapturedMatrix = true;
        capturedTickDelta = class_97792.method_60637(false);
    }

    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void onRender(CallbackInfo callbackInfo) {
        if (hasCapturedMatrix) {
            class_4587 class_45872 = new class_4587();
            class_45872.method_34425((Matrix4fc)capturedMatrix);
            try {
                ModuleManager.INSTANCE.onRender(class_45872, capturedTickDelta);
            }
            finally {
                RenderUtils.restoreWorldDepthState();
            }
        }
    }

    @Inject(method={"renderWeather"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$skipWeatherPass(class_9909 class_99092, GpuBufferSlice gpuBufferSlice, CallbackInfo callbackInfo) {
        if (NoRender.hideAllPrecipitation()) {
            callbackInfo.cancel();
        }
    }

    static {
        capturedTickDelta = 1.0f;
    }
}

