/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.gui.HudEditor;
import com.water.gui.hud.SpotifyQueueHud;
import net.minecraft.class_11909;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_408;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_408.class})
public class ChatScreenMixin {
    @Inject(method={"mouseClicked"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$mouseClicked(class_11909 class_119092, boolean bl, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        double d2 = class_119092.comp_4798();
        double d3 = class_119092.comp_4799();
        int n = class_119092.method_74245();
        if (n == 0) {
            if (SpotifyQueueHud.onMouseClick(d2, d3, n)) {
                callbackInfoReturnable.setReturnValue((Object)true);
                return;
            }
            if (HudEditor.INSTANCE.onMouseClick(d2, d3, n)) {
                HudEditor.isEditing = true;
                callbackInfoReturnable.setReturnValue((Object)true);
            }
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void water$render(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null) {
            boolean bl;
            boolean bl2 = bl = GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)0) == 1;
            if (!bl) {
                SpotifyQueueHud.onMouseRelease();
                HudEditor.INSTANCE.onMouseRelease();
                HudEditor.isEditing = false;
            }
        }
        HudEditor.INSTANCE.render(class_3322, n, n2);
    }
}

