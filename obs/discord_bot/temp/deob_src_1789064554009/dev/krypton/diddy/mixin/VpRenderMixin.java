package dev.krypton.diddy.mixin;

import dev.krypton.diddy.DiddyEntrypoint;
import net.minecraft.class_332;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(
   targets = {"vp"},
   priority = 2000
)
public abstract class VpRenderMixin {
   private boolean krypton$forcingQpp;

   // $VF: renamed from: qpp (net.minecraft.class_332, int, int, float) void
   @Shadow
   public abstract void method_918(class_332 var1, int var2, int var3, float var4);

   @Inject(
      method = {"method_25394"},
      at = {@At("TAIL")}
   )
   private void krypton$forceRealQpp(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      if (DiddyEntrypoint.shouldForceVpRender()) {
         if (!this.krypton$forcingQpp) {
            this.krypton$forcingQpp = true;

            try {
               DiddyEntrypoint.onForcedVpQpp(this);
               this.method_918(var1, var2, var3, var4);
            } catch (Throwable var10) {
               DiddyEntrypoint.onForcedVpQppFailure(var10);
            } finally {
               this.krypton$forcingQpp = false;
            }
         }
      }
   }

   @Inject(
      method = {"qpp"},
      at = {@At("HEAD")}
   )
   private void krypton$onVpQpp(class_332 var1, int var2, int var3, float var4, CallbackInfo var5) {
      DiddyEntrypoint.onVpQppHead(this);
   }
}
