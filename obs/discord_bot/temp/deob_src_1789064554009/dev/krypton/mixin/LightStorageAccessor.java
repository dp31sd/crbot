package dev.krypton.mixin;

import net.minecraft.class_3556;
import net.minecraft.class_3560;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_3560.class})
public interface LightStorageAccessor {
   @Accessor("field_15796")
   class_3556 getStorage();
}
