package dev.krypton.mixin;

import net.minecraft.class_1041;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import net.minecraft.class_3675.class_306;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({class_304.class})
public abstract class KeyBindingMixin implements Class_280 {
   @Shadow
   private class_306 field_1655;

   // $VF: renamed from: yrn () boolean
   @Override
   public boolean method_34() {
      class_1041 var1 = ((class_310)ScreenUI_78.field_771).method_22683();
      int var2 = this.field_1655.method_1444();
      return class_3675.method_15987(var1, var2);
   }

   // $VF: renamed from: wlr () void
   @Override
   public void method_35() {
      this.method_23481(this.method_34());
   }

   @Shadow
   public abstract void method_23481(boolean var1);
}
