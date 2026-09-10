/*
 * Decompiled with CFR 0.152.
 */
package com.water.setting;

import com.water.setting.Setting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_7923;

public final class MobsSetting
extends Setting<Set<class_1299<?>>> {
    private final List<class_1299<?>> availableMobs = class_7923.field_41177.method_10220().filter(MobsSetting::isLivingMob).sorted(Comparator.comparing(this::getDisplayName, String.CASE_INSENSITIVE_ORDER)).toList();
    private long version;

    public MobsSetting(String string, class_1299<?> ... class_1299Array) {
        super(string, MobsSetting.createDefaultSet(class_1299Array));
    }

    private static boolean isLivingMob(class_1299<?> class_13112) {
        return (class_13112 = class_13112.method_5891()) == class_1311.field_6302 || class_13112 == class_1311.field_6294 || class_13112 == class_1311.field_6303 || class_13112 == class_1311.field_34447 || class_13112 == class_1311.field_30092 || class_13112 == class_1311.field_6300 || class_13112 == class_1311.field_24460;
    }

    @Override
    public void setValue(Set<class_1299<?>> object) {
        LinkedHashSet<class_1299> linkedHashSet = new LinkedHashSet<class_1299>();
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                class_1299 class_12992 = (class_1299)object.next();
                if (class_12992 == null) continue;
                linkedHashSet.add(class_12992);
            }
        }
        super.setValue(linkedHashSet);
        ++this.version;
    }

    public boolean contains(class_1299<?> class_12992) {
        return class_12992 != null && ((Set)this.getValue()).contains(class_12992);
    }

    public void toggle(class_1299<?> class_12992) {
        if (class_12992 == null) {
            return;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection)this.getValue());
        if (!linkedHashSet.add(class_12992)) {
            linkedHashSet.remove(class_12992);
        }
        this.setValue(linkedHashSet);
    }

    public void clear() {
        if (((Set)this.getValue()).isEmpty()) {
            return;
        }
        this.setValue(Collections.emptySet());
    }

    public int size() {
        return ((Set)this.getValue()).size();
    }

    public long getVersion() {
        return this.version;
    }

    public Set<class_1299<?>> getSelectedMobs() {
        return Collections.unmodifiableSet((Set)this.getValue());
    }

    public List<class_1299<?>> getAvailableMobs() {
        return this.availableMobs;
    }

    public List<class_1299<?>> filter(String string) {
        String string2 = string = string == null ? "" : string.trim().toLowerCase(Locale.ROOT);
        if (string.isEmpty()) {
            return this.availableMobs;
        }
        ArrayList arrayList = new ArrayList();
        for (class_1299<?> class_12992 : this.availableMobs) {
            String string3 = this.getDisplayName(class_12992).toLowerCase(Locale.ROOT);
            Object object = class_7923.field_41177.method_10221(class_12992);
            String string4 = object = object == null ? "" : object.toString().toLowerCase(Locale.ROOT);
            if (!string3.contains(string) && !((String)object).contains(string)) continue;
            arrayList.add(class_12992);
        }
        return arrayList;
    }

    public String getDisplayName(class_1299<?> class_29602) {
        try {
            return class_29602.method_5897().getString();
        }
        catch (Exception exception) {
            class_29602 = class_7923.field_41177.method_10221(class_29602);
            return class_29602 == null ? "Mob" : class_29602.method_12832();
        }
    }

    public String getSummary() {
        if (((Set)this.getValue()).isEmpty()) {
            return "None";
        }
        Object object = (class_1299)((Set)this.getValue()).iterator().next();
        object = this.getDisplayName((class_1299<?>)object);
        int n = ((Set)this.getValue()).size() - 1;
        return n > 0 ? (String)object + " +" + n : object;
    }

    private static Set<class_1299<?>> createDefaultSet(class_1299<?> ... class_1299Array) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (class_1299Array != null) {
            Collections.addAll(linkedHashSet, class_1299Array);
            linkedHashSet.remove(null);
        }
        return linkedHashSet;
    }
}

