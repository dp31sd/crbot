package dev.krypton.mixin;

import net.minecraft.class_12155;
import net.minecraft.class_12179;
import net.minecraft.class_12180;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_12155.class})
public class EntityHitboxDebugRendererMixin {
   @Shadow
   @Final
   class_310 field_63589;

   @Inject(
      method = {"method_75432"},
      at = {@At("HEAD")}
   )
   private void onDrawHitbox(class_1297 var1, float var2, boolean var3, CallbackInfo var4) {
      class_243 var5 = var1.method_30950(var2);
      class_243 var6 = var5.method_1020(var1.method_73189());
      class_238 var7 = var1.method_5829().method_997(var6);
      int var8 = -16711936;
      class_12180.method_75541(var7, class_12179.method_75535(var8));
      class_243 var9 = var5.method_1031(0.0, (double)var1.method_5751(), 0.0);
      class_243 var10 = var1.method_5828(var2);
      class_12180.method_75555(var9, var9.method_1019(var10.method_1021(2.0)), -16776961);
   }
}
