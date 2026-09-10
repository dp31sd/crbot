import java.lang.invoke.MethodHandle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConfigManager_221 {
   // $VF: renamed from: ict java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_479 = new MethodHandle[0];
   private static final String[] MODULE_CLASSES = new String[]{
      "ac",
      "aj",
      "al",
      "an",
      "ap",
      "apk",
      "av",
      "ax",
      "azz",
      "bg",
      "bq",
      "bs",
      "cks",
      "cl",
      "d",
      "dht",
      "egg",
      "egh",
      "f",
      "ffv",
      "fp",
      "gc",
      "gy",
      "gz",
      "ho",
      "ijq",
      "iko",
      "ip",
      "is",
      "izs",
      "ja",
      "jl",
      "k",
      "kd",
      "ke",
      "kh",
      "kl",
      "ku",
      "la",
      "ld",
      "lmy",
      "lwu",
      "mh",
      "mob",
      "mu",
      "my",
      "nd",
      "nq",
      "nw",
      "o",
      "ok",
      "ow",
      "oz",
      "pkx",
      "qc",
      "qpf",
      "qw",
      "rnu",
      "sf",
      "sn",
      "ss",
      "tc",
      "tfw",
      "tlk",
      "tn",
      "tv",
      "ue",
      "ui",
      "uy",
      "v",
      "vap",
      "vb",
      "vu",
      "wfu",
      "wgp",
      "xax",
      "xk",
      "xpl",
      "xu",
      "xy",
      "yj",
      "ze",
      "zk",
      "zr",
      "zt"
   };
   // $VF: renamed from: bt java.lang.Object
   public Object field_480;
   private final List modules = new ArrayList();

   public ConfigManager_221() {
      this.field_480 = this.modules;
      this.seedModules();
   }

   // $VF: renamed from: kx () java.util.List
   public List method_478() {
      return this.modules;
   }

   // $VF: renamed from: fs (java.lang.String, int) Class_342
   public Class_342 method_479(String var1, int var2) {
      if (var1 == null) {
         return null;
      } else {
         for (Object var4 : this.modules) {
            if (var4 instanceof Class_342 var5 && var1.equals(moduleName(var5))) {
               return var5;
            }
         }

         return var2 >= 0 && var2 < this.modules.size() && this.modules.get(var2) instanceof Class_342 ? (Class_342)this.modules.get(var2) : null;
      }
   }

   // $VF: renamed from: px () java.util.List
   public List method_480() {
      return this.modules;
   }

   // $VF: renamed from: ocp (Class_400) java.util.List
   public List method_481(Class_400 var1) {
      if (var1 == null) {
         return this.modules;
      } else {
         ArrayList var2 = new ArrayList();

         for (Object var4 : this.modules) {
            if (var4 instanceof Class_342 && moduleCategory((Class_342)var4) == var1) {
               var2.add(var4);
            }
         }

         return var2;
      }
   }

   // $VF: renamed from: is (java.lang.Class) Class_342
   public Class_342 method_482(Class var1) {
      if (var1 == null) {
         return null;
      } else {
         for (Object var3 : this.modules) {
            if (var1.isInstance(var3)) {
               return (Class_342)var3;
            }
         }

         return null;
      }
   }

   // $VF: renamed from: ko (Class_342, int) void
   public void method_483(Class_342 var1, int var2) {
      if (var1 != null) {
         try {
            var1.method_1404(var2);
         } catch (Throwable var4) {
         }

         var1.field_1517 = var2;
         saveConfig();
      }
   }

   // $VF: renamed from: sr (Class_70) void
   public void method_484(Class_70 var1) {
      if (var1 != null && var1.field_958 != null && var1.field_959 == 1) {
         int var2 = var1.field_958.comp_4795();
         if (var2 != -1) {
            for (Object var4 : this.modules) {
               if (var4 instanceof Class_342 var5) {
                  method_487(var1, var5);
                  if (var1.ay()) {
                     return;
                  }
               }
            }
         }
      }
   }

   public boolean handleKeybind(int var1) {
      if (var1 == -1) {
         return false;
      } else {
         for (Object var3 : this.modules) {
            if (var3 instanceof Class_342 var4 && matchesKeybind(var4, var1)) {
               setModuleEnabled(var4, !moduleEnabled(var4));
               saveConfig();
               return true;
            }
         }

         return false;
      }
   }

   // $VF: renamed from: xu (Class_354) void
   public void method_485(Class_354 var1) {
   }

   // $VF: renamed from: ug (Class_354, Class_342) void
   public static void method_486(Class_354 var0, Class_342 var1) {
   }

   // $VF: renamed from: ab (Class_70, Class_342) void
   public static void method_487(Class_70 var0, Class_342 var1) {
      if (var0 != null && var1 != null && var0.field_958 != null && var0.field_959 == 1) {
         int var2 = var0.field_958.comp_4795();
         if (matchesKeybind(var1, var2)) {
            setModuleEnabled(var1, !moduleEnabled(var1));
            var0.li();
         }
      }
   }

   private static boolean matchesKeybind(Class_342 var0, int var1) {
      if (var0 == null) {
         return false;
      } else {
         int var2 = var0.field_1517;
         return var1 != -1 && var2 == var1 && !isClickGuiModule(var0);
      }
   }

   // $VF: renamed from: mgn (Class_400, Class_342) boolean
   public static boolean method_488(Class_400 var0, Class_342 var1) {
      return var1 != null && moduleCategory(var1) == var0;
   }

   // $VF: renamed from: jqc (java.lang.String, Class_342) boolean
   public static boolean method_489(String var0, Class_342 var1) {
      return var1 != null && var0 != null && var0.equals(moduleName(var1));
   }

   // $VF: renamed from: au (int) void
   static void method_490(int var0) {
   }

   public void __jnt__init__335709356644597222__() {
   }

   public static void guard() {
   }

   private void seedModules() {
      if (this.modules.isEmpty()) {
         this.seedRealModules();
         if (this.modules.isEmpty()) {
            Class_400[] var1 = categories();
            if (var1.length != 0) {
               this.method_491("KillAura", "Attacks nearby targets", 0, category(var1, 0));
               this.method_491("AutoTotem", "Keeps a totem ready", 0, category(var1, 0));
               this.method_491("Velocity", "Adjusts knockback", 0, category(var1, 0));
               this.method_491("Speed", "Movement speed module", 0, category(var1, 1));
               this.method_491("Fly", "Air movement module", 0, category(var1, 1));
               this.method_491("NoFall", "Prevents fall damage", 0, category(var1, 1));
               this.method_491("ESP", "Highlights entities", 0, category(var1, 2));
               this.method_491("Fullbright", "Raises world brightness", 0, category(var1, 2));
               this.method_491("HUD", "Draws the client overlay", 0, category(var1, 2));
               this.method_491("Scaffold", "Places blocks while moving", 0, category(var1, 4));
               this.method_491("ChestStealer", "Moves chest items quickly", 0, category(var1, 3));
               this.method_491("ClickGUI", "Opens this screen", 344, category(var1, 5));
            }
         }
      }
   }

   // $VF: renamed from: add (java.lang.String, java.lang.String, int, Class_400) void
   private void method_491(String var1, String var2, int var3, Class_400 var4) {
      if (var4 != null) {
         try {
            DiddyModule var5 = new DiddyModule(var1, var2, var3, var4);
            ensureKeybindSetting(var5);
            this.modules.add(var5);
         } catch (Throwable var6) {
         }
      }
   }

   private void seedRealModules() {
      ClassLoader var1 = ConfigManager_221.class.getClassLoader();

      for (String var5 : MODULE_CLASSES) {
         try {
            Class var6 = Class.forName(var5, true, var1);
            if (Class_342.class.isAssignableFrom(var6)) {
               Constructor var7 = var6.getDeclaredConstructor();
               var7.setAccessible(true);
               Object var8 = var7.newInstance();
               Class_342 var9 = (Class_342)var8;
               ensureKeybindSetting(var9);
               this.modules.add(var9);
            }
         } catch (Throwable var10) {
         }
      }
   }

   private static Class_400[] categories() {
      try {
         return Class_400.values();
      } catch (Throwable var1) {
         return new Class_400[0];
      }
   }

   private static Class_400 category(Class_400[] var0, int var1) {
      return var0.length == 0 ? null : var0[Math.floorMod(var1, var0.length)];
   }

   public static String moduleName(Class_342 var0) {
      try {
         String var1 = var0.method_1399();
         if (var1 != null) {
            return var1;
         }
      } catch (Throwable var2) {
      }

      return var0.field_1512;
   }

   public static String moduleDescription(Class_342 var0) {
      try {
         String var1 = var0.method_1402();
         if (var1 != null) {
            return var1;
         }
      } catch (Throwable var2) {
      }

      return var0.field_1513 == null ? "" : var0.field_1513;
   }

   public static Class_400 moduleCategory(Class_342 var0) {
      try {
         return var0.method_1405();
      } catch (Throwable var2) {
         return var0.field_1514;
      }
   }

   public static boolean moduleEnabled(Class_342 var0) {
      return var0 != null && var0.field_1516;
   }

   public static void setModuleEnabled(Class_342 var0, boolean var1) {
      try {
         var0.method_1401(var1);
      } catch (Throwable var3) {
         var0.field_1516 = var1;
      }
   }

   public static void ensureKeybindSetting(Class_342 var0) {
      if (var0 != null && !isClickGuiModule(var0)) {
         try {
            List var1 = var0.method_1406();
            Class_115 var2 = null;
            Iterator var3 = var1.iterator();

            while (var3.hasNext()) {
               Object var4 = var3.next();
               if (var4 instanceof Class_115) {
                  Class_115 var5 = (Class_115)var4;
                  if (isModuleKeybindSetting(var5)) {
                     if (var2 == null) {
                        var2 = var5;
                     } else {
                        var3.remove();
                     }
                  }
               }
            }

            if (var2 == null) {
               var2 = new Class_115("Keybind", var0.field_1517, true);
               var0.method_1409(var2);
            }

            registerKeybindSetting(var2, var0);
         } catch (Throwable var6) {
         }
      }
   }

   public static void syncKeybindFromSetting(Class_342 var0) {
      if (var0 != null) {
         try {
            for (Object var2 : var0.method_1406()) {
               if (var2 instanceof Class_115 var3 && isModuleKeybindSetting(var3)) {
                  int var4 = var3.method_1029();

                  try {
                     var0.method_1404(var4);
                  } catch (Throwable var6) {
                  }

                  var0.field_1517 = var4;
                  return;
               }
            }
         } catch (Throwable var7) {
         }
      }
   }

   public static void syncKeybindSetting(Class_342 var0) {
      if (var0 != null) {
         try {
            for (Object var2 : var0.method_1406()) {
               if (var2 instanceof Class_115 var3 && isModuleKeybindSetting(var3)) {
                  var3.method_1030(var0.field_1517);
                  return;
               }
            }
         } catch (Throwable var4) {
         }
      }
   }

   private static boolean isClickGuiModule(Class_342 var0) {
      String var1 = moduleName(var0);
      return "Krypton+".equalsIgnoreCase(var1) || "ClickGUI".equalsIgnoreCase(var1) || "izs".equals(var0.getClass().getName());
   }

   private static boolean isModuleKeybindSetting(Class_115 var0) {
      if (var0 == null) {
         return false;
      } else {
         try {
            if (var0.method_1026()) {
               return true;
            }
         } catch (Throwable var4) {
         }

         try {
            String var1 = var0.fdy();
            if ("Keybind".equalsIgnoreCase(var1)) {
               return true;
            }
         } catch (Throwable var3) {
         }

         try {
            return "Keybind".equalsIgnoreCase(var0.nb);
         } catch (Throwable var2) {
            return false;
         }
      }
   }

   private static void saveConfig() {
      try {
         Class.forName("dev.krypton.diddy.DiddyEntrypoint").getMethod("saveConfig").invoke(null);
      } catch (Throwable var1) {
      }
   }

   private static void registerKeybindSetting(Object var0, Class_342 var1) {
      try {
         Class.forName("dev.krypton.diddy.DiddyEntrypoint").getMethod("registerKeybindSetting", Object.class, Object.class).invoke(null, var0, var1);
      } catch (Throwable var3) {
      }
   }
}
