package dev.krypton.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_746.class})
public class ClientPlayerEntityMixin extends class_742 {
   @Shadow
   @Final
   protected class_310 field_3937;

   public ClientPlayerEntityMixin(class_638 var1, GameProfile var2) {
      super(var1, var2);
   }

   @Inject(
      method = {"method_3136"},
      at = {@At("HEAD")}
   )
   private void onSendMovementPackets(CallbackInfo var1) {
      Class_202.method_559(new Class_239());
   }

   @Inject(
      method = {"method_5773"},
      at = {@At("HEAD")}
   )
   private void onPlayerTick(CallbackInfo var1) {
      Class_202.method_559(new Class_274());
   }
}
