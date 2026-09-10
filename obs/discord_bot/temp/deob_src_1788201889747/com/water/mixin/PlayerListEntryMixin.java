/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.mojang.authlib.GameProfile;
import com.water.module.modules.donut.FakeRoles;
import com.water.module.modules.misc.SkinChanger;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_640;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_640.class})
public abstract class PlayerListEntryMixin {
    @Shadow
    public abstract GameProfile method_2966();

    @Inject(method={"getSkinTextures"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$overrideListEntrySkin(CallbackInfoReturnable<class_8685> callbackInfoReturnable) {
        GameProfile gameProfile = this.method_2966();
        if (gameProfile == null || gameProfile.id() == null) {
            return;
        }
        class_8685 class_86852 = SkinChanger.getOverrideSkin(gameProfile.id());
        if (class_86852 != null) {
            callbackInfoReturnable.setReturnValue((Object)class_86852);
        }
    }

    @Inject(method={"getDisplayName"}, at={@At(value="RETURN")}, cancellable=true)
    private void water$fakeRoleDisplayName(CallbackInfoReturnable<class_2561> callbackInfoReturnable) {
        if (!FakeRoles.isActive()) {
            return;
        }
        GameProfile gameProfile = this.method_2966();
        class_310 class_3102 = class_310.method_1551();
        if (gameProfile == null || gameProfile.id() == null || class_3102 == null || class_3102.field_1724 == null) {
            return;
        }
        if (!gameProfile.id().equals(class_3102.field_1724.method_5667())) {
            return;
        }
        class_2561 class_25612 = FakeRoles.buildPrefixedDisplayName(gameProfile.name());
        if (class_25612 != null) {
            callbackInfoReturnable.setReturnValue((Object)class_25612);
        }
    }
}

