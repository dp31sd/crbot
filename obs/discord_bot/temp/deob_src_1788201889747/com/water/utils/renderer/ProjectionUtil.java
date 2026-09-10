/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils.renderer;

import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_3545;
import net.minecraft.class_4184;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL11;

public class ProjectionUtil {
    public static final Matrix4f projectionMatrix = new Matrix4f();
    public static final Matrix4f modelViewMatrix = new Matrix4f();
    public static final Matrix4f positionMatrix = new Matrix4f();
    static class_310 field_0;

    public static class_243 worldSpaceToScreenSpace(class_243 class_2432) {
        class_4184 class_41842 = ProjectionUtil.mc.method_1561().field_4686;
        int n = mc.method_22683().method_4507();
        int[] nArray = new int[4];
        GL11.glGetIntegerv((int)2978, (int[])nArray);
        Vector3f vector3f = new Vector3f();
        double d2 = class_2432.field_1352 - class_41842.method_71156().field_1352;
        double d3 = class_2432.field_1351 - class_41842.method_71156().field_1351;
        double d4 = class_2432.field_1350 - class_41842.method_71156().field_1350;
        class_2432 = new Vector4f((float)d2, (float)d3, (float)d4, 1.0f).mul((Matrix4fc)positionMatrix);
        class_41842 = new Matrix4f((Matrix4fc)projectionMatrix);
        Matrix4f matrix4f = new Matrix4f((Matrix4fc)modelViewMatrix);
        class_41842.mul((Matrix4fc)matrix4f).project(class_2432.x(), class_2432.y(), class_2432.z(), nArray, vector3f);
        return new class_243((double)(vector3f.x / (float)mc.method_22683().method_4495()), (double)(((float)n - vector3f.y) / (float)mc.method_22683().method_4495()), (double)vector3f.z);
    }

    public static class_3545<class_243, Boolean> project(Matrix4f matrix4f, Matrix4f matrix4f2, class_243 class_2432) {
        if (ProjectionUtil.mc.field_1773 == null || mc.method_1560() == null) {
            return null;
        }
        ScreenProjection screenProjection = new ScreenProjection();
        if (!ProjectionUtil.projectToScreen(matrix4f, matrix4f2, class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, screenProjection)) {
            return null;
        }
        return new class_3545((Object)new class_243(screenProjection.x, screenProjection.y, screenProjection.z), (Object)screenProjection.visible);
    }

    public static boolean projectToScreen(Matrix4f matrix4f, Matrix4f matrix4f2, double d2, double d3, double d4, ScreenProjection screenProjection) {
        if (ProjectionUtil.mc.field_1773 == null || mc.method_1560() == null || screenProjection == null) {
            return false;
        }
        class_243 class_2432 = ProjectionUtil.mc.field_1773.method_19418().method_71156();
        double d5 = d2 - class_2432.field_1352;
        double d6 = d3 - class_2432.field_1351;
        double d7 = d4 - class_2432.field_1350;
        double d8 = (double)matrix4f.m00() * d5 + (double)matrix4f.m10() * d6 + (double)matrix4f.m20() * d7 + (double)matrix4f.m30();
        double d9 = (double)matrix4f.m01() * d5 + (double)matrix4f.m11() * d6 + (double)matrix4f.m21() * d7 + (double)matrix4f.m31();
        double d10 = (double)matrix4f.m02() * d5 + (double)matrix4f.m12() * d6 + (double)matrix4f.m22() * d7 + (double)matrix4f.m32();
        double d11 = (double)matrix4f.m03() * d5 + (double)matrix4f.m13() * d6 + (double)matrix4f.m23() * d7 + (double)matrix4f.m33();
        double d12 = (double)matrix4f2.m00() * d8 + (double)matrix4f2.m10() * d9 + (double)matrix4f2.m20() * d10 + (double)matrix4f2.m30() * d11;
        double d13 = (double)matrix4f2.m01() * d8 + (double)matrix4f2.m11() * d9 + (double)matrix4f2.m21() * d10 + (double)matrix4f2.m31() * d11;
        double d14 = (double)matrix4f2.m02() * d8 + (double)matrix4f2.m12() * d9 + (double)matrix4f2.m22() * d10 + (double)matrix4f2.m32() * d11;
        double d15 = (double)matrix4f2.m03() * d8 + (double)matrix4f2.m13() * d9 + (double)matrix4f2.m23() * d10 + (double)matrix4f2.m33() * d11;
        boolean bl = d15 > 0.0;
        double d16 = d15 != 0.0 ? 1.0 / d15 : 0.0;
        double d17 = d12 * d16;
        double d18 = d13 * d16;
        double d19 = d14 * d16;
        double d20 = (d17 * 0.5 + 0.5) * (double)mc.method_22683().method_4486();
        double d21 = (0.5 - d18 * 0.5) * (double)mc.method_22683().method_4502();
        screenProjection.set(d20, d21, d19, d15, bl);
        return true;
    }

