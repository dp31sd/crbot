package dev.krypton.mixin;

import net.minecraft.class_2338;
import net.minecraft.class_852;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_852.class})
public abstract class ChunkOcclusionDataBuilderMixin {
   @Inject(
      method = {"method_3682"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onMarkClosed(class_2338 var1, CallbackInfo var2) {
      Class_407 var3 = new Class_407();
      Class_202.method_559(var3);
      if (var3.ay()) {
         var2.cancel();
      }
   }
}
