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
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_7923;

public final class BlocksSetting
extends Setting<Set<class_2248>> {
    private final List<class_2248> availableBlocks = class_7923.field_41175.method_10220().filter((? super T class_22482) -> class_22482 != class_2246.field_10124).sorted(Comparator.comparing(this::getDisplayName, String.CASE_INSENSITIVE_ORDER)).toList();
    private long version;

    public BlocksSetting(String string, class_2248 ... class_2248Array) {
        super(string, BlocksSetting.createDefaultSet(class_2248Array));
    }

    @Override
    public void setValue(Set<class_2248> object) {
        LinkedHashSet<class_2248> linkedHashSet = new LinkedHashSet<class_2248>();
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                class_2248 class_22482 = (class_2248)object.next();
                if (class_22482 == null || class_22482 == class_2246.field_10124) continue;
                linkedHashSet.add(class_22482);
            }
        }
        super.setValue(linkedHashSet);
        ++this.version;
    }

    public boolean contains(class_2248 class_22482) {
        return class_22482 != null && ((Set)this.getValue()).contains(class_22482);
    }

    public void toggle(class_2248 class_22482) {
        if (class_22482 == null || class_22482 == class_2246.field_10124) {
            return;
        }
        LinkedHashSet<class_2248> linkedHashSet = new LinkedHashSet<class_2248>((Collection)this.getValue());
        if (!linkedHashSet.add(class_22482)) {
            linkedHashSet.remove(class_22482);
        }
        this.setValue((Set<class_2248>)linkedHashSet);
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

    public Set<class_2248> getSelectedBlocks() {
        return Collections.unmodifiableSet((Set)this.getValue());
    }

    public List<class_2248> getAvailableBlocks() {
        return this.availableBlocks;
    }

    public List<class_2248> filter(String string) {
        String string2 = string = string == null ? "" : string.trim().toLowerCase(Locale.ROOT);
        if (string.isEmpty()) {
            return this.availableBlocks;
        }
        ArrayList<class_2248> arrayList = new ArrayList<class_2248>();
        for (class_2248 class_22482 : this.availableBlocks) {
            String string3 = this.getDisplayName(class_22482).toLowerCase(Locale.ROOT);
            Object object = class_7923.field_41175.method_10221((Object)class_22482);
            String string4 = object = object == null ? "" : object.toString().toLowerCase(Locale.ROOT);
            if (!string3.contains(string) && !((String)object).contains(string)) continue;
            arrayList.add(class_22482);
        }
        return arrayList;
    }

    public String getDisplayName(class_2248 class_22482) {
        try {
            return class_22482.method_9518().getString();
        }
        catch (Exception exception) {
            class_22482 = class_7923.field_41175.method_10221((Object)class_22482);
            return class_22482 == null ? "Block" : class_22482.method_12832();
        }
    }

    public String getSummary() {
        if (((Set)this.getValue()).isEmpty()) {
            return "None";
        }
        Object object = (class_2248)((Set)this.getValue()).iterator().next();
        object = this.getDisplayName((class_2248)object);
        int n = ((Set)this.getValue()).size() - 1;
        return n > 0 ? (String)object + " +" + n : object;
    }

    private static Set<class_2248> createDefaultSet(class_2248 ... class_2248Array) {
        LinkedHashSet<class_2248> linkedHashSet = new LinkedHashSet<class_2248>();
        if (class_2248Array != null) {
            Collections.addAll(linkedHashSet, class_2248Array);
            linkedHashSet.remove(null);
            linkedHashSet.remove(class_2246.field_10124);
        }
        return linkedHashSet;
    }
}

