package dev.krypton.diddy.mixin;

import dev.krypton.diddy.DiddyEntrypoint;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   targets = {"net.minecraft.class_310"},
   priority = 2000
)
public abstract class MinecraftClientBootstrapMixin {
   @Inject(
      method = {"method_1574"},
      at = {@At("HEAD")}
   )
   private void krypton$tickDiddyClient(CallbackInfo var1) {
      DiddyEntrypoint.onClientTick(this);
   }
}
