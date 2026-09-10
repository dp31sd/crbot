/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils.renderer;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.water.utils.renderer.GuiRenderer;
import java.lang.invoke.LambdaMetafactory;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Supplier;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_12137;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector4f;
import org.joml.Vector4fc;
import org.lwjgl.system.MemoryUtil;

public class Blur2DRenderer {
    private static final RenderPipeline field_0;
    private static final RenderPipeline field_1;
    private static final Vector4f field_2;
    private static final Vector3f field_3;
    private static final Matrix4f field_4;
    private static GpuBuffer field_5;
    private static GpuBuffer field_6;
    private static ByteBuffer field_7;
    private static final GpuBuffer[] field_8;
    private static final ByteBuffer[] field_9;
    private static int field_10;
    private static GpuTexture field_11;
    private static GpuTextureView field_12;
    private static GpuTexture[] field_13;
    private static GpuTextureView[] field_14;
    private static int field_15;
    private static int field_16;
    private static boolean field_17;
    private static int field_18;
    private static float field_19;
    private static boolean field_20;

    public static void method_0() {
        ay = true;
    }

    public static void method_1() {
        if (b) {
            return;
        }
        ByteBuffer byteBuffer = MemoryUtil.memAlloc((int)4);
        byteBuffer.putInt(0);
        byteBuffer.flip();
        b = RenderSystem.getDevice().createBuffer((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, w(), ()Ljava/lang/String;)(), 32, byteBuffer);
        MemoryUtil.memFree((Buffer)byteBuffer);
        b = true;
    }

    private static void method_2(int n, int n2) {
        int n3 = n / 2;
        int n4 = n2 / 2;
        if (a != null && n == B && n2 == C) {
            return;
        }
        if (a != null) {
            a.close();
            a = null;
        }
        if (a != null) {
            a.close();
            a = null;
        }
        a = RenderSystem.getDevice().createTexture((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, z(), ()Ljava/lang/String;)(), 5, TextureFormat.RGBA8, n, n2, 1, 1);
        a = RenderSystem.getDevice().createTextureView(a);
        for (int i = 0; i < 2; ++i) {
            if (a[i] != null) {
                a[i].close();
                Blur2DRenderer.a[i] = null;
            }
            if (a[i] != null) {
                a[i].close();
                Blur2DRenderer.a[i] = null;
            }
            int n5 = i;
            Blur2DRenderer.a[i] = RenderSystem.getDevice().createTexture((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, f(int ), ()Ljava/lang/String;)((int)n5), 13, TextureFormat.RGBA8, n3, n4, 1, 1);
            Blur2DRenderer.a[i] = RenderSystem.getDevice().createTextureView(a[i]);
        }
        B = n;
        C = n2;
    }

