/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils;

import com.water.module.modules.misc.NameProtect;
import com.water.utils.NameProtectUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_5348;
import net.minecraft.class_5481;

public final class NameProtectUtil {
    private NameProtectUtil() {
    }

    public static String replace(String string) {
        if (string == null || !NameProtectUtil.isActive()) {
            return string;
        }
        String string2 = NameProtectUtil.getRealName();
        String string3 = NameProtectUtil.getFakeName();
        if (string2 == null || string3 == null || string2.isBlank() || string2.equals(string3)) {
            return string;
        }
        return string.contains(string2) ? string.replace(string2, string3) : string;
    }

    public static class_5348 replace(class_5348 object) {
        if (object == null || !NameProtectUtil.isActive()) {
            return object;
        }
        List<StyledChunk> list = NameProtectUtil.replaceChunks(NameProtectUtil.collect((class_5348)object));
        if (list == null) {
            return object;
        }
        if (list.isEmpty()) {
            return class_5348.field_25310;
        }
        object = new ArrayList(list.size());
        for (StyledChunk styledChunk : list) {
            object.add(class_5348.method_29431((String)styledChunk.text(), (class_2583)styledChunk.style()));
        }
        return class_5348.method_29432((List)object);
    }

    public static class_5481 replace(class_5481 object) {
        if (object == null || !NameProtectUtil.isActive()) {
            return object;
        }
        List<StyledChunk> list = NameProtectUtil.replaceChunks(NameProtectUtil.collect((class_5481)object));
        if (list == null) {
            return object;
        }
        if (list.isEmpty()) {
            return class_5481.method_34905();
        }
        object = new ArrayList(list.size());
        for (StyledChunk styledChunk : list) {
            object.add(class_5481.method_30747((String)styledChunk.text(), (class_2583)styledChunk.style()));
        }
        return class_5481.method_30749((List)object);
    }

    private static boolean isActive() {
        return NameProtect.instance != null && NameProtect.instance.isEnabled() && NameProtectUtil.getRealName() != null && !NameProtectUtil.getRealName().isBlank();
    }

    private static String getRealName() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_1548() == null) {
            return null;
        }
        return class_3102.method_1548().method_1676();
    }

    private static String getFakeName() {
        if (NameProtect.instance == null) {
            return null;
        }
        return NameProtect.instance.getFakeName();
    }

    private static List<StyledChunk> collect(class_5348 class_53482) {
        ArrayList<StyledChunk> arrayList = new ArrayList<StyledChunk>();
        class_53482.method_27658((class_25832, string) -> {
            NameProtectUtil.appendCodePoints(arrayList, string, class_25832);
            return Optional.empty();
        }, class_2583.field_24360);
        return arrayList;
    }

    private static List<StyledChunk> collect(class_5481 class_54812) {
        ArrayList<StyledChunk> arrayList = new ArrayList<StyledChunk>();
        class_54812.accept((n, class_25832, n2) -> {
            arrayList.add(new StyledChunk(new String(Character.toChars(n2)), class_25832));
            return true;
        });
        return arrayList;
    }

    private static void appendCodePoints(List<StyledChunk> list, String string, class_2583 class_25832) {
        int n;
        if (string == null || string.isEmpty()) {
            return;
        }
        for (int i = 0; i < string.length(); i += Character.charCount(n)) {
            n = string.codePointAt(i);
            list.add(new StyledChunk(new String(Character.toChars(n)), class_25832));
        }
    }

    private static List<StyledChunk> replaceChunks(List<StyledChunk> list) {
        String string = NameProtectUtil.getRealName();
        String string2 = NameProtectUtil.getFakeName();
        if (string == null || string2 == null || string.isBlank() || string.equals(string2)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> arrayList = new ArrayList<Integer>(list.size());
        for (StyledChunk object2 : list) {
            arrayList.add(stringBuilder.length());
            stringBuilder.append(object2.text());
        }
        String string3 = stringBuilder.toString();
        if (!string3.contains(string)) {
            return null;
        }
        ArrayList<StyledChunk> arrayList2 = new ArrayList<StyledChunk>();
        int n = 0;
        int n2 = 0;
        while ((n2 = string3.indexOf(string, n2)) >= 0) {
            while (n < list.size() && (Integer)arrayList.get(n) < n2) {
                arrayList2.add(list.get(n++));
            }
            class_2583 class_25832 = n < list.size() ? list.get(n).style() : class_2583.field_24360;
            arrayList2.add(new StyledChunk(string2, class_25832));
            n2 += string.length();
            while (n < list.size() && (Integer)arrayList.get(n) < n2) {
                ++n;
            }
        }
        while (n < list.size()) {
            arrayList2.add(list.get(n++));
        }
        return NameProtectUtil.merge(arrayList2);
    }

    private static List<StyledChunk> merge(List<StyledChunk> list) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList<StyledChunk> arrayList = new ArrayList<StyledChunk>(list.size());
        StyledChunk styledChunk = list.getFirst();
        for (int i = 1; i < list.size(); ++i) {
            StyledChunk styledChunk2 = list.get(i);
            if (Objects.equals(styledChunk.style(), styledChunk2.style())) {
                styledChunk = new StyledChunk(styledChunk.text() + styledChunk2.text(), styledChunk.style());
                continue;
            }
            arrayList.add(styledChunk);
            styledChunk = styledChunk2;
        }
        arrayList.add(styledChunk);
        return arrayList;
    }
}

