package dev.krypton.diddy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.lwjgl.glfw.GLFW;

public final class DiddyEntrypoint implements PreLaunchEntrypoint, ModInitializer, ClientModInitializer {
   private static boolean lastRightShift;
   private static Object clientInstance;
   private static Object kryptonClient;
   private static long lastOpenFailureLog;
   private static int nkiRenderCalls;
   private static int nkiQppCalls;
   private static int forcedNkiQppCalls;
   private static int vpQppCalls;
   private static int forcedVpQppCalls;
   private static int hudEnableChecks;
   private static int autosaveTicks;
   private static boolean clickGuiPrimed;
   private static Object configAppliedToManager;
   private static boolean applyingConfig;
   private static boolean savingConfig;
   private static final Set<Object> initializedModules = Collections.newSetFromMap(new IdentityHashMap<>());
   private static final IdentityHashMap<Object, Object> keybindOwners = new IdentityHashMap<>();

   public void onPreLaunch() {
      ensureKryptonClientSkeleton();
   }

   public void onInitialize() {
      ensureKryptonClientSkeleton();
   }

   public void onInitializeClient() {
      ensureKryptonClientSkeleton();
   }

   public static synchronized void initializeClientAtMinecraftTail(Object var0) {
      bindClient(var0);
   }

   public static void onClientTick(Object var0) {
      bindClient(var0);
      dispatchEvent("xr");
      if (isInGame(var0) && (++hudEnableChecks & 31) == 1) {
         primeClickGuiState();
         enableHudModule();
         initializeEnabledModules();
      }

      if (isInGame(var0)) {
         dispatchEvent("mk");
      }

      forwardMovementKeys(var0);
      boolean var1 = isRightShiftDown(var0);
      if (var1 && !lastRightShift && !shouldSuppressKeybinds()) {
         openClickGui(var0);
      }

      lastRightShift = var1;
      autosaveAppliedConfig();
   }

   private static synchronized void bindClient(Object var0) {
      if (var0 != null) {
         clientInstance = var0;

         try {
            ClassLoader var1 = DiddyEntrypoint.class.getClassLoader();
            Class var2 = Class.forName("fa", true, var1);
            ensureKryptonClientSkeleton();
            setStaticField(var2, "lr", var0);
            setStaticField(var2, "euq", kryptonClient);
            ensureClientField(var2, "qn", Class.forName("xw", true, var1));
            ensureRealClientField(var2, "bs", Class.forName("nc", true, var1));
            setInstanceField(kryptonClient, "config", var2.getField("qn").get(kryptonClient));
            ensureClientField(var2, "av", Class.forName("mdl", true, var1));
            ensureRenderMatrixStack(var1);
            initializeRenderer(var1);
            initializeFontRenderer(var1);
            normalizeCategoryNames(var1);
            applyConfigOnce(var2);
         } catch (ReflectiveOperationException var3) {
            throw new RuntimeException("Failed to bind Krypton client state", var3);
         }
      }
   }

   public static void ensureRenderMatrixStack() {
      ensureRenderMatrixStack(DiddyEntrypoint.class.getClassLoader());
   }

   private static void ensureRenderMatrixStack(ClassLoader var0) {
      try {
         Class var1 = Class.forName("fa", true, var0);
         Field var2 = var1.getField("wwv");
         if (var2.get(null) == null) {
            Class var3 = Class.forName("net.minecraft.class_4587", false, var0);
            var2.set(null, var3.getDeclaredConstructor().newInstance());
         }
      } catch (LinkageError | ReflectiveOperationException var4) {
      }
   }

