package dev.krypton.mixin;

import net.minecraft.class_2794;
import net.minecraft.class_5868;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin({class_5868.class})
public abstract class HeightContextMixin {
   @Redirect(
      method = {"<init>"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_2794;method_33730()I"
      )
   )
   private int onMinY(class_2794 var1) {
      return var1 == null ? -9999999 : var1.method_33730();
   }

   @Redirect(
      method = {"<init>"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_2794;method_12104()I"
      )
   )
   private int onHeight(class_2794 var1) {
      return var1 == null ? 100000000 : var1.method_12104();
   }
}
