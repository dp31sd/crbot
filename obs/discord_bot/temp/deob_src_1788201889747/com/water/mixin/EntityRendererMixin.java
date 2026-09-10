/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.combat.Hitbox;
import com.water.module.modules.misc.NameTags;
import com.water.utils.NametagRenderState;
import net.minecraft.class_10017;
import net.minecraft.class_11659;
import net.minecraft.class_12075;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_4587;
import net.minecraft.class_897;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_897.class})
public class EntityRendererMixin {
    @Inject(method={"updateRenderState"}, at={@At(value="TAIL")})
    private void water$updateNametagState(class_1297 class_12972, class_10017 class_100172, float f, CallbackInfo callbackInfo) {
        class_1309 class_13092;
        block5: {
            block4: {
                if (!(class_12972 instanceof class_1309)) break block4;
                class_13092 = (class_1309)class_12972;
                if (NameTags.isActive()) break block5;
            }
            NametagRenderState.clear(class_100172);
            return;
        }
        NameTags nameTags = NameTags.instance;
        if (nameTags == null || !nameTags.shouldRenderForState(class_13092, class_100172.field_53332) || class_100172.field_53333) {
            NametagRenderState.clear(class_100172);
            return;
        }
        NametagRenderState.mark(class_100172);
    }

    @Inject(method={"renderLabelIfPresent"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$renderCustomNametag(class_10017 class_100172, class_4587 class_45872, class_11659 class_116592, class_12075 class_120752, CallbackInfo callbackInfo) {
        if (!NametagRenderState.hasEntry(class_100172)) {
            return;
        }
        callbackInfo.cancel();
    }

    @Inject(method={"getShadowRadius"}, at={@At(value="RETURN")}, cancellable=true)
    private void water$hitbox(class_10017 class_100172, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        Hitbox hitbox = Hitbox.INSTANCE;
        if (hitbox != null && hitbox.isEnabled()) {
            callbackInfoReturnable.setReturnValue((Object)Float.valueOf(((Float)callbackInfoReturnable.getReturnValue()).floatValue() + hitbox.size.getValue().floatValue()));
        }
    }
}

