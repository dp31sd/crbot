package dev.krypton.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_310;
import net.minecraft.class_4048;
import net.minecraft.class_4050;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_1297.class})
public abstract class EntityMixin {
   @Shadow
   private class_4048 field_18065;

   @Inject(
      method = {"method_5871"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void getTargetingMargin(CallbackInfoReturnable<Float> var1) {
      Class_202.method_559(new Class_355((class_1297)this, var1));
   }

   @Inject(
      method = {"method_18376"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onGetPose(CallbackInfoReturnable<class_4050> var1) {
      Class_202.method_559(new Class_171((class_1297)this, var1));
   }

   @Inject(
      method = {"method_5872"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void updateChangeLookDirection(double var1, double var3, CallbackInfo var5) {
      if (this == ((class_310)ScreenUI_78.field_771).field_1724) {
         Class_205 var6 = (Class_205)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_205.class);
         if (var6.pbm()) {
            var6.method_1741(var1 * 0.15, var3 * 0.15);
            var5.cancel();
         }
      }
   }

   @Inject(
      method = {"method_33332"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void calculateBoundingBox(CallbackInfoReturnable<class_238> var1) {
      if (this instanceof class_1309 var3) {
         if (var3 instanceof class_1657 var4 && var4.method_7340()) {
            return;
         }

         Class_304 var5 = (Class_304)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_304.class);
         if (!var5.pbm()) {
            return;
         }

         var1.setReturnValue(this.field_18065.method_30231(var3.field_6014, var3.field_6036, var3.field_5969));
      }
   }

   @ModifyReturnValue(
      method = {"method_18376"},
      at = {@At("RETURN")}
   )
   private class_4050 modifyGetPose(class_4050 var1) {
      if (this != ((class_310)ScreenUI_78.field_771).field_1724) {
         return var1;
      } else {
         return var1 == class_4050.field_18081 && !((class_310)ScreenUI_78.field_771).field_1724.method_5715() ? class_4050.field_18076 : var1;
      }
   }
}
