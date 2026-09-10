/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import net.minecraft.class_10185;
import net.minecraft.class_241;
import net.minecraft.class_744;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_744.class})
public interface InputAccessor {
    @Accessor(value="playerInput")
    public void water$setPlayerInput(class_10185 var1);

    @Accessor(value="movementVector")
    public void water$setMovementVector(class_241 var1);
}

