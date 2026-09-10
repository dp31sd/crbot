/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.utils.FakeRolesUtil;
import com.water.utils.NameProtectUtil;
import net.minecraft.class_327;
import net.minecraft.class_5348;
import net.minecraft.class_5481;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value={class_327.class})
public class TextRendererMixin {
    @ModifyVariable(method={"prepare(Ljava/lang/String;FFIZI)Lnet/minecraft/client/font/TextRenderer$GlyphDrawable;"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    private String water$replacePreparedString(String string) {
        return FakeRolesUtil.replace(NameProtectUtil.replace(string));
    }

    @ModifyVariable(method={"prepare(Lnet/minecraft/text/OrderedText;FFIZZI)Lnet/minecraft/client/font/TextRenderer$GlyphDrawable;"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    private class_5481 water$replacePreparedOrderedText(class_5481 class_54812) {
        return FakeRolesUtil.replace(NameProtectUtil.replace(class_54812));
    }

    @ModifyVariable(method={"drawWithOutline(Lnet/minecraft/text/OrderedText;FFIILorg/joml/Matrix4f;Lnet/minecraft/client/render/VertexConsumerProvider;I)V"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    private class_5481 water$replaceOutlinedOrderedText(class_5481 class_54812) {
        return FakeRolesUtil.replace(NameProtectUtil.replace(class_54812));
    }

    @ModifyVariable(method={"getWidth(Ljava/lang/String;)I"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    private String water$replaceWidthString(String string) {
        return FakeRolesUtil.replace(NameProtectUtil.replace(string));
    }

    @ModifyVariable(method={"getWidth(Lnet/minecraft/text/StringVisitable;)I"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    private class_5348 water$replaceWidthVisitable(class_5348 class_53482) {
        return FakeRolesUtil.replace(NameProtectUtil.replace(class_53482));
    }

    @ModifyVariable(method={"getWidth(Lnet/minecraft/text/OrderedText;)I"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    private class_5481 water$replaceWidthOrderedText(class_5481 class_54812) {
        return FakeRolesUtil.replace(NameProtectUtil.replace(class_54812));
    }
}

