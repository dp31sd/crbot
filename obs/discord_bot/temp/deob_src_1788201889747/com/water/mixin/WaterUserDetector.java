/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.misc.NameTags;
import java.util.UUID;
import net.minecraft.class_634;
import net.minecraft.class_7828;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_634.class})
public class WaterUserDetector {
    @Inject(method={"onPlayerRemove"}, at={@At(value="HEAD")})
    private void onPlayerRemove(class_7828 class_78282, CallbackInfo callbackInfo) {
        try {
            for (UUID uUID : class_78282.comp_1105()) {
                NameTags.removeWaterUser(uUID);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

