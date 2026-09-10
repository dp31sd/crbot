package dev.krypton.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_4076;
import net.minecraft.class_862;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin({class_862.class})
public abstract class ChunkBorderDebugRendererMixin {
   @Shadow
   @Final
   private class_310 field_4516;

   @ModifyExpressionValue(
      method = {"method_23109"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4076;method_18682(Lnet/minecraft/class_2338;)Lnet/minecraft/class_4076;"
      )}
   )
   private class_4076 render$getChunkPos(class_4076 var1) {
      Class_205 var2 = (Class_205)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_205.class);
      if (!var2.pbm()) {
         return var1;
      } else {
         float var3 = this.field_4516.method_61966().method_60637(true);
         return class_4076.method_18676(
            class_4076.method_18675(class_3532.method_15357(var2.method_1742(var3))),
            class_4076.method_18675(class_3532.method_15357(var2.method_1743(var3))),
            class_4076.method_18675(class_3532.method_15357(var2.method_1744(var3)))
         );
      }
   }
}
