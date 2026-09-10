/*
 * Decompiled with CFR 0.152.
 */
package com.water.gui;

import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.client.ConfigShare;
import com.water.module.modules.client.WaterPlus;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;

public class ConfigManagerScreen
extends class_437 {
    private static final int field_0 = 340;
    private static final int field_1 = 380;
    private static final int PAD = 14;
    private static final int ROW_H = 42;
    private static final int ROWS = 4;
    private static final int MAX_CFG = 5;
    private static int field_2;
    private static int SURFACE;
    private static int SURFACE2;
    private static int BORDER;
    private static int ACCENT;
    private static int ACCENT2;
    private static final int TEXT = -1117441;
    private static final int TEXT2 = -7824982;
    private static final int TEXT3 = -12298906;
    private static final int GREEN = -14498466;
    private static final int GREEN_BG = -15914984;
    private static final int RED = -1096636;
    private static final int RED_BG = -13824498;
    private static final int AMBER = -680437;
    private static final int AMBER_BG = -13821184;
    private static int SEL_BG;
    private static int SEL_BD;
    private a tab = a.CONFIGS;
    private final List<String> configs = new ArrayList<String>();
    private int sel = 0;
    private int scroll = 0;
    private boolean newOpen = false;
    private boolean importOpen = false;
    private String newName = "";
    private String importCode = "";
    private String status = "";
    private int statusCol = -7824982;
    private long statusAt = 0L;
    private int field_3;
    private int field_4;

    private static void syncColors() {
        int n = WaterPlus.getBackgroundARGB();
        int n2 = WaterPlus.getAccentARGB();
        BG = ConfigManagerScreen.darken(n, 0.85f);
        SURFACE = ConfigManagerScreen.darken(n, 0.95f);
        SURFACE2 = n;
        BORDER = ConfigManagerScreen.blendArgb(n, n2, 0.15f);
        ACCENT = n2;
        ACCENT2 = ConfigManagerScreen.darken(n2, 0.75f);
        SEL_BG = ConfigManagerScreen.blendArgb(n, n2, 0.2f);
        SEL_BD = ConfigManagerScreen.blendArgb(n, n2, 0.55f);
    }

    private static int darken(int n, float f) {
        int n2 = Math.max(0, (int)((float)(n >> 16 & 0xFF) * f));
        int n3 = Math.max(0, (int)((float)(n >> 8 & 0xFF) * f));
        int n4 = Math.max(0, (int)((float)(n & 0xFF) * f));
        return n & 0xFF000000 | n2 << 16 | n3 << 8 | n4;
    }

    private static int blendArgb(int n, int n2, float f) {
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n2 >> 16 & 0xFF;
        int n6 = n2 >> 8 & 0xFF;
        return 0xFF000000 | (int)((float)n3 + (float)(n5 - n3) * f) << 16 | (int)((float)n4 + (float)(n6 - n4) * f) << 8 | (int)((float)(n &= 0xFF) + (float)((n2 &= 0xFF) - n) * f);
    }

    private static float method_0() {
        return WaterPlus.getGuiRoundness() + 6.0f;
    }

    private static float method_1() {
        return Math.max(4.0f, WaterPlus.getGuiRoundness());
    }

    private void method_2(class_332 class_3322, String string, int n, int n2, int n3) {
        WaterFontRenderer.INSTANCE.a(class_3322, string, n, n2, n3);
    }

    private void method_3(class_332 class_3322, String string, int n, int n2, int n3) {
        int n4 = WaterFontRenderer.INSTANCE.a(string);
        WaterFontRenderer.INSTANCE.a(class_3322, string, n - n4 / 2, n2, n3);
    }

    private int method_4(String string) {
        return WaterFontRenderer.INSTANCE.a(string);
    }

    public ConfigManagerScreen() {
        super((class_2561)class_2561.method_43470((String)"Water Configs"));
    }

    protected void method_25426() {
        this.px = (this.field_22789 - 340) / 2;
        this.py = (this.field_22790 - 380) / 2;
        this.refreshConfigs();
    }

    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        ConfigManagerScreen.syncColors();
        ModuleManager.INSTANCE.getModules().stream().filter(module -> module instanceof WaterPlus).findFirst().ifPresent(module -> module.onTick());
        WaterFontRenderer.bk();
        GuiRenderer.a((class_332)class_3322, (float)this.px, (float)this.py, (float)340.0f, (float)380.0f, (float)ConfigManagerScreen.R(), (int)BG, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)this.px, (float)this.py, (float)340.0f, (float)380.0f, (float)ConfigManagerScreen.R(), (float)1.0f, (int)BORDER, (boolean)false);
        this.renderHeader(class_3322, n, n2);
        this.renderTabs(class_3322, n, n2);
        if (this.tab == a.CONFIGS) {
            this.renderConfigs(class_3322, n, n2);
        } else {
            this.renderShare(class_3322, n, n2);
        }
        this.renderFooter(class_3322, n, n2);
        if (!this.status.isEmpty() && System.currentTimeMillis() - this.statusAt < 3000L) {
            int n3 = this.fw(this.status) + 24;
            int n4 = this.px + 170 - n3 / 2;
            int n5 = this.py + 380 - 36;
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)n3, (float)22.0f, (float)6.0f, (int)-871756268, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)n3, (float)22.0f, (float)6.0f, (float)1.0f, (int)(this.statusCol & 0x55FFFFFF), (boolean)false);
            this.tc(class_3322, this.status, this.px + 170, n5 + 7, this.statusCol);
        }
        if (this.newOpen) {
            this.renderNewPopup(class_3322, n, n2);
        }
        if (this.importOpen) {
            this.renderImportPopup(class_3322, n, n2);
        }
    }

    private void renderHeader(class_332 class_3322, int n, int n2) {
        int n3 = this.py + 18;
        this.t(class_3322, "WATER CONFIGS", this.px + 14, n3, -1117441);
        String string = this.configs.size() + " / " + 5;
        int n4 = this.fw(string) + 16;
        GuiRenderer.a((class_332)class_3322, (float)(this.px + 340 - 14 - n4), (float)(n3 - 4), (float)n4, (float)20.0f, (float)5.0f, (int)SURFACE2, (boolean)false);
        this.tc(class_3322, string, this.px + 340 - 14 - n4 / 2, n3, -7824982);
        n = this.hov(n, n2, this.px + 340 - 28, n3 - 4, 20, 20) ? 1 : 0;
        this.t(class_3322, "x", this.px + 340 - 22, n3, n != 0 ? -1117441 : -7824982);
        class_3322.method_25294(this.px + 14, this.py + 46, this.px + 340 - 14, this.py + 47, BORDER);
    }

    private void renderTabs(class_332 class_3322, int n, int n2) {
        n = this.py + 56;
        String string = "MY CONFIGS";
        String string2 = "SHARE / IMPORT";
        boolean bl = this.tab == a.CONFIGS;
        int n3 = this.px + 14;
        int n4 = this.px + 14 + 130;
        GuiRenderer.a((class_332)class_3322, (float)(n3 - 6), (float)(n - 4), (float)(this.fw(string) + 12), (float)24.0f, (float)5.0f, (int)(bl ? SURFACE2 : 0), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n4 - 6), (float)(n - 4), (float)(this.fw(string2) + 12), (float)24.0f, (float)5.0f, (int)(!bl ? SURFACE2 : 0), (boolean)false);
        this.t(class_3322, string, n3, n + 3, bl ? -1117441 : -7824982);
        this.t(class_3322, string2, n4, n + 3, !bl ? -1117441 : -7824982);
        n3 = bl ? n3 : n4;
        int n5 = bl ? this.fw(string) : this.fw(string2);
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)(n + 22), (float)n5, (float)3.0f, (float)2.0f, (int)ACCENT, (boolean)false);
        class_3322.method_25294(this.px + 14, n + 28, this.px + 340 - 14, n + 29, BORDER);
    }

    private void renderConfigs(class_332 class_3322, int n, int n2) {
        int n3 = this.py + 100;
        if (this.configs.isEmpty()) {
            this.tc(class_3322, "No configs yet \u2014 create one below", this.px + 170, n3 + 168 / 2 - 6, -12298906);
            return;
        }
        for (int i = 0; i < 4; ++i) {
            int n4;
            int n5 = i + this.scroll;
            if (n5 >= this.configs.size()) {
                if (n5 != this.configs.size() || this.configs.size() >= 5) continue;
                n4 = n3 + i * 42 + 4;
                GuiRenderer.a((class_332)class_3322, (float)(this.px + 14), (float)n4, (float)312.0f, (float)34.0f, (float)ConfigManagerScreen.RR(), (int)0x22FFFFFF, (boolean)false);
                GuiRenderer.a((class_332)class_3322, (float)(this.px + 14), (float)n4, (float)312.0f, (float)34.0f, (float)ConfigManagerScreen.RR(), (float)1.0f, (int)0x22FFFFFF, (boolean)false);
                this.tc(class_3322, "+ new config slot", this.px + 170, n4 + 17 - 5, -12298906);
                continue;
            }
            n4 = n3 + i * 42 + 4;
            int n6 = n5 == this.sel ? 1 : 0;
            int n7 = this.hov(n, n2, this.px + 14, n4, 312, 34);
            n7 = n6 != 0 ? SEL_BG : (n7 != 0 ? SURFACE2 : SURFACE);
            int n8 = n6 != 0 ? SEL_BD : BORDER;
            GuiRenderer.a((class_332)class_3322, (float)(this.px + 14), (float)n4, (float)312.0f, (float)34.0f, (float)ConfigManagerScreen.RR(), (int)n7, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)(this.px + 14), (float)n4, (float)312.0f, (float)34.0f, (float)ConfigManagerScreen.RR(), (float)1.0f, (int)n8, (boolean)false);
            if (n6 != 0) {
                GuiRenderer.a((class_332)class_3322, (float)(this.px + 14), (float)(n4 + 8), (float)3.0f, (float)18.0f, (float)2.0f, (int)ACCENT, (boolean)false);
            }
            this.t(class_3322, this.configs.get(n5), this.px + 14 + (n6 != 0 ? 14 : 10), n4 + 17 - 5, n6 != 0 ? -1117441 : -7824982);
            n5 = n4 + 17 - 10;
            n4 = this.px + 340 - 14 - 70;
            n6 = n4 - 80;
            n7 = this.hov(n, n2, n6, n5, 70, 20) ? 1 : 0;
            GuiRenderer.a((class_332)class_3322, (float)n6, (float)n5, (float)70.0f, (float)20.0f, (float)5.0f, (int)(n7 != 0 ? -15914984 : SURFACE), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n6, (float)n5, (float)70.0f, (float)20.0f, (float)5.0f, (float)1.0f, (int)(n7 != 0 ? -14498466 : 0x33FFFFFF), (boolean)false);
            this.tc(class_3322, "Reload", n6 + 35, n5 + 5, -14498466);
            n6 = this.hov(n, n2, n4, n5, 70, 20) ? 1 : 0;
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)70.0f, (float)20.0f, (float)5.0f, (int)(n6 != 0 ? -13824498 : SURFACE), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)70.0f, (float)20.0f, (float)5.0f, (float)1.0f, (int)(n6 != 0 ? -1096636 : 0x33FFFFFF), (boolean)false);
            this.tc(class_3322, "Delete", n4 + 35, n5 + 5, -1096636);
        }
    }

    private void renderShare(class_332 class_3322, int n, int n2) {
        ConfigShare configShare = ConfigShare.a();
        int n3 = configShare != null && (configShare.e || configShare.f) ? 1 : 0;
        int n4 = this.px + 14;
        int n5 = this.py + 105;
        boolean bl = n3 == 0 && this.hov(n, n2, n4, n5 += 8, 312, 36);
        GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)312.0f, (float)36.0f, (float)ConfigManagerScreen.RR(), (int)(bl ? ACCENT2 : SURFACE2), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)312.0f, (float)36.0f, (float)ConfigManagerScreen.RR(), (float)1.0f, (int)(bl ? ACCENT : BORDER), (boolean)false);
        String string = configShare != null && configShare.e ? "Uploading..." : "Share Config";
        this.tc(class_3322, string, this.px + 170, n5 + 11, -1117441);
        n = n3 == 0 && this.hov(n, n2, n4, n5 += 44, 312, 36) ? 1 : 0;
        GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)312.0f, (float)36.0f, (float)ConfigManagerScreen.RR(), (int)(n != 0 ? SURFACE2 : SURFACE), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)312.0f, (float)36.0f, (float)ConfigManagerScreen.RR(), (float)1.0f, (int)(n != 0 ? ACCENT : BORDER), (boolean)false);
        String string2 = configShare != null && configShare.f ? "Importing..." : "Import Config";
        this.tc(class_3322, string2, this.px + 170, n5 + 11, n != 0 ? -1117441 : -7824982);
        n5 += 48;
        if (configShare != null && !configShare.c.isEmpty()) {
            String string3 = "Code: " + configShare.c + "  (copied)";
            int n6 = this.fw(string3) + 24;
            n3 = this.px + 170 - n6 / 2;
            GuiRenderer.a((class_332)class_3322, (float)n3, (float)n5, (float)n6, (float)26.0f, (float)6.0f, (int)SURFACE2, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n3, (float)n5, (float)n6, (float)26.0f, (float)6.0f, (float)1.0f, (int)ACCENT, (boolean)false);
            this.tc(class_3322, string3, this.px + 170, n5 + 8, ACCENT);
        }
        if (configShare != null && !configShare.d.isEmpty()) {
            this.tc(class_3322, configShare.d, this.px + 170, this.py + 380 - 70, -1096636);
        }
    }

    private void renderFooter(class_332 class_3322, int n, int n2) {
        int n3 = this.py + 380 - 54;
        class_3322.method_25294(this.px + 14, n3, this.px + 340 - 14, n3 + 1, BORDER);
        n3 += 14;
        if (this.tab == a.CONFIGS) {
            boolean bl;
            int n4 = this.configs.size() >= 5 ? 1 : 0;
            boolean bl2 = bl = n4 == 0 && this.hov(n, n2, this.px + 14, n3, 110, 18);
            this.t(class_3322, "+ New config", this.px + 14, n3 + 2, bl ? ACCENT : (n4 != 0 ? -12298906 : -7824982));
            n4 = this.px + 340 - 14 - 90;
            n = this.hov(n, n2, n4, n3 - 4, 90, 26) ? 1 : 0;
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)(n3 - 4), (float)90.0f, (float)26.0f, (float)6.0f, (int)(n != 0 ? -13821184 : SURFACE), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)(n3 - 4), (float)90.0f, (float)26.0f, (float)6.0f, (float)1.0f, (int)(n != 0 ? -680437 : BORDER), (boolean)false);
            this.tc(class_3322, "Reset all", n4 + 90 / 2, n3 + 2, -680437);
        }
    }

    private void renderNewPopup(class_332 class_3322, int n, int n2) {
        int n3 = this.px + 170 - 340 / 2;
        int n4 = this.py + 190 - 130 / 2;
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n4, (float)340.0f, (float)130.0f, (float)12.0f, (int)BG, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n4, (float)340.0f, (float)130.0f, (float)12.0f, (float)1.0f, (int)BORDER, (boolean)false);
        this.tc(class_3322, "New Config Name", n3 + 340 / 2, n4 + 14, -1117441);
        GuiRenderer.a((class_332)class_3322, (float)(n3 + 16), (float)(n4 + 40), (float)308.0f, (float)30.0f, (float)6.0f, (int)SURFACE2, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n3 + 16), (float)(n4 + 40), (float)308.0f, (float)30.0f, (float)6.0f, (float)1.0f, (int)(this.newName.isEmpty() ? BORDER : ACCENT), (boolean)false);
        String string = this.newName.isEmpty() ? "Enter name..." : this.newName;
        this.t(class_3322, string, n3 + 26, n4 + 50, this.newName.isEmpty() ? -12298906 : -1117441);
        n3 = n3 + 340 / 2 - 55;
        n = this.hov(n, n2, n3, n4 + 88, 110, 28) ? 1 : 0;
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)(n4 + 88), (float)110.0f, (float)28.0f, (float)7.0f, (int)(n != 0 ? ACCENT2 : SURFACE2), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)(n4 + 88), (float)110.0f, (float)28.0f, (float)7.0f, (float)1.0f, (int)(n != 0 ? ACCENT : BORDER), (boolean)false);
        this.tc(class_3322, "Create", n3 + 110 / 2, n4 + 97, -1117441);
    }

    private void renderImportPopup(class_332 class_3322, int n, int n2) {
        int n3 = this.px + 170 - 380 / 2;
        int n4 = this.py + 190 - 130 / 2;
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n4, (float)380.0f, (float)130.0f, (float)12.0f, (int)BG, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n4, (float)380.0f, (float)130.0f, (float)12.0f, (float)1.0f, (int)BORDER, (boolean)false);
        this.tc(class_3322, "Enter Config Code", n3 + 380 / 2, n4 + 14, -1117441);
        GuiRenderer.a((class_332)class_3322, (float)(n3 + 16), (float)(n4 + 40), (float)348.0f, (float)30.0f, (float)6.0f, (int)SURFACE2, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n3 + 16), (float)(n4 + 40), (float)348.0f, (float)30.0f, (float)6.0f, (float)1.0f, (int)(this.importCode.isEmpty() ? BORDER : ACCENT), (boolean)false);
        String string = this.importCode.isEmpty() ? "Paste code here (Ctrl+V)..." : this.importCode;
        this.t(class_3322, string, n3 + 26, n4 + 50, this.importCode.isEmpty() ? -12298906 : -1117441);
        n3 = n3 + 380 / 2 - 55;
        n = this.hov(n, n2, n3, n4 + 88, 110, 28) ? 1 : 0;
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)(n4 + 88), (float)110.0f, (float)28.0f, (float)7.0f, (int)(n != 0 ? ACCENT2 : SURFACE2), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)(n4 + 88), (float)110.0f, (float)28.0f, (float)7.0f, (float)1.0f, (int)(n != 0 ? ACCENT : BORDER), (boolean)false);
        this.tc(class_3322, "Import", n3 + 110 / 2, n4 + 97, -1117441);
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        int n = (int)class_119092.comp_4798();
        int n2 = (int)class_119092.comp_4799();
        int n3 = this.px;
        int n4 = this.py;
        if (this.newOpen) {
            int n5 = n3 + 170 - 340 / 2;
            int n6 = n5 + 340 / 2 - 55;
            int n7 = n4 + 190 - 130 / 2;
            if (this.hov(n, n2, n6, n7 + 88, 110, 28)) {
                this.doCreate();
                return true;
            }
            if (!this.hov(n, n2, n5, n7, 340, 130)) {
                this.newOpen = false;
                return true;
            }
            return true;
        }
        if (this.importOpen) {
            int n8 = n3 + 170 - 380 / 2;
            int n9 = n8 + 380 / 2 - 55;
            int n10 = n4 + 190 - 130 / 2;
            if (this.hov(n, n2, n9, n10 + 88, 110, 28)) {
                this.doImport();
                return true;
            }
            if (!this.hov(n, n2, n8, n10, 380, 130)) {
                this.importOpen = false;
                return true;
            }
            return true;
        }
        if (this.hov(n, n2, n3 + 340 - 28, n4 + 14, 20, 20)) {
            this.method_25419();
            return true;
        }
        if (this.hov(n, n2, n3 + 14 - 6, n4 + 52, this.fw("MY CONFIGS") + 12, 28)) {
            this.tab = a.CONFIGS;
            return true;
        }
        if (this.hov(n, n2, n3 + 14 + 124, n4 + 52, this.fw("SHARE / IMPORT") + 12, 28)) {
            this.tab = a.SHARE;
            return true;
        }
        if (this.tab == a.CONFIGS) {
            int n11;
            int n12;
            int n13;
            int n14 = n4 + 100;
            for (n13 = 0; n13 < 4 && (n12 = n13 + this.scroll) < this.configs.size(); ++n13) {
                int n15 = n3 + 340 - 14 - 70;
                int n16 = n15 - 80;
                int n17 = n14 + n13 * 42 + 4;
                n11 = n17 + 17 - 10;
                if (this.hov(n, n2, n16, n11, 70, 20)) {
                    this.sel = n12;
                    this.doReload();
                    return true;
                }
                if (this.hov(n, n2, n15, n11, 70, 20)) {
                    this.sel = n12;
                    this.doDelete();
                    return true;
                }
                if (!this.hov(n, n2, n3 + 14, n17, 312, 34)) continue;
                this.sel = n12;
                return true;
            }
            n13 = n4 + 380 - 54 + 14;
            int n18 = n12 = this.configs.size() >= 5 ? 1 : 0;
            if (n12 == 0 && this.hov(n, n2, n3 + 14, n13, 110, 18)) {
                this.newOpen = true;
                this.newName = "";
                return true;
            }
            if (n12 != 0 && this.hov(n, n2, n3 + 14, n13, 110, 18)) {
                this.setStatus("Max 5 configs!", -1096636);
                return true;
            }
            n11 = n3 + 340 - 14 - 90;
            if (this.hov(n, n2, n11, n13 - 4, 90, 26)) {
                this.doReset();
                return true;
            }
        } else {
            ConfigShare configShare = ConfigShare.a();
            boolean bl2 = configShare != null && (configShare.e || configShare.f);
            int n19 = n3 + 14;
            int n20 = n4 + 127;
            if (!bl2 && this.hov(n, n2, n19, n20, 312, 36)) {
                this.doShare();
                return true;
            }
            if (!bl2 && this.hov(n, n2, n19, n20 + 36 + 8, 312, 36)) {
                this.importOpen = true;
                this.importCode = "";
                return true;
            }
        }
        return super.method_25402(class_119092, bl);
    }

    public boolean method_25401(double d2, double d3, double d4, double d5) {
        int n = Math.max(0, this.configs.size() - 4);
        this.scroll = (int)Math.max(0.0, Math.min((double)n, (double)this.scroll - d5));
        return true;
    }

    public boolean method_25404(class_11908 object) {
        int n = object.method_74228();
        if (this.newOpen) {
            if (n == 256) {
                this.newOpen = false;
                return true;
            }
            if (n == 257) {
                this.doCreate();
                return true;
            }
            if (n == 259 && !this.newName.isEmpty()) {
                this.newName = this.newName.substring(0, this.newName.length() - 1);
                return true;
            }
            return true;
        }
        if (this.importOpen) {
            if (n == 256) {
                this.importOpen = false;
                return true;
            }
            if (n == 257) {
                this.doImport();
                return true;
            }
            if (n == 259 && !this.importCode.isEmpty()) {
                this.importCode = this.importCode.substring(0, this.importCode.length() - 1);
                return true;
            }
            if (object.method_74243()) {
                object = class_310.method_1551().field_1774.method_1460();
                if (object != null) {
                    this.importCode = ((String)object).trim();
                }
                return true;
            }
            return true;
        }
        if (n == 256) {
            this.method_25419();
            return true;
        }
        return super.method_25404((class_11908)object);
    }

    public boolean method_25400(class_11905 class_119052) {
        String string = class_119052.method_74226();
        if (this.newOpen && this.newName.length() < 24) {
            this.newName = this.newName + string;
            return true;
        }
        if (this.importOpen && this.importCode.length() < 64) {
            this.importCode = this.importCode + string;
            return true;
        }
        return super.method_25400(class_119052);
    }

    private void doReload() {
        Map<String, Boolean> map = this.snapshotEnabled();
        if (!this.configs.isEmpty() && this.sel < this.configs.size()) {
            ModuleManager.INSTANCE.e(this.configs.get(this.sel));
        }
        ModuleManager.INSTANCE.g();
        this.syncModuleLifecycle(map, this.snapshotEnabled());
        this.setStatus("Config loaded: " + ModuleManager.INSTANCE.a(), -14498466);
    }

    private void doDelete() {
        if (this.configs.isEmpty()) {
            return;
        }
        try {
            Object object = class_310.method_1551();
            if (object != null && ((File)(object = new File(((class_310)object).field_1697, "water_config_" + this.configs.get(this.sel) + ".txt"))).exists()) {
                ((File)object).delete();
            }
        }
        catch (Exception exception) {}
        this.configs.remove(this.sel);
        if (this.sel >= this.configs.size()) {
            this.sel = Math.max(0, this.configs.size() - 1);
        }
        this.setStatus("Config deleted.", -1096636);
    }

    private void doReset() {
        ModuleManager.INSTANCE.getModules().forEach(module -> {
            if (module.isEnabled()) {
                module.toggle();
            }
        });
        this.setStatus("All modules disabled!", -680437);
    }

    private void doShare() {
        ConfigShare configShare = ConfigShare.a();
        if (configShare == null) {
            return;
        }
        if (!this.configs.isEmpty() && this.sel < this.configs.size()) {
            ModuleManager.INSTANCE.e(this.configs.get(this.sel));
        }
        ModuleManager.INSTANCE.f();
        this.setStatus("Uploading...", -680437);
        configShare.a(() -> {
            if (configShare.d.isEmpty()) {
                this.setStatus("Code copied: " + configShare.c, -14498466);
            } else {
                this.setStatus(configShare.d, -1096636);
            }
        });
    }

    private void doImport() {
        if (this.importCode.trim().isEmpty()) {
            this.setStatus("Paste a code first!", -1096636);
            return;
        }
        ConfigShare configShare = ConfigShare.a();
        if (configShare == null) {
            return;
        }
        this.setStatus("Loading...", -680437);
        configShare.a(this.importCode.trim(), () -> {
            this.importOpen = false;
            if (configShare.d.isEmpty()) {
                this.setStatus("Config imported!", -14498466);
            } else {
                this.setStatus(configShare.d, -1096636);
            }
        });
    }

    private void doCreate() {
        if (this.configs.size() >= 5) {
            this.setStatus("Max 5 configs!", -1096636);
            return;
        }
        if (this.newName.trim().isEmpty()) {
            this.setStatus("Enter a name first!", -1096636);
            return;
        }
        String string = this.newName.trim();
        ModuleManager.INSTANCE.e(string);
        ModuleManager.INSTANCE.f();
        if (!this.configs.contains(string)) {
            this.configs.add(string);
        }
        this.newOpen = false;
        this.newName = "";
        this.sel = this.configs.indexOf(string);
        this.setStatus("\"" + string + "\" saved!", -14498466);
    }

    private void refreshConfigs() {
        this.configs.clear();
        try {
            File[] fileArray = class_310.method_1551();
            if (fileArray != null && (fileArray = fileArray.field_1697.listFiles(file -> file.isFile() && file.getName().startsWith("water_config_") && file.getName().endsWith(".txt"))) != null) {
                for (File file2 : fileArray) {
                    this.configs.add(file2.getName().replace("water_config_", "").replace(".txt", ""));
                }
            }
        }
        catch (Exception exception) {}
        this.sel = 0;
    }

    private void setStatus(String string, int n) {
        this.status = string;
        this.statusCol = n;
        this.statusAt = System.currentTimeMillis();
    }

    private boolean hov(int n, int n2, int n3, int n4, int n5, int n6) {
        return n >= n3 && n <= n3 + n5 && n2 >= n4 && n2 <= n4 + n6;
    }

    private Map<String, Boolean> snapshotEnabled() {
        HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
        for (Module module : ModuleManager.INSTANCE.getModules()) {
            hashMap.put(module.getName(), module.isEnabled());
        }
        return hashMap;
    }

    private void syncModuleLifecycle(Map<String, Boolean> map, Map<String, Boolean> map2) {
        for (Module module : ModuleManager.INSTANCE.getModules()) {
            boolean bl;
            boolean bl2 = map.getOrDefault(module.getName(), false);
            if (bl2 == (bl = map2.getOrDefault(module.getName(), false).booleanValue())) continue;
            try {
                if (bl) {
                    module.onEnable();
                    continue;
                }
                module.onDisable();
            }
            catch (Throwable throwable) {}
        }
    }

    public boolean method_25421() {
        return false;
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    private static enum a {
        CONFIGS,
        SHARE;

    }
}

