/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils.renderer;

import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.water.utils.renderer.Arc2DRenderer;
import com.water.utils.renderer.Blur2DRenderer;
import com.water.utils.renderer.Outline2DRenderer;
import com.water.utils.renderer.Rectangle2DRenderer;
import com.water.utils.renderer.Texture2DRenderer;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1041;
import net.minecraft.class_1044;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;

public class GuiRenderer {
    private static final List<Runnable> field_0;

    public static int method_0() {
        class_1041 class_10412 = class_310.method_1551().method_22683();
        return (int)Math.ceil((double)class_10412.method_4480() / 1.0);
    }

    public static int method_1() {
        class_1041 class_10412 = class_310.method_1551().method_22683();
        return (int)Math.ceil((double)class_10412.method_4507() / 1.0);
    }

    public static Matrix4f method_2(class_332 class_3322) {
        class_1041 class_10412 = class_310.method_1551().method_22683();
        class_3322 = class_3322.method_51448();
        return new Matrix4f().ortho(0.0f, (float)class_10412.method_4486(), (float)class_10412.method_4502(), 0.0f, -1000.0f, 1000.0f).mul((Matrix4fc)new Matrix4f(class_3322.m00, class_3322.m01, 0.0f, 0.0f, class_3322.m10, class_3322.m11, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, class_3322.m20, class_3322.m21, 0.0f, 1.0f));
    }

    public static void method_3(class_332 class_3322, float f, float f2, float f3, float f4, float f5, int n, boolean bl) {
        GuiRenderer.a((Matrix4f)GuiRenderer.a((class_332)class_3322), (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (int)n, (boolean)bl);
    }

    public static void method_4(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl, int ... nArray) {
        GuiRenderer.a((Matrix4f)GuiRenderer.a((class_332)class_3322), (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)f7, (float)f8, (boolean)bl, (int[])nArray);
    }

    public static void method_5(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, int n, boolean bl) {
        GuiRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f5, (float)f5, (float)f5, (boolean)bl, (int[])new int[]{n});
    }

    public static void method_6(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl, int ... nArray) {
        if (bl) {
            j.add((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(org.joml.Matrix4f float float float float float float float float int[] ), ()V)((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)f7, (float)f8, (int[])nArray));
            return;
        }
        Rectangle2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)f7, (float)f8, (float)0.0f, (int[])nArray);
    }

    public static void method_7(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n, boolean bl) {
        GuiRenderer.a((Matrix4f)GuiRenderer.a((class_332)class_3322), (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f5, (float)f5, (float)f5, (float)f6, (int)n, (boolean)bl);
    }

    public static void method_8(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, boolean bl) {
        if (bl) {
            j.add((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(org.joml.Matrix4f float float float float float float float float float int ), ()V)((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)f7, (float)f8, (float)f9, (int)n));
            return;
        }
        Outline2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)f7, (float)f8, (float)f9, (float)0.0f, (int[])new int[]{n});
    }

    public static void method_9(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        class_3322 = GuiRenderer.a((class_332)class_3322);
        if (bl) {
            j.add((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(org.joml.Matrix4f float float float float float float ), ()V)((Matrix4f)class_3322, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6));
            return;
        }
        Blur2DRenderer.a((Matrix4f)class_3322, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)0.0f);
    }

    public static void method_10(class_332 class_3322, float f, float f2, float f3, float f4, float f5, float f6, int n, boolean bl) {
        GuiRenderer.a((Matrix4f)GuiRenderer.a((class_332)class_3322), (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (int)n, (boolean)bl);
    }

    public static void method_11(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, int n, boolean bl) {
        if (bl) {
            j.add((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(org.joml.Matrix4f float float float float float float int ), ()V)((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (int)n));
            return;
        }
        Arc2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)0.0f, (int[])new int[]{n});
    }

    public static void method_12(class_332 class_3322, float f, float f2, float f3, class_2960 class_29602, int n, float f4, boolean bl) {
        GuiRenderer.a((Matrix4f)GuiRenderer.a((class_332)class_3322), (float)f, (float)f2, (float)f3, (class_2960)class_29602, (int)n, (float)f4, (boolean)bl);
    }

    public static void method_13(Matrix4f matrix4f, float f, float f2, float f3, class_2960 class_29602, int n, float f4, boolean bl) {
        class_310 class_3102 = class_310.method_1551();
        class_29602 = class_3102.method_1531().method_4619(class_29602);
        if (class_29602 != null) {
            if (bl) {
                j.add((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(org.joml.Matrix4f float float float net.minecraft.class_1044 int float ), ()V)((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (class_1044)class_29602, (int)n, (float)f4));
                return;
            }
            Texture2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (GpuTextureView)class_29602.method_71659(), (int)n, (float)f4, (float)0.0f);
        }
    }

    public static void method_14(RenderPass renderPass) {
    }

    private static /* synthetic */ void method_15(Matrix4f matrix4f, float f, float f2, float f3, class_1044 class_10442, int n, float f4) {
        Texture2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (GpuTextureView)class_10442.method_71659(), (int)n, (float)f4, (float)0.0f);
    }

    private static /* synthetic */ void method_16(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, int n) {
        Arc2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)0.0f, (int[])new int[]{n});
    }

    private static /* synthetic */ void method_17(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6) {
        Blur2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)0.0f);
    }

    private static /* synthetic */ void method_18(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n) {
        Outline2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)f7, (float)f8, (float)f9, (float)0.0f, (int[])new int[]{n});
    }

    private static /* synthetic */ void method_19(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int[] nArray) {
        Rectangle2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (float)f5, (float)f6, (float)f7, (float)f8, (float)0.0f, (int[])nArray);
    }

    static {
        j = new ArrayList();
    }
}

