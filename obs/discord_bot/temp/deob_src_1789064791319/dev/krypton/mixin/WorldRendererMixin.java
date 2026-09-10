package dev.krypton.mixin;

import net.minecraft.class_761;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin({class_761.class})
public abstract class WorldRendererMixin {
   @ModifyArg(
      method = {"method_22710"},
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_761;method_74752(Lnet/minecraft/class_4184;Lnet/minecraft/class_4604;Z)V"
      ),
      index = 2
   )
   private boolean renderSetupTerrainModifyArg(boolean var1) {
      return ((Class_205)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_205.class)).pbm() || var1;
   }
}
