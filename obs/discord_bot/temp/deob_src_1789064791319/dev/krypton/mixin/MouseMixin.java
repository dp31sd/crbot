package dev.krypton.mixin;

import net.minecraft.class_1041;
import net.minecraft.class_11909;
import net.minecraft.class_11910;
import net.minecraft.class_310;
import net.minecraft.class_312;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_312.class})
public abstract class MouseMixin {
   @Shadow
   @Final
   private class_310 field_1779;

   @Shadow
   public abstract double method_68879(class_1041 var1);

   @Shadow
   public abstract double method_68883(class_1041 var1);

   @Inject(
      method = {"method_1601"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onMouseButton(long var1, class_11910 var3, int var4, CallbackInfo var5) {
      if (var3.comp_4801() != -1) {
         class_11909 var6 = new class_11909(this.method_68879(this.field_1779.method_22683()), this.method_68883(this.field_1779.method_22683()), var3);
         Class_354 var7 = new Class_354(var6, var1, var4);
         Class_202.method_559(var7);
         if (var7.ay()) {
            var5.cancel();
         }
      }
   }

   @Inject(
      method = {"method_1598"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onMouseScroll(long var1, double var3, double var5, CallbackInfo var7) {
      Class_56 var8 = new Class_56(var5);
      Class_202.method_559(var8);
      if (var8.ay()) {
         var7.cancel();
      }
   }

   @Redirect(
      method = {"method_1606"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_746;method_5872(DD)V"
      )
   )
   private void updateMouseChangeLookDirection(class_746 var1, double var2, double var4) {
      Class_68 var6 = (Class_68)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_68.class);
      if (var6 == null || !var6.pbm()) {
         var1.method_5872(var2, var4);
      } else if (var6.field_2194.method_1006(Class_364.field_1030)) {
         var6.field_2202 = var6.field_2202 + (float)(var2 / (10.0 / var6.field_2195.method_1071()));
         var6.field_2203 = var6.field_2203 + (float)(var4 / (10.0 / var6.field_2195.method_1071()));
         if (Math.abs(var6.field_2203) > 90.0F) {
            var6.field_2203 = var6.field_2203 > 0.0F ? 90.0F : -90.0F;
         }
      } else {
         var1.method_5872(var2, var4);
      }
   }
}
