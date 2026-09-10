package dev.krypton.diddy.mixin;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   targets = {"vap"},
   priority = 2000
)
public abstract class VapArrayListMixin {
   @Inject(
      method = {"sva"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void krypton$onlyShowEnabledModules(CallbackInfoReturnable<List> var1) {
      List var2 = (List)var1.getReturnValue();
      if (var2 != null && !var2.isEmpty()) {
         ArrayList var3 = new ArrayList(var2.size());

         for (Object var5 : var2) {
            if (isEnabledModule(var5)) {
               var3.add(var5);
            }
         }

         var1.setReturnValue(var3);
      }
   }

   private static boolean isEnabledModule(Object var0) {
      try {
         ClassLoader var1 = VapArrayListMixin.class.getClassLoader();
         Class var2 = Class.forName("usf", true, var1);
         if (!var2.isInstance(var0)) {
            return false;
         } else {
            Object var3 = Class.forName("nc", true, var1).getMethod("moduleEnabled", var2).invoke(null, var0);
            return Boolean.TRUE.equals(var3);
         }
      } catch (LinkageError | ReflectiveOperationException var4) {
         return false;
      }
   }
}
