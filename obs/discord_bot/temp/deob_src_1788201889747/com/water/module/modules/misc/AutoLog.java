/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.module.ActivatableModule;
import com.water.module.Category;
import com.water.module.modules.client.Friends;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_239;
import net.minecraft.class_2561;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_412;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_500;
import net.minecraft.class_639;
import net.minecraft.class_642;
import net.minecraft.class_8646;
import net.minecraft.class_9011;

public final class AutoLog
extends ActivatableModule {
    private long field_0;
    private long field_1;
    private long field_2;
    private float field_3;
    private int field_4;
    private int field_5;
    private String field_6;
    private int field_7;
    private String field_8;
    private boolean field_9;
    private long field_10;

    public AutoLog() {
        super("AutoLog", Category.c);
        this.c = -1.0f;
        this.ad = -1;
        this.ae = -1;
        this.aa = false;
        this.v = 0L;
    }

    @Override
    public void method_0() {
        if (AutoLog.mc.field_1724 == null || AutoLog.mc.field_1687 == null) {
            return;
        }
        this.aj();
        this.j();
        this.aa = true;
        this.v = System.currentTimeMillis() + 3000L;
    }

    @Override
    public void onEnable() {
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.c = this.c();
        this.ad = this.m();
        this.ae = this.n();
        if (AutoLog.mc.field_1724 != null && AutoLog.mc.field_1687 != null && (this.p() || this.q() || this.v())) {
            this.a(System.currentTimeMillis());
        }
    }

    @Override
    public void onTick() {
        class_239 class_2392;
        boolean bl;
        if (this.aa && AutoLog.mc.field_1724 == null && AutoLog.mc.field_1687 == null) {
            if (System.currentTimeMillis() >= this.v && this.t != null) {
                this.aa = false;
                this.ak();
            }
            return;
        }
        if (AutoLog.mc.field_1724 == null || AutoLog.mc.field_1687 == null) {
            return;
        }
        long l = System.currentTimeMillis();
        float f = this.c();
        boolean bl2 = this.c >= 0.0f && f + 0.001f < this.c;
        this.c = f;
        if (AutoLog.mc.field_1724.field_6235 > 0 || bl2 || this.r()) {
            this.s = l;
        }
        if (bl = this.v()) {
            this.u = l;
        }
        if (AutoLog.mc.field_1690.field_1886.method_1434() && AutoLog.mc.field_1765 != null && AutoLog.mc.field_1765.method_17783() == class_239.class_240.field_1331 && (class_2392 = AutoLog.mc.field_1765) instanceof class_3966) {
            class_1657 class_16572;
            class_2392 = (class_3966)class_2392;
            if ((class_2392 = class_2392.method_17782()) instanceof class_1657 && (class_16572 = (class_1657)class_2392) != AutoLog.mc.field_1724) {
                this.t = l;
            }
        }
        if (this.s()) {
            this.t = l;
        }
        if (this.a(l, bl)) {
            return;
        }
        for (class_1657 class_16572 : AutoLog.mc.field_1687.method_18456()) {
            if (class_16572 == AutoLog.mc.field_1724 || class_16572.method_7325() || Friends.c() && Friends.a((String)class_16572.method_5477().getString())) continue;
            if (mc.method_1562() != null && mc.method_1562().method_48296() != null) {
                this.aj();
                mc.method_1562().method_48296().method_10747((class_2561)class_2561.method_43470((String)("[AutoLog] Player detected: " + class_16572.method_5477().getString())));
                this.toggle();
            }
            return;
        }
    }

    private void method_1() {
        if (mc.method_1558() != null) {
            class_642 class_6422 = mc.method_1558();
            class_639 class_6392 = class_639.method_2950((String)class_6422.field_3761);
            this.t = class_6392.method_2952();
            this.af = class_6392.method_2954();
            this.u = class_6422.field_3752;
        }
    }

    private void method_2() {
        if (mc.method_1562() != null && mc.method_1562().method_48296() != null) {
            mc.method_1562().method_48296().method_10747((class_2561)class_2561.method_43470((String)"[AutoLog] Manual leave"));
        }
    }

    private void method_3() {
        if (this.t == null) {
            return;
        }
        class_642 class_6422 = new class_642(this.u != null ? this.u : this.t, this.t + ":" + this.af, class_642.class_8678.field_45611);
        class_412.method_36877((class_437)new class_500((class_437)new class_442()), (class_310)mc, (class_639)class_639.method_2950((String)class_6422.field_3761), (class_642)class_6422, (boolean)false, null);
    }

    private boolean method_4(long l, boolean bl) {
        if (bl || this.q() || l - this.u < 1500L) {
            return true;
        }
        if (this.s <= 0L && this.t <= 0L) {
            return false;
        }
        long l2 = Math.max(this.s, this.t);
        return l - l2 < 20000L;
    }

    private boolean method_5() {
        class_239 class_2392;
        if (AutoLog.mc.field_1724 == null || AutoLog.mc.field_1687 == null) {
            return false;
        }
        if (AutoLog.mc.field_1724.field_6235 > 0 || this.q()) {
            return true;
        }
        if (AutoLog.mc.field_1765 != null && AutoLog.mc.field_1765.method_17783() == class_239.class_240.field_1331 && (class_2392 = AutoLog.mc.field_1765) instanceof class_3966) {
            class_2392 = (class_3966)class_2392;
            if ((class_2392 = class_2392.method_17782()) instanceof class_1657 && (class_2392 = (class_1657)class_2392) != AutoLog.mc.field_1724 && !class_2392.method_7325()) {
                return true;
            }
        }
        for (class_1657 class_16572 : AutoLog.mc.field_1687.method_18456()) {
            if (class_16572 == AutoLog.mc.field_1724 || class_16572.method_7325() || !(AutoLog.mc.field_1724.method_5858((class_1297)class_16572) <= 64.0)) continue;
            return true;
        }
        return false;
    }

    private void method_6(long l) {
        this.s = l;
        this.t = l;
        this.u = l;
    }

    private boolean method_7() {
        return this.t() || this.u();
    }

    private boolean method_8() {
        int n = this.m();
        if (n <= 0 || n == this.ad) {
            return false;
        }
        this.ad = n;
        return this.t();
    }

    private boolean method_9() {
        int n = this.n();
        if (n <= 0 || n == this.ae) {
            return false;
        }
        this.ae = n;
        return this.u();
    }

    private boolean method_10() {
        if (AutoLog.mc.field_1724 == null) {
            return false;
        }
        class_1309 class_13092 = AutoLog.mc.field_1724.method_49107();
        if (!(class_13092 instanceof class_1657) || (class_13092 = (class_1657)class_13092) == AutoLog.mc.field_1724 || class_13092.method_7325()) {
            return false;
        }
        return this.a(AutoLog.mc.field_1724.method_6117());
    }

    private boolean method_11() {
        if (AutoLog.mc.field_1724 == null) {
            return false;
        }
        class_1309 class_13092 = AutoLog.mc.field_1724.method_6052();
        if (!(class_13092 instanceof class_1657) || (class_13092 = (class_1657)class_13092) == AutoLog.mc.field_1724 || class_13092.method_7325()) {
            return false;
        }
        return this.a(AutoLog.mc.field_1724.method_6083());
    }

    private boolean method_12(int n) {
        if (AutoLog.mc.field_1724 == null || n <= 0) {
            return false;
        }
        return (n = AutoLog.mc.field_1724.field_6012 - n) >= 0 && n < 400;
    }

    private int method_13() {
        return AutoLog.mc.field_1724 != null ? AutoLog.mc.field_1724.method_6117() : -1;
    }

    private int method_14() {
        return AutoLog.mc.field_1724 != null ? AutoLog.mc.field_1724.method_6083() : -1;
    }

    private boolean method_15() {
        if (AutoLog.mc.field_1687 != null && this.a(AutoLog.mc.field_1687.method_8428())) {
            return true;
        }
        Set set = Collections.newSetFromMap(new IdentityHashMap());
        return AutoLog.mc.field_1705 != null && this.a(AutoLog.mc.field_1705, 0, set);
    }

    private boolean method_16(class_269 class_2692) {
        if (class_2692 == null) {
            return false;
        }
        for (class_266 class_2662 : class_2692.method_1151()) {
            if (!this.c(class_2662.method_1113()) && !this.a(class_2662.method_1114())) continue;
            return true;
        }
        for (class_8646 class_86462 : class_8646.values()) {
            class_266 class_2662 = class_2692.method_1189(class_86462);
            if (class_2662 == null) continue;
            if (this.c(class_2662.method_1113()) || this.a(class_2662.method_1114())) {
                return true;
            }
            for (class_9011 class_90112 : class_2692.method_1184(class_2662)) {
                if (this.c(class_90112.comp_2127()) || this.a(class_90112.method_55387()) || this.a(class_90112.comp_2129())) {
                    return true;
                }
                if (!this.a((class_268)(class_90112 = class_2692.method_1164(class_90112.comp_2127())))) continue;
                return true;
            }
        }
        for (class_268 class_2682 : class_2692.method_1159()) {
            if (!this.a(class_2682)) continue;
            return true;
        }
        return false;
    }

    private boolean method_17(class_268 class_2682) {
        return class_2682 != null && (this.c(class_2682.method_1197()) || this.a(class_2682.method_1140()) || this.a(class_2682.method_1144()) || this.a(class_2682.method_1136()));
    }

    private boolean method_18(Object object, int n, Set<Object> set) {
        if (object == null || n > 4) {
            return false;
        }
        if (object instanceof class_2561) {
            class_2561 class_25612 = (class_2561)object;
            return this.c(class_25612.getString());
        }
        if (object instanceof String) {
            String string = (String)object;
            return this.c(string);
        }
        if (!set.add(object)) {
            return false;
        }
        if (object instanceof Map) {
            Map map = (Map)object;
            for (Map.Entry entry : map.entrySet()) {
                if (!this.a(entry.getKey(), n + 1, set) && !this.a(entry.getValue(), n + 1, set)) continue;
                return true;
            }
            return false;
        }
        if (object instanceof Collection) {
            Object object2 = (Collection)object;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                Object e2 = object2.next();
                if (!this.a(e2, n + 1, set)) continue;
                return true;
            }
            return false;
        }
        Class<?> clazz = object.getClass();
        if (!this.a(clazz)) {
            return false;
        }
        while (clazz != null && clazz != Object.class) {
            for (Field field : clazz.getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()) || field.getType().isPrimitive() || field.getDeclaringClass().getName().startsWith("java.lang")) continue;
                try {
                    field.setAccessible(true);
                    if (!this.a(field.get(object), n + 1, set)) continue;
                    return true;
                }
                catch (Exception exception) {}
            }
            clazz = clazz.getSuperclass();
        }
        return false;
    }

    private boolean method_19(Class<?> object) {
        return ((String)(object = ((Class)object).getName())).startsWith("net.minecraft.scoreboard.") || ((String)object).startsWith("net.minecraft.text.") || ((String)object).startsWith("net.minecraft.client.gui.hud.") || ((String)object).startsWith("net.minecraft.client.network.") || ((String)object).startsWith("java.util.");
    }

    private boolean method_20(String string) {
        return string != null && string.toLowerCase().contains("combat");
    }

    private boolean method_21(class_2561 class_25612) {
        return class_25612 != null && this.c(class_25612.getString());
    }

    private float method_22() {
        return AutoLog.mc.field_1724 != null ? AutoLog.mc.field_1724.method_6032() + AutoLog.mc.field_1724.method_6067() : -1.0f;
    }
}

