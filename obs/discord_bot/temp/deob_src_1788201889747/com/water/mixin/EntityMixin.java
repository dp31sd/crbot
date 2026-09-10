/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.donut.FakeRoles;
import com.water.module.modules.misc.Freelook;
import com.water.module.modules.misc.NameProtect;
import com.water.module.modules.render.Freecam;
import net.minecraft.class_1297;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1297.class})
public class EntityMixin {
    @Inject(method={"changeLookDirection"}, at={@At(value="HEAD")}, cancellable=true)
    private void onChangeLookDirection(double d2, double d3, CallbackInfo callbackInfo) {
        class_1297 class_12972 = (class_1297)this;
        if (class_12972 != class_310.method_1551().field_1724) {
            return;
        }
        if (Freecam.instance != null && Freecam.instance.isEnabled()) {
            Freecam.instance.updateRotation(d2 * 0.15 * (double)Freecam.instance.getLookSensitivity(), d3 * 0.15 * (double)Freecam.instance.getLookSensitivity());
            callbackInfo.cancel();
            return;
        }
        if (Freelook.instance != null && Freelook.instance.isCameraActive()) {
            Freelook.instance.consumeMouseDelta(d2, d3);
            callbackInfo.cancel();
        }
    }

    @Inject(method={"isSneaking"}, at={@At(value="HEAD")}, cancellable=true)
    private void onIsSneaking(CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (Freecam.instance != null && Freecam.instance.isEnabled() && this == class_310.method_1551().field_1724) {
            callbackInfoReturnable.setReturnValue((Object)Freecam.instance.shouldRenderSneaking());
        }
    }

    @Inject(method={"shouldRender(D)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private void onShouldRender(double d2, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        if (Freecam.instance != null && Freecam.instance.isEnabled() && d2 < 25600.0) {
            callbackInfoReturnable.setReturnValue((Object)true);
        }
    }

    @Inject(method={"getDisplayName"}, at={@At(value="RETURN")}, cancellable=true)
    private void onGetDisplayName(CallbackInfoReturnable<class_2561> callbackInfoReturnable) {
        String string;
        class_2561 class_25612;
        Object object;
        if (FakeRoles.isActive() && (object = FakeRoles.modifyChatText((class_2561)callbackInfoReturnable.getReturnValue())) != callbackInfoReturnable.getReturnValue()) {
            callbackInfoReturnable.setReturnValue(object);
            return;
        }
        if (NameProtect.instance != null && NameProtect.instance.isEnabled() && class_310.method_1551().method_1548() != null && (object = class_310.method_1551().method_1548().method_1676()) != null && (class_25612 = (class_2561)callbackInfoReturnable.getReturnValue()) != null && (string = class_25612.getString()).contains((CharSequence)object)) {
            callbackInfoReturnable.setReturnValue((Object)class_2561.method_43470((String)string.replace((CharSequence)object, NameProtect.instance.getFakeName())));
        }
    }

    @Inject(method={"getName"}, at={@At(value="RETURN")}, cancellable=true)
    private void onGetName(CallbackInfoReturnable<class_2561> callbackInfoReturnable) {
        String string;
        class_2561 class_25612;
        Object object;
        if (FakeRoles.isActive() && (object = FakeRoles.modifyChatText((class_2561)callbackInfoReturnable.getReturnValue())) != callbackInfoReturnable.getReturnValue()) {
            callbackInfoReturnable.setReturnValue(object);
            return;
        }
        if (NameProtect.instance != null && NameProtect.instance.isEnabled() && class_310.method_1551().method_1548() != null && (object = class_310.method_1551().method_1548().method_1676()) != null && (class_25612 = (class_2561)callbackInfoReturnable.getReturnValue()) != null && (string = class_25612.getString()).contains((CharSequence)object)) {
            callbackInfoReturnable.setReturnValue((Object)class_2561.method_43470((String)string.replace((CharSequence)object, NameProtect.instance.getFakeName())));
        }
    }
}

