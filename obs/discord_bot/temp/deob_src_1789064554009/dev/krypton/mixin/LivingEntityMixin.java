package dev.krypton.mixin;

import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_4048;
import net.minecraft.class_4050;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1309.class})
public abstract class LivingEntityMixin {
   @Inject(
      method = {"method_55694"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getBaseDimensions(class_4050 var1, CallbackInfoReturnable<class_4048> var2) {
      if (this instanceof class_1657 var3) {
         if (var3.method_7340()) {
            return;
         }

         Class_125 var4 = (Class_125)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_125.class);
         if (var4.pbm()) {
            var2.setReturnValue(class_4048.method_18384(0.6F, 1.8F).method_55685(1.62F));
         }
      }
   }

   @Inject(
      method = {"method_6028"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void modifySwingDuration(CallbackInfoReturnable<Integer> var1) {
      if (this instanceof class_1657 var2) {
         if (var2.method_7340()) {
            if ((ScreenUI_78)ScreenUI_78.field_772 != null && (ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780 != null) {
               Class_372 var3 = (Class_372)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_372.class);
               if (var3 != null && var3.pbm()) {
                  var1.setReturnValue(var3.method_1461());
               }
            }
         }
      }
   }
}
