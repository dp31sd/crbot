/*
 * Decompiled with CFR 0.152.
 */
package com.water.utils;

import com.water.module.modules.donut.FakeRoles;
import com.water.utils.FakeRolesUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.class_2583;
import net.minecraft.class_310;
import net.minecraft.class_5348;
import net.minecraft.class_5481;

public final class FakeRolesUtil {
    private FakeRolesUtil() {
    }

    public static String replace(String string) {
        if (string != null && FakeRoles.isActive()) {
            String string2 = FakeRolesUtil.getRealName();
            if (string2 == null || string2.isBlank()) {
                return string;
            }
            if (!string.contains(string2)) {
                return string;
            }
            String string3 = FakeRoles.getPrefixedNameString();
            return string3 != null && !string3.equals(string2) ? string.replace(string2, string3) : string;
        }
        return string;
    }

    public static class_5481 replace(class_5481 object) {
        if (object != null && FakeRoles.isActive()) {
            List<StyledChar> list = FakeRolesUtil.replaceChunks(FakeRolesUtil.collectOrdered((class_5481)object));
            if (list == null) {
                return object;
            }
            if (list.isEmpty()) {
                return class_5481.method_34905();
            }
            object = new ArrayList(list.size());
            for (StyledChar styledChar : list) {
                object.add(class_5481.method_30747((String)styledChar.text(), (class_2583)styledChar.style()));
            }
            return class_5481.method_30749((List)object);
        }
        return object;
    }

    public static class_5348 replace(class_5348 object) {
        if (object != null && FakeRoles.isActive()) {
            List<StyledChar> list = FakeRolesUtil.replaceChunks(FakeRolesUtil.collectVisitable((class_5348)object));
            if (list == null) {
                return object;
            }
            if (list.isEmpty()) {
                return class_5348.field_25310;
            }
            object = new ArrayList(list.size());
            for (StyledChar styledChar : list) {
                object.add(class_5348.method_29431((String)styledChar.text(), (class_2583)styledChar.style()));
            }
            return class_5348.method_29432((List)object);
        }
        return object;
    }

    private static String getRealName() {
        class_310 class_3102 = class_310.method_1551();
        return class_3102 != null && class_3102.method_1548() != null ? class_3102.method_1548().method_1676() : null;
    }

    private static List<StyledChar> collectOrdered(class_5481 class_54812) {
        ArrayList<StyledChar> arrayList = new ArrayList<StyledChar>();
        class_54812.accept((n, class_25832, n2) -> {
            arrayList.add(new StyledChar(new String(Character.toChars(n2)), class_25832));
            return true;
        });
        return arrayList;
    }

    private static List<StyledChar> collectVisitable(class_5348 class_53482) {
        ArrayList<StyledChar> arrayList = new ArrayList<StyledChar>();
        class_53482.method_27658((class_25832, string) -> {
            int n;
            for (int i = 0; i < string.length(); i += Character.charCount(n)) {
                n = string.codePointAt(i);
                arrayList.add(new StyledChar(new String(Character.toChars(n)), class_25832));
            }
            return Optional.empty();
        }, class_2583.field_24360);
        return arrayList;
    }

    private static List<StyledChar> replaceChunks(List<StyledChar> list) {
        String string = FakeRolesUtil.getRealName();
        if (string != null && !string.isBlank()) {
            StyledChar styledChar2;
            String string2 = FakeRoles.getRolePrefixString();
            if (string2 == null) {
                return null;
            }
            Serializable serializable = new StringBuilder();
            ArrayList<Integer> arrayList = new ArrayList<Integer>(list.size());
            for (StyledChar styledChar2 : list) {
                arrayList.add(((StringBuilder)serializable).length());
                ((StringBuilder)serializable).append(styledChar2.text());
            }
            String string3 = ((StringBuilder)serializable).toString();
            if (!string3.contains(string)) {
                return null;
            }
            styledChar2 = FakeRoles.getRoleNameStyle();
            serializable = new ArrayList();
            int n = 0;
            int n2 = 0;
            while ((n2 = string3.indexOf(string, n2)) >= 0) {
                int n3;
                int n4;
                while (n < list.size() && (Integer)arrayList.get(n) < n2) {
                    serializable.add(list.get(n++));
                }
                for (n3 = 0; n3 < string2.length(); n3 += Character.charCount(n4)) {
                    n4 = string2.codePointAt(n3);
                    serializable.add(new StyledChar(new String(Character.toChars(n4)), FakeRoles.getRolePrefixStyleForChar(n4)));
                }
                for (n3 = 0; n3 < string.length(); n3 += Character.charCount(n4)) {
                    n4 = string.codePointAt(n3);
                    serializable.add(new StyledChar(new String(Character.toChars(n4)), (class_2583)styledChar2));
                }
                n3 = n2 + string.length();
                while (n < list.size() && (Integer)arrayList.get(n) < n3) {
                    ++n;
                }
                n2 = n3;
            }
            while (n < list.size()) {
                serializable.add(list.get(n++));
            }
            return FakeRolesUtil.merge((List<StyledChar>)((Object)serializable));
        }
        return null;
    }

    private static List<StyledChar> merge(List<StyledChar> list) {
        if (list.isEmpty()) {
            return list;
        }
        ArrayList<StyledChar> arrayList = new ArrayList<StyledChar>(list.size());
        StyledChar styledChar = list.getFirst();
        for (int i = 1; i < list.size(); ++i) {
            StyledChar styledChar2 = list.get(i);
            if (Objects.equals(styledChar.style(), styledChar2.style())) {
                styledChar = new StyledChar(styledChar.text() + styledChar2.text(), styledChar.style());
                continue;
            }
            arrayList.add(styledChar);
            styledChar = styledChar2;
        }
        arrayList.add(styledChar);
        return arrayList;
    }
}

