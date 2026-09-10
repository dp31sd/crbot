/*
 * Decompiled with CFR 0.152.
 */
package com.water.gui;

import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.client.WaterPlus;
import com.water.module.modules.render.StorageESP;
import com.water.setting.BlocksSetting;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public final class BlockSelectionScreen
extends class_437 {
    private static final int field_0 = 320;
    private static final int field_1 = 300;
    private static final int PAD = 10;
    private static final int HEAD_H = 34;
    private static final int FOOT_H = 36;
    private static final int TAB_H = 24;
    private static final int SRCH_H = 22;
    private static final int CELL = 22;
    private static final int GAP = 3;
    private static final int COLS = 9;
    private static final int CP_W = 140;
    private static final int CP_H = 130;
    private static final int CP_SV = 90;
    private static final int CP_HUE = 12;
    private static final int CP_GAP = 6;
    private static final int C_BD_IN = -15327184;
    private static final int C_TEXT = -2234128;
    private static final int C_TEXT_DIM = -7824982;
    private static final int C_MUTED = -12298906;
    private static final int C_RED = -2539435;
    private static final int C_GRID_BG = -16183270;
    private static final int C_CELL_BG = -15656928;
    private static final int C_CELL_HOV = -15063498;
    private static final int C_CELL_SEL = -15785936;
    private static final int C_WHITE_10 = 0x10FFFFFF;
    private final class_437 parent;
    private final Module module;
    private final BlocksSetting setting;
    private final Map<class_2248, Color> colorMap;
    private final Consumer<Map<class_2248, Color>> colorSaveCallback;
    private final Map<class_2248, Color> builtinColors = new LinkedHashMap<class_2248, Color>();
    private final Set<class_2248> builtinBlocks = new LinkedHashSet<class_2248>();
    private final Set<class_2248> sel = new LinkedHashSet<class_2248>();
    private final List<class_2248> all = new ArrayList<class_2248>();
    private List<class_2248> filtered = new ArrayList<class_2248>();
    private String search = "";
    private boolean showSel = false;
    private int scroll = 0;
    private long openNs = 0L;
    private class_2248 cpBlock = null;
    private boolean cpBuiltin = false;
    private int cpX;
    private int cpY;
    private boolean cpDragSV = false;
    private boolean cpDragHue = false;

    public BlockSelectionScreen(class_437 class_4372, Module module, BlocksSetting blocksSetting) {
        this(class_4372, module, blocksSetting, new LinkedHashMap<class_2248, Color>(), null);
    }

    public BlockSelectionScreen(class_437 object, Module module, BlocksSetting blocksSetting, Map<class_2248, Color> map, Consumer<Map<class_2248, Color>> consumer) {
        super((class_2561)class_2561.method_43470((String)""));
        this.parent = object;
        this.module = module;
        this.setting = blocksSetting;
        this.colorMap = new LinkedHashMap<class_2248, Color>(map);
        this.colorSaveCallback = consumer;
        if (module instanceof StorageESP) {
            object = (StorageESP)module;
            this.builtinColors.putAll(object.c());
            this.builtinBlocks.addAll(this.builtinColors.keySet());
        }
        this.sel.addAll(blocksSetting.getSelectedBlocks());
        this.all.addAll(blocksSetting.getAvailableBlocks());
        this.all.removeIf(class_22482 -> class_22482 == null || class_22482 == class_2246.field_10124 || new class_1799((class_1935)class_22482).method_7960());
        this.all.sort(Comparator.comparing(blocksSetting::getDisplayName, String.CASE_INSENSITIVE_ORDER));
        this.rebuild();
    }

    private int method_0() {
        return (this.field_22789 - 320) / 2;
    }

    private int method_1() {
        return (this.field_22790 - 300) / 2;
    }

    private int method_2() {
        return this.px() + 10;
    }

    private int method_3() {
        return this.py() + 34 + 24 + 22 + 6;
    }

    private int method_4() {
        return 300;
    }

    private int method_5() {
        return 172;
    }

    private int mxR() {
        return Math.max(1, this.gh() / 25);
    }

    private int totR() {
        return (int)Math.ceil((double)this.visibleList().size() / 9.0);
    }

    private int mxSc() {
        return Math.max(0, this.totR() - this.mxR());
    }

    private List<class_2248> visibleList() {
        return this.showSel ? this.selectedList() : this.filtered;
    }

    private List<class_2248> selectedList() {
        ArrayList<class_2248> arrayList = new ArrayList<class_2248>(this.builtinBlocks);
        for (class_2248 class_22482 : this.sel) {
            if (this.builtinBlocks.contains(class_22482)) continue;
            arrayList.add(class_22482);
        }
        return arrayList;
    }

    private void rebuild() {
        this.rebuild(false);
    }

    private void rebuild(boolean bl) {
        if (this.search.isBlank()) {
            this.filtered = new ArrayList<class_2248>(this.all);
        } else {
            String string = this.search.trim().toLowerCase();
            this.filtered = new ArrayList<class_2248>();
            for (class_2248 class_22482 : this.all) {
                if (!this.setting.getDisplayName(class_22482).toLowerCase().contains(string)) continue;
                this.filtered.add(class_22482);
            }
        }
        this.scroll = !bl ? 0 : Math.max(0, Math.min(this.mxSc(), this.scroll));
    }

    private Color getColor(class_2248 class_22483) {
        if (this.builtinColors.containsKey(class_22483)) {
            return this.builtinColors.get(class_22483);
        }
        return this.colorMap.computeIfAbsent(class_22483, class_22482 -> this.randomColor());
    }

    private void setColor(class_2248 class_22482, Color color) {
        if (this.builtinColors.containsKey(class_22482)) {
            this.builtinColors.put(class_22482, color);
        } else {
            this.colorMap.put(class_22482, color);
        }
    }

    private Color randomColor() {
        int n = Color.HSBtoRGB((float)Math.random(), 0.75f, 1.0f);
        return new Color(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, 200);
    }

    private boolean isSelected(class_2248 class_22482) {
        return this.builtinBlocks.contains(class_22482) || this.sel.contains(class_22482);
    }

    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        boolean bl;
        int n3;
        int n4;
        int n5;
        int n6;
        if (this.openNs == 0L) {
            this.openNs = System.nanoTime();
        }
        f = this.easeOut(Math.min(1.0f, (float)(System.nanoTime() - this.openNs) / 1.6E8f));
        int n7 = this.px();
        int n8 = this.py();
        int n9 = WaterPlus.getAccentARGB();
        int n10 = WaterPlus.getBackgroundARGB();
        float f2 = WaterPlus.getGuiRoundness();
        float f3 = Math.max(5.0f, f2 * 0.6f);
        float f4 = Math.max(4.0f, f2 * 0.4f);
        float f5 = WaterPlus.getGlassIntensity();
        class_3322.method_25294(0, 0, this.field_22789, this.field_22790, this.as(-2013265920, f));
        GuiRenderer.a((class_332)class_3322, (float)(n7 - 4), (float)(n8 - 4), (float)328.0f, (float)308.0f, (float)(f2 + 3.0f), (int)this.as(BlockSelectionScreen.gc((int)(n9 & 0xFFFFFF), (int)((int)(28.0f * f))), 1.0f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n7, (float)n8, (float)320.0f, (float)300.0f, (float)f2, (int)this.as(n10, f), (boolean)false);
        if (f5 > 0.01f) {
            GuiRenderer.a((class_332)class_3322, (float)(n7 + 1), (float)(n8 + 1), (float)318.0f, (float)36.0f, (float)f2, (int)this.as(BlockSelectionScreen.gc((int)0xFFFFFF, (int)((int)(16.0f * f5))), f), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n7, (float)n8, (float)320.0f, (float)300.0f, (float)f2, (float)1.0f, (int)this.as(BlockSelectionScreen.gc((int)0xFFFFFF, (int)((int)(55.0f * f5))), f), (boolean)false);
        } else {
            GuiRenderer.a((class_332)class_3322, (float)n7, (float)n8, (float)320.0f, (float)300.0f, (float)f2, (float)1.0f, (int)this.as(n9 & 0xFFFFFF | 0x55000000, f), (boolean)false);
        }
        GuiRenderer.a((class_332)class_3322, (float)n7, (float)n8, (float)320.0f, (float)34.0f, (float)f2, (float)f2, (float)0.0f, (float)0.0f, (boolean)false, (int[])new int[]{this.as(BlockSelectionScreen.gc((int)0, (int)55), f)});
        class_3322.method_25294(n7, n8 + 34, n7 + 320, n8 + 34 + 1, this.as(-15327184, f));
        GuiRenderer.a((class_332)class_3322, (float)n7, (float)(n8 + 8), (float)3.0f, (float)18.0f, (float)1.5f, (int)this.as(n9, f), (boolean)false);
        String string = (this.setting.getName() + " \u2014 " + (this.module == null ? "" : this.module.getName())).toUpperCase();
        this.ft(class_3322, string, n7 + 10 + 8, n8 + 10, this.as(-2234128, f));
        int n11 = this.builtinBlocks.size() + this.sel.size();
        this.ft(class_3322, n11 + " selected", n7 + 10 + 8, n8 + 22, this.as(-7824982, f));
        n11 = n8 + 34 + 4;
        int n12 = n7 + 10;
        int n13 = n12 + 145 + 10;
        this.drawTab(class_3322, n12, n11, 145, 18, "ALL", !this.showSel, this.hov(n, n2, n12, n11, 145, 18), f, n9);
        this.drawTab(class_3322, n13, n11, 145, 18, "SELECTED (" + (this.builtinBlocks.size() + this.sel.size()) + ")", this.showSel, this.hov(n, n2, n13, n11, 145, 18), f, n9);
        if (!this.showSel) {
            n11 = n8 + 34 + 24 + 2;
            n13 = !this.search.isEmpty() ? 1 : 0;
            GuiRenderer.a((class_332)class_3322, (float)n12, (float)n11, (float)300.0f, (float)20.0f, (float)f3, (int)this.as(-16183270, f), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n12, (float)n11, (float)300.0f, (float)20.0f, (float)f3, (float)1.0f, (int)this.as(n13 != 0 ? n9 & 0xFFFFFF | 0x66000000 : -15327184, f), (boolean)false);
            this.ft(class_3322, n13 != 0 ? "\u2315  " + this.search + "_" : "\u2315  Search blocks...", n12 + 8, n11 + 11 - 5, this.as(n13 != 0 ? -2234128 : -12298906, f));
        } else {
            n11 = n8 + 34 + 24 + 2;
            this.ft(class_3322, "Right-click a block to change its color", n12 + 4, n11 + 11 - 5, this.as(-12298906, f));
        }
        List<class_2248> list = this.visibleList();
        n13 = this.gx();
        int n14 = this.gy();
        int n15 = this.gw();
        int n16 = this.gh();
        GuiRenderer.a((class_332)class_3322, (float)(n13 - 3), (float)(n14 - 3), (float)(n15 + 6), (float)(n16 + 6), (float)f3, (int)this.as(-16183270, f), (boolean)false);
        String string2 = null;
        int n17 = 0;
        int n18 = 0;
        int n19 = this.mxR();
        for (n6 = 0; n6 < n19; ++n6) {
            for (n5 = 0; n5 < 9 && (n4 = (n6 + this.scroll) * 9 + n5) < list.size(); ++n5) {
                class_2248 class_22482 = list.get(n4);
                n4 = n13 + n5 * 25;
                n3 = n14 + n6 * 25;
                boolean bl2 = this.isSelected(class_22482);
                bl = this.builtinBlocks.contains(class_22482);
                boolean bl3 = this.hov(n, n2, n4, n3, 22, 22);
                GuiRenderer.a((class_332)class_3322, (float)n4, (float)n3, (float)22.0f, (float)22.0f, (float)f4, (int)this.as(bl2 ? -15785936 : (bl3 ? -15063498 : -15656928), f), (boolean)false);
                if (bl2) {
                    Color color = this.getColor(class_22482);
                    int n20 = (int)(50.0f * f) << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
                    GuiRenderer.a((class_332)class_3322, (float)n4, (float)n3, (float)22.0f, (float)22.0f, (float)f4, (int)n20, (boolean)false);
                    n20 = (int)(255.0f * f) << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
                    GuiRenderer.a((class_332)class_3322, (float)n4, (float)n3, (float)22.0f, (float)22.0f, (float)f4, (float)(class_22482 == this.cpBlock ? 2.0f : 1.5f), (int)n20, (boolean)false);
                    GuiRenderer.a((class_332)class_3322, (float)(n4 + 22 - 7), (float)(n3 + 22 - 7), (float)6.0f, (float)6.0f, (float)3.0f, (int)this.as(-16777216, f), (boolean)false);
                    GuiRenderer.a((class_332)class_3322, (float)(n4 + 22 - 6), (float)(n3 + 22 - 6), (float)4.0f, (float)4.0f, (float)2.0f, (int)this.as(0xFF000000 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue(), f), (boolean)false);
                    if (bl) {
                        GuiRenderer.a((class_332)class_3322, (float)(n4 + 1), (float)(n3 + 1), (float)5.0f, (float)5.0f, (float)2.0f, (int)this.as(n9 & 0xFFFFFF | 0xAA000000, f), (boolean)false);
                    }
                } else if (bl3) {
                    GuiRenderer.a((class_332)class_3322, (float)n4, (float)n3, (float)22.0f, (float)22.0f, (float)f4, (float)1.0f, (int)this.as(n9 & 0xFFFFFF | 0x44000000, f), (boolean)false);
                }
                class_1799 class_17992 = new class_1799((class_1935)class_22482);
                if (!class_17992.method_7960()) {
                    class_3322.method_51427(class_17992, n4 + 3, n3 + 3);
                }
                if (!bl3) continue;
                string2 = this.setting.getDisplayName(class_22482) + (bl ? " [built-in]" : "");
                n17 = n4;
                n18 = n3;
            }
        }
        if (string2 != null) {
            String string3 = string2 + "  [RMB: color]";
            n5 = this.fw(string3) + 10;
            n4 = Math.min(n17, n13 + n15 - n5);
            int n21 = n18 - 15;
            if (n21 < n14) {
                n21 = n18 + 22 + 2;
            }
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n21, (float)n5, (float)13.0f, (float)f4, (int)this.as(-16117736, f), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n4, (float)n21, (float)n5, (float)13.0f, (float)f4, (float)1.0f, (int)this.as(-15327184, f), (boolean)false);
            this.ft(class_3322, string3, n4 + 5, n21 + 2, this.as(-2234128, f));
        }
        if (list.isEmpty()) {
            this.ft(class_3322, "No blocks", n13 + n15 / 2 - this.fw("No blocks") / 2, n14 + n16 / 2 - 5, this.as(-12298906, f));
        }
        if (this.totR() > this.mxR()) {
            n6 = n13 + n15 + 2;
            float f6 = Math.max(16.0f, (float)(n16 * this.mxR()) / (float)this.totR());
            float f7 = (float)n14 + ((float)n16 - f6) * ((float)this.scroll / (float)Math.max(1, this.mxSc()));
            GuiRenderer.a((class_332)class_3322, (float)n6, (float)n14, (float)3.0f, (float)n16, (float)1.5f, (int)this.as(-15327184, f), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n6, (float)((int)f7), (float)3.0f, (float)((int)f6), (float)1.5f, (int)this.as(n9 & 0xFFFFFF | 0xAA000000, f), (boolean)false);
        }
        n6 = n8 + 300 - 36;
        class_3322.method_25294(n7, n6, n7 + 320, n6 + 1, this.as(-15327184, f));
        GuiRenderer.a((class_332)class_3322, (float)n7, (float)n6, (float)320.0f, (float)36.0f, (float)0.0f, (float)0.0f, (float)f2, (float)f2, (boolean)false, (int[])new int[]{this.as(BlockSelectionScreen.gc((int)0, (int)50), f)});
        int n22 = n6 + 7;
        boolean bl4 = this.hov(n, n2, n12, n22, 76, 22);
        GuiRenderer.a((class_332)class_3322, (float)n12, (float)n22, (float)76.0f, (float)22.0f, (float)11.0f, (int)this.as(bl4 ? 869875797 : 349782101, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n12, (float)n22, (float)76.0f, (float)22.0f, (float)11.0f, (float)1.0f, (int)this.as(-2539435, f * (bl4 ? 0.9f : 0.4f)), (boolean)false);
        this.ft(class_3322, "CLEAR ALL", n12 + (76 - this.fw("CLEAR ALL")) / 2, n22 + 7, this.as(-2539435, f));
        int n23 = n7 + 320 - 10 - 66 - 10 - 66;
        n3 = this.hov(n, n2, n23, n22, 66, 22) ? 1 : 0;
        GuiRenderer.a((class_332)class_3322, (float)n23, (float)n22, (float)66.0f, (float)22.0f, (float)11.0f, (int)this.as(n3 != 0 ? 0x18FFFFFF : 0x8FFFFFF, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n23, (float)n22, (float)66.0f, (float)22.0f, (float)11.0f, (float)1.0f, (int)this.as(-15327184, f), (boolean)false);
        this.ft(class_3322, "CANCEL", n23 + (66 - this.fw("CANCEL")) / 2, n22 + 7, this.as(-7824982, f));
        int n24 = n7 + 320 - 10 - 66;
        bl = this.hov(n, n2, n24, n22, 66, 22);
        GuiRenderer.a((class_332)class_3322, (float)n24, (float)n22, (float)66.0f, (float)22.0f, (float)11.0f, (int)this.as(bl ? n9 : n9 & 0xFFFFFF | 0x22000000, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n24, (float)n22, (float)66.0f, (float)22.0f, (float)11.0f, (float)1.5f, (int)this.as(n9, f * (bl ? 1.0f : 0.5f)), (boolean)false);
        this.ft(class_3322, "SAVE", n24 + (66 - this.fw("SAVE")) / 2, n22 + 7, this.as(bl ? -16777216 : n9, f));
        if (this.cpBlock != null) {
            this.drawColorPicker(class_3322, n, n2, f);
        }
    }

    private void drawColorPicker(class_332 class_3322, int n, int n2, float f) {
        float f2;
        int n3;
        int n4;
        n = Math.min(this.cpX, this.px() + 320 - 140 - 6);
        if (n < this.px() + 4) {
            n = this.px() + 4;
        }
        if ((n2 = Math.min(this.cpY, this.py() + 300 - 130 - 6)) < this.py() + 34 + 4) {
            n2 = this.py() + 34 + 4;
        }
        Color color = this.getColor(this.cpBlock);
        float f3 = this.hsb(color)[0];
        float f4 = this.hsb(color)[1];
        float f5 = this.hsb(color)[2];
        float f6 = WaterPlus.getGuiRoundness();
        int n5 = WaterPlus.getAccentARGB();
        GuiRenderer.a((class_332)class_3322, (float)(n - 2), (float)(n2 - 2), (float)144.0f, (float)134.0f, (float)f6, (int)this.as(BlockSelectionScreen.gc((int)0, (int)80), f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)140.0f, (float)130.0f, (float)f6, (int)this.as(WaterPlus.getBackgroundARGB(), f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)140.0f, (float)130.0f, (float)f6, (float)1.0f, (int)this.as(n5 & 0xFFFFFF | 0x88000000, f), (boolean)false);
        int n6 = n + 6;
        n5 = n2 + 6;
        int n7 = n6 + 90 + 6;
        float cfr_ignored_0 = 90.0f / 12.0f;
        float cfr_ignored_1 = 90.0f / 12.0f;
        for (n4 = 0; n4 < 12; ++n4) {
            float f7 = 1.0f - (float)n4 / 12.0f;
            for (n3 = 0; n3 < 12; ++n3) {
                f2 = (float)n3 / 12.0f;
                class_3322.method_25294((int)((float)n6 + (float)n3 * 7.5f), (int)((float)n5 + (float)n4 * 7.5f), (int)((float)n6 + (float)(n3 + 1) * 7.5f), (int)((float)n5 + (float)(n4 + 1) * 7.5f), 0xFF000000 | Color.HSBtoRGB(f3, f2, f7) & 0xFFFFFF);
            }
        }
        GuiRenderer.a((class_332)class_3322, (float)n6, (float)n5, (float)90.0f, (float)90.0f, (float)3.0f, (float)1.0f, (int)this.as(0x44FFFFFF, f), (boolean)false);
        n4 = n6 + (int)(f4 * 90.0f);
        int n8 = n5 + (int)((1.0f - f5) * 90.0f);
        GuiRenderer.a((class_332)class_3322, (float)(n4 - 4), (float)(n8 - 4), (float)8.0f, (float)8.0f, (float)4.0f, (int)this.as(-2013265920, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n4 - 4), (float)(n8 - 4), (float)8.0f, (float)8.0f, (float)4.0f, (float)2.0f, (int)this.as(-1, f), (boolean)false);
        for (n3 = 0; n3 < 90; ++n3) {
            f2 = (float)n3 / 90.0f;
            class_3322.method_25294(n7, n5 + n3, n7 + 12, n5 + n3 + 1, 0xFF000000 | Color.HSBtoRGB(f2, 1.0f, 1.0f) & 0xFFFFFF);
        }
        GuiRenderer.a((class_332)class_3322, (float)n7, (float)n5, (float)12.0f, (float)90.0f, (float)3.0f, (float)1.0f, (int)this.as(0x44FFFFFF, f), (boolean)false);
        n3 = n5 + (int)(f3 * 90.0f);
        GuiRenderer.a((class_332)class_3322, (float)(n7 - 2), (float)(n3 - 1), (float)16.0f, (float)3.0f, (float)1.5f, (int)this.as(-1, f), (boolean)false);
        int n9 = n5 + 90 + 6;
        int n10 = 0xFF000000 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
        GuiRenderer.a((class_332)class_3322, (float)n6, (float)n9, (float)52.0f, (float)10.0f, (float)3.0f, (int)this.as(n10, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n6 + 52 + 4), (float)n9, (float)52.0f, (float)10.0f, (float)3.0f, (int)this.as(n10, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n6, (float)n9, (float)52.0f, (float)10.0f, (float)3.0f, (float)1.0f, (int)this.as(0x44FFFFFF, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n6 + 52 + 4), (float)n9, (float)52.0f, (float)10.0f, (float)3.0f, (float)1.0f, (int)this.as(0x44FFFFFF, f), (boolean)false);
        this.ft(class_3322, this.setting.getDisplayName(this.cpBlock), n + 6, n2 + 130 - 14, this.as(-7824982, f));
    }

    private float[] hsb(Color color) {
        return Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
    }

    private int cpSvX() {
        int n = Math.min(this.cpX, this.px() + 320 - 140 - 6);
        if (n < this.px() + 4) {
            n = this.px() + 4;
        }
        return n + 6;
    }

    private int cpSvY() {
        int n = Math.min(this.cpY, this.py() + 300 - 130 - 6);
        if (n < this.py() + 34 + 4) {
            n = this.py() + 34 + 4;
        }
        return n + 6;
    }

    private int cpHueX() {
        return this.cpSvX() + 90 + 6;
    }

    private void updateSV(int n, int n2) {
        if (this.cpBlock == null) {
            return;
        }
        Color color = this.getColor(this.cpBlock);
        float f = Math.max(0.0f, Math.min(1.0f, (float)(n - this.cpSvX()) / 90.0f));
        float f2 = 1.0f - Math.max(0.0f, Math.min(1.0f, (float)(n2 - this.cpSvY()) / 90.0f));
        int n3 = Color.HSBtoRGB(this.hsb(color)[0], f, f2);
        this.setColor(this.cpBlock, new Color(n3 >> 16 & 0xFF, n3 >> 8 & 0xFF, n3 & 0xFF, color.getAlpha()));
    }

    private void updateHue(int n) {
        if (this.cpBlock == null) {
            return;
        }
        Color color = this.getColor(this.cpBlock);
        float f = Math.max(0.0f, Math.min(1.0f, (float)(n - this.cpSvY()) / 90.0f));
        int n2 = Color.HSBtoRGB(f, this.hsb(color)[1], this.hsb(color)[2]);
        this.setColor(this.cpBlock, new Color(n2 >> 16 & 0xFF, n2 >> 8 & 0xFF, n2 & 0xFF, color.getAlpha()));
    }

    public boolean method_25402(class_11909 class_119092, boolean n) {
        int n2 = (int)class_119092.comp_4798();
        int n3 = (int)class_119092.comp_4799();
        int n4 = class_119092.method_74245();
        int n5 = this.px();
        int n6 = this.py();
        if (this.cpBlock != null) {
            int n7;
            int n8 = this.cpSvX();
            int n9 = this.cpSvY();
            int n10 = this.cpHueX();
            if (n4 == 0) {
                if (this.hov(n2, n3, n8, n9, 90, 90)) {
                    this.updateSV(n2, n3);
                    this.cpDragSV = true;
                    return true;
                }
                if (this.hov(n2, n3, n10, n9, 12, 90)) {
                    this.updateHue(n3);
                    this.cpDragHue = true;
                    return true;
                }
            }
            if ((n7 = Math.min(this.cpX, n5 + 320 - 140 - 6)) < n5 + 4) {
                n7 = n5 + 4;
            }
            if ((n8 = Math.min(this.cpY, n6 + 300 - 130 - 6)) < n6 + 34 + 4) {
                n8 = n6 + 34 + 4;
            }
            if (!this.hov(n2, n3, n7 - 2, n8 - 2, 144, 134)) {
                this.cpBlock = null;
                this.cpDragSV = false;
                this.cpDragHue = false;
            }
            return true;
        }
        int n11 = n6 + 34 + 4;
        int n12 = n5 + 10;
        int n13 = n12 + 145 + 10;
        if (this.hov(n2, n3, n12, n11, 145, 18)) {
            this.showSel = false;
            this.scroll = 0;
            this.rebuild();
            return true;
        }
        if (this.hov(n2, n3, n13, n11, 145, 18)) {
            this.showSel = true;
            this.scroll = 0;
            this.rebuild();
            return true;
        }
        if (n2 >= this.gx() && n2 < this.gx() + this.gw() && n3 >= this.gy() && n3 < this.gy() + this.gh()) {
            List<class_2248> list = this.visibleList();
            n6 = (n2 - this.gx()) / 25;
            int n14 = (n3 - this.gy()) / 25 + this.scroll;
            n = n14 * 9 + n6;
            if (n6 < 9 && n >= 0 && n < list.size()) {
                class_2248 class_22482 = list.get(n);
                n2 = this.builtinBlocks.contains(class_22482) ? 1 : 0;
                if (n4 == 0 && n2 == 0) {
                    if (this.sel.contains(class_22482)) {
                        this.sel.remove(class_22482);
                    } else {
                        this.sel.add(class_22482);
                        this.getColor(class_22482);
                    }
                    this.rebuild(true);
                } else if (n4 == 1 && this.isSelected(class_22482)) {
                    n3 = this.gx() + n6 * 25;
                    n14 = this.gy() + (n14 - this.scroll) * 25;
                    this.cpX = n3 + 22 + 4;
                    this.cpY = n14 - 4;
                    this.cpBlock = class_22482;
                    this.cpBuiltin = n2;
                    this.cpDragSV = false;
                    this.cpDragHue = false;
                }
            }
            return true;
        }
        n11 = n6 + 300 - 36;
        if (this.hov(n2, n3, n12, n6 = n11 + 7, 76, 22)) {
            this.sel.clear();
            this.colorMap.clear();
            this.rebuild();
            return true;
        }
        if (this.hov(n2, n3, n5 + 320 - 10 - 66 - 10 - 66, n6, 66, 22)) {
            this.field_22787.method_1507(this.parent);
            return true;
        }
        if (this.hov(n2, n3, n5 + 320 - 10 - 66, n6, 66, 22)) {
            this.saveAndClose();
            return true;
        }
        return super.method_25402(class_119092, n != 0);
    }

    public boolean method_25403(class_11909 class_119092, double d2, double d3) {
        int n = (int)class_119092.comp_4798();
        int n2 = (int)class_119092.comp_4799();
        if (this.cpDragSV) {
            this.updateSV(n, n2);
            return true;
        }
        if (this.cpDragHue) {
            this.updateHue(n2);
            return true;
        }
        return super.method_25403(class_119092, d2, d3);
    }

    public boolean method_25406(class_11909 class_119092) {
        this.cpDragSV = false;
        this.cpDragHue = false;
        return super.method_25406(class_119092);
    }

    public boolean method_25401(double d2, double d3, double d4, double d5) {
        if (d2 >= (double)this.gx() && d2 < (double)(this.gx() + this.gw()) && d3 >= (double)this.gy() && d3 < (double)(this.gy() + this.gh())) {
            this.scroll = Math.max(0, Math.min(this.mxSc(), this.scroll + (d5 > 0.0 ? -1 : 1)));
            return true;
        }
        return super.method_25401(d2, d3, d4, d5);
    }

    public boolean method_25400(class_11905 class_119052) {
        if (this.cpBlock != null) {
            return true;
        }
        String string = class_119052.method_74226();
        if (string != null && !string.isEmpty() && !this.showSel) {
            this.search = this.search + string;
            this.rebuild();
            return true;
        }
        return super.method_25400(class_119052);
    }

    public boolean method_25404(class_11908 class_119082) {
        if (this.cpBlock != null) {
            if (class_119082.method_74231()) {
                this.cpBlock = null;
            }
            return true;
        }
        if (class_119082.method_74228() == 259 && !this.search.isEmpty()) {
            this.search = this.search.substring(0, this.search.length() - 1);
            this.rebuild();
            return true;
        }
        if (class_119082.method_74231()) {
            this.saveAndClose();
            return true;
        }
        return super.method_25404(class_119082);
    }

    public boolean method_25421() {
        return false;
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    /*
     * WARNING - void declaration
     */
    private void drawTab(class_332 class_3322, int n, int n2, int n3, int n4, String string, boolean bl, boolean bl2, float f, int n5) {
        void var8_9;
        void var9_11;
        void var10_12;
        int n6 = bl ? this.as((int)(var10_12 & 0xFFFFFF | 0x1A000000), (float)var9_11) : (var8_9 != false ? this.as(0x10FFFFFF, (float)var9_11) : this.as(0x8FFFFFF, (float)var9_11));
        int n7 = bl ? this.as((int)(var10_12 & 0xFFFFFF | 0x55000000), (float)var9_11) : this.as(-15327184, (float)var9_11);
        int n8 = bl ? this.as((int)var10_12, (float)var9_11) : this.as(-7824982, (float)var9_11);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n3, (float)n4, (float)((float)n4 / 2.0f), (int)n6, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n3, (float)n4, (float)((float)n4 / 2.0f), (float)1.0f, (int)n7, (boolean)false);
        this.ft(class_3322, string, n + (n3 - this.fw(string)) / 2, n2 + n4 / 2 - 5, n8);
    }

    private void method_6(class_332 class_3322, String string, int n, int n2, int n3) {
        WaterFontRenderer.INSTANCE.a(class_3322, string, n, n2, n3);
    }

    private int method_7(String string) {
        return WaterFontRenderer.INSTANCE.a(string);
    }

    private int method_8(int n, float f) {
        return Math.max(0, Math.min(255, (int)((float)(n >> 24 & 0xFF) * f))) << 24 | n & 0xFFFFFF;
    }

    private static int method_9(int n, int n2) {
        return Math.max(0, Math.min(255, n2)) << 24 | n & 0xFFFFFF;
    }

    private float easeOut(float f) {
        return 1.0f - (float)Math.pow(1.0f - Math.min(1.0f, f), 3.0);
    }

    private boolean hov(int n, int n2, int n3, int n4, int n5, int n6) {
        return n >= n3 && n <= n3 + n5 && n2 >= n4 && n2 <= n4 + n6;
    }

    private void saveAndClose() {
        this.setting.setValue((Set<class_2248>)new LinkedHashSet<class_2248>(this.sel));
        Iterator<Map.Entry<class_2248, Color>> iterator = this.module;
        if (iterator instanceof StorageESP) {
            StorageESP storageESP = (StorageESP)((Object)iterator);
            iterator = new LinkedHashMap<class_2248, Color>(this.colorMap);
            for (Map.Entry<class_2248, Color> entry : this.builtinColors.entrySet()) {
                iterator.put(entry.getKey(), entry.getValue());
            }
            storageESP.b((Map)((Object)iterator));
            ModuleManager.INSTANCE.f();
            this.field_22787.method_1507(this.parent);
            return;
        }
        if (this.colorSaveCallback != null) {
            this.colorSaveCallback.accept(new LinkedHashMap<class_2248, Color>(this.colorMap));
        }
        if ((iterator = this.module) instanceof StorageESP) {
            StorageESP storageESP = (StorageESP)((Object)iterator);
            for (Map.Entry<class_2248, Color> entry : this.builtinColors.entrySet()) {
                storageESP.a(entry.getKey(), entry.getValue());
            }
        }
        ModuleManager.INSTANCE.f();
        this.field_22787.method_1507(this.parent);
    }
}

