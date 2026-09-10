package dev.krypton.diddy.mixin;

import dev.krypton.diddy.DiddyEntrypoint;
import java.util.List;
import java.util.function.BiConsumer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(
   targets = {"usf"},
   priority = 2000
)
public abstract class UsfLifecycleMixin {
   // $VF: renamed from: ap java.util.List
   @Shadow
   public List field_872;
   // $VF: renamed from: gw boolean
   @Shadow
   public boolean field_873;

   // $VF: renamed from: mg () void
   @Shadow
   public abstract void method_919();

   // $VF: renamed from: q () void
   @Shadow
   public abstract void method_920();

   // $VF: renamed from: wz (boolean) void
   @Overwrite
   public void method_921(boolean var1) {
      if (this.field_873 != var1) {
         this.field_873 = var1;
         if (!DiddyEntrypoint.shouldSkipModuleLifecycle(this)) {
            try {
               if (var1) {
                  this.method_919();
               } else {
                  this.method_920();
               }
            } catch (Throwable var7) {
               DiddyEntrypoint.fallbackModuleLifecycle(this, var1);
            }
         }

         if (this.field_872 != null) {
            for (Object var3 : this.field_872) {
               if (var3 instanceof BiConsumer) {
                  BiConsumer var4 = (BiConsumer)var3;

                  try {
                     var4.accept(this, var1);
                  } catch (Throwable var6) {
                  }
               }
            }
         }

         DiddyEntrypoint.saveConfig();
      }
   }
}
