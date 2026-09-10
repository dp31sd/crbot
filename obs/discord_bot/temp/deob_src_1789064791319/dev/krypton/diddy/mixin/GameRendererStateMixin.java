package dev.krypton.diddy.mixin;

import dev.krypton.diddy.DiddyEntrypoint;
import net.minecraft.class_757;
import net.minecraft.class_9779;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_757.class})
public abstract class GameRendererStateMixin {
   @Inject(
      method = {"method_3188"},
      at = {@At("HEAD")}
   )
   private void krypton$ensureWorldMatrixStack(class_9779 var1, CallbackInfo var2) {
      DiddyEntrypoint.ensureRenderMatrixStack();
   }
}
