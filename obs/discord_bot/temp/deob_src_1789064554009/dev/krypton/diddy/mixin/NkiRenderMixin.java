package dev.krypton.diddy.mixin;

import dev.krypton.diddy.DiddyEntrypoint;
import net.minecraft.class_332;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   targets = {"nki"},
   priority = 2000
)
public abstract class NkiRenderMixin {
   private boolean krypton$forcingQpp;

   // $VF: renamed from: qpp (net.minecraft.class_332, int, int, float) void
   @Shadow
   public abstract void method_922(class_332 var1, int var2, int var3, float var4);

   @Inject(
      method = {"method_25394"},
      at = {@At("HEAD")}
   )
   private void krypton$onNkiRender(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      DiddyEntrypoint.onNkiRenderHead(this);
   }

   @Inject(
      method = {"method_25394"},
      at = {@At("TAIL")}
   )
   private void krypton$forceRealQpp(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (!this.krypton$forcingQpp) {
         this.krypton$forcingQpp = true;

         try {
            DiddyEntrypoint.onForcedNkiQpp(this);
            this.method_922(var1, var2, var3, var4);
         } catch (Throwable var10) {
            DiddyEntrypoint.onForcedNkiQppFailure(var10);
         } finally {
            this.krypton$forcingQpp = false;
         }
      }
   }

   @Inject(
      method = {"qpp"},
      at = {@At("HEAD")}
   )
   private void krypton$onNkiQpp(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      DiddyEntrypoint.onNkiQppHead(this);
   }
}
