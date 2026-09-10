package dev.krypton.mixin;

import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_11890;
import net.minecraft.class_11901;
import net.minecraft.class_310;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_1007.class})
public abstract class PlayerEntityRendererMixin<T extends class_11890 & class_11901> {
   @Inject(
      method = {"method_62604(Lnet/minecraft/class_11890;Lnet/minecraft/class_10055;F)V"},
      at = {@At("TAIL")}
   )
   private void onUpdateRenderState(T var1, class_10055 var2, float var3, CallbackInfo var4) {
      class_310 var5 = class_310.method_1551();
      if (var5.field_1724 != null) {
         boolean var6 = var1.method_5628() == var5.field_1724.method_5628();
         if (!var6) {
            Class_418 var7 = (Class_418)((ScreenUI_78)ScreenUI_78.field_772).method_797().method_482(Class_418.class);
            if (var7 != null && var7.pbm() && var7.method_1438()) {
               var2.field_53525 = null;
               var2.field_53337 = null;
            }

            NetworkHandler_15 var8 = (NetworkHandler_15)((ScreenUI_78)ScreenUI_78.field_772).method_797().method_482(NetworkHandler_15.class);
            if (var8 != null && var8.pbm() && var8.method_1919()) {
               class_8685 var9 = var8.method_1917();
               if (var9 != null) {
                  var2.field_53520 = var9;
               }
            }
         } else {
            NetworkHandler_15 var10 = (NetworkHandler_15)((ScreenUI_78)ScreenUI_78.field_772).method_797().method_482(NetworkHandler_15.class);
            if (var10 != null && var10.pbm() && var10.method_1918()) {
               class_8685 var11 = var10.method_1917();
               if (var11 != null) {
                  var2.field_53520 = var11;
               }
            }
         }
      }
   }
}
