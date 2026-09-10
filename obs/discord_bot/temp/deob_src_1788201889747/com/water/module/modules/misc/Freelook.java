/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.WaterPlus;
import com.water.setting.ModeSetting;
import com.water.setting.Setting;
import net.minecraft.class_3532;
import net.minecraft.class_5498;
import org.lwjgl.glfw.GLFW;

public final class Freelook
extends Module {
    private static final float MIN_DISTANCE = 1.0f;
    private static final float MAX_DISTANCE = 15.0f;
    private static final float MIN_SENSITIVITY = 0.1f;
    private static final float MAX_SENSITIVITY = 3.0f;
    public static Freelook instance;
    private final ModeSetting activationMode = new ModeSetting("Mode", "Hold", new String[]{"Activation Mode"}, new String[]{"Hold", "Toggle"});
    private final Setting<Float> distance = new Setting<Float>("Distance", Float.valueOf(4.0f), Float.valueOf(1.0f), Float.valueOf(15.0f));
    private final Setting<Boolean> smoothZoom = new Setting<Boolean>("Smooth Zoom", true);
    private final Setting<Integer> zoomTime = new Setting<Integer>("Zoom Time", 280, 80, 800);
    private final Setting<Boolean> wallClip = new Setting<Boolean>("Wall Clip", true);
    private final Setting<Float> sensitivity = new Setting<Float>("Sensitivity", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(3.0f));
    private final Setting<Boolean> invertY = new Setting<Boolean>("Invert Y", false);
    private boolean active;
    private class_5498 savedPerspective;
    private boolean savedChunkCullingEnabled = true;
    private float cameraYaw;
    private float cameraPitch;
    private long activationMs;

    public Freelook() {
        super("FreeLook", Category.c);
        instance = this;
        this.addSetting(this.activationMode);
        this.addSetting(this.distance);
        this.addSetting(this.smoothZoom);
        this.addSetting(this.zoomTime);
        this.addSetting(this.wallClip);
        this.addSetting(this.sensitivity);
        this.addSetting(this.invertY);
    }

    @Override
    public void onEnable() {
        this.active = false;
        this.savedPerspective = null;
        this.savedChunkCullingEnabled = true;
    }

    @Override
    public void onDisable() {
        this.deactivateCamera();
    }

    @Override
    public void onTick() {
        if (Freelook.mc.field_1724 == null || Freelook.mc.field_1690 == null || mc.method_22683() == null) {
            this.deactivateCamera();
            return;
        }
        if (this.isHoldMode()) {
            int n = this.getBind();
            int n2 = n = n != 0 && GLFW.glfwGetKey((long)mc.method_22683().method_4490(), (int)n) == 1 ? 1 : 0;
            if (n != 0) {
                this.activateCamera();
            } else {
                this.deactivateCamera();
            }
        } else if (this.active) {
            this.ensureCameraState();
        }
    }

    @Override
    public void onBindPressed() {
        if (this.isHoldMode()) {
            return;
        }
        if (!this.isEnabled()) {
            this.toggle();
            return;
        }
        if (this.active) {
            this.deactivateCamera();
        } else {
            this.activateCamera();
        }
    }

    public boolean isCameraActive() {
        return this.isEnabled() && this.active && Freelook.mc.field_1724 != null;
    }

    public void consumeMouseDelta(double d2, double d3) {
        if (!this.isCameraActive()) {
            return;
        }
        double d4 = this.invertY.getValue() != false ? -1.0 : 1.0;
        double d5 = 0.15 * (double)this.getSensitivity();
        this.cameraYaw = class_3532.method_15393((float)(this.cameraYaw + (float)(d2 * d5)));
        this.cameraPitch = class_3532.method_15363((float)(this.cameraPitch + (float)(d3 * d5 * d4)), (float)-90.0f, (float)90.0f);
    }

    public float getCameraYaw() {
        return this.cameraYaw;
    }

    public float getCameraPitch() {
        return this.cameraPitch;
    }

    public float getDistance() {
        float f = class_3532.method_15363((float)this.distance.getValue().floatValue(), (float)1.0f, (float)15.0f);
        if (!this.smoothZoom.getValue().booleanValue() || this.activationMs <= 0L) {
            return f;
        }
        float f2 = Math.max(80, this.zoomTime.getValue());
        f2 = class_3532.method_15363((float)((float)(System.currentTimeMillis() - this.activationMs) / f2), (float)0.0f, (float)1.0f);
        f2 = 1.0f - (float)Math.pow(1.0f - f2, 3.0);
        return class_3532.method_16439((float)f2, (float)1.0f, (float)f);
    }

    public boolean shouldWallClip() {
        return this.wallClip.getValue();
    }

    public float getSensitivity() {
        return class_3532.method_15363((float)this.sensitivity.getValue().floatValue(), (float)0.1f, (float)3.0f);
    }

    private boolean isHoldMode() {
        ModeSetting modeSetting = this.activationMode;
        return (boolean)"\ufffdv\ufffd";
    }

    private void activateCamera() {
        if (this.active || Freelook.mc.field_1724 == null || Freelook.mc.field_1690 == null) {
            this.ensureCameraState();
            return;
        }
        this.savedPerspective = Freelook.mc.field_1690.method_31044();
        this.savedChunkCullingEnabled = Freelook.mc.field_1730;
        Freelook.mc.field_1690.method_31043(class_5498.field_26665);
        Freelook.mc.field_1730 = false;
        this.cameraYaw = Freelook.mc.field_1724.method_36454();
        this.cameraPitch = Freelook.mc.field_1724.method_36455();
        this.activationMs = System.currentTimeMillis();
        this.active = true;
        this.pushNotification(true);
    }

    private void ensureCameraState() {
        if (!this.active || Freelook.mc.field_1690 == null) {
            return;
        }
        if (!Freelook.mc.field_1690.method_31044().method_31034() && !Freelook.mc.field_1690.method_31044().method_31035()) {
            return;
        }
        Freelook.mc.field_1690.method_31043(class_5498.field_26665);
        Freelook.mc.field_1730 = false;
    }

    private void deactivateCamera() {
        if (!this.active) {
            return;
        }
        this.active = false;
        this.activationMs = 0L;
        if (Freelook.mc.field_1690 != null) {
            Freelook.mc.field_1690.method_31043(this.savedPerspective == null ? class_5498.field_26664 : this.savedPerspective);
        }
        Freelook.mc.field_1730 = this.savedChunkCullingEnabled;
        this.pushNotification(false);
    }

    private void pushNotification(boolean bl) {
        try {
            if (WaterPlus.notificationsEnabled()) {
                ToastManager.INSTANCE.pushToggle(this.getName(), bl, this.getModuleIcon());
            }
        }
        catch (Exception exception) {}
    }

    static String _c2cc8e86a63() {
        return "2";
    }
}

