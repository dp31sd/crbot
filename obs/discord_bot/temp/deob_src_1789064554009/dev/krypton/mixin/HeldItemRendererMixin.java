package dev.krypton.mixin;

import net.minecraft.class_2960;
import net.minecraft.class_759;
import net.minecraft.class_8685;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin({class_759.class})
public class HeldItemRendererMixin {
   @ModifyVariable(
      method = {"method_3216"},
      at = @At("STORE"),
      ordinal = 0
   )
   private class_2960 modifyArmTexture(class_2960 var1) {
      return this.getOverrideSkinTexture(var1);
   }

   @ModifyVariable(
      method = {"method_3219"},
      at = @At("STORE"),
      ordinal = 0
   )
   private class_2960 modifyArmHoldingItemTexture(class_2960 var1) {
      return this.getOverrideSkinTexture(var1);
   }

   private class_2960 getOverrideSkinTexture(class_2960 var1) {
      NetworkHandler_15 var2 = (NetworkHandler_15)((ScreenUI_78)ScreenUI_78.field_772).method_797().method_482(NetworkHandler_15.class);
      if (var2 != null && var2.pbm() && var2.method_1918()) {
         class_8685 var3 = var2.method_1917();
         if (var3 != null) {
            return var3.comp_1626().comp_3627();
         }
      }

      return var1;
   }
}
