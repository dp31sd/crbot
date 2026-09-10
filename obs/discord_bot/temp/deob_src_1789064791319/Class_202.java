import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Class_202 {
   // $VF: renamed from: ufc java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_506 = new MethodHandle[0];
   // $VF: renamed from: uah java.util.Map
   public Map field_507 = new HashMap();

   // $VF: renamed from: ae (Class_26) void
   public static void method_559(Class_26 var0) {
      if (ScreenUI_78.field_772 instanceof ScreenUI_78 var2) {
         var2.method_799().method_563(var0);
      }
   }

   public void ncrs(Object var1) {
   }

   // $VF: renamed from: tnu (java.lang.Object, java.lang.reflect.Method, Class_21) void
   public void method_560(Object var1, Method var2, Class_21 var3) {
   }

   // $VF: renamed from: nps (java.lang.Object) void
   public void method_561(Object var1) {
   }

   // $VF: renamed from: ff () void
   public void method_562() {
      this.field_507.clear();
   }

   // $VF: renamed from: ktj (Class_26) void
   public void method_563(Class_26 var1) {
      if (var1 != null && ScreenUI_78.field_772 instanceof ScreenUI_78 var2) {
         if (!(var1 instanceof Class_70) || !shouldSuppressKeybinds()) {
            ConfigManager_221 var8 = var2.method_797();
            if (var1 instanceof Class_70 var4) {
               var8.method_484(var4);
               if (var4.ay()) {
                  return;
               }

               if (isMovementKey(var4.field_958.comp_4795())) {
                  return;
               }
            }

            for (Object var6 : var8.method_478()) {
               if (var6 instanceof Class_342) {
                  Class_342 var7 = (Class_342)var6;
                  if (ConfigManager_221.moduleEnabled(var7)) {
                     dispatch(var7, var1);
                  }
               }
            }
         }
      }
   }

   public static void guard() {
   }

   private static void dispatch(Object var0, Object var1) {
      Method[] var2 = var0.getClass().getMethods();

      for (Method var6 : var2) {
         Class[] var7 = var6.getParameterTypes();
         if (var7.length == 1 && var7[0].isAssignableFrom(var1.getClass())) {
            try {
               var6.setAccessible(true);
               var6.invoke(var0, var1);
            } catch (Throwable var9) {
            }
         }
      }
   }

   private static boolean isMovementKey(int var0) {
      return var0 == 32
         || var0 == 65
         || var0 == 68
         || var0 == 83
         || var0 == 87
         || var0 == 263
         || var0 == 264
         || var0 == 265
         || var0 == 262
         || var0 == 340
         || var0 == 341
         || var0 == 344
         || var0 == 345;
   }

   private static boolean shouldSuppressKeybinds() {
      try {
         return Boolean.TRUE.equals(Class.forName("dev.krypton.diddy.DiddyEntrypoint").getMethod("shouldSuppressKeybinds").invoke(null));
      } catch (Throwable var1) {
         return false;
      }
   }
}
