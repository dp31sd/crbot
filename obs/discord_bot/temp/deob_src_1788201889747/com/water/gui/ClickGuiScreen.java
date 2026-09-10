/*
 * Decompiled with CFR 0.152.
 */
package com.water.gui;

import com.water.gui.BlockSelectionScreen;
import com.water.gui.ChatMacroScreen;
import com.water.gui.ConfigManagerScreen;
import com.water.module.ActivatableModule;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.client.ConfigShare;
import com.water.module.modules.client.WaterPlus;
import com.water.module.modules.render.ExtraESP;
import com.water.module.modules.render.StorageESP;
import com.water.setting.BlocksSetting;
import com.water.setting.MobsSetting;
import com.water.setting.ModeSetting;
import com.water.setting.Setting;
import com.water.utils.renderer.Blur2DRenderer;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_1299;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1826;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.joml.Matrix3x2fStack;
import org.lwjgl.glfw.GLFW;

public class ClickGuiScreen
extends class_437 {
    private static final Category[] CACHED_CATEGORIES = Category.values();
    private static final int SLIDER_TRACK_COLOR_ARGB = -15198181;
    private static final int PANEL_W = 140;
    private static final int PANEL_PAD = 10;
    private static final int PANEL_HEADER_H = 22;
    private static final int PANEL_GAP = 12;
    private static final int PANEL_HEADER_SPACING = 6;
    private static final int ROW_H = 17;
    private static final int ROW_STEP = 19;
    private static final int SEARCH_H = 20;
    private static final int COLOR_PICKER_SV_SIZE = 80;
    private static final int COLOR_PICKER_HUE_W = 16;
    private static final int COLOR_PICKER_GAP = 6;
    private static final int COLOR_PICKER_PREVIEW_H = 14;
    private static final int COLOR_PICKER_BOTTOM_PAD = 6;
    private static final int COLOR_PICKER_FIELD_HEIGHT = 80;
    private static final int COLOR_PICKER_ALPHA_HEIGHT = 10;
    private static final int COLOR_PICKER_EXTRA_HEIGHT = 112;
    private static final int BLOCK_PICKER_SEARCH_H = 16;
    private static final int BLOCK_PICKER_ROW_H = 18;
    private static final int BLOCK_PICKER_VISIBLE_ROWS = 5;
    private static final int BLOCK_PICKER_GAP = 6;
    private static final int BLOCK_PICKER_CLEAR_W = 30;
    private static final int BLOCK_PICKER_BOTTOM_PAD = 6;
    private static final float BLOCK_PICKER_SCROLLBAR_W = 4.0f;
    private static final float BLOCK_PICKER_INDICATOR_SIZE = 6.0f;
    private static final float BLOCK_PICKER_TEXT_SCALE = 0.9f;
    private static final int COLOR_SCREEN_BG = -15987700;
    private static int COLOR_PANEL_BG = -15987700;
    private static final int COLOR_PANEL_OUTLINE = -14671840;
    private static final int COLOR_HEADER_BG = 0;
    private static final int COLOR_ROW_BG = 0;
    private static final int COLOR_ROW_HOVER = 0xAFFFFFF;
    private static final int COLOR_ROW_ACTIVE = 0;
    private static final int COLOR_TEXT = -1;
    private static final int COLOR_TEXT_MUTED = -1073741825;
    private static int COLOR_ACCENT = -6862849;
    private static int COLOR_ACCENT_DIM = -8767028;
    private static final int COLOR_DIVIDER = 0xFFFFFFF;
    private static final int COLOR_SEARCH_OUTLINE = -14671840;
    private static final int COLOR_ROW_OUTLINE = 0;
    private static final int COLOR_KEY_BG = -15198181;
    private static final int SCROLL_STEP = 24;
    private static final EnumMap<Category, class_2960> CATEGORY_TEXTURES = new EnumMap(Category.class);
    private Module listeningBind = null;
    private ActivatableModule listeningActivationBind = null;
    private Setting<String> listeningString = null;
    private boolean listeningGuiKey = false;
    private Setting<String> expandedStringListSetting = null;
    private boolean stringListAddActive = false;
    private String stringListAddBuffer = "";
    private Setting<Color> expandedColorSetting = null;
    private Setting<Color> activeColorSetting = null;
    private BlocksSetting expandedBlocksSetting = null;
    private MobsSetting expandedMobsSetting = null;
    private c colorDragMode = c.NONE;
    private boolean searchActive = false;
    private boolean blockSearchActive = false;
    private boolean mobSearchActive = false;
    private String searchQuery = "";
    private String blockSearchQuery = "";
    private String mobSearchQuery = "";
    private int mobPickerScroll = 0;
    private int verticalScroll = 0;
    private int blockPickerScroll = 0;
    private float uiScale = 1.0f;
    private Setting<?> draggingNumericSetting = null;
    private Module draggingNumericModule = null;
    private int draggingNumericCatX = 0;
    private boolean batchingSettingDrag = false;
    private final EnumMap<Category, int[]> categoryOffsets = new EnumMap(Category.class);
    private Category draggingCategory = null;
    private int dragGrabOffsetX = 0;
    private int dragGrabOffsetY = 0;
    private final HashMap<String, Float> animValues = new HashMap();
    private long lastAnimNanos = 0L;
    private float frameDt = 0.016666668f;
    private final HashMap<String, Long> moduleOpenTime = new HashMap();
    private static final long MODULE_STAGGER_MS = 35L;
    private static final long MODULE_SLIDE_DURATION_MS = 220L;
    public static ClickGuiScreen INSTANCE;

    private void drawStyledText(class_332 ctx, String s, int x, int y, int color, boolean shadow) {
        WaterFontRenderer.INSTANCE.a(ctx, s, x, y, color);
    }

    private int fontWidth(String s) {
        return WaterFontRenderer.INSTANCE.a(s);
    }

    private String fontTrimToWidth(String s, int maxWidth) {
        if (this.fontWidth(s) <= maxWidth) {
            return s;
        }
        String v3 = "...";
        int i4 = this.fontWidth(v3);
        while (s.length() > 0 && this.fontWidth(s) + i4 > maxWidth) {
            s = s.substring(0, s.length() - 1);
        }
        return s + v3;
    }

    private String titleCase(String s) {
        if (s == null || ((String)s).isEmpty()) {
            return s == null ? "" : s;
        }
        StringBuilder v2 = new StringBuilder(((String)s).length());
        boolean i3 = true;
        for (Object i6 : (Object)((String)s).toCharArray()) {
            if (Character.isLetter((char)i6)) {
                v2.append(i3 ? Character.toUpperCase((char)i6) : Character.toLowerCase((char)i6));
                i3 = false;
                continue;
            }
            v2.append((char)i6);
            i3 = i6 == 32 || i6 == 95 || i6 == 45;
        }
        return v2.toString();
    }

    private void updateAnimDt() {
        long j1 = System.nanoTime();
        if (this.lastAnimNanos != 0L) {
            this.frameDt = Math.min(0.1f, (float)(j1 - this.lastAnimNanos) / 1.0E9f);
        }
        this.lastAnimNanos = j1;
    }

    private float anim(String key, float target, float speed) {
        if (!WaterPlus.animationsEffectivelyEnabled()) {
            this.animValues.put(key, Float.valueOf(target));
            return target;
        }
        float f4 = this.animValues.getOrDefault(key, Float.valueOf(target)).floatValue();
        speed = 1.0f - (float)Math.exp(-speed * WaterPlus.getAnimSpeedMult() * this.frameDt);
        target = f4 + (target - f4) * speed;
        this.animValues.put(key, Float.valueOf(target));
        return target;
    }

    private int getModuleExpandedHeight(Module module) {
        int i2 = 19;
        if (module instanceof ActivatableModule) {
            i2 += 19;
        }
        if ("Config Share".equals(module.getName())) {
            i2 += 19;
        }
        for (Setting<?> v4 : module.getSettings()) {
            Setting v5;
            i2 += 19;
            if (v4 instanceof BlocksSetting && this.expandedBlocksSetting == (v5 = (BlocksSetting)v4)) {
                i2 += this.getBlockPickerExtraHeight((BlocksSetting)v5);
            }
            if (v4 instanceof MobsSetting && this.expandedMobsSetting == (v5 = (MobsSetting)v4)) {
                i2 += this.getMobPickerExtraHeight((MobsSetting)v5);
            }
            if (v4.getValue() instanceof Color && this.expandedColorSetting == v4) {
                i2 += 112;
            }
            if (!this.isStringListSetting(module, v4) || this.expandedStringListSetting != v4) continue;
            i2 += this.getStringListEditorExtraHeight(v4);
        }
        return i2;
    }

    private boolean isStringListSetting(Module module, Setting<?> setting) {
        if (module == null || setting == null || !(setting.getValue() instanceof String)) {
            return false;
        }
        if ("Friends".equalsIgnoreCase(module.getName()) && setting.matchesName("Names")) {
            return true;
        }
        return "TabDetector".equalsIgnoreCase(module.getName()) && setting.matchesName("Target Players");
    }

    private int getStringListEditorExtraHeight(Setting<?> setting) {
        return (Math.min(6, this.parseStringList(setting).size()) + 1) * 19;
    }

    private List<String> parseStringList(Setting<?> setting) {
        if (setting == null || !(((Setting)setting).getValue() instanceof String)) {
            return new ArrayList<String>();
        }
        if ((setting = (String)((Setting)setting).getValue()) == null || ((String)setting).isBlank()) {
            return new ArrayList<String>();
        }
        setting = ((String)setting).replace('\n', ',').replace('\r', ',');
        ArrayList<String> v2 = new ArrayList<String>();
        for (String v5 : ((String)setting).split(",")) {
            String string = v5 = v5 == null ? "" : v5.trim();
            if (v5.isEmpty()) continue;
            v2.add(v5);
        }
        setting = new LinkedHashSet();
        for (String v4 : v2) {
            ((HashSet)setting).add(v4.toLowerCase(Locale.ROOT));
        }
        return new ArrayList<String>((Collection<String>)setting);
    }

    private void setStringListFromLowerList(Setting<String> setting, List<String> lowerNames) {
        if (setting == null) {
            return;
        }
        StringBuilder v3 = new StringBuilder();
        lowerNames = lowerNames.iterator();
        while (lowerNames.hasNext()) {
            String v4 = (String)lowerNames.next();
            v4 = v4 == null ? "" : v4.trim();
            if (v4.isEmpty()) continue;
            if (!v3.isEmpty()) {
                v3.append(", ");
            }
            v3.append(v4);
        }
        setting.setValue(v3.toString());
    }

    private float computeUiScale() {
        int i1 = WaterPlus.menuSizePercent();
        i1 = Math.max(1, Math.min(10, i1));
        return 0.77f + (float)(i1 - 1) * 0.044444446f;
    }

    private double toUiX(double rawX) {
        return rawX / (double)Math.max(1.0E-4f, this.uiScale);
    }

    private double toUiY(double rawY) {
        return rawY / (double)Math.max(1.0E-4f, this.uiScale);
    }

    private int uiWidth() {
        return Math.round((float)this.field_22789 / Math.max(1.0E-4f, this.uiScale));
    }

    private int uiHeight() {
        return Math.round((float)this.field_22790 / Math.max(1.0E-4f, this.uiScale));
    }

    private float getExpandProgress(Module module, String modKey) {
        return this.anim(modKey + "/expand", module.isExpanded() ? 1.0f : 0.0f, 20.0f);
    }

    private static int lerpARGB(int a2, int b2, float t) {
        if (t <= 0.0f) {
            return a2;
        }
        if (t >= 1.0f) {
            return b2;
        }
        int i3 = a2 >>> 24 & 0xFF;
        int i4 = a2 >>> 16 & 0xFF;
        int i5 = a2 >>> 8 & 0xFF;
        int i6 = b2 >>> 24 & 0xFF;
        int i7 = b2 >>> 16 & 0xFF;
        int i8 = b2 >>> 8 & 0xFF;
        return (int)((float)i3 + (float)(i6 - i3) * t) << 24 | (int)((float)i4 + (float)(i7 - i4) * t) << 16 | (int)((float)i5 + (float)(i8 - i5) * t) << 8 | (int)((float)(a2 &= 0xFF) + (float)((b2 &= 0xFF) - a2) * t);
    }

    private int[] getCategoryOffset(Category c2) {
        return this.categoryOffsets.computeIfAbsent(c2, k -> new int[2]);
    }

    private int getCategoryX(Category c2, int index) {
        int i3 = CACHED_CATEGORIES.length * 140 + (CACHED_CATEGORIES.length - 1) * 12;
        i3 = Math.max(10, (this.uiWidth() - i3) / 2);
        return i3 + index * 152 + this.getCategoryOffset(c2)[0];
    }

    private int getCategoryY(Category c2) {
        return this.getContentTop() + this.verticalScroll + this.getCategoryOffset(c2)[1];
    }

    public static void open() {
        class_310 v0 = class_310.method_1551();
        if (v0 == null) {
            return;
        }
        v0.method_1507((class_437)new ClickGuiScreen());
    }

    public ClickGuiScreen() {
        super((class_2561)class_2561.method_43470((String)"Water Menu"));
        INSTANCE = this;
    }

    public void method_25426() {
        super.method_25426();
        this.moduleOpenTime.clear();
    }

    private static int glassCol(int rgb, int alpha) {
        return Math.max(0, Math.min(255, alpha)) << 24 | rgb & 0xFFFFFF;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
        ClickGuiScreen.COLOR_ACCENT = WaterPlus.getAccentARGB();
        ClickGuiScreen.COLOR_ACCENT_DIM = -16777216 | (ClickGuiScreen.COLOR_ACCENT >> 16 & 255) * 4 / 5 << 16 | (ClickGuiScreen.COLOR_ACCENT >> 8 & 255) * 4 / 5 << 8 | (ClickGuiScreen.COLOR_ACCENT & 255) * 4 / 5;
        ClickGuiScreen.COLOR_PANEL_BG = WaterPlus.getBackgroundARGB();
        v4 = WaterPlus.getAccentColor();
        ClickGuiScreen.COLOR_ACCENT_DIM = -16777216 | Math.max(0, v4.getRed() - 30) << 16 | Math.max(0, v4.getGreen() - 35) << 8 | Math.max(0, v4.getBlue() - 20);
        Blur2DRenderer.bm();
        this.updateAnimDt();
        this.uiScale = this.computeUiScale();
        i4 = Math.round((float)mouseX / this.uiScale);
        i5 = Math.round((float)mouseY / this.uiScale);
        context.method_51448().pushMatrix();
        context.method_51448().scale(this.uiScale, this.uiScale);
        this.verticalScroll = this.clampVerticalScroll(this.verticalScroll);
        i6 = Math.min(260, this.uiWidth() - 60);
        i7 = (this.uiWidth() - i6) / 2;
        i8 = this.uiHeight() - 20 - 60;
        v0 = i9 = this.searchActive != false ? ClickGuiScreen.COLOR_ACCENT : ClickGuiScreen.glassCol(0xFFFFFF, 22 + (int)(30.0f * WaterPlus.getGlassIntensity()));
        if (WaterPlus.menuBlurEnabled()) {
            GuiRenderer.a((class_332)context, (float)i7, (float)i8, (float)i6, (float)20.0f, (float)8.0f, (float)1.0f, (boolean)false);
        }
        GuiRenderer.a((class_332)context, (float)i7, (float)i8, (float)i6, (float)20.0f, (float)8.0f, (int)ClickGuiScreen.COLOR_PANEL_BG, (boolean)false);
        GuiRenderer.a((class_332)context, (float)i7, (float)i8, (float)i6, (float)20.0f, (float)8.0f, (float)1.0f, (int)i9, (boolean)false);
        v9 = this.searchQuery.isEmpty() != false ? "Search modules..." : this.searchQuery;
        i10 = this.searchQuery.isEmpty() != false && this.searchActive == false ? -1073741825 : -1;
        v1 = i11 = System.currentTimeMillis() / 500L % 2L == 0L ? 1 : 0;
        if (this.searchActive && i11 != 0) {
            v9 = v9 + "_";
        }
        this.drawInputTextClipped(context, i7, i8, i6, 20.0f, v9, i7 + 8, i8 + 6, i10);
        v6 = "Configs";
        i7 = this.fontWidth((String)v6) + 18;
        i9 = (this.uiWidth() - i7) / 2;
        i8 = i8 - 14 - 6;
        v2 = i10 = i4 >= i9 && i4 <= i9 + i7 && i5 >= i8 && i5 <= i8 + 14 ? 1 : 0;
        if (WaterPlus.menuBlurEnabled()) {
            GuiRenderer.a((class_332)context, (float)i9, (float)i8, (float)i7, (float)14.0f, (float)7.0f, (float)1.0f, (boolean)false);
        }
        GuiRenderer.a((class_332)context, (float)i9, (float)i8, (float)i7, (float)14.0f, (float)7.0f, (int)ClickGuiScreen.COLOR_PANEL_BG, (boolean)false);
        GuiRenderer.a((class_332)context, (float)i9, (float)i8, (float)i7, (float)14.0f, (float)7.0f, (float)1.0f, (int)(i10 != 0 ? ClickGuiScreen.COLOR_ACCENT : ClickGuiScreen.glassCol(0xFFFFFF, 22 + (int)(30.0f * WaterPlus.getGlassIntensity()))), (boolean)false);
        this.drawStyledText(context, (String)v6, i9 + (i7 - this.fontWidth((String)v6)) / 2, i8 + 3, i10 != 0 ? -1 : -1073741825, false);
        v6 = ClickGuiScreen.CACHED_CATEGORIES;
        for (i7 = 0; i7 < v6.length; ++i7) {
            v8 = v6[i7];
            i9 = this.getCategoryX(v8, i7);
            i10 = this.getCategoryY(v8);
            i11 = this.getPanelHeight(v8);
            f12 = WaterPlus.getAccentGlow();
            i13 = WaterPlus.getAccentARGB();
            f14 = WaterPlus.getEffectiveRoundness();
            v15 = WaterPlus.getHeaderStyle();
            for (i16 = 4; i16 >= 1; --i16) {
                GuiRenderer.a((class_332)context, (float)(i9 - i16), (float)(i10 - i16 + 2), (float)(140 + i16 * 2), (float)(i11 + i16 * 2), (float)(f14 + (float)i16), (int)(10 - i16 * 2 << 24), (boolean)false);
            }
            if (f12 > 0.01f) {
                GuiRenderer.a((class_332)context, (float)(i9 - 3), (float)(i10 - 3), (float)146.0f, (float)(i11 + 6), (float)(f14 + 3.0f), (int)ClickGuiScreen.glassCol(i13 & 0xFFFFFF, (int)(22.0f * f12)), (boolean)false);
            }
            if (WaterPlus.menuBlurEnabled()) {
                GuiRenderer.a((class_332)context, (float)i9, (float)i10, (float)140.0f, (float)i11, (float)f14, (float)1.0f, (boolean)false);
            }
            f16 = WaterPlus.getGlassIntensity();
            GuiRenderer.a((class_332)context, (float)i9, (float)i10, (float)140.0f, (float)i11, (float)f14, (int)ClickGuiScreen.COLOR_PANEL_BG, (boolean)false);
            if (f16 > 0.01f) {
                GuiRenderer.a((class_332)context, (float)(i9 + 1), (float)(i10 + 1), (float)138.0f, (float)24.0f, (float)f14, (int)ClickGuiScreen.glassCol(0xFFFFFF, (int)(16.0f * f16)), (boolean)false);
            }
            GuiRenderer.a((class_332)context, (float)i9, (float)i10, (float)140.0f, (float)i11, (float)f14, (float)1.0f, (int)ClickGuiScreen.glassCol(0xFFFFFF, 22 + (int)(30.0f * f16)), (boolean)false);
            v12 = v15;
            i15 = -1;
            switch (v12.hashCode()) {
                case 80066187: {
                    if (!v12.equals("Solid")) break;
                    i15 = 0;
                    break;
                }
                case 154295120: {
                    if (!v12.equals("Gradient")) break;
                    i15 = 1;
                }
            }
            switch (i15) {
                case 0: {
                    v3 = -15461356;
                    break;
                }
                case 1: {
                    v3 = i13 & 0xFFFFFF | 0x33000000;
                    break;
                }
                default: {
                    v3 = i12 = 0;
                }
            }
            if (i12 != 0) {
                GuiRenderer.a((class_332)context, (float)i9, (float)i10, (float)140.0f, (float)22.0f, (float)f14, (float)f14, (float)6.0f, (float)6.0f, (boolean)false, (int[])new int[]{i12});
            }
            this.drawStyledText(context, this.titleCase(v8.getName()), i9 + 10, i10 + 6, -1, false);
            i15 = i9 + 140 - 10 - 15;
            i12 = i10 + 7 / 2;
            v13 = ClickGuiScreen.CATEGORY_TEXTURES.get((Object)v8);
            if (v13 != null) {
                GuiRenderer.a((class_332)context, (float)i15, (float)i12, (float)15.0f, (class_2960)v13, (int)-1, (float)3.0f, (boolean)false);
            }
            GuiRenderer.a((class_332)context, (float)i9, (float)(i10 + 22 - 2), (float)140.0f, (float)2.0f, (float)0.5f, (int)0x10000000, (boolean)false);
            i11 = i10 + i11;
            WaterFontRenderer.n((int)i11);
            i10 = i10 + 22 + 6;
            v11 = ModuleManager.INSTANCE.getModulesInCategory(v8);
            i12 = 0;
            i13 = 0;
            j42 = System.currentTimeMillis();
            v14 = v11.iterator();
            while (v14.hasNext()) {
                v15 = v14.next();
                if (!this.matchesQuery((Module)v15)) continue;
                v16 = v8.name() + "/" + v15.getName() + "/openTime";
                if (!this.moduleOpenTime.containsKey(v16)) {
                    this.moduleOpenTime.put(v16, j42 + (long)i13 * 35L);
                }
                ++i13;
            }
            v14 = v11.iterator();
            while (v14.hasNext()) {
                v15 = v14.next();
                if (!this.matchesQuery((Module)v15)) continue;
                v16 = v8.name() + "/" + v15.getName() + "/openTime";
                v11 = this.moduleOpenTime.get(v16);
                f13 = 1.0f;
                if (v11 != null) {
                    j49 = System.currentTimeMillis() - v11.longValue();
                    if (j49 < 0L) {
                        f13 = 0.0f;
                    } else {
                        f11 = Math.min(1.0f, (float)j49 / 220.0f);
                        f13 = 1.0f - (float)Math.pow(1.0f - f11, 3.0);
                    }
                }
                i49 = (int)((1.0f - f13) * -14.0f);
                ++i12;
                i50 = i4 >= i9 + 4 && i4 <= i9 + 140 - 4 && i5 >= i10 && i5 <= i10 + 17;
                v11 = v8.name() + "/" + v15.getName();
                f16 = this.anim((String)v11 + "/hover", i50 != false ? 1.0f : 0.0f, 14.0f);
                f17 = this.anim((String)v11 + "/enabled", v15.isEnabled() != false ? 1.0f : 0.0f, 12.0f);
                i18 = ClickGuiScreen.lerpARGB(0, 0xAFFFFFF, f16);
                i19 = ClickGuiScreen.COLOR_ACCENT & 0xFFFFFF | (int)(180.0f * f17) << 24;
                ClickGuiScreen.lerpARGB(i18, i19, f17);
                i18 = ClickGuiScreen.lerpARGB(-1073741825, -1, f16);
                ClickGuiScreen.lerpARGB(i18, -1, f17);
                context.method_51448().pushMatrix();
                context.method_51448().translate(0.0f, (float)i49);
                if (f16 > 0.01f) {
                    GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (int)this.multiplyAlpha(0xAFFFFFF, f16 * f13), (boolean)false);
                }
                if (f17 > 0.01f) {
                    GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (int)this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT, 0.8f * f17 * f13), (boolean)false);
                }
                GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)(i10 + 17), (float)132.0f, (float)1.0f, (float)0.5f, (int)this.multiplyAlpha(0x5FFFFFF, f13), (boolean)false);
                f16 = Math.min(1.0f, 0.75f + 0.25f * f17 + 0.25f * f16);
                i13 = this.withAlpha(-1, f16 * f13);
                i16 = i9 + 10 + Math.round(2.0f * f17);
                if (WaterPlus.moduleIconsEnabled()) {
                    i64 = i16;
                    i65 = i10 + 7 / 2;
                    context.method_51448().pushMatrix();
                    context.method_51448().translate((float)i64, (float)i65);
                    context.method_51448().scale(0.65f, 0.65f);
                    context.method_51427(v15.getModuleIcon(), 0, 0);
                    context.method_51448().popMatrix();
                    i16 = i64 + 10 + 4;
                }
                this.drawStyledText(context, this.titleCase(v15.getName()), i16, i10 + 4, i13, false);
                context.method_51448().popMatrix();
                i10 += 19;
                f13 = this.getExpandProgress((Module)v15, (String)v11);
                i16 = this.getModuleExpandedHeight((Module)v15);
                i64 = Math.round(f13 * (float)i16);
                if (!(f13 > 0.001f)) continue;
                i65 = i10;
                f66 = this.easeOutCubic(f13);
                f67 = -(1.0f - f66) * 4.0f;
                i68 = this.listeningBind == v15 ? 1 : 0;
                f69 = this.clamp01((float)(i64 - (i10 - i65)) / 17.0f);
                f70 = f66 * f69;
                if (!this.animValues.containsKey((String)v11 + "/stagger/bind")) {
                    this.animValues.put((String)v11 + "/stagger/bind", Float.valueOf(-10.0f));
                }
                f71 = this.anim((String)v11 + "/stagger/bind", v15.isExpanded() != false ? 0.0f : -10.0f, 20.0f);
                context.method_51448().pushMatrix();
                context.method_51448().translate(0.0f, f67 + f71);
                GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (int)this.multiplyAlpha(-15198181, f70), (boolean)false);
                GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (float)1.0f, (int)this.multiplyAlpha(0, f70), (boolean)false);
                this.drawStyledText(context, "Bind", i9 + 10, i10 + 4, this.multiplyAlpha(-1073741825, f70), false);
                v72 = i68 != 0 ? "..." : (v15.getBind() == 0 ? "None" : this.getKeyDisplayName(v15.getBind()));
                i73 = this.fontWidth(v72) + 10;
                i74 = i9 + 140 - 10 - i73;
                i75 = i10 + 3;
                i76 = i68 != 0 ? this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT & 0xFFFFFF | -2013265920, f70) : this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT & 0xFFFFFF | 0x33000000, f70);
                GuiRenderer.a((class_332)context, (float)i74, (float)i75, (float)i73, (float)10.0f, (float)Math.max(2.0f, WaterPlus.getEffectiveRoundness() * 0.5f), (int)i76, (boolean)false);
                GuiRenderer.a((class_332)context, (float)i74, (float)i75, (float)i73, (float)10.0f, (float)Math.max(2.0f, WaterPlus.getEffectiveRoundness() * 0.5f), (float)1.0f, (int)this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT & 0xFFFFFF | 0x66000000, f70), (boolean)false);
                this.drawStyledText(context, v72, i74 + 5, i75 + 2, this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT, f70), false);
                context.method_51448().popMatrix();
                i10 += 19;
                if (v15 instanceof ActivatableModule) {
                    v68 = (ActivatableModule)v15;
                    i69 = this.listeningActivationBind == v68;
                    f70 = this.clamp01((float)(i64 - (i10 - i65)) / 17.0f);
                    f71 = f66 * f70;
                    if (!this.animValues.containsKey((String)v11 + "/stagger/act")) {
                        this.animValues.put((String)v11 + "/stagger/act", Float.valueOf(-10.0f));
                    }
                    f72 = this.anim((String)v11 + "/stagger/act", v15.isExpanded() != false ? 0.0f : -10.0f, 18.0f);
                    context.method_51448().pushMatrix();
                    context.method_51448().translate(0.0f, f67 + f72);
                    GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (int)this.multiplyAlpha(-15198181, f71), (boolean)false);
                    GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (float)1.0f, (int)this.multiplyAlpha(0, f71), (boolean)false);
                    this.drawStyledText(context, "Activation", i9 + 10, i10 + 4, this.multiplyAlpha(-1073741825, f71), false);
                    v73 = i69 != false ? "..." : (v68.getActivationKey() == 0 ? "None" : this.getKeyDisplayName(v68.getActivationKey()));
                    i74 = this.fontWidth(v73) + 10;
                    i75 = i9 + 140 - 10 - i74;
                    i76 = i10 + 3;
                    i77 = i69 != false ? this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT & 0xFFFFFF | -2013265920, f71) : this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT & 0xFFFFFF | 0x33000000, f71);
                    GuiRenderer.a((class_332)context, (float)i75, (float)i76, (float)i74, (float)10.0f, (float)Math.max(2.0f, WaterPlus.getEffectiveRoundness() * 0.5f), (int)i77, (boolean)false);
                    GuiRenderer.a((class_332)context, (float)i75, (float)i76, (float)i74, (float)10.0f, (float)Math.max(2.0f, WaterPlus.getEffectiveRoundness() * 0.5f), (float)1.0f, (int)this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT & 0xFFFFFF | 0x66000000, f71), (boolean)false);
                    this.drawStyledText(context, v73, i75 + 5, i76 + 2, this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT, f71), false);
                    context.method_51448().popMatrix();
                    i10 += 19;
                }
                if ("Config Share".equals(v15.getName())) {
                    f68 = this.clamp01((float)(i64 - (i10 - i65)) / 17.0f);
                    f69 = f66 * f68;
                    i70 = this.pointInRect(i4, i5, i9 + 4, i10, 132.0f, 17.0f);
                    i71 = i70 != false ? this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT, f69) : this.multiplyAlpha(-15198181, f69);
                    context.method_51448().pushMatrix();
                    context.method_51448().translate(0.0f, f67);
                    GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (int)i71, (boolean)false);
                    GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (float)1.0f, (int)this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT, f69 * 0.6f), (boolean)false);
                    this.drawStyledText(context, "Open Config Manager", i9 + 10, i10 + 4, this.multiplyAlpha(-1, f69), false);
                    context.method_51448().popMatrix();
                    i10 += 19;
                }
                i68 = 0;
                for (Setting<String> v70 : v15.getSettings()) {
                    block69: {
                        block71: {
                            block70: {
                                block68: {
                                    f71 = this.clamp01((float)(i64 - (i10 - i65)) / 17.0f);
                                    f72 = f66 * f71;
                                    v73 = (String)v11 + "/stagger/" + i68;
                                    v4 = f74 = v15.isExpanded() != false ? 0.0f : -8.0f;
                                    if (!this.animValues.containsKey(v73)) {
                                        this.animValues.put(v73, Float.valueOf(-8.0f));
                                    }
                                    f75 = this.anim(v73, f74, Math.max(8.0f, 18.0f - (float)i68 * 1.5f));
                                    ++i68;
                                    context.method_51448().pushMatrix();
                                    context.method_51448().translate(0.0f, f67 + f75);
                                    GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (int)this.multiplyAlpha(0, f72), (boolean)false);
                                    GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (float)1.0f, (int)this.multiplyAlpha(0, f72), (boolean)false);
                                    v76 = v70.getValue();
                                    if (!(v70 instanceof ModeSetting)) break block68;
                                    v77 /* !! */  = (ModeSetting)v70;
                                    this.drawModeSetting(context, v77 /* !! */ , i9 + 4, 132, i10, f72);
                                    break block69;
                                }
                                if (!(v76 instanceof Boolean)) break block70;
                                i81 = (Boolean)v76;
                                i82 = i9 + 140 - 10 - 13;
                                i83 = i10 + 4;
                                v84 = System.identityHashCode(v70) + "/tog";
                                f85 = this.anim(v84, i81 != false ? 1.0f : 0.0f, 16.0f);
                                GuiRenderer.a((class_332)context, (float)i82, (float)i83, (float)13.0f, (float)8.0f, (float)4.0f, (int)this.multiplyAlpha(ClickGuiScreen.lerpARGB(-15198181, ClickGuiScreen.COLOR_ACCENT, f85), f72), (boolean)false);
                                GuiRenderer.a((class_332)context, (float)(i82 + 1 + Math.round(5.0f * f85)), (float)(i83 + 1), (float)6.0f, (float)6.0f, (float)3.0f, (int)this.multiplyAlpha(-1, f72), (boolean)false);
                                this.drawStyledText(context, v70.getName(), i9 + 10, i10 + 4, this.multiplyAlpha(ClickGuiScreen.lerpARGB(-1073741825, -1, f85), f72), false);
                                break block69;
                            }
                            if (!(v76 instanceof Float) && !(v76 instanceof Double) && !(v76 instanceof Integer)) break block71;
                            if (!(v76 instanceof Integer)) ** GOTO lbl-1000
                            v85 = (Integer)v76;
                            if (v70.getMin() instanceof Integer && v70.getMax() instanceof Integer) {
                                f81 = v85.intValue();
                                f83 = ((Integer)v70.getMin()).intValue();
                                f82 = ((Integer)v70.getMax()).intValue();
                                v84 = Integer.toString(v85);
                            } else lbl-1000:
                            // 2 sources

                            {
                                f81 = v76 instanceof Float != false ? ((Float)v76).floatValue() : (float)((Double)v76).doubleValue();
                                f82 = v70.getMax() instanceof Float != false ? ((Float)v70.getMax()).floatValue() : (float)((Double)v70.getMax()).doubleValue();
                                v5 = f83 = v70.getMin() instanceof Float != false ? ((Float)v70.getMin()).floatValue() : (float)((Double)v70.getMin()).doubleValue();
                                if (this.allowDecimalForModule((Module)v15)) {
                                    v84 = String.format("%.1f", new Object[]{Float.valueOf(f81)});
                                } else {
                                    f81 = Math.round(f81);
                                    v84 = Integer.toString(Math.round(f81));
                                }
                            }
                            f85 = (f81 - f83) / (f82 - f83);
                            i86 = i9 + 10;
                            i87 = i10 + 11;
                            i89 = (int)(120.0f * Math.max(0.0f, Math.min(1.0f, f85)));
                            GuiRenderer.a((class_332)context, (float)i86, (float)i87, (float)120.0f, (float)2.0f, (float)1.0f, (int)this.multiplyAlpha(-1290266597, f72), (boolean)false);
                            GuiRenderer.a((class_332)context, (float)i86, (float)i87, (float)i89, (float)2.0f, (float)1.0f, (int)this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT, f72), (boolean)false);
                            f90 = (float)(i86 + i89) - 3.0f;
                            f91 = (float)i87 + 1.0f - 3.0f;
                            GuiRenderer.a((class_332)context, (float)f90, (float)f91, (float)6.0f, (float)6.0f, (float)3.0f, (int)this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT, f72), (boolean)false);
                            this.drawStyledText(context, v70.getName() + ": " + v84, i9 + 10, i10 + 2, this.multiplyAlpha(-1, f72), false);
                            break block69;
                        }
                        if (v76 instanceof String) {
                            if ("GUI Key".equals(v70.getName())) {
                                f81 = class_310.method_1551().field_1772.method_1727(this.listeningGuiKey != false ? "GUI Key: ..." : "GUI Key: " + WaterPlus.getGuiKeyDisplayName()) + 10;
                                f82 = (float)(i9 + 140 - 4) - f81;
                                f83 = (float)i10 + 3.5f;
                                GuiRenderer.a((class_332)context, (float)f82, (float)f83, (float)f81, (float)10.0f, (float)4.0f, (int)(ClickGuiScreen.COLOR_ACCENT & 0xFFFFFF | 0x44000000), (boolean)false);
                                this.drawStyledText(context, "GUI Key", i9 + 10, i10 + 4, this.multiplyAlpha(-1, f72), false);
                                this.drawStyledText(context, this.listeningGuiKey != false ? "..." : WaterPlus.getGuiKeyDisplayName(), (int)(f82 + 5.0f), (int)(f83 + 1.0f), this.multiplyAlpha(ClickGuiScreen.COLOR_ACCENT, f72), false);
                            } else {
                                if (this.isStringListSetting((Module)v15, v70)) {
                                    i82 = this.parseStringList(v70).size();
                                    v81 = v70.getName() + ": " + i82 + " entries";
                                    if (this.expandedStringListSetting == v70) {
                                        v81 = v81 + " (edit)";
                                    }
                                } else {
                                    v82 = this.formatStringSettingValue((Module)v15, v70, (String)v76);
                                    v81 = v70.getName() + ": " + v82;
                                    if (this.listeningString == v70) {
                                        v81 = v81 + "_";
                                    }
                                }
                                this.drawInputTextClipped(context, i9 + 4, i10, 132.0f, 17.0f, v81, i9 + 10, i10 + 4, this.multiplyAlpha(-1, f72));
                            }
                        } else if (v70 instanceof BlocksSetting) {
                            v78 = (BlocksSetting)v70;
                            this.drawBlocksSettingSummary(context, v78, i9 + 4, 132.0f, i10, 17, f72);
                        } else if (v70 instanceof MobsSetting) {
                            v79 = (MobsSetting)v70;
                            this.drawMobsSettingSummary(context, v79, i9 + 4, 132.0f, i10, 17, f72);
                        } else if (v76 instanceof Color) {
                            (Color)v76;
                            i81 = i4 >= i9 + 4 && i4 <= i9 + 140 - 4 && i5 >= i10 && i5 <= i10 + 17;
                            this.drawStyledText(context, v70.getName(), i9 + 10, i10 + 4, this.multiplyAlpha(-1, f72), false);
                            this.drawColorSetting(context, v70, i9 + 4, 132.0f, i10, 17, i81 != false ? 1.0f : 0.0f, this.expandedColorSetting == v70 ? 1.0f : 0.0f, f72);
                        }
                    }
                    context.method_51448().popMatrix();
                    i10 += 19;
                    if (this.isStringListSetting((Module)v15, v70) && this.expandedStringListSetting == v70) {
                        f77 = this.clamp01((float)(i64 - (i10 - i65)) / 17.0f);
                        if (f66 * f77 > 0.01f) {
                            context.method_51448().pushMatrix();
                            context.method_51448().translate(0.0f, f67);
                            this.drawStringListEditor(context, v70, i9 + 4, i10, 132, f66 * f77);
                            context.method_51448().popMatrix();
                        }
                        i10 += this.getStringListEditorExtraHeight(v70);
                    }
                    if (v70 instanceof BlocksSetting && this.expandedBlocksSetting == (v77 /* !! */  = (BlocksSetting)v70)) {
                        f78 = f66 * this.clamp01((float)(i64 - (i10 - i65)) / 17.0f);
                        context.method_51448().pushMatrix();
                        context.method_51448().translate(0.0f, f67);
                        if (f78 > 0.01f) {
                            this.drawBlocksPicker(context, (BlocksSetting)v77 /* !! */ , i9 + 4, 132.0f, i10, mouseX, mouseY);
                        }
                        context.method_51448().popMatrix();
                        i10 += this.getBlockPickerExtraHeight((BlocksSetting)v77 /* !! */ );
                    }
                    if (v70 instanceof MobsSetting && this.expandedMobsSetting == (v77 /* !! */  = (MobsSetting)v70)) {
                        f78 = f66 * this.clamp01((float)(i64 - (i10 - i65)) / 17.0f);
                        context.method_51448().pushMatrix();
                        context.method_51448().translate(0.0f, f67);
                        if (f78 > 0.01f) {
                            this.drawMobsPicker(context, (MobsSetting)v77 /* !! */ , i9 + 4, 132.0f, i10, mouseX, mouseY);
                        }
                        context.method_51448().popMatrix();
                        i10 += this.getMobPickerExtraHeight((MobsSetting)v77 /* !! */ );
                    }
                    if (!(v70.getValue() instanceof Color) || this.expandedColorSetting != v70) continue;
                    i10 += 112;
                }
                i10 = i65 + i64;
            }
            if (i12 == 0) {
                GuiRenderer.a((class_332)context, (float)(i9 + 4), (float)i10, (float)132.0f, (float)17.0f, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (int)0, (boolean)false);
                this.drawStyledText(context, "No results", i9 + 10, i10 + 4, -1073741825, false);
            }
            WaterFontRenderer.bk();
        }
        context.method_51448().popMatrix();
        if (this.listeningBind != null) {
            for (i7 = 32; i7 <= 348; ++i7) {
                if (i7 == 256 || i7 == 259 || GLFW.glfwGetKey((long)class_310.method_1551().method_22683().method_4490(), (int)i7) != 1) continue;
                this.listeningBind.setBind(i7);
                this.listeningBind = null;
                break;
            }
            if (this.listeningBind != null && GLFW.glfwGetKey((long)class_310.method_1551().method_22683().method_4490(), (int)259) == 1) {
                this.listeningBind.setBind(0);
                this.listeningBind = null;
            }
            if (GLFW.glfwGetKey((long)class_310.method_1551().method_22683().method_4490(), (int)256) == 1) {
                this.listeningBind = null;
            }
        }
        if (this.listeningActivationBind != null) {
            for (i7 = 32; i7 <= 348; ++i7) {
                if (i7 == 256 || i7 == 259 || GLFW.glfwGetKey((long)class_310.method_1551().method_22683().method_4490(), (int)i7) != 1) continue;
                this.listeningActivationBind.setActivationKey(i7);
                this.listeningActivationBind = null;
                break;
            }
            if (this.listeningActivationBind != null && GLFW.glfwGetKey((long)class_310.method_1551().method_22683().method_4490(), (int)259) == 1) {
                this.listeningActivationBind.setActivationKey(0);
                this.listeningActivationBind = null;
            }
            if (GLFW.glfwGetKey((long)class_310.method_1551().method_22683().method_4490(), (int)256) == 1) {
                this.listeningActivationBind = null;
            }
        }
        if (this.listeningGuiKey) {
            for (i7 = 32; i7 <= 348; ++i7) {
                if (i7 == 256 || i7 == 259 || GLFW.glfwGetKey((long)class_310.method_1551().method_22683().method_4490(), (int)i7) != 1) continue;
                WaterPlus.applyGuiKey(i7, ClickGuiScreen.getKeyDisplayNameStatic(i7));
                this.listeningGuiKey = false;
                break;
            }
            if (this.listeningGuiKey && GLFW.glfwGetKey((long)class_310.method_1551().method_22683().method_4490(), (int)256) == 1) {
                this.listeningGuiKey = false;
            }
        }
    }

    private void drawBlocksSettingSummary(class_332 context, BlocksSetting setting, float panelX, float panelWidth, float rowY, int rowHeight, float revealAlpha) {
        String v6 = this.expandedBlocksSetting == setting ? "v" : ">";
        int i8 = this.fontWidth(v6);
        int i4 = Math.round(panelX + panelWidth - 6.0f - (float)i8);
        i8 = Math.max(30, i4 - (Math.round(panelX) + 10 + this.fontWidth(setting.getName()) + 14));
        int i9 = this.multiplyAlpha(this.expandedBlocksSetting == setting || setting.size() > 0 ? -1 : -1073741825, revealAlpha);
        String v10 = setting.size() == 0 ? "Choose" : this.buildBlocksPreviewText(setting);
        v10 = this.trimWithEllipsis(v10, Math.round((float)(i8 - 18) / 0.9f));
        i8 = Math.max(34, Math.min(i8, this.fontWidth(v10) + 22));
        int i11 = i4 - i8 - 6;
        int i12 = this.multiplyAlpha(setting.size() > 0 ? COLOR_ACCENT_DIM : -15198181, revealAlpha);
        class_1799 v13 = this.getPreviewBlockStack(setting);
        this.drawStyledText(context, setting.getName(), Math.round(panelX) + 10, Math.round(rowY) + 4, i9, false);
        GuiRenderer.a((class_332)context, (float)i11, (float)(rowY + 2.0f), (float)i8, (float)12.0f, (float)Math.max(2.0f, WaterPlus.getEffectiveRoundness() * 0.5f), (int)i12, (boolean)false);
        GuiRenderer.a((class_332)context, (float)i11, (float)(rowY + 2.0f), (float)i8, (float)12.0f, (float)Math.max(2.0f, WaterPlus.getEffectiveRoundness() * 0.5f), (float)1.0f, (int)this.multiplyAlpha(0, revealAlpha), (boolean)false);
        if (!v13.method_7960()) {
            context.method_51427(v13, i11 + 2, Math.round(rowY) + 1);
        }
        this.drawScaledText(context, v10, i11 + (v13.method_7960() ? 6 : 16), rowY + 4.0f, 0.9f, this.multiplyAlpha(-1, revealAlpha));
        this.drawStyledText(context, v6, i4, Math.round(rowY) + 4, this.multiplyAlpha(-1073741825, revealAlpha), false);
    }

    private void drawBlocksPicker(class_332 context, BlocksSetting setting, float panelX, float panelWidth, float pickerY, int mouseX, int mouseY) {
        float f11;
        float f13;
        int i11;
        String v9;
        b v3 = this.buildBlockPickerLayout(panelX, panelWidth, pickerY, setting);
        List<class_2248> v4 = this.getFilteredBlocks(setting);
        this.blockPickerScroll = this.clampBlockPickerScroll(v4.size(), this.blockPickerScroll);
        pickerY = WaterPlus.getEffectiveRoundness();
        pickerY = Math.max(4.0f, pickerY * 0.5f);
        float f8 = WaterPlus.getGlassIntensity();
        int i9 = WaterPlus.getBackgroundARGB();
        GuiRenderer.a((class_332)context, (float)v3.x, (float)v3.y, (float)v3.width, (float)v3.height, (float)pickerY, (int)i9, (boolean)false);
        if (f8 > 0.01f) {
            GuiRenderer.a((class_332)context, (float)v3.x, (float)v3.y, (float)v3.width, (float)v3.height, (float)pickerY, (float)1.0f, (int)ClickGuiScreen.glassCol(0xFFFFFF, (int)(50.0f * f8)), (boolean)false);
            GuiRenderer.a((class_332)context, (float)(v3.x + 1.0f), (float)(v3.y + 1.0f), (float)(v3.width - 2.0f), (float)6.0f, (float)pickerY, (int)ClickGuiScreen.glassCol(0xFFFFFF, (int)(15.0f * f8)), (boolean)false);
        } else {
            GuiRenderer.a((class_332)context, (float)v3.x, (float)v3.y, (float)v3.width, (float)v3.height, (float)pickerY, (float)1.0f, (int)0x16FFFFFF, (boolean)false);
        }
        int i8 = this.blockSearchActive && this.expandedBlocksSetting == setting ? 1 : 0;
        i9 = i8 != 0 ? -15919840 : -16117736;
        int i10 = i8 != 0 ? COLOR_ACCENT : -14799552;
        GuiRenderer.a((class_332)context, (float)v3.searchX, (float)v3.searchY, (float)v3.searchWidth, (float)v3.searchHeight, (float)pickerY, (int)i9, (boolean)false);
        GuiRenderer.a((class_332)context, (float)v3.searchX, (float)v3.searchY, (float)v3.searchWidth, (float)v3.searchHeight, (float)pickerY, (float)1.0f, (int)i10, (boolean)false);
        String string = v9 = this.blockSearchQuery.isEmpty() ? "\u2315  Search..." : "\u2315  " + this.blockSearchQuery;
        if (i8 != 0 && System.currentTimeMillis() / 500L % 2L == 0L) {
            v9 = v9 + "_";
        }
        this.drawInputTextClipped(context, v3.searchX, v3.searchY, Math.max(0.0f, v3.searchWidth), Math.max(0.0f, v3.searchHeight), v9, Math.round(v3.searchX) + 6, Math.round(v3.searchY) + 4, this.blockSearchQuery.isEmpty() && i8 == 0 ? -1073741825 : -1);
        GuiRenderer.a((class_332)context, (float)v3.clearX, (float)v3.clearY, (float)v3.clearWidth, (float)v3.clearHeight, (float)pickerY, (int)585125984, (boolean)false);
        GuiRenderer.a((class_332)context, (float)v3.clearX, (float)v3.clearY, (float)v3.clearWidth, (float)v3.clearHeight, (float)pickerY, (float)1.0f, (int)1725976672, (boolean)false);
        this.drawStyledText(context, "\u2715", Math.round(v3.clearX) + (int)(v3.clearWidth / 2.0f) - 3, Math.round(v3.clearY) + 4, -2076576, false);
        if (v4.isEmpty()) {
            this.drawStyledText(context, "No blocks found", Math.round(v3.listX) + 6, Math.round(v3.listY) + 4, -1073741825, false);
            return;
        }
        i8 = Math.min(5, v4.size());
        i9 = v4.size() > i8 ? 1 : 0;
        for (i10 = 0; i10 < i8 && (i11 = this.blockPickerScroll + i10) < v4.size(); ++i10) {
            class_1799 v11;
            boolean i15;
            Object v12 = v4.get(i11);
            f13 = v3.listY + (float)(i10 * 18);
            int i14 = setting.contains((class_2248)v12);
            boolean bl = i15 = (float)mouseX >= v3.listX && (float)mouseX <= v3.listX + v3.listWidth && (float)mouseY >= f13 && (float)mouseY <= f13 + 18.0f - 2.0f;
            int n = i14 != 0 ? COLOR_ACCENT & 0xFFFFFF | 0x22000000 : (i11 = i15 ? 0x18FFFFFF : 0);
            if (i11 != 0) {
                GuiRenderer.a((class_332)context, (float)v3.listX, (float)f13, (float)v3.listWidth, (float)16.0f, (float)pickerY, (int)i11, (boolean)false);
            }
            if (i14 != 0) {
                GuiRenderer.a((class_332)context, (float)v3.listX, (float)(f13 + 2.0f), (float)2.0f, (float)12.0f, (float)1.0f, (int)COLOR_ACCENT, (boolean)false);
            }
            if (!(v11 = new class_1799((class_1935)v12)).method_7960()) {
                context.method_51448().pushMatrix();
                context.method_51448().translate(v3.listX + 4.0f, f13 + 1.0f);
                context.method_51448().scale(0.75f, 0.75f);
                context.method_51427(v11, 0, 0);
                context.method_51448().popMatrix();
            }
            f11 = v3.listX + v3.listWidth - 10.0f;
            int i16 = Math.round(v3.listX) + 16;
            v12 = this.trimWithEllipsis(setting.getDisplayName((class_2248)v12), Math.round((f11 - (float)i16 - 4.0f) / 0.9f));
            this.drawScaledText(context, (String)v12, i16, f13 + 4.0f, 0.9f, i14 != 0 ? COLOR_ACCENT : (i15 ? -1 : -1073741825));
            int i12 = i14 != 0 ? COLOR_ACCENT : -14799552;
            int n2 = i14 = i14 != 0 ? COLOR_ACCENT & 0xFFFFFF | 0x44000000 : 0;
            if (i14 != 0) {
                GuiRenderer.a((class_332)context, (float)f11, (float)(f13 + 5.0f), (float)6.0f, (float)6.0f, (float)3.0f, (int)i14, (boolean)false);
            }
            GuiRenderer.a((class_332)context, (float)f11, (float)(f13 + 5.0f), (float)6.0f, (float)6.0f, (float)3.0f, (float)1.0f, (int)i12, (boolean)false);
        }
        if (i9 != 0) {
            i10 = Math.max(1, v4.size() - i8);
            f11 = v3.listX + v3.listWidth - 4.0f;
            float f12 = v3.listY + 1.0f;
            f13 = v3.listHeight - 2.0f;
            float f14 = Math.max(12.0f, f13 * ((float)i8 / (float)v4.size()));
            float f15 = (f13 - f14) * ((float)this.blockPickerScroll / (float)i10);
            GuiRenderer.a((class_332)context, (float)f11, (float)f12, (float)4.0f, (float)f13, (float)2.0f, (int)-16117736, (boolean)false);
            GuiRenderer.a((class_332)context, (float)f11, (float)(f12 + f15), (float)4.0f, (float)f14, (float)2.0f, (int)(COLOR_ACCENT & 0xFFFFFF | 0xAA000000), (boolean)false);
        }
    }

    private void drawColorSetting(class_332 context, Setting<Color> setting, float panelX, float panelWidth, float rowY, int rowHeight, float hoverProgress, float expansionProgress, float revealAlpha) {
        float f17;
        int i16;
        float f15;
        Color v7 = setting.getValue();
        float f10 = WaterPlus.getEffectiveRoundness();
        f10 = Math.max(2.0f, f10 * 0.5f);
        panelWidth = panelX + panelWidth - 5.0f - 12.0f;
        float f11 = rowY + ((float)rowHeight - 4.0f - 12.0f) / 2.0f;
        GuiRenderer.a((class_332)context, (float)panelWidth, (float)(f11 + 2.0f), (float)12.0f, (float)12.0f, (float)f10, (int)this.multiplyAlpha(setting.getValue(), revealAlpha), (boolean)false);
        GuiRenderer.a((class_332)context, (float)panelWidth, (float)(f11 + 2.0f), (float)12.0f, (float)12.0f, (float)f10, (float)1.0f, (int)this.multiplyAlpha(-1427114245, revealAlpha), (boolean)false);
        if (expansionProgress <= 0.01f) {
            return;
        }
        float f2 = this.easeOutCubic(expansionProgress) * revealAlpha;
        panelWidth = rowY + (float)rowHeight + 6.0f;
        rowY = Math.max(1.0f, 80.0f * f2);
        float f6 = Math.max(1.0f, 16.0f * f2);
        expansionProgress = (panelX += 4.0f) + rowY + 6.0f;
        revealAlpha = this.getHue(v7);
        f11 = this.getSaturation(v7);
        float f12 = this.getBrightness(v7);
        float f13 = rowY / 12.0f;
        float cfr_ignored_0 = rowY / 12.0f;
        for (int i14 = 0; i14 < 12; ++i14) {
            f15 = 1.0f - (float)i14 / 12.0f;
            for (i16 = 0; i16 < 12; ++i16) {
                f17 = (float)i16 / 12.0f;
                context.method_25294((int)(panelX + (float)i16 * f13), (int)(panelWidth + (float)i14 * f13), (int)(panelX + (float)(i16 + 1) * f13), (int)(panelWidth + (float)(i14 + 1) * f13), this.withAlpha(Color.HSBtoRGB(revealAlpha, f17, f15), f2));
            }
        }
        GuiRenderer.a((class_332)context, (float)panelX, (float)panelWidth, (float)rowY, (float)rowY, (float)f10, (float)1.0f, (int)this.withAlpha(0x66FFFFFF, f2), (boolean)false);
        float f14 = panelX + f11 * rowY;
        f15 = panelWidth + (1.0f - f12) * rowY;
        GuiRenderer.a((class_332)context, (float)(f14 - 4.0f), (float)(f15 - 4.0f), (float)8.0f, (float)8.0f, (float)4.0f, (int)this.withAlpha(-2013265920, f2), (boolean)false);
        GuiRenderer.a((class_332)context, (float)(f14 - 4.0f), (float)(f15 - 4.0f), (float)8.0f, (float)8.0f, (float)4.0f, (float)2.0f, (int)this.withAlpha(-1, f2), (boolean)false);
        for (i16 = 0; i16 < (int)rowY; ++i16) {
            f17 = (float)i16 / (float)((int)rowY);
            context.method_25294((int)expansionProgress, (int)(panelWidth + (float)i16), (int)(expansionProgress + f6), (int)(panelWidth + (float)i16 + 1.0f), this.withAlpha(0xFF000000 | Color.HSBtoRGB(f17, 1.0f, 1.0f) & 0xFFFFFF, f2));
        }
        GuiRenderer.a((class_332)context, (float)expansionProgress, (float)panelWidth, (float)f6, (float)rowY, (float)f10, (float)1.0f, (int)this.withAlpha(0x66FFFFFF, f2), (boolean)false);
        GuiRenderer.a((class_332)context, (float)(expansionProgress - 2.0f), (float)(panelWidth + revealAlpha * rowY - 1.0f), (float)(f6 + 4.0f), (float)3.0f, (float)1.5f, (int)this.withAlpha(-1, f2), (boolean)false);
        float f16 = panelWidth + rowY + 6.0f;
        f17 = (rowY + 6.0f + f6) / 2.0f - 2.0f;
        panelWidth = Math.max(1.0f, 14.0f * f2);
        int i5 = this.multiplyAlpha(v7, f2);
        GuiRenderer.a((class_332)context, (float)panelX, (float)f16, (float)f17, (float)panelWidth, (float)f10, (int)i5, (boolean)false);
        GuiRenderer.a((class_332)context, (float)(panelX + f17 + 4.0f), (float)f16, (float)f17, (float)panelWidth, (float)f10, (int)i5, (boolean)false);
        GuiRenderer.a((class_332)context, (float)panelX, (float)f16, (float)f17, (float)panelWidth, (float)f10, (float)1.0f, (int)this.withAlpha(0x55FFFFFF, f2), (boolean)false);
        GuiRenderer.a((class_332)context, (float)(panelX + f17 + 4.0f), (float)f16, (float)f17, (float)panelWidth, (float)f10, (float)1.0f, (int)this.withAlpha(0x55FFFFFF, f2), (boolean)false);
        this.drawStyledText(context, "ORIGINAL", (int)(panelX + 2.0f), (int)(f16 + panelWidth + 2.0f), this.withAlpha(-6642510, f2), false);
        this.drawStyledText(context, "NEW", (int)(panelX + f17 + 6.0f), (int)(f16 + panelWidth + 2.0f), this.withAlpha(-6642510, f2), false);
    }

    public float getHue(Color c2) {
        return Color.RGBtoHSB(c2.getRed(), c2.getGreen(), c2.getBlue(), null)[0];
    }

    public float getSaturation(Color c2) {
        return Color.RGBtoHSB(c2.getRed(), c2.getGreen(), c2.getBlue(), null)[1];
    }

    public float getBrightness(Color c2) {
        return Color.RGBtoHSB(c2.getRed(), c2.getGreen(), c2.getBlue(), null)[2];
    }

    public float getAlphaFloat(Color c2) {
        return (float)c2.getAlpha() / 255.0f;
    }

    private void drawStripBar(class_332 context, float x, float y, float width, float height, float radius, int segments, IntFunction<Integer> colorProvider) {
        if (height <= 0.0f) {
            return;
        }
        float f9 = Math.max(1.0f, width / (float)segments);
        for (int i10 = 0; i10 < segments; ++i10) {
            float f11 = x + f9 * (float)i10;
            float f12 = i10 == segments - 1 ? x + width - f11 : f9 + 1.0f;
            float f13 = i10 == 0 ? radius : 0.0f;
            float f14 = i10 == segments - 1 ? radius : 0.0f;
            GuiRenderer.a((class_332)context, (float)f11, (float)y, (float)f12, (float)height, (float)f13, (float)f14, (float)f14, (float)f13, (boolean)false, (int[])new int[]{colorProvider.apply(i10)});
        }
    }

    public boolean method_25402(class_11909 click, boolean bl) {
        Object v8;
        this.uiScale = this.computeUiScale();
        double d3 = this.toUiX(click.comp_4798());
        double d5 = this.toUiY(click.comp_4799());
        int i7 = click.method_74245();
        this.activeColorSetting = null;
        this.colorDragMode = c.NONE;
        this.draggingNumericSetting = null;
        this.draggingNumericModule = null;
        int i8 = Math.min(260, this.uiWidth() - 60);
        int i9 = (this.uiWidth() - i8) / 2;
        int i10 = this.uiHeight() - 20 - 60;
        String v11 = "Configs";
        int i11 = this.fontWidth(v11) + 18;
        int i12 = (this.uiWidth() - i11) / 2;
        int i13 = i10 - 14 - 6;
        if (d3 >= (double)i12 && d3 <= (double)(i12 + i11) && d5 >= (double)i13 && d5 <= (double)(i13 + 14)) {
            this.searchActive = false;
            class_310.method_1551().method_1507((class_437)new ConfigManagerScreen());
            return true;
        }
        if (d3 >= (double)i9 && d3 <= (double)(i9 + i8) && d5 >= (double)i10 && d5 <= (double)(i10 + 20)) {
            this.searchActive = true;
            this.blockSearchActive = false;
            this.listeningBind = null;
            this.listeningActivationBind = null;
            this.listeningString = null;
            return true;
        }
        this.searchActive = false;
        if (i7 == 0) {
            v8 = CACHED_CATEGORIES;
            for (i9 = 0; i9 < ((Category[])v8).length; ++i9) {
                i10 = this.getCategoryX(v8[i9], i9);
                i11 = this.getCategoryY(v8[i9]);
                if (!(d3 >= (double)i10) || !(d3 <= (double)(i10 + 140)) || !(d5 >= (double)i11) || !(d5 <= (double)(i11 + 22))) continue;
                this.draggingCategory = v8[i9];
                this.dragGrabOffsetX = (int)(d3 - (double)i10);
                this.dragGrabOffsetY = (int)(d5 - (double)i11);
                return true;
            }
        }
        v8 = CACHED_CATEGORIES;
        for (i9 = 0; i9 < ((Category[])v8).length; ++i9) {
            Object v10 = v8[i9];
            i11 = this.getCategoryX((Category)((Object)v10), i9);
            i12 = this.getCategoryY((Category)((Object)v10));
            i12 = i12 + 22 + 6;
            for (Module v14 : ModuleManager.INSTANCE.getModulesInCategory((Category)((Object)v10))) {
                int i17;
                if (!this.matchesQuery(v14)) continue;
                if (d3 >= (double)(i11 + 4) && d3 <= (double)(i11 + 140 - 4) && d5 >= (double)i12 && d5 <= (double)(i12 + 17)) {
                    if (i7 == 1 && v14.getName().equals("Chat Macro")) {
                        class_310.method_1551().method_1507((class_437)new ChatMacroScreen(this));
                        return true;
                    }
                    if (i7 == 0) {
                        v14.toggle();
                    } else if (i7 == 1) {
                        boolean i15 = !v14.isExpanded();
                        String string = ((Enum)v10).name() + "/" + v14.getName();
                        if (i15) {
                            this.animValues.put(string + "/expand", Float.valueOf(0.0f));
                            for (i17 = 0; i17 < v14.getSettings().size() + 2; ++i17) {
                                this.animValues.put(string + "/stagger/" + i17, Float.valueOf(-8.0f));
                            }
                            this.animValues.put(string + "/stagger/bind", Float.valueOf(-10.0f));
                            this.animValues.put(string + "/stagger/act", Float.valueOf(-10.0f));
                        } else {
                            this.animValues.put(string + "/expand", Float.valueOf(0.0f));
                        }
                        v14.setExpanded(i15);
                    }
                    return true;
                }
                i12 += 19;
                if (!v14.isExpanded()) continue;
                if (d3 >= (double)(i11 + 4) && d3 <= (double)(i11 + 140 - 4) && d5 >= (double)i12 && d5 <= (double)(i12 + 17)) {
                    if (i7 == 1) {
                        v14.setBind(0);
                        this.listeningBind = null;
                        this.listeningActivationBind = null;
                    } else if (i7 == 0) {
                        this.listeningBind = v14;
                        this.listeningActivationBind = null;
                    }
                    return true;
                }
                i12 += 19;
                if ("Config Share".equals(v14.getName())) {
                    if (d3 >= (double)(i11 + 4) && d3 <= (double)(i11 + 140 - 4) && d5 >= (double)i12 && d5 <= (double)(i12 + 17)) {
                        if (i7 == 0) {
                            class_310.method_1551().method_1507((class_437)new ConfigManagerScreen());
                        }
                        return true;
                    }
                    i12 += 19;
                }
                if (v14 instanceof ActivatableModule) {
                    ActivatableModule v15 = (ActivatableModule)v14;
                    if (d3 >= (double)(i11 + 4) && d3 <= (double)(i11 + 140 - 4) && d5 >= (double)i12 && d5 <= (double)(i12 + 17)) {
                        if (i7 == 1) {
                            v15.setActivationKey(0);
                            this.listeningActivationBind = null;
                            this.listeningBind = null;
                        } else if (i7 == 0) {
                            this.listeningActivationBind = v15;
                            this.listeningBind = null;
                        }
                        return true;
                    }
                    i12 += 19;
                }
                for (Setting setting : v14.getSettings()) {
                    int i18;
                    int i19;
                    Object v18;
                    Object v17;
                    if (d3 >= (double)(i11 + 4) && d3 <= (double)(i11 + 140 - 4) && d5 >= (double)i12 && d5 <= (double)(i12 + 17)) {
                        if (setting instanceof ModeSetting) {
                            v17 = (ModeSetting)setting;
                            if (i7 == 1) {
                                v17.bf();
                            } else {
                                v17.be();
                            }
                        } else if (setting.getValue() instanceof Boolean) {
                            setting.setValue((Boolean)setting.getValue() == false);
                        } else if (setting.getValue() instanceof String) {
                            if ("GUI Key".equals(setting.getName())) {
                                if (i7 == 0) {
                                    this.listeningGuiKey = !this.listeningGuiKey;
                                    this.listeningBind = null;
                                    this.listeningActivationBind = null;
                                    this.listeningString = null;
                                } else if (i7 == 1) {
                                    this.listeningGuiKey = false;
                                }
                            } else if (this.isStringListSetting(v14, setting)) {
                                if (i7 == 0) {
                                    this.expandedStringListSetting = this.expandedStringListSetting == setting ? null : setting;
                                    this.stringListAddActive = this.expandedStringListSetting == setting;
                                    this.stringListAddBuffer = "";
                                    this.listeningString = null;
                                } else if (i7 == 1) {
                                    this.expandedStringListSetting = null;
                                    this.stringListAddActive = false;
                                    this.stringListAddBuffer = "";
                                }
                            } else {
                                this.expandedStringListSetting = null;
                                this.stringListAddActive = false;
                                this.stringListAddBuffer = "";
                                this.listeningString = setting;
                            }
                        } else if (setting.getValue() instanceof Float || setting.getValue() instanceof Double || setting.getValue() instanceof Integer) {
                            if (i7 == 0) {
                                this.beginSettingDragBatch();
                                this.draggingNumericSetting = setting;
                                this.draggingNumericModule = v14;
                                this.draggingNumericCatX = i11;
                                this.updateNumericSetting(v14, setting, d3, i11);
                            }
                        } else if (setting instanceof BlocksSetting) {
                            v18 = (BlocksSetting)setting;
                            if (i7 == 0 || i7 == 1) {
                                click = new LinkedHashMap();
                                Consumer<Map> v2 = null;
                                if (v14 instanceof StorageESP) {
                                    v8 = (StorageESP)v14;
                                    click.putAll(v8.d());
                                    v2 = (Consumer<Map>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, b(java.util.Map ), (Ljava/util/Map;)V)((StorageESP)v8);
                                } else if (v14 instanceof ExtraESP) {
                                    ExtraESP v9 = (ExtraESP)v14;
                                    click.putAll(v9.b());
                                    v2 = (Consumer<Map>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)V, a(java.util.Map ), (Ljava/util/Map;)V)((ExtraESP)v9);
                                }
                                class_310.method_1551().method_1507((class_437)new BlockSelectionScreen(this, v14, (BlocksSetting)v18, (Map<class_2248, Color>)click, v2));
                                return true;
                            }
                            if (i7 == 2) {
                                ((BlocksSetting)v18).clear();
                            }
                        } else if (setting instanceof MobsSetting) {
                            MobsSetting v19 = (MobsSetting)setting;
                            if (i7 == 0) {
                                if (this.expandedMobsSetting != v19) {
                                    this.mobSearchQuery = "";
                                    this.mobPickerScroll = 0;
                                }
                                this.expandedMobsSetting = this.expandedMobsSetting == v19 ? null : v19;
                                this.mobSearchActive = this.expandedMobsSetting == v19;
                            } else if (i7 == 1) {
                                v19.clear();
                                this.mobPickerScroll = 0;
                            }
                        } else if (setting.getValue() instanceof Color) {
                            if (i7 == 0) {
                                this.expandedColorSetting = this.expandedColorSetting == setting ? null : setting;
                            } else if (i7 == 1) {
                                this.expandedColorSetting = null;
                            }
                        }
                        return true;
                    }
                    if (this.isStringListSetting(v14, setting) && this.expandedStringListSetting == setting && this.pointInRect(d3, d5, i19 = i11 + 4, i17 = i12 + 19, 132.0f, i18 = this.getStringListEditorExtraHeight(setting))) {
                        int i1;
                        Setting v2 = setting;
                        v8 = this.parseStringList(v2);
                        i9 = Math.min(6, v8.size());
                        for (i1 = 0; i1 < i9; ++i1) {
                            i10 = i17 + i1 * 19;
                            i11 = i19 + 132 - 10 - 12;
                            if (!this.pointInRect(d3, d5, i11, i10 += 2, 12.0f, 12.0f) || i7 != 0) continue;
                            click = (String)v8.get(i1);
                            v8.removeIf(arg_0 -> ClickGuiScreen.lambda$mouseClicked$1((String)click, arg_0));
                            this.setStringListFromLowerList(v2, (List<String>)v8);
                            return true;
                        }
                        i1 = i17 + i9 * 19;
                        i10 = i19 + 132 - 10 - 12;
                        i11 = i1 + 2;
                        if (i7 == 0 && this.pointInRect(d3, d5, i10, i11, 12.0f, 12.0f)) {
                            Object object = v10 = this.stringListAddBuffer == null ? "" : this.stringListAddBuffer.trim();
                            if (!((String)v10).isEmpty()) {
                                click = ((String)v10).toLowerCase(Locale.ROOT);
                                boolean i3 = false;
                                Iterator v4 = v8.iterator();
                                while (v4.hasNext()) {
                                    String v5 = (String)v4.next();
                                    if (!v5.equalsIgnoreCase((String)click)) continue;
                                    i3 = true;
                                    break;
                                }
                                if (!i3) {
                                    v8.add(click);
                                    this.setStringListFromLowerList(v2, (List<String>)v8);
                                }
                            }
                            this.stringListAddBuffer = "";
                            this.stringListAddActive = true;
                            this.listeningString = null;
                            return true;
                        }
                        if (i7 == 0 && this.pointInRect(d3, d5, i19, i1, 132.0f, 17.0f)) {
                            this.stringListAddActive = true;
                            this.listeningString = null;
                            return true;
                        }
                        return true;
                    }
                    if (setting instanceof BlocksSetting && this.expandedBlocksSetting == (v17 = (BlocksSetting)setting)) {
                        v18 = this.buildBlockPickerLayout(i11 + 4, 132.0f, i12 + 19, (BlocksSetting)v17);
                        if (this.pointInRect(d3, d5, ((b)v18).clearX, ((b)v18).clearY, ((b)v18).clearWidth, ((b)v18).clearHeight)) {
                            ((BlocksSetting)v17).clear();
                            this.blockPickerScroll = 0;
                            this.blockSearchQuery = "";
                            return true;
                        }
                        if (this.pointInRect(d3, d5, ((b)v18).searchX, ((b)v18).searchY, ((b)v18).searchWidth, ((b)v18).searchHeight)) {
                            this.blockSearchActive = true;
                            this.searchActive = false;
                            this.listeningString = null;
                            return true;
                        }
                        if (this.pointInRect(d3, d5, ((b)v18).x, ((b)v18).y, ((b)v18).width, ((b)v18).height)) {
                            this.blockSearchActive = false;
                            List<class_2248> v19 = this.getFilteredBlocks((BlocksSetting)v17);
                            int i1 = Math.min(5, Math.max(1, v19.size()));
                            for (bl = 0; bl < i1 && (i8 = this.clampBlockPickerScroll(v19.size(), this.blockPickerScroll) + bl) < v19.size(); ++bl) {
                                float f9 = ((b)v18).listY + (float)(bl * 18);
                                if (!this.pointInRect(d3, d5, ((b)v18).listX, f9, ((b)v18).listWidth, 16.0f)) continue;
                                ((BlocksSetting)v17).toggle(v19.get(i8));
                                return true;
                            }
                            return true;
                        }
                    }
                    if (setting instanceof MobsSetting && this.expandedMobsSetting == (v17 = (MobsSetting)setting)) {
                        v18 = this.buildMobPickerLayout(i11 + 4, 132.0f, i12 + 19, (MobsSetting)v17);
                        if (this.pointInRect(d3, d5, ((b)v18).clearX, ((b)v18).clearY, ((b)v18).clearWidth, ((b)v18).clearHeight)) {
                            ((MobsSetting)v17).clear();
                            this.mobPickerScroll = 0;
                            this.mobSearchQuery = "";
                            return true;
                        }
                        if (this.pointInRect(d3, d5, ((b)v18).searchX, ((b)v18).searchY, ((b)v18).searchWidth, ((b)v18).searchHeight)) {
                            this.mobSearchActive = true;
                            this.searchActive = false;
                            this.listeningString = null;
                            return true;
                        }
                        if (this.pointInRect(d3, d5, ((b)v18).x, ((b)v18).y, ((b)v18).width, ((b)v18).height)) {
                            this.mobSearchActive = false;
                            List<class_1299<?>> v19 = this.getFilteredMobs((MobsSetting)v17);
                            int i1 = Math.min(5, Math.max(1, v19.size()));
                            for (bl = 0; bl < i1 && (i8 = this.clampMobPickerScroll(v19.size(), this.mobPickerScroll) + bl) < v19.size(); ++bl) {
                                float f9 = ((b)v18).listY + (float)(bl * 18);
                                if (!this.pointInRect(d3, d5, ((b)v18).listX, f9, ((b)v18).listWidth, 16.0f)) continue;
                                ((MobsSetting)v17).toggle(v19.get(i8));
                                return true;
                            }
                            return true;
                        }
                    }
                    if (i7 == 0 && setting.getValue() instanceof Color && this.expandedColorSetting == setting) {
                        v17 = this.buildColorPickerLayout(i11 + 4, 132.0f, i12, 17);
                        if (this.pointInRect(d3, d5, ((d)v17).fieldX, ((d)v17).fieldY, ((d)v17).fieldWidth, ((d)v17).fieldHeight)) {
                            this.beginSettingDragBatch();
                            this.updateColorFromField(setting, (d)v17, d3, d5);
                            this.activeColorSetting = setting;
                            this.colorDragMode = c.FIELD;
                            return true;
                        }
                        if (this.pointInRect(d3, d5, ((d)v17).alphaY - 6.0f, ((d)v17).fieldY - 4.0f, ((d)v17).alphaHeight + 12.0f, ((d)v17).fieldHeight + 8.0f)) {
                            this.beginSettingDragBatch();
                            this.updateColorFromAlpha(setting, (d)v17, d5);
                            this.activeColorSetting = setting;
                            this.colorDragMode = c.ALPHA;
                            return true;
                        }
                    }
                    i12 += 19;
                    if (this.isStringListSetting(v14, setting) && this.expandedStringListSetting == setting) {
                        i12 += this.getStringListEditorExtraHeight(setting);
                    }
                    if (setting instanceof BlocksSetting && this.expandedBlocksSetting == (v17 = (BlocksSetting)setting)) {
                        i12 += this.getBlockPickerExtraHeight((BlocksSetting)v17);
                    }
                    if (setting instanceof MobsSetting && this.expandedMobsSetting == (v17 = (MobsSetting)setting)) {
                        i12 += this.getMobPickerExtraHeight((MobsSetting)v17);
                    }
                    if (!(setting.getValue() instanceof Color) || this.expandedColorSetting != setting) continue;
                    i12 += 112;
                }
            }
        }
        this.listeningBind = null;
        this.listeningActivationBind = null;
        this.listeningString = null;
        this.stringListAddActive = false;
        this.blockSearchActive = false;
        return super.method_25402((class_11909)click, bl != 0);
    }

    public boolean method_25403(class_11909 click, double deltaX, double deltaY) {
        this.uiScale = this.computeUiScale();
        double d6 = this.toUiX(click.comp_4798());
        double d8 = this.toUiY(click.comp_4799());
        int i10 = click.method_74245();
        if (i10 != 0) {
            return super.method_25403((class_11909)click, deltaX, deltaY);
        }
        if (this.colorDragMode != c.NONE && this.activeColorSetting != null && this.updateActiveColorDrag(d6, d8)) {
            return true;
        }
        if (this.draggingNumericSetting != null && this.draggingNumericModule != null) {
            this.updateNumericSetting(this.draggingNumericModule, this.draggingNumericSetting, d6, this.draggingNumericCatX);
            return true;
        }
        if (this.draggingCategory != null) {
            int i3;
            click = CACHED_CATEGORIES;
            int i2 = 0;
            for (i3 = 0; i3 < click.length; ++i3) {
                if (click[i3] != this.draggingCategory) continue;
                i2 = i3;
                break;
            }
            i3 = CACHED_CATEGORIES.length * 140 + (CACHED_CATEGORIES.length - 1) * 12;
            int i1 = Math.max(10, (this.uiWidth() - i3) / 2);
            i1 += i2 * 152;
            i2 = this.getContentTop() + this.verticalScroll;
            int[] v3 = this.getCategoryOffset(this.draggingCategory);
            v3[0] = (int)(d6 - (double)this.dragGrabOffsetX) - i1;
            v3[1] = (int)(d8 - (double)this.dragGrabOffsetY) - i2;
            return true;
        }
        return super.method_25403((class_11909)click, deltaX, deltaY);
    }

    public boolean method_25406(class_11909 click) {
        this.activeColorSetting = null;
        this.colorDragMode = c.NONE;
        this.draggingCategory = null;
        this.draggingNumericSetting = null;
        this.draggingNumericModule = null;
        this.finishSettingDragBatch();
        return super.method_25406(click);
    }

    public void method_25432() {
        this.finishSettingDragBatch();
        super.method_25432();
    }

    public boolean method_25401(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        double d9;
        this.uiScale = this.computeUiScale();
        mouseX = this.toUiX(mouseX);
        mouseY = this.toUiY(mouseY);
        double d2 = d9 = verticalAmount != 0.0 ? verticalAmount : horizontalAmount;
        if (d9 == 0.0) {
            return super.method_25401(mouseX, mouseY, horizontalAmount, verticalAmount);
        }
        Record v5 = this.getExpandedBlocksPickerContext();
        if (v5 != null && this.pointInRect(mouseX, mouseY, v5.layout.x, v5.layout.y, v5.layout.width, v5.layout.height)) {
            this.blockPickerScroll = this.clampBlockPickerScroll(this.getFilteredBlocks(v5.setting).size(), this.blockPickerScroll + (d9 > 0.0 ? -1 : 1));
            return true;
        }
        v5 = this.getExpandedMobsPickerContext();
        if (v5 != null && this.pointInRect(mouseX, mouseY, ((e)v5).layout.x, ((e)v5).layout.y, ((e)v5).layout.width, ((e)v5).layout.height)) {
            this.mobPickerScroll = this.clampMobPickerScroll(this.getFilteredMobs(((e)v5).setting).size(), this.mobPickerScroll + (d9 > 0.0 ? -1 : 1));
            return true;
        }
        this.verticalScroll = this.clampVerticalScroll(this.verticalScroll + (int)Math.round(d9 * 24.0));
        return true;
    }

    public boolean method_25400(class_11905 input) {
        String v2 = this.sanitizeTextInput(input.method_74226());
        if (v2.isEmpty()) {
            return super.method_25400(input);
        }
        if (this.blockSearchActive && this.expandedBlocksSetting != null) {
            this.blockSearchQuery = this.blockSearchQuery + v2;
            this.blockPickerScroll = 0;
            return true;
        }
        if (this.mobSearchActive && this.expandedMobsSetting != null) {
            this.mobSearchQuery = this.mobSearchQuery + v2;
            this.mobPickerScroll = 0;
            return true;
        }
        if (this.searchActive && this.listeningString == null) {
            this.searchQuery = this.searchQuery + v2;
            return true;
        }
        if (this.stringListAddActive && this.expandedStringListSetting != null) {
            this.stringListAddBuffer = (this.stringListAddBuffer == null ? "" : this.stringListAddBuffer) + v2;
            return true;
        }
        if (this.listeningString != null) {
            this.listeningString.setValue(this.listeningString.getValue() + v2);
            return true;
        }
        return super.method_25400(input);
    }

    public boolean method_25421() {
        return false;
    }

    public boolean method_25404(class_11908 input) {
        if (this.blockSearchActive && this.expandedBlocksSetting != null && this.handleBlockSearchKeyInput(input)) {
            return true;
        }
        if (this.mobSearchActive && this.expandedMobsSetting != null && this.handleMobSearchKeyInput(input)) {
            return true;
        }
        if (this.searchActive) {
            if (this.handleSearchKeyInput(input)) {
                this.searchActive = false;
                return true;
            }
            if (input.method_74228() == 259) {
                this.searchQuery = this.removeLastCodePoint(this.searchQuery);
                return true;
            }
            if (input.method_74243()) {
                this.searchQuery = this.searchQuery + this.getClipboardText();
                return true;
            }
            return true;
        }
        if (this.listeningString != null && this.handleStringKeyInput(input)) {
            return true;
        }
        if (this.stringListAddActive && this.expandedStringListSetting != null && this.handleFriendsAddKeyInput(input)) {
            return true;
        }
        return super.method_25404(input);
    }

    private boolean handleFriendsAddKeyInput(class_11908 input) {
        if (input.method_74228() == 259) {
            this.stringListAddBuffer = this.removeLastCodePoint(this.stringListAddBuffer == null ? "" : this.stringListAddBuffer);
            return true;
        }
        if (input.method_74243()) {
            this.stringListAddBuffer = (this.stringListAddBuffer == null ? "" : this.stringListAddBuffer) + this.getClipboardText();
            return true;
        }
        if (input.method_74231()) {
            this.stringListAddActive = false;
            this.stringListAddBuffer = "";
            return true;
        }
        if (input.method_74230()) {
            if (this.expandedStringListSetting != null) {
                String v2;
                input = this.parseStringList(this.expandedStringListSetting);
                String string = v2 = this.stringListAddBuffer == null ? "" : this.stringListAddBuffer.trim();
                if (!v2.isEmpty()) {
                    v2 = v2.toLowerCase(Locale.ROOT);
                    boolean i3 = false;
                    Iterator v4 = input.iterator();
                    while (v4.hasNext()) {
                        String v5 = (String)v4.next();
                        if (!v5.equalsIgnoreCase(v2)) continue;
                        i3 = true;
                        break;
                    }
                    if (!i3) {
                        input.add(v2);
                        this.setStringListFromLowerList(this.expandedStringListSetting, (List<String>)input);
                    }
                }
            }
            this.stringListAddBuffer = "";
            return true;
        }
        return true;
    }

    private boolean matchesQuery(Module module) {
        if (module instanceof ConfigShare) {
            return false;
        }
        if (this.searchQuery.isBlank()) {
            return true;
        }
        return module.getName().toLowerCase().contains(this.searchQuery.trim().toLowerCase());
    }

    private String getBindLabel(Module module) {
        return "None".equals(module = this.getKeyDisplayName(((Module)module).getBind())) ? "" : module;
    }

    private String getKeyDisplayName(int keyCode) {
        return ClickGuiScreen.getKeyDisplayNameStatic(keyCode);
    }

    public static String getKeyDisplayNameStatic(int keyCode) {
        if (keyCode == 0) {
            return "None";
        }
        String v1 = GLFW.glfwGetKeyName((int)keyCode, (int)0);
        if (v1 != null && !v1.isBlank()) {
            return ClickGuiScreen.normalizeKeyName(v1);
        }
        return switch (keyCode) {
            case 344 -> "RShift";
            case 340 -> "LShift";
            case 345 -> "RCtrl";
            case 341 -> "LCtrl";
            case 346 -> "RAlt";
            case 342 -> "LAlt";
            case 257 -> "Enter";
            case 258 -> "Tab";
            case 259 -> "Backspace";
            case 260 -> "Insert";
            case 261 -> "Delete";
            case 268 -> "Home";
            case 269 -> "End";
            case 266 -> "Page Up";
            case 267 -> "Page Down";
            case 256 -> "Esc";
            case 32 -> "Space";
            case 280 -> "Caps";
            case 265 -> "Up";
            case 264 -> "Down";
            case 263 -> "Left";
            case 262 -> "Right";
            default -> "Key " + keyCode;
        };
    }

    private static String normalizeKeyName(String value) {
        if (value == null) {
            return "";
        }
        if ((value = value.trim()).isEmpty()) {
            return "";
        }
        return switch (value.toLowerCase()) {
            case "right shift" -> "RShift";
            case "left shift" -> "LShift";
            case "right control", "right ctrl" -> "RCtrl";
            case "left control", "left ctrl" -> "LCtrl";
            case "right alt" -> "RAlt";
            case "left alt" -> "LAlt";
            case "escape" -> "Esc";
            case "caps lock" -> "Caps";
            case "page up" -> "Page Up";
            case "page down" -> "Page Down";
            default -> value.length() == 1 ? value.toUpperCase() : value;
        };
    }

    private void drawModeSetting(class_332 context, ModeSetting setting, int rowX, int rowWidth, int rowY, float revealAlpha) {
        String v7 = ((Setting)setting).getName();
        setting = (String)((Setting)setting).getValue();
        int i8 = this.fontWidth((String)setting) + 12;
        rowWidth = rowX + rowWidth - 10 - i8;
        int i9 = rowY + 4;
        int i10 = Math.max(0, rowWidth - 4 - (rowX += 10));
        if (this.fontWidth(v7) > i10) {
            String v11 = "...";
            int i12 = this.fontWidth(v11);
            while (v7.length() > 0 && this.fontWidth(v7) + i12 > i10) {
                v7 = v7.substring(0, v7.length() - 1);
            }
            v7 = v7 + v11;
        }
        this.drawStyledText(context, v7, rowX, i9, this.multiplyAlpha(-1, revealAlpha), false);
        GuiRenderer.a((class_332)context, (float)rowWidth, (float)(rowY + 2), (float)i8, (float)12.0f, (float)5.0f, (int)this.multiplyAlpha(-15198181, revealAlpha), (boolean)false);
        GuiRenderer.a((class_332)context, (float)rowWidth, (float)(rowY + 2), (float)i8, (float)12.0f, (float)5.0f, (float)1.0f, (int)this.multiplyAlpha(0, revealAlpha), (boolean)false);
        this.drawStyledText(context, (String)setting, rowWidth + 6, i9, this.multiplyAlpha(COLOR_ACCENT, revealAlpha), false);
    }

    private void drawStringListEditor(class_332 context, Setting<String> setting, int x, int y, int w, float alpha) {
        int i10;
        int i11;
        List<String> v7 = this.parseStringList(setting);
        int i8 = Math.min(6, v7.size());
        int i9 = this.getStringListEditorExtraHeight(setting);
        GuiRenderer.a((class_332)context, (float)x, (float)y, (float)w, (float)i9, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (int)this.multiplyAlpha(0, alpha), (boolean)false);
        GuiRenderer.a((class_332)context, (float)x, (float)y, (float)w, (float)i9, (float)Math.max(0.0f, WaterPlus.getEffectiveRoundness() - 3.0f), (float)1.0f, (int)this.multiplyAlpha(0, alpha), (boolean)false);
        for (i9 = 0; i9 < i8; ++i9) {
            String v10 = v7.get(i9);
            this.drawStyledText(context, v10, x + 10, y + 4, this.multiplyAlpha(-1, alpha), false);
            i11 = x + w - 10 - 12;
            i10 = y + 2;
            GuiRenderer.a((class_332)context, (float)i11, (float)i10, (float)12.0f, (float)12.0f, (float)4.0f, (int)this.multiplyAlpha(-14011323, alpha), (boolean)false);
            GuiRenderer.a((class_332)context, (float)i11, (float)i10, (float)12.0f, (float)12.0f, (float)4.0f, (float)1.0f, (int)this.multiplyAlpha(0, alpha), (boolean)false);
            this.drawStyledText(context, "x", i11 + 4, y + 4, this.multiplyAlpha(-1938838, alpha), false);
            y += 19;
        }
        String v9 = "Add: " + (this.stringListAddBuffer == null ? "" : this.stringListAddBuffer);
        if (this.stringListAddActive && this.expandedStringListSetting == setting) {
            v9 = v9 + "_";
        }
        this.drawInputTextClipped(context, x, y, w, 17.0f, v9, x + 10, y + 4, this.multiplyAlpha(-1073741825, alpha));
        i10 = x + w - 10 - 12;
        i11 = y + 2;
        GuiRenderer.a((class_332)context, (float)i10, (float)i11, (float)12.0f, (float)12.0f, (float)4.0f, (int)this.multiplyAlpha(-15198181, alpha), (boolean)false);
        GuiRenderer.a((class_332)context, (float)i10, (float)i11, (float)12.0f, (float)12.0f, (float)4.0f, (float)1.0f, (int)this.multiplyAlpha(0, alpha), (boolean)false);
        this.drawStyledText(context, "+", i10 + 4, y + 4, this.multiplyAlpha(COLOR_ACCENT, alpha), false);
    }

    private int getPanelHeight(Category category) {
        int i2 = 38;
        int i3 = 0;
        for (Module v5 : ModuleManager.INSTANCE.getModulesInCategory(category)) {
            if (!this.matchesQuery(v5)) continue;
            ++i3;
            i2 += 19;
            String v6 = category.name() + "/" + v5.getName();
            String string = v6 + "/expand";
            float f = v5.isExpanded() ? 1.0f : 0.0f;
            float f6 = this.animValues.getOrDefault(string, Float.valueOf(f)).floatValue();
            if (!(f6 > 0.001f)) continue;
            i2 += Math.round((float)this.getModuleExpandedHeight(v5) * f6);
        }
        if (i3 == 0) {
            i2 += 19;
        }
        return i2;
    }

    private b buildBlockPickerLayout(float panelX, float panelWidth, float pickerY, BlocksSetting setting) {
        int i4 = this.getFilteredBlocks(setting).size();
        i4 = Math.min(5, Math.max(1, i4));
        float f5 = panelX + 6.0f;
        float f6 = pickerY + 6.0f;
        float f7 = panelX + panelWidth - 30.0f - 6.0f;
        float f8 = Math.max(24.0f, f7 - f5 - 4.0f);
        float f9 = f6 + 16.0f + 6.0f;
        float f10 = panelWidth - 12.0f;
        float f4 = i4 * 18;
        float f11 = 28.0f + f4 + 6.0f;
        return new b(panelX, pickerY, panelWidth, f11, f5, f6, f8, 16.0f, f7, f6, 30.0f, 16.0f, f5, f9, f10, f4);
    }

    private List<class_2248> getFilteredBlocks(BlocksSetting setting) {
        ArrayList<class_2248> v2 = new ArrayList<class_2248>(setting.filter(this.blockSearchQuery));
        v2.sort(Comparator.comparing(b2 -> !setting.contains((class_2248)b2)).thenComparing(setting::getDisplayName, String.CASE_INSENSITIVE_ORDER));
        return v2;
    }

    private String buildBlocksPreviewText(BlocksSetting setting) {
        return "Choose";
    }

    private class_1799 getPreviewBlockStack(BlocksSetting setting) {
        if ((setting = (class_2248)setting.getSelectedBlocks().stream().findFirst().orElse(null)) == null) {
            return class_1799.field_8037;
        }
        return (setting = new class_1799((class_1935)setting)).method_7960() ? class_1799.field_8037 : setting;
    }

    private String trimWithEllipsis(String text, int maxWidth) {
        if (text == null || text.isEmpty() || maxWidth <= 0) {
            return "";
        }
        if (this.fontWidth(text) <= maxWidth) {
            return text;
        }
        int i3 = this.fontWidth("...");
        if (i3 >= maxWidth) {
            return this.fontTrimToWidth(text, maxWidth);
        }
        return this.fontTrimToWidth(text, maxWidth - i3) + "...";
    }

    private String formatStringSettingValue(Module module, Setting<?> setting, String value) {
        if (value == null || value.isEmpty()) {
            return "";
        }
        if (this.isCoordSnapperWebhookSetting(module, setting)) {
            return this.abbreviateSensitiveSuffix(value, 10);
        }
        return value;
    }

    private boolean isCoordSnapperWebhookSetting(Module module, Setting<?> setting) {
        return module != null && setting != null && "CoordSnapper".equalsIgnoreCase(module.getName()) && setting.matchesName("Webhook");
    }

    private String abbreviateSensitiveSuffix(String value, int visibleChars) {
        String string = value = value == null ? "" : value.trim();
        if (value.isEmpty()) {
            return "";
        }
        int i3 = Math.max(value.lastIndexOf(47), value.lastIndexOf(92));
        String string2 = value = i3 >= 0 && i3 < value.length() - 1 ? value.substring(i3 + 1) : value;
        if (value.length() <= visibleChars) {
            return "..." + value;
        }
        return "..." + value.substring(value.length() - visibleChars);
    }

    private void drawScaledText(class_332 context, String text, float x, float y, float scale, int color) {
        if (text == null || text.isEmpty()) {
            return;
        }
        Matrix3x2fStack v7 = context.method_51448();
        v7.pushMatrix();
        v7.translate(x, y);
        v7.scale(scale, scale);
        this.drawStyledText(context, text, 0, 0, color, false);
        v7.popMatrix();
    }

    private void drawInputTextClipped(class_332 context, float cx, float cy, float cw, float ch, String text, int tx, int ty, int color) {
        int i2;
        if (text == null) {
            text = "";
        }
        String v2 = (i2 = (int)Math.max(0.0f, cw) - (tx - (int)cx) - 4) > 0 ? this.fontTrimToWidth(text, i2) : text;
        this.drawStyledText(context, v2, tx, ty, color, false);
    }

    private int getBlockPickerExtraHeight(BlocksSetting setting) {
        return Math.round(this.buildBlockPickerLayout((float)0.0f, (float)132.0f, (float)0.0f, (BlocksSetting)setting).height);
    }

    private int clampBlockPickerScroll(int itemCount, int value) {
        return Math.max(0, Math.min(Math.max(0, itemCount - 5), value));
    }

    private b buildMobPickerLayout(float panelX, float panelWidth, float pickerY, MobsSetting setting) {
        int i4 = this.getFilteredMobs(setting).size();
        i4 = Math.min(5, Math.max(1, i4));
        float f5 = panelX + 6.0f;
        float f6 = pickerY + 6.0f;
        float f7 = panelX + panelWidth - 30.0f - 6.0f;
        float f8 = Math.max(24.0f, f7 - f5 - 4.0f);
        float f9 = f6 + 16.0f + 6.0f;
        float f10 = panelWidth - 12.0f;
        float f4 = i4 * 18;
        float f11 = 28.0f + f4 + 6.0f;
        return new b(panelX, pickerY, panelWidth, f11, f5, f6, f8, 16.0f, f7, f6, 30.0f, 16.0f, f5, f9, f10, f4);
    }

    private List<class_1299<?>> getFilteredMobs(MobsSetting setting) {
        ArrayList v2 = new ArrayList(setting.filter(this.mobSearchQuery));
        v2.sort(Comparator.comparing(t -> !setting.contains((class_1299<?>)t)).thenComparing(setting::getDisplayName, String.CASE_INSENSITIVE_ORDER));
        return v2;
    }

    private int getMobPickerExtraHeight(MobsSetting setting) {
        return Math.round(this.buildMobPickerLayout((float)0.0f, (float)132.0f, (float)0.0f, (MobsSetting)setting).height);
    }

    private int clampMobPickerScroll(int itemCount, int value) {
        return Math.max(0, Math.min(Math.max(0, itemCount - 5), value));
    }

    private String buildMobsPreviewText(MobsSetting setting) {
        class_1299 v2 = setting.getSelectedMobs().stream().findFirst().orElse(null);
        if (v2 == null) {
            return "Choose";
        }
        int i3 = setting.size() - 1;
        return i3 > 0 ? setting.getDisplayName(v2) + " +" + i3 : setting.getDisplayName(v2);
    }

    private class_1799 getPreviewMobStack(MobsSetting setting) {
        if ((setting = (class_1299)setting.getSelectedMobs().stream().findFirst().orElse(null)) == null) {
            return class_1799.field_8037;
        }
        return this.getMobStack((class_1299<?>)setting);
    }

    private class_1799 getMobStack(class_1299<?> type) {
        try {
            type = class_1826.method_8019(type);
            if (type != null) {
                return new class_1799((class_1935)type);
            }
        }
        catch (Throwable throwable) {}
        return new class_1799((class_1935)class_1802.field_8803);
    }

    private void drawMobsSettingSummary(class_332 context, MobsSetting setting, float panelX, float panelWidth, float rowY, int rowHeight, float revealAlpha) {
        String v6 = this.expandedMobsSetting == setting ? "v" : ">";
        int i8 = this.fontWidth(v6);
        int i4 = Math.round(panelX + panelWidth - 6.0f - (float)i8);
        i8 = Math.max(30, i4 - (Math.round(panelX) + 10 + this.fontWidth(setting.getName()) + 14));
        int i9 = this.multiplyAlpha(this.expandedMobsSetting == setting || setting.size() > 0 ? -1 : -1073741825, revealAlpha);
        String v10 = setting.size() == 0 ? "Choose" : this.buildMobsPreviewText(setting);
        v10 = this.trimWithEllipsis(v10, Math.round((float)(i8 - 18) / 0.9f));
        i8 = Math.max(34, Math.min(i8, this.fontWidth(v10) + 22));
        int i11 = i4 - i8 - 6;
        int i12 = this.multiplyAlpha(setting.size() > 0 ? COLOR_ACCENT_DIM : -15198181, revealAlpha);
        class_1799 v13 = this.getPreviewMobStack(setting);
        this.drawStyledText(context, setting.getName(), Math.round(panelX) + 10, Math.round(rowY) + 4, i9, false);
        GuiRenderer.a((class_332)context, (float)i11, (float)(rowY + 2.0f), (float)i8, (float)12.0f, (float)5.0f, (int)i12, (boolean)false);
        GuiRenderer.a((class_332)context, (float)i11, (float)(rowY + 2.0f), (float)i8, (float)12.0f, (float)5.0f, (float)1.0f, (int)this.multiplyAlpha(0, revealAlpha), (boolean)false);
        if (!v13.method_7960()) {
            context.method_51427(v13, i11 + 2, Math.round(rowY) + 1);
        }
        this.drawScaledText(context, v10, i11 + (v13.method_7960() ? 6 : 16), rowY + 4.0f, 0.9f, this.multiplyAlpha(-1, revealAlpha));
        this.drawStyledText(context, v6, i4, Math.round(rowY) + 4, this.multiplyAlpha(-1073741825, revealAlpha), false);
    }

    private void drawMobsPicker(class_332 context, MobsSetting setting, float panelX, float panelWidth, float pickerY, int mouseX, int mouseY) {
        float f10;
        float f12;
        int i10;
        int i9;
        String v5;
        b v3 = this.buildMobPickerLayout(panelX, panelWidth, pickerY, setting);
        List<class_1299<?>> v4 = this.getFilteredMobs(setting);
        this.mobPickerScroll = this.clampMobPickerScroll(v4.size(), this.mobPickerScroll);
        GuiRenderer.a((class_332)context, (float)v3.x, (float)v3.y, (float)v3.width, (float)v3.height, (float)6.0f, (int)-15198181, (boolean)false);
        GuiRenderer.a((class_332)context, (float)v3.x, (float)v3.y, (float)v3.width, (float)v3.height, (float)6.0f, (float)1.0f, (int)0, (boolean)false);
        int i5 = this.mobSearchActive && this.expandedMobsSetting == setting ? COLOR_ACCENT : -14671840;
        GuiRenderer.a((class_332)context, (float)v3.searchX, (float)v3.searchY, (float)v3.searchWidth, (float)v3.searchHeight, (float)5.0f, (int)COLOR_PANEL_BG, (boolean)false);
        GuiRenderer.a((class_332)context, (float)v3.searchX, (float)v3.searchY, (float)v3.searchWidth, (float)v3.searchHeight, (float)5.0f, (float)1.0f, (int)i5, (boolean)false);
        GuiRenderer.a((class_332)context, (float)v3.clearX, (float)v3.clearY, (float)v3.clearWidth, (float)v3.clearHeight, (float)5.0f, (int)0, (boolean)false);
        GuiRenderer.a((class_332)context, (float)v3.clearX, (float)v3.clearY, (float)v3.clearWidth, (float)v3.clearHeight, (float)5.0f, (float)1.0f, (int)0, (boolean)false);
        String string = v5 = this.mobSearchQuery.isEmpty() ? "Search mobs..." : this.mobSearchQuery;
        if (this.mobSearchActive && this.expandedMobsSetting == setting && System.currentTimeMillis() / 500L % 2L == 0L) {
            v5 = v5 + "_";
        }
        this.drawInputTextClipped(context, v3.searchX, v3.searchY, Math.max(0.0f, v3.searchWidth), Math.max(0.0f, v3.searchHeight), v5, Math.round(v3.searchX) + 6, Math.round(v3.searchY) + 4, this.mobSearchQuery.isEmpty() && !this.mobSearchActive ? -1073741825 : -1);
        this.drawStyledText(context, "Clear", Math.round(v3.clearX) + 4, Math.round(v3.clearY) + 4, -1073741825, false);
        if (v4.isEmpty()) {
            this.drawStyledText(context, "No mobs found", Math.round(v3.listX) + 6, Math.round(v3.listY) + 4, -1073741825, false);
            return;
        }
        i5 = Math.min(5, v4.size());
        boolean i8 = v4.size() > i5;
        for (i9 = 0; i9 < i5 && (i10 = this.mobPickerScroll + i9) < v4.size(); ++i9) {
            class_1299<?> v11 = v4.get(i10);
            f12 = v3.listY + (float)(i9 * 18);
            int i13 = (float)mouseX >= v3.listX && (float)mouseX <= v3.listX + v3.listWidth && (float)mouseY >= f12 && (float)mouseY <= f12 + 18.0f - 2.0f ? 1 : 0;
            boolean i14 = setting.contains(v11);
            GuiRenderer.a((class_332)context, (float)v3.listX, (float)f12, (float)v3.listWidth, (float)16.0f, (float)5.0f, (int)(i14 ? 0 : (i13 != 0 ? 0xAFFFFFF : 0)), (boolean)false);
            GuiRenderer.a((class_332)context, (float)v3.listX, (float)f12, (float)v3.listWidth, (float)16.0f, (float)5.0f, (float)1.0f, (int)0, (boolean)false);
            class_1799 v10 = this.getMobStack(v11);
            i13 = Math.round(v3.listX) + 5;
            if (!v10.method_7960()) {
                context.method_51427(v10, Math.round(v3.listX) + 2, Math.round(f12) + 1);
                i13 += 16;
            }
            f10 = v3.listX + v3.listWidth - 10.0f;
            this.drawScaledText(context, this.trimWithEllipsis(setting.getDisplayName(v11), Math.round((f10 - (float)i13 - 4.0f) / 0.9f)), i13, f12 + 4.0f, 0.9f, i14 ? COLOR_ACCENT : -1);
            GuiRenderer.a((class_332)context, (float)f10, (float)(f12 + 5.0f), (float)6.0f, (float)6.0f, (float)2.5f, (int)(i14 ? COLOR_ACCENT : -15198181), (boolean)false);
            GuiRenderer.a((class_332)context, (float)f10, (float)(f12 + 5.0f), (float)6.0f, (float)6.0f, (float)2.5f, (float)1.0f, (int)(i14 ? COLOR_ACCENT : -14671840), (boolean)false);
        }
        if (i8) {
            i9 = Math.max(1, v4.size() - i5);
            f10 = v3.listX + v3.listWidth - 4.0f;
            float f11 = v3.listY + 1.0f;
            f12 = v3.listHeight - 2.0f;
            float f13 = Math.max(12.0f, f12 * ((float)i5 / (float)v4.size()));
            float f14 = (f12 - f13) * ((float)this.mobPickerScroll / (float)i9);
            GuiRenderer.a((class_332)context, (float)f10, (float)f11, (float)4.0f, (float)f12, (float)2.0f, (int)COLOR_PANEL_BG, (boolean)false);
            GuiRenderer.a((class_332)context, (float)f10, (float)(f11 + f14), (float)4.0f, (float)f13, (float)2.0f, (int)COLOR_ACCENT_DIM, (boolean)false);
        }
    }

    private d buildColorPickerLayout(float panelX, float panelWidth, float rowY, int rowHeight) {
        panelWidth = rowY + (float)rowHeight + 6.0f;
        rowY = (panelX += 4.0f) + 80.0f + 6.0f;
        return new d(panelX, panelWidth, 80.0f, 80.0f, rowY, 24.0f);
    }

    private boolean updateActiveColorDrag(double mouseX, double mouseY) {
        int i5 = this.getContentTop() + this.verticalScroll;
        for (int i6 = 0; i6 < CACHED_CATEGORIES.length; ++i6) {
            Category v7 = CACHED_CATEGORIES[i6];
            int i8 = this.getCategoryX(v7, i6);
            int i9 = i5 + 22 + 6;
            for (Module module : ModuleManager.INSTANCE.getModulesInCategory(v7)) {
                if (!this.matchesQuery(module)) continue;
                i9 += 19;
                if (!module.isExpanded()) continue;
                i9 += 19;
                i9 += 19;
                for (Setting<Color> v11 : module.getSettings()) {
                    Object v12;
                    if (v11 == this.activeColorSetting && v11.getValue() instanceof Color) {
                        v12 = this.buildColorPickerLayout(i8 + 4, 132.0f, i9, 17);
                        if (this.colorDragMode == c.FIELD) {
                            this.updateColorFromField(v11, (d)v12, mouseX, mouseY);
                        } else if (this.colorDragMode == c.ALPHA) {
                            this.updateColorFromAlpha(v11, (d)v12, mouseY);
                        }
                        return true;
                    }
                    i9 += 19;
                    if (v11 instanceof BlocksSetting && this.expandedBlocksSetting == (v12 = (BlocksSetting)v11)) {
                        i9 += this.getBlockPickerExtraHeight((BlocksSetting)v12);
                    }
                    if (v11 instanceof MobsSetting && this.expandedMobsSetting == (v12 = (MobsSetting)v11)) {
                        i9 += this.getMobPickerExtraHeight((MobsSetting)v12);
                    }
                    if (!(v11.getValue() instanceof Color) || this.expandedColorSetting != v11) continue;
                    i9 += 112;
                }
            }
        }
        return false;
    }

    private e getExpandedMobsPickerContext() {
        if (this.expandedMobsSetting == null) {
            return null;
        }
        int i1 = this.getContentTop() + this.verticalScroll;
        for (int i2 = 0; i2 < CACHED_CATEGORIES.length; ++i2) {
            Category v3 = CACHED_CATEGORIES[i2];
            int i4 = this.getCategoryX(v3, i2);
            int i5 = i1 + 22 + 6;
            for (Module module : ModuleManager.INSTANCE.getModulesInCategory(v3)) {
                if (!this.matchesQuery(module)) continue;
                i5 += 19;
                if (!module.isExpanded()) continue;
                i5 += 19;
                i5 += 19;
                for (Setting<?> v7 : module.getSettings()) {
                    Setting v8;
                    if (v7 == this.expandedMobsSetting) {
                        return new e(this.expandedMobsSetting, this.buildMobPickerLayout(i4 + 4, 132.0f, i5 + 19, this.expandedMobsSetting));
                    }
                    i5 += 19;
                    if (v7 instanceof BlocksSetting && this.expandedBlocksSetting == (v8 = (BlocksSetting)v7)) {
                        i5 += this.getBlockPickerExtraHeight((BlocksSetting)v8);
                    }
                    if (v7 instanceof MobsSetting && this.expandedMobsSetting == (v8 = (MobsSetting)v7)) {
                        i5 += this.getMobPickerExtraHeight((MobsSetting)v8);
                    }
                    if (!(v7.getValue() instanceof Color) || this.expandedColorSetting != v7) continue;
                    i5 += 112;
                }
            }
        }
        return null;
    }

    private a getExpandedBlocksPickerContext() {
        if (this.expandedBlocksSetting == null) {
            return null;
        }
        int i1 = this.getContentTop() + this.verticalScroll;
        for (int i2 = 0; i2 < CACHED_CATEGORIES.length; ++i2) {
            Category v3 = CACHED_CATEGORIES[i2];
            int i4 = this.getCategoryX(v3, i2);
            int i5 = i1 + 22 + 6;
            for (Module module : ModuleManager.INSTANCE.getModulesInCategory(v3)) {
                if (!this.matchesQuery(module)) continue;
                i5 += 19;
                if (!module.isExpanded()) continue;
                i5 += 19;
                i5 += 19;
                for (Setting<?> v7 : module.getSettings()) {
                    Setting v8;
                    if (v7 == this.expandedBlocksSetting) {
                        return new a(this.expandedBlocksSetting, this.buildBlockPickerLayout(i4 + 4, 132.0f, i5 + 19, this.expandedBlocksSetting));
                    }
                    i5 += 19;
                    if (v7 instanceof BlocksSetting && this.expandedBlocksSetting == (v8 = (BlocksSetting)v7)) {
                        i5 += this.getBlockPickerExtraHeight((BlocksSetting)v8);
                    }
                    if (v7 instanceof MobsSetting && this.expandedMobsSetting == (v8 = (MobsSetting)v7)) {
                        i5 += this.getMobPickerExtraHeight((MobsSetting)v8);
                    }
                    if (!(v7.getValue() instanceof Color) || this.expandedColorSetting != v7) continue;
                    i5 += 112;
                }
            }
        }
        return null;
    }

    private boolean handleSearchKeyInput(class_11908 input) {
        return input.method_74231() || input.method_74230();
    }

    private boolean handleBlockSearchKeyInput(class_11908 input) {
        if (input.method_74228() == 259) {
            this.blockSearchQuery = this.removeLastCodePoint(this.blockSearchQuery);
            this.blockPickerScroll = 0;
            return true;
        }
        if (input.method_74243()) {
            this.blockSearchQuery = this.blockSearchQuery + this.getClipboardText();
            this.blockPickerScroll = 0;
            return true;
        }
        if (input.method_74231() || input.method_74230()) {
            this.blockSearchActive = false;
            return true;
        }
        return true;
    }

    private boolean handleMobSearchKeyInput(class_11908 input) {
        if (input.method_74228() == 259) {
            this.mobSearchQuery = this.removeLastCodePoint(this.mobSearchQuery);
            this.mobPickerScroll = 0;
            return true;
        }
        if (input.method_74243()) {
            this.mobSearchQuery = this.mobSearchQuery + this.getClipboardText();
            this.mobPickerScroll = 0;
            return true;
        }
        if (input.method_74231() || input.method_74230()) {
            this.mobSearchActive = false;
            return true;
        }
        return true;
    }

    private boolean handleStringKeyInput(class_11908 input) {
        if (input.method_74228() == 259) {
            this.listeningString.setValue(this.removeLastCodePoint(this.listeningString.getValue()));
            return true;
        }
        if (input.method_74243()) {
            this.listeningString.setValue(this.listeningString.getValue() + this.getClipboardText());
            return true;
        }
        if (input.method_74231() || input.method_74230()) {
            this.listeningString = null;
            return true;
        }
        return true;
    }

    private int getContentTop() {
        return 16;
    }

    private int getTallestPanelHeight() {
        int i1 = 0;
        for (Category v5 : CACHED_CATEGORIES) {
            i1 = Math.max(i1, this.getPanelHeight(v5));
        }
        return i1;
    }

    private int clampVerticalScroll(int value) {
        int i2 = Math.max(0, this.uiHeight() - this.getContentTop() - 16);
        i2 = Math.min(0, i2 - this.getTallestPanelHeight());
        return Math.max(i2, Math.min(0, value));
    }

    private String getClipboardText() {
        return this.sanitizeTextInput(class_310.method_1551().field_1774.method_1460());
    }

    private String sanitizeTextInput(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder v2 = new StringBuilder(input.length());
        input.codePoints().filter(cp -> !Character.isISOControl(cp)).forEach(v2::appendCodePoint);
        return v2.toString();
    }

    private String removeLastCodePoint(String value) {
        if (value == null || value.isEmpty()) {
            return "";
        }
        return value.substring(0, value.offsetByCodePoints(value.length(), -1));
    }

    private void updateColorFromField(Setting<Color> setting, d layout, double mouseX, double mouseY) {
        Color v7 = setting.getValue();
        float f8 = this.getHue(v7);
        float f3 = this.clamp01((float)((mouseX - (double)layout.fieldX) / (double)layout.fieldWidth));
        float f2 = 1.0f - this.clamp01((float)((mouseY - (double)layout.fieldY) / (double)layout.fieldHeight));
        int i2 = Color.HSBtoRGB(f8, f3, f2);
        setting.setValue(new Color(i2 >> 16 & 0xFF, i2 >> 8 & 0xFF, i2 & 0xFF, v7.getAlpha()));
    }

    private void updateColorFromAlpha(Setting<Color> setting, d layout, double mouseY) {
        float f2 = this.clamp01((float)((mouseY - (double)layout.fieldY) / (double)layout.fieldHeight));
        Color v3 = setting.getValue();
        int i2 = Color.HSBtoRGB(f2, this.getSaturation(v3), this.getBrightness(v3));
        setting.setValue(new Color(i2 >> 16 & 0xFF, i2 >> 8 & 0xFF, i2 & 0xFF, v3.getAlpha()));
    }

    private boolean pointInRect(double x, double y, float rx, float ry, float rw, float rh) {
        return x >= (double)rx && x <= (double)(rx + rw) && y >= (double)ry && y <= (double)(ry + rh);
    }

    private boolean allowDecimalForModule(Module module) {
        if (module == null) {
            return false;
        }
        module = ((Module)module).getName() == null ? "" : ((Module)module).getName().toLowerCase().replace(" ", "");
        return ((String)module).equals("swingspeed") || ((String)module).equals("freelook") || ((String)module).equals("fastplace") || ((String)module).equals("playeresp") || ((String)module).equals("storageesp") || ((String)module).equals("freecam") || ((String)module).equals("holeesp") || ((String)module).equals("jumpcircles") || ((String)module).equals("autototem") || ((String)module).equals("autoinvtotem") || ((String)module).equals("hitbox") || ((String)module).equals("anchormacro") || ((String)module).equals("autocrystal") || ((String)module).equals("doubleanchor") || ((String)module).equals("triggerbot") || ((String)module).equals("shieldbreaker") || ((String)module).equals("spotifyhud") || ((String)module).equals("Fashionstylecrack+") || ((String)module).equals("hud") || ((String)module).equals("spawnernotifier") || ((String)module).equals("nametags");
    }

    private void beginSettingDragBatch() {
        if (!this.batchingSettingDrag) {
            this.batchingSettingDrag = true;
            ModuleManager.INSTANCE.d();
        }
    }

    private void finishSettingDragBatch() {
        if (this.batchingSettingDrag) {
            this.batchingSettingDrag = false;
            ModuleManager.INSTANCE.e();
        }
    }

    private void updateNumericSetting(Module module, Setting<?> setting, double mouseX, int catX) {
        double d6 = Math.max(0.0, Math.min(1.0, (mouseX - (double)(catX + 10)) / 120.0));
        boolean i1 = this.allowDecimalForModule(module);
        if (setting.getValue() instanceof Float && setting.getMin() instanceof Float && setting.getMax() instanceof Float) {
            float f9 = ((Float)setting.getMin()).floatValue();
            float f10 = ((Float)setting.getMax()).floatValue();
            float f11 = (float)((double)f9 + (double)(f10 - f9) * d6);
            if (!i1) {
                f11 = Math.round(f11);
            }
            setting.setValue(Float.valueOf(f11));
            return;
        }
        if (setting.getValue() instanceof Integer && setting.getMin() instanceof Integer && setting.getMax() instanceof Integer) {
            int i9 = (Integer)setting.getMin();
            int i10 = (Integer)setting.getMax();
            int i11 = (int)Math.round((double)i9 + (double)(i10 - i9) * d6);
            setting.setValue(Math.max(i9, Math.min(i10, i11)));
            return;
        }
        if (setting.getValue() instanceof Double && setting.getMin() instanceof Double && setting.getMax() instanceof Double) {
            double d9 = (Double)setting.getMin();
            double d11 = (Double)setting.getMax();
            double d13 = d9 + (d11 - d9) * d6;
            if (!i1) {
                d13 = Math.round(d13);
            }
            setting.setValue(d13);
        }
    }

    private float clamp01(float value) {
        return Math.max(0.0f, Math.min(1.0f, value));
    }

    private int withAlpha(int color, float alpha) {
        int i2 = Math.max(0, Math.min(255, Math.round(alpha * 255.0f)));
        return color & 0xFFFFFF | i2 << 24;
    }

    private int multiplyAlpha(int color, float alphaMul) {
        int i3 = color >> 24 & 0xFF;
        int i2 = Math.max(0, Math.min(255, Math.round((float)i3 * alphaMul)));
        return color & 0xFFFFFF | i2 << 24;
    }

    private int multiplyAlpha(Color color, float alphaMul) {
        int i2 = Math.max(0, Math.min(255, Math.round((float)color.getAlpha() * alphaMul)));
        return i2 << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
    }

    private float easeOutCubic(float t) {
        t = this.clamp01(t);
        return 1.0f - (float)Math.pow(1.0f - t, 3.0);
    }

    public void method_25420(class_332 context, int mouseX, int mouseY, float deltaTicks) {
    }

    static String _c35bbdbeb99() {
        return "W";
    }

    private static /* synthetic */ boolean lambda$mouseClicked$1(String tr, String n) {
        return n.equalsIgnoreCase(tr);
    }

    static {
        for (Category v3 : Category.values()) {
            CATEGORY_TEXTURES.put(v3, class_2960.method_60655((String)"water", (String)("textures/gui/categories/" + v3.name().toLowerCase(Locale.ROOT) + ".png")));
        }
    }

    private static enum c {
        NONE,
        FIELD,
        ALPHA;

    }

    private static final class b {
        private final float field_0;
        private final float field_1;
        private final float width;
        private final float height;
        private final float searchX;
        private final float searchY;
        private final float searchWidth;
        private final float searchHeight;
        private final float clearX;
        private final float clearY;
        private final float clearWidth;
        private final float clearHeight;
        private final float listX;
        private final float listY;
        private final float listWidth;
        private final float listHeight;

        private b(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
            this.searchX = f5;
            this.searchY = f6;
            this.searchWidth = f7;
            this.searchHeight = f8;
            this.clearX = f9;
            this.clearY = f10;
            this.clearWidth = f11;
            this.clearHeight = f12;
            this.listX = f13;
            this.listY = f14;
            this.listWidth = f15;
            this.listHeight = f16;
        }
    }

    private static final class d {
        private final float fieldX;
        private final float fieldY;
        private final float fieldWidth;
        private final float fieldHeight;
        private final float alphaY;
        private final float alphaHeight;

        private d(float f, float f2, float f3, float f4, float f5, float f6) {
            this.fieldX = f;
            this.fieldY = f2;
            this.fieldWidth = f3;
            this.fieldHeight = f4;
            this.alphaY = f5;
            this.alphaHeight = f6;
        }
    }

    private record a(BlocksSetting setting, b layout) {
    }

    private record e(MobsSetting setting, b layout) {
    }
}