   private static synchronized void ensureKryptonClientSkeleton() {
      try {
         ClassLoader var0 = DiddyEntrypoint.class.getClassLoader();
         Class var1 = Class.forName("fa", true, var0);
         if (kryptonClient == null) {
            kryptonClient = allocateWithoutConstructor(var1);
         }

         setStaticField(var1, "euq", kryptonClient);
         ensureAllocatedClientField(var1, "qn", Class.forName("xw", true, var0));
         setInstanceField(kryptonClient, "config", var1.getField("qn").get(kryptonClient));
         ensureMinimalModuleManager(var1, Class.forName("nc", true, var0));
         ensureAllocatedClientField(var1, "av", Class.forName("mdl", true, var0));
      } catch (LinkageError | ReflectiveOperationException var2) {
      }
   }

   private static Object allocateWithoutConstructor(Class<?> var0) throws ReflectiveOperationException {
      Constructor var1 = Object.class.getDeclaredConstructor();
      var1.setAccessible(true);
      Class var2 = Class.forName("sun.reflect.ReflectionFactory");
      Object var3 = var2.getMethod("getReflectionFactory").invoke(null);
      Method var4 = var2.getMethod("newConstructorForSerialization", Class.class, Constructor.class);
      Constructor var5 = (Constructor)var4.invoke(var3, var0, var1);
      var5.setAccessible(true);
      return var5.newInstance();
   }

   private static void ensureAllocatedClientField(Class<?> var0, String var1, Class<?> var2) throws ReflectiveOperationException {
      Field var3 = var0.getField(var1);
      Object var4 = var3.get(kryptonClient);
      if (var4 == null || !var2.isInstance(var4)) {
         var3.set(kryptonClient, allocateWithoutConstructor(var2));
      }
   }

   private static void ensureMinimalModuleManager(Class<?> var0, Class<?> var1) throws ReflectiveOperationException {
      Field var2 = var0.getField("bs");
      Object var3 = var2.get(kryptonClient);
      if (var3 == null || !var1.isInstance(var3)) {
         Object var4 = allocateWithoutConstructor(var1);
         ArrayList var5 = new ArrayList();
         setInstanceField(var4, "modules", var5);
         setInstanceField(var4, "bt", var5);
         var2.set(kryptonClient, var4);
      }
   }

   private static boolean isRightShiftDown(Object var0) {
      try {
         Method var1 = var0.getClass().getMethod("method_22683");
         Object var2 = var1.invoke(var0);
         Method var3 = var2.getClass().getMethod("method_4490");
         long var4 = (Long)var3.invoke(var2);
         return GLFW.glfwGetKey(var4, 344) == 1;
      } catch (ReflectiveOperationException var6) {
         return false;
      }
   }

   public static void openClickGui(Object var0) {
      try {
         if (var0 == null) {
            var0 = clientInstance;
         }

         if (var0 == null) {
            return;
         }

         if (!isInGame(var0)) {
            return;
         }

         if (shouldSuppressKeybinds()) {
            return;
         }

         bindClient(var0);
         Object var1 = getCurrentScreen(var0);
         if (isClickGuiScreen(var1)) {
            return;
         }

         Object var5 = clickGuiScreen();
         setClientField("os", shouldRenderBehindClickGui(var1) ? var1 : null);
         setClientField("ql", null);
         setClientField("eag", var5);
         setScreen(var0, var5);
         setClientField("eag", var5);
      } catch (LinkageError | ReflectiveOperationException var4) {
         long var2 = System.currentTimeMillis();
         if (var2 - lastOpenFailureLog > 5000L) {
            lastOpenFailureLog = var2;
            var4.printStackTrace();
         }
      }
   }

   private static Object clickGuiScreen() throws ReflectiveOperationException {
      return createClickGuiScreen();
   }

   private static void primeClickGuiState() {
      if (!clickGuiPrimed) {
         try {
            createClickGuiScreen();
            clickGuiPrimed = true;
         } catch (LinkageError | ReflectiveOperationException var1) {
         }
      }
   }

