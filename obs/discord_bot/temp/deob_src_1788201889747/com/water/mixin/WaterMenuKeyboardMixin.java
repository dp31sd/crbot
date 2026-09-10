/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.WaterClient;
import com.water.module.modules.client.WaterPlus;
import net.minecraft.class_11908;
import net.minecraft.class_309;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_309.class})
public class WaterMenuKeyboardMixin {
    @Unique
    private boolean water$menuKeyDown = false;

    @Inject(method={"onKey"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$openClickGuiFromAnyScreen(long l, int n, class_11908 class_119082, CallbackInfo callbackInfo) {
        boolean bl;
        int n2 = WaterPlus.getGuiKey();
        boolean bl2 = bl = GLFW.glfwGetKey((long)l, (int)n2) == 1;
        if (bl && !this.water$menuKeyDown) {
            WaterClient.toggleClickGui();
            callbackInfo.cancel();
        }
        this.water$menuKeyDown = bl;
    }
}

