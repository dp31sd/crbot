/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.donut.FakeStats;
import net.minecraft.class_2561;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_332;
import net.minecraft.class_355;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_355.class})
public class PlayerListHudMixin {
    @Shadow
    private class_2561 field_2154;

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void water$fakeFooter(class_332 class_3322, int n, class_269 class_2692, class_266 class_2662, CallbackInfo callbackInfo) {
        FakeStats fakeStats = FakeStats.getInstance();
        if (fakeStats == null || !fakeStats.isEnabled() || this.field_2154 == null) {
            return;
        }
        class_2561 class_25612 = fakeStats.fakeFooterText(this.field_2154);
        if (class_25612 != null) {
            this.field_2154 = class_25612;
        }
    }
}

