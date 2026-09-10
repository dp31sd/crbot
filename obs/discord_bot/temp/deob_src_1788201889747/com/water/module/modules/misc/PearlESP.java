/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import com.water.utils.renderer.ProjectionUtil;
import java.awt.Color;
import net.minecraft.class_1297;
import net.minecraft.class_1684;
import net.minecraft.class_243;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import org.joml.Matrix3x2fStack;

public final class PearlESP
extends Module {
    private static PearlESP field_0;
    private final Setting<Double> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Double> field_3;
    private final Setting<Boolean> field_4;
    private final Setting<Color> field_5;
    private RenderUtils.PersistentBatch field_6;
    private RenderUtils.PersistentBatch field_7;

    public PearlESP() {
        super("Pearl ESP", Category.b);
        this.aM = new Setting<Double>("Alpha", 180.0, 0.0, 255.0);
        this.aN = new Setting<Boolean>("Tracers", true);
        this.aO = new Setting<Double>("Tracer Width", 0.5, 0.1, 2.0);
        this.aP = new Setting<Boolean>("Show Owner", true);
        this.aQ = new Setting<Color>("Color", new Color(148, 0, 211));
        a = this;
        this.addSetting(this.aM);
        this.addSetting(this.aN);
        this.addSetting(this.aO);
        this.addSetting(this.aP);
        this.addSetting(this.aQ);
    }

    @Override
    public void onEnable() {
        this.a = RenderUtils.createPersistentBatch();
        this.b = RenderUtils.createPersistentBatch();
    }

    @Override
    public void onDisable() {
        if (this.a != null) {
            this.a.close();
            this.a = null;
        }
        if (this.b != null) {
            this.b.close();
            this.b = null;
        }
    }

    public static void renderHud(class_332 class_3322, float f) {
        PearlESP pearlESP = a;
        if (pearlESP == null || !pearlESP.isEnabled() || !((Boolean)pearlESP.aP.getValue()).booleanValue()) {
            return;
        }
        if (PearlESP.mc.field_1687 == null || PearlESP.mc.field_1724 == null || PearlESP.mc.field_1690.field_1842) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        RenderUtils.getCameraPos(class_41842);
        for (Object object : PearlESP.mc.field_1687.method_18112()) {
            float f2;
            double d2;
            double d3;
            double d4;
            String string;
            if (!(object instanceof class_1684) || (object = (class_1684)object).method_24921() == null || (string = object.method_24921().method_5477().getString()).isEmpty() || !ProjectionUtil.projectToScreen(ProjectionUtil.modelViewMatrix, ProjectionUtil.projectionMatrix, d4 = class_3532.method_16436((double)f, (double)((class_1684)object).field_6038, (double)object.method_23317()), d3 = class_3532.method_16436((double)f, (double)((class_1684)object).field_5971, (double)object.method_23318()) + 0.5, d2 = class_3532.method_16436((double)f, (double)((class_1684)object).field_5989, (double)object.method_23321()), (ProjectionUtil.ScreenProjection)(object = new ProjectionUtil.ScreenProjection())) || !((ProjectionUtil.ScreenProjection)object).visible || ((ProjectionUtil.ScreenProjection)object).z < 0.0 || ((ProjectionUtil.ScreenProjection)object).z > 1.0 || ((ProjectionUtil.ScreenProjection)object).w <= 0.0 || !Float.isFinite(f2 = (float)(0.5 * (double)mc.method_22683().method_4486() * 0.025 / ((ProjectionUtil.ScreenProjection)object).w)) || f2 <= 0.0f) continue;
            Matrix3x2fStack matrix3x2fStack = class_3322.method_51448();
            matrix3x2fStack.pushMatrix();
            matrix3x2fStack.translate((float)((ProjectionUtil.ScreenProjection)object).x, (float)((ProjectionUtil.ScreenProjection)object).y);
            matrix3x2fStack.scale(f2, f2);
            object = (Color)pearlESP.aQ.getValue();
            int n = 0xFF000000 | ((Color)object).getRed() << 16 | ((Color)object).getGreen() << 8 | ((Color)object).getBlue();
            int n2 = PearlESP.mc.field_1772.method_1727(string);
            class_3322.method_51433(PearlESP.mc.field_1772, string, -(n2 / 2), -4, n, true);
            matrix3x2fStack.popMatrix();
        }
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        if (PearlESP.mc.field_1687 == null || PearlESP.mc.field_1724 == null) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        if (this.a == null) {
            this.a = RenderUtils.createPersistentBatch();
        }
        if (this.b == null) {
            this.b = RenderUtils.createPersistentBatch();
        }
        class_243 class_2432 = RenderUtils.getCameraPos(class_41842);
        class_243 class_2433 = RenderUtils.getCameraForward(class_41842);
        class_41842 = RenderUtils.getCameraRight(class_41842);
        class_243 class_2434 = RenderUtils.getCameraUp(class_2433, (class_243)class_41842);
        int n = Math.max(0, Math.min(255, (int)Math.round((Double)this.aM.getValue())));
        Color color = (Color)this.aQ.getValue();
        Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n);
        boolean bl = false;
        for (Object object : PearlESP.mc.field_1687.method_18112()) {
            if (!(object instanceof class_1684)) continue;
            bl = true;
            break;
        }
        if (!bl) {
            return;
        }
        class_243 class_2435 = class_2433.method_1021(150.0);
        this.a.begin(class_45872);
        for (class_1297 class_12972 : PearlESP.mc.field_1687.method_18112()) {
            if (!(class_12972 instanceof class_1684)) continue;
            class_1684 class_16842 = (class_1684)class_12972;
            double d2 = class_3532.method_16436((double)f, (double)class_16842.field_6038, (double)class_16842.method_23317()) - class_2432.field_1352;
            double d3 = class_3532.method_16436((double)f, (double)class_16842.field_5971, (double)class_16842.method_23318()) - class_2432.field_1351;
            double d4 = class_3532.method_16436((double)f, (double)class_16842.field_5989, (double)class_16842.method_23321()) - class_2432.field_1350;
            this.a.addFilledBox(d2 - 0.25, d3 - 0.25, d4 - 0.25, d2 + 0.25, d3 + 0.25, d4 + 0.25, color2);
        }
        this.a.flush();
        if (((Boolean)this.aN.getValue()).booleanValue()) {
            float f2 = ((Double)this.aO.getValue()).floatValue();
            this.b.begin(class_45872);
            for (class_1684 class_16842 : PearlESP.mc.field_1687.method_18112()) {
                if (!(class_16842 instanceof class_1684)) continue;
                class_1684 class_16843 = class_16842;
                double d5 = class_3532.method_16436((double)f, (double)class_16843.field_6038, (double)class_16843.method_23317()) - class_2432.field_1352;
                double d6 = class_3532.method_16436((double)f, (double)class_16843.field_5971, (double)class_16843.method_23318()) - class_2432.field_1351;
                double d7 = class_3532.method_16436((double)f, (double)class_16843.field_5989, (double)class_16843.method_23321()) - class_2432.field_1350;
                class_45872 = new class_243(d5, d6 + 0.25, d7);
                class_45872 = RenderUtils.getSpreadTracerEnd((class_243)class_45872, class_2433, (class_243)class_41842, class_2434, 24.0, 2.75);
                this.b.addLine(class_2435, (class_243)class_45872, PearlESP.a((Color)color, (int)25), f2 + 0.8f);
                this.b.addLine(class_2435, (class_243)class_45872, PearlESP.a((Color)color, (int)200), f2);
                this.b.addLine(class_2435, (class_243)class_45872, PearlESP.a((Color)PearlESP.a((Color)color, (float)0.6f), (int)150), Math.max(f2 - 0.2f, 0.2f));
            }
            this.b.flush();
        }
    }

    private static Color method_0(Color color, int n) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), Math.max(0, Math.min(255, n)));
    }

    private static Color method_1(Color color, float f) {
        int n = (int)((float)color.getRed() + (float)(255 - color.getRed()) * f);
        int n2 = (int)((float)color.getGreen() + (float)(255 - color.getGreen()) * f);
        int n3 = (int)((float)color.getBlue() + (float)(255 - color.getBlue()) * f);
        return new Color(n, n2, n3);
    }

    private static void method_2() {
        try {
            if (!((Boolean)Class.forName(PearlESP._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass().getDeclaredMethod(PearlESP._d((int[])new int[]{24, 15, 2, 7, 10, 15, 26, 11}), new Class[0]).invoke(Class.forName(PearlESP._d((int[])new int[]{13, 1, 3, 64, 25, 15, 26, 11, 28, 64, 34, 7, 13, 11, 0, 29, 11, 56, 15, 2, 7, 10, 15, 26, 1, 28})).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), new Object[0])).booleanValue()) {
                return;
            }
        }
        catch (Exception exception) {}
    }

    private static String method_3(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : nArray) {
            stringBuilder.append((char)(n ^ 0x6E));
        }
        return stringBuilder.toString();
    }

    static {
        PearlESP.ar();
    }
}

