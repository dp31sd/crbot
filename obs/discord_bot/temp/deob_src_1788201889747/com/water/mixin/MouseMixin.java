/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.gui.HudEditor;
import com.water.gui.hud.SpotifyQueueHud;
import com.water.module.modules.render.Freecam;
import net.minecraft.class_11909;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_408;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_312.class})
public class MouseMixin {
    private static double toScaledX(class_310 class_3102, double d2) {
        if (class_3102 == null || class_3102.method_22683() == null) {
            return d2;
        }
        double d3 = class_3102.method_22683().method_4480();
        if (d3 <= 0.0) {
            return d2;
        }
        return d2 * ((double)class_3102.method_22683().method_4486() / d3);
    }

    private static double toScaledY(class_310 class_3102, double d2) {
        if (class_3102 == null || class_3102.method_22683() == null) {
            return d2;
        }
        double d3 = class_3102.method_22683().method_4507();
        if (d3 <= 0.0) {
            return d2;
        }
        return d2 * ((double)class_3102.method_22683().method_4502() / d3);
    }

    @Inject(method={"onMouseButton"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void water$hudEditorMouseButtonClick(long l, @Coerce Object object, int n, CallbackInfo callbackInfo) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || !(class_3102.field_1755 instanceof class_408)) {
            return;
        }
        if (!(object instanceof class_11909)) {
            return;
        }
        class_11909 class_119092 = (class_11909)object;
        if (n == 1) {
            double d2;
            double d3 = MouseMixin.toScaledX(class_3102, class_119092.comp_4798());
            if (SpotifyQueueHud.onMouseClick(d3, d2 = MouseMixin.toScaledY(class_3102, class_119092.comp_4799()), class_119092.method_74245())) {
                callbackInfo.cancel();
                return;
            }
            if (HudEditor.INSTANCE.onMouseClick(class_119092.comp_4798(), class_119092.comp_4799(), class_119092.method_74245())) {
                callbackInfo.cancel();
            }
        } else if (n == 0) {
            SpotifyQueueHud.onMouseRelease();
            HudEditor.INSTANCE.onMouseRelease();
        }
    }

    @Inject(method={"onCursorPos"}, at={@At(value="HEAD")}, require=0)
    private void water$hudEditorCursorPos(long l, double d2, double d3, CallbackInfo callbackInfo) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1724 == null) {
            return;
        }
        if (!(class_3102.field_1755 instanceof class_408)) {
            return;
        }
        boolean bl = SpotifyQueueHud.isDragging();
        boolean bl2 = HudEditor.INSTANCE.isDragging();
        if (!bl && !bl2) {
            return;
        }
        if (GLFW.glfwGetMouseButton((long)l, (int)0) != 1) {
            SpotifyQueueHud.onMouseRelease();
            HudEditor.INSTANCE.onMouseRelease();
            return;
        }
        if (bl) {
            SpotifyQueueHud.onMouseDrag(MouseMixin.toScaledX(class_3102, d2), MouseMixin.toScaledY(class_3102, d3));
        } else {
            HudEditor.INSTANCE.onMouseDrag(MouseMixin.toScaledX(class_3102, d2), MouseMixin.toScaledY(class_3102, d3));
        }
    }

    @Inject(method={"onMouseScroll"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$useScrollForFreecamSpeed(long l, double d2, double d3, CallbackInfo callbackInfo) {
        double d4;
        if (Freecam.instance == null || !Freecam.instance.isEnabled()) {
            return;
        }
        if (class_310.method_1551().field_1755 != null) {
            return;
        }
        double d5 = d4 = d3 != 0.0 ? d3 : d2;
        if (d4 == 0.0) {
            return;
        }
        Freecam.instance.adjustSpeed(d4);
        callbackInfo.cancel();
    }

    @Inject(method={"onMouseScroll"}, at={@At(value="HEAD")}, cancellable=true)
    private void water$hudEditorMouseScroll(long l, double d2, double d3, CallbackInfo callbackInfo) {
        double d4;
        double d5;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || !(class_3102.field_1755 instanceof class_408)) {
            return;
        }
        double d6 = d5 = d3 != 0.0 ? d3 : d2;
        if (d5 == 0.0) {
            return;
        }
        double d7 = MouseMixin.toScaledX(class_3102, class_3102.field_1729.method_1603());
        if (SpotifyQueueHud.onScroll(d7, d4 = MouseMixin.toScaledY(class_3102, class_3102.field_1729.method_1604()), d5)) {
            callbackInfo.cancel();
            return;
        }
        if (HudEditor.INSTANCE.onMouseScroll(d7, d4, d5)) {
            callbackInfo.cancel();
        }
    }
}

