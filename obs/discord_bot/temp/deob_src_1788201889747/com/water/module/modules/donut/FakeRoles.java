/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.ModeSetting;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_5250;
import net.minecraft.class_5251;

public final class FakeRoles
extends Module {
    public static FakeRoles instance;
    private static final String MODE_NONE = "None";
    private static final String MODE_SRMOD = "SRMOD";
    private static final String MODE_MEDIA = "MEDIA";
    private static final String MODE_SRADMIN = "SRADMIN";
    private static final int TAG_BRACKET = 0x7F7F7F;
    private static final int TAG_SRMOD = 0x55FF55;
    private static final int TAG_MEDIA = 0xFF55FF;
    private static final int TAG_SRADMIN = 0xFF5555;
    private static final int TAG_WHITE = 0xFFFFFF;
    private final ModeSetting role = new ModeSetting("Role", "None", "None", "SRMOD", "MEDIA", "SRADMIN");

    public FakeRoles() {
        super("FakeRoles", Category.d);
        instance = this;
        this.addSetting(this.role);
    }

    /*
     * Exception decompiling
     */
    public static boolean isActive() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17 : ICONST_0 - null : trying to set 0 previously set to 1
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:207)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.populateStackInfo(Op02WithProcessedDataAndRefs.java:1559)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:434)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static String getActiveRole() {
        return !FakeRoles.isActive() ? null : (String)FakeRoles.instance.role.getValue();
    }

    public static String getPlayerName() {
        return mc != null && mc.method_1548() != null ? mc.method_1548().method_1676() : null;
    }

    public static class_2561 modifyChatText(class_2561 class_25612) {
        if (FakeRoles.isActive() && class_25612 != null) {
            String string = FakeRoles.getPlayerName();
            if (string != null && !string.isBlank()) {
                String string2 = class_25612.getString();
                if (!string2.contains(string)) {
                    return class_25612;
                }
                class_25612 = FakeRoles.buildPrefixedName(string);
                int n = string2.indexOf(string);
                class_5250 class_52502 = class_2561.method_43473();
                if (n > 0) {
                    class_52502.method_10852((class_2561)class_2561.method_43470((String)string2.substring(0, n)));
                }
                class_52502.method_10852(class_25612);
                int n2 = n + string.length();
                if (n2 < string2.length()) {
                    class_52502.method_10852((class_2561)class_2561.method_43470((String)string2.substring(n2)));
                }
                return class_52502;
            }
            return class_25612;
        }
        return class_25612;
    }

    public static class_2561 buildPrefixedDisplayName(String string) {
        return FakeRoles.isActive() && string != null ? FakeRoles.buildPrefixedName(string) : null;
    }

    public static String getPrefixedNameString() {
        if (!FakeRoles.isActive()) {
            return null;
        }
        String string = FakeRoles.getPlayerName();
        if (string == null) {
            return null;
        }
        string = FakeRoles.buildPrefixedName(string);
        return string.getString();
    }

    public static class_2583 getRolePrefixStyle() {
        if (!FakeRoles.isActive()) {
            return class_2583.field_24360;
        }
        return switch ((String)FakeRoles.instance.role.getValue()) {
            case MODE_SRMOD -> FakeRoles.roleStyle(0x55FF55);
            case MODE_MEDIA -> FakeRoles.roleStyle(0xFF55FF);
            case MODE_SRADMIN -> FakeRoles.roleStyle(0xFF5555);
            default -> class_2583.field_24360;
        };
    }

    public static class_2583 getRoleBracketStyle() {
        return FakeRoles.isActive() ? class_2583.field_24360.method_27703(class_5251.method_27717((int)0x7F7F7F)).method_10982(Boolean.valueOf(false)) : class_2583.field_24360;
    }

    public static class_2583 getRolePrefixStyleForChar(int n) {
        return n != 91 && n != 93 && !Character.isWhitespace(n) ? FakeRoles.getRolePrefixStyle() : FakeRoles.getRoleBracketStyle();
    }

    public static class_2583 getRoleNameStyle() {
        if (!FakeRoles.isActive()) {
            return class_2583.field_24360;
        }
        return switch ((String)FakeRoles.instance.role.getValue()) {
            case MODE_SRMOD -> FakeRoles.roleStyle(0x55FF55);
            case MODE_MEDIA -> class_2583.field_24360.method_27703(class_5251.method_27717((int)0xFFFFFF)).method_10982(Boolean.valueOf(false));
            case MODE_SRADMIN -> FakeRoles.roleStyle(0xFF5555);
            default -> class_2583.field_24360;
        };
    }

    public static String getRolePrefixString() {
        if (!FakeRoles.isActive()) {
            return null;
        }
        return switch ((String)FakeRoles.instance.role.getValue()) {
            case MODE_SRMOD -> "[SR.MOD] ";
            case MODE_MEDIA -> "[MEDIA] ";
            case MODE_SRADMIN -> "[SR.ADMIN] ";
            default -> null;
        };
    }

    private static class_2561 buildPrefixedName(String string) {
        return switch ((String)FakeRoles.instance.role.getValue()) {
            case MODE_SRMOD -> FakeRoles.buildSrmodName(string);
            case MODE_MEDIA -> FakeRoles.buildMediaName(string);
            case MODE_SRADMIN -> FakeRoles.buildSradminName(string);
            default -> class_2561.method_43470((String)string);
        };
    }

    private static class_2561 buildSrmodName(String string) {
        class_5250 class_52502 = class_2561.method_43473();
        FakeRoles.appendTag(class_52502, "SR.MOD", FakeRoles.roleStyle(0x55FF55));
        class_52502.method_10852((class_2561)class_2561.method_43470((String)string).method_10862(FakeRoles.getRoleNameStyle()));
        return class_52502;
    }

    private static class_2561 buildMediaName(String string) {
        class_5250 class_52502 = class_2561.method_43473();
        FakeRoles.appendTag(class_52502, MODE_MEDIA, FakeRoles.roleStyle(0xFF55FF));
        class_52502.method_10852((class_2561)class_2561.method_43470((String)string).method_10862(FakeRoles.getRoleNameStyle()));
        return class_52502;
    }

    private static class_2561 buildSradminName(String string) {
        class_5250 class_52502 = class_2561.method_43473();
        FakeRoles.appendTag(class_52502, "SR.ADMIN", FakeRoles.roleStyle(0xFF5555));
        class_52502.method_10852((class_2561)class_2561.method_43470((String)string).method_10862(FakeRoles.getRoleNameStyle()));
        return class_52502;
    }

    private static void appendTag(class_5250 class_52502, String string, class_2583 class_25832) {
        class_2583 class_25833 = class_2583.field_24360.method_27703(class_5251.method_27717((int)0x7F7F7F)).method_10982(Boolean.valueOf(false));
        class_52502.method_10852((class_2561)class_2561.method_43470((String)"[").method_10862(class_25833));
        class_52502.method_10852((class_2561)class_2561.method_43470((String)string).method_10862(class_25832));
        class_52502.method_10852((class_2561)class_2561.method_43470((String)"] ").method_10862(class_25833));
    }

    private static class_2583 roleStyle(int n) {
        return class_2583.field_24360.method_27703(class_5251.method_27717((int)n)).method_10982(Boolean.valueOf(true));
    }
}

