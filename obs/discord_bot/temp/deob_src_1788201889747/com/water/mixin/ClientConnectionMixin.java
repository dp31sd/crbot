/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.Module;
import com.water.module.ModuleManager;
import io.netty.channel.ChannelFutureListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2535.class})
public class ClientConnectionMixin {
    @Inject(method={"handlePacket"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onHandlePacket(class_2596<?> class_25962, class_2547 class_25472, CallbackInfo callbackInfo) {
        try {
            Module module = ModuleManager.INSTANCE.getModuleByName("RTP Home Reset");
            if (module != null && module.isEnabled() && ClientConnectionMixin.containsBlockedText(class_25962)) {
                callbackInfo.cancel();
                return;
            }
            ModuleManager.INSTANCE.onPacketReceive(class_25962);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static boolean containsBlockedText(Object object) {
        Object object2;
        if (object == null) {
            return false;
        }
        Object object3 = object.getClass().getDeclaredMethods();
        int n = ((Method[])object3).length;
        for (int i = 0; i < n; ++i) {
            Method method = object3[i];
            if (method.getParameterCount() != 0) continue;
            try {
                method.setAccessible(true);
                Object throwable = method.invoke(object, new Object[0]);
                if (throwable instanceof class_2561) {
                    object2 = (class_2561)throwable;
                    if (ClientConnectionMixin.isBlocked(object2.getString())) {
                        return true;
                    }
                    if (ClientConnectionMixin.isBlocked(object2.getString())) {
                        return true;
                    }
                }
                if (!(throwable instanceof String) || !ClientConnectionMixin.isBlocked((String)(object2 = (String)throwable))) continue;
                return true;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        for (object3 = object.getClass(); object3 != null; object3 = ((Class)object3).getSuperclass()) {
            for (Field field : ((Class)object3).getDeclaredFields()) {
                try {
                    Object object4;
                    field.setAccessible(true);
                    object2 = field.get(object);
                    if (object2 instanceof class_2561 && ClientConnectionMixin.isBlocked((object4 = object2).getString())) {
                        return true;
                    }
                    if (!(object2 instanceof String) || !ClientConnectionMixin.isBlocked((String)(object4 = (String)object2))) continue;
                    return true;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
        return false;
    }

    private static boolean isBlocked(String string) {
        if (string == null) {
            return false;
        }
        String string2 = string.toLowerCase();
        return string2.contains("home deleted") || string2.contains("home set") || string2.contains("teleported to a random location") || string2.contains("teleported to your home");
    }

    @Inject(method={"send(Lnet/minecraft/network/packet/Packet;Lio/netty/channel/ChannelFutureListener;Z)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSend(class_2596<?> class_25962, ChannelFutureListener channelFutureListener, boolean bl, CallbackInfo callbackInfo) {
        try {
            if (ModuleManager.INSTANCE.onPacketSend(class_25962)) {
                callbackInfo.cancel();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

