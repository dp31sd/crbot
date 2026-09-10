package dev.krypton.mixin;

import net.minecraft.class_2561;
import net.minecraft.class_412;
import net.minecraft.class_4185;
import net.minecraft.class_419;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_8667;
import net.minecraft.class_4185.class_7840;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_419.class})
public abstract class DisconnectedScreenMixin extends class_437 {
   @Shadow
   @Final
   private class_8667 field_44552;
   @Unique
   private class_4185 reconnectBtn;
   @Unique
   private double time;

   protected DisconnectedScreenMixin(class_2561 var1) {
      super(var1);
   }

   @Inject(
      method = {"method_25426"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/class_8667;method_48222()V",
         shift = Shift.BEFORE
      )}
   )
   private void addButtons(CallbackInfo var1) {
      Class_17 var2 = this.getAutoReconnect();
      if (var2 != null) {
         this.time = var2.method_1909() * 20.0;
         if (var2.method_1914() != null && !var2.method_1910()) {
            this.reconnectBtn = new class_7840(class_2561.method_43470(this.getText()), var1x -> this.tryConnecting()).method_46431();
            this.field_44552.method_52736(this.reconnectBtn);
         }
      }
   }

   public void method_25393() {
      Class_17 var1 = this.getAutoReconnect();
      if (var1 != null && var1.pbm() && var1.method_1914() != null) {
         if (this.time <= 0.0) {
            this.tryConnecting();
         } else {
            this.time--;
            if (this.reconnectBtn != null) {
               this.reconnectBtn.method_25355(class_2561.method_43470(this.getText()));
            }
         }
      }
   }

   @Unique
   private Class_17 getAutoReconnect() {
      return (ScreenUI_78)ScreenUI_78.field_772 != null && ((ScreenUI_78)ScreenUI_78.field_772).method_797() != null
         ? (Class_17)((ScreenUI_78)ScreenUI_78.field_772).method_797().method_482(Class_17.class)
         : null;
   }

   @Unique
   private String getText() {
      Class_17 var1 = this.getAutoReconnect();
      String var2 = "Reconnect";
      if (var1 != null && var1.pbm()) {
         var2 = var2 + " " + String.format("(%.1f)", this.time / 20.0);
      }

      return var2;
   }

   @Unique
   private void tryConnecting() {
      Class_17 var1 = this.getAutoReconnect();
      if (var1 != null && var1.method_1914() != null) {
         class_412.method_36877(new class_442(), this.field_22787, var1.method_1914(), var1.method_1915(), false, null);
      }
   }
}
