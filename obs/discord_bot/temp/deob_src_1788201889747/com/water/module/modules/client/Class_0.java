/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.client;

import com.water.gui.ClickGuiScreen;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.client.Hud;
import com.water.module.modules.client.SpotifyHud;
import com.water.module.modules.client.WaterPlus;
import com.water.module.modules.donut.StaffDetector;
import com.water.setting.Setting;
import com.water.utils.renderer.Blur2DRenderer;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1296;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_640;
import net.minecraft.class_742;
import net.minecraft.class_7923;
import org.joml.Matrix4f;

public final class Class_0
extends Module {
    private static Hud field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Boolean> field_3;
    private final Setting<Boolean> field_4;
    private final Setting<Boolean> field_5;
    private final Setting<Boolean> field_6;
    private final Setting<Boolean> field_7;
    private final Setting<Boolean> field_8;
    private final Setting<Boolean> field_9;
    private final Setting<Boolean> field_10;
    private final Setting<Float> field_11;
    private final Setting<Boolean> field_12;
    private final Setting<Float> field_13;
    private final Setting<Integer> field_14;
    private final Setting<Integer> field_15;
    private final Setting<Boolean> field_16;
    private final Setting<Boolean> field_17;
    private final Setting<Boolean> field_18;
    private final Setting<Boolean> field_19;
    private final Setting<Float> field_20;
    private static Color field_21;
    private static long field_22;
    private static List<class_1297> field_23;
    private static long field_24;
    private static final EnumMap<Hud.a, int[]> field_25;
    private static final EnumMap<Hud.a, Float> field_26;
    private static final Map<class_2960, class_2960> field_27;
    private static final Set<class_2960> field_28;
    private static int field_29;

    public static int[] method_0(Hud.a a2) {
        return Hud.a.computeIfAbsent(a2, (Function<Hud.a, int[]>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, c(com.water.module.modules.client.Hud$a ), (Lcom/water/module/modules/client/Hud$a;)[I)());
    }

    public static void method_1(Hud.a a2, int n, int n2) {
        Hud.a.put(a2, new int[]{n, n2});
        ModuleManager.INSTANCE.c();
    }

    public static float method_2(Hud.a a2) {
        if (a2 == Hud.a.h) {
            return SpotifyHud.b();
        }
        return Hud.b.getOrDefault((Object)a2, Float.valueOf(1.0f)).floatValue();
    }

    public static void method_3(Hud.a a2, float f) {
        if (a2 == Hud.a.h) {
            SpotifyHud.a((float)Math.max(0.5f, Math.min(3.0f, f)));
        } else {
            Hud.b.put(a2, Float.valueOf(Math.max(0.5f, Math.min(3.0f, f))));
        }
        ModuleManager.INSTANCE.c();
    }

    public static int method_4(Hud.a a2) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return 100;
        }
        return switch (a2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> Hud.fw((String)"Water +") + 20;
            case 1 -> Hud.fw((String)"XYZ: -00000 / -256 / -00000") + 14;
            case 2 -> Hud.fw((String)"999 FPS  \u2022  999 ms  \u2022  23:59:59") + 14;
            case 3 -> 120;
            case 4 -> 110;
            case 5 -> Hud.fw((String)" 100%") + 22;
            case 6 -> 120;
            case 7 -> SpotifyHud.a();
            case 8 -> {
                if (Hud.a != null) {
                    yield (Integer)Hud.a.t.getValue();
                }
                yield 110;
            }
            case 9 -> 180;
            case 10 -> 168;
        };
    }

    public static int[] method_5(Hud.a a2) {
        int[] nArray;
        Object object = class_310.method_1551();
        if (object == null || ((class_310)object).field_1724 == null) {
            int[] nArray2 = Hud.a((Hud.a)a2);
            return new int[]{nArray2[0], nArray2[1], Hud.a((Hud.a)a2), 14};
        }
        int[] nArray3 = Hud.a((Hud.a)a2);
        switch (a2.ordinal()) {
            default: {
                throw new MatchException(null, null);
            }
            case 0: {
                int[] nArray4 = new int[4];
                nArray4[0] = nArray3[0];
                nArray4[1] = nArray3[1];
                nArray4[2] = Hud.fw((String)"WATER+") + 20;
                nArray = nArray4;
                nArray4[3] = 20;
                break;
            }
            case 1: {
                int[] nArray5 = new int[4];
                nArray5[0] = nArray3[0];
                nArray5[1] = nArray3[1];
                nArray5[2] = Hud.fw((String)String.format("%.0f X  %.0f Y  %.0f Z", ((class_310)object).field_1724.method_23317(), ((class_310)object).field_1724.method_23318(), ((class_310)object).field_1724.method_23321())) + 14;
                nArray = nArray5;
                nArray5[3] = 20;
                break;
            }
            case 2: {
                int[] nArray6 = new int[4];
                nArray6[0] = nArray3[0];
                nArray6[1] = nArray3[1];
                nArray6[2] = Hud.fw((String)(object.method_47599() + " FPS  \u2022  0 ms  \u2022  00:00:00")) + 14;
                nArray = nArray6;
                nArray6[3] = 20;
                break;
            }
            case 3: {
                nArray = Hud.a();
                break;
            }
            case 4: {
                object = new ArrayList(((class_310)object).field_1724.method_6026());
                if (object.isEmpty()) {
                    int[] nArray7 = new int[4];
                    nArray7[0] = nArray3[0];
                    nArray7[1] = nArray3[1];
                    nArray7[2] = Hud.a((Hud.a)a2);
                    nArray = nArray7;
                    nArray7[3] = 20;
                    break;
                }
                int n = 0;
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    class_1293 class_12932 = (class_1293)iterator.next();
                    int n2 = Hud.fw((String)Hud.a((class_1293)class_12932)) + 14;
                    if (n2 <= n) continue;
                    n = n2;
                }
                int[] nArray8 = new int[4];
                nArray8[0] = nArray3[0];
                nArray8[1] = nArray3[1];
                nArray8[2] = n;
                nArray = nArray8;
                nArray8[3] = object.size() * 22;
                break;
            }
            case 5: {
                int[] nArray9 = new int[4];
                nArray9[0] = nArray3[0];
                nArray9[1] = nArray3[1];
                nArray9[2] = 70;
                nArray = nArray9;
                nArray9[3] = 90;
                break;
            }
            case 6: {
                object = Hud.a();
                if (object.isEmpty()) {
                    int[] nArray10 = new int[4];
                    nArray10[0] = nArray3[0];
                    nArray10[1] = nArray3[1];
                    nArray10[2] = Hud.a((Hud.a)a2);
                    nArray = nArray10;
                    nArray10[3] = 20;
                    break;
                }
                int n = 0;
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    Module module = (Module)iterator.next();
                    int n3 = Hud.fw((String)(module.getName() + "  " + ClickGuiScreen.getKeyDisplayNameStatic(module.getBind()).toUpperCase())) + 14;
                    if (n3 <= n) continue;
                    n = n3;
                }
                int[] nArray11 = new int[4];
                nArray11[0] = nArray3[0];
                nArray11[1] = nArray3[1];
                nArray11[2] = n;
                nArray = nArray11;
                nArray11[3] = object.size() * 22 + 22;
                break;
            }
            case 7: {
                int[] nArray12 = new int[4];
                nArray12[0] = nArray3[0];
                nArray12[1] = nArray3[1];
                nArray12[2] = SpotifyHud.a();
                nArray = nArray12;
                nArray12[3] = SpotifyHud.b();
                break;
            }
            case 8: {
                int n = Hud.a != null ? (Integer)Hud.a.t.getValue() : 110;
                int[] nArray13 = new int[4];
                nArray13[0] = nArray3[0];
                nArray13[1] = nArray3[1];
                nArray13[2] = n;
                nArray = nArray13;
                nArray13[3] = n;
                break;
            }
            case 9: {
                int[] nArray14 = new int[4];
                nArray14[0] = nArray3[0];
                nArray14[1] = nArray3[1];
                nArray14[2] = 180;
                nArray = nArray14;
                nArray14[3] = 100;
                break;
            }
            case 10: {
                int[] nArray15 = new int[4];
                nArray15[0] = nArray3[0];
                nArray15[1] = nArray3[1];
                nArray15[2] = 168;
                nArray = nArray15;
                nArray15[3] = 200;
            }
        }
        return nArray;
    }

    private static List<Module> method_6() {
        ArrayList<Module> arrayList = new ArrayList<Module>();
        for (Module module : ModuleManager.INSTANCE.getModules()) {
            if (module.getBind() == 0) continue;
            arrayList.add(module);
        }
        arrayList.sort(Comparator.comparing(Module::getName));
        return arrayList;
    }

    public static boolean method_7(Hud.a a2) {
        if (Hud.a == null || !Hud.a.isEnabled()) {
            return false;
        }
        return switch (a2.ordinal()) {
            default -> throw new MatchException(null, null);
            case 0 -> (Boolean)Hud.a.g.getValue();
            case 1 -> (Boolean)Hud.a.h.getValue();
            case 2 -> (Boolean)Hud.a.i.getValue();
            case 3 -> (Boolean)Hud.a.j.getValue();
            case 4 -> (Boolean)Hud.a.k.getValue();
            case 5 -> (Boolean)Hud.a.l.getValue();
            case 6 -> (Boolean)Hud.a.m.getValue();
            case 7 -> SpotifyHud.isActive();
            case 8 -> (Boolean)Hud.a.o.getValue();
            case 9 -> true;
            case 10 -> true;
        };
    }

    private static int[] method_8(Hud.a a2) {
        int[] nArray;
        class_310 class_3102 = class_310.method_1551();
        int n = class_3102 != null ? class_3102.method_22683().method_4486() : 800;
        switch (a2.ordinal()) {
            default: {
                throw new MatchException(null, null);
            }
            case 0: {
                int[] nArray2 = new int[2];
                nArray2[0] = 5;
                nArray = nArray2;
                nArray2[1] = 5;
                break;
            }
            case 1: {
                int[] nArray3 = new int[2];
                nArray3[0] = 5;
                nArray = nArray3;
                nArray3[1] = 30;
                break;
            }
            case 2: {
                int[] nArray4 = new int[2];
                nArray4[0] = 5;
                nArray = nArray4;
                nArray4[1] = 55;
                break;
            }
            case 3: {
                int[] nArray5 = new int[2];
                nArray5[0] = n - 8;
                nArray = nArray5;
                nArray5[1] = 5;
                break;
            }
            case 4: {
                int[] nArray6 = new int[2];
                nArray6[0] = 5;
                nArray = nArray6;
                nArray6[1] = 80;
                break;
            }
            case 5: {
                int[] nArray7 = new int[2];
                nArray7[0] = n - 70;
                nArray = nArray7;
                nArray7[1] = 200;
                break;
            }
            case 6: {
                int[] nArray8 = new int[2];
                nArray8[0] = 5;
                nArray = nArray8;
                nArray8[1] = 130;
                break;
            }
            case 7: {
                int[] nArray9 = new int[2];
                nArray9[0] = 5;
                nArray = nArray9;
                nArray9[1] = 50;
                break;
            }
            case 8: {
                int[] nArray10 = new int[2];
                nArray10[0] = n - 125;
                nArray = nArray10;
                nArray10[1] = 10;
                break;
            }
            case 9: {
                int[] nArray11 = new int[2];
                nArray11[0] = n - 190;
                nArray = nArray11;
                nArray11[1] = 10;
                break;
            }
            case 10: {
                int[] nArray12 = new int[2];
                nArray12[0] = n - 180;
                nArray = nArray12;
                nArray12[1] = 200;
            }
        }
        return nArray;
    }

    public Class_0() {
        super("Hud", Category.e);
        this.g = new Setting<Boolean>("Watermark", true);
        this.h = new Setting<Boolean>("Coordinates", true);
        this.i = new Setting<Boolean>("Info", true);
        this.j = new Setting<Boolean>("Module List", true);
        this.k = new Setting<Boolean>("Potion Effects", true);
        this.l = new Setting<Boolean>("Armor", true);
        this.m = new Setting<Boolean>("Keybinds", true);
        this.n = new Setting<Boolean>("Notifications", true);
        this.o = new Setting<Boolean>("Radar", true);
        this.p = new Setting<Boolean>("Spotify Queue", true);
        this.q = new Setting<Float>("Opacity", Float.valueOf(0.8f), Float.valueOf(0.0f), Float.valueOf(1.0f));
        this.r = new Setting<Boolean>("Rainbow", false);
        this.s = new Setting<Float>("Rainbow Speed", Float.valueOf(2.0f), Float.valueOf(0.1f), Float.valueOf(10.0f));
        this.t = new Setting<Integer>("Radar Size", 110, 60, 200);
        this.u = new Setting<Integer>("Radar Range", 64, 16, 128);
        this.v = new Setting<Boolean>("Radar Players", true);
        this.w = new Setting<Boolean>("Radar Hostile", false);
        this.x = new Setting<Boolean>("Radar Passive", false);
        this.y = new Setting<Boolean>("Radar Rotate", true);
        this.z = new Setting<Float>("HUD Scale", Float.valueOf(1.0f), Float.valueOf(0.5f), Float.valueOf(3.0f));
        this.addSetting(this.g);
        this.addSetting(this.h);
        this.addSetting(this.i);
        this.addSetting(this.j);
        this.addSetting(this.k);
        this.addSetting(this.l);
        this.addSetting(this.m);
        this.addSetting(this.n);
        this.addSetting(this.q);
        this.addSetting(this.r);
        this.addSetting(this.s);
        this.addSetting(this.p);
        this.addSetting(this.o);
        this.addSetting(this.t);
        this.addSetting(this.u);
        this.addSetting(this.v);
        this.addSetting(this.w);
        this.addSetting(this.x);
        this.addSetting(this.y);
        this.addSetting(this.z);
        Hud.a = this;
    }

    public static boolean method_9() {
        return Hud.a != null && Hud.a.isEnabled() && (Boolean)Hud.a.p.getValue() != false;
    }

    public static float method_10() {
        return Hud.a == null ? 1.0f : ((Float)Hud.a.z.getValue()).floatValue();
    }

    /*
     * WARNING - void declaration
     */
    public static void method_11(class_332 class_3322) {
        List list;
        int n;
        ArrayList<class_1293> arrayList;
        int n2;
        int bl;
        int n3;
        Object object;
        int n4;
        Object f10;
        Object object4;
        if (Hud.a == null || !Hud.a.isEnabled()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1724 == null) {
            return;
        }
        if (class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        if (class_3102.method_53526().method_53536()) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l != Hud.c) {
            Hud.c = l;
            Hud.a = WaterPlus.getAccentColor();
            GuiRenderer.a((class_332)class_3322);
        }
        float f = ((Float)Hud.a.q.getValue()).floatValue();
        float f2 = WaterPlus.getGuiRoundness();
        int n6 = ((Boolean)Hud.a.r.getValue()).booleanValue();
        int n7 = ((Float)Hud.a.s.getValue()).intValue();
        Hud.a();
        String[] stringArray = WaterPlus.getBackgroundColor();
        stringArray = new Color(stringArray.getRed(), stringArray.getGreen(), stringArray.getBlue(), (int)(f * 255.0f));
        float f3 = Hud.b.getOrDefault((Object)Hud.a.a, Float.valueOf(1.0f)).floatValue();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(f3, f3);
        if (((Boolean)Hud.a.g.getValue()).booleanValue()) {
            int[] nArray = Hud.a((Hud.a)Hud.a.a);
            object4 = n6 != 0 ? Hud.a((int)n7, (int)0) : Hud.a;
            String object3 = "Water";
            f10 = "+";
            n4 = Hud.fw((String)object3);
            object = Hud.fw((String)f10);
            n3 = n4 + object + 16;
            Hud.a((class_332)class_3322, (Color)stringArray, (float)nArray[0], (float)nArray[1], (float)n3, (float)20.0f, (float)f2);
            Hud.ft((class_332)class_3322, (String)object3, (int)(nArray[0] + 7), (int)(nArray[1] + 5), (int)-1117449);
            Hud.ft((class_332)class_3322, (String)f10, (int)(nArray[0] + 7 + n4), (int)(nArray[1] + 5), (int)((Color)object4).getRGB());
        }
        class_3322.method_51448().popMatrix();
        f3 = Hud.b.getOrDefault((Object)Hud.a.b, Float.valueOf(1.0f)).floatValue();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(f3, f3);
        if (((Boolean)Hud.a.h.getValue()).booleanValue()) {
            int[] nArray = Hud.a((Hud.a)Hud.a.b);
            object4 = n6 != 0 ? Hud.a((int)n7, (int)0) : Hud.a;
            Color color = n6 != 0 ? Hud.a((int)n7, (int)40) : Hud.a((Color)Hud.a);
            f10 = n6 != 0 ? Hud.a((int)n7, (int)80) : Hud.a((Color)Hud.a);
            String string = String.format("%.0f", class_3102.field_1724.method_23317());
            String string2 = String.format("%.0f", class_3102.field_1724.method_23318());
            String string3 = String.format("%.0f", class_3102.field_1724.method_23321());
            bl = Hud.fw((String)string) + Hud.fw((String)"  X  ") + Hud.fw((String)string2) + Hud.fw((String)"  Y  ") + Hud.fw((String)string3) + Hud.fw((String)"  Z") + 16;
            Hud.a((class_332)class_3322, (Color)stringArray, (float)nArray[0], (float)nArray[1], (float)bl, (float)20.0f, (float)f2);
            int color2 = nArray[0] + 7;
            Hud.ft((class_332)class_3322, (String)string, (int)color2, (int)(nArray[1] + 5), (int)-1117449);
            Hud.ft((class_332)class_3322, (String)"  X", (int)(color2 += Hud.fw((String)string)), (int)(nArray[1] + 5), (int)((Color)object4).getRGB());
            Hud.ft((class_332)class_3322, (String)("  " + string2), (int)(color2 += Hud.fw((String)"  X")), (int)(nArray[1] + 5), (int)-1117449);
            Hud.ft((class_332)class_3322, (String)"  Y", (int)(color2 += Hud.fw((String)("  " + string2))), (int)(nArray[1] + 5), (int)color.getRGB());
            Hud.ft((class_332)class_3322, (String)("  " + string3), (int)(color2 += Hud.fw((String)"  Y")), (int)(nArray[1] + 5), (int)-1117449);
            Hud.ft((class_332)class_3322, (String)"  Z", (int)(color2 += Hud.fw((String)("  " + string3))), (int)(nArray[1] + 5), (int)((Color)f10).getRGB());
        }
        class_3322.method_51448().popMatrix();
        float f4 = Hud.b.getOrDefault((Object)Hud.a.c, Float.valueOf(1.0f)).floatValue();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(f4, f4);
        if (((Boolean)Hud.a.i.getValue()).booleanValue()) {
            int[] nArray = Hud.a((Hud.a)Hud.a.c);
            object4 = n6 != 0 ? Hud.a((int)n7, (int)0) : Hud.a;
            Color color = n6 != 0 ? Hud.a((int)n7, (int)40) : Hud.a((Color)Hud.a);
            int n5 = class_3102.method_47599();
            n4 = 0;
            try {
                class_640 class_6402;
                if (class_3102.method_1562() != null && (class_6402 = class_3102.method_1562().method_2871(class_3102.field_1724.method_5667())) != null) {
                    n4 = class_6402.method_2959();
                }
            }
            catch (Exception exception) {}
            String string = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String string4 = n5 + " FPS";
            String string5 = n4 + " ms";
            String string6 = "  \u2022  ";
            n2 = Hud.fw((String)string4) + Hud.fw((String)string6) + Hud.fw((String)string5) + Hud.fw((String)string6) + Hud.fw((String)string) + 16;
            Hud.a((class_332)class_3322, (Color)stringArray, (float)nArray[0], (float)nArray[1], (float)n2, (float)20.0f, (float)f2);
            n4 = nArray[0] + 7;
            Hud.ft((class_332)class_3322, (String)string4, (int)n4, (int)(nArray[1] + 5), (int)-1117449);
            Hud.ft((class_332)class_3322, (String)string6, (int)(n4 += Hud.fw((String)string4)), (int)(nArray[1] + 5), (int)((Color)object4).getRGB());
            Hud.ft((class_332)class_3322, (String)string5, (int)(n4 += Hud.fw((String)string6)), (int)(nArray[1] + 5), (int)-1117449);
            Hud.ft((class_332)class_3322, (String)string6, (int)(n4 += Hud.fw((String)string5)), (int)(nArray[1] + 5), (int)color.getRGB());
            Hud.ft((class_332)class_3322, (String)string, (int)(n4 += Hud.fw((String)string6)), (int)(nArray[1] + 5), (int)-5260086);
        }
        class_3322.method_51448().popMatrix();
        float f5 = Hud.b.getOrDefault((Object)Hud.a.e, Float.valueOf(1.0f)).floatValue();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(f5, f5);
        if (((Boolean)Hud.a.k.getValue()).booleanValue() && !(arrayList = new ArrayList<class_1293>(class_3102.field_1724.method_6026())).isEmpty()) {
            arrayList.sort(Comparator.comparingInt((ToIntFunction<class_1293>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)I, a(net.minecraft.class_1293 ), (Lnet/minecraft/class_1293;)I)()));
            object4 = Hud.a((Hud.a)Hud.a.e);
            Object n16 = object4[1];
            for (int i = 0; i < arrayList.size(); ++i) {
                void var11_49;
                class_1293 class_12932 = (class_1293)arrayList.get(i);
                String string = Hud.a((class_1293)class_12932);
                n3 = Hud.fw((String)string) + 16;
                ((class_1291)class_12932.method_5579().comp_349()).method_5556();
                if (n6 != 0) {
                    Hud.a((int)n7, (int)(i * 15));
                } else {
                    Hud.a((Color)Hud.a, (Color)Hud.a((Color)Hud.a), (float)((float)i / (float)Math.max(1, arrayList.size() - 1)));
                }
                Hud.a((class_332)class_3322, (Color)stringArray, (float)((float)object4[0]), (float)((float)var11_49), (float)n3, (float)20.0f, (float)f2);
                Hud.ft((class_332)class_3322, (String)string, (int)(object4[0] + 8), (int)(var11_49 + 5), (int)-5260086);
                var11_49 += 23;
            }
        }
        class_3322.method_51448().popMatrix();
        float f6 = Hud.b.getOrDefault((Object)Hud.a.f, Float.valueOf(1.0f)).floatValue();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(f6, f6);
        if (((Boolean)Hud.a.l.getValue()).booleanValue()) {
            int[] nArray = Hud.a((Hud.a)Hud.a.f);
            object4 = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};
            int n8 = nArray[1];
            class_1304[] class_1304Array = object4;
            int cfr_ignored_0 = class_1304Array.length;
            for (object = 0; object < 4; ++object) {
                void var11_51;
                int n9;
                class_1304 class_13042 = class_1304Array[object];
                class_1799 f25 = class_3102.field_1724.method_6118(class_13042);
                if (f25 == null || f25.method_7960()) continue;
                int n10 = n9 = f25.method_7963() && f25.method_7936() > 0 ? (int)Math.round((1.0 - (double)f25.method_7919() / (double)f25.method_7936()) * 100.0) : 100;
                Color n18 = n9 >= 66 ? new Color(74, 222, 128) : (n9 >= 33 ? new Color(250, 204, 21) : new Color(239, 68, 68));
                String string = n9 + "%";
                n = 16 + Hud.fw((String)string) + 8;
                Hud.a((class_332)class_3322, (Color)stringArray, (float)nArray[0], (float)((float)var11_51), (float)n, (float)18.0f, (float)f2);
                class_3322.method_51427(f25, nArray[0] + 4, (int)(var11_51 + true));
                Hud.ft((class_332)class_3322, (String)string, (int)(nArray[0] + 22), (int)(var11_51 + 5), (int)n18.getRGB());
                var11_51 += 21;
            }
        }
        class_3322.method_51448().popMatrix();
        float f7 = Hud.b.getOrDefault((Object)Hud.a.g, Float.valueOf(1.0f)).floatValue();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(f7, f7);
        if (((Boolean)Hud.a.m.getValue()).booleanValue() && !(list = Hud.a()).isEmpty()) {
            object4 = Hud.a((Hud.a)Hud.a.g);
            Color color = n6 != 0 ? Hud.a((int)n7, (int)0) : Hud.a;
            String string = "Hotkeys";
            n4 = Hud.fw((String)string) + 16;
            Hud.a((class_332)class_3322, (Color)stringArray, (float)((float)object4[0]), (float)((float)object4[1]), (float)n4, (float)20.0f, (float)f2);
            Hud.ft((class_332)class_3322, (String)string, (int)(object4[0] + 8), (int)(object4[1] + 5), (int)color.getRGB());
            object = object4[1] + 23;
            for (n3 = 0; n3 < list.size(); ++n3) {
                Module module = (Module)list.get(n3);
                String string7 = Hud.titleCase(module.getName());
                String string8 = ClickGuiScreen.getKeyDisplayNameStatic(module.getBind()).toUpperCase();
                Color color3 = n6 != 0 ? Hud.a((int)n7, (int)(n3 * 15)) : Hud.a((Color)Hud.a, (Color)Hud.a((Color)Hud.a), (float)((float)n3 / (float)Math.max(1, list.size() - 1)));
                n = Hud.fw((String)string7) + Hud.fw((String)"  ") + Hud.fw((String)string8) + 16;
                Hud.a((class_332)class_3322, (Color)stringArray, (float)((float)object4[0]), (float)object, (float)n, (float)18.0f, (float)f2);
                Hud.ft((class_332)class_3322, (String)string7, (int)(object4[0] + 8), (int)(object + 4), (int)-5260086);
                Hud.ft((class_332)class_3322, (String)string8, (int)(object4[0] + 8 + Hud.fw((String)string7) + Hud.fw((String)"  ")), (int)(object + 4), (int)color3.getRGB());
                object += 21;
            }
        }
        class_3322.method_51448().popMatrix();
        float f8 = Hud.b.getOrDefault((Object)Hud.a.d, Float.valueOf(1.0f)).floatValue();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(f8, f8);
        if (((Boolean)Hud.a.j.getValue()).booleanValue()) {
            int[] nArray = Hud.a((Hud.a)Hud.a.d);
            object4 = new ArrayList();
            for (Module module : ModuleManager.INSTANCE.getModules()) {
                if (!module.isEnabled() || module.getCategory() == Category.e) continue;
                object4.add(module);
            }
            if (!object4.isEmpty()) {
                int n13;
                object4.sort(Comparator.comparingInt((ToIntFunction<Module>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)I, a(com.water.module.Module ), (Lcom/water/module/Module;)I)()).reversed());
                String string = "Modules";
                bl = Hud.fw((String)string);
                Iterator iterator = object4.iterator();
                while (iterator.hasNext()) {
                    Module module = (Module)iterator.next();
                    bl = Math.max(bl, Hud.fw((String)Hud.titleCase(module.getName())));
                }
                int n11 = bl + 14 + 4;
                n2 = 21 + object4.size() * 12 + 5;
                n4 = nArray[0] - n11;
                n = nArray[1];
                for (n13 = 3; n13 >= 1; --n13) {
                    GuiRenderer.a((class_332)class_3322, (float)(n4 - n13), (float)(n - n13 + 1), (float)(n11 + n13 * 2), (float)(n2 + n13 * 2), (float)(f2 + (float)n13), (int)(10 - n13 * 2 << 24), (boolean)false);
                }
                if (WaterPlus.menuBlurEnabled()) {
                    Blur2DRenderer.bm();
                    GuiRenderer.a((class_332)class_3322, (float)n4, (float)n, (float)n11, (float)n2, (float)f2, (float)1.0f, (boolean)false);
                }
                GuiRenderer.a((class_332)class_3322, (float)n4, (float)n, (float)n11, (float)n2, (float)f2, (int)stringArray.getRGB(), (boolean)false);
                GuiRenderer.a((class_332)class_3322, (float)(n4 + 1), (float)(n + 1), (float)(n11 - 2), (float)18.0f, (float)f2, (int)0x10FFFFFF, (boolean)false);
                GuiRenderer.a((class_332)class_3322, (float)n4, (float)n, (float)n11, (float)n2, (float)f2, (float)1.0f, (int)0x2AFFFFFF, (boolean)false);
                Hud.ft((class_332)class_3322, (String)string, (int)(n4 + 7), (int)(n + 5), (int)-1);
                GuiRenderer.a((class_332)class_3322, (float)n4, (float)(n + 18), (float)n11, (float)3.0f, (float)0.5f, (int)0x14000000, (boolean)false);
                n13 = n + 18 + 3 + 2;
                for (int i = 0; i < object4.size(); ++i) {
                    stringArray = n6 != 0 ? Hud.a((int)n7, (int)(i * 15)) : Hud.a;
                    Hud.ft((class_332)class_3322, (String)Hud.titleCase(((Module)object4.get(i)).getName()), (int)(n4 + 7), (int)n13, (int)(0xBF000000 | stringArray.getRGB() & 0xFFFFFF));
                    n13 += 12;
                }
            }
        }
        class_3322.method_51448().popMatrix();
        float f9 = Hud.b.getOrDefault((Object)Hud.a.i, Float.valueOf(1.0f)).floatValue();
        class_3322.method_51448().pushMatrix();
        class_3322.method_51448().scale(f9, f9);
        if (((Boolean)Hud.a.o.getValue()).booleanValue() && class_3102.field_1687 != null) {
            int[] nArray = Hud.a((Hud.a)Hud.a.i);
            int n15 = (Integer)Hud.a.t.getValue();
            int n12 = (Integer)Hud.a.u.getValue();
            float f11 = (float)n15 / 2.0f;
            float f12 = (float)nArray[0] + f11;
            float f13 = (float)nArray[1] + f11;
            float f14 = (Boolean)Hud.a.y.getValue() != false ? class_3102.field_1724.method_36454() : 0.0f;
            float f15 = f11 * 0.55f;
            Color color = n6 != 0 ? Hud.a((int)n7, (int)0) : Hud.a;
            Color color4 = Hud.a;
            n = (int)(f * 180.0f) << 24 | color4.getRed() << 16 | color4.getGreen() << 8 | color4.getBlue();
            GuiRenderer.a((class_332)class_3322, (float)nArray[0], (float)nArray[1], (float)n15, (float)n15, (float)((float)n15 / 2.0f), (int)-871756784, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)(f12 - f15), (float)(f13 - f15), (float)(f15 * 2.0f), (float)(f15 * 2.0f), (float)f15, (int)0x18FFFFFF, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)nArray[0], (float)nArray[1], (float)n15, (float)n15, (float)((float)n15 / 2.0f), (float)1.5f, (int)n, (boolean)false);
            GuiRenderer.b((class_332)class_3322, (float)(f12 - 3.0f), (float)(f13 - 3.0f), (float)6.0f, (float)6.0f, (float)360.0f, (float)0.0f, (int)-1996488705, (boolean)false);
            GuiRenderer.b((class_332)class_3322, (float)(f12 - 1.5f), (float)(f13 - 1.5f), (float)3.0f, (float)3.0f, (float)360.0f, (float)0.0f, (int)-1, (boolean)false);
            class_327 class_3272 = class_3102.field_1772;
            stringArray = new String[]{"N", "E", "S", "W"};
            float[] fArray = new float[]{180.0f, 270.0f, 0.0f, 90.0f};
            for (n6 = 0; n6 < 4; ++n6) {
                float f152 = fArray[n6] - f14;
                float f16 = (float)Math.toRadians(f152 - 90.0f);
                float f17 = (float)((double)f12 + (double)(f11 - 8.0f) * Math.cos(f16));
                f16 = (float)((double)f13 + (double)(f11 - 8.0f) * Math.sin(f16));
                int n13 = n6 == 0 ? -1 : -1997606153;
                class_3322.method_51433(class_3272, stringArray[n6], (int)(f17 - (float)class_3272.method_1727(stringArray[n6]) / 2.0f), (int)(f16 - 4.0f), n13, false);
            }
            n6 = 0xFF000000 | color4.getRed() << 16 | color4.getGreen() << 8 | color4.getBlue();
            GuiRenderer.b((class_332)class_3322, (float)(f12 - 4.0f), (float)(f13 - 4.0f), (float)8.0f, (float)8.0f, (float)360.0f, (float)0.0f, (int)n6, (boolean)false);
            GuiRenderer.b((class_332)class_3322, (float)(f12 - 2.0f), (float)(f13 - 2.0f), (float)4.0f, (float)4.0f, (float)360.0f, (float)0.0f, (int)-1, (boolean)false);
            float f18 = (f11 - 8.0f) / (float)n12;
            if (l - Hud.d >= 100L) {
                Hud.d = l;
                Hud.b = new ArrayList(class_3102.field_1687.method_8390(class_1297.class, class_3102.field_1724.method_5829().method_1009((double)n12, (double)n12, (double)n12), (Predicate<class_1297>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(net.minecraft.class_310 net.minecraft.class_1297 ), (Lnet/minecraft/class_1297;)Z)((class_310)class_3102)));
            }
            List list222 = Hud.b;
            for (List list222 : list222) {
                double d2;
                double d3;
                boolean bl2 = list222 instanceof class_1657;
                boolean bl22 = list222 instanceof class_1588;
                boolean bl3 = list222 instanceof class_1296;
                if (bl2 && !((Boolean)Hud.a.v.getValue()).booleanValue() || bl22 && !((Boolean)Hud.a.w.getValue()).booleanValue() || bl3 && !((Boolean)Hud.a.x.getValue()).booleanValue() || !bl2 && !bl22 && !bl3 || Math.sqrt((d3 = list222.method_23317() - class_3102.field_1724.method_23317()) * d3 + (d2 = list222.method_23321() - class_3102.field_1724.method_23321()) * d2) > (double)n12) continue;
                float f19 = (float)Math.toRadians(-f14);
                float f20 = (float)Math.cos(f19);
                f19 = (float)Math.sin(f19);
                float f21 = (float)d3;
                float f16 = (float)d2;
                float f17 = f21 * f20 - f16 * f19;
                f19 = -(f21 * f19 + f16 * f20);
                f20 = f12 + f17 * f18;
                f21 = (float)Math.sqrt((f20 - f12) * (f20 - f12) + ((f19 = f13 + f19 * f18) - f13) * (f19 - f13));
                if (f21 > f11 - 4.0f) {
                    f21 = (f11 - 4.0f) / f21;
                    f20 = f12 + (f20 - f12) * f21;
                    f19 = f13 + (f19 - f13) * f21;
                }
                if (bl2) {
                    float f24 = f20 - 9.0f / 2.0f;
                    f19 -= 9.0f / 2.0f;
                    boolean bl4 = false;
                    StaffDetector staffDetector = (StaffDetector)ModuleManager.INSTANCE.getModuleByName("Staff Detector");
                    if (staffDetector != null && staffDetector.isEnabled()) {
                        bl4 = staffDetector.a().containsKey(((class_1657)list222).method_5477().getString());
                    }
                    staffDetector = (class_742)list222;
                    list222 = null;
                    try {
                        staffDetector = staffDetector.method_52814();
                        for (Method method : staffDetector.getClass().getMethods()) {
                            Object object2;
                            if (method.getParameterCount() != 0) continue;
                            method.setAccessible(true);
                            try {
                                object2 = method.invoke((Object)staffDetector, new Object[0]);
                            }
                            catch (Exception exception) {
                                continue;
                            }
                            if (object2 == null) continue;
                            if (object2 instanceof class_2960) {
                                list222 = (class_2960)object2;
                                break;
                            }
                            try {
                                for (Method method2 : object2.getClass().getMethods()) {
                                    if (method2.getParameterCount() != 0 || method2.getReturnType() != class_2960.class) continue;
                                    method2.setAccessible(true);
                                    list222 = (class_2960)method2.invoke(object2, new Object[0]);
                                    if (list222 == null) {
                                        continue;
                                    }
                                    break;
                                }
                            }
                            catch (Exception exception) {}
                            if (list222 == null) {
                                continue;
                            }
                            break;
                        }
                    }
                    catch (Exception exception) {}
                    staffDetector = Hud.a((class_2960)list222);
                    if (staffDetector != null) {
                        GuiRenderer.a((class_332)class_3322, (float)(f24 - 1.0f), (float)(f19 - 1.0f), (float)11.0f, (float)11.0f, (float)3.5f, (int)-16118768, (boolean)false);
                        GuiRenderer.a((class_332)class_3322, (float)f24, (float)f19, (float)9.0f, (class_2960)staffDetector, (int)-1, (float)0.0f, (boolean)false);
                        GuiRenderer.a((class_332)class_3322, (float)(f24 - 1.0f), (float)(f19 - 1.0f), (float)11.0f, (float)11.0f, (float)3.5f, (float)1.0f, (int)(0xFF000000 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue()), (boolean)false);
                    } else {
                        GuiRenderer.a((class_332)class_3322, (float)f24, (float)f19, (float)9.0f, (float)9.0f, (float)2.5f, (int)(0xFF000000 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue()), (boolean)false);
                    }
                    if (!bl4) continue;
                    float f22 = (float)(0.5 + 0.5 * Math.sin((double)l / 250.0));
                    int n14 = (int)(f22 * 150.0f);
                    GuiRenderer.a((class_332)class_3322, (float)(f24 - 2.0f), (float)(f19 - 2.0f), (float)13.0f, (float)13.0f, (float)2.0f, (int)(n14 << 24 | 0xFF2222), (boolean)false);
                    continue;
                }
                GuiRenderer.b((class_332)class_3322, (float)(f20 - 2.0f), (float)(f19 - 2.0f), (float)4.0f, (float)4.0f, (float)360.0f, (float)0.0f, (int)(bl22 ? -50116 : -11477936), (boolean)false);
            }
            GuiRenderer.b((class_332)class_3322, (float)(f12 - 2.5f), (float)(f13 - 2.5f), (float)5.0f, (float)5.0f, (float)360.0f, (float)0.0f, (int)-1, (boolean)false);
            class_3322.method_25294((int)(f12 - 1.0f), (int)(f13 - 6.0f), (int)(f12 + 1.0f), (int)(f13 - 2.0f), -1);
        }
        class_3322.method_51448().popMatrix();
        StaffDetector.a((class_332)class_3322);
    }

    private static Color method_12(int n, int n2) {
        return Color.getHSBColor((float)((System.currentTimeMillis() * 3L + (long)n2 * 175L) % 7200L) / 7200.0f * (float)n % 1.0f, 0.6f, 1.0f);
    }

    private static Color method_13(Color color) {
        return new Color(Math.max(0, (int)((float)color.getRed() * 0.6f)), Math.max(0, (int)((float)color.getGreen() * 0.6f)), Math.max(0, (int)((float)color.getBlue() * 0.6f)), 255);
    }

    private static Color method_14(Color color, Color color2, float f) {
        f = Math.max(0.0f, Math.min(1.0f, f));
        return new Color((int)((float)color.getRed() + (float)(color2.getRed() - color.getRed()) * f), (int)((float)color.getGreen() + (float)(color2.getGreen() - color.getGreen()) * f), (int)((float)color.getBlue() + (float)(color2.getBlue() - color.getBlue()) * f), 255);
    }

    private static void method_15(class_332 class_3322, Color color, float f, float f2, float f3, float f4, float f5) {
        for (int i = 3; i >= 1; --i) {
            GuiRenderer.a((class_332)class_3322, (float)(f - (float)i), (float)(f2 - (float)i + 1.0f), (float)(f3 + (float)(i * 2)), (float)(f4 + (float)(i * 2)), (float)(f5 + (float)i), (int)(10 - i * 2 << 24), (boolean)false);
        }
        if (WaterPlus.menuBlurEnabled()) {
            Blur2DRenderer.bm();
            GuiRenderer.a((class_332)class_3322, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)1.0f, (boolean)false);
        }
        GuiRenderer.a((class_332)class_3322, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (int)color.getRGB(), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(f + 1.0f), (float)(f2 + 1.0f), (float)(f3 - 2.0f), (float)Math.min(f4 - 2.0f, 10.0f), (float)f5, (int)0xEFFFFFF, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)1.0f, (int)0x2AFFFFFF, (boolean)false);
    }

    private static void method_16(class_332 class_3322, String string, int n, int n2, int n3) {
        WaterFontRenderer.INSTANCE.a(class_3322, string, n, n2, n3);
    }

    private static int method_17(String string) {
        return WaterFontRenderer.INSTANCE.a(string);
    }

    private static String titleCase(String object) {
        if (object == null || ((String)object).isEmpty()) {
            return object == null ? "" : object;
        }
        StringBuilder stringBuilder = new StringBuilder(((String)object).length());
        boolean bl = true;
        for (Object object2 : (Object)((String)object).toCharArray()) {
            if (Character.isLetter((char)object2)) {
                stringBuilder.append(bl ? Character.toUpperCase((char)object2) : Character.toLowerCase((char)object2));
                bl = false;
                continue;
            }
            stringBuilder.append((char)object2);
            bl = object2 == 32 || object2 == 95 || object2 == 45;
        }
        return stringBuilder.toString();
    }

    /*
     * WARNING - void declaration
     */
    public static String method_18(class_1293 class_12932) {
        void var1_8;
        int n;
        String object = class_7923.field_41174.method_10221((Object)((class_1291)class_12932.method_5579().comp_349())).method_12832();
        String[] stringArray = object.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            if (string.isEmpty()) continue;
            stringBuilder.append(Character.toUpperCase(string.charAt(0)));
            if (string.length() > 1) {
                stringBuilder.append(string.substring(1));
            }
            stringBuilder.append(' ');
        }
        String string = stringBuilder.toString().trim();
        int n2 = class_12932.method_5578();
        if (n2 > 0) {
            String string2 = string + " " + Hud.b((int)(n2 + 1));
        }
        if ((n = class_12932.method_5584()) < Short.MAX_VALUE) {
            void var1_6;
            int n3 = n / 20;
            String string3 = (String)var1_6 + " " + String.format("%d:%02d", n3 / 60, n3 % 60);
        }
        return var1_8;
    }

    private static String method_19(int n) {
        return switch (n) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            case 10 -> "X";
            default -> String.valueOf(n);
        };
    }

    public static int[] method_20() {
        Object object = class_310.method_1551();
        if (object == null) {
            return new int[]{0, 0, 120, 14};
        }
        object = Hud.a((Hud.a)Hud.a.d);
        ArrayList<Module> arrayList = new ArrayList<Module>();
        for (Module object2 : ModuleManager.INSTANCE.getModules()) {
            if (!object2.isEnabled() || object2.getCategory() == Category.e) continue;
            arrayList.add(object2);
        }
        if (arrayList.isEmpty()) {
            return new int[]{(int)(object[0] - 80), (int)object[1], 80, 26};
        }
        int n = Hud.fw((String)"Modules");
        for (Module n3 : arrayList) {
            n = Math.max(n, Hud.fw((String)Hud.titleCase(n3.getName())));
        }
        int n2 = n + 14 + 4;
        int n3 = 21 + arrayList.size() * 12 + 5;
        return new int[]{(int)(object[0] - n2), (int)object[1], n2, n3};
    }

    private static String method_21(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nArray) {
            stringBuilder.append((char)(n ^ 0x6E));
        }
        return stringBuilder.toString();
    }

    public static class_2960 method_22(class_2960 class_29602) {
        if (class_29602 == null) {
            return null;
        }
        class_2960 class_29603 = (class_2960)Hud.a.get(class_29602);
        if (class_29603 != null) {
            return class_29603;
        }
        if (Hud.a.contains(class_29602)) {
            return null;
        }
        class_29603 = class_310.method_1551();
        class_1044 class_10442 = class_29603.method_1531().method_4619(class_29602);
        if (class_10442 == null) {
            return null;
        }
        Hud.a.add(class_29602);
        class_29603.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(net.minecraft.class_310 net.minecraft.class_2960 ), ()V)((class_310)class_29603, (class_2960)class_29602));
        return null;
    }

    private static /* synthetic */ void method_23(class_310 class_3102, class_2960 class_29602) {
        try {
            int n;
            Object object;
            class_1044 class_10442 = class_3102.method_1531().method_4619(class_29602);
            if (class_10442 == null) {
                Hud.a.remove(class_29602);
                return;
            }
            class_1011 class_10112 = null;
            if (class_10442 instanceof class_1043) {
                object = (Field[])class_10442;
                class_10112 = object.method_4525();
            }
            if (class_10112 == null) {
                object = class_10442.getClass().getDeclaredFields();
                int n2 = ((Field[])object).length;
                for (n = 0; n < n2; ++n) {
                    Object object2 = object[n];
                    if (!((Field)object2).getType().getSimpleName().equals("NativeImage")) continue;
                    ((Field)object2).setAccessible(true);
                    try {
                        class_10112 = (class_1011)((Field)object2).get(class_10442);
                    }
                    catch (Exception exception) {}
                    if (class_10112 != null) break;
                }
            }
            if (class_10112 == null) {
                block7: for (object = class_10442.getClass().getSuperclass(); object != null && class_10112 == null; object = ((Class)object).getSuperclass()) {
                    for (Field field : ((Class)object).getDeclaredFields()) {
                        if (!field.getType().getSimpleName().equals("NativeImage")) continue;
                        field.setAccessible(true);
                        try {
                            class_10112 = (class_1011)field.get(class_10442);
                        }
                        catch (Exception exception) {}
                        if (class_10112 != null) continue block7;
                    }
                }
            }
            if (class_10112 == null) {
                Hud.a.remove(class_29602);
                return;
            }
            class_1011 class_10113 = new class_1011(16, 16, false);
            n = class_10112.method_4307();
            int n3 = class_10112.method_4323();
            for (int i = 0; i < 16; ++i) {
                for (int j = 0; j < 16; ++j) {
                    int n4 = 8 + j * 8 / 16;
                    int n5 = 8 + i * 8 / 16;
                    if (n4 >= n || n5 >= n3) continue;
                    class_10113.method_61941(j, i, class_10112.method_61940(n4, n5));
                }
            }
            class_2960 class_29603 = class_2960.method_60655((String)"water", (String)("player_head_" + Hud.c++));
            class_3102.method_1531().method_4616(class_29603, (class_1044)new class_1043((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, c(), ()Ljava/lang/String;)(), class_10113));
            Hud.a.put(class_29602, class_29603);
            Hud.a.remove(class_29602);
        }
        catch (Exception exception) {
            Hud.a.remove(class_29602);
        }
    }

    private static /* synthetic */ String method_24() {
        return "ph";
    }

    private static /* synthetic */ boolean method_25(class_310 class_3102, class_1297 class_12972) {
        return class_12972 != class_3102.field_1724;
    }

    private static /* synthetic */ int method_26(Module module) {
        return Hud.fw((String)Hud.titleCase(module.getName()));
    }

    private static /* synthetic */ int method_27(class_1293 class_12932) {
        return Hud.fw((String)Hud.a((class_1293)class_12932));
    }

    static {
        new Color(65, 185, 255, 255);
        Hud.a = new Color(65, 185, 255);
        new Matrix4f();
        Hud.c = 0L;
        Hud.b = new ArrayList();
        Hud.d = 0L;
        Hud.a = new EnumMap(Hud.a.class);
        Hud.b = new EnumMap(Hud.a.class);
        try {
            GenericDeclaration genericDeclaration = Class.forName(Hud._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28}));
            Object obj = ((Class)genericDeclaration).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(Hud._d((int[])new int[]{24, 15, 2, 7, 10, 15, 26, 11}), new Class[0]);
            if (!((Boolean)((Method)genericDeclaration).invoke(obj, new Object[0])).booleanValue()) {
                throw new ExceptionInInitializerError(Hud._d((int[])new int[]{15, 27, 26, 6}));
            }
        }
        catch (ExceptionInInitializerError exceptionInInitializerError) {
            throw exceptionInInitializerError;
        }
        catch (Exception exception) {}
        Hud.a = new ConcurrentHashMap();
        Hud.a = Collections.newSetFromMap(new ConcurrentHashMap());
        Hud.c = 0;
    }
}

