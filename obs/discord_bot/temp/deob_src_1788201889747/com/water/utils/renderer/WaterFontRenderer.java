/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils.renderer;

import com.mojang.blaze3d.textures.GpuTextureView;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.Texture2DRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.invoke.LambdaMetafactory;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import javax.imageio.ImageIO;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import net.minecraft.class_332;
import org.joml.Matrix4f;

public class WaterFontRenderer {
    public static final WaterFontRenderer INSTANCE = new WaterFontRenderer();
    private static volatile b field_0;
    private Font field_1;
    private b field_2;
    private static volatile int field_3;
    private final AtomicInteger field_4;
    private final LinkedHashMap<String, a> field_5;

    public WaterFontRenderer() {
        this.b = null;
        this.b = new AtomicInteger(0);
        this.a = new /* Unavailable Anonymous Inner Class!! */;
    }

    public static void method_0(int n) {
        bj = n;
    }

    public static void method_1() {
        bj = -1;
    }

    public static void method_2(b b2) {
        if (b2 != a) {
            a = b2;
            WaterFontRenderer.INSTANCE.a = null;
            WaterFontRenderer.INSTANCE.b = null;
            WaterFontRenderer.INSTANCE.a.clear();
        }
    }

    public static b method_3() {
        return a;
    }

    private void method_4() {
        b b2 = b.j;
        a = b.j;
        if (this.b == b2 && this.a != null) {
            return;
        }
        if (b2 == b.k) {
            this.a = null;
            this.b = b2;
            return;
        }
        this.a = this.a(b.j);
        if (this.a == null) {
            this.a = this.a(b.e);
        }
        if (this.a == null) {
            this.a = this.a(b.c);
        }
        if (this.a == null) {
            this.a = new Font("Monospaced", 1, 16);
        }
        this.b = b2;
    }

    private Font method_5(b b2) {
        if (b2 == null || b2.aj == null) {
            return null;
        }
        byte[] byArray = this.a(b2);
        if (byArray == null || byArray.length == 0) {
            return null;
        }
        Font font = this.a(byArray, 0, b2.d);
        if (font == null) {
            font = this.a(byArray, 1, b2.d);
        }
        if (font == null) {
            return null;
        }
        try {
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
        }
        catch (Throwable throwable) {}
        return font.deriveFont(0, b2.d);
    }

