package dev.krypton.mixin;

import io.netty.channel.ChannelPipeline;
import java.net.InetSocketAddress;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2596;
import net.minecraft.class_2598;
import net.minecraft.class_8762;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({class_2535.class})
public class ClientConnectionMixin {
   @Inject(
      method = {"method_10759"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static <T extends class_2547> void onPacketReceive(class_2596<T> var0, class_2547 var1, CallbackInfo var2) {
      Class_83 var3 = new Class_83(var0);
      Class_202.method_559(var3);
      if (var3.ay()) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"method_10743(Lnet/minecraft/class_2596;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onPacketSend(class_2596<?> var1, CallbackInfo var2) {
      Class_165 var3 = new Class_165(var1);
      Class_202.method_559(var3);
      if (var3.ay()) {
         var2.cancel();
      }
   }

   @Inject(
      method = {"method_48311"},
      at = {@At("RETURN")},
      require = 0
   )
   private static void injectProxy(ChannelPipeline var0, class_2598 var1, boolean var2, class_8762 var3, CallbackInfo var4) {
      if (var1 == class_2598.field_11942 && !var2) {
         Class_389 var5 = Class_389.method_1450();
         if (var5 != null && var5.pbm() && !var5.field_1585.method_1021().isBlank()) {
            int var6;
            try {
               var6 = Integer.parseInt(var5.field_1586.method_1021().trim());
            } catch (NumberFormatException var10) {
               return;
            }

            if (var6 >= 1 && var6 <= 65535) {
               InetSocketAddress var7 = new InetSocketAddress(var5.field_1585.method_1021(), var6);
               String var8 = var5.field_1588.method_1021();
               String var9 = var5.field_1589.method_1021();
               if (var5.field_1587.method_1006(Class_265.field_1088)) {
                  var0.addFirst("socks-proxy", var8.isBlank() ? new Class_190(var7) : new Class_190(var7, var8));
               } else {
                  var0.addFirst("socks-proxy", var8.isBlank() ? new Class_336(var7) : new Class_336(var7, var8, var9));
               }
            }
         }
      }
   }
}
