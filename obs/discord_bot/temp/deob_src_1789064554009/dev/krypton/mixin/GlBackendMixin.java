package dev.krypton.mixin;

import com.mojang.blaze3d.systems.RenderPass;
import net.minecraft.class_10865;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({class_10865.class})
public abstract class GlBackendMixin implements RenderEngine_269 {
   // $VF: renamed from: x int
   @Unique
   private int field_869;
   // $VF: renamed from: y int
   @Unique
   private int field_870;
   @Unique
   private int width;
   @Unique
   private int height;
   // $VF: renamed from: set boolean
   @Unique
   private boolean field_871;

   // $VF: renamed from: ola (int, int, int, int) void
   @Override
   public void method_31(int var1, int var2, int var3, int var4) {
      if (this.field_871) {
         throw new IllegalStateException("Currently there can only be one global scissor pushed");
      } else {
         this.field_869 = var1;
         this.field_870 = var2;
         this.width = var3;
         this.height = var4;
         this.field_871 = true;
      }
   }

   // $VF: renamed from: ni () void
   @Override
   public void method_32() {
      if (!this.field_871) {
         throw new IllegalStateException("No scissor pushed");
      } else {
         this.field_871 = false;
      }
   }

   // $VF: renamed from: lv (com.mojang.blaze3d.systems.RenderPass) void
   @Deprecated
   @Override
   public void method_33(RenderPass var1) {
      if (this.field_871) {
         var1.enableScissor(this.field_869, this.field_870, this.width, this.height);
      }
   }
}
