/*
 * Decompiled with CFR 0.152.
 */
package com.water.gui;

import com.water.gui.SpotifyBrowserScreen;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.client.Hud;
import com.water.module.modules.client.SpotifyHud;
import com.water.module.modules.client.WaterPlus;
import com.water.utils.renderer.GuiRenderer;
import java.util.ArrayList;
import java.util.Comparator;
import net.minecraft.class_1293;
import net.minecraft.class_1304;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.lwjgl.glfw.GLFW;

public final class HudEditor {
    public static final HudEditor INSTANCE = new HudEditor();
    private static final int HANDLE_SIZE = 8;
    private String dragging = null;
    private int grabOffsetX;
    private int grabOffsetY;
    private boolean isDragging = false;
    private String resizing = null;
    private int resizeStartX;
    private int resizeStartY;
    private float resizeStartScale;
    public static volatile boolean isEditing = false;

    private HudEditor() {
    }

    private static float method_0() {
        return Hud.a();
    }

    public boolean onMouseClick(double d2, double d3, int n) {
        if (n != 0 && n != 1) {
            return false;
        }
        for (Hud.a a2 : Hud.a.values()) {
            if (!Hud.a((Hud.a)a2) || !HudEditor.hasContent(a2)) continue;
            int[] nArray = HudEditor.handlePos(a2);
            int n2 = HudEditor.handleW(a2);
            int n3 = HudEditor.handleH(a2);
            if (n == 0 && HudEditor.isOnResizeHandle(d2, d3, nArray, n2, n3)) {
                this.resizing = a2.name();
                this.resizeStartX = (int)d2;
                this.resizeStartY = (int)d3;
                this.resizeStartScale = HudEditor.elementScale(a2);
                this.isDragging = false;
                this.dragging = null;
                isEditing = true;
                return true;
            }
            if (!(d2 >= (double)nArray[0]) || !(d2 <= (double)(nArray[0] + n2)) || !(d3 >= (double)nArray[1]) || !(d3 <= (double)(nArray[1] + n3))) continue;
            if (n == 1 && a2 == Hud.a.h) {
                class_310 class_3102 = class_310.method_1551();
                if (class_3102 != null) {
                    class_3102.method_1507((class_437)new SpotifyBrowserScreen(class_3102.field_1755));
                }
                return true;
            }
            if (n != 0) continue;
            this.dragging = a2.name();
            this.grabOffsetX = (int)(d2 - (double)nArray[0]);
            this.grabOffsetY = (int)(d3 - (double)nArray[1]);
            this.isDragging = true;
            this.resizing = null;
            isEditing = true;
            return true;
        }
        if (n == 0) {
            this.dragging = null;
            this.isDragging = false;
            this.resizing = null;
        }
        return false;
    }

    public boolean isDragging() {
        return this.dragging != null && this.isDragging || this.resizing != null;
    }

    public boolean isResizing() {
        return this.resizing != null;
    }

    public void onMouseDrag(double d2, double d3) {
        boolean bl;
        class_310 class_3102 = class_310.method_1551();
        boolean bl2 = bl = class_3102 != null && class_3102.method_22683() != null && GLFW.glfwGetMouseButton((long)class_3102.method_22683().method_4490(), (int)0) == 1;
        if (!bl) {
            this.onMouseRelease();
            return;
        }
        if (this.resizing != null) {
            try {
                Hud.a a2 = Hud.a.valueOf(this.resizing);
                double d4 = d2 - (double)this.resizeStartX;
                double d5 = d3 - (double)this.resizeStartY;
                double d6 = d4 + d5;
                float f = Math.max(0.5f, Math.min(3.0f, this.resizeStartScale + (float)(d6 * (double)0.006f)));
                Hud.a((Hud.a)a2, (float)f);
            }
            catch (Exception exception) {}
            return;
        }
        if (this.dragging == null || !this.isDragging) {
            return;
        }
        try {
            Hud.a a3 = Hud.a.valueOf(this.dragging);
            float f = Hud.a((Hud.a)a3);
            if (a3 == Hud.a.h) {
                int n = (int)Math.round(d2 - (double)this.grabOffsetX);
                int n2 = (int)Math.round(d3 - (double)this.grabOffsetY);
                if (class_3102 != null && class_3102.method_22683() != null) {
                    int n3 = class_3102.method_22683().method_4486();
                    int n4 = class_3102.method_22683().method_4502();
                    int n5 = SpotifyHud.a();
                    int n6 = SpotifyHud.b();
                    n = Math.max(0, Math.min(n, n3 - n5));
                    n2 = Math.max(0, Math.min(n2, n4 - n6));
                }
                Hud.a((Hud.a)a3, (int)n, (int)n2);
            } else {
                int n = (int)Math.round((d2 - (double)this.grabOffsetX) / (double)f);
                int n7 = (int)Math.round((d3 - (double)this.grabOffsetY) / (double)f);
                if (class_3102 != null && class_3102.method_22683() != null) {
                    int n8 = class_3102.method_22683().method_4486();
                    int n9 = class_3102.method_22683().method_4502();
                    int[] nArray = a3 == Hud.a.d ? Hud.a() : Hud.b((Hud.a)a3);
                    int n10 = nArray[2];
                    int n11 = nArray[3];
                    if (n10 < 1) {
                        n10 = 1;
                    }
                    if (n11 < 1) {
                        n11 = 1;
                    }
                    if (n8 > 0) {
                        n = Math.max(0, Math.min(n, (int)(((float)n8 - (float)n10 * f) / f)));
                    }
                    if (n9 > 0) {
                        n7 = Math.max(0, Math.min(n7, (int)(((float)n9 - (float)n11 * f) / f)));
                    }
                }
                if (a3 == Hud.a.d) {
                    int[] nArray = Hud.a();
                    Hud.a((Hud.a)a3, (int)(n + nArray[2]), (int)n7);
                } else {
                    Hud.a((Hud.a)a3, (int)n, (int)n7);
                }
            }
        }
        catch (Exception exception) {}
    }

