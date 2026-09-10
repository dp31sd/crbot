package dev.krypton.mixin;

import net.minecraft.class_6017;
import net.minecraft.class_6793;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_6793.class})
public interface CountPlacementModifierAccessor {
   @Accessor("field_35719")
   class_6017 getCount();
}
