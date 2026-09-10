/*
 * Decompiled with CFR 0.152.
 */
package com.water.gui;

import com.water.gui.ClickGuiScreen;
import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.client.WaterPlus;
import com.water.module.modules.misc.ChatMacro;
import com.water.setting.Setting;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.lwjgl.glfw.GLFW;

public class ChatMacroScreen
extends class_437 {
    private static final int field_0 = 420;
    private static final int field_1 = 380;
    private static final int PAD = 12;
    private static final int HEAD_H = 36;
    private static final int FOOT_H = 44;
    private static final int ROW_H = 52;
    private static final int ROW_GAP = 6;
    private static final int KEY_W = 72;
    private static final float field_2 = 14.0f;
    private static final float R_SM = 8.0f;
    private static final float R_XS = 5.0f;
    private static final int C_BD_IN = -15327184;
    private static final int C_TEXT = -2234128;
    private static final int C_TEXT_DIM = -7824982;
    private static final int C_MUTED = -12298906;
    private static final int C_RED = -2539435;
    private static final int C_GREEN = -11751558;
    private static final int C_WHITE_10 = 0x10FFFFFF;
    private static final int C_GRID_BG = -16183270;
    private final class_437 parent;
    private final ChatMacro module;
    private long openNs = 0L;
    private final List<String[]> macros = new ArrayList<String[]>();
    private int editingText = -1;
    private int listeningKey = -1;
    private int scroll = 0;
    private int field_3;
    private int field_4;

    public ChatMacroScreen(class_437 class_4372) {
        super((class_2561)class_2561.method_43470((String)""));
        this.parent = class_4372;
        this.module = this.find();
        this.load();
    }

    private ChatMacro find() {
        Object object = ModuleManager.INSTANCE.getModules().iterator();
        while (object.hasNext()) {
            Module module = object.next();
            if (!(module instanceof ChatMacro)) continue;
            object = (ChatMacro)module;
            return object;
        }
        return null;
    }

    private void load() {
        this.macros.clear();
        if (this.module == null) {
            this.macros.add(new String[]{"", "0"});
            return;
        }
        List<Setting<?>> list = this.module.getSettings();
        int n = 0;
        while (n + 1 < list.size()) {
            String string = (String)list.get(n).getValue();
            String string2 = String.valueOf(list.get(n + 1).getValue());
            this.macros.add(new String[]{string, string2});
            n += 2;
        }
        if (this.macros.isEmpty()) {
            this.macros.add(new String[]{"", "0"});
        }
    }

    private void save() {
        if (this.module == null) {
            return;
        }
        List<Setting<?>> list = this.module.getSettings();
        for (int i = 0; i < this.macros.size() && i * 2 + 1 < list.size(); ++i) {
            list.get(i * 2).setValue(this.macros.get(i)[0]);
            list.get(i * 2 + 1).setValue(this.parseKey(this.macros.get(i)[1]));
        }
    }

    private int parseKey(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (Exception exception) {
            return 0;
        }
    }

    private int method_0() {
        return (this.field_22789 - 420) / 2;
    }

    private int method_1() {
        return (this.field_22790 - 380) / 2;
    }

    private int listY() {
        return this.py() + 36 + 12;
    }

    private int listH() {
        return 276;
    }

    private int visRows() {
        return Math.max(1, this.listH() / 58);
    }

    private int maxScroll() {
        return Math.max(0, this.macros.size() - this.visRows());
    }

    protected void method_25426() {
        this.px = this.px();
        this.py = this.py();
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        if (this.openNs == 0L) {
            this.openNs = System.nanoTime();
        }
        float f2 = this.easeOut(Math.min(1.0f, (float)(System.nanoTime() - this.openNs) / 1.6E8f));
        this.px = this.px();
        this.py = this.py();
        int n6 = WaterPlus.getAccentARGB();
        int n7 = WaterPlus.getBackgroundARGB();
        float f3 = WaterPlus.getGuiRoundness();
        float f4 = Math.max(5.0f, f3 * 0.6f);
        float f5 = Math.max(4.0f, f3 * 0.4f);
        float f6 = WaterPlus.getGlassIntensity();
        GuiRenderer.a((class_332)class_3322, (float)(this.px - 4), (float)(this.py - 4), (float)428.0f, (float)388.0f, (float)(f3 + 3.0f), (int)this.as(ChatMacroScreen.gc((int)(n6 & 0xFFFFFF), (int)((int)(25.0f * f2))), 1.0f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)this.px, (float)this.py, (float)420.0f, (float)380.0f, (float)f3, (int)this.as(n7, f2), (boolean)false);
        if (f6 > 0.01f) {
            GuiRenderer.a((class_332)class_3322, (float)(this.px + 1), (float)(this.py + 1), (float)418.0f, (float)38.0f, (float)f3, (int)this.as(ChatMacroScreen.gc((int)0xFFFFFF, (int)((int)(15.0f * f6))), f2), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)this.px, (float)this.py, (float)420.0f, (float)380.0f, (float)f3, (float)1.0f, (int)this.as(ChatMacroScreen.gc((int)0xFFFFFF, (int)((int)(50.0f * f6))), f2), (boolean)false);
        } else {
            GuiRenderer.a((class_332)class_3322, (float)this.px, (float)this.py, (float)420.0f, (float)380.0f, (float)f3, (float)1.0f, (int)this.as(n6 & 0xFFFFFF | 0x55000000, f2), (boolean)false);
        }
        GuiRenderer.a((class_332)class_3322, (float)this.px, (float)this.py, (float)420.0f, (float)36.0f, (float)f3, (float)f3, (float)0.0f, (float)0.0f, (boolean)false, (int[])new int[]{this.as(ChatMacroScreen.gc((int)0, (int)55), f2)});
        class_3322.method_25294(this.px, this.py + 36, this.px + 420, this.py + 36 + 1, this.as(-15327184, f2));
        GuiRenderer.a((class_332)class_3322, (float)this.px, (float)(this.py + 8), (float)3.0f, (float)20.0f, (float)1.5f, (int)this.as(n6, f2), (boolean)false);
        this.ft(class_3322, "CHAT MACROS", this.px + 12 + 8, this.py + 11, this.as(-2234128, f2));
        this.ft(class_3322, this.macros.size() + " macros", this.px + 12 + 8, this.py + 23, this.as(-7824982, f2));
        n7 = this.px + 420 - 12 - 60;
        int n8 = this.py + 9;
        int n9 = this.hov(n, n2, n7, n8, 60, 18);
        GuiRenderer.a((class_332)class_3322, (float)n7, (float)n8, (float)60.0f, (float)18.0f, (float)9.0f, (int)this.as(n9 != 0 ? n6 & 0xFFFFFF | 0x33000000 : n6 & 0xFFFFFF | 0x18000000, f2), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n7, (float)n8, (float)60.0f, (float)18.0f, (float)9.0f, (float)1.0f, (int)this.as(n6 & 0xFFFFFF | 0x66000000, f2), (boolean)false);
        this.ft(class_3322, "+ ADD", n7 + (60 - this.fw("+ ADD")) / 2, n8 + 4, this.as(n6, f2));
        n7 = this.px + 12;
        n8 = this.listY();
        n9 = this.visRows();
        this.scroll = Math.max(0, Math.min(this.maxScroll(), this.scroll));
        for (n5 = 0; n5 < n9 && (n4 = n5 + this.scroll) < this.macros.size(); ++n5) {
            String string;
            String[] stringArray = this.macros.get(n4);
            String string2 = stringArray[0];
            int n10 = this.parseKey(stringArray[1]);
            int n11 = n8 + n5 * 58;
            boolean bl = this.editingText == n4;
            boolean bl2 = this.listeningKey == n4;
            int n12 = bl || bl2 ? 1 : 0;
            int n13 = n12 != 0 ? n6 & 0xFFFFFF | 0x16000000 : this.as(0x18FFFFFF, f2);
            int n14 = n12 != 0 ? n6 & 0xFFFFFF | 0x55000000 : this.as(0x22FFFFFF, f2);
            GuiRenderer.a((class_332)class_3322, (float)n7, (float)n11, (float)396.0f, (float)52.0f, (float)f4, (int)n13, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n7, (float)n11, (float)396.0f, (float)52.0f, (float)f4, (float)1.0f, (int)n14, (boolean)false);
            this.ft(class_3322, "#" + (n4 + 1), n7 + 8, n11 + 6, this.as(n12 != 0 ? n6 : -12298906, f2));
            n4 = n7 + 8;
            n12 = bl && System.currentTimeMillis() / 500L % 2L == 0L ? 1 : 0;
            String string3 = string2 + (n12 != 0 ? "|" : "");
            if (string3.isEmpty()) {
                string3 = bl ? "|" : "";
            }
            n13 = bl ? this.as(n6 & 0xFFFFFF | 0x22000000, f2) : this.as(0x22000000, f2);
            n14 = bl ? this.as(n6 & 0xFFFFFF | 0x88000000, f2) : this.as(0x33FFFFFF, f2);
            GuiRenderer.a((class_332)class_3322, (float)(n4 - 2), (float)(n11 + 22), (float)280.0f, (float)20.0f, (float)f5, (int)n13, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)(n4 - 2), (float)(n11 + 22), (float)280.0f, (float)20.0f, (float)f5, (float)1.0f, (int)n14, (boolean)false);
            String string4 = "Type message or /command...";
            n14 = string2.isEmpty() && !bl ? this.as(-12298906, f2) : this.as(-2234128, f2);
            String string5 = string = string2.isEmpty() && !bl ? string4 : string3;
            if (this.fw(string) > 272) {
                while (string.length() > 1 && this.fw(string) > 272) {
                    string = string.substring(1);
                }
            }
            this.ft(class_3322, string, n4 + 2, n11 + 28, n14);
            n4 = n7 + 396 - 72 - 34;
            n3 = n11 + 22;
            this.hov(n, n2, n4, n3, 72, 20);
            String string6 = bl2 ? "PRESS..." : (string2 = n10 <= 0 ? "NO KEY" : this.keyName(n10));
            int n15 = bl2 ? this.as(n6 & 0xFFFFFF | 0x44000000, f2) : (n12 = n10 > 0 ? this.as(n6 & 0xFFFFFF | 0x28000000, f2) : this.as(0x22000000, f2));
            n13 = bl2 ? this.as(n6, f2) : (n10 > 0 ? this.as(n6 & 0xFFFFFF | 0x77000000, f2) : this.as(0x33FFFFFF, f2));
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n3, (float)72.0f, (float)20.0f, (float)f5, (int)n12, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n3, (float)72.0f, (float)20.0f, (float)f5, (float)1.0f, (int)n13, (boolean)false);
            this.ft(class_3322, string2, n4 + (72 - this.fw(string2)) / 2, n3 + 5, this.as(bl2 ? n6 : (n10 > 0 ? -2234128 : -12298906), f2));
            n4 = n7 + 396 - 26;
            n3 = n11 + 22;
            boolean bl3 = this.hov(n, n2, n4, n3, 20, 20);
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n3, (float)20.0f, (float)20.0f, (float)f5, (int)this.as(bl3 ? 1155088469 : 584663125, f2), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n3, (float)20.0f, (float)20.0f, (float)f5, (float)1.0f, (int)this.as(-2539435, f2 * (bl3 ? 0.9f : 0.4f)), (boolean)false);
            this.ft(class_3322, "\u2715", n4 + (20 - this.fw("\u2715")) / 2, n3 + 5, this.as(-2539435, f2));
        }
        if (this.macros.isEmpty()) {
            this.ft(class_3322, "No macros yet \u2014 click + ADD", this.px + 210 - this.fw("No macros yet \u2014 click + ADD") / 2, this.py + 190 - 5, this.as(-12298906, f2));
        }
        if (this.macros.size() > this.visRows()) {
            n5 = this.px + 420 - 8;
            n4 = this.listY();
            n3 = this.listH();
            float f7 = (float)this.visRows() / (float)this.macros.size();
            float f8 = Math.max(20.0f, (float)n3 * f7);
            float f9 = (float)n4 + ((float)n3 - f8) * ((float)this.scroll / (float)Math.max(1, this.maxScroll()));
            GuiRenderer.a((class_332)class_3322, (float)n5, (float)n4, (float)4.0f, (float)n3, (float)2.0f, (int)this.as(-15327184, f2), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n5, (float)((int)f9), (float)4.0f, (float)((int)f8), (float)2.0f, (int)this.as(n6 & 0xFFFFFF | 0xAA000000, f2), (boolean)false);
        }
        n5 = this.py + 380 - 44;
        class_3322.method_25294(this.px, n5, this.px + 420, n5 + 1, this.as(-15327184, f2));
        GuiRenderer.a((class_332)class_3322, (float)this.px, (float)n5, (float)420.0f, (float)44.0f, (float)0.0f, (float)0.0f, (float)f3, (float)f3, (boolean)false, (int[])new int[]{this.as(ChatMacroScreen.gc((int)0, (int)50), f2)});
        n4 = n5 + 11;
        n3 = this.px + 12;
        boolean bl = this.hov(n, n2, n3, n4, 80, 22);
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n4, (float)80.0f, (float)22.0f, (float)11.0f, (int)this.as(bl ? 0x18FFFFFF : 0x8FFFFFF, f2), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n4, (float)80.0f, (float)22.0f, (float)11.0f, (float)1.0f, (int)this.as(-15327184, f2), (boolean)false);
        this.ft(class_3322, "CANCEL", n3 + (80 - this.fw("CANCEL")) / 2, n4 + 7, this.as(-7824982, f2));
        int n16 = this.px + 420 - 12 - 80;
        boolean bl4 = this.hov(n, n2, n16, n4, 80, 22);
        GuiRenderer.a((class_332)class_3322, (float)n16, (float)n4, (float)80.0f, (float)22.0f, (float)11.0f, (int)this.as(bl4 ? n6 : n6 & 0xFFFFFF | 0x22000000, f2), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n16, (float)n4, (float)80.0f, (float)22.0f, (float)11.0f, (float)1.5f, (int)this.as(n6, f2 * (bl4 ? 1.0f : 0.5f)), (boolean)false);
        this.ft(class_3322, "SAVE", n16 + (80 - this.fw("SAVE")) / 2, n4 + 7, this.as(bl4 ? -16777216 : n6, f2));
        super.method_25394(class_3322, n, n2, f);
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        int n;
        int n2 = (int)class_119092.comp_4798();
        int n3 = (int)class_119092.comp_4799();
        class_119092.method_74245();
        this.px = this.px();
        this.py = this.py();
        WaterPlus.getAccentARGB();
        int n4 = this.py + 380 - 44;
        if (this.hov(n2, n3, this.px + 12, n4 += 11, 80, 22)) {
            class_310.method_1551().method_1507(this.parent);
            return true;
        }
        if (this.hov(n2, n3, this.px + 420 - 12 - 80, n4, 80, 22)) {
            this.save();
            class_310.method_1551().method_1507(this.parent);
            return true;
        }
        n4 = this.px + 420 - 12 - 60;
        int n5 = this.py + 9;
        if (this.hov(n2, n3, n4, n5, 60, 18)) {
            this.macros.add(new String[]{"", "0"});
            this.scroll = this.maxScroll();
            this.editingText = this.macros.size() - 1;
            this.listeningKey = -1;
            return true;
        }
        this.editingText = -1;
        this.listeningKey = -1;
        n4 = this.px + 12;
        n5 = this.listY();
        int n6 = this.visRows();
        for (int i = 0; i < n6 && (n = i + this.scroll) < this.macros.size(); ++i) {
            int n7 = n4 + 8;
            int n8 = n5 + i * 58;
            if (this.hov(n2, n3, n7 - 2, n8 + 22, 280, 20)) {
                this.editingText = n;
                return true;
            }
            n7 = n4 + 396 - 72 - 34;
            int n9 = n8 + 22;
            if (this.hov(n2, n3, n7, n9, 72, 20)) {
                this.listeningKey = n;
                return true;
            }
            n7 = n4 + 396 - 26;
            if (!this.hov(n2, n3, n7, n8 += 22, 20, 20)) continue;
            this.macros.remove(n);
            this.scroll = Math.max(0, Math.min(this.maxScroll(), this.scroll));
            this.editingText = -1;
            this.listeningKey = -1;
            return true;
        }
        return super.method_25402(class_119092, bl);
    }

    public boolean method_25401(double d2, double d3, double d4, double d5) {
        this.scroll = Math.max(0, Math.min(this.maxScroll(), this.scroll + (d5 > 0.0 ? -1 : 1)));
        return true;
    }

    public boolean method_25404(class_11908 object) {
        int n = object.method_74228();
        if (this.listeningKey >= 0) {
            this.macros.get((int)this.listeningKey)[1] = n == 256 || n == 259 ? "0" : String.valueOf(n);
            this.listeningKey = -1;
            return true;
        }
        if (this.editingText >= 0) {
            if (n == 256 || n == 257) {
                this.editingText = -1;
                return true;
            }
            if (n == 259 && !this.macros.get(this.editingText)[0].isEmpty()) {
                object = this.macros.get(this.editingText)[0];
                this.macros.get((int)this.editingText)[0] = ((String)object).substring(0, ((String)object).length() - 1);
                return true;
            }
            if (object.method_74243()) {
                String[] stringArray = this.macros.get(this.editingText);
                stringArray[0] = stringArray[0] + class_310.method_1551().field_1774.method_1460().trim();
                return true;
            }
            return true;
        }
        if (n == 256) {
            class_310.method_1551().method_1507(this.parent);
            return true;
        }
        return super.method_25404((class_11908)object);
    }

    public boolean method_25400(class_11905 class_119052) {
        if (this.editingText >= 0) {
            String[] stringArray = this.macros.get(this.editingText);
            stringArray[0] = stringArray[0] + class_119052.method_74226();
            return true;
        }
        return super.method_25400(class_119052);
    }

    private void method_2(class_332 class_3322, String string, int n, int n2, int n3) {
        WaterFontRenderer.INSTANCE.a(class_3322, string, n, n2, n3);
    }

    private int method_3(String string) {
        return WaterFontRenderer.INSTANCE.a(string);
    }

    private int method_4(int n, float f) {
        return Math.max(0, Math.min(255, (int)((float)(n >> 24 & 0xFF) * f))) << 24 | n & 0xFFFFFF;
    }

    private static int method_5(int n, int n2) {
        return Math.max(0, Math.min(255, n2)) << 24 | n & 0xFFFFFF;
    }

    private float easeOut(float f) {
        return 1.0f - (float)Math.pow(1.0f - Math.min(1.0f, f), 3.0);
    }

    private boolean hov(int n, int n2, int n3, int n4, int n5, int n6) {
        return n >= n3 && n <= n3 + n5 && n2 >= n4 && n2 <= n4 + n6;
    }

    private String keyName(int n) {
        if (n <= 0) {
            return "None";
        }
        String string = GLFW.glfwGetKeyName((int)n, (int)0);
        if (string != null && !string.isBlank()) {
            return string.toUpperCase();
        }
        return ClickGuiScreen.getKeyDisplayNameStatic(n);
    }

    public boolean method_25421() {
        return false;
    }
}

