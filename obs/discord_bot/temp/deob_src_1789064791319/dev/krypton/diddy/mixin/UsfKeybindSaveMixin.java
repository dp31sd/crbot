package dev.krypton.diddy.mixin;

import dev.krypton.diddy.DiddyEntrypoint;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   targets = {"usf"},
   priority = 2000
)
public abstract class UsfKeybindSaveMixin {
   @Inject(
      method = {"mw"},
      at = {@At("TAIL")},
      require = 0
   )
   private void krypton$saveConfigAfterKeybindChanged(int var1, CallbackInfo var2) {
      DiddyEntrypoint.saveConfig();
   }
}
