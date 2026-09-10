/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.utils.NametagRenderState;
import net.minecraft.class_10017;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.class_4587;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1007.class})
public class PlayerEntityRendererMixin {
    @Inject(method={"renderLabelIfPresent"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$renderPlayerNametag(class_10055 class_100552, class_4587 class_45872, class_11659 class_116592, class_12075 class_120752, CallbackInfo callbackInfo) {
        if (!NametagRenderState.hasEntry((class_10017)class_100552)) {
            return;
        }
        callbackInfo.cancel();
    }
}

