/*
 * Decompiled with CFR 0.152.
 */
package com.water.module;

import com.water.module.ActivatableModule;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.NamedModule;
import com.water.module.modules.client.ConfigShare;
import com.water.module.modules.client.DiscordRPC;
import com.water.module.modules.client.Friends;
import com.water.module.modules.client.Hud;
import com.water.module.modules.client.SpotifyHud;
import com.water.module.modules.client.WaterPlus;
import com.water.module.modules.combat.AnchorMacro;
import com.water.module.modules.combat.AutoCrystal;
import com.water.module.modules.combat.AutoDoubleHand;
import com.water.module.modules.combat.AutoInventoryTotem;
import com.water.module.modules.combat.AutoTotem;
import com.water.module.modules.combat.DoubleAnchor;
import com.water.module.modules.combat.Hitbox;
import com.water.module.modules.combat.HoverTotem;
import com.water.module.modules.combat.ShieldBreaker;
import com.water.module.modules.combat.SingleAnchor;
import com.water.module.modules.combat.SpearSwap;
import com.water.module.modules.combat.Triggerbot;
import com.water.module.modules.donut.ActivityDebug;
import com.water.module.modules.donut.AntiTrap;
import com.water.module.modules.donut.AutoChunkLoader;
import com.water.module.modules.donut.BoneDropper;
import com.water.module.modules.donut.FakeRoles;
import com.water.module.modules.donut.FakeStats;
import com.water.module.modules.donut.SpawnerProtect;
import com.water.module.modules.donut.StaffDetector;
import com.water.module.modules.donut.SuspiciousChunkFinder;
import com.water.module.modules.donut.TuffChunkV2;
import com.water.module.modules.misc.AutoLog;
import com.water.module.modules.misc.AutoMine;
import com.water.module.modules.misc.AutoRender;
import com.water.module.modules.misc.AutoTPA;
import com.water.module.modules.misc.AutoTool;
import com.water.module.modules.misc.ChatMacro;
import com.water.module.modules.misc.CoordinateSnapper;
import com.water.module.modules.misc.FastPlace;
import com.water.module.modules.misc.Freelook;
import com.water.module.modules.misc.HomeSetter;
import com.water.module.modules.misc.NameProtect;
import com.water.module.modules.misc.NameTags;
import com.water.module.modules.misc.PearlESP;
import com.water.module.modules.misc.SkinChanger;
import com.water.module.modules.misc.Sprint;
import com.water.module.modules.misc.SwingSpeed;
import com.water.module.modules.misc.TabDetector;
import com.water.module.modules.misc.TunnelBaseFinder;
import com.water.module.modules.misc.WeatherNotifier;
import com.water.module.modules.render.BlockESP;
import com.water.module.modules.render.ExtraESP;
import com.water.module.modules.render.Freecam;
import com.water.module.modules.render.FullBright;
import com.water.module.modules.render.FutureDebug;
import com.water.module.modules.render.HoleESP;
import com.water.module.modules.render.JumpCircles;
import com.water.module.modules.render.LightDebug;
import com.water.module.modules.render.NoRender;
import com.water.module.modules.render.PlayerESP;
import com.water.module.modules.render.RegionMap;
import com.water.module.modules.render.SpawnerNotifier;
import com.water.module.modules.render.StorageESP;
import com.water.setting.BlocksSetting;
import com.water.setting.MobsSetting;
import com.water.setting.MultiItemSetting;
import com.water.setting.Setting;
import com.water.setting.ToggleableIntegerSetting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1299;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2596;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_7923;

public class ModuleManager {
    private String field_0;
    public static final ModuleManager INSTANCE = new ModuleManager();
    private final List<Module> field_1;
    private boolean field_2;
    private boolean field_3;
    private int field_4;
    private boolean field_5;

    public ModuleManager() {
        this.b = "default";
        this.a = new ArrayList();
        this.b = false;
        this.c = false;
        this.b = 0;
        this.d = false;
    }

