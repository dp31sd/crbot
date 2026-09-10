package dev.krypton.mixin;

import net.minecraft.class_310;
import net.minecraft.class_5223;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({class_5223.class})
public class TextVisitFactoryMixin {
   @ModifyArg(
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_5223;method_27473(Ljava/lang/String;ILnet/minecraft/class_2583;Lnet/minecraft/class_2583;Lnet/minecraft/class_5224;)Z",
         ordinal = 0
      ),
      method = {"method_27472(Ljava/lang/String;ILnet/minecraft/class_2583;Lnet/minecraft/class_5224;)Z"},
      index = 0
   )
   private static String adjustText(String var0) {
      Class_418 var1 = (Class_418)((ScreenUI_78)ScreenUI_78.field_772).method_797().method_482(Class_418.class);
      if (var1 != null && var1.pbm()) {
         String var2 = ((class_310)ScreenUI_78.field_771).method_1548().method_1676();
         return var0.contains(var2) ? var0.replace(var2, var1.method_1437()) : var0;
      } else {
         return var0;
      }
   }
}
