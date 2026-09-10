/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.Hud;
import com.water.setting.Setting;
import com.water.utils.renderer.GuiRenderer;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3417;
import net.minecraft.class_742;

public final class StaffDetector
extends Module {
    private final Setting<Boolean> field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Boolean> field_3;
    private static final List<String> field_4;
    private static final Set<String> field_5;
    private final Map<String, String> field_6;
    private final Set<String> field_7;
    private final Map<String, class_2960> field_8;
    private int field_9;
    private static StaffDetector field_10;

    public StaffDetector() {
        super("Staff Detector", Category.d);
        this.J = new Setting<Boolean>("Chat Alert", true);
        this.K = new Setting<Boolean>("HUD", true);
        this.L = new Setting<Boolean>("By Name", true);
        this.M = new Setting<Boolean>("By Rank Tag", true);
        this.g = new LinkedHashMap();
        this.g = new HashSet();
        this.h = new LinkedHashMap();
        this.k = 0;
        this.addSetting(this.J);
        this.addSetting(this.K);
        this.addSetting(this.L);
        this.addSetting(this.M);
        a = this;
    }

    @Override
    public void onEnable() {
        this.g.clear();
        this.g.clear();
        this.h.clear();
        this.k = 0;
    }

    @Override
    public void onDisable() {
        this.g.clear();
        this.g.clear();
        this.h.clear();
    }

    @Override
    public void onTick() {
        if (StaffDetector.mc.field_1687 == null || StaffDetector.mc.field_1724 == null) {
            return;
        }
        if (++this.k % 20 != 0) {
            return;
        }
        if (mc.method_1562() == null) {
            return;
        }
        HashSet<String> hashSet = new HashSet<String>();
        for (Object object : mc.method_1562().method_2880()) {
            Object object2;
            String string = object.method_2966().name();
            Object object3 = object2 = object.method_2971() != null ? object.method_2971().getString() : string;
            if (object.method_2955() != null) {
                object2 = object.method_2955().method_1144().getString() + string + object.method_2955().method_1136().getString();
            }
            if ((object = this.a(string, (String)object2)) == null) continue;
            hashSet.add(string);
            this.g.put(string, object);
            if (!this.h.containsKey(string) && StaffDetector.mc.field_1687 != null) {
                object2 = StaffDetector.mc.field_1687.method_18456().iterator();
                while (object2.hasNext()) {
                    class_742 class_7422 = (class_742)object2.next();
                    if (!class_7422.method_5477().getString().equalsIgnoreCase(string) || !(class_7422 instanceof class_742)) continue;
                    object2 = class_7422;
                    if ((object2 = StaffDetector.a((class_742)object2)) == null) break;
                    this.h.put(string, object2);
                    break;
                }
            }
            if (this.g.contains(string)) continue;
            this.g.add(string);
            if (((Boolean)this.J.getValue()).booleanValue() && StaffDetector.mc.field_1724 != null) {
                StaffDetector.mc.field_1724.method_7353((class_2561)class_2561.method_43470((String)("\u00a78[\u00a7cStaff Detector\u00a78] \u00a7c\u26a0 \u00a7f" + string + " \u00a77(" + (String)object + ")")), false);
            }
            StaffDetector.mc.field_1724.method_5783(class_3417.field_14627, 1.0f, 0.5f);
        }
        this.g.keySet().retainAll(hashSet);
        this.h.keySet().retainAll(hashSet);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static class_2960 method_0(class_742 class_7422) {
        int n;
        int n2;
        Method[] methodArray;
        try {
            class_7422 = class_7422.method_52814();
            methodArray = class_7422.getClass().getMethods();
            n2 = methodArray.length;
            n = 0;
        }
        catch (Exception exception) {}
        return null;
        while (n < n2) {
            block11: {
                Method method = methodArray[n];
                if (method.getParameterCount() == 0) {
                    Object object;
                    method.setAccessible(true);
                    try {
                        object = method.invoke((Object)class_7422, new Object[0]);
                    }
                    catch (Exception exception) {
                        break block11;
                    }
                    if (object != null) {
                        if (object instanceof class_2960) {
                            return (Method[])object;
                        }
                        try {
                            for (Method method2 : object.getClass().getMethods()) {
                                if (method2.getParameterCount() != 0 || method2.getReturnType() != class_2960.class) continue;
                                method2.setAccessible(true);
                                method2 = (class_2960)method2.invoke(object, new Object[0]);
                                if (method2 == null) continue;
                                return method2;
                            }
                        }
                        catch (Exception exception) {}
                    }
                }
            }
            ++n;
        }
        return null;
    }

    public static void method_1(class_332 class_3322) {
        int n;
        if (a == null || !a.isEnabled()) {
            return;
        }
        if (!((Boolean)StaffDetector.a.K.getValue()).booleanValue()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1724 == null) {
            return;
        }
        Map map = StaffDetector.a.g;
        int n2 = map.isEmpty();
        int[] nArray = Hud.a((Hud.a)Hud.a.j);
        int n3 = nArray[0];
        int n4 = nArray[1];
        if (n2 != 0) {
            GuiRenderer.a((class_332)class_3322, (float)n3, (float)n4, (float)145.0f, (float)49.0f, (float)6.0f, (int)-870108853, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)(n3 - 1), (float)(n4 - 1), (float)147.0f, (float)51.0f, (float)7.0f, (int)1080002264, (boolean)false);
            int n5 = n4 + 8;
            class_3322.method_51433(class_3102.field_1772, "STAFF ONLINE", n3 + 10, n5, -920065, false);
            String string = "0";
            int n6 = class_3102.field_1772.method_1727(string) + 8;
            int object = n3 + 145 - 10 - n6;
            n2 = n5 - 1;
            GuiRenderer.a((class_332)class_3322, (float)object, (float)n2, (float)n6, (float)12.0f, (float)6.0f, (int)-11567141, (boolean)false);
            class_3322.method_51433(class_3102.field_1772, string, object + n6 / 2 - class_3102.field_1772.method_1727(string) / 2, n2 + 2, -1, false);
            int n7 = n5 + 14 + 2;
            GuiRenderer.a((class_332)class_3322, (float)(n3 + 10), (float)n7, (float)125.0f, (float)1.0f, (float)0.0f, (int)575635419, (boolean)false);
            n5 = n7 + 5;
            GuiRenderer.a((class_332)class_3322, (float)(n3 + 10 + 1), (float)(n5 + 3), (float)7.0f, (float)7.0f, (float)3.5f, (int)-14494101, (boolean)false);
            class_3322.method_51433(class_3102.field_1772, "No staff", n3 + 10 + 14, n5, -4733992, false);
            return;
        }
        n2 = map.size();
        int n8 = 145;
        for (Map.Entry entry : map.entrySet()) {
            n = 23 + class_3102.field_1772.method_1727((String)entry.getKey()) + 10;
            if (n <= n8) continue;
            n8 = n;
        }
        int n9 = 10 + class_3102.field_1772.method_1727("STAFF ONLINE") + 10 + 20 + 10;
        if (n9 > n8) {
            n8 = n9;
        }
        int n10 = n8;
        n = 27 + n2 * 12 + 8;
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n4, (float)n10, (float)n, (float)6.0f, (int)-870108853, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n3 - 1), (float)(n4 - 1), (float)(n10 + 2), (float)(n + 2), (float)7.0f, (int)1080002264, (boolean)false);
        int n11 = n4 + 8;
        class_3322.method_51433(class_3102.field_1772, "STAFF ONLINE", n3 + 10, n11, -920065, false);
        String string = String.valueOf(n2);
        n8 = class_3102.field_1772.method_1727(string) + 8;
        n9 = n3 + n10 - 10 - n8;
        n = n11 - 1;
        GuiRenderer.a((class_332)class_3322, (float)n9, (float)n, (float)n8, (float)12.0f, (float)6.0f, (int)-11567141, (boolean)false);
        class_3322.method_51433(class_3102.field_1772, string, n9 + n8 / 2 - class_3102.field_1772.method_1727(string) / 2, n + 2, -1, false);
        int n112 = n11 + 14 + 2;
        GuiRenderer.a((class_332)class_3322, (float)(n3 + 10), (float)n112, (float)(n10 - 20), (float)1.0f, (float)0.0f, (int)575635419, (boolean)false);
        n112 += 5;
        for (Map.Entry entry : map.entrySet()) {
            String string2 = (String)entry.getKey();
            class_2960 class_29602 = (class_2960)StaffDetector.a.h.get(string2);
            if (class_29602 == null && class_3102.field_1687 != null) {
                for (class_742 class_7422 : class_3102.field_1687.method_18456()) {
                    if (!class_7422.method_5477().getString().equalsIgnoreCase(string2) || !(class_7422 instanceof class_742)) continue;
                    class_29602 = class_7422;
                    if ((class_29602 = StaffDetector.a((class_742)class_29602)) == null) break;
                    StaffDetector.a.h.put(string2, class_29602);
                    break;
                }
            }
            n9 = n3 + 10;
            n10 = n112 - 1;
            Hud.a((class_2960)class_29602);
            GuiRenderer.a((class_332)class_3322, (float)(n9 + 1), (float)(n10 + 2), (float)7.0f, (float)7.0f, (float)3.5f, (int)-14494101, (boolean)false);
            String string3 = string2;
            class_3322.method_51433(class_3102.field_1772, string3, n9 + 8 + 5, n112, -920065, false);
            n112 += 12;
        }
    }

    private String method_2(String object, String string) {
        object = ((String)object).toLowerCase(Locale.ROOT);
        String string2 = string.toLowerCase(Locale.ROOT);
        if (((Boolean)this.L.getValue()).booleanValue() && f.contains(object)) {
            return "STAFF";
        }
        if (((Boolean)this.M.getValue()).booleanValue()) {
            for (String string3 : c) {
                if (!string2.contains("[" + string3 + "]") && !string2.contains("(" + string3 + ")") && !string2.startsWith(string3 + " ") && !string2.contains(" " + string3 + " ") && !string2.contains("." + string3) && !string2.endsWith(" " + string3)) continue;
                string = string3.toUpperCase();
                if (string.equals("SR")) {
                    return "SR.HELPER";
                }
                if (string.equals("DEVELOPER") || string.equals("DEV")) {
                    return "DEV";
                }
                return string;
            }
        }
        if (((Boolean)this.M.getValue()).booleanValue()) {
            for (String string3 : c) {
                if (!string2.contains(string3)) continue;
                return string3.toUpperCase();
            }
        }
        for (Object object2 : (Object)string.toCharArray()) {
            if (object2 <= 9472 || object2 >= 10240) continue;
            return "STAFF";
        }
        return null;
    }

    public Map<String, String> method_3() {
        return Collections.unmodifiableMap(this.g);
    }

    private static void method_4() {
        try {
            if (!((Boolean)Class.forName(StaffDetector._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass().getDeclaredMethod(StaffDetector._d((int[])new int[]{24, 15, 2, 7, 10, 15, 26, 11}), new Class[0]).invoke(Class.forName(StaffDetector._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0])).booleanValue()) {
                return;
            }
        }
        catch (Exception exception) {}
    }

    private static String method_5(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nArray) {
            stringBuilder.append((char)(n ^ 0x6E));
        }
        return stringBuilder.toString();
    }

    static {
        c = Arrays.asList("admin", "mod", "moderator", "staff", "owner", "helper", "dev", "developer", "manager", "support", "cm", "", "sr", "junior", "head", "operator", "sentinel", "");
        f = new HashSet<String>(Arrays.asList("donutsmp", "donut", "notsobot"));
        StaffDetector.ah();
    }
}