    public void method_0() {
        if (this.b) {
            return;
        }
        this.a.add(new WaterPlus());
        this.a.add(new Hud());
        this.a.add(new SpotifyHud());
        this.a.add(new Friends());
        this.a.add(new ConfigShare());
        this.a.add(new NamedModule("Elytra Swap", Category.a));
        this.a.add(new AutoTotem());
        this.a.add(new ShieldBreaker());
        this.a.add(new AnchorMacro());
        this.a.add(new NamedModule("Mace Swap", Category.a));
        this.a.add(new Triggerbot());
        this.a.add(new HoverTotem());
        this.a.add(new DoubleAnchor());
        this.a.add(new SingleAnchor());
        this.a.add(new AutoDoubleHand());
        this.a.add(new AutoInventoryTotem());
        this.a.add(new AutoCrystal());
        this.a.add(new Hitbox());
        this.a.add(new SpearSwap());
        this.a.add(new DiscordRPC());
        this.a.add(new StorageESP());
        this.a.add(new ExtraESP());
        this.a.add(new Freecam());
        this.a.add(new FullBright());
        this.a.add(new PlayerESP());
        this.a.add(new HoleESP());
        this.a.add(new NoRender());
        this.a.add(new JumpCircles());
        this.a.add(new LightDebug());
        this.a.add(new AutoRender());
        this.a.add(new SpawnerNotifier());
        this.a.add(new FutureDebug());
        this.a.add(new SuspiciousChunkFinder());
        this.a.add(new TuffChunkV2());
        this.a.add(new AutoMine());
        this.a.add(new PearlESP());
        this.a.add(new SwingSpeed());
        this.a.add(new NameTags());
        this.a.add(new RegionMap());
        this.a.add(new AutoTool());
        this.a.add(new Sprint());
        this.a.add(new NameProtect());
        this.a.add(new Freelook());
        this.a.add(new SkinChanger());
        this.a.add(new HomeSetter());
        this.a.add(new WeatherNotifier());
        this.a.add(new CoordinateSnapper());
        this.a.add(new FastPlace());
        this.a.add(new TabDetector());
        this.a.add(new AutoLog());
        this.a.add(new AutoTPA());
        this.a.add(new TunnelBaseFinder());
        this.a.add(new ChatMacro());
        this.a.add(new AutoChunkLoader());
        this.a.add(new StaffDetector());
        this.a.add(new FakeRoles());
        this.a.add(new AntiTrap());
        this.a.add(new ActivityDebug());
        this.a.add(new SpawnerProtect());
        this.a.add(new FakeStats());
        this.a.add(new BoneDropper());
        this.b = true;
        this.g();
        this.h();
    }

    public void method_1() {
        if (!this.b || this.c) {
            return;
        }
        if (this.b > 0) {
            this.d = true;
            return;
        }
        this.f();
    }

    public void method_2() {
        ++this.b;
    }

    public void method_3() {
        if (this.b > 0) {
            --this.b;
        }
        if (this.b == 0 && this.d) {
            this.d = false;
            this.f();
        }
    }

