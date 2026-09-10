import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class CryptoService_396 {
   // $VF: renamed from: bax java.lang.invoke.MethodHandle[]
   public static final MethodHandle[] field_72 = new MethodHandle[0];
   private static final String[] CATEGORY_NAMES = new String[]{"StarryDev", "StarryDev", "StarryDev", "StarryDev", "StarryDev", "StarryDev"};
   private static final String[][] MODULE_ROWS = new String[][]{
      {"KillAura", "Attacks nearby targets", "0"},
      {"AutoTotem", "Keeps a totem ready", "0"},
      {"Velocity", "Adjusts knockback", "0"},
      {"Speed", "Movement speed module", "1"},
      {"Fly", "Air movement module", "1"},
      {"NoFall", "Prevents fall damage", "1"},
      {"ESP", "Highlights entities", "2"},
      {"Fullbright", "Raises world brightness", "2"},
      {"HUD", "Draws the client overlay", "2"},
      {"ChestStealer", "Moves chest items quickly", "3"},
      {"Scaffold", "Places blocks while moving", "4"},
      {"ClickGUI", "Opens this screen", "5"}
   };
   // $VF: renamed from: leg com.google.gson.JsonObject
   public JsonObject field_73 = new JsonObject();
   private final Path configDir = Path.of(System.getProperty("user.dir", "."), "config", "kryptonplus");
   private final Path activeProfilePath = this.configDir.resolve("active-profile.txt");
   private Path configPath = this.readActiveConfigPath();

   public CryptoService_396() {
      this.loadFromDisk();
   }

   // $VF: renamed from: ns () java.lang.String
   public String method_80() {
      return this.method_82(false).toString();
   }

   // $VF: renamed from: cg () java.lang.String
   public String method_81() {
      return this.method_82(true).toString();
   }

   // $VF: renamed from: nck (boolean) com.google.gson.JsonObject
   public JsonObject method_82(boolean var1) {
      JsonObject var2 = this.field_73 == null ? new JsonObject() : this.field_73.deepCopy();
      JsonObject var3 = new JsonObject();

      for (Object var5 : modules()) {
         if (var5 instanceof Class_342 var6) {
            String var7 = ConfigManager_221.moduleName(var6);
            var3.add(var7 != null && !var7.isBlank() ? var7 : var6.getClass().getName(), this.moduleToJson(var6, var1));
         }
      }

      var2.add("modules", var3);
      return var2;
   }

   // $VF: renamed from: lp (Class_271, Class_342) void
   public void method_83(Class_271 var1, Class_342 var2) {
      try {
         var1.method_926();
      } catch (Throwable var4) {
      }

      this.saveCurrent();
   }

   // $VF: renamed from: za () void
   public void method_84() {
      this.saveCurrent();
      publishGuiData(null);
   }

   // $VF: renamed from: cq (java.lang.String, boolean) void
   public void method_85(String var1, boolean var2) {
      this.method_86(var1, var2, false);
   }

   // $VF: renamed from: rzs (java.lang.String, boolean, boolean) void
   public void method_86(String var1, boolean var2, boolean var3) {
      if (var2) {
         this.saveProfile(var1, var3);
      } else {
         this.loadProfileOrJson(var1);
      }
   }

   // $VF: renamed from: fz (Class_271, com.google.gson.JsonElement, Class_342) void
   public void method_87(Class_271 var1, JsonElement var2, Class_342 var3) {
      if (var1 != null && var2 != null && !var2.isJsonNull()) {
         try {
            var1.method_925(var2);
            applySettingValue(var1, var2);
            var1.method_926();
         } catch (Throwable var5) {
         }
      }
   }

   // $VF: renamed from: hsx (Class_271, com.google.gson.JsonObject) void
   public void method_88(Class_271 var1, JsonObject var2) {
      if (var1 != null && var2 != null) {
         try {
            var2.add(settingName(var1), settingToJson(var1));
         } catch (Throwable var4) {
         }
      }
   }

   // $VF: renamed from: yw (Class_27, byte[][]) void
   public void method_89(Class_27 var1, byte[]... var2) {
   }

   // $VF: renamed from: ppu (int) void
   public void method_90(int var1) {
      this.loadProfileByIndex(var1);
   }

   // $VF: renamed from: ddc (int, java.lang.String) void
   public void method_91(int var1, String var2) {
      if (var2 != null && !var2.isBlank()) {
         this.saveProfile(var2, false);
      }

      publishGuiData(var2);
   }

   // $VF: renamed from: yt (int) void
   public void method_92(int var1) {
      this.saveProfileByIndex(var1);
      publishGuiData(null);
   }

   // $VF: renamed from: zr (int) void
   public void method_93(int var1) {
      this.deleteProfileByIndex(var1);
      publishGuiData(null);
   }

   // $VF: renamed from: djd (int) void
   public void method_94(int var1) {
      this.loadProfileByIndex(var1);
      publishGuiData(null);
   }

   // $VF: renamed from: sp (java.lang.String) void
   public void method_95(String var1) {
      this.saveProfile(var1, false);
      publishGuiData(var1);
   }

   // $VF: renamed from: by (java.lang.String) void
   public void method_96(String var1) {
      this.loadProfileOrJson(var1);
      publishGuiData(var1);
   }

   // $VF: renamed from: ghp () void
   public void method_97() {
      this.loadProfileOrJson("default");
      publishGuiData(null);
   }

   // $VF: renamed from: ucc () void
   public void method_98() {
      this.saveProfile("default", false);
      publishGuiData(null);
   }

   // $VF: renamed from: vd (java.lang.String) void
   public void method_99(String var1) {
      this.deleteProfile(var1);
      publishGuiData(var1);
   }

   // $VF: renamed from: dgx (java.lang.String) int
   public int method_100(String var1) {
      return 0;
   }

   // $VF: renamed from: svi (java.lang.String) java.util.List
   public List method_101(String var1) {
      return categoryRows();
   }

   // $VF: renamed from: ppn (java.lang.String) java.util.List
   public List method_102(String var1) {
      return moduleRows(var1);
   }

   private static ArrayList categoryRows() {
      ArrayList var0 = new ArrayList();
      Class_400[] var1 = categories();
      if (var1.length != 0) {
         for (int var3 = 0; var3 < var1.length; var3++) {
            var0.add(new Class_137(var3, categoryName(var1[var3], var3), 0L));
         }

         return var0;
      } else {
         for (int var2 = 0; var2 < CATEGORY_NAMES.length; var2++) {
            var0.add(new Class_137(var2, CATEGORY_NAMES[var2], 0L));
         }

         return var0;
      }
   }

   private static ArrayList moduleRows(String var0) {
      ArrayList var1 = new ArrayList();
      String var2 = var0 == null ? "" : var0.trim().toLowerCase();
      List var3 = modules();
      if (!var3.isEmpty()) {
         for (int var11 = 0; var11 < var3.size(); var11++) {
            Object var12 = var3.get(var11);
            if (var12 instanceof Class_342) {
               Class_342 var6 = (Class_342)var12;
               String var7 = safe(ConfigManager_221.moduleName(var6));
               String var8 = safe(ConfigManager_221.moduleDescription(var6));
               Class_400 var9 = ConfigManager_221.moduleCategory(var6);
               String var10 = categoryName(var9, var9 == null ? 0 : var9.ordinal());
               if (var2.isEmpty() || var7.toLowerCase().contains(var2) || var8.toLowerCase().contains(var2) || var10.toLowerCase().contains(var2)) {
                  var1.add(new Class_75(var11, var7, var8, var9 == null ? 0 : var9.ordinal()));
               }
            }
         }

         return var1;
      } else {
         for (int var4 = 0; var4 < MODULE_ROWS.length; var4++) {
            String[] var5 = MODULE_ROWS[var4];
            if (var2.isEmpty()
               || var5[0].toLowerCase().contains(var2)
               || var5[1].toLowerCase().contains(var2)
               || CATEGORY_NAMES[Integer.parseInt(var5[2])].toLowerCase().contains(var2)) {
               var1.add(new Class_75(var4, var5[0], var5[1], Integer.parseInt(var5[2])));
            }
         }

         return var1;
      }
   }

   private static List modules() {
      if (ScreenUI_78.field_772 instanceof ScreenUI_78 var1) {
         try {
            if (var1.field_780 instanceof ConfigManager_221 var3) {
               return var3.method_478();
            }
         } catch (Throwable var4) {
         }
      }

      return Collections.emptyList();
   }

   private static Class_400[] categories() {
      try {
         return Class_400.values();
      } catch (Throwable var1) {
         return new Class_400[0];
      }
   }

   private static String categoryName(Class_400 var0, int var1) {
      return "StarryDev";
   }

   private static String safe(String var0) {
      return var0 == null ? "" : var0;
   }

   private static void publishGuiData(String var0) {
      Class_225 var1 = currentGui();
      if (var1 != null) {
         var1.method_2054(0, categoryRows());
         var1.method_2055(moduleRows(var0));
      }
   }

   private static Class_225 currentGui() {
      if (ScreenUI_78.field_772 instanceof ScreenUI_78 var1) {
         Object var3 = var1.field_779;
         if (var3 instanceof Class_225) {
            return (Class_225)var3;
         }
      }

      return null;
   }

   public static void guard() {
   }

   public void applyConfig() {
      this.applyJson(this.field_73);
   }

   private void applyJson(JsonObject var1) {
      JsonObject var2 = object(var1, "modules");
      if (var2 != null) {
         for (Object var4 : modules()) {
            if (var4 instanceof Class_342) {
               Class_342 var5 = (Class_342)var4;
               String var6 = ConfigManager_221.moduleName(var5);
               JsonObject var7 = object(var2, var6);
               if (var7 == null) {
                  var7 = object(var2, var5.getClass().getName());
               }

               if (var7 != null) {
                  JsonElement var8 = var7.get("enabled");
                  if (var8 != null && var8.isJsonPrimitive() && var8.getAsJsonPrimitive().isBoolean()) {
                     ConfigManager_221.setModuleEnabled(var5, var8.getAsBoolean());
                  }

                  JsonElement var9 = var7.get("key");
                  if (var9 != null && var9.isJsonPrimitive() && var9.getAsJsonPrimitive().isNumber()) {
                     int var10 = var9.getAsInt();

                     try {
                        var5.method_1404(var10);
                     } catch (Throwable var12) {
                     }

                     var5.field_1517 = var10;
                  }

                  ConfigManager_221.ensureKeybindSetting(var5);
                  ConfigManager_221.syncKeybindSetting(var5);
                  JsonObject var13 = object(var7, "settings");
                  if (var13 != null) {
                     this.applySettings(var5, var13);
                  }
               }
            }
         }
      }
   }

   public void saveCurrent() {
      this.field_73 = this.method_82(false);
      this.saveToDisk();
   }

   private JsonObject moduleToJson(Class_342 var1, boolean var2) {
      ConfigManager_221.ensureKeybindSetting(var1);
      JsonObject var3 = new JsonObject();
      var3.addProperty("enabled", ConfigManager_221.moduleEnabled(var1));
      var3.addProperty("key", var1.field_1517);
      var3.addProperty("class", var1.getClass().getName());
      JsonObject var4 = new JsonObject();
      JsonArray var5 = new JsonArray();

      try {
         Iterator var6 = var1.method_1406().iterator();

         label40:
         while (true) {
            while (true) {
               if (!var6.hasNext()) {
                  break label40;
               }

               if (var6.next() instanceof Class_271 var8 && !isModuleKeybindSetting(var8)) {
                  if (var2) {
                     try {
                        if (!var8.method_923()) {
                           continue;
                        }
                     } catch (Throwable var11) {
                     }
                  }
                  break;
               }
            }

            JsonElement var9 = settingToJson(var8);
            var4.add(settingName(var8), var9);
            JsonObject var10 = new JsonObject();
            var10.addProperty("name", settingName(var8));
            var10.addProperty("field", var8.field_875);
            var10.addProperty("class", var8.getClass().getName());
            var10.add("value", var9);
            var5.add(var10);
         }
      } catch (Throwable var12) {
      }

      var3.add("settings", var4);
      var3.add("settingsList", var5);
      return var3;
   }

   private void applySettings(Class_342 var1, JsonObject var2) {
      JsonArray var3 = null;

      try {
         JsonObject var4 = this.findSavedModule(var1);
         JsonElement var5 = var4 == null ? null : var4.get("settingsList");
         if (var5 != null && var5.isJsonArray()) {
            var3 = var5.getAsJsonArray();
         }
      } catch (Throwable var9) {
      }

      try {
         int var11 = 0;

         for (Object var6 : var1.method_1406()) {
            if (var6 instanceof Class_271) {
               Class_271 var7 = (Class_271)var6;
               if (!isModuleKeybindSetting(var7)) {
                  JsonElement var8 = var2.get(settingName(var7));
                  if (var8 == null) {
                     var8 = var2.get(var7.field_875);
                  }

                  if (var8 == null) {
                     var8 = valueFromSettingsList(var3, var7, var11);
                  }

                  this.method_87(var7, var8, var1);
                  var11++;
               }
            }
         }
      } catch (Throwable var10) {
      }
   }

   private JsonObject findSavedModule(Class_342 var1) {
      JsonObject var2 = object(this.field_73, "modules");
      if (var2 != null && var1 != null) {
         String var3 = ConfigManager_221.moduleName(var1);
         JsonObject var4 = object(var2, var3);
         if (var4 == null) {
            var4 = object(var2, var1.getClass().getName());
         }

         return var4;
      } else {
         return null;
      }
   }

   private static JsonElement valueFromSettingsList(JsonArray var0, Class_271 var1, int var2) {
      if (var0 != null && var1 != null) {
         String var3 = settingName(var1);
         String var4 = var1.field_875;
         String var5 = var1.getClass().getName();
         Object var6 = null;
         if (var2 >= 0 && var2 < var0.size()) {
            JsonElement var7 = var0.get(var2);
            if (var7 != null && var7.isJsonObject()) {
               var6 = var7.getAsJsonObject();
               if (matchesSettingEntry((JsonObject)var6, var3, var4, var5)) {
                  return var6.get("value");
               }
            }
         }

         for (JsonElement var8 : var0) {
            if (var8 != null && var8.isJsonObject()) {
               JsonObject var9 = var8.getAsJsonObject();
               if (matchesSettingEntry(var9, var3, var4, var5)) {
                  return var9.get("value");
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static boolean matchesSettingEntry(JsonObject var0, String var1, String var2, String var3) {
      if (var0 == null) {
         return false;
      } else {
         String var4 = string(var0, "class");
         if (var4 != null && var3 != null && !var4.equals(var3)) {
            return false;
         } else {
            String var5 = string(var0, "name");
            String var6 = string(var0, "field");
            return var5 != null && var5.equals(var1) || var6 != null && var6.equals(var2);
         }
      }
   }

   private static String string(JsonObject var0, String var1) {
      JsonElement var2 = var0 == null ? null : var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString() ? var2.getAsString() : null;
   }

   private void saveProfile(String var1, boolean var2) {
      String var3 = normalizeProfileName(var1);
      this.configPath = this.configDir.resolve(var3 + ".json");
      this.field_73 = this.method_82(var2);
      this.saveToDisk();
   }

   private void loadProfileOrJson(String var1) {
      if (var1 != null && var1.trim().startsWith("{")) {
         try {
            JsonElement var4 = JsonParser.parseString(var1);
            if (var4 != null && var4.isJsonObject()) {
               this.field_73 = var4.getAsJsonObject();
               this.applyJson(this.field_73);
               this.saveToDisk();
            }
         } catch (Throwable var3) {
         }
      } else {
         String var2 = normalizeProfileName(var1);
         this.configPath = this.configDir.resolve(var2 + ".json");
         this.loadFromDisk();
         this.applyConfig();
      }
   }

   private void loadProfileByIndex(int var1) {
      Path var2 = this.profileByIndex(var1);
      if (var2 != null) {
         this.configPath = var2;
         this.loadFromDisk();
         this.applyConfig();
      }
   }

   private void saveProfileByIndex(int var1) {
      Path var2 = this.profileByIndex(var1);
      if (var2 != null) {
         this.configPath = var2;
      }

      this.saveCurrent();
   }

   private void deleteProfileByIndex(int var1) {
      Path var2 = this.profileByIndex(var1);
      if (var2 != null) {
         this.deleteProfile(var2.getFileName().toString().replaceFirst("\\.json$", ""));
      }
   }

   private void deleteProfile(String var1) {
      try {
         Files.deleteIfExists(this.configDir.resolve(normalizeProfileName(var1) + ".json"));
      } catch (Throwable var3) {
      }
   }

   private Path profileByIndex(int var1) {
      try {
         List var2 = this.listProfiles();
         if (var1 >= 0 && var1 < var2.size()) {
            return (Path)var2.get(var1);
         }
      } catch (Throwable var3) {
      }

      return null;
   }

   private List<Path> listProfiles() throws IOException {
      if (!Files.isDirectory(this.configDir)) {
         return Collections.emptyList();
      } else {
         List var2;
         try (Stream var1 = Files.list(this.configDir)) {
            var2 = var1.filter(var0 -> var0.getFileName().toString().endsWith(".json"))
               .sorted(Comparator.comparing(var0 -> var0.getFileName().toString()))
               .toList();
         }

         return var2;
      }
   }

   private void loadFromDisk() {
      try {
         if (!Files.isRegularFile(this.configPath)) {
            this.field_73 = new JsonObject();
            return;
         }

         try (BufferedReader var1 = Files.newBufferedReader(this.configPath, StandardCharsets.UTF_8)) {
            JsonElement var2 = JsonParser.parseReader(var1);
            this.field_73 = var2 != null && var2.isJsonObject() ? var2.getAsJsonObject() : new JsonObject();
         }
      } catch (Throwable var6) {
         this.field_73 = new JsonObject();
      }
   }

   private void saveToDisk() {
      try {
         Files.createDirectories(this.configPath.getParent());

         try (BufferedWriter var1 = Files.newBufferedWriter(this.configPath, StandardCharsets.UTF_8)) {
            var1.write(this.field_73 == null ? "{}" : this.field_73.toString());
         }

         Files.writeString(this.activeProfilePath, profileName(this.configPath), StandardCharsets.UTF_8);
      } catch (Throwable var6) {
      }
   }

   private Path readActiveConfigPath() {
      try {
         if (Files.isRegularFile(this.activeProfilePath)) {
            String var1 = Files.readString(this.activeProfilePath, StandardCharsets.UTF_8).trim();
            if (!var1.isBlank()) {
               return this.configDir.resolve(normalizeProfileName(var1) + ".json");
            }
         }
      } catch (Throwable var2) {
      }

      return this.configDir.resolve("default.json");
   }

   private static JsonObject object(JsonObject var0, String var1) {
      if (var0 != null && var1 != null) {
         JsonElement var2 = var0.get(var1);
         return var2 != null && var2.isJsonObject() ? var2.getAsJsonObject() : null;
      } else {
         return null;
      }
   }

   private static String settingName(Class_271 var0) {
      try {
         String var1 = var0.method_927();
         if (var1 != null && !var1.isBlank()) {
            return var1;
         }
      } catch (Throwable var3) {
      }

      try {
         if (var0.field_875 != null && !var0.field_875.isBlank()) {
            return var0.field_875;
         }
      } catch (Throwable var2) {
      }

      return var0.getClass().getName();
   }

   private static JsonElement settingToJson(Class_271 var0) {
      JsonElement var1 = pickerSettingToJson(var0);
      if (var1 != null) {
         return var1;
      } else {
         try {
            JsonElement var2 = var0.method_924();
            if (var2 != null) {
               return var2;
            }
         } catch (Throwable var3) {
         }

         return reflectiveSettingJson(var0);
      }
   }

   private static JsonElement pickerSettingToJson(Class_271 var0) {
      if (var0 == null) {
         return null;
      } else {
         String var1 = var0.getClass().getName();
         if ("efi".equals(var1) || "zv".equals(var1)) {
            return colorMapSettingToJson(var0, var1);
         } else {
            return !"lo".equals(var1) && !"pdf".equals(var1) && !"em".equals(var1) ? null : setSettingToJson(var0, var1);
         }
      }
   }

   private static JsonObject colorMapSettingToJson(Class_271 var0, String var1) {
      JsonObject var2 = new JsonObject();
      Map var3 = mapField(var0, "jky");
      Map var4 = mapField(var0, "ta");
      Map var5 = var3 != null ? var3 : var4;
      if (var5 == null) {
         return var2;
      } else {
         for (Entry var7 : var5.entrySet()) {
            String var8 = pickerId(var1, var7.getKey());
            if (var8 != null && !var8.isBlank()) {
               var2.add(var8, colorJson(var7.getValue()));
            }
         }

         return var2;
      }
   }

   private static JsonArray setSettingToJson(Class_271 var0, String var1) {
      JsonArray var2 = new JsonArray();
      Set var3 = setField(var0, "bm");
      Set var4 = setField(var0, "vngs");
      Set var5 = var3 != null ? var3 : var4;
      if (var5 == null) {
         return var2;
      } else {
         ArrayList var6 = new ArrayList();

         for (Object var8 : var5) {
            String var9 = pickerId(var1, var8);
            if (var9 != null && !var9.isBlank()) {
               var6.add(var9);
            }
         }

         Collections.sort(var6);

         for (String var11 : var6) {
            var2.add(var11);
         }

         return var2;
      }
   }

   private static Map<?, ?> mapField(Object var0, String var1) {
      try {
         return var0.getClass().getField(var1).get(var0) instanceof Map var3 ? var3 : null;
      } catch (Throwable var4) {
         return null;
      }
   }

   private static Set<?> setField(Object var0, String var1) {
      try {
         return var0.getClass().getField(var1).get(var0) instanceof Set var3 ? var3 : null;
      } catch (Throwable var4) {
         return null;
      }
   }

   private static String pickerId(String var0, Object var1) {
      if (var1 == null) {
         return null;
      } else {
         String var2 = switch (var0) {
            case "efi", "lo" -> "jnh";
            case "zv" -> "fbo";
            default -> null;
         };
         if (var2 != null) {
            try {
               Class var3 = Class.forName(var0, true, CryptoService_396.class.getClassLoader());

               for (Method var7 : var3.getMethods()) {
                  if (var7.getName().equals(var2) && var7.getParameterCount() == 1 && var7.getParameterTypes()[0].isAssignableFrom(var1.getClass())) {
                     Object var8 = var7.invoke(null, var1);
                     if (var8 != null) {
                        return var8.toString();
                     }
                  }
               }
            } catch (Throwable var9) {
            }
         }

         String var10 = var1.toString();
         int var12 = var10.indexOf(123);
         int var13 = var10.indexOf(125, var12 + 1);
         return var12 >= 0 && var13 > var12 ? var10.substring(var12 + 1, var13) : var10;
      }
   }

   private static JsonObject colorJson(Object var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("r", colorComponent(var0, "kfl", 255));
      var1.addProperty("g", colorComponent(var0, "smq", 255));
      var1.addProperty("b", colorComponent(var0, "gx", 255));
      var1.addProperty("a", colorComponent(var0, "qg", 255));
      return var1;
   }

   private static int colorComponent(Object var0, String var1, int var2) {
      if (var0 == null) {
         return var2;
      } else {
         try {
            return var0.getClass().getField(var1).getInt(var0);
         } catch (Throwable var4) {
            return var2;
         }
      }
   }

   private static void applySettingValue(Class_271 var0, JsonElement var1) {
      if (var0 != null && var1 != null && !var1.isJsonNull()) {
         String var2 = var0.getClass().getName();

         try {
            if (var1.isJsonPrimitive()) {
               JsonPrimitive var9 = var1.getAsJsonPrimitive();
               if (var9.isBoolean()) {
                  boolean var13 = var9.getAsBoolean();
                  if ("gr".equals(var2)) {
                     setBooleanField(var0, "mkk", var13);
                     setBooleanField(var0, "wbf", var13);
                  }

                  return;
               }

               if (var9.isNumber()) {
                  double var12 = var9.getAsDouble();
                  if ("dc".equals(var2)) {
                     setDoubleField(var0, "cyo", var12);
                     setDoubleField(var0, "hf", var12);
                  } else if ("hq".equals(var2)) {
                     int var6 = var9.getAsInt();
                     setIntField(var0, "pt", var6);
                     setIntField(var0, "upv", var6);
                  } else if ("to".equals(var2)) {
                     int var14 = var9.getAsInt();
                     setIntField(var0, "jkm", var14);
                     setIntField(var0, "dy", var14);
                  }

                  return;
               }

               if (var9.isString() && "kq".equals(var2)) {
                  String var11 = var9.getAsString();
                  setObjectField(var0, "wz", var11);
                  setObjectField(var0, "ko", var11);
               }

               return;
            }

            if (var1.isJsonObject()) {
               JsonObject var3 = var1.getAsJsonObject();
               if ("yl".equals(var2)) {
                  setIntField(var0, "zyv", intValue(var3, "x", -1));
                  setIntField(var0, "jcu", intValue(var3, "y", -1));
                  return;
               }

               if ("zf".equals(var2)) {
                  Object var10 = colorValue(var3);
                  if (var10 != null) {
                     setObjectField(var0, "v", var10);
                     setObjectField(var0, "u", var10);
                  }

                  if (var3.has("hue")) {
                     setDoubleField(var0, "dc", var3.get("hue").getAsDouble());
                  }

                  return;
               }
            }

            if (var1.isJsonArray() && "fpb".equals(var2)) {
               ArrayList var8 = new ArrayList();

               for (JsonElement var5 : var1.getAsJsonArray()) {
                  if (var5 != null && var5.isJsonPrimitive()) {
                     var8.add(var5.getAsString());
                  }
               }

               setObjectField(var0, "ud", var8);
            }
         } catch (Throwable var7) {
         }
      }
   }

   private static int intValue(JsonObject var0, String var1, int var2) {
      try {
         JsonElement var3 = var0.get(var1);
         return var3 == null ? var2 : var3.getAsInt();
      } catch (Throwable var4) {
         return var2;
      }
   }

   private static Object colorValue(JsonObject var0) {
      try {
         Class var1 = Class.forName("pw", true, CryptoService_396.class.getClassLoader());
         return var1.getConstructor(int.class, int.class, int.class, int.class)
            .newInstance(intValue(var0, "r", 255), intValue(var0, "g", 255), intValue(var0, "b", 255), intValue(var0, "a", 255));
      } catch (Throwable var2) {
         return null;
      }
   }

   private static void setBooleanField(Object var0, String var1, boolean var2) {
      try {
         Field var3 = var0.getClass().getField(var1);
         var3.setBoolean(var0, var2);
      } catch (Throwable var4) {
      }
   }

   private static void setIntField(Object var0, String var1, int var2) {
      try {
         Field var3 = var0.getClass().getField(var1);
         var3.setInt(var0, var2);
      } catch (Throwable var4) {
      }
   }

   private static void setDoubleField(Object var0, String var1, double var2) {
      try {
         Field var4 = var0.getClass().getField(var1);
         var4.setDouble(var0, var2);
      } catch (Throwable var5) {
      }
   }

   private static void setObjectField(Object var0, String var1, Object var2) {
      try {
         Field var3 = var0.getClass().getField(var1);
         var3.set(var0, var2);
      } catch (Throwable var4) {
      }
   }

   private static JsonElement reflectiveSettingJson(Class_271 var0) {
      JsonObject var1 = new JsonObject();

      try {
         for (Field var5 : var0.getClass().getFields()) {
            if (!Modifier.isStatic(var5.getModifiers())) {
               Class var6 = var5.getType();
               if (var6 == String.class) {
                  Object var7 = var5.get(var0);
                  if (var7 != null) {
                     var1.addProperty(var5.getName(), var7.toString());
                  }
               } else if (var6 == boolean.class || var6 == Boolean.class) {
                  var1.addProperty(var5.getName(), var5.getBoolean(var0));
               } else if (var6 == int.class || var6 == Integer.class) {
                  var1.addProperty(var5.getName(), var5.getInt(var0));
               } else if (var6 == long.class || var6 == Long.class) {
                  var1.addProperty(var5.getName(), var5.getLong(var0));
               } else if (var6 == float.class || var6 == Float.class || var6 == double.class || var6 == Double.class) {
                  var1.addProperty(var5.getName(), var5.getDouble(var0));
               }
            }
         }
      } catch (Throwable var8) {
      }

      return var1;
   }

   private static String normalizeProfileName(String var0) {
      String var1 = var0 != null && !var0.isBlank() ? var0.trim() : "default";
      var1 = var1.replace('\\', '_').replace('/', '_').replace(':', '_');
      var1 = var1.replaceAll("[^A-Za-z0-9._ -]", "_").trim();
      return var1.isBlank() ? "default" : var1;
   }

   private static String profileName(Path var0) {
      return var0 != null && var0.getFileName() != null ? var0.getFileName().toString().replaceFirst("\\.json$", "") : "default";
   }

   private static boolean isModuleKeybindSetting(Class_271 var0) {
      try {
         if (var0 instanceof Class_115 var1 && var1.method_1026()) {
            return true;
         }
      } catch (Throwable var3) {
      }

      try {
         String var4 = settingName(var0);
         return "Keybind".equalsIgnoreCase(var4);
      } catch (Throwable var2) {
         return false;
      }
   }
}
