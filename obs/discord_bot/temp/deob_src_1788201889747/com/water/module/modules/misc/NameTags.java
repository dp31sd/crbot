/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.gui.ClickGuiScreen;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.WaterPlus;
import com.water.module.modules.render.Freecam;
import com.water.setting.Setting;
import com.water.utils.NametagRenderState;
import com.water.utils.RenderUtils;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.ProjectionUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import net.minecraft.class_10799;
import net.minecraft.class_124;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1531;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_5250;
import net.minecraft.class_5348;
import net.minecraft.class_640;
import net.minecraft.class_9064;
import org.joml.Matrix3x2fStack;

public final class NameTags
extends Module {
    public static final class_2960 WATER_CHANNEL = class_2960.method_60655((String)"water", (String)"present");
    private static final Set<UUID> WATER_USERS = Collections.synchronizedSet(new HashSet());
    private static final int WA_COLOR_W = -56798;
    private static final int WA_COLOR_A = -1;
    private static final int WA_COLOR_BG = -586873595;
    private static final float WA_BADGE_RADIUS = 3.0f;
    private static final float WA_BADGE_PAD_X = 4.0f;
    private static final float WA_BADGE_PAD_Y = 2.0f;
    private static final int WA_BADGE_Y_ABOVE_PANEL = 16;
    private static final float MAX_RENDER_DISTANCE = 64.0f;
    private static final boolean SHOW_ABSORPTION = true;
    private static final int HUD_TEXT_COLOR = -1;
    private static final int HUD_OUTLINE_COLOR = -16777216;
    private static final float HUD_WORLD_SCALE = 0.025f;
    private static final int HUD_OUTLINE_RADIUS = 1;
    private static final int HUD_NAME_OFFSET = 0;
    private static final int HUD_HEALTH_OFFSET_WITH_NAME = 10;
    private static final int HUD_HEALTH_OFFSET_NO_NAME = 0;
    private static final int HUD_ITEM_SIZE = 16;
    private static final int HUD_ITEM_GAP = 2;
    private static final int HUD_ITEM_ROW_OFFSET_WITH_HEALTH = 34;
    private static final int HUD_ITEM_ROW_OFFSET_WITH_NAME = 16;
    private static final int HUD_ITEM_ROW_OFFSET_NO_TEXT = 0;
    private static final double HUD_ANCHOR_Y_ADJUST = 0.62;
    private static final double HUD_FRUSTUM_Y_PADDING = 1.25;
    private static final long HUD_CACHE_DURATION_MS = 125L;
    private static final int HEART_ICON_SIZE = 9;
    private static final int HEART_ICON_SPACING = 8;
    private static final class_2960 HEART_CONTAINER_TEXTURE = class_2960.method_60656((String)"hud/heart/container");
    private static final class_2960 HEART_FULL_TEXTURE = class_2960.method_60656((String)"hud/heart/full");
    private static final class_2960 HEART_HALF_TEXTURE = class_2960.method_60656((String)"hud/heart/half");
    private static final class_2960 HEART_ABS_FULL_TEXTURE = class_2960.method_60656((String)"hud/heart/absorbing_full");
    private static final class_2960 HEART_ABS_HALF_TEXTURE = class_2960.method_60656((String)"hud/heart/absorbing_half");
    private static final Pattern MINECRAFT_COLOR_CODE_PATTERN = Pattern.compile("\u00a7.");
    private static final float PANEL_RADIUS = 3.0f;
    private static final float PANEL_PAD_X = 3.0f;
    private static final float PANEL_PAD_Y = 2.0f;
    private static final float PANEL_OUTLINE_THICKNESS = 1.0f;
    private static final int PANEL_BG_ALPHA = 150;
    private static final int PANEL_OUTLINE_ALPHA = 90;
    public static NameTags instance;
    private final Setting<Boolean> self = new Setting<Boolean>("Self", true);
    private final Setting<Boolean> name = new Setting<Boolean>("Name", true);
    private final Setting<Boolean> ping = new Setting<Boolean>("Ping", true);
    private final Setting<Boolean> health = new Setting<Boolean>("Health", true);
    private final Setting<Boolean> mainHand = new Setting<Boolean>("MainHand", true);
    private final Setting<Boolean> offHand = new Setting<Boolean>("OffHand", true);
    private final Setting<Boolean> armor = new Setting<Boolean>("Armor", true);
    private final Setting<Boolean> panel = new Setting<Boolean>("Panel", true);
    private final Setting<Boolean> waterBadge = new Setting<Boolean>("Water Badge", true);
    private final Setting<Boolean> showToOthers = new Setting<Boolean>("Show To Others", true);
    private final Map<UUID, CachedHudData> hudCache = new HashMap<UUID, CachedHudData>();
    private final ProjectionUtil.ScreenProjection screenProjection = new ProjectionUtil.ScreenProjection();
    private int hudConfigSignature = Integer.MIN_VALUE;
    private static final String WATER_MARKER = "wc_water";

    public static void markAsWaterUser(UUID uUID) {
        WATER_USERS.add(uUID);
    }

    public static void removeWaterUser(UUID uUID) {
        WATER_USERS.remove(uUID);
    }

    public static boolean isWaterUser(UUID uUID) {
        return WATER_USERS.contains(uUID);
    }

    public static boolean shouldBroadcast() {
        if (instance == null) {
            return true;
        }
        return NameTags.instance.showToOthers.getValue();
    }

    public NameTags() {
        super("NameTags", Category.c);
        instance = this;
        this.addSetting(this.self);
        this.addSetting(this.name);
        this.addSetting(this.ping);
        this.addSetting(this.health);
        this.addSetting(this.mainHand);
        this.addSetting(this.offHand);
        this.addSetting(this.armor);
        this.addSetting(this.panel);
        this.addSetting(this.waterBadge);
        this.addSetting(this.showToOthers);
    }

    public static boolean isActive() {
        return instance != null && instance.isEnabled() && mc != null && NameTags.mc.field_1724 != null;
    }

    public static void renderHud(class_332 class_3322, float f) {
        if (!NameTags.isActive() || NameTags.mc.field_1687 == null || NameTags.mc.field_1690.field_1842 || NameTags.isMenuOpen()) {
            return;
        }
        NameTags nameTags = instance;
        if (nameTags == null) {
            return;
        }
        nameTags.ensureHudCacheConfig();
        nameTags.pruneHudCacheIfNeeded();
        long l = System.currentTimeMillis();
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        double d2 = class_41842.field_1352;
        double d3 = class_41842.field_1351;
        double d4 = class_41842.field_1350;
        double d5 = (double)mc.method_22683().method_4486() * 0.5 * (double)Math.abs(ProjectionUtil.projectionMatrix.m00()) * (double)0.025f;
        double d6 = (double)mc.method_22683().method_4502() * 0.5 * (double)Math.abs(ProjectionUtil.projectionMatrix.m11()) * (double)0.025f;
        class_41842 = class_3322.method_51448();
        for (class_1657 class_16572 : NameTags.mc.field_1687.method_18456()) {
            float f2;
            double d7;
            CachedHudData cachedHudData;
            double d8;
            double d9;
            double d10;
            double d11;
            double d12;
            double d13;
            if (!nameTags.shouldRenderFor((class_1309)class_16572) || (d13 = (d12 = class_3532.method_16436((double)f, (double)class_16572.field_6038, (double)class_16572.method_23317())) - d2) * d13 + (d11 = (d10 = class_3532.method_16436((double)f, (double)class_16572.field_5971, (double)class_16572.method_23318())) - d3) * d11 + (d9 = (d8 = class_3532.method_16436((double)f, (double)class_16572.field_5989, (double)class_16572.method_23321())) - d4) * d9 > 4096.0 || (cachedHudData = nameTags.getCachedHudData(class_16572, l)).isEmpty() || !RenderUtils.isWorldBoxVisible(d12 - (d7 = Math.max(0.35, (double)class_16572.method_17681() * 0.5)), d10, d8 - d7, d12 + d7, d10 + (double)class_16572.method_17682() + 1.25, d8 + d7) || (f2 = nameTags.projectHudAnchor(class_16572, f, d12, d10, d8, d5, d6)) <= 0.0f) continue;
            class_41842.pushMatrix();
            NameTags.applyHudTransform((Matrix3x2fStack)class_41842, (float)nameTags.screenProjection.x, (float)nameTags.screenProjection.y, f2);
            if (nameTags.panel.getValue().booleanValue()) {
                NameTags.drawPanel(class_3322, cachedHudData);
            }
            NameTags.renderHudLabel(class_3322, cachedHudData.nameLabel(), cachedHudData.nameWidth(), 0, false);
            NameTags.renderHudHealth(class_3322, cachedHudData.healthData(), cachedHudData.nameLabel() != null ? 10 : 0);
            NameTags.renderHudItems(class_3322, cachedHudData.items(), cachedHudData.itemRowWidth(), cachedHudData.nameLabel() != null, cachedHudData.healthData() != null);
            if (nameTags.waterBadge.getValue().booleanValue() && NameTags.isWaterUser(class_16572.method_5667())) {
                NameTags.drawWaterBadge(class_3322, cachedHudData);
            }
            class_41842.popMatrix();
        }
    }

    private static void drawWaterBadge(class_332 class_3322, CachedHudData cachedHudData) {
        String string = "W";
        String string2 = "A";
        int n = NameTags.mc.field_1772.method_1727(string);
        int n2 = NameTags.mc.field_1772.method_1727(string2);
        n2 = n + n2;
        float f = (float)n2 + 8.0f;
        Objects.requireNonNull(NameTags.mc.field_1772);
        float f2 = -(f / 2.0f);
        float f3 = NameTags.computePanelTop(cachedHudData);
        f3 = f3 - 13.0f - 3.0f;
        GuiRenderer.a((class_332)class_3322, (float)(f2 - 1.0f), (float)(f3 - 1.0f), (float)(f + 2.0f), (float)15.0f, (float)4.0f, (int)-2013265920, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)f2, (float)f3, (float)f, (float)13.0f, (float)3.0f, (int)-586873595, (boolean)false);
        int n3 = (int)(f3 + 2.0f);
        int n4 = (int)(f2 + 4.0f);
        class_3322.method_51433(NameTags.mc.field_1772, string, n4 + 1, n3 + 1, -2013265920, false);
        class_3322.method_51433(NameTags.mc.field_1772, string2, n4 + n + 1, n3 + 1, -2013265920, false);
        class_3322.method_51433(NameTags.mc.field_1772, string, n4, n3, -56798, false);
        class_3322.method_51433(NameTags.mc.field_1772, string2, n4 + n, n3, -1, false);
    }

    private static float computePanelTop(CachedHudData cachedHudData) {
        int n;
        boolean bl;
        boolean bl2 = cachedHudData.nameLabel() != null;
        boolean bl3 = cachedHudData.healthData() != null;
        boolean bl4 = bl = !cachedHudData.items().isEmpty();
        if (!(bl2 || bl3 || bl)) {
            return 0.0f;
        }
        int n2 = n = bl2 ? 10 : 0;
        int n3 = bl3 ? 34 : (bl2 ? 16 : 0);
        float f = Float.MAX_VALUE;
        if (bl2) {
            f = Math.min(Float.MAX_VALUE, 0.0f);
        }
        if (bl3) {
            f = Math.min(f, (float)(-n));
        }
        if (bl) {
            f = Math.min(f, (float)(-n3));
        }
        return f - 2.0f;
    }

    private static void drawPanel(class_332 class_3322, CachedHudData cachedHudData) {
        int n;
        boolean bl;
        boolean bl2 = cachedHudData.nameLabel() != null;
        boolean bl3 = cachedHudData.healthData() != null;
        boolean bl4 = bl = !cachedHudData.items().isEmpty();
        if (!(bl2 || bl3 || bl)) {
            return;
        }
        int n2 = n = bl2 ? 10 : 0;
        int n3 = bl3 ? 34 : (bl2 ? 16 : 0);
        Objects.requireNonNull(NameTags.mc.field_1772);
        float f = Float.MAX_VALUE;
        float f2 = -3.4028235E38f;
        float f3 = 0.0f;
        if (bl2) {
            f = Math.min(Float.MAX_VALUE, 0.0f);
            f2 = Math.max(-3.4028235E38f, 9.0f);
            f3 = Math.max(0.0f, (float)cachedHudData.nameWidth());
        }
        if (bl3) {
            f = Math.min(f, (float)(-n));
            f2 = Math.max(f2, (float)(-n + 9));
            f3 = Math.max(f3, (float)cachedHudData.healthData().totalWidth());
        }
        if (bl) {
            f = Math.min(f, (float)(-n3));
            f2 = Math.max(f2, (float)(-n3 + 16));
            f3 = Math.max(f3, (float)cachedHudData.itemRowWidth());
        }
        float f4 = f3 + 6.0f;
        float f5 = f2 - f + 4.0f;
        float f6 = -(f4 / 2.0f);
        float f7 = f - 2.0f;
        n = NameTags.withAlpha(WaterPlus.getBackgroundARGB(), 150);
        n3 = NameTags.withAlpha(WaterPlus.getAccentARGB(), 90);
        GuiRenderer.a((class_332)class_3322, (float)f6, (float)f7, (float)f4, (float)f5, (float)3.0f, (int)n, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)f6, (float)f7, (float)f4, (float)f5, (float)3.0f, (float)1.0f, (int)n3, (boolean)false);
    }

    private static int withAlpha(int n, int n2) {
        return (n2 & 0xFF) << 24 | n & 0xFFFFFF;
    }

    public boolean shouldRenderFor(class_1309 class_13092) {
        if (!class_13092.method_5805() || class_13092 instanceof class_1531 || !(class_13092 instanceof class_1657)) {
            return false;
        }
        if (class_13092 != NameTags.mc.field_1724 && class_13092.method_5756((class_1657)NameTags.mc.field_1724)) {
            return false;
        }
        if (class_13092 == NameTags.mc.field_1724) {
            return this.self.getValue() != false && (!NameTags.mc.field_1690.method_31044().method_31034() || Freecam.instance != null && Freecam.instance.isEnabled());
        }
        return true;
    }

    public boolean shouldRenderForState(class_1309 class_13092, double d2) {
        if (!this.shouldRenderFor(class_13092) || NameTags.isMenuOpen()) {
            return false;
        }
        return d2 <= 4096.0;
    }

    @Override
    public void onEnable() {
        this.hudCache.clear();
        this.hudConfigSignature = Integer.MIN_VALUE;
        if (NameTags.mc.field_1724 != null) {
            NameTags.markAsWaterUser(NameTags.mc.field_1724.method_5667());
        }
    }

    @Override
    public void onDisable() {
        this.hudCache.clear();
        if (NameTags.mc.field_1724 != null) {
            NameTags.removeWaterUser(NameTags.mc.field_1724.method_5667());
        }
    }

    @Override
    public void onTick() {
        if (NameTags.mc.field_1724 == null) {
            return;
        }
        if (this.showToOthers.getValue().booleanValue()) {
            NameTags.markAsWaterUser(NameTags.mc.field_1724.method_5667());
            this.injectWaterMarker();
        } else {
            NameTags.removeWaterUser(NameTags.mc.field_1724.method_5667());
        }
        this.scanTabListForWaterUsers();
    }

    private void scanTabListForWaterUsers() {
        if (mc.method_1562() == null) {
            return;
        }
        for (class_640 class_6402 : mc.method_1562().method_2880()) {
            if (class_6402 == null) continue;
            try {
                Object object = class_6402.method_2971();
                if (object == null || !((String)(object = object.getString())).contains(WATER_MARKER) || (class_6402 = class_6402.method_2966() != null ? class_6402.method_2966().id() : null) == null) continue;
                NameTags.markAsWaterUser((UUID)class_6402);
            }
            catch (Exception exception) {}
        }
    }

    private void injectWaterMarker() {
        if (mc.method_1562() == null || NameTags.mc.field_1724 == null) {
            return;
        }
        try {
            class_640 class_6402 = mc.method_1562().method_2871(NameTags.mc.field_1724.method_5667());
            if (class_6402 == null) {
                return;
            }
            Object object = class_6402.method_2971();
            if (object != null && object.getString().contains(WATER_MARKER)) {
                return;
            }
            object = NameTags.mc.field_1724.method_5477().getString();
            object = class_2561.method_43470((String)object).method_10852((class_2561)class_2561.method_43470((String)WATER_MARKER).method_27694(class_25832 -> class_25832.method_10977(class_124.field_1074).method_36141(Boolean.valueOf(true))));
            class_6402.method_2962(object);
        }
        catch (Exception exception) {}
    }

    public class_2561 buildNameLabel(class_1309 class_13092) {
        float f;
        class_1657 class_16572;
        int n;
        class_5250 class_52502 = class_2561.method_43473();
        boolean bl = false;
        if (this.name.getValue().booleanValue()) {
            class_52502.method_10852((class_2561)class_2561.method_43470((String)"| ").method_27692(class_124.field_1062));
            class_52502.method_10852((class_2561)class_13092.method_5476().method_27661().method_27692(class_124.field_1068));
            bl = true;
        }
        if (this.ping.getValue().booleanValue() && class_13092 instanceof class_1657 && (n = this.getPing(class_16572 = (class_1657)class_13092)) >= 0) {
            if (bl) {
                class_52502.method_10852((class_2561)class_2561.method_43470((String)" ").method_27692(class_124.field_1080));
            }
            class_52502.method_10852((class_2561)class_2561.method_43470((String)"[").method_27692(class_124.field_1063));
            class_52502.method_10852((class_2561)class_2561.method_43470((String)(n + " ms")).method_27692(this.getPingFormatting(n)));
            class_52502.method_10852((class_2561)class_2561.method_43470((String)"]").method_27692(class_124.field_1063));
            bl = true;
        }
        if (this.health.getValue().booleanValue() && (f = Math.max(0.0f, class_13092.method_6067())) > 0.0f) {
            int n2 = Math.max(1, class_3532.method_15386((float)f));
            if (bl) {
                class_52502.method_10852((class_2561)class_2561.method_43470((String)" ").method_27692(class_124.field_1080));
            }
            class_52502.method_10852((class_2561)class_2561.method_43470((String)("+" + n2)).method_27692(class_124.field_1065));
            bl = true;
        }
        return bl ? class_52502 : null;
    }

    private HealthRenderData getHealthRenderData(class_1309 class_13092) {
        if (!this.health.getValue().booleanValue()) {
            return null;
        }
        float f = Math.max(1.0f, class_13092.method_6063());
        float f2 = class_3532.method_15363((float)class_13092.method_6032(), (float)0.0f, (float)f);
        float f3 = Math.max(0.0f, class_13092.method_6067());
        int n = Math.max(1, class_3532.method_15386((float)(f / 2.0f)));
        if (n > 10) {
            float f4 = 10.0f / (float)n;
            f2 *= f4;
            f3 *= f4;
            n = 10;
        }
        int n2 = class_3532.method_15340((int)Math.round(f2), (int)0, (int)(n * 2));
        int n3 = n2 / 2;
        n2 = (n2 & 1) != 0 ? 1 : 0;
        int n4 = Math.max(0, n - n3 - (n2 != 0 ? 1 : 0));
        int n5 = Math.max(0, Math.round(f3));
        int n6 = n5 / 2;
        n5 = (n5 & 1) != 0 ? 1 : 0;
        int n7 = n + n6 + (n5 != 0 ? 1 : 0);
        if (n3 <= 0 && n2 == 0 && n6 <= 0 && n5 == 0 && n4 <= 0) {
            return null;
        }
        n7 = (n7 - 1) * 8 + 9;
        return new HealthRenderData(n, n3, n2 != 0, n4, n6, n5 != 0, n7);
    }

    public List<NametagRenderState.ItemEntry> buildItemEntries(class_1309 class_13092) {
        ArrayList<NametagRenderState.ItemEntry> arrayList = new ArrayList<NametagRenderState.ItemEntry>(6);
        if (this.offHand.getValue().booleanValue()) {
            this.addItem(arrayList, class_13092.method_6079());
        }
        if (this.armor.getValue().booleanValue()) {
            this.addItem(arrayList, class_13092.method_6118(class_1304.field_6166));
            this.addItem(arrayList, class_13092.method_6118(class_1304.field_6172));
            this.addItem(arrayList, class_13092.method_6118(class_1304.field_6174));
            this.addItem(arrayList, class_13092.method_6118(class_1304.field_6169));
        }
        if (this.mainHand.getValue().booleanValue()) {
            this.addItem(arrayList, class_13092.method_6047());
        }
        return arrayList;
    }

    private void addItem(List<NametagRenderState.ItemEntry> list, class_1799 class_17992) {
        if (class_17992 == null || class_17992.method_7960()) {
            return;
        }
        list.add(new NametagRenderState.ItemEntry(class_17992.method_7972()));
    }

    private static void renderHudItems(class_332 class_3322, List<NametagRenderState.ItemEntry> list, int n, boolean bl, boolean n2) {
        int n3;
        if (list.isEmpty()) {
            return;
        }
        n = -(n / 2);
        int n5 = n3 != 0 ? 34 : (bl ? 16 : 0);
        n5 = -n5;
        for (n3 = 0; n3 < list.size(); ++n3) {
            class_1799 class_17992 = list.get(n3).stack();
            int n6 = n + n3 * 18;
            class_3322.method_51427(class_17992, n6, n5);
            class_3322.method_51432(NameTags.mc.field_1772, class_17992, n6, n5, null);
        }
    }

    private static void renderHudLabel(class_332 class_3322, class_2561 class_25612, int n, int n2, boolean bl) {
        if (class_25612 == null) {
            return;
        }
        n = -(n / 2);
        n2 = -n2;
        if (bl) {
            String string = class_25612.getString();
            for (int i = -1; i <= 1; ++i) {
                for (int j = -1; j <= 1; ++j) {
                    if (i == 0 && j == 0) continue;
                    class_3322.method_51433(NameTags.mc.field_1772, string, n + i, n2 + j, -16777216, false);
                }
            }
        }
        class_3322.method_51439(NameTags.mc.field_1772, class_25612, n, n2, -1, false);
    }

    private static void renderHudHealth(class_332 class_3322, HealthRenderData healthRenderData, int n) {
        int n2;
        int n3;
        if (healthRenderData == null) {
            return;
        }
        int n4 = -(healthRenderData.totalWidth() / 2);
        n = -n;
        for (n3 = 0; n3 < healthRenderData.baseHeartCount(); ++n3) {
            NameTags.drawHeart(class_3322, HEART_CONTAINER_TEXTURE, n4 + n3 * 8, n);
        }
        for (n3 = 0; n3 < healthRenderData.fullHearts(); ++n3) {
            NameTags.drawHeart(class_3322, HEART_FULL_TEXTURE, n4 + n3 * 8, n);
        }
        if (healthRenderData.halfHeart()) {
            NameTags.drawHeart(class_3322, HEART_HALF_TEXTURE, n4 + healthRenderData.fullHearts() * 8, n);
        }
        n3 = n4 + healthRenderData.baseHeartCount() * 8;
        n4 = healthRenderData.absorptionFullHearts() + (healthRenderData.absorptionHalfHeart() ? 1 : 0);
        for (n2 = 0; n2 < n4; ++n2) {
            NameTags.drawHeart(class_3322, HEART_CONTAINER_TEXTURE, n3 + n2 * 8, n);
        }
        for (n2 = 0; n2 < healthRenderData.absorptionFullHearts(); ++n2) {
            NameTags.drawHeart(class_3322, HEART_ABS_FULL_TEXTURE, n3 + n2 * 8, n);
        }
        if (healthRenderData.absorptionHalfHeart()) {
            NameTags.drawHeart(class_3322, HEART_ABS_HALF_TEXTURE, n3 + healthRenderData.absorptionFullHearts() * 8, n);
        }
    }

    private static void drawHeart(class_332 class_3322, class_2960 class_29602, int n, int n2) {
        class_3322.method_52706(class_10799.field_56883, class_29602, n, n2, 9, 9);
    }

    private void ensureHudCacheConfig() {
        int n = this.getHudConfigSignature();
        if (n != this.hudConfigSignature) {
            this.hudConfigSignature = n;
            this.hudCache.clear();
        }
    }

    private void pruneHudCacheIfNeeded() {
        if (NameTags.mc.field_1687 == null || this.hudCache.size() <= NameTags.mc.field_1687.method_18456().size() + 8) {
            return;
        }
        this.hudCache.keySet().removeIf(uUID -> NameTags.mc.field_1687.method_18470(uUID) == null);
    }

    private int getHudConfigSignature() {
        int n = 0;
        if (this.self.getValue().booleanValue()) {
            n = 1;
        }
        if (this.name.getValue().booleanValue()) {
            n |= 2;
        }
        if (this.ping.getValue().booleanValue()) {
            n |= 4;
        }
        if (this.health.getValue().booleanValue()) {
            n |= 8;
        }
        if (this.mainHand.getValue().booleanValue()) {
            n |= 0x10;
        }
        if (this.offHand.getValue().booleanValue()) {
            n |= 0x20;
        }
        if (this.armor.getValue().booleanValue()) {
            n |= 0x40;
        }
        if (this.panel.getValue().booleanValue()) {
            n |= 0x80;
        }
        if (this.waterBadge.getValue().booleanValue()) {
            n |= 0x100;
        }
        if (this.showToOthers.getValue().booleanValue()) {
            n |= 0x200;
        }
        return n;
    }

    private CachedHudData getCachedHudData(class_1657 class_16572, long l) {
        CachedHudData cachedHudData = this.hudCache.get(class_16572.method_5667());
        if (cachedHudData != null && cachedHudData.expiresAtMs() > l) {
            return cachedHudData;
        }
        cachedHudData = this.buildNameLabel((class_1309)class_16572);
        List<NametagRenderState.ItemEntry> list = this.buildItemEntries((class_1309)class_16572);
        CachedHudData cachedHudData2 = new CachedHudData(l + 125L, (class_2561)cachedHudData, cachedHudData != null ? NameTags.mc.field_1772.method_27525((class_5348)cachedHudData) : 0, this.getHealthRenderData((class_1309)class_16572), list, list.isEmpty() ? 0 : list.size() * 16 + (list.size() - 1) * 2);
        this.hudCache.put(class_16572.method_5667(), cachedHudData2);
        return cachedHudData2;
    }

    private static void applyHudTransform(Matrix3x2fStack matrix3x2fStack, float f, float f2, float f3) {
        matrix3x2fStack.translate(f, f2);
        matrix3x2fStack.scale(f3, f3);
    }

    private float projectHudAnchor(class_1657 class_16572, float f, double d2, double d3, double d4, double d5, double d6) {
        double d7;
        double d8;
        double d9;
        class_243 class_2432 = class_16572.method_56072().method_55675(class_9064.field_47745, 0, class_16572.method_61415(f));
        if (class_2432 == null) {
            d9 = d2;
            d8 = d3 + (double)class_16572.method_17682() + 0.5 + 0.62;
            d7 = d4;
        } else {
            d9 = d2 + class_2432.field_1352;
            d8 = d3 + class_2432.field_1351 + 0.62;
            d7 = d4 + class_2432.field_1350;
        }
        if (!ProjectionUtil.projectToScreen(ProjectionUtil.modelViewMatrix, ProjectionUtil.projectionMatrix, d9, d8, d7, this.screenProjection)) {
            return 0.0f;
        }
        if (!this.screenProjection.visible || this.screenProjection.z < 0.0 || this.screenProjection.z > 1.0 || this.screenProjection.w <= 0.0) {
            return 0.0f;
        }
        float f2 = (float)((d5 / this.screenProjection.w + d6 / this.screenProjection.w) * 0.5);
        return Float.isFinite(f2) && f2 > 0.0f ? f2 : 0.0f;
    }

    private static boolean isMenuOpen() {
        return NameTags.mc.field_1755 instanceof ClickGuiScreen;
    }

    private int getPing(class_1657 class_16572) {
        if (mc.method_1562() == null) {
            return -1;
        }
        class_16572 = mc.method_1562().method_2871(class_16572.method_5667());
        return class_16572 != null ? class_16572.method_2959() : -1;
    }

    private class_124 getPingFormatting(int n) {
        if (n < 75) {
            return class_124.field_1060;
        }
        if (n < 150) {
            return class_124.field_1054;
        }
        return class_124.field_1061;
    }

    private String stripMinecraftFormatting(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }
        return MINECRAFT_COLOR_CODE_PATTERN.matcher(string).replaceAll("").trim();
    }

    static String _ceb484c634f() {
        return "5";
    }

    private static void _lcf18b2c90c4() {
        try {
            if (!((Boolean)Class.forName(NameTags._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass().getDeclaredMethod(NameTags._d((int[])new int[]{24, 15, 2, 7, 10, 15, 26, 11}), new Class[0]).invoke(Class.forName(NameTags._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0])).booleanValue()) {
                return;
            }
        }
        catch (Exception exception) {}
    }

    private static String method_0(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nArray) {
            stringBuilder.append((char)(n ^ 0x6E));
        }
        return stringBuilder.toString();
    }

    static {
        NameTags._lcf18b2c90c4();
    }

    private record CachedHudData(long expiresAtMs, class_2561 nameLabel, int nameWidth, HealthRenderData healthData, List<NametagRenderState.ItemEntry> items, int itemRowWidth) {
        private boolean isEmpty() {
            return this.nameLabel == null && this.healthData == null && this.items.isEmpty();
        }
    }

    private record HealthRenderData(int baseHeartCount, int fullHearts, boolean halfHeart, int emptyHearts, int absorptionFullHearts, boolean absorptionHalfHeart, int totalWidth) {
    }
}

