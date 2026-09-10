package dev.krypton.mixin;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({RenderPipeline.class})
public abstract class RenderPipelineMixin implements Class_147 {
   @Unique
   private boolean lineSmooth;

   // $VF: renamed from: obu (boolean) void
   @Override
   public void method_26(boolean var1) {
      this.lineSmooth = var1;
   }

   // $VF: renamed from: up () boolean
   @Override
   public boolean method_27() {
      return this.lineSmooth;
   }
}