   public static Object createClickGuiScreen() throws ReflectiveOperationException {
      Class var0 = Class.forName("vp", true, DiddyEntrypoint.class.getClassLoader());
      Field var1 = Class.forName("fa", true, DiddyEntrypoint.class.getClassLoader()).getField("eag");
      if (kryptonClient == null) {
         Class var2 = Class.forName("fa", true, DiddyEntrypoint.class.getClassLoader());
         Constructor var3 = var2.getDeclaredConstructor();
         var3.setAccessible(true);
         kryptonClient = var3.newInstance();
         var2.getField("euq").set(null, kryptonClient);
      }

      Object var4 = var1.get(kryptonClient);
      if (var0.isInstance(var4)) {
         return var4;
      } else {
         Object var5 = constructClickGuiWithoutBeacon(var0);
         var1.set(kryptonClient, var5);
         return var5;
      }
   }

   private static Object constructClickGuiWithoutBeacon(Class<?> var0) throws ReflectiveOperationException {
      ClassLoader var1 = DiddyEntrypoint.class.getClassLoader();
      Object var2 = allocateScreenWithBaseConstructor(var0, emptyText(var1));
      ArrayList var3 = new ArrayList();
      setInstanceField(var2, "cvs", var3);
      setInstanceField(var2, "ie", null);
      setInstanceField(var2, "ru", -1.0);
      setInstanceField(var2, "bh", null);
      Class var4 = Class.forName("yb", true, var1);
      normalizeCategoryNames(var1);
      Object[] var5 = (Object[])var4.getMethod("values").invoke(null);
      Class var6 = Class.forName("xx", true, var1);
      Constructor var7 = var6.getDeclaredConstructor(int.class, int.class, int.class, int.class, var4, var0);
      var7.setAccessible(true);
      short var8 = 50;

      for (Object var12 : var5) {
         Object var13 = var7.newInstance(Integer.valueOf(var8), 50, 230, 30, var12, var2);
         var3.add(var13);
         var8 += 250;
      }

      Class var14 = Class.forName("io", true, var1);
      Constructor var15 = var14.getDeclaredConstructor(int.class, int.class, int.class, var0);
      var15.setAccessible(true);
      Object var16 = var15.newInstance(Integer.valueOf(var8), 50, 230, var2);
      setInstanceField(var2, "qjq", var16);
      return var2;
   }

   private static void normalizeCategoryNames(ClassLoader var0) {
      try {
         Class var1 = Class.forName("yb", true, var0);
         Object[] var2 = (Object[])var1.getMethod("values").invoke(null);

         for (Object var6 : var2) {
            setStringFieldIfPresent(var6, "name", "StarryDev");
            setStringFieldIfPresent(var6, "pzn", "StarryDev");
         }
      } catch (LinkageError | ReflectiveOperationException var7) {
      }
   }

   private static void setStringFieldIfPresent(Object var0, String var1, String var2) {
      if (var0 != null) {
         try {
            Field var3 = declaredField(var0.getClass(), var1);
            var3.setAccessible(true);
            var3.set(var0, var2);
         } catch (LinkageError | ReflectiveOperationException var4) {
         }
      }
   }

   private static Object allocateScreenWithBaseConstructor(Class<?> var0, Object var1) throws ReflectiveOperationException {
      ClassLoader var2 = DiddyEntrypoint.class.getClassLoader();
      Class var3 = Class.forName("net.minecraft.class_2561", false, var2);
      Class var4 = Class.forName("net.minecraft.class_437", false, var2);
      Constructor var5 = var4.getDeclaredConstructor(var3);
      var5.setAccessible(true);
      Class var6 = Class.forName("sun.reflect.ReflectionFactory");
      Object var7 = var6.getMethod("getReflectionFactory").invoke(null);
      Method var8 = var6.getMethod("newConstructorForSerialization", Class.class, Constructor.class);
      Constructor var9 = (Constructor)var8.invoke(var7, var0, var5);
      var9.setAccessible(true);
      return var9.newInstance(var1);
   }