    public static void method_3(Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.method_1522() == null) {
            return;
        }
        if (class_3102.method_1522().method_30277() == null) {
            return;
        }
        Blur2DRenderer.a();
        int n = class_3102.method_1522().field_1482;
        int n2 = class_3102.method_1522().field_1481;
        int n3 = n / 2;
        int n4 = n2 / 2;
        Blur2DRenderer.a((int)n, (int)n2);
        long cfr_ignored_0 = System.nanoTime() / 16666666L;
        int n5 = ay || Math.abs(f6 - e) > 0.01f ? 1 : 0;
        class_12137 class_121372 = RenderSystem.getSamplerCache().method_75294(FilterMode.LINEAR);
        GpuBufferSlice gpuBufferSlice = RenderSystem.getDynamicUniforms().method_71106((Matrix4fc)RenderSystem.getModelViewMatrix(), (Vector4fc)a, (Vector3fc)a, (Matrix4fc)a);
        CommandEncoder commandEncoder = RenderSystem.getDevice().createCommandEncoder();
        if (n5 != 0) {
            commandEncoder.copyTextureToTexture(class_3102.method_1522().method_30277(), a, 0, 0, 0, 0, 0, n, n2);
            Blur2DRenderer.a((int)n, (int)n2, (int)n3, (int)n4, (float)1.0f, (float)f6);
            commandEncoder.writeToBuffer(a.slice(), a);
            try (RenderPass renderPass = commandEncoder.createRenderPass((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, y(), ()Ljava/lang/String;)(), a[0], OptionalInt.empty(), null, OptionalDouble.empty());){
                renderPass.setPipeline(b);
                renderPass.setVertexBuffer(0, b);
                renderPass.bindTexture("Sampler0", a, class_121372);
                RenderSystem.bindDefaultUniforms((RenderPass)renderPass);
                renderPass.setUniform("DynamicTransforms", gpuBufferSlice);
                renderPass.setUniform("BlurData", a);
                renderPass.draw(0, 6);
            }
            n = Math.min(10, Math.max(2, (int)(5.0f * f6)));
            float[] fArray = new float[]{1.0f, 2.0f, 2.0f, 3.0f};
            n5 = 0;
            while (n5 < n) {
                int n6 = n5 % 2;
                int n7 = (n5 + 1) % 2;
                float f8 = n5 < fArray.length ? fArray[n5] : 3.0f;
                int n8 = n5++;
                Blur2DRenderer.a((int)n3, (int)n4, (int)n3, (int)n4, (float)f8, (float)1.0f);
                commandEncoder.writeToBuffer(a.slice(), a);
                try (RenderPass renderPass = commandEncoder.createRenderPass((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, e(int ), ()Ljava/lang/String;)((int)n8), a[n7], OptionalInt.empty(), null, OptionalDouble.empty());){
                    renderPass.setPipeline(b);
                    renderPass.setVertexBuffer(0, b);
                    renderPass.bindTexture("Sampler0", a[n6], class_121372);
                    RenderSystem.bindDefaultUniforms((RenderPass)renderPass);
                    renderPass.setUniform("DynamicTransforms", gpuBufferSlice);
                    renderPass.setUniform("BlurData", a);
                    renderPass.draw(0, 6);
                }
            }
            D = n % 2;
            e = f6;
            ay = false;
        }
        float[] fArray = new float[]{f5, f5, f5, f5};
        n2 = GuiRenderer.x();
        n5 = GuiRenderer.y();
        Blur2DRenderer.a((Matrix4f)matrix4f, (float)f, (float)f2, (float)f3, (float)f4, (int)n2, (int)n5, (float[])fArray, (float)f7);
        commandEncoder.writeToBuffer(a.slice(), a);
        try (RenderPass renderPass = commandEncoder.createRenderPass((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, x(), ()Ljava/lang/String;)(), class_3102.method_1522().method_71639(), OptionalInt.empty(), class_3102.method_1522().method_71640(), OptionalDouble.of(1.0));){
            GuiRenderer.a((RenderPass)renderPass);
            renderPass.setPipeline(c);
            renderPass.setVertexBuffer(0, b);
            renderPass.bindTexture("Sampler0", a[D], class_121372);
            RenderSystem.bindDefaultUniforms((RenderPass)renderPass);
            renderPass.setUniform("DynamicTransforms", gpuBufferSlice);
            renderPass.setUniform("BlurData", a);
            renderPass.draw(0, 6);
        }
    }

    private static void method_4() {
        if (a[A = (A + 1) % 24] == null) {
            Blur2DRenderer.a[Blur2DRenderer.A] = MemoryUtil.memAlloc((int)256);
        }
        a = a[A];
    }

    private static void method_5(int n, int n2, int n3, int n4, float f, float f2) {
        Blur2DRenderer.A();
        a.clear();
        for (int i = 0; i < 16; ++i) {
            a.putFloat(0.0f);
        }
        a.putFloat(0.0f).putFloat(0.0f).putFloat(n).putFloat(n2);
        a.putFloat(n).putFloat(n2).putFloat(1.0f).putFloat(f);
        a.putFloat(n3).putFloat(n4).putFloat(1.0f).putFloat(f2);
        a.putFloat(0.0f).putFloat(0.0f).putFloat(0.0f).putFloat(0.0f);
        a.putFloat(0.0f).putFloat(0.0f).putFloat(0.0f).putFloat(0.0f);
        a.flip();
        Blur2DRenderer.B();
    }

    private static void method_6(Matrix4f matrix4f, float f, float f2, float f3, float f4, int n, int n2, float[] fArray, float f5) {
        Blur2DRenderer.A();
        a.clear();
        a.putFloat(matrix4f.m00()).putFloat(matrix4f.m01()).putFloat(matrix4f.m02()).putFloat(matrix4f.m03());
        a.putFloat(matrix4f.m10()).putFloat(matrix4f.m11()).putFloat(matrix4f.m12()).putFloat(matrix4f.m13());
        a.putFloat(matrix4f.m20()).putFloat(matrix4f.m21()).putFloat(matrix4f.m22()).putFloat(matrix4f.m23());
        a.putFloat(matrix4f.m30()).putFloat(matrix4f.m31()).putFloat(matrix4f.m32()).putFloat(matrix4f.m33());
        a.putFloat(f).putFloat(f2).putFloat(f3).putFloat(f4);
        a.putFloat(n).putFloat(n2).putFloat(0.0f).putFloat(0.0f);
        a.putFloat(n).putFloat(n2).putFloat(1.0f).putFloat(0.0f);
        a.putFloat(fArray[0]).putFloat(fArray[1]).putFloat(fArray[2]).putFloat(fArray[3]);
        a.putFloat(f5).putFloat(0.0f).putFloat(0.0f).putFloat(0.0f);
        a.flip();
        Blur2DRenderer.B();
    }

    private static void method_7() {
        int n = a.remaining();
        if (a[A] == null || a[A].size() < (long)n) {
            if (a[A] != null) {
                a[A].close();
            }
            int n2 = A;
            Blur2DRenderer.a[Blur2DRenderer.A] = RenderSystem.getDevice().createBuffer((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, d(int ), ()Ljava/lang/String;)((int)n2), 136, (long)n);
        }
        a = a[A];
    }

    private static /* synthetic */ String method_8(int n) {
        return "water:blur_uniform_" + n;
    }

    private static /* synthetic */ String method_9() {
        return "water:blur_final";
    }

    private static /* synthetic */ String method_10(int n) {
        return "water:blur_" + n;
    }

    private static /* synthetic */ String method_11() {
        return "water:blur_downsample";
    }

    private static /* synthetic */ String method_12(int n) {
        return "water:blur_pp_" + n;
    }

    private static /* synthetic */ String method_13() {
        return "water:blur_copy";
    }

    private static /* synthetic */ String method_14() {
        return "water:blur_dummy_vertex";
    }

    static {
        b = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125}).withLocation(class_2960.method_60655((String)"water", (String)"pipeline/blur_pass")).withVertexShader(class_2960.method_60655((String)"water", (String)"blur_pass_vertex")).withFragmentShader(class_2960.method_60655((String)"water", (String)"blur_pass_fragment")).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).withUniform("BlurData", class_10789.field_60031).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).build());
        c = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125}).withLocation(class_2960.method_60655((String)"water", (String)"pipeline/blur_final")).withVertexShader(class_2960.method_60655((String)"water", (String)"blur_final_vertex")).withFragmentShader(class_2960.method_60655((String)"water", (String)"blur_final_fragment")).withVertexFormat(class_290.field_60033, VertexFormat.class_5596.field_27379).withUniform("BlurData", class_10789.field_60031).withSampler("Sampler0").withBlend(BlendFunction.TRANSLUCENT).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withCull(false).build());
        a = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
        a = new Vector3f(0.0f, 0.0f, 0.0f);
        a = new Matrix4f();
        a = new GpuBuffer[24];
        a = new ByteBuffer[24];
        A = 0;
        a = new GpuTexture[2];
        a = new GpuTextureView[2];
        B = 0;
        C = 0;
        b = false;
        D = 0;
        e = 0.0f;
        ay = true;
    }
}