    public void onMouseRelease() {
        this.dragging = null;
        this.isDragging = false;
        this.resizing = null;
        isEditing = false;
    }

    public boolean onMouseScroll(double d2, double d3, double d4) {
        if (d4 == 0.0) {
            return false;
        }
        if (!Hud.a((Hud.a)Hud.a.h)) {
            return false;
        }
        int[] nArray = Hud.a((Hud.a)Hud.a.h);
        int n = SpotifyHud.a();
        int n2 = SpotifyHud.b();
        if (d2 < (double)nArray[0] || d2 > (double)(nArray[0] + n) || d3 < (double)nArray[1] || d3 > (double)(nArray[1] + n2)) {
            return false;
        }
        SpotifyHud.a((float)(SpotifyHud.b() + (float)(d4 * 0.08)));
        return true;
    }

    public void render(class_332 class_3322, int n, int n2) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return;
        }
        int n3 = WaterPlus.getAccentARGB();
        float f = WaterPlus.getGuiRoundness();
        for (Hud.a a2 : Hud.a.values()) {
            boolean bl;
            if (!Hud.a((Hud.a)a2) || !HudEditor.hasContent(a2) && a2 != Hud.a.h) continue;
            int[] nArray = HudEditor.handlePos(a2);
            int n4 = HudEditor.handleW(a2);
            int n5 = HudEditor.handleH(a2);
            if (a2 == Hud.a.d) {
                int[] nArray2 = Hud.a();
                GuiRenderer.a((class_332)class_3322, (float)nArray2[0], (float)nArray2[1], (float)nArray2[2], (float)nArray2[3], (float)3.0f, (float)1.0f, (int)n3, (boolean)false);
            } else if (a2 == Hud.a.e) {
                if (class_3102.field_1724 == null) continue;
                class_327 class_3272 = class_3102.field_1772;
                Object object = new ArrayList<class_1293>(class_3102.field_1724.method_6026());
                object.sort(Comparator.comparingInt(class_12932 -> class_3272.method_1727(Hud.a((class_1293)class_12932))));
                int[] nArray3 = Hud.a((Hud.a)Hud.a.e);
                int n6 = nArray3[1];
                object = object.iterator();
                while (object.hasNext()) {
                    Object object2 = (class_1293)object.next();
                    object2 = Hud.a((class_1293)object2);
                    int n7 = class_3272.method_1727((String)object2) + 14;
                    GuiRenderer.a((class_332)class_3322, (float)nArray3[0], (float)n6, (float)n7, (float)14.0f, (float)5.0f, (float)1.0f, (int)n3, (boolean)false);
                    n6 += 17;
                }
            } else {
                GuiRenderer.a((class_332)class_3322, (float)nArray[0], (float)nArray[1], (float)n4, (float)n5, (float)f, (float)1.0f, (int)n3, (boolean)false);
            }
            if (a2 == Hud.a.d || a2 == Hud.a.e) continue;
            boolean bl2 = HudEditor.isOnResizeHandle(n, n2, nArray, n4, n5);
            boolean bl3 = bl = this.resizing != null && this.resizing.equals(a2.name());
            int n8 = bl ? n3 : (bl2 ? HudEditor.blendArgb(n3, -1, 0.3f) : n3 & 0xFFFFFF | 0x99000000);
            float f2 = nArray[0] + n4 - 8;
            float f3 = nArray[1] + n5 - 8;
            GuiRenderer.a((class_332)class_3322, (float)f2, (float)f3, (float)8.0f, (float)8.0f, (float)Math.min(f, 4.0f), (int)n8, (boolean)false);
            class_3322.method_25294((int)(f2 + 2.0f), (int)(f3 + 8.0f - 3.0f), (int)(f2 + 8.0f - 1.0f), (int)(f3 + 8.0f - 2.0f), -855638017);
            class_3322.method_25294((int)(f2 + 2.0f), (int)(f3 + 8.0f - 5.0f), (int)(f2 + 8.0f - 3.0f), (int)(f3 + 8.0f - 4.0f), -855638017);
        }
    }

    private static boolean isOnResizeHandle(double d2, double d3, int[] nArray, int n, int n2) {
        return d2 >= (double)(nArray[0] + n - 8) && d2 <= (double)(nArray[0] + n) && d3 >= (double)(nArray[1] + n2 - 8) && d3 <= (double)(nArray[1] + n2);
    }

    private static float elementScale(Hud.a a2) {
        return Hud.a((Hud.a)a2);
    }

    private static int blendArgb(int n, int n2, float f) {
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        n = n >> 24 & 0xFF;
        int n6 = n2 >> 16 & 0xFF;
        int n7 = n2 >> 8 & 0xFF;
        int n8 = n2 & 0xFF;
        n2 = n2 >> 24 & 0xFF;
        return (int)((float)n + (float)(n2 - n) * f) << 24 | (int)((float)n3 + (float)(n6 - n3) * f) << 16 | (int)((float)n4 + (float)(n7 - n4) * f) << 8 | (int)((float)n5 + (float)(n8 - n5) * f);
    }

    private static boolean hasContent(Hud.a object) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return false;
        }
        return switch (1.$SwitchMap$com$water$module$modules$client$Hud$HudElement[((Enum)object).ordinal()]) {
            case 1 -> {
                if (class_3102.field_1724 == null) {
                    yield false;
                }
                Object var2_3 = object = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};
                ((Object)var2_3).length;
                for (int var0_1 = 0; var0_1 < 4; ++var0_1) {
                    Object var3_6 = var2_3[var0_1];
                    if ((var3_6 = class_3102.field_1724.method_6118((class_1304)var3_6)) == null || var3_6.method_7960()) continue;
                    yield true;
                }
                yield false;
            }
            case 2 -> {
                if (class_3102.field_1724 == null) {
                    yield false;
                }
                if (!class_3102.field_1724.method_6026().isEmpty()) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                for (Module var2_4 : ModuleManager.INSTANCE.getModules()) {
                    if (!var2_4.isEnabled() || var2_4.getCategory() == Category.e) continue;
                    yield true;
                }
                yield false;
            }
            case 4 -> {
                for (Module var2_5 : ModuleManager.INSTANCE.getModules()) {
                    if (var2_5.getBind() == 0) continue;
                    yield true;
                }
                yield false;
            }
            default -> true;
        };
    }

    private static int[] handlePos(Hud.a object) {
        float f = Hud.a((Hud.a)((Object)object));
        if (object == Hud.a.d) {
            object = Hud.a();
            return new int[]{(int)object[0], (int)object[1]};
        }
        if (object == Hud.a.h) {
            object = Hud.a((Hud.a)((Object)object));
            class_310 class_3102 = class_310.method_1551();
            if (class_3102 != null && class_3102.method_22683() != null) {
                int n = Math.max(0, class_3102.method_22683().method_4486() - SpotifyHud.a());
                int n2 = Math.max(0, class_3102.method_22683().method_4502() - SpotifyHud.b());
                return new int[]{Math.max(0, Math.min((int)object[0], n)), Math.max(0, Math.min((int)object[1], n2))};
            }
            return new int[]{(int)object[0], (int)object[1]};
        }
        object = Hud.a((Hud.a)((Object)object));
        return new int[]{Math.round((float)object[0] * f), Math.round((float)object[1] * f)};
    }

    private static int handleW(Hud.a a2) {
        float f = Hud.a((Hud.a)a2);
        if (a2 == Hud.a.d) {
            return Math.round((float)Hud.a()[2] * f);
        }
        if (a2 == Hud.a.h) {
            return SpotifyHud.a();
        }
        return Math.round((float)Hud.b((Hud.a)a2)[2] * f);
    }

    private static int handleH(Hud.a a2) {
        float f = Hud.a((Hud.a)a2);
        if (a2 == Hud.a.d) {
            return Math.round((float)Hud.a()[3] * f);
        }
        if (a2 == Hud.a.h) {
            return SpotifyHud.b();
        }
        return Math.round((float)Hud.b((Hud.a)a2)[3] * f);
    }

    static String _c4e6cf034db() {
        return "A";
    }
}

