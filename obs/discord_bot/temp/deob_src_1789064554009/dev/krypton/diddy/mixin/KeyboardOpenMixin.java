package dev.krypton.diddy.mixin;

import dev.krypton.diddy.DiddyEntrypoint;
import net.minecraft.class_11908;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   targets = {"net.minecraft.class_309"},
   priority = 2000
)
public abstract class KeyboardOpenMixin {
   @Inject(
      method = {"method_1466"},
      at = {@At("HEAD")}
   )
   private void krypton$openClickGuiOnRightShift(long var1, int var3, class_11908 var4, CallbackInfo var5) {
      DiddyEntrypoint.handleKeyPress(var1, var3, var4);
   }
}
