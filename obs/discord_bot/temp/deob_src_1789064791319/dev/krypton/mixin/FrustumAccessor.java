package dev.krypton.mixin;

import net.minecraft.class_4604;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({class_4604.class})
public interface FrustumAccessor {
   @Accessor("field_20995")
   double getX();

   @Accessor("field_20995")
   void setX(double var1);

   @Accessor("field_20996")
   double getY();

   @Accessor("field_20996")
   void setY(double var1);

   @Accessor("field_20997")
   double getZ();

   @Accessor("field_20997")
   void setZ(double var1);
}
