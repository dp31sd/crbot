package dev.krypton.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import net.minecraft.class_3695;
import net.minecraft.class_765;
import net.minecraft.class_9848;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_765.class})
public abstract class LightmapTextureManagerMixin {
   @Shadow
   @Final
   private GpuTexture field_57927;

   @Inject(
      method = {"method_3313"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_3695;method_15396(Ljava/lang/String;)V",
         shift = Shift.AFTER
      )},
      cancellable = true
   )
   private void update$skip(float var1, CallbackInfo var2, @Local class_3695 var3) {
      if (((Class_67)((ConfigManager_221)((ScreenUI_78)ScreenUI_78.field_772).field_780).method_482(Class_67.class)).pbm()) {
         RenderSystem.getDevice().createCommandEncoder().clearColorTexture(this.field_57927, class_9848.method_61324(255, 255, 255, 255));
         var3.method_15407();
         var2.cancel();
      }
   }
}
