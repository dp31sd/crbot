/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.ModuleManager;
import com.water.module.modules.misc.AutoMine;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_239;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3965;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_310.class})
public class AutoMineMixin {
    private class_2338 autoMineLastPos = null;
    private boolean autoMineActive = false;

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void onTick(CallbackInfo callbackInfo) {
        boolean bl;
        class_310 class_3102 = (class_310)this;
        AutoMine autoMine = (AutoMine)ModuleManager.INSTANCE.getModuleByName("AutoMine");
        if (autoMine == null || !autoMine.isEnabled()) {
            if (this.autoMineActive) {
                this.autoMineActive = false;
                this.autoMineLastPos = null;
            }
            return;
        }
        if (class_3102.field_1724 == null || class_3102.field_1687 == null || class_3102.field_1761 == null) {
            return;
        }
        if (class_3102.field_1755 != null) {
            return;
        }
        boolean bl2 = bl = GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)0) == 1;
        if (bl) {
            this.autoMineActive = false;
            this.autoMineLastPos = null;
            return;
        }
        class_239 class_2392 = class_3102.field_1765;
        if (class_2392 == null || class_2392.method_17783() != class_239.class_240.field_1332) {
            this.autoMineLastPos = null;
            this.autoMineActive = false;
            return;
        }
        class_3965 class_39652 = (class_3965)class_2392;
        class_2338 class_23382 = class_39652.method_17777();
        class_2680 class_26802 = class_3102.field_1687.method_8320(class_23382);
        if (class_26802.method_26215() || class_26802.method_26214((class_1922)class_3102.field_1687, class_23382) < 0.0f) {
            this.autoMineLastPos = null;
            this.autoMineActive = false;
            return;
        }
        class_3102.field_1690.field_1886.method_23481(true);
        this.autoMineActive = true;
        this.autoMineLastPos = class_23382;
    }
}