    /*
     * WARNING - void declaration
     */
    public void method_4() {
        if (!this.b || this.c) {
            return;
        }
        Path path = this.b();
        Path path2 = path.resolveSibling(path.getFileName().toString() + ".tmp");
        try {
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path2, StandardCharsets.UTF_8, new OpenOption[0]);){
                void object42;
                Object object2;
                bufferedWriter.write("WATER_CONFIG_V2");
                bufferedWriter.newLine();
                for (Module module : this.a) {
                    int n;
                    bufferedWriter.write("MODULE");
                    bufferedWriter.write(9);
                    bufferedWriter.write(this.a(module.getName()));
                    bufferedWriter.write(9);
                    bufferedWriter.write(Integer.toString(module.getBind()));
                    bufferedWriter.write(9);
                    if (module instanceof ActivatableModule) {
                        ActivatableModule activatableModule = (ActivatableModule)module;
                        n = activatableModule.getActivationKey();
                    } else {
                        n = 0;
                    }
                    int n2 = n;
                    bufferedWriter.write(Integer.toString(n2));
                    bufferedWriter.write(9);
                    bufferedWriter.write(Boolean.toString(module.isEnabled()));
                    bufferedWriter.newLine();
                    for (Object object2 : module.getSettings()) {
                        String string = this.a((Setting)object2);
                        if (string == null) continue;
                        bufferedWriter.write("SETTING");
                        bufferedWriter.write(9);
                        bufferedWriter.write(this.a(module.getName()));
                        bufferedWriter.write(9);
                        bufferedWriter.write(this.a(((Setting)object2).getName()));
                        bufferedWriter.write(9);
                        bufferedWriter.write(this.a(string));
                        bufferedWriter.newLine();
                    }
                }
                Hud.a[] aArray = Hud.a.values();
                int n = aArray.length;
                boolean object3 = false;
                while (object42 < n) {
                    Hud.a a2 = aArray[object42];
                    object2 = Hud.a((Hud.a)a2);
                    bufferedWriter.write("HUDPOS");
                    bufferedWriter.write(9);
                    bufferedWriter.write(a2.name());
                    bufferedWriter.write(9);
                    bufferedWriter.write(Integer.toString(object2[0]));
                    bufferedWriter.write(9);
                    bufferedWriter.write(Integer.toString((int)object2[1]));
                    bufferedWriter.newLine();
                    ++object42;
                }
                for (Module module : this.a) {
                    if (!(module instanceof BlockESP)) continue;
                    BlockESP object52 = (BlockESP)module;
                    Map map = object52.b();
                    object2 = map.entrySet().iterator();
                    while (object2.hasNext()) {
                        Map.Entry entry = (Map.Entry)object2.next();
                        module = class_7923.field_41175.method_10221((Object)((class_2248)entry.getKey()));
                        if (module == null) continue;
                        Color color = (Color)entry.getValue();
                        bufferedWriter.write("BLOCKCOLOR");
                        bufferedWriter.write(9);
                        bufferedWriter.write(this.a(module.toString()));
                        bufferedWriter.write(9);
                        bufferedWriter.write(color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getAlpha());
                        bufferedWriter.newLine();
                    }
                }
                for (Module module : this.a) {
                    if (!(module instanceof StorageESP)) continue;
                    StorageESP storageESP = (StorageESP)module;
                    Map map = storageESP.d();
                    for (Map.Entry entry : map.entrySet()) {
                        module = class_7923.field_41175.method_10221((Object)((class_2248)entry.getKey()));
                        if (module == null) continue;
                        Color color = (Color)entry.getValue();
                        bufferedWriter.write("STORAGECOLOR");
                        bufferedWriter.write(9);
                        bufferedWriter.write(this.a(module.toString()));
                        bufferedWriter.write(9);
                        bufferedWriter.write(color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getAlpha());
                        bufferedWriter.newLine();
                    }
                }
                for (Module module : this.a) {
                    if (!(module instanceof ExtraESP)) continue;
                    ExtraESP extraESP = (ExtraESP)module;
                    Map map = extraESP.b();
                    for (Map.Entry entry : map.entrySet()) {
                        module = class_7923.field_41175.method_10221((Object)((class_2248)entry.getKey()));
                        if (module == null) continue;
                        Color color = (Color)entry.getValue();
                        bufferedWriter.write("EXTRACOLOR");
                        bufferedWriter.write(9);
                        bufferedWriter.write(this.a(module.toString()));
                        bufferedWriter.write(9);
                        bufferedWriter.write(color.getRed() + "," + color.getGreen() + "," + color.getBlue() + "," + color.getAlpha());
                        bufferedWriter.newLine();
                    }
                }
            }
            try {
                Files.move(path2, path, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            }
            catch (IOException iOException) {
                Files.move(path2, path, StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (Throwable throwable) {
            System.err.println("[WaterConfig] save failed: " + throwable.getMessage());
            try {
                Files.deleteIfExists(path2);
            }
            catch (IOException iOException) {}
        }
    }

    public void method_5() {
        Object object = this.b();
        if (!Files.exists((Path)object, new LinkOption[0])) {
            return;
        }
        this.c = true;
        try {
            object = Files.readAllLines((Path)object, StandardCharsets.UTF_8);
            object = object.iterator();
            while (object.hasNext()) {
                String string = (String)object.next();
                if (string == null || string.isBlank() || "WATER_CONFIG_V2".equals(string)) continue;
                if (string.startsWith("MODULE\t")) {
                    this.f(string);
                    continue;
                }
                if (string.startsWith("SETTING\t")) {
                    this.g(string);
                    continue;
                }
                if (string.startsWith("HUDPOS\t")) {
                    this.a(string);
                    continue;
                }
                if (string.startsWith("BLOCKCOLOR\t")) {
                    this.b(string);
                    continue;
                }
                if (string.startsWith("STORAGECOLOR\t")) {
                    this.c(string);
                    continue;
                }
                if (string.startsWith("EXTRACOLOR\t")) {
                    this.d(string);
                    continue;
                }
                this.h(string);
            }
        }
        catch (Throwable throwable) {
            System.err.println("[WaterConfig] load failed: " + throwable.getMessage());
        }
        finally {
            this.c = false;
        }
    }

    private void method_6() {
        for (Module module : this.a) {
            if (module == null || !module.isEnabled()) continue;
            try {
                module.onEnable();
            }
            catch (Throwable throwable) {
                this.a(module);
            }
        }
    }

    private void method_7(String stringArray) {
        try {
            stringArray = stringArray.split("\t");
            if (stringArray.length < 4) {
                return;
            }
            Hud.a a2 = Hud.a.valueOf(stringArray[1]);
            int n = Integer.parseInt(stringArray[2]);
            int n2 = Integer.parseInt(stringArray[3]);
            Hud.a((Hud.a)a2, (int)n, (int)n2);
        }
        catch (Exception exception) {}
    }

    private void method_8(String stringArray) {
        try {
            stringArray = stringArray.split("\t");
            if (stringArray.length < 3) {
                return;
            }
            String string = this.b(stringArray[1]);
            if ((stringArray = stringArray[2].split(",")).length < 4) {
                return;
            }
            int n = Integer.parseInt(stringArray[0].trim());
            int n2 = Integer.parseInt(stringArray[1].trim());
            int n3 = Integer.parseInt(stringArray[2].trim());
            int n4 = Integer.parseInt(stringArray[3].trim());
            if ((string = class_2960.method_12829((String)string)) == null) {
                return;
            }
            if ((string = (class_2248)class_7923.field_41175.method_63535((class_2960)string)) == null || string == class_2246.field_10124) {
                return;
            }
            for (Module module : this.a) {
                if (!(module instanceof BlockESP)) continue;
                module = (BlockESP)module;
                Map map = module.b();
                map.put(string, new Color(n, n2, n3, n4));
                module.a(map);
            }
        }
        catch (Exception exception) {}
    }

    private void method_9(String stringArray) {
        try {
            stringArray = stringArray.split("\t");
            if (stringArray.length < 3) {
                return;
            }
            String string = this.b(stringArray[1]);
            if ((stringArray = stringArray[2].split(",")).length < 4) {
                return;
            }
            int n = Integer.parseInt(stringArray[0].trim());
            int n2 = Integer.parseInt(stringArray[1].trim());
            int n3 = Integer.parseInt(stringArray[2].trim());
            int n4 = Integer.parseInt(stringArray[3].trim());
            if ((string = class_2960.method_12829((String)string)) == null) {
                return;
            }
            if ((string = (class_2248)class_7923.field_41175.method_63535((class_2960)string)) == null || string == class_2246.field_10124) {
                return;
            }
            for (Module module : this.a) {
                if (!(module instanceof StorageESP)) continue;
                module = (StorageESP)module;
                module.a((class_2248)string, new Color(n, n2, n3, n4));
            }
        }
        catch (Exception exception) {}
    }

    private void method_10(String stringArray) {
        try {
            stringArray = stringArray.split("\t");
            if (stringArray.length < 3) {
                return;
            }
            String string = this.b(stringArray[1]);
            if ((stringArray = stringArray[2].split(",")).length < 4) {
                return;
            }
            int n = Integer.parseInt(stringArray[0].trim());
            int n2 = Integer.parseInt(stringArray[1].trim());
            int n3 = Integer.parseInt(stringArray[2].trim());
            int n4 = Integer.parseInt(stringArray[3].trim());
            if ((string = class_2960.method_12829((String)string)) == null) {
                return;
            }
            if ((string = (class_2248)class_7923.field_41175.method_63535((class_2960)string)) == null || string == class_2246.field_10124) {
                return;
            }
            for (Module module : this.a) {
                if (!(module instanceof ExtraESP)) continue;
                module = (ExtraESP)module;
                Map map = module.b();
                map.put(string, new Color(n, n2, n3, n4));
                module.a(map);
            }
        }
        catch (Exception exception) {}
    }

    public String method_11() {
        return this.b;
    }

    public void method_12(String string) {
        this.b = string == null || string.isBlank() ? "default" : string.trim();
    }

    public List<Module> getModules() {
        return this.a;
    }

    public List<Module> getModulesInCategory(Category category) {
        ArrayList<Module> arrayList = new ArrayList<Module>();
        for (Module module : this.a) {
            try {
                if (module == null || module.getCategory() != category) continue;
                arrayList.add(module);
            }
            catch (Throwable throwable) {}
        }
        return arrayList;
    }

    public Module getModuleByName(String string) {
        if (string == null || string.isBlank()) {
            return null;
        }
        if (string.equalsIgnoreCase("Tuff Chunk Finder")) {
            string = "Tuff Chunk V2";
        }
        for (Module module : this.a) {
            if (module == null) continue;
            try {
                String string2 = module.getName();
                if (string2 == null || !string2.equalsIgnoreCase(string)) continue;
                return module;
            }
            catch (Throwable throwable) {
            }
        }
        return null;
    }

    public Path method_13() {
        return this.b();
    }

    public boolean method_14(Path path) {
        if (path == null || !Files.isRegularFile(path, new LinkOption[0])) {
            return false;
        }
        Path path2 = this.b();
        try {
            Files.createDirectories(path2.getParent(), new FileAttribute[0]);
            Files.copy(path, path2, StandardCopyOption.REPLACE_EXISTING);
            this.g();
            return true;
        }
        catch (Throwable throwable) {
            System.err.println("[WaterConfig] apply failed: " + throwable.getMessage());
            return false;
        }
    }

    public void onTick() {
        for (Module module : this.a) {
            if (!module.isEnabled()) continue;
            try {
                module.onTick();
            }
            catch (Throwable throwable) {
                this.a(module);
            }
        }
    }

    public void onRender(class_4587 class_45872, float f) {
        for (Module module : this.a) {
            if (!module.isEnabled() || module instanceof ExtraESP || module instanceof StorageESP) continue;
            try {
                module.onRender(class_45872, f);
            }
            catch (Throwable throwable) {
                this.a(module);
            }
            finally {
                RenderUtils.restoreWorldDepthState();
            }
        }
        this.a(ExtraESP.class, class_45872, f);
        this.a(StorageESP.class, class_45872, f);
        RenderUtils.restoreWorldDepthState();
    }

    private void method_15(Class<? extends Module> clazz, class_4587 class_45872, float f) {
        for (Module module : this.a) {
            if (!module.isEnabled() || !clazz.isInstance(module)) continue;
            try {
                module.onRender(class_45872, f);
            }
            catch (Throwable throwable) {
                this.a(module);
            }
            finally {
                RenderUtils.restoreWorldDepthState();
            }
        }
    }

    private void method_16(Module module) {
        try {
            module.applyEnabled(false);
            module.onDisable();
            this.f();
        }
        catch (Throwable throwable) {}
    }

    public void onPacketReceive(class_2596<?> class_25962) {
        for (Module module : this.a) {
            if (!module.isEnabled()) continue;
            module.onPacketReceive(class_25962);
        }
    }

    public boolean onPacketSend(class_2596<?> class_25962) {
        boolean bl = false;
        for (Module module : this.a) {
            if (!module.isEnabled()) continue;
            try {
                bl |= module.onPacketSend(class_25962);
            }
            catch (Exception exception) {}
        }
        return bl;
    }

    private Path method_17() {
        String string = this.b == null || this.b.isBlank() ? "default" : this.b;
        string = string.equals("default") ? "water_config.txt" : "water_config_" + string + ".txt";
        return class_310.method_1551().field_1697.toPath().resolve(string);
    }

    private void method_18(String stringArray) {
        if ((stringArray = stringArray.split("\t", 5)).length < 5) {
            return;
        }
        Module module = this.getModuleByName(this.b(stringArray[1]));
        if (module == null) {
            return;
        }
        try {
            module.applyBind(Integer.parseInt(stringArray[2]));
            if (module instanceof ActivatableModule) {
                ActivatableModule activatableModule = (ActivatableModule)module;
                activatableModule.a(Integer.parseInt(stringArray[3]));
            }
            module.applyEnabled(Boolean.parseBoolean(stringArray[4]));
        }
        catch (Exception exception) {}
    }

    private void method_19(String stringArray) {
        if ((stringArray = stringArray.split("\t", 4)).length < 4) {
            return;
        }
        Object object = this.getModuleByName(this.b(stringArray[1]));
        if (object == null) {
            return;
        }
        if ((object = this.a((Module)object, this.b(stringArray[2]))) == null) {
            return;
        }
        this.a((Setting)object, this.b(stringArray[3]));
    }

    private void method_20(String stringArray) {
        if ((stringArray = stringArray.split(":", 4)).length < 2) {
            return;
        }
        Module module = this.getModuleByName(stringArray[0]);
        if (module == null) {
            return;
        }
        try {
            if (stringArray.length >= 2) {
                module.applyBind(Integer.parseInt(stringArray[1]));
            }
            if (stringArray.length >= 3 && module instanceof ActivatableModule) {
                ActivatableModule activatableModule = (ActivatableModule)module;
                activatableModule.a(Integer.parseInt(stringArray[2]));
            }
            if (stringArray.length >= 4) {
                module.applyEnabled(Boolean.parseBoolean(stringArray[3]));
            }
        }
        catch (Exception exception) {}
    }

    private Setting<?> method_21(Module object, String string) {
        for (Setting<?> setting : ((Module)((Object)object)).getSettings()) {
            if (!setting.matchesName(string)) continue;
            return setting;
        }
        return null;
    }

    private String method_22(Setting<?> object) {
        Object obj = ((Setting)object).getValue();
        if (object instanceof BlocksSetting) {
            object = (BlocksSetting)object;
            return this.a((BlocksSetting)object);
        }
        if (object instanceof MobsSetting) {
            object = (MobsSetting)object;
            return this.a((MobsSetting)object);
        }
        if (object instanceof MultiItemSetting) {
            object = (MultiItemSetting)object;
            return this.a((Set)((Setting)object).getValue());
        }
        if (object instanceof ToggleableIntegerSetting) {
            object = (ToggleableIntegerSetting)object;
            return object.q();
        }
        if (obj instanceof Boolean) {
            object = (Boolean)obj;
            return Boolean.toString((Boolean)object);
        }
        if (obj instanceof Float) {
            object = (Float)obj;
            return Float.toString(((Float)object).floatValue());
        }
        if (obj instanceof Integer) {
            object = (Integer)obj;
            return Integer.toString((Integer)object);
        }
        if (obj instanceof Double) {
            object = (Double)obj;
            return Double.toString((Double)object);
        }
        if (obj instanceof String) {
            object = (String)obj;
            return object;
        }
        if (obj instanceof Color) {
            object = (Color)obj;
            return ((Color)object).getRed() + "," + ((Color)object).getGreen() + "," + ((Color)object).getBlue() + "," + ((Color)object).getAlpha();
        }
        return null;
    }

    private void method_23(Setting<?> setting, String string) {
        Object object = setting.getValue();
        try {
            if (setting instanceof BlocksSetting) {
                object = (BlocksSetting)setting;
                ((BlocksSetting)object).setValue(this.a(string));
                return;
            }
            if (setting instanceof MobsSetting) {
                object = (MobsSetting)setting;
                ((MobsSetting)object).setValue(this.b(string));
                return;
            }
            if (setting instanceof MultiItemSetting) {
                object = (MultiItemSetting)setting;
                ((MultiItemSetting)object).setValue(this.c(string));
                return;
            }
            if (setting instanceof ToggleableIntegerSetting) {
                object = (ToggleableIntegerSetting)setting;
                object.u(string);
                return;
            }
            if (object instanceof Boolean) {
                setting.setValue(Boolean.parseBoolean(string));
                return;
            }
            if (object instanceof Float) {
                setting.setValue(Float.valueOf(Float.parseFloat(string)));
                return;
            }
            if (object instanceof Integer) {
                setting.setValue(Math.round(Float.parseFloat(string)));
                return;
            }
            if (object instanceof Double) {
                setting.setValue(Double.parseDouble(string));
                return;
            }
            if (object instanceof String) {
                setting.setValue(string);
                return;
            }
            if (object instanceof Color && (object = this.a(string, (Color)object)) != null) {
                setting.setValue(object);
            }
        }
        catch (Exception exception) {}
    }

    private Color method_24(String string, Color color) {
        if (string == null) {
            return color;
        }
        if ((string = string.trim()).isEmpty()) {
            return color;
        }
        try {
            String[] stringArray;
            if (string.startsWith("#")) {
                stringArray = string.substring(1).trim();
                long l = Long.parseLong((String)stringArray, 16);
                if (stringArray.length() == 6) {
                    return new Color((int)(l >> 16 & 0xFFL), (int)(l >> 8 & 0xFFL), (int)(l & 0xFFL), color == null ? 255 : color.getAlpha());
                }
                if (stringArray.length() == 8) {
                    return new Color((int)(l >> 16 & 0xFFL), (int)(l >> 8 & 0xFFL), (int)(l & 0xFFL), (int)(l >> 24 & 0xFFL));
                }
            }
            if (string.startsWith("java.awt.Color")) {
                string = string.replace("java.awt.Color", "").replace("[", "").replace("]", "").replace("r=", "").replace("g=", "").replace("b=", "").replace("a=", "");
            }
            if ((stringArray = string.split(",")).length >= 3) {
                int n = this.a(Integer.parseInt(stringArray[0].trim()));
                int n2 = this.a(Integer.parseInt(stringArray[1].trim()));
                int n3 = this.a(Integer.parseInt(stringArray[2].trim()));
                int n4 = stringArray.length >= 4 ? this.a(Integer.parseInt(stringArray[3].trim())) : (color == null ? 255 : color.getAlpha());
                return new Color(n, n2, n3, n4);
            }
        }
        catch (Exception exception) {}
        return color;
    }

    private int method_25(int n) {
        return Math.max(0, Math.min(255, n));
    }

    private String method_26(BlocksSetting object) {
        StringBuilder stringBuilder = new StringBuilder();
        for (class_2248 class_22482 : ((BlocksSetting)object).getSelectedBlocks()) {
            if ((class_22482 = class_7923.field_41175.method_10221((Object)class_22482)) == null) continue;
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(',');
            }
            stringBuilder.append(class_22482);
        }
        return stringBuilder.toString();
    }

    private Set<class_2248> method_27(String stringArray) {
        LinkedHashSet<class_2248> linkedHashSet = new LinkedHashSet<class_2248>();
        if (stringArray == null || stringArray.isBlank()) {
            return linkedHashSet;
        }
        for (String string : stringArray.split(",")) {
            if ((string = string.trim()).isEmpty() || (string = class_2960.method_12829((String)string)) == null || (string = (class_2248)class_7923.field_41175.method_63535((class_2960)string)) == null) continue;
            linkedHashSet.add((class_2248)string);
        }
        return linkedHashSet;
    }

    private String method_28(MobsSetting object) {
        StringBuilder stringBuilder = new StringBuilder();
        for (class_1299<?> class_12992 : ((MobsSetting)((Object)object)).getSelectedMobs()) {
            class_2960 class_129922 = class_7923.field_41177.method_10221(class_12992);
            if (class_129922 == null) continue;
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(',');
            }
            stringBuilder.append(class_129922);
        }
        return stringBuilder.toString();
    }

    private Set<class_1299<?>> method_29(String stringArray) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (stringArray == null || stringArray.isBlank()) {
            return linkedHashSet;
        }
        for (String string : stringArray.split(",")) {
            if ((string = string.trim()).isEmpty() || (string = class_2960.method_12829((String)string)) == null || !class_7923.field_41177.method_10250((class_2960)string)) continue;
            linkedHashSet.add((class_1299)class_7923.field_41177.method_63535((class_2960)string));
        }
        return linkedHashSet;
    }

    private String method_30(Set<String> object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            if (string == null || string.isEmpty()) continue;
            if (!stringBuilder.isEmpty()) {
                stringBuilder.append(',');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    private Set<String> method_31(String stringArray) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        if (stringArray == null || stringArray.isBlank()) {
            return linkedHashSet;
        }
        for (String string : stringArray.split(",")) {
            if ((string = string.trim()).isEmpty()) continue;
            linkedHashSet.add(string);
        }
        return linkedHashSet;
    }

    private String method_32(String string) {
        return Base64.getEncoder().encodeToString(string.getBytes(StandardCharsets.UTF_8));
    }

    private String method_33(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        try {
            return new String(Base64.getDecoder().decode(string), StandardCharsets.UTF_8);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return string;
        }
    }
}

