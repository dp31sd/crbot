package dev.krypton.mixin;

import net.minecraft.class_3558;
import net.minecraft.class_3560;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_3558.class})
public interface ChunkLightProviderAccessor {
   @Accessor("field_15793")
   class_3560 getLightStorage();
}