   private static Object emptyText(ClassLoader var0) throws ReflectiveOperationException {
      Class var1 = Class.forName("net.minecraft.class_2561", false, var0);

      for (Method var5 : var1.getMethods()) {
         if (Modifier.isStatic(var5.getModifiers()) && var1.isAssignableFrom(var5.getReturnType())) {
            Class[] var6 = var5.getParameterTypes();
            if (var6.length == 1 && var6[0] == String.class) {
               var5.setAccessible(true);
               return var5.invoke(null, "");
            }
         }
      }

      throw new NoSuchMethodException("empty text factory");
   }

   private static boolean shouldRenderBehindClickGui(Object var0) {
      return var0 != null && !"vp".equals(var0.getClass().getName()) && !"nki".equals(var0.getClass().getName());
   }

   private static boolean isClickGuiScreen(Object var0) {
      if (var0 == null) {
         return false;
      } else {
         String var1 = var0.getClass().getName();
         return "vp".equals(var1);
      }
   }

   private static void setScreen(Object var0, Object var1) throws ReflectiveOperationException {
      Class var2 = Class.forName("net.minecraft.class_437", false, DiddyEntrypoint.class.getClassLoader());
      Method var3 = var0.getClass().getMethod("method_1507", var2);
      var3.invoke(var0, var1);
   }

   private static Object getCurrentScreen(Object var0) {
      try {
         Field var1 = var0.getClass().getDeclaredField("field_1755");
         var1.setAccessible(true);
         return var1.get(var0);
      } catch (ReflectiveOperationException var2) {
         return null;
      }
   }

   public static boolean isInGame(Object var0) {
      if (var0 == null) {
         return false;
      } else {
         try {
            Field var1 = var0.getClass().getDeclaredField("field_1687");
            Field var2 = var0.getClass().getDeclaredField("field_1724");
            var1.setAccessible(true);
            var2.setAccessible(true);
            return var1.get(var0) != null && var2.get(var0) != null;
         } catch (ReflectiveOperationException var3) {
            return false;
         }
      }
   }

   private static void enableHudModule() {
      try {
         Class var0 = Class.forName("usf", true, DiddyEntrypoint.class.getClassLoader());
         Method var1 = kryptonClient.getClass().getMethod("modules");
         Object var2 = var1.invoke(kryptonClient);
         if (!(var2 instanceof Iterable)) {
            return;
         }

         for (Object var5 : (Iterable)var2) {
            if (var5 != null && var0.isInstance(var5)) {
               String var6 = moduleName(var5);
               if ("hud".equalsIgnoreCase(var6)) {
                  Method var7 = Class.forName("nc", true, DiddyEntrypoint.class.getClassLoader()).getMethod("setModuleEnabled", var0, boolean.class);
                  var7.invoke(null, var5, true);
                  initializeModule(var5);
                  return;
               }
            }
         }
      } catch (LinkageError | ReflectiveOperationException var8) {
      }
   }

   private static void initializeEnabledModules() {
      try {
         Class var0 = Class.forName("usf", true, DiddyEntrypoint.class.getClassLoader());
         Method var1 = kryptonClient.getClass().getMethod("modules");
         if (!(var1.invoke(kryptonClient) instanceof Iterable var3)) {
            return;
         }

         Method var4 = Class.forName("nc", true, DiddyEntrypoint.class.getClassLoader()).getMethod("moduleEnabled", var0);

         for (Object var6 : var3) {
            if (var6 != null && var0.isInstance(var6) && Boolean.TRUE.equals(var4.invoke(null, var6))) {
               initializeModule(var6);
            }
         }
      } catch (LinkageError | ReflectiveOperationException var7) {
      }
   }

   private static void initializeModule(Object var0) {
      if (var0 != null && initializedModules.add(var0)) {
         if (!shouldSkipModuleLifecycle(var0)) {
            try {
               var0.getClass().getMethod("mg").invoke(var0);
            } catch (Throwable var2) {
               fallbackModuleStart(var0);
            }
         }
      }
   }

