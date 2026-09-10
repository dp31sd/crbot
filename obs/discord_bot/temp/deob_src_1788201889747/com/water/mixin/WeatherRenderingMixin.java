/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.modules.render.NoRender;
import net.minecraft.class_1937;
import net.minecraft.class_1959;
import net.minecraft.class_2338;
import net.minecraft.class_9976;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_9976.class})
public abstract class WeatherRenderingMixin {
    @Invoker(value="getPrecipitationAt")
    protected abstract class_1959.class_1963 water$getPrecipitationAt(class_1937 var1, class_2338 var2);

    @Redirect(method={"buildPrecipitationPieces"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WeatherRendering;getPrecipitationAt(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome$Precipitation;"))
    private class_1959.class_1963 water$filterRenderedPrecipitation(class_9976 class_99762, class_1937 class_19372, class_2338 class_23382) {
        return NoRender.filterPrecipitation(this.water$getPrecipitationAt(class_19372, class_23382));
    }

    @Redirect(method={"addParticlesAndSound"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WeatherRendering;getPrecipitationAt(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/world/biome/Biome$Precipitation;"))
    private class_1959.class_1963 water$filterWeatherParticlesAndSounds(class_9976 class_99762, class_1937 class_19372, class_2338 class_23382) {
        return NoRender.filterPrecipitation(this.water$getPrecipitationAt(class_19372, class_23382));
    }
}

