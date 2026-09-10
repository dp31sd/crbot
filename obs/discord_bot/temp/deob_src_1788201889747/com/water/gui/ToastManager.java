/*
 * Decompiled with CFR 0.152.
 */
package com.water.gui;

import com.water.module.modules.client.WaterPlus;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.class_156;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_332;

public final class ToastManager {
    public static final ToastManager INSTANCE = new ToastManager();
    private static final long DISPLAY_MS = 3500L;
    private static final long ANIMATION_MS = 220L;
    private static final int MAX_NOTIFICATIONS = 5;
    private static final float CARD_WIDTH = 170.0f;
    private static final float CARD_HEIGHT = 36.0f;
    private static final float CARD_GAP = 5.0f;
    private static final float ICON_SIZE = 16.0f;
    private static final float ICON_PAD = 7.0f;
    private static final float ACCENT_BAR = 3.0f;
    private final List<a> notifications = new CopyOnWriteArrayList<a>();

    private ToastManager() {
    }

    public void pushToggle(String string, boolean bl) {
        this.pushToggle(string, bl, class_1799.field_8037);
    }

    public void pushToggle(String string, boolean bl, class_1799 class_17992) {
        this.push(string, bl ? "Enabled" : "Disabled", class_17992, bl ? WaterPlus.getAccentARGB() : -2076576);
    }

    public void renderToasts(class_332 class_3322) {
        this.render(class_3322);
    }

    public void push(String string, String string2, class_1799 class_17992, int n) {
        this.notifications.add(0, new a(string == null ? "" : string, string2 == null ? "" : string2, class_17992 == null ? class_1799.field_8037 : class_17992.method_7972(), n, class_156.method_658()));
        while (this.notifications.size() > 5) {
            this.notifications.remove(this.notifications.size() - 1);
        }
    }

    public void render(class_332 class_3322) {
        if (this.notifications.isEmpty()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        long l = class_156.method_658();
        this.notifications.removeIf(a2 -> a2.isExpired(l));
        if (this.notifications.isEmpty()) {
            return;
        }
        class_3322.method_71048();
        float f = (float)class_3102.method_22683().method_4486() - 170.0f - 8.0f;
        float f2 = (float)class_3102.method_22683().method_4502() - 36.0f - 8.0f;
        float f3 = WaterPlus.getGuiRoundness();
        for (int i = 0; i < this.notifications.size(); ++i) {
            a a3 = this.notifications.get(i);
            float f4 = a3.getVisibility(l);
            if (f4 <= 0.0f) continue;
            float f5 = f + (1.0f - f4) * 184.0f;
            float f6 = f2 - (float)i * 41.0f;
            ToastManager.withAlpha(a3.accentColor, f4);
            int n = ToastManager.withAlpha(WaterPlus.getBackgroundARGB(), f4 * 0.97f);
            int n2 = ToastManager.withAlpha(-16777216, f4 * 0.45f);
            int n3 = ToastManager.withAlpha(ToastManager.blendColors(WaterPlus.getBackgroundARGB(), a3.accentColor, 0.25f), f4);
            GuiRenderer.a((class_332)class_3322, (float)(f5 + 2.0f), (float)(f6 + 2.0f), (float)170.0f, (float)36.0f, (float)f3, (int)n2, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)f5, (float)f6, (float)170.0f, (float)36.0f, (float)f3, (int)n, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)f5, (float)f6, (float)170.0f, (float)36.0f, (float)f3, (float)1.0f, (int)n3, (boolean)false);
            f5 = f5 + 7.0f + 3.0f;
            float f7 = f6 + 10.0f;
            n2 = ToastManager.withAlpha(-15724528, f4 * 0.7f);
            GuiRenderer.a((class_332)class_3322, (float)(f5 - 2.0f), (float)(f7 - 2.0f), (float)20.0f, (float)20.0f, (float)(f3 * 0.5f), (int)n2, (boolean)false);
            if (!a3.stack.method_7960()) {
                class_3322.method_51427(a3.stack, (int)f5, (int)f7);
            }
            WaterFontRenderer waterFontRenderer = WaterFontRenderer.INSTANCE;
            n2 = ToastManager.withAlpha(-1, f4);
            int n4 = ToastManager.withAlpha(a3.accentColor | 0xFF000000, f4);
            f5 = f5 + 16.0f + 6.0f;
            waterFontRenderer.a("A");
            waterFontRenderer.a(class_3322, a3.message, f5, f6 + 8.0f, n2);
            waterFontRenderer.a(class_3322, a3.details, f5, f6 + 20.0f, n4);
        }
    }

    private static int withAlpha(int n, float f) {
        int n2 = Math.max(0, Math.min(255, Math.round((float)(n >>> 24 & 0xFF) * f)));
        return n & 0xFFFFFF | n2 << 24;
    }

    private static int blendColors(int n, int n2, float f) {
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        n &= 0xFF;
        int n5 = n2 >> 16 & 0xFF;
        int n6 = n2 >> 8 & 0xFF;
        n3 = (int)((float)n3 + (float)(n5 - n3) * f);
        n4 = (int)((float)n4 + (float)(n6 - n4) * f);
        n = (int)((float)n + (float)((n2 &= 0xFF) - n) * f);
        return 0xFF000000 | n3 << 16 | n4 << 8 | n;
    }

    static String _c98900d3603() {
        return "R";
    }

    private static final class a {
        private final String message;
        private final String details;
        private final class_1799 stack;
        private final int accentColor;
        private final long createdAt;

        private a(String string, String string2, class_1799 class_17992, int n, long l) {
            this.message = string;
            this.details = string2;
            this.stack = class_17992;
            this.accentColor = n | 0xFF000000;
            this.createdAt = l;
        }

        private boolean isExpired(long l) {
            return l - this.createdAt >= 3500L;
        }

        private float getVisibility(long l) {
            long l2 = l - this.createdAt;
            if (l2 <= 0L) {
                return 0.0f;
            }
            if (l2 < 220L) {
                return this.easeOut((float)l2 / 220.0f);
            }
            if (l2 > 3280L) {
                return this.easeOut(Math.max(0.0f, 1.0f - (float)(l2 - 3280L) / 220.0f));
            }
            return 1.0f;
        }

        private float easeOut(float f) {
            f = 1.0f - Math.max(0.0f, Math.min(1.0f, f));
            return 1.0f - f * f * f;
        }
    }
}

