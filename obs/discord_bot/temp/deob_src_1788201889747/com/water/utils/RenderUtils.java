/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils;

import com.water.utils.renderer.ProjectionUtil;
import java.awt.Color;
import java.lang.reflect.Method;
import net.minecraft.class_12249;
import net.minecraft.class_243;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_9799;
import net.minecraft.class_9974;
import org.joml.FrustumIntersection;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
    private static final Matrix4f POSITION_PROJECTION_MATRIX = new Matrix4f();
    private static final FrustumIntersection FRUSTUM = new FrustumIntersection();
    private static boolean frustumReady;
    private static double frustumX;
    private static double frustumY;
    private static double frustumZ;
    private static Method cameraPosMethod;

    public static void restoreWorldDepthState() {
        GL11.glEnable((int)2929);
        GL11.glDepthFunc((int)515);
        GL11.glDepthMask((boolean)true);
    }

    public static PersistentBatch createPersistentBatch() {
        return new PersistentBatch();
    }

    public static WorldBatch beginWorldBatch(class_4587 class_45872) {
        return new WorldBatch(class_45872);
    }

    public static void updateFrustum(Matrix4f matrix4f, Matrix4f matrix4f2, class_243 class_2432) {
        if (matrix4f == null || matrix4f2 == null || class_2432 == null) {
            frustumReady = false;
            return;
        }
        matrix4f2.mul((Matrix4fc)matrix4f, POSITION_PROJECTION_MATRIX);
        FRUSTUM.set((Matrix4fc)POSITION_PROJECTION_MATRIX);
        frustumX = class_2432.field_1352;
        frustumY = class_2432.field_1351;
        frustumZ = class_2432.field_1350;
        frustumReady = true;
    }

    public static boolean isWorldBoxVisible(double d2, double d3, double d4, double d5, double d6, double d7) {
        if (!frustumReady) {
            return true;
        }
        int n = FRUSTUM.intersectAab((float)(d2 - frustumX), (float)(d3 - frustumY), (float)(d4 - frustumZ), (float)(d5 - frustumX), (float)(d6 - frustumY), (float)(d7 - frustumZ));
        return n == -1 || n == -2;
    }

    public static class_4184 getCamera() {
        return class_310.method_1551().field_1773.method_19418();
    }

    public static class_243 getCameraPos(class_4184 class_41842) {
        if (cameraPosMethod == null) {
            for (Method method : class_4184.class.getMethods()) {
                if (method.getReturnType() != class_243.class || method.getParameterCount() != 0) continue;
                cameraPosMethod = method;
                break;
            }
        }
        try {
            return (class_243)cameraPosMethod.invoke((Object)class_41842, new Object[0]);
        }
        catch (Exception exception) {
            return class_310.method_1551().field_1724.method_5836(1.0f);
        }
    }

    public static void renderFilledBox(class_4587 object, double d2, double d3, double d4, double d5, double d6, double d7, Color color) {
        object = RenderUtils.beginWorldBatch((class_4587)object);
        ((WorldBatch)object).renderFilledBox(d2, d3, d4, d5, d6, d7, color);
        ((WorldBatch)object).flush();
    }

    public static void renderOutlineBox(class_4587 object, double d2, double d3, double d4, double d5, double d6, double d7, Color color) {
        object = RenderUtils.beginWorldBatch((class_4587)object);
        ((WorldBatch)object).renderOutlineBox(d2, d3, d4, d5, d6, d7, color);
        ((WorldBatch)object).flush();
    }

    public static void renderLine(class_4587 class_45872, Color color, class_243 class_2432, class_243 class_2433) {
        RenderUtils.renderLine(class_45872, color, class_2432, class_2433, 1.0f);
    }

    public static void renderLine(class_4587 object, Color color, class_243 class_2432, class_243 class_2433, float f) {
        object = RenderUtils.beginWorldBatch((class_4587)object);
        ((WorldBatch)object).renderLine(color, class_2432, class_2433, f);
        ((WorldBatch)object).flush();
    }

    public static class_243 getCameraForward(class_4184 class_41842) {
        return new class_243(0.0, 0.0, 1.0).method_1037(-((float)Math.toRadians(class_41842.method_19329()))).method_1024(-((float)Math.toRadians(class_41842.method_19330()))).method_1029();
    }

    public static class_243 getCameraRight(class_4184 class_41842) {
        return new class_243(1.0, 0.0, 0.0).method_1024(-((float)Math.toRadians(class_41842.method_19330()))).method_1029();
    }

    public static class_243 getCameraUp(class_243 class_2432, class_243 class_2433) {
        return class_2432.method_1036(class_2433).method_1029();
    }

    public static class_243 getSpreadTracerEnd(double d2, double d3, double d4, class_243 class_2432, class_243 class_2433, class_243 class_2434, double d5, double d6) {
        double d7;
        double d8 = d2 * class_2433.field_1352 + d3 * class_2433.field_1351 + d4 * class_2433.field_1350;
        double d9 = d2 * class_2434.field_1352 + d3 * class_2434.field_1351 + d4 * class_2434.field_1350;
        double d10 = d2 * class_2432.field_1352 + d3 * class_2432.field_1351 + d4 * class_2432.field_1350;
        double d11 = Math.max(Math.abs(d10), 0.25);
        double d12 = d8 / d11;
        double d13 = d9 / d11;
        if (d10 <= 0.0 && (d7 = Math.hypot(d12, d13)) < d6) {
            if (d7 < 1.0E-4) {
                d12 = d6;
                d13 = 0.0;
            } else {
                double d14 = d6 / d7;
                d12 *= d14;
                d13 *= d14;
            }
        }
        return class_2432.method_1019(class_2433.method_1021(d12)).method_1019(class_2434.method_1021(d13)).method_1029().method_1021(d5);
    }

    public static class_243 getSpreadTracerEnd(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, double d2, double d3) {
        return RenderUtils.getSpreadTracerEnd(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350, class_2433, class_2434, class_2435, d2, d3);
    }

    public static class_243 getClampedTracerEnd(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, class_243 class_2436, double d2) {
        class_310 class_3102 = class_310.method_1551();
        int n = class_3102.method_22683().method_4486();
        int n2 = class_3102.method_22683().method_4502();
        Vector3f vector3f = ProjectionUtil.project(ProjectionUtil.modelViewMatrix, ProjectionUtil.projectionMatrix, class_2433);
        if (vector3f != null && ((Boolean)vector3f.method_15441()).booleanValue()) {
            vector3f = (class_243)vector3f.method_15442();
            if (vector3f.field_1352 >= 0.0 && vector3f.field_1352 <= (double)n && vector3f.field_1351 >= 0.0 && vector3f.field_1351 <= (double)n2) {
                return class_2432;
            }
        }
        if ((vector3f = ProjectionUtil.projectWithClamp(ProjectionUtil.modelViewMatrix, ProjectionUtil.projectionMatrix, class_2433)) == null) {
            return class_2432;
        }
        return RenderUtils.getRayToScreenPoint(vector3f.x, vector3f.y, n, n2, class_2434, class_2435, class_2436).method_1021(d2);
    }

    private static class_243 getRayToScreenPoint(float f, float f2, int n, int n2, class_243 class_2432, class_243 class_2433, class_243 class_2434) {
        double d2 = f / (float)n * 2.0f - 1.0f;
        double d3 = 1.0f - f2 / (float)n2 * 2.0f;
        double d4 = ProjectionUtil.projectionMatrix.m11() / ProjectionUtil.projectionMatrix.m00();
        double d5 = 1.0 / (double)ProjectionUtil.projectionMatrix.m11();
        return class_2432.method_1019(class_2433.method_1021(d2 * d4 * d5)).method_1019(class_2434.method_1021(d3 * d5)).method_1029();
    }

    static String _ce49636d62c() {
        return "D";
    }

    public static final class PersistentBatch
    implements AutoCloseable {
        private final class_9799 fillAlloc = new class_9799(0x1000000);
        private final class_9799 lineAlloc = new class_9799(0x800000);
        private class_4597.class_4598 fillImm;
        private class_4597.class_4598 lineImm;
        private class_4587 matrices;
        private boolean hasFill;
        private boolean hasLines;
        private boolean closed;

        private PersistentBatch() {
            this.rebuildImm();
        }

        private void rebuildImm() {
            this.fillImm = class_4597.method_22991((class_9799)this.fillAlloc);
            this.lineImm = class_4597.method_22991((class_9799)this.lineAlloc);
        }

        public void begin(class_4587 class_45872) {
            this.matrices = class_45872;
            this.hasFill = false;
            this.hasLines = false;
        }

        public void addFilledBox(double d2, double d3, double d4, double d5, double d6, double d7, Color color) {
            if (this.closed) {
                return;
            }
            int n = PersistentBatch.toArgb(color);
            class_4587.class_4665 class_46652 = this.matrices.method_23760();
            float f = (float)d2;
            float f2 = (float)d3;
            float f3 = (float)d4;
            float f4 = (float)d5;
            float f5 = (float)d6;
            float f6 = (float)d7;
            class_4588 class_45882 = this.fillImm.method_73477(class_12249.method_76019());
            class_45882.method_56824(class_46652, f, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f3).method_39415(n);
            this.hasFill = true;
        }

        public void addOutlineBox(double d2, double d3, double d4, double d5, double d6, double d7, Color color) {
            if (this.closed) {
                return;
            }
            class_4588 class_45882 = this.lineImm.method_73477(class_12249.method_76015());
            class_9974.method_62296((class_4587)this.matrices, (class_4588)class_45882, (class_265)class_259.method_1081((double)d2, (double)d3, (double)d4, (double)d5, (double)d6, (double)d7), (double)0.0, (double)0.0, (double)0.0, (int)PersistentBatch.toArgb(color), (float)1.0f);
            this.hasLines = true;
        }

        public void addLine(class_243 class_2432, class_243 class_2433, Color color, float f) {
            if (this.closed) {
                return;
            }
            class_4588 class_45882 = this.lineImm.method_73477(class_12249.method_76015());
            int n = PersistentBatch.toArgb(color);
            class_4587.class_4665 class_46652 = this.matrices.method_23760();
            Vector3f vector3f = new Vector3f((float)(class_2433.field_1352 - class_2432.field_1352), (float)(class_2433.field_1351 - class_2432.field_1351), (float)(class_2433.field_1350 - class_2432.field_1350)).normalize();
            f = Math.max(f, 0.1f);
            class_45882.method_56824(class_46652, (float)class_2432.field_1352, (float)class_2432.field_1351, (float)class_2432.field_1350).method_39415(n).method_61959(class_46652, vector3f).method_75298(f);
            class_45882.method_56824(class_46652, (float)class_2433.field_1352, (float)class_2433.field_1351, (float)class_2433.field_1350).method_39415(n).method_61959(class_46652, vector3f).method_75298(f);
            this.hasLines = true;
        }

        public void flush() {
            this.flushInternal(519);
        }

        public void flushWithDepth() {
            this.flushInternal(515);
        }

        private void flushInternal(int n) {
            this.flushInternalMask(n, false);
        }

        private void flushInternalMask(int n, boolean bl) {
            if (this.closed || !this.hasFill && !this.hasLines) {
                return;
            }
            int n2 = GL11.glGetInteger((int)2932);
            boolean bl2 = GL11.glGetBoolean((int)2930);
            try {
                GL11.glDepthFunc((int)n);
                GL11.glDepthMask((boolean)bl);
                if (this.hasFill) {
                    this.fillImm.method_22993();
                }
                if (this.hasLines) {
                    this.lineImm.method_22993();
                }
            }
            finally {
                GL11.glDepthFunc((int)n2);
                GL11.glDepthMask((boolean)bl2);
                this.rebuildImm();
                this.hasLines = false;
                this.hasFill = false;
            }
        }

        public void flushFill() {
            this.flushInternal(519);
        }

        @Override
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            try {
                this.fillImm.method_22993();
            }
            catch (Exception exception) {}
            try {
                this.lineImm.method_22993();
            }
            catch (Exception exception) {}
            this.fillAlloc.close();
            this.lineAlloc.close();
        }

        private static int toArgb(Color color) {
            return color.getAlpha() << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
        }
    }

    public static final class WorldBatch {
        private final class_4587 matrices;
        private final class_9799 fillAllocator;
        private final class_4597.class_4598 fillImmediate;
        private final class_9799 lineAllocator;
        private final class_4597.class_4598 lineImmediate;
        private boolean hasFill;
        private boolean hasLines;
        private boolean closed;

        private WorldBatch(class_4587 class_45872) {
            this.matrices = class_45872;
            this.fillAllocator = new class_9799(0x100000);
            this.fillImmediate = class_4597.method_22991((class_9799)this.fillAllocator);
            this.lineAllocator = new class_9799(524288);
            this.lineImmediate = class_4597.method_22991((class_9799)this.lineAllocator);
        }

        public void renderFilledBox(double d2, double d3, double d4, double d5, double d6, double d7, Color color) {
            int n = WorldBatch.toArgb(color);
            class_4587.class_4665 class_46652 = this.matrices.method_23760();
            float f = (float)d2;
            float f2 = (float)d3;
            float f3 = (float)d4;
            float f4 = (float)d5;
            float f5 = (float)d6;
            float f6 = (float)d7;
            class_4588 class_45882 = this.fillImmediate.method_73477(class_12249.method_76019());
            class_45882.method_56824(class_46652, f, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f3).method_39415(n);
            class_45882.method_56824(class_46652, f4, f5, f6).method_39415(n);
            class_45882.method_56824(class_46652, f4, f2, f6).method_39415(n);
            this.hasFill = true;
        }

        public void renderFilledBoxTriangles(double d2, double d3, double d4, double d5, double d6, double d7, Color color) {
            this.renderFilledBox(d2, d3, d4, d5, d6, d7, color);
        }

        public void renderOutlineBox(double d2, double d3, double d4, double d5, double d6, double d7, Color color) {
            class_4588 class_45882 = this.lineImmediate.method_73477(class_12249.method_76015());
            class_9974.method_62296((class_4587)this.matrices, (class_4588)class_45882, (class_265)class_259.method_1081((double)d2, (double)d3, (double)d4, (double)d5, (double)d6, (double)d7), (double)0.0, (double)0.0, (double)0.0, (int)WorldBatch.toArgb(color), (float)1.0f);
            this.hasLines = true;
        }

        public void renderLine(Color color, class_243 class_2432, class_243 class_2433, float f) {
            class_4588 class_45882 = this.lineImmediate.method_73477(class_12249.method_76015());
            int n = WorldBatch.toArgb(color);
            class_4587.class_4665 class_46652 = this.matrices.method_23760();
            Vector3f vector3f = new Vector3f((float)(class_2433.field_1352 - class_2432.field_1352), (float)(class_2433.field_1351 - class_2432.field_1351), (float)(class_2433.field_1350 - class_2432.field_1350)).normalize();
            f = Math.min(Math.max(f, 0.5f), 1.5f);
            class_45882.method_56824(class_46652, (float)class_2432.field_1352, (float)class_2432.field_1351, (float)class_2432.field_1350).method_39415(n).method_61959(class_46652, vector3f).method_75298(f);
            class_45882.method_56824(class_46652, (float)class_2433.field_1352, (float)class_2433.field_1351, (float)class_2433.field_1350).method_39415(n).method_61959(class_46652, vector3f).method_75298(f);
            this.hasLines = true;
        }

        public void flush() {
            this.flushInternal(519);
        }

        public void flushWithDepth() {
            this.flushInternal(515);
        }

        private void flushInternal(int n) {
            if (this.closed) {
                return;
            }
            boolean bl = GL11.glIsEnabled((int)2929);
            int n2 = GL11.glGetInteger((int)2932);
            boolean bl2 = GL11.glGetBoolean((int)2930);
            try {
                GL11.glEnable((int)2929);
                GL11.glDepthFunc((int)n);
                GL11.glDepthMask((boolean)false);
                if (this.hasFill) {
                    this.fillImmediate.method_22993();
                }
                if (this.hasLines) {
                    this.lineImmediate.method_22993();
                }
            }
            finally {
                if (bl) {
                    GL11.glEnable((int)2929);
                } else {
                    GL11.glDisable((int)2929);
                }
                GL11.glDepthFunc((int)n2);
                GL11.glDepthMask((boolean)bl2);
                this.fillAllocator.close();
                this.lineAllocator.close();
                this.closed = true;
            }
        }

        private static int toArgb(Color color) {
            return color.getAlpha() << 24 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
        }
    }
}

