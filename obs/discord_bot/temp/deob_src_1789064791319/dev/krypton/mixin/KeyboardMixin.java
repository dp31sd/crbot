package dev.krypton.mixin;

import net.minecraft.class_11908;
import net.minecraft.class_309;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_309.class})
public class KeyboardMixin {
   @Inject(
      method = {"method_1466"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onPress(long var1, int var3, class_11908 var4, CallbackInfo var5) {
      if (var4.comp_4795() != -1) {
         Class_70 var6 = new Class_70(var4, var1, var3);
         Class_202.method_559(var6);
         if (var6.ay()) {
            var5.cancel();
         }
      }
   }
}
