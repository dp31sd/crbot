/*
 * Decompiled with CFR 0.152.
 */
package com.water.mixin;

import net.minecraft.class_1735;
import net.minecraft.class_465;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={class_465.class})
public interface HandledScreenAccessor {
    @Accessor(value="focusedSlot")
    @Nullable
    public class_1735 water$getFocusedSlot();
}