    public static Vector3f projectVector(Matrix4f class_2432, Matrix4f matrix4f, class_243 class_2433) {
        if ((class_2432 = ProjectionUtil.project((Matrix4f)class_2432, matrix4f, class_2433)) == null) {
            return null;
        }
        class_2432 = (class_243)class_2432.method_15442();
        return new Vector3f((float)class_2432.field_1352, (float)class_2432.field_1351, (float)class_2432.field_1350);
    }

    public static Vector3f project(double d2, double d3, double d4) {
        if (ProjectionUtil.mc.field_1773 == null || mc.method_1560() == null) {
            return null;
        }
        return ProjectionUtil.project(new class_243(d2, d3, d4));
    }

    public static Vector3f project(class_243 class_2432) {
        if (ProjectionUtil.mc.field_1773 == null || mc.method_1560() == null) {
            return null;
        }
        class_2432 = ProjectionUtil.worldSpaceToScreenSpace(class_2432);
        if (class_2432.field_1350 < 0.0 || class_2432.field_1350 > 1.0) {
            return null;
        }
        return new Vector3f((float)class_2432.field_1352, (float)class_2432.field_1351, (float)class_2432.field_1350);
    }

    public static Vector3f projectWithClamp(Matrix4f matrix4f, Matrix4f matrix4f2, class_243 class_2432) {
        if (ProjectionUtil.mc.field_1773 == null || mc.method_1560() == null) {
            return null;
        }
        if ((class_2432 = class_2432.method_1020(ProjectionUtil.mc.field_1773.method_19418().method_71156())).method_1027() < 1.0E-4) {
            return new Vector3f((float)mc.method_22683().method_4486() / 2.0f, (float)mc.method_22683().method_4502() / 2.0f, 0.0f);
        }
        class_2432 = new Vector4f((float)class_2432.field_1352, (float)class_2432.field_1351, (float)class_2432.field_1350, 1.0f);
        class_2432.mul((Matrix4fc)matrix4f);
        class_2432.mul((Matrix4fc)matrix4f2);
        boolean bl = class_2432.w() <= 0.0f;
        float f = Math.abs(class_2432.w());
        if (f < 0.001f) {
            f = 0.001f;
        }
        float f2 = class_2432.x() / f;
        f = class_2432.y() / f;
        float f3 = mc.method_22683().method_4486();
        float f4 = mc.method_22683().method_4502();
        float f5 = f3 / 2.0f;
        float f6 = f4 / 2.0f;
        f2 = (f2 * 0.5f + 0.5f) * f3;
        f = (0.5f - f * 0.5f) * f4;
        if (!bl && f2 >= 0.0f && f2 <= f3 && f >= 0.0f && f <= f4) {
            return new Vector3f(f2, f, 0.0f);
        }
        float f7 = f2 - f5;
        if (f7 == 0.0f && (f -= f6) == 0.0f) {
            f = 1.0f;
        }
        f3 = f3 / 2.0f - 10.0f;
        f2 = f4 / 2.0f - 10.0f;
        f4 = Float.MAX_VALUE;
        float f8 = Float.MAX_VALUE;
        if (f7 != 0.0f) {
            f4 = Math.abs(f3 / f7);
        }
        if (f != 0.0f) {
            f8 = Math.abs(f2 / f);
        }
        f3 = Math.min(f4, f8);
        return new Vector3f(f5 + f7 * f3, f6 + f * f3, 0.0f);
    }

    static {
        mc = class_310.method_1551();
    }

    public static final class ScreenProjection {
        public double field_0;
        public double field_1;
        public double field_2;
        public double field_3;
        public boolean visible;

        public void set(double d2, double d3, double d4, double d5, boolean bl) {
            this.x = d2;
            this.y = d3;
            this.z = d4;
            this.w = d5;
            this.visible = bl;
        }
    }
}

