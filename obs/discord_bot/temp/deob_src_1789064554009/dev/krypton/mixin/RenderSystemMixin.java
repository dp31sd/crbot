package dev.krypton.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({RenderSystem.class})
public abstract class RenderSystemMixin {
   @Inject(
      method = {"flipFrame"},
      at = {@At("TAIL")}
   )
   private static void krypton$flipFrame(CallbackInfo var0) {
      Class_204.axww();
      Class_212.method_536();
      Class_34.method_1126();
      Class_345.method_257();
   }
}
