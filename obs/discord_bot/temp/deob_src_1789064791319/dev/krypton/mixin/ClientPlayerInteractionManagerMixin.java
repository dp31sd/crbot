package dev.krypton.mixin;

import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_636;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_636.class})
public class ClientPlayerInteractionManagerMixin {
   @Inject(
      method = {"method_2910"},
      at = {@At("HEAD")}
   )
   private void onAttackBlock(class_2338 var1, class_2350 var2, CallbackInfoReturnable<Boolean> var3) {
      Class_202.method_559(new Class_48(var1, var2));
   }
}