    private Font method_6(byte[] object, int n, float f) {
        Font font;
        object = new ByteArrayInputStream((byte[])object);
        try {
            font = Font.createFont(n, (InputStream)object).deriveFont(0, f);
        }
        catch (Throwable throwable) {
            try {
                try {
                    ((ByteArrayInputStream)object).close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (Throwable throwable3) {
                return null;
            }
        }
        ((ByteArrayInputStream)object).close();
        return font;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private byte[] method_7(b object) {
        InputStream inputStream;
        Object object2;
        Object object3;
        block28: {
            object = object.aj;
            try {
                object3 = this.getClass().getResourceAsStream((String)object);
                try {
                    if (object3 != null) {
                        byte[] byArray = ((InputStream)object3).readAllBytes();
                        return byArray;
                    }
                }
                finally {
                    if (object3 != null) {
                        ((InputStream)object3).close();
                    }
                }
            }
            catch (Throwable throwable) {}
            try {
                object3 = Thread.currentThread().getContextClassLoader();
                Object object4 = object2 = ((String)object).startsWith("/") ? ((String)object).substring(1) : object;
                if (object3 == null) break block28;
                inputStream = ((ClassLoader)object3).getResourceAsStream((String)object2);
                try {
                    if (inputStream != null) {
                        object3 = inputStream.readAllBytes();
                        return object3;
                    }
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
            catch (Throwable throwable) {}
        }
        try {
            object3 = class_310.method_1551();
            if (object3 == null) return null;
            if (object3.method_1478() == null) return null;
            Object object5 = object2 = ((String)object).startsWith("/assets/water/") ? ((String)object).substring("/assets/water/".length()) : object;
            if (((String)object2).startsWith("/")) {
                object2 = ((String)object2).substring(1);
            }
            inputStream = class_2960.method_60655((String)"water", (String)object2);
            if (!((Optional)(object3 = object3.method_1478().method_14486((class_2960)inputStream))).isPresent()) return null;
            object2 = ((class_3298)((Optional)object3).get()).method_14482();
            try {
                object = ((InputStream)object2).readAllBytes();
                return object;
            }
            finally {
                if (object2 != null) {
                    ((InputStream)object2).close();
                }
            }
        }
        catch (Throwable throwable) {}
        return null;
    }

    private a method_8(String string) {
        String string2 = a.name() + ":" + string;
        a a2 = (a)this.a.get(string2);
        if (a2 != null) {
            return a2;
        }
        a2 = this.b(string);
        if (a2 != null) {
            this.a.put(string2, a2);
        }
        return a2;
    }

    private a method_9(String object) {
        this.bl();
        if (this.a == null) {
            return null;
        }
        Object object2 = new BufferedImage(1, 1, 2);
        object2 = ((BufferedImage)object2).createGraphics();
        ((Graphics)object2).setFont(this.a);
        Object object3 = ((Graphics2D)object2).getFontRenderContext();
        object3 = this.a.getStringBounds((String)object, (FontRenderContext)object3);
        ((Graphics)object2).dispose();
        int n = Math.max(1, (int)Math.ceil(((RectangularShape)object3).getWidth()) + 6);
        int n2 = Math.max(1, (int)Math.ceil((float)this.a.getSize() * 1.3f));
        BufferedImage bufferedImage = new BufferedImage(n, n2, 2);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        graphics2D.setFont(this.a);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString((String)object, 1, this.a.getSize() - 1);
        graphics2D.dispose();
        try {
            object = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage)bufferedImage, "png", (OutputStream)object);
            object = class_1011.method_4309((InputStream)new ByteArrayInputStream(((ByteArrayOutputStream)object).toByteArray()));
            object = new class_1043((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, u(), ()Ljava/lang/String;)(), (class_1011)object);
            bufferedImage = class_2960.method_60655((String)"water", (String)("font_cache_" + this.b.getAndIncrement()));
            graphics2D = class_310.method_1551();
            if (graphics2D != null) {
                graphics2D.method_1531().method_4616((class_2960)bufferedImage, (class_1044)object);
            }
            return new a((class_1043)object, (class_2960)bufferedImage, n / 2, n2 / 2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public void method_10(class_332 class_3322, String string, float f, float f2, int n) {
        if (string == null || string.isEmpty()) {
            return;
        }
        if (bj >= 0 && f2 >= (float)bj) {
            return;
        }
        if (a == b.k) {
            class_310 class_3102 = class_310.method_1551();
            if (class_3102 != null) {
                class_3322.method_51433(class_3102.field_1772, string, (int)f, (int)f2, n, false);
            }
            return;
        }
        a a2 = this.a(string);
        if (a2 == null || a2.b.method_71659() == null) {
            return;
        }
        class_3322 = GuiRenderer.a((class_332)class_3322);
        Texture2DRenderer.a((Matrix4f)class_3322, (float)f, (float)f2, (float)a2.bk, (float)a2.bl, (GpuTextureView)a2.b.method_71659(), (int)n, (float)0.0f);
    }

    public int method_11(String string) {
        if (string == null || string.isEmpty()) {
            return 0;
        }
        if (a == b.k) {
            class_310 class_3102 = class_310.method_1551();
            return class_3102 != null ? class_3102.field_1772.method_1727(string) : string.length() * 6;
        }
        this.bl();
        if (this.a == null) {
            return string.length() * 6;
        }
        Object object = new BufferedImage(1, 1, 2);
        object = ((BufferedImage)object).createGraphics();
        ((Graphics)object).setFont(this.a);
        int n = ((Graphics)object).getFontMetrics().stringWidth(string) / 2;
        ((Graphics)object).dispose();
        return n;
    }

    private static /* synthetic */ String method_12() {
        return "water_font_cache";
    }

    static {
        a = b.j;
        bj = -1;
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b field_0;
        private static /* enum */ b field_1;
        public static final /* enum */ b field_2;
        private static /* enum */ b field_3;
        private static /* enum */ b field_4;
        private static /* enum */ b field_5;
        private static /* enum */ b field_6;
        public static final /* enum */ b field_7;
        public static final /* enum */ b field_8;
        private String field_9;
        public final String field_10;
        public final float field_11;
        private int field_12;
        private static final /* synthetic */ b[] field_13;

        public static b[] values() {
            return (b[])a.clone();
        }

        public static b valueOf(String string) {
            return Enum.valueOf(b.class, string);
        }

        private b(String string2, String string3, float f, int n2) {
            this.ai = string2;
            this.aj = string3;
            this.d = f;
            this.bm = n2;
        }

        private static /* synthetic */ b[] method_0() {
            return new b[]{c, d, e, f, g, h, i, j, k};
        }

        static {
            c = new b("Inter", "/assets/water/font/inter.ttf", 16.0f, 0);
            d = new b("Dekatron", "/assets/water/font/dekatron.otf", 16.0f, 0);
            e = new b("Minecraft Ten", "/assets/water/font/minecraft_ten.ttf", 16.0f, 0);
            f = new b("Basketball", "/assets/water/font/basketball.otf", 16.0f, 0);
            g = new b("Second Time", "/assets/water/font/second_time_demo.ttf", 16.0f, 0);
            h = new b("Under Trained", "/assets/water/font/under_trained.ttf", 16.0f, 0);
            i = new b("Belash", "/assets/water/font/belash.ttf", 16.0f, 0);
            j = new b("Bliss Bloom", "/assets/water/font/bliss_bloom.otf", 16.0f, 0);
            k = new b("Vanilla", null, 16.0f, -1);
            a = b.a();
        }
    }
}

