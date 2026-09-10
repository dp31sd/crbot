package dev.krypton.diddy.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   targets = {"vp"},
   priority = 2000
)
public abstract class VpInputMixin {
   @Inject(
      method = {"method_25421"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void krypton$doNotPauseGame(CallbackInfoReturnable<Boolean> var1) {
      var1.setReturnValue(false);
   }
}
