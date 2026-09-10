import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import net.minecraft.class_2960;

public class ScreenUI_78 {
   // $VF: renamed from: xmo java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_769 = new MethodHandle[0];
   // $VF: renamed from: wwv java.lang.Object
   public static Object field_770;
   // $VF: renamed from: lr java.lang.Object
   public static Object field_771;
   // $VF: renamed from: euq java.lang.Object
   public static Object field_772;
   // $VF: renamed from: weg java.lang.Object
   public static Object field_773;
   // $VF: renamed from: bu java.lang.Object
   public static Object field_774;
   // $VF: renamed from: ila long
   public static volatile long field_775;
   // $VF: renamed from: fl int
   public static int field_776;
   // $VF: renamed from: av java.lang.Object
   public Object field_777;
   // $VF: renamed from: qn java.lang.Object
   public Object field_778;
   // $VF: renamed from: ql java.lang.Object
   public Object field_779;
   // $VF: renamed from: bs java.lang.Object
   public Object field_780;
   // $VF: renamed from: dx java.lang.Object
   public Object field_781;
   // $VF: renamed from: obw java.lang.Object
   public Object field_782;
   // $VF: renamed from: cau boolean
   public boolean field_783;
   // $VF: renamed from: eag java.lang.Object
   public Object field_784;
   // $VF: renamed from: os java.lang.Object
   public Object field_785;
   // $VF: renamed from: eck boolean
   public volatile boolean field_786;
   // $VF: renamed from: te boolean
   public volatile boolean field_787;
   // $VF: renamed from: zjl java.lang.Object
   public Object field_788;
   private final CryptoService_396 config = new CryptoService_396();

   public ScreenUI_78() {
      field_772 = this;
      this.field_778 = this.config;
      if (this.field_780 == null) {
         this.field_780 = new ConfigManager_221();
      }

      if (this.field_777 == null) {
         this.field_777 = new Class_202();
      }
   }

   // $VF: renamed from: ou (java.lang.String) net.minecraft.class_2960
   public static class_2960 method_793(String var0) {
      try {
         Class var1 = Class.forName("net.minecraft.class_2960");
         String var2 = var0 == null ? "" : var0;

         for (Method var6 : var1.getDeclaredMethods()) {
            if (Modifier.isStatic(var6.getModifiers()) && var6.getReturnType() == var1) {
               Class[] var7 = var6.getParameterTypes();
               var6.setAccessible(true);
               if (var7.length == 1 && var7[0] == String.class) {
                  try {
                     return (class_2960)var6.invoke(null, var2);
                  } catch (RuntimeException | ReflectiveOperationException var13) {
                  }
               }

               if (var7.length == 2 && var7[0] == String.class && var7[1] == String.class) {
                  String var8 = "krypton";
                  String var9 = var2;
                  int var10 = var2.indexOf(58);
                  if (var10 >= 0) {
                     var8 = var2.substring(0, var10);
                     var9 = var2.substring(var10 + 1);
                  }

                  try {
                     return (class_2960)var6.invoke(null, var8, var9);
                  } catch (RuntimeException | ReflectiveOperationException var12) {
                  }
               }
            }
         }

         for (Constructor var18 : var1.getDeclaredConstructors()) {
            Class[] var19 = var18.getParameterTypes();
            var18.setAccessible(true);
            if (var19.length == 2 && var19[0] == String.class && var19[1] == String.class) {
               String var20 = "krypton";
               String var21 = var2;
               int var22 = var2.indexOf(58);
               if (var22 >= 0) {
                  var20 = var2.substring(0, var22);
                  var21 = var2.substring(var22 + 1);
               }

               return (class_2960)var18.newInstance(var20, var21);
            }
         }
      } catch (LinkageError | ReflectiveOperationException var14) {
      }

      return null;
   }

   // $VF: renamed from: ee () void
   public void method_794() {
   }

   // $VF: renamed from: ouo () void
   public void method_795() {
   }

   // $VF: renamed from: ru (long) CryptoService_396
   public CryptoService_396 method_796(long var1) {
      return this.config;
   }

   // $VF: renamed from: xp () ConfigManager_221
   public ConfigManager_221 method_797() {
      if (!(this.field_780 instanceof ConfigManager_221)) {
         this.field_780 = new ConfigManager_221();
      }

      return (ConfigManager_221)this.field_780;
   }

   // $VF: renamed from: jio (int) Class_164
   public Class_164 method_798(int var1) {
      return null;
   }

   // $VF: renamed from: lc () Class_202
   public Class_202 method_799() {
      if (!(this.field_777 instanceof Class_202)) {
         this.field_777 = new Class_202();
      }

      return (Class_202)this.field_777;
   }

   // $VF: renamed from: wl (long) Class_359
   public Class_359 method_800(long var1) {
      if (!(this.field_784 instanceof Class_359)) {
         try {
            Class var3 = Class.forName("dev.krypton.diddy.DiddyEntrypoint");
            this.field_784 = var3.getMethod("createClickGuiScreen").invoke(null);
         } catch (LinkageError | ReflectiveOperationException var4) {
            var4.printStackTrace();
         }
      }

      return (Class_359)this.field_784;
   }

   // $VF: renamed from: vf (java.lang.Throwable) void
   public static void method_801(Throwable var0) {
      if (var0 != null) {
         var0.printStackTrace();
      }
   }

   // $VF: renamed from: kb (java.lang.String) void
   public void method_802(String var1) {
   }

   // $VF: renamed from: iia (java.lang.String, java.lang.String) void
   public void method_803(String var1, String var2) {
   }

   // $VF: renamed from: yp (java.lang.String) void
   public void method_804(String var1) {
   }

   // $VF: renamed from: tt (java.lang.String, boolean) void
   public void method_805(String var1, boolean var2) {
   }

   // $VF: renamed from: mh () void
   public void method_806() {
   }

   // $VF: renamed from: ncf (java.util.List) void
   public void method_807(List var1) {
   }

   // $VF: renamed from: vi (int, java.util.List) void
   public void method_808(int var1, List var2) {
   }

   // $VF: renamed from: pw (java.lang.String) void
   public void method_809(String var1) {
   }

   // $VF: renamed from: qfm () void
   public void method_810() {
   }

   // $VF: renamed from: yk () void
   public void method_811() {
   }

   // $VF: renamed from: vna (int) void
   public void method_812(int var1) {
   }

   // $VF: renamed from: yb (java.lang.String, java.lang.String) void
   public static void method_813(String var0, String var1) {
   }

   // $VF: renamed from: mv (java.lang.Runnable) java.lang.Thread
   public static Thread method_814(Runnable var0) {
      Thread var1 = new Thread(var0, "Krypton-diddy");
      var1.setDaemon(true);
      var1.start();
      return var1;
   }

   // $VF: renamed from: pij (int) void
   public static void method_815(int var0) {
   }

   public void __jnt__init__4077092992793081454__() {
   }

   public static void guard() {
   }

   public List modules() {
      return this.method_797().method_478();
   }
}
