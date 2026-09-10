/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import net.minecraft.class_310;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_310.class})
public interface MinecraftClientAccessor {
    @Accessor(value="itemUseCooldown")
    public int water$getItemUseCooldown();

    @Accessor(value="itemUseCooldown")
    public void water$setItemUseCooldown(int var1);
}

