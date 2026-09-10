/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.utils.NametagRenderState;
import net.minecraft.class_11689;
import net.minecraft.class_2561;
import net.minecraft.class_327;
import net.minecraft.class_4597;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_11689.class})
public class LabelCommandRendererMixin {
    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/font/TextRenderer;draw(Lnet/minecraft/text/Text;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/font/TextRenderer$TextLayerType;II)V", ordinal=1), require=0)
    private void water$drawHealthLabelsWithOutline(class_327 class_3272, class_2561 class_25612, float f, float f2, int n, boolean bl, Matrix4f matrix4f, class_4597 class_45972, class_327.class_6415 class_64152, int n2, int n3) {
        if (!NametagRenderState.isOutlinedLabel(class_25612)) {
            class_3272.method_27522(class_25612, f, f2, n, bl, matrix4f, class_45972, class_64152, n2, n3);
            return;
        }
        class_3272.method_37296(class_25612.method_30937(), f, f2, n, -16777216, matrix4f, class_45972, n3);
    }
}

