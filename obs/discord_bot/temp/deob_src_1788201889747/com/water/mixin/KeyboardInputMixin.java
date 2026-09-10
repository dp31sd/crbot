/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.mixin.InputAccessor;
import com.water.module.modules.render.Freecam;
import net.minecraft.class_10185;
import net.minecraft.class_241;
import net.minecraft.class_743;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_743.class})
public class KeyboardInputMixin {
    @Inject(method={"tick()V"}, at={@At(value="RETURN")})
    private void onTickReturn(CallbackInfo callbackInfo) {
        if (Freecam.instance != null && Freecam.instance.isEnabled()) {
            InputAccessor inputAccessor = (InputAccessor)((Object)this);
            if (Freecam.instance.shouldKeepMovement()) {
                inputAccessor.water$setPlayerInput(Freecam.instance.getHeldMovementInput());
                inputAccessor.water$setMovementVector(Freecam.instance.getHeldMovementVector());
            } else {
                inputAccessor.water$setPlayerInput(new class_10185(false, false, false, false, false, false, false));
                inputAccessor.water$setMovementVector(class_241.field_1340);
            }
        }
    }
}

