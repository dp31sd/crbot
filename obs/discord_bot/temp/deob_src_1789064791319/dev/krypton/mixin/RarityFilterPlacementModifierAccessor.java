package dev.krypton.mixin;

import net.minecraft.class_6799;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_6799.class})
public interface RarityFilterPlacementModifierAccessor {
   @Accessor("field_35753")
   int getChance();
}
