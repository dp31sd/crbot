package dev.krypton.mixin;

import com.mojang.blaze3d.pipeline.RenderPipeline.Builder;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin({Builder.class})
public interface RenderPipelineBuilderAccessor {
   @Invoker("withSnippet")
   void invokeWithSnippet(Snippet var1);
}
