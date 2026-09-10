/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import net.minecraft.class_10185;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_5498;
import org.joml.Vector3d;
import org.joml.Vector3dc;

public class Freecam
extends Module {
    private static final float MIN_SCROLL_SPEED = 0.1f;
    private static final float MAX_SCROLL_SPEED = 10.0f;
    private static final float SCROLL_SPEED_STEP = 0.2f;
    public final Vector3d currentPosition = new Vector3d();
    public final Vector3d previousPosition = new Vector3d();
    private final Vector3d velocity = new Vector3d();
    public float yaw;
    public float pitch;
    public float previousYaw;
    public float previousPitch;
    public final Setting<Float> speed = new Setting<Float>("Speed", Float.valueOf(1.0f), Float.valueOf(0.1f), Float.valueOf(10.0f));
    public final Setting<Boolean> smoothing = new Setting<Boolean>("Smooth", Boolean.TRUE);
    public final Setting<Boolean> keepSneak = new Setting<Boolean>("Keep Sneak", Boolean.FALSE);
    public final Setting<Boolean> keepMovement = new Setting<Boolean>("Keep Movement", Boolean.FALSE);
    public final Setting<Boolean> tracerStickToEye = new Setting<Boolean>("Stick to Eye", Boolean.FALSE);
    private float lookSensitivity = 0.5f;
    private float currentSpeed;
    private class_5498 savedPerspective;
    private boolean savedChunkCullingEnabled;
    private long lastFrameTime;
    private float savedPlayerYaw;
    private float savedPlayerPitch;
    public boolean wasSneaking;
    private boolean heldForward;
    private boolean heldBackward;
    private boolean heldLeft;
    private boolean heldRight;
    private boolean heldJump;
    private boolean heldSneak;
    private boolean heldSprint;
    public static Freecam instance;

    public Freecam() {
        super("Freecam", Category.b);
        instance = this;
        this.addSetting(this.speed);
        this.addSetting(this.smoothing);
        this.addSetting(this.keepSneak);
        this.addSetting(this.keepMovement);
        this.addSetting(this.tracerStickToEye);
    }

    @Override
    public void onEnable() {
        if (Freecam.mc.field_1724 == null || Freecam.mc.field_1687 == null) {
            this.toggle();
            return;
        }
        this.savedPerspective = Freecam.mc.field_1690.method_31044();
        this.savedChunkCullingEnabled = Freecam.mc.field_1730;
        Freecam.mc.field_1730 = false;
        this.savedPlayerYaw = Freecam.mc.field_1724.method_36454();
        this.savedPlayerPitch = Freecam.mc.field_1724.method_36455();
        this.wasSneaking = Freecam.mc.field_1724.method_5715();
        this.captureHeldMovement();
        this.yaw = Freecam.mc.field_1724.method_36454();
        this.pitch = Freecam.mc.field_1724.method_36455();
        class_243 class_2432 = Freecam.mc.field_1724.method_5836(1.0f);
        this.currentPosition.set(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        this.previousPosition.set(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        this.previousYaw = this.yaw;
        this.previousPitch = this.pitch;
        this.lastFrameTime = System.currentTimeMillis();
        this.velocity.set(0.0, 0.0, 0.0);
        this.currentSpeed = this.getConfiguredSpeed();
    }

    @Override
    public void onDisable() {
        if (Freecam.mc.field_1724 != null) {
            Freecam.mc.field_1724.method_36456(this.savedPlayerYaw);
            Freecam.mc.field_1724.method_36457(this.savedPlayerPitch);
            Freecam.mc.field_1724.method_5847(this.savedPlayerYaw);
            Freecam.mc.field_1724.method_5636(this.savedPlayerYaw);
            Freecam.mc.field_1724.method_36456(this.savedPlayerYaw);
            Freecam.mc.field_1724.method_5847(this.savedPlayerYaw);
            Freecam.mc.field_1724.method_5636(this.savedPlayerYaw);
            Freecam.mc.field_1724.method_5660(this.wasSneaking);
        }
        if (this.savedPerspective != null) {
            Freecam.mc.field_1690.method_31043(this.savedPerspective);
        } else {
            Freecam.mc.field_1690.method_31043(class_5498.field_26664);
        }
        Freecam.mc.field_1730 = this.savedChunkCullingEnabled;
        this.velocity.set(0.0, 0.0, 0.0);
        this.currentSpeed = this.getConfiguredSpeed();
        this.clearHeldMovement();
    }

    @Override
    public void onTick() {
        if (Freecam.mc.field_1724 == null) {
            return;
        }
        Freecam.mc.field_1724.method_36456(this.savedPlayerYaw);
        Freecam.mc.field_1724.method_36457(this.savedPlayerPitch);
        Freecam.mc.field_1724.method_5847(this.savedPlayerYaw);
        Freecam.mc.field_1724.method_5636(this.savedPlayerYaw);
        if (this.keepMovement.getValue().booleanValue()) {
            Freecam.mc.field_1724.method_5660(this.heldSneak);
            Freecam.mc.field_1724.method_5728(this.heldSprint);
        } else if (this.keepSneak.getValue().booleanValue() || this.wasSneaking) {
            Freecam.mc.field_1724.method_5660(this.wasSneaking || this.keepSneak.getValue() != false);
        }
    }

    private void captureHeldMovement() {
        if (Freecam.mc.field_1690 == null) {
            this.clearHeldMovement();
            return;
        }
        this.heldForward = Freecam.mc.field_1690.field_1894.method_1434();
        this.heldBackward = Freecam.mc.field_1690.field_1881.method_1434();
        this.heldLeft = Freecam.mc.field_1690.field_1913.method_1434();
        this.heldRight = Freecam.mc.field_1690.field_1849.method_1434();
        this.heldJump = Freecam.mc.field_1690.field_1903.method_1434();
        this.heldSneak = Freecam.mc.field_1690.field_1832.method_1434() || this.wasSneaking;
        this.heldSprint = Freecam.mc.field_1690.field_1867.method_1434() || Freecam.mc.field_1724.method_5624();
    }

    private void clearHeldMovement() {
        this.heldForward = false;
        this.heldBackward = false;
        this.heldLeft = false;
        this.heldRight = false;
        this.heldJump = false;
        this.heldSneak = false;
        this.heldSprint = false;
    }

    public void updateCameraMovement() {
        if (Freecam.mc.field_1724 == null) {
            return;
        }
        this.previousPosition.set((Vector3dc)this.currentPosition);
        this.previousYaw = this.yaw;
        this.previousPitch = this.pitch;
        long l = System.currentTimeMillis();
        float f = (float)(l - this.lastFrameTime) / 1000.0f;
        this.lastFrameTime = l;
        f = Math.min(f, 0.1f);
        if (f < 0.001f) {
            f = 0.016f;
        }
        float f2 = (float)Math.toRadians(this.yaw);
        double d2 = -Math.sin(f2);
        double d3 = Math.cos(f2);
        double d4 = -Math.cos(f2);
        double d5 = -Math.sin(f2);
        double d6 = 0.0;
        double d7 = 0.0;
        double d8 = 0.0;
        double d9 = (double)this.currentSpeed * 2.0;
        if (Freecam.mc.field_1690 != null && Freecam.mc.field_1690.field_1867.method_1434()) {
            d9 *= 2.0;
        }
        if (Freecam.mc.field_1690.field_1894.method_1434()) {
            d6 = 0.0 + d2 * d9;
            d8 = 0.0 + d3 * d9;
        }
        if (Freecam.mc.field_1690.field_1881.method_1434()) {
            d6 -= d2 * d9;
            d8 -= d3 * d9;
        }
        if (Freecam.mc.field_1690.field_1849.method_1434()) {
            d6 += d4 * d9;
            d8 += d5 * d9;
        }
        if (Freecam.mc.field_1690.field_1913.method_1434()) {
            d6 -= d4 * d9;
            d8 -= d5 * d9;
        }
        if (Freecam.mc.field_1690.field_1903.method_1434()) {
            d7 = 0.0 + d9;
        }
        if (Freecam.mc.field_1690.field_1832.method_1434()) {
            d7 -= d9;
        }
        if (this.smoothing.getValue().booleanValue()) {
            double d10 = 1.0 - Math.pow(0.001, f);
            this.velocity.x = class_3532.method_16436((double)d10, (double)this.velocity.x, (double)(d6 * 5.0));
            this.velocity.y = class_3532.method_16436((double)d10, (double)this.velocity.y, (double)(d7 * 5.0));
            this.velocity.z = class_3532.method_16436((double)d10, (double)this.velocity.z, (double)(d8 * 5.0));
        } else {
            this.velocity.set(d6 * 5.0, d7 * 5.0, d8 * 5.0);
        }
        this.currentPosition.x += this.velocity.x * (double)f;
        this.currentPosition.y += this.velocity.y * (double)f;
        this.currentPosition.z += this.velocity.z * (double)f;
    }

    public void onScrollWheel(double d2) {
        float f = this.currentSpeed;
        float f2 = f + (float)d2 * 0.5f;
        this.currentSpeed = class_3532.method_15363((float)f2, (float)0.1f, (float)10.0f);
    }

    public void updateRotation(double d2, double d3) {
        this.yaw += (float)d2;
        this.pitch += (float)d3;
        this.yaw = class_3532.method_15393((float)this.yaw);
        this.pitch = class_3532.method_15363((float)this.pitch, (float)-90.0f, (float)90.0f);
    }

    public double getInterpolatedX(float f) {
        return class_3532.method_16436((double)f, (double)this.previousPosition.x, (double)this.currentPosition.x);
    }

    public double getInterpolatedY(float f) {
        return class_3532.method_16436((double)f, (double)this.previousPosition.y, (double)this.currentPosition.y);
    }

    public double getInterpolatedZ(float f) {
        return class_3532.method_16436((double)f, (double)this.previousPosition.z, (double)this.currentPosition.z);
    }

    public float getInterpolatedYaw(float f) {
        return class_3532.method_16439((float)f, (float)this.previousYaw, (float)this.yaw);
    }

    public float getInterpolatedPitch(float f) {
        return class_3532.method_16439((float)f, (float)this.previousPitch, (float)this.pitch);
    }

    public float getLookSensitivity() {
        return this.lookSensitivity;
    }

    public void adjustSpeed(double d2) {
        if (d2 == 0.0) {
            return;
        }
        float f = this.currentSpeed + (float)Math.signum(d2) * 0.2f;
        this.currentSpeed = class_3532.method_15363((float)f, (float)0.1f, (float)10.0f);
    }

    private float getConfiguredSpeed() {
        return class_3532.method_15363((float)this.speed.getValue().floatValue(), (float)0.1f, (float)10.0f);
    }

    public boolean shouldKeepMovement() {
        return this.keepMovement.getValue();
    }

    public class_10185 getHeldMovementInput() {
        return new class_10185(this.heldForward, this.heldBackward, this.heldLeft, this.heldRight, this.heldJump, this.heldSneak, this.heldSprint);
    }

    public class_241 getHeldMovementVector() {
        float f = 0.0f;
        float f2 = 0.0f;
        if (this.heldForward) {
            f2 = 1.0f;
        }
        if (this.heldBackward) {
            f2 -= 1.0f;
        }
        if (this.heldLeft) {
            f = 1.0f;
        }
        if (this.heldRight) {
            f -= 1.0f;
        }
        if (f != 0.0f && f2 != 0.0f) {
            float f3 = (float)(1.0 / Math.sqrt(f * f + f2 * f2));
            f *= f3;
            f2 *= f3;
        }
        return new class_241(f, f2);
    }

    public boolean shouldRenderSneaking() {
        if (this.keepMovement.getValue().booleanValue()) {
            return this.heldSneak;
        }
        return this.keepSneak.getValue() != false || this.wasSneaking;
    }

    public boolean shouldTracersStickToEye() {
        return this.tracerStickToEye.getValue();
    }

    public static class_243 resolveTracerOrigin(class_243 class_2432, float f) {
        if (instance != null && instance.isEnabled() && instance.shouldTracersStickToEye() && Freecam.mc.field_1724 != null) {
            return Freecam.mc.field_1724.method_5836(f);
        }
        return class_2432;
    }
}

