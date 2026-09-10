package dev.krypton.mixin;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.class_2804;
import net.minecraft.class_3556;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_3556.class})
public interface ChunkToNibbleArrayMapAccessor {
   @Accessor("field_15791")
   Long2ObjectOpenHashMap<class_2804> getArrays();
}
