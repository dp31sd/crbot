/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import com.water.module.Module;
import com.water.module.ModuleManager;
import com.water.module.modules.donut.FakeRoles;
import com.water.module.modules.misc.NameProtect;
import java.lang.reflect.Method;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_338;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_338.class})
public class ChatHudMixin {
    @Shadow
    private List<?> field_2061;

    @Inject(method={"addMessage*"}, at={@At(value="RETURN")})
    private void afterAddMessage(CallbackInfo callbackInfo) {
        Module module = ModuleManager.INSTANCE.getModuleByName("RTP Home Reset");
        if (module == null || !module.isEnabled()) {
            return;
        }
        if (this.field_2061 == null || this.field_2061.isEmpty()) {
            return;
        }
        this.field_2061.removeIf(object -> {
            if (object == null) {
                return false;
            }
            try {
                for (Method method : object.getClass().getDeclaredMethods()) {
                    if (method.getParameterCount() != 0) continue;
                    method.setAccessible(true);
                    Object object2 = method.invoke(object, new Object[0]);
                    if (!(object2 instanceof class_2561)) continue;
                    class_2561 class_25612 = (class_2561)object2;
                    String string = class_25612.getString().toLowerCase();
                    return string.contains("home deleted") || string.contains("home set") || string.contains("teleported to a random location") || string.contains("teleported to your home");
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            return false;
        });
    }

    @ModifyVariable(method={"addMessage"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    private class_2561 modifyChatMessage(class_2561 class_25612) {
        String string;
        String string2;
        if (class_25612 != null && NameProtect.instance != null && NameProtect.instance.isEnabled() && class_310.method_1551().method_1548() != null && (string2 = class_310.method_1551().method_1548().method_1676()) != null && (string = class_25612.getString()).contains(string2)) {
            class_25612 = class_2561.method_43470((String)string.replace(string2, NameProtect.instance.getFakeName()));
        }
        return FakeRoles.modifyChatText(class_25612);
    }
}

