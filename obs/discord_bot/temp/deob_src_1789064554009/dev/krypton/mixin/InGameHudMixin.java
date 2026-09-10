package dev.krypton.mixin;

import net.minecraft.class_310;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_9779;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_329.class})
public class InGameHudMixin {
   @Inject(
      method = {"method_1753"},
      at = {@At("HEAD")}
   )
   private void onRenderHud(class_332 var1, class_9779 var2, CallbackInfo var3) {
      Class_387 var4 = new Class_387(var1, var2.method_60637(true));
      Class_202.method_559(var4);
      Class_314.method_301(var1);
   }

   @Inject(
      method = {"method_1765"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRenderStatusEffects(class_332 var1, class_9779 var2, CallbackInfo var3) {
      RenderEngine_348 var4 = (RenderEngine_348)((ScreenUI_78)ScreenUI_78.field_772).method_797().method_482(RenderEngine_348.class);
      if (var4 != null && var4.pbm()) {
         var3.cancel();
      }
   }

   @Inject(
      method = {"method_1736"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRenderCrosshair(class_332 var1, class_9779 var2, CallbackInfo var3) {
      if (((class_310)ScreenUI_78.field_771).field_1755 instanceof Class_308) {
         var3.cancel();
      }
   }
}
