package dev.krypton.mixin;

import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_639;
import net.minecraft.class_642;
import net.minecraft.class_9112;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_412.class})
public abstract class ConnectScreenMixin {
   @Inject(
      method = {"method_2130(Lnet/minecraft/class_310;Lnet/minecraft/class_639;Lnet/minecraft/class_642;Lnet/minecraft/class_9112;)V"},
      at = {@At("HEAD")}
   )
   private void onConnect(class_310 var1, class_639 var2, class_642 var3, class_9112 var4, CallbackInfo var5) {
      Class_202.method_559(new Class_85(var2, var3));
   }
}
