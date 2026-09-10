/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.ModeSetting;
import com.water.setting.Setting;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import net.minecraft.class_1799;
import net.minecraft.class_2561;
import net.minecraft.class_640;

public final class TabDetector
extends Module {
    private final ModeSetting field_0;
    private final Setting<String> field_1;
    private final ModeSetting field_2;
    private final Setting<Boolean> field_3;
    private final Set<String> field_4;
    private final Set<String> field_5;

    public TabDetector() {
        super("TabDetector", Category.c);
        this.c = new ModeSetting("Detect", "List", "Any", "List");
        this.aR = new Setting<String>("Target Players", "");
        this.d = new ModeSetting("Notification Mode", "Both", "Chat", "Toast", "Both");
        this.aS = new Setting<Boolean>("Log Offline", true);
        this.h = new HashSet();
        this.i = new HashSet();
        this.aR.visibleWhen(() -> {
            ModeSetting modeSetting = this.c;
            return (boolean)"tqw";
        });
        this.addSetting(this.c);
        this.addSetting(this.aR);
        this.addSetting(this.d);
        this.addSetting(this.aS);
    }

    @Override
    public void onEnable() {
        this.h.clear();
        this.i.clear();
        this.c(this.i);
    }

    @Override
    public void onDisable() {
        this.h.clear();
        this.i.clear();
    }

    @Override
    public void onTick() {
        Set set;
        if (TabDetector.mc.field_1724 == null || TabDetector.mc.field_1687 == null || mc.method_1562() == null) {
            return;
        }
        ModeSetting modeSetting = this.c;
        String string = "X&";
        Set set2 = set = string != false ? Set.of() : this.d((String)this.aR.getValue());
        if (string == false && set.isEmpty()) {
            this.h.clear();
            this.i.clear();
            return;
        }
        this.h.clear();
        for (Object object : mc.method_1562().method_2880()) {
            if (((String)(object = this.a((class_640)object))).isEmpty() || TabDetector.mc.field_1724 != null && ((String)object).equalsIgnoreCase(TabDetector.mc.field_1724.method_5477().getString()) || string == false && !this.a(set, (String)object)) continue;
            this.h.add(object);
        }
        HashSet hashSet = new HashSet(this.h);
        hashSet.removeAll(this.i);
        if (!hashSet.isEmpty()) {
            this.a(hashSet);
        }
        if (((Boolean)this.aS.getValue()).booleanValue()) {
            Object object;
            object = new HashSet(this.i);
            object.removeAll(this.h);
            if (!object.isEmpty()) {
                this.b((Set)object);
            }
        }
        this.i.clear();
        this.i.addAll(this.h);
    }

    private void method_0(Set<String> set) {
        String string = String.join((CharSequence)", ", set);
        string = set.size() == 1 ? "Target player joined: " + string : "Target players joined: " + string;
        this.c(string, set.size() == 1 ? "Target Player Joined!" : "Target Players Joined!", -1938838);
    }

    private void method_1(Set<String> set) {
        String string = String.join((CharSequence)", ", set);
        string = set.size() == 1 ? "Target player left: " + string : "Target players left: " + string;
        this.c(string, set.size() == 1 ? "Target Player Left!" : "Target Players Left!", -11152222);
    }

    private void method_2(String string, String string2, int n) {
        boolean bl;
        String string3 = (String)this.d.getValue();
        boolean bl2 = "Chat".equalsIgnoreCase(string3) || "Both".equalsIgnoreCase(string3);
        boolean bl3 = bl = "Toast".equalsIgnoreCase(string3) || "Both".equalsIgnoreCase(string3);
        if (bl2) {
            try {
                TabDetector.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)("[TabDetector] " + string)));
            }
            catch (Throwable throwable) {}
        }
        if (bl) {
            ToastManager.INSTANCE.push("TabDetector", string2, class_1799.field_8037, n);
        }
    }

    private void method_3(Set<String> set) {
        Set set2;
        set.clear();
        if (mc.method_1562() == null) {
            return;
        }
        ModeSetting modeSetting = this.c;
        String string = "X&";
        Set set3 = set2 = string != false ? Set.of() : this.d((String)this.aR.getValue());
        if (string == false && set2.isEmpty()) {
            return;
        }
        for (Object object : mc.method_1562().method_2880()) {
            if (((String)(object = this.a((class_640)object))).isEmpty() || TabDetector.mc.field_1724 != null && ((String)object).equalsIgnoreCase(TabDetector.mc.field_1724.method_5477().getString()) || string == false && !this.a(set2, (String)object)) continue;
            set.add((String)object);
        }
    }

    private String method_4(class_640 object) {
        block4: {
            try {
                if (object != null && object.method_2966() != null) break block4;
                return "";
            }
            catch (Throwable throwable) {
                return "";
            }
        }
        try {
            object = object.method_2966().name();
            return object == null ? "" : object;
        }
        catch (Throwable throwable) {
            return "";
        }
    }

    private boolean method_5(Set<String> set, String string) {
        return set.contains(string.toLowerCase(Locale.ROOT));
    }

    private Set<String> method_6(String stringArray) {
        if (stringArray == null || stringArray.isBlank()) {
            return Set.of();
        }
        stringArray = stringArray.replace('\n', ',').replace('\r', ',');
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        for (String string : stringArray.split(",")) {
            String string2 = string = string == null ? "" : string.trim();
            if (string.isEmpty()) continue;
            linkedHashSet.add(string.toLowerCase(Locale.ROOT));
        }
        return linkedHashSet;
    }
}

