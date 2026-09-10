package dev.krypton.diddy.mixin;

import dev.krypton.diddy.DiddyEntrypoint;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   targets = {"dc", "efi", "em", "fpb", "gr", "hq", "kq", "lo", "mo", "pdf", "to", "wo", "yl", "zf", "zm", "zv"},
   priority = 2000
)
public abstract class SettingSaveMixin {
   @Inject(
      method = {"l"},
      at = {@At("TAIL")},
      require = 0
   )
   private void krypton$saveConfigAfterSettingChanged(CallbackInfo var1) {
      DiddyEntrypoint.saveConfig();
   }
}
