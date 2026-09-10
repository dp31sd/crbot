/*
 * Decompiled with CFR 0.152.
 */
package com.water.setting;

import com.water.setting.ItemOption;
import com.water.setting.Setting;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class MultiItemSetting
extends Setting<Set<String>> {
    private final List<ItemOption> field_0;

    public MultiItemSetting(String string, ItemOption ... itemOptionArray) {
        super(string, new LinkedHashSet());
        this.i = List.of(itemOptionArray);
    }

    @Override
    public void setValue(Set<String> object) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        if (object != null) {
            object = object.iterator();
            block0: while (object.hasNext()) {
                String string = (String)object.next();
                if (string == null) continue;
                for (ItemOption itemOption : this.i) {
                    if (!itemOption.value().equalsIgnoreCase(string)) continue;
                    linkedHashSet.add(itemOption.value());
                    continue block0;
                }
            }
        }
        super.setValue(linkedHashSet);
    }
}

