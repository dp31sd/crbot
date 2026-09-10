package dev.krypton.mixin;

import net.minecraft.class_1041;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_437;
import net.minecraft.class_638;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_310.class})
public class MinecraftClientMixin {
   @Shadow
   @Nullable
   public class_638 field_1687;
   @Shadow
   @Final
   private class_1041 field_1704;
   @Shadow
   private int field_1752;

   @Inject(
      method = {"method_1574"},
      at = {@At("HEAD")}
   )
   private void onTick(CallbackInfo var1) {
      Class_392 var2 = new Class_392();
      Class_202.method_559(var2);
      if (this.field_1687 != null) {
         Class_207 var3 = new Class_207();
         Class_202.method_559(var3);
      }
   }

   @Inject(
      method = {"method_15993"},
      at = {@At("HEAD")}
   )
   private void onResolutionChanged(CallbackInfo var1) {
      Class_202.method_559(new Class_268(this.field_1704));
   }

   @Inject(
      method = {"method_1583"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void onItemUseReturn(CallbackInfo var1) {
      Class_89 var2 = new Class_89(this.field_1752);
      Class_202.method_559(var2);
      if (var2.ay()) {
         var1.cancel();
      }

      this.field_1752 = var2.field_956;
   }

   @Inject(
      method = {"method_1583"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onItemUseHead(CallbackInfo var1) {
      Class_256 var2 = new Class_256(this.field_1752);
      Class_202.method_559(var2);
      if (var2.ay()) {
         var1.cancel();
      }

      this.field_1752 = var2.field_949;
   }

   @Inject(
      method = {"method_1536"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onAttack(CallbackInfoReturnable<Boolean> var1) {
      Class_198 var2 = new Class_198();
      Class_202.method_559(var2);
      if (var2.ay()) {
         var1.cancel();
         var1.setReturnValue(false);
      } else {
         Class_113 var3 = (Class_113)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_113.class);
         if (var3.field_2139.method_1035()) {
            if (((class_310)ScreenUI_78.field_771).field_1724 != null) {
               if (((class_310)ScreenUI_78.field_771).field_1755 == null) {
                  if (((class_310)ScreenUI_78.field_771).field_1765 instanceof class_3966 var4) {
                     if (var4.method_17782() instanceof class_1657 var7) {
                        if (var3.method_1834(var7)) {
                           var2.li();
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Inject(
      method = {"method_1590"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onBlockBreaking(boolean var1, CallbackInfo var2) {
      Class_307 var3 = new Class_307();
      Class_202.method_559(var3);
      if (var3.ay()) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"method_1507"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onSetScreen(class_437 var1, CallbackInfo var2) {
      Class_132 var3 = new Class_132(var1);
      Class_202.method_559(var3);
      if (var3.ay()) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"<init>"},
      at = {@At("TAIL")}
   )
   private void onInit(CallbackInfo var1) {
      ((ScreenUI_78)ScreenUI_78.field_772).method_795();
   }
}
