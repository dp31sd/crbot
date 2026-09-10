/*
 * Decompiled with CFR 0.152.
 */
package com.water.client;

import com.water.gui.ClickGuiScreen;
import com.water.gui.ToastManager;
import com.water.gui.hud.SpotifyQueueHud;
import com.water.module.ActivatableModule;
import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.client.Hud;
import com.water.module.modules.client.SpotifyHud;
import com.water.module.modules.client.WaterPlus;
import com.water.module.modules.misc.NameTags;
import java.lang.invoke.LambdaMetafactory;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.class_2960;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_9779;
import org.lwjgl.glfw.GLFW;
import org.slf4j.LoggerFactory;

public final class ClientBootstrap {
    public static boolean isMenuKey(int n, int n2) {
        return n == WaterPlus.getGuiKey();
    }

    public static void toggleClickGui() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return;
        }
        class_3102.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, b(net.minecraft.class_310 ), ()V)((class_310)class_3102));
    }

    public static void method_0() {
        ModuleManager.INSTANCE.a();
        KeyBindingHelper.registerKeyBinding((class_304)new class_304("key.water.toggle_menu", class_3675.class_307.field_1668, 344, new class_304.class_11900(class_2960.method_60655((String)"water", (String)"general"))));
        HudRenderCallback.EVENT.register((Object)(HudRenderCallback)LambdaMetafactory.metafactory(null, null, null, (Lnet/minecraft/class_332;Lnet/minecraft/class_9779;)V, b(net.minecraft.class_332 net.minecraft.class_9779 ), (Lnet/minecraft/class_332;Lnet/minecraft/class_9779;)V)());
        ClientTickEvents.END_CLIENT_TICK.register((Object)(ClientTickEvents.EndTick)LambdaMetafactory.metafactory(null, null, null, (Lnet/minecraft/class_310;)V, c(net.minecraft.class_310 ), (Lnet/minecraft/class_310;)V)());
    }

    private static /* synthetic */ void method_1(class_310 class_3102) {
        ModuleManager.INSTANCE.onTick();
        if (class_3102.field_1755 == null && class_3102.method_22683() != null) {
            for (Module module : ModuleManager.INSTANCE.getModules()) {
                boolean bl;
                int n;
                ActivatableModule activatableModule;
                int n2 = module.getBind();
                ActivatableModule activatableModule2 = module instanceof ActivatableModule ? (activatableModule = (ActivatableModule)module) : null;
                int n3 = n = activatableModule2 != null ? activatableModule2.getActivationKey() : 0;
                if (n2 != 0) {
                    try {
                        boolean bl2 = bl = GLFW.glfwGetKey((long)class_3102.method_22683().method_4490(), (int)n2) == 1;
                        if (bl && !module.wasBindPressed && n != n2) {
                            module.onBindPressed();
                        }
                        module.wasBindPressed = bl;
                    }
                    catch (Exception exception) {}
                }
                if (activatableModule2 == null || n == 0) continue;
                try {
                    boolean bl3 = bl = GLFW.glfwGetKey((long)class_3102.method_22683().method_4490(), (int)n) == 1;
                    if (bl && !activatableModule2.a) {
                        activatableModule2.b();
                    }
                    activatableModule2.a = bl;
                }
                catch (Exception exception) {}
            }
        }
    }

    private static /* synthetic */ void method_2(class_332 class_3322, class_9779 class_97792) {
        NameTags.renderHud(class_3322, class_97792.method_60637(false));
        Hud.a((class_332)class_3322);
        SpotifyHud.a((class_332)class_3322);
        SpotifyQueueHud.visible = Hud.e();
        if (SpotifyQueueHud.visible && (class_97792 = class_310.method_1551()) != null) {
            double d2 = class_97792.method_22683().method_4495();
            double d3 = class_97792.field_1729.method_1603() / d2;
            double d4 = class_97792.field_1729.method_1604() / d2;
            SpotifyQueueHud.render(class_3322, d3, d4);
        }
        ToastManager.INSTANCE.render(class_3322);
    }

    private static /* synthetic */ void method_3(class_310 class_3102) {
        if (class_3102.field_1755 instanceof ClickGuiScreen) {
            class_3102.method_1507(null);
        } else {
            ClickGuiScreen.open();
        }
    }

    static {
        LoggerFactory.getLogger((String)"water");
    }
}

