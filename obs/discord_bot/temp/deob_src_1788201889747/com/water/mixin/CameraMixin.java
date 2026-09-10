/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.misc.Freelook;
import com.water.module.modules.render.Freecam;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_4184.class})
public abstract class CameraMixin {
    @Shadow
    protected abstract void method_19327(double var1, double var3, double var5);

    @Shadow
    protected abstract void method_19325(float var1, float var2);

    @Shadow
    protected abstract float method_19318(float var1);

    @Shadow
    protected abstract void method_19324(float var1, float var2, float var3);

    @Inject(method={"update"}, at={@At(value="TAIL")})
    private void onUpdate(class_1937 class_19372, class_1297 class_12972, boolean bl, boolean bl2, float f, CallbackInfo callbackInfo) {
        if (Freecam.instance != null && Freecam.instance.isEnabled()) {
            Freecam.instance.updateCameraMovement();
            double d2 = Freecam.instance.getInterpolatedX(f);
            double d3 = Freecam.instance.getInterpolatedY(f);
            double d4 = Freecam.instance.getInterpolatedZ(f);
            float f2 = Freecam.instance.getInterpolatedYaw(f);
            float f3 = Freecam.instance.getInterpolatedPitch(f);
            this.method_19327(d2, d3, d4);
            this.method_19325(f2, f3);
            return;
        }
        Freelook freelook = Freelook.instance;
        if (freelook != null && freelook.isCameraActive() && class_12972 != null) {
            class_243 class_2432 = class_12972.method_5836(f);
            this.method_19325(freelook.getCameraYaw(), freelook.getCameraPitch());
            this.method_19327(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
            float f4 = freelook.getDistance();
            if (!freelook.shouldWallClip()) {
                f4 = this.method_19318(f4);
            }
            this.method_19324(-f4, 0.0f, 0.0f);
        }
    }

    @Inject(method={"isThirdPerson"}, at={@At(value="HEAD")}, cancellable=true)
    private void onIsThirdPerson(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (Freecam.instance != null && Freecam.instance.isEnabled()) {
            callbackInfoReturnable.setReturnValue((Object)true);
            return;
        }
        if (Freelook.instance != null && Freelook.instance.isCameraActive()) {
            callbackInfoReturnable.setReturnValue((Object)true);
        }
    }
}

