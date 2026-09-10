package dev.krypton.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(
   targets = {"com/mojang/blaze3d/opengl/GlStateManager$class_1018"}
)
public abstract class CapabilityTrackerMixin implements Class_327 {
   @Shadow
   private boolean field_5051;

   @Shadow
   public abstract void method_4470(boolean var1);

   // $VF: renamed from: ei () boolean
   @Override
   public boolean method_36() {
      return this.field_5051;
   }

   // $VF: renamed from: gx (boolean) void
   @Override
   public void method_37(boolean var1) {
      this.method_4470(var1);
   }
}
