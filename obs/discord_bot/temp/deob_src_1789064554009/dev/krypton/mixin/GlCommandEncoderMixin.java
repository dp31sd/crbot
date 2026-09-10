package dev.krypton.mixin;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderPass;
import net.minecraft.class_10860;
import net.minecraft.class_10865;
import org.lwjgl.opengl.GL11C;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({class_10860.class})
public abstract class GlCommandEncoderMixin {
   @Shadow
   @Final
   private class_10865 field_57844;

   @Inject(
      method = {"createRenderPass(Ljava/util/function/Supplier;Lcom/mojang/blaze3d/textures/GpuTextureView;Ljava/util/OptionalInt;Lcom/mojang/blaze3d/textures/GpuTextureView;Ljava/util/OptionalDouble;)Lcom/mojang/blaze3d/systems/RenderPass;"},
      at = {@At("RETURN")}
   )
   private void createRenderPass$iGpuDevice(CallbackInfoReturnable<RenderPass> var1) {
      ((RenderEngine_269)this.field_57844).method_33((RenderPass)var1.getReturnValue());
   }

   @Inject(
      method = {"method_68356"},
      at = {@At(
         value = "INVOKE",
         target = "Lcom/mojang/blaze3d/opengl/GlStateManager;_polygonMode(II)V"
      )}
   )
   private void setPipelineAndApplyState$lineSmooth(RenderPipeline var1, CallbackInfo var2) {
      if (((Class_147)var1).method_27()) {
         GL11C.glEnable(2848);
         GL11C.glLineWidth(1.0F);
      } else {
         GL11C.glDisable(2848);
      }
   }
}
