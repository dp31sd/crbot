package dev.krypton.mixin;

import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_2818.class})
public class WorldChunkMixin {
   @Shadow
   @Final
   class_1937 field_12858;

   @Inject(
      method = {"method_12010"},
      at = {@At("TAIL")}
   )
   private void onSetBlockState(class_2338 var1, class_2680 var2, int var3, CallbackInfoReturnable<class_2680> var4) {
      if (this.field_12858.method_8608()) {
         Class_202.method_559(new Class_302(var1, (class_2680)var4.getReturnValue(), var2));
      }
   }
}