   public static void fallbackModuleLifecycle(Object var0, boolean var1) {
      if (var1) {
         fallbackModuleStart(var0);
      } else {
         fallbackModuleStop(var0);
      }
   }

   private static void fallbackModuleStart(Object var0) {
      if (var0 != null) {
         ensureModuleExecutors(var0);
      }
   }

   private static void fallbackModuleStop(Object var0) {
      if (var0 != null) {
         for (Field var2 : allFields(var0.getClass())) {
            if (ExecutorService.class.isAssignableFrom(var2.getType())) {
               try {
                  var2.setAccessible(true);
                  Object var3 = var2.get(var0);
                  if (var3 instanceof ExecutorService) {
                     ExecutorService var4 = (ExecutorService)var3;
                     if (!var4.isShutdown()) {
                        var4.shutdownNow();
                     }
                  }
               } catch (Throwable var5) {
               }
            }
         }
      }
   }

   private static void ensureModuleExecutors(Object var0) {
      for (Field var2 : allFields(var0.getClass())) {
         if (ExecutorService.class.isAssignableFrom(var2.getType())) {
            try {
               var2.setAccessible(true);
               if (!(var2.get(var0) instanceof ExecutorService var4) || var4.isShutdown()) {
                  String var6 = var0.getClass().getName();
                  var2.set(var0, Executors.newSingleThreadExecutor(var2x -> {
                     Thread var3 = new Thread(var2x, "krypton-" + var6 + "-" + var2.getName());
                     var3.setDaemon(true);
                     return var3;
                  }));
               }
            } catch (Throwable var5) {
            }
         }
      }
   }

   private static List<Field> allFields(Class<?> var0) {
      ArrayList var1 = new ArrayList();

      for (Class var2 = var0; var2 != null; var2 = var2.getSuperclass()) {
         Collections.addAll(var1, var2.getDeclaredFields());
      }

      return var1;
   }

   public static void forwardMovementKeys() {
      forwardMovementKeys(clientInstance);
   }

   private static void forwardMovementKeys(Object var0) {
      if (var0 != null && isClickGuiScreen(getCurrentScreen(var0))) {
         try {
            Field var1 = declaredField(var0.getClass(), "field_1690");
            var1.setAccessible(true);
            Object var2 = var1.get(var0);
            Object var3 = var0.getClass().getMethod("method_22683").invoke(var0);
            long var4 = (Long)var3.getClass().getMethod("method_4490").invoke(var3);
            setKeyPressed(var2, "field_1894", var4, 87, 265);
            setKeyPressed(var2, "field_1913", var4, 65, 263);
            setKeyPressed(var2, "field_1881", var4, 83, 264);
            setKeyPressed(var2, "field_1849", var4, 68, 262);
            setKeyPressed(var2, "field_1903", var4, 32);
            setKeyPressed(var2, "field_1832", var4, 340);
            setKeyPressed(var2, "field_1867", var4, 341);
         } catch (LinkageError | ReflectiveOperationException var6) {
         }
      }
   }

   private static void setKeyPressed(Object var0, String var1, long var2, int... var4) throws ReflectiveOperationException {
      Field var5 = declaredField(var0.getClass(), var1);
      var5.setAccessible(true);
      Object var6 = var5.get(var0);
      boolean var7 = false;

      for (int var11 : var4) {
         var7 |= GLFW.glfwGetKey(var2, var11) == 1;
      }

      var6.getClass().getMethod("method_23481", boolean.class).invoke(var6, var7);
   }

   public static boolean shouldForceVpRender() {
      return false;
   }

   public static boolean shouldSuppressKeybinds() {
      Object var0 = getCurrentScreen(clientInstance);
      return var0 != null && !isClickGuiScreen(var0);
   }

