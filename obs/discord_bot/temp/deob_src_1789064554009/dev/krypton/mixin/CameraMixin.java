package dev.krypton.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_4184;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin({class_4184.class})
public class CameraMixin {
   @Shadow
   private boolean field_18719;
   @Unique
   private float tickDelta;

   @Inject(
      method = {"method_19321"},
      at = {@At("HEAD")}
   )
   private void onUpdateHead(class_1937 var1, class_1297 var2, boolean var3, boolean var4, float var5, CallbackInfo var6) {
      this.tickDelta = var5;
   }

   @ModifyArgs(
      method = {"method_19321"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4184;method_19327(DDD)V"
      )
   )
   private void update(Args var1) {
      Class_205 var2 = (Class_205)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_205.class);
      if (var2.pbm()) {
         var1.set(0, var2.method_1742(this.tickDelta));
         var1.set(1, var2.method_1743(this.tickDelta));
         var1.set(2, var2.method_1744(this.tickDelta));
      }
   }

   @ModifyArgs(
      method = {"method_19321"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4184;method_19325(FF)V"
      )
   )
   private void onUpdateSetRotationArgs(Args var1) {
      Class_205 var2 = (Class_205)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_205.class);
      Class_68 var3 = (Class_68)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_68.class);
      if (var3.pbm()) {
         var1.set(0, var3.field_2202);
         var1.set(1, var3.field_2203);
      }

      if (var2.pbm()) {
         var1.set(0, (float)var2.method_1745(this.tickDelta));
         var1.set(1, (float)var2.method_1746(this.tickDelta));
      }
   }

   @ModifyArgs(
      method = {"method_19321"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_4184;method_19327(DDD)V"
      )
   )
   private void onUpdateSetPosArgs(Args var1, @Local(argsOnly = true) float var2) {
      Class_205 var3 = (Class_205)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_205.class);
      if (var3.pbm()) {
         var1.set(0, var3.method_1742(var2));
         var1.set(1, var3.method_1743(var2));
         var1.set(2, var3.method_1744(var2));
      }
   }

   @Inject(
      method = {"method_19321"},
      at = {@At("TAIL")}
   )
   private void onUpdateTail(class_1937 var1, class_1297 var2, boolean var3, boolean var4, float var5, CallbackInfo var6) {
      Class_205 var7 = (Class_205)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_205.class);
      if (var7.pbm()) {
         this.field_18719 = true;
      }
   }

   @Inject(
      method = {"method_19318"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onClipToSpaceHead(float var1, CallbackInfoReturnable<Float> var2) {
      Class_205 var3 = (Class_205)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_205.class);
      if (var3.pbm()) {
         var2.setReturnValue(0.0F);
      } else {
         Class_68 var4 = (Class_68)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_68.class);
         if (var4.pbm() && var4.field_2198.method_1035()) {
            var2.setReturnValue(var1);
         }
      }
   }
}
