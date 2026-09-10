import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat.class_5596;
import dev.krypton.mixin.RenderPipelineBuilderAccessor;
import net.minecraft.class_10789;
import net.minecraft.class_2960;

public class RenderEngine_136 {
   // $VF: renamed from: jtg com.mojang.blaze3d.pipeline.RenderPipeline.Builder
   public Builder field_671 = RenderPipeline.builder(new Snippet[0]);
   // $VF: renamed from: ibc boolean
   public boolean field_672;

   public RenderEngine_136(Snippet... var1) {
      for (Snippet var5 : var1) {
         ((RenderPipelineBuilderAccessor)this.field_671).invokeWithSnippet(var5);
      }
   }

   // $VF: renamed from: fyx () RenderEngine_136
   public RenderEngine_136 method_650() {
      this.field_672 = true;
      return this;
   }

   // $VF: renamed from: gam (net.minecraft.class_2960) RenderEngine_136
   public RenderEngine_136 method_651(class_2960 var1) {
      this.field_671.withLocation(var1);
      return this;
   }

   // $VF: renamed from: oli (com.mojang.blaze3d.vertex.VertexFormat, com.mojang.blaze3d.vertex.VertexFormat.class_5596) RenderEngine_136
   public RenderEngine_136 method_652(VertexFormat var1, class_5596 var2) {
      this.field_671.withVertexFormat(var1, var2);
      return this;
   }

   // $VF: renamed from: thj (net.minecraft.class_2960) RenderEngine_136
   public RenderEngine_136 method_653(class_2960 var1) {
      this.field_671.withVertexShader(var1);
      return this;
   }

   // $VF: renamed from: ptz (net.minecraft.class_2960) RenderEngine_136
   public RenderEngine_136 method_654(class_2960 var1) {
      this.field_671.withFragmentShader(var1);
      return this;
   }

   // $VF: renamed from: inz (java.lang.String) RenderEngine_136
   public RenderEngine_136 method_655(String var1) {
      this.field_671.withSampler(var1);
      return this;
   }

   // $VF: renamed from: pp (java.lang.String, net.minecraft.class_10789) RenderEngine_136
   public RenderEngine_136 method_656(String var1, class_10789 var2) {
      this.field_671.withUniform(var1, var2);
      return this;
   }

   // $VF: renamed from: miv (com.mojang.blaze3d.platform.DepthTestFunction) RenderEngine_136
   public RenderEngine_136 method_657(DepthTestFunction var1) {
      this.field_671.withDepthTestFunction(var1);
      return this;
   }

   // $VF: renamed from: sc (boolean) RenderEngine_136
   public RenderEngine_136 method_658(boolean var1) {
      this.field_671.withDepthWrite(var1);
      return this;
   }

   public RenderEngine_136 ybeh(BlendFunction var1) {
      this.field_671.withBlend(var1);
      return this;
   }

   // $VF: renamed from: ok (boolean) RenderEngine_136
   public RenderEngine_136 method_659(boolean var1) {
      this.field_671.withCull(var1);
      return this;
   }

   // $VF: renamed from: wtq () com.mojang.blaze3d.pipeline.RenderPipeline
   public RenderPipeline method_660() {
      RenderPipeline var1 = this.field_671.build();
      ((Class_147)var1).method_26(this.field_672);
      return var1;
   }
}