   public static void handleKeyPress(long var0, int var2, Object var3) {
      if (var2 == 1 && var3 != null && !shouldSuppressKeybinds()) {
         int var4;
         try {
            if (!(var3.getClass().getMethod("comp_4795").invoke(var3) instanceof Number var6)) {
               return;
            }

            var4 = var6.intValue();
         } catch (LinkageError | ReflectiveOperationException var7) {
            return;
         }

         if (var4 != -1) {
            if (!toggleModuleKeybind(var4)) {
               if (var4 == 344) {
                  openClickGui(clientInstance);
               }
            }
         }
      }
   }

   private static boolean toggleModuleKeybind(int var0) {
      try {
         Class var1 = Class.forName("fa", true, DiddyEntrypoint.class.getClassLoader());
         Object var2 = var1.getField("euq").get(null);
         if (var2 == null) {
            return false;
         } else {
            Object var3 = var1.getField("bs").get(var2);
            if (var3 == null) {
               return false;
            } else {
               Object var4 = var3.getClass().getMethod("handleKeybind", int.class).invoke(var3, var0);
               return Boolean.TRUE.equals(var4);
            }
         }
      } catch (LinkageError | ReflectiveOperationException var5) {
         return false;
      }
   }

   public static boolean shouldSkipModuleLifecycle(Object var0) {
      String var1 = moduleName(var0);
      return "Krypton+".equalsIgnoreCase(var1) || var0 != null && "izs".equals(var0.getClass().getName());
   }

   public static void saveConfig() {
      if (!savingConfig && !applyingConfig && configAppliedToManager != null) {
         savingConfig = true;

         try {
            Object var0 = getConfigObject();
            if (var0 != null) {
               var0.getClass().getMethod("saveCurrent").invoke(var0);
            }
         } catch (LinkageError | ReflectiveOperationException var4) {
         } finally {
            savingConfig = false;
         }
      }
   }

   public static void registerKeybindSetting(Object var0, Object var1) {
      if (var0 != null && var1 != null) {
         synchronized (keybindOwners) {
            keybindOwners.put(var0, var1);
         }
      }
   }

   public static void syncKeybindOwner(Object var0) {
      Object var1;
      synchronized (keybindOwners) {
         var1 = keybindOwners.get(var0);
      }

      if (var1 != null) {
         try {
            Object var11;
            try {
               var11 = var0.getClass().getMethod("fh").invoke(var0);
            } catch (NoSuchMethodException var8) {
               var11 = var0.getClass().getMethod("wo").invoke(var0);
            }

            if (var11 instanceof Number var3) {
               int var4 = var3.intValue();

               try {
                  var1.getClass().getMethod("mw", int.class).invoke(var1, var4);
               } catch (ReflectiveOperationException var7) {
               }

               try {
                  Field var5 = declaredField(var1.getClass(), "jm");
                  var5.setAccessible(true);
                  var5.setInt(var1, var4);
               } catch (ReflectiveOperationException var6) {
               }
            }
         } catch (LinkageError | ReflectiveOperationException var9) {
         }
      }
   }

   private static void applyConfigOnce(Class<?> var0) {
      try {
         Object var1 = var0.getField("bs").get(kryptonClient);
         if (var1 != null && var1 == configAppliedToManager) {
            return;
         }

         if (var1 == null || !(var1.getClass().getMethod("kx").invoke(var1) instanceof List var2) || var2.isEmpty()) {
            return;
         }

         Object var9 = getConfigObject();
         if (var9 != null) {
            applyingConfig = true;

            try {
               var9.getClass().getMethod("applyConfig").invoke(var9);
               configAppliedToManager = var1;
               autosaveTicks = 0;
            } finally {
               applyingConfig = false;
            }
         }
      } catch (LinkageError | ReflectiveOperationException var8) {
         applyingConfig = false;
      }
   }

   private static void autosaveAppliedConfig() {
      if (configAppliedToManager != null) {
         if (++autosaveTicks >= 20) {
            autosaveTicks = 0;
            saveConfig();
         }
      }
   }

