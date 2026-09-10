/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.lang.invoke.LambdaMetafactory;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.glfw.GLFW;

public final class ChatMacro
extends Module {
    private final Setting<String> field_0;
    private final Setting<Integer> field_1;
    private final Setting<String> field_2;
    private final Setting<Integer> field_3;
    private final Setting<String> field_4;
    private final Setting<Integer> field_5;
    private final Setting<String> field_6;
    private final Setting<Integer> field_7;
    private final Setting<String> field_8;
    private final Setting<Integer> field_9;
    private final Map<Integer, Boolean> field_10;

    public ChatMacro() {
        super("Chat Macro", Category.c);
        this.Q = new Setting<String>("Macro 1 Text", "");
        this.R = new Setting<Integer>("Macro 1 Key", 0, 0, 348);
        this.S = new Setting<String>("Macro 2 Text", "");
        this.T = new Setting<Integer>("Macro 2 Key", 0, 0, 348);
        this.U = new Setting<String>("Macro 3 Text", "");
        this.V = new Setting<Integer>("Macro 3 Key", 0, 0, 348);
        this.W = new Setting<String>("Macro 4 Text", "");
        this.X = new Setting<Integer>("Macro 4 Key", 0, 0, 348);
        this.Y = new Setting<String>("Macro 5 Text", "");
        this.Z = new Setting<Integer>("Macro 5 Key", 0, 0, 348);
        this.i = new HashMap();
        this.addSetting(this.Q);
        this.addSetting(this.R);
        this.addSetting(this.S);
        this.addSetting(this.T);
        this.addSetting(this.U);
        this.addSetting(this.V);
        this.addSetting(this.W);
        this.addSetting(this.X);
        this.addSetting(this.Y);
        this.addSetting(this.Z);
    }

    @Override
    public void onTick() {
        if (ChatMacro.mc.field_1724 == null || ChatMacro.mc.field_1755 != null) {
            return;
        }
        this.b((Integer)this.R.getValue(), (String)this.Q.getValue());
        this.b((Integer)this.T.getValue(), (String)this.S.getValue());
        this.b((Integer)this.V.getValue(), (String)this.U.getValue());
        this.b((Integer)this.X.getValue(), (String)this.W.getValue());
        this.b((Integer)this.Z.getValue(), (String)this.Y.getValue());
    }

    private void method_0(int n, String string) {
        if (n <= 0 || string == null || string.isBlank()) {
            return;
        }
        boolean bl = this.b(n);
        boolean bl2 = this.i.getOrDefault(n, false);
        if (bl && !bl2) {
            this.r(string.trim());
        }
        this.i.put(n, bl);
    }

    private boolean method_1(int n) {
        if (mc.method_22683() == null) {
            return false;
        }
        try {
            return GLFW.glfwGetKey((long)mc.method_22683().method_4490(), (int)n) == 1;
        }
        catch (Exception exception) {
            return false;
        }
    }

    private void method_2(String string) {
        mc.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, s(java.lang.String ), ()V)((String)string));
    }

    private static /* synthetic */ void method_3(String string) {
        if (ChatMacro.mc.field_1724 == null || mc.method_1562() == null) {
            return;
        }
        if (string.startsWith("/")) {
            mc.method_1562().method_45730(string.substring(1));
        } else {
            mc.method_1562().method_45729(string);
        }
    }
}

