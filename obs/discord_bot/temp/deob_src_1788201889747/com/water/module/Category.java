/*
 * Decompiled with CFR 0.152.
 */
package com.water.module;

public final class Category
extends Enum<Category> {
    public static final /* enum */ Category field_0;
    public static final /* enum */ Category field_1;
    public static final /* enum */ Category field_2;
    public static final /* enum */ Category field_3;
    public static final /* enum */ Category field_4;
    private final String field_5;
    private static final /* synthetic */ Category[] field_6;

    public static Category[] values() {
        return (Category[])a.clone();
    }

    public static Category valueOf(String string) {
        return Enum.valueOf(Category.class, string);
    }

    private Category(String string2) {
        this.a = string2;
    }

    public String getName() {
        return this.a;
    }

    private static /* synthetic */ Category[] method_0() {
        return new Category[]{a, b, c, d, e};
    }

    static {
        a = new Category("COMBAT");
        b = new Category("RENDER");
        c = new Category("MISC");
        d = new Category("DONUT");
        e = new Category("CLIENT");
        a = Category.a();
    }
}