   private static Object getConfigObject() throws ReflectiveOperationException {
      if (kryptonClient == null) {
         return null;
      } else {
         Class var0 = Class.forName("fa", true, DiddyEntrypoint.class.getClassLoader());
         Object var1 = var0.getField("qn").get(kryptonClient);
         if (var1 == null) {
            try {
               var1 = var0.getDeclaredMethod("ru", long.class).invoke(kryptonClient, 0L);
            } catch (ReflectiveOperationException var3) {
            }
         }

         return var1;
      }
   }

   private static String moduleName(Object var0) {
      try {
         Method var1 = Class.forName("nc", true, DiddyEntrypoint.class.getClassLoader())
            .getMethod("moduleName", Class.forName("usf", true, DiddyEntrypoint.class.getClassLoader()));
         Object var2 = var1.invoke(null, var0);
         return var2 == null ? "" : var2.toString();
      } catch (LinkageError | ReflectiveOperationException var3) {
         return "";
      }
   }

   private static void dispatchEvent(String var0) {
      try {
         ClassLoader var1 = DiddyEntrypoint.class.getClassLoader();
         Object var2 = Class.forName(var0, true, var1).getDeclaredConstructor().newInstance();
         Method var3 = Class.forName("mdl", true, var1).getMethod("ae", Class.forName("bll", true, var1));
         var3.invoke(null, var2);
      } catch (LinkageError | ReflectiveOperationException var4) {
      }
   }

   private static void setStaticField(Class<?> var0, String var1, Object var2) throws ReflectiveOperationException {
      Field var3 = var0.getField(var1);
      var3.set(null, var2);
   }

   private static void setClientField(String var0, Object var1) throws ReflectiveOperationException {
      Field var2 = Class.forName("fa", true, DiddyEntrypoint.class.getClassLoader()).getField(var0);
      var2.set(kryptonClient, var1);
   }

   private static void setInstanceField(Object var0, String var1, Object var2) throws ReflectiveOperationException {
      Field var3 = declaredField(var0.getClass(), var1);
      var3.setAccessible(true);
      var3.set(var0, var2);
   }

   private static Field declaredField(Class<?> var0, String var1) throws NoSuchFieldException {
      for (Class var2 = var0; var2 != null; var2 = var2.getSuperclass()) {
         try {
            return var2.getDeclaredField(var1);
         } catch (NoSuchFieldException var4) {
         }
      }

      throw new NoSuchFieldException(var1);
   }

   private static void ensureClientField(Class<?> var0, String var1, Class<?> var2) throws ReflectiveOperationException {
      Field var3 = var0.getField(var1);
      Object var4 = var3.get(kryptonClient);
      if (var4 == null || !var2.isInstance(var4) || isUnconstructedConfig(var4, var2)) {
         Constructor var5 = var2.getDeclaredConstructor();
         var5.setAccessible(true);
         var3.set(kryptonClient, var5.newInstance());
      }
   }

   private static boolean isUnconstructedConfig(Object var0, Class<?> var1) {
      if (!"xw".equals(var1.getName())) {
         return false;
      } else {
         try {
            Field var2 = declaredField(var1, "leg");
            var2.setAccessible(true);
            return var2.get(var0) == null;
         } catch (ReflectiveOperationException var3) {
            return true;
         }
      }
   }

   private static void ensureRealClientField(Class<?> var0, String var1, Class<?> var2) throws ReflectiveOperationException {
      Field var3 = var0.getField(var1);
      Object var4 = var3.get(kryptonClient);
      if (var2.isInstance(var4)) {
         try {
            if (var2.getMethod("kx").invoke(var4) instanceof List var6 && !var6.isEmpty()) {
               return;
            }
         } catch (ReflectiveOperationException var7) {
            return;
         }
      }

      Constructor var8 = var2.getDeclaredConstructor();
      var8.setAccessible(true);
      var3.set(kryptonClient, var8.newInstance());
   }

   private static void initializeRenderer(ClassLoader var0) {
      try {
         Class var1 = Class.forName("xa", true, var0);
         Field var2 = var1.getField("so");
         if (var2.get(null) == null) {
            Method var3 = var1.getMethod("smv");
            var3.invoke(null);
         }
      } catch (LinkageError | ReflectiveOperationException var4) {
      }
   }

   private static void initializeFontRenderer(ClassLoader var0) {
      try {
         Class var1 = Class.forName("nt", true, var0);
         var1.getField("oei").get(null);
         Object var2 = Class.forName("cu", true, var0).getMethod("nkq").invoke(null);
         if (var2 != null) {
            return;
         }

         Class var3 = Class.forName("cb", true, var0);
         Method var4 = var3.getMethod("ke");
         var4.invoke(null);
         var2 = Class.forName("cu", true, var0).getMethod("nkq").invoke(null);
         if (var2 == null) {
            disableCustomFont(var0);
         }
      } catch (LinkageError | ReflectiveOperationException var5) {
         disableCustomFont(var0);
      }
   }

   private static void disableCustomFont(ClassLoader var0) {
      try {
         Class var1 = Class.forName("izs", true, var0);
         Field var2 = var1.getField("mct");
         Object var3 = var2.get(null);
         if (var3 != null) {
            Method var4 = var3.getClass().getMethod("obi", boolean.class);
            var4.invoke(var3, false);
         }

         Class.forName("nt", true, var0).getField("oei").get(null);
      } catch (LinkageError | ReflectiveOperationException var5) {
      }
   }

   public static Object getClientInstance() {
      return clientInstance;
   }

   public static void onNkiRenderHead(Object var0) {
      normalizeNkiScreen(var0);
   }

   public static void onNkiQppHead(Object var0) {
      normalizeNkiScreen(var0);
   }

   public static void onForcedNkiQpp(Object var0) {
      normalizeNkiScreen(var0);
   }

   public static void onForcedNkiQppFailure(Throwable var0) {
      long var1 = System.currentTimeMillis();
      if (var1 - lastOpenFailureLog > 5000L) {
         lastOpenFailureLog = var1;
         var0.printStackTrace();
      }
   }

   public static void onVpQppHead(Object var0) {
      vpQppCalls++;
      forwardMovementKeys();
   }

   public static void onForcedVpQpp(Object var0) {
      forcedVpQppCalls++;
   }

   public static void onForcedVpQppFailure(Throwable var0) {
      long var1 = System.currentTimeMillis();
      if (var1 - lastOpenFailureLog > 5000L) {
         lastOpenFailureLog = var1;
         var0.printStackTrace();
      }
   }

   private static void normalizeNkiScreen(Object var0) {
      if (var0 != null && "nki".equals(var0.getClass().getName())) {
         try {
            Field var1 = var0.getClass().getField("ht");
            Field var2 = var0.getClass().getField("ikh");
            Field var3 = var0.getClass().getField("oy");
            if (var3.getInt(var0) == 0) {
               var3.setInt(var0, 255);
            }
         } catch (ReflectiveOperationException var4) {
         }
      }
   }

   private static String describeNki(Object var0) {
      if (var0 == null) {
         return "null";
      } else {
         try {
            return "ht="
               + var0.getClass().getField("ht").get(var0)
               + " ikh="
               + var0.getClass().getField("ikh").get(var0)
               + " pdl="
               + var0.getClass().getField("pdl").get(var0)
               + " xnj="
               + var0.getClass().getField("xnj").get(var0)
               + " wpn="
               + var0.getClass().getField("wpn").get(var0)
               + " oy="
               + var0.getClass().getField("oy").get(var0);
         } catch (ReflectiveOperationException var2) {
            return var0.getClass().getName();
         }
      }
   }
}
