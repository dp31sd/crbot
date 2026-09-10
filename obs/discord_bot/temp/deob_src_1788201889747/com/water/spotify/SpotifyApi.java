/*
 * Decompiled with CFR 0.152.
 */
package com.water.spotify;

import com.water.spotify.SpotifyAuth;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class SpotifyApi {
    /*
     * Exception decompiling
     */
    public static List<a> method_0(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl16 : ALOAD_0 - null : trying to set 1 previously set to 0
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

    public static List<a> method_1() {
        String string = SpotifyApi.i((String)"https://api.spotify.com/v1/me/player/queue");
        if (string == null) {
            return new ArrayList<a>();
        }
        ArrayList<a> arrayList = new ArrayList<a>();
        String string2 = string;
        String string3 = "currently_playing";
        String string4 = "\ufffd";
        String string5 = string;
        String string6 = "currently_playing";
        String string7 = "\ufffd\ufffd\ufffd";
        String string8 = SpotifyApi.j((String)SpotifyApi.c((String)string, (String)"currently_playing"));
        String string9 = string;
        String string10 = "currently_playing";
        String string11 = "\ufffd\ufffd";
        if (string7 != null) {
            arrayList.add(new a(string4, string7, string8 != null ? string8 : "", string11 != null ? string11 : ""));
        }
        if ((string = SpotifyApi.d((String)string, (String)"queue")) != null) {
            arrayList.addAll(SpotifyApi.d((String)string));
        }
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    public static List<String[]> method_2() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl26 : ALOAD_0 - null : trying to set 2 previously set to 0
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

    public static boolean method_3(String string) {
        string = "{\"uris\":[\"" + string + "\"]}";
        return SpotifyApi.a((String)"https://api.spotify.com/v1/me/player/play", (String)string) == 204;
    }

    public static boolean method_4(String string, String string2) {
        string = "{\"context_uri\":\"" + string + "\",\"offset\":{\"uri\":\"" + string2 + "\"}}";
        return SpotifyApi.a((String)"https://api.spotify.com/v1/me/player/play", (String)string) == 204;
    }

    public static boolean method_5() {
        return SpotifyApi.b((String)"https://api.spotify.com/v1/me/player/pause", (String)"") == 204;
    }

    public static boolean method_6() {
        return SpotifyApi.b((String)"https://api.spotify.com/v1/me/player/next", (String)"") == 204;
    }

    public static boolean method_7() {
        return SpotifyApi.b((String)"https://api.spotify.com/v1/me/player/previous", (String)"") == 204;
    }

    private static String method_8(String object) {
        CharSequence charSequence = SpotifyAuth.t();
        if (charSequence == null) {
            return null;
        }
        object = new URL((String)object);
        object = (HttpURLConnection)((URL)object).openConnection();
        ((HttpURLConnection)object).setRequestMethod("GET");
        ((URLConnection)object).setRequestProperty("Authorization", "Bearer " + (String)charSequence);
        ((URLConnection)object).setConnectTimeout(8000);
        ((URLConnection)object).setReadTimeout(8000);
        if (((HttpURLConnection)object).getResponseCode() == 401) {
            return null;
        }
        if (((HttpURLConnection)object).getResponseCode() == 204) {
            return "";
        }
        if (((HttpURLConnection)object).getResponseCode() != 200) {
            return null;
        }
        object = new BufferedReader(new InputStreamReader(((URLConnection)object).getInputStream(), StandardCharsets.UTF_8));
        try {
            String string;
            charSequence = new StringBuilder();
            while ((string = ((BufferedReader)object).readLine()) != null) {
                ((StringBuilder)charSequence).append(string);
            }
            charSequence = ((StringBuilder)charSequence).toString();
        }
        catch (Throwable throwable) {
            try {
                try {
                    ((BufferedReader)object).close();
                }
                catch (Throwable throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
            catch (Exception exception) {
                return null;
            }
        }
        ((BufferedReader)object).close();
        return charSequence;
    }

    private static int method_9(String string, String string2) {
        return SpotifyApi.a((String)string, (String)"PUT", (String)string2);
    }

    private static int method_10(String string, String string2) {
        return SpotifyApi.a((String)string, (String)"POST", (String)string2);
    }

    private static int method_11(String object, String object2, String string) {
        String string2 = SpotifyAuth.t();
        if (string2 == null) {
            return -1;
        }
        try {
            object = new URL((String)object);
            object = (HttpURLConnection)((URL)object).openConnection();
            ((HttpURLConnection)object).setRequestMethod((String)object2);
            ((URLConnection)object).setRequestProperty("Authorization", "Bearer " + string2);
            ((URLConnection)object).setRequestProperty("Content-Type", "application/json");
            ((URLConnection)object).setConnectTimeout(8000);
            ((URLConnection)object).setReadTimeout(8000);
            if (!string.isEmpty()) {
                ((URLConnection)object).setDoOutput(true);
                object2 = ((URLConnection)object).getOutputStream();
                try {
                    ((OutputStream)object2).write(string.getBytes(StandardCharsets.UTF_8));
                }
                finally {
                    if (object2 != null) {
                        ((OutputStream)object2).close();
                    }
                }
            }
            return ((HttpURLConnection)object).getResponseCode();
        }
        catch (Exception exception) {
            return -1;
        }
    }

    /*
     * Exception decompiling
     */
    private static List<a> method_12(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17 : ALOAD_0 - null : trying to set 3 previously set to 0
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

    /*
     * Exception decompiling
     */
    private static List<a> method_13(String var0) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl9 : ALOAD_0 - null : trying to set 3 previously set to 0
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

    private static String method_14(String object) {
        if (object == null) {
            return null;
        }
        String string = object;
        object = "0\ufffd8\ufffd";
        if (object == null) {
            return null;
        }
        if ((object = SpotifyApi.e((String)object)).isEmpty()) {
            return null;
        }
        String string2 = (String)object.get(0);
        return "\ufffd\ufffd\ufffd";
    }

    private static String method_15(String string, String string2) {
        int n;
        if (string == null) {
            return null;
        }
        string2 = "\"" + string2 + "\":";
        int n2 = string.indexOf(string2);
        if (n2 < 0) {
            return null;
        }
        n2 += string2.length();
        while (n2 < string.length() && string.charAt(n2) == ' ') {
            ++n2;
        }
        if (n2 >= string.length()) {
            return null;
        }
        if (string.charAt(n2) == '\"') {
            int n3;
            for (n3 = ++n2; n3 < string.length() && string.charAt(n3) != '\"'; ++n3) {
                if (string.charAt(n3) != '\\') continue;
                ++n3;
            }
            return string.substring(n2, Math.min(n3, string.length()));
        }
        if (string.charAt(n2) == 'n') {
            return null;
        }
        for (n = n2; n < string.length() && ",}]".indexOf(string.charAt(n)) < 0; ++n) {
        }
        return string.substring(n2, n).trim();
    }

    private static String method_16(String string, String string2, String string3) {
        return (string = SpotifyApi.c((String)string, (String)string2)) != null ? SpotifyApi.b((String)string, (String)string3) : null;
    }

    private static String method_17(String string, String string2) {
        if (string == null) {
            return null;
        }
        string2 = "\"" + string2 + "\":";
        int n = string.indexOf(string2);
        if (n < 0) {
            return null;
        }
        n += string2.length();
        while (n < string.length() && string.charAt(n) == ' ') {
            ++n;
        }
        if (n >= string.length() || string.charAt(n) != '{') {
            return null;
        }
        return SpotifyApi.a((String)string, (int)n, (char)'{', (char)'}');
    }

    private static String method_18(String string, String string2) {
        if (string == null) {
            return null;
        }
        string2 = "\"" + string2 + "\":";
        int n = string.indexOf(string2);
        if (n < 0) {
            return null;
        }
        n += string2.length();
        while (n < string.length() && string.charAt(n) == ' ') {
            ++n;
        }
        if (n >= string.length() || string.charAt(n) != '[') {
            return null;
        }
        return (string = SpotifyApi.a((String)string, (int)n, (char)'[', (char)']')) != null ? string.substring(1, string.length() - 1) : null;
    }

    private static String method_19(String string, int n, char c2, char c3) {
        int n2 = 0;
        boolean bl = false;
        for (int i = n; i < string.length(); ++i) {
            char c4 = string.charAt(i);
            if (c4 == '\"' && (i == 0 || string.charAt(i - 1) != '\\')) {
                boolean bl2 = bl = !bl;
            }
            if (bl) continue;
            if (c4 == c2) {
                ++n2;
            }
            if (c4 != c3 || --n2 != 0) continue;
            return string.substring(n, i + 1);
        }
        return null;
    }

    private static List<String> method_20(String string) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (string == null || string.isBlank()) {
            return arrayList;
        }
        int n = 0;
        int n2 = -1;
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c2 = string.charAt(i);
            if (c2 == '\"' && (i == 0 || string.charAt(i - 1) != '\\')) {
                boolean bl2 = bl = !bl;
            }
            if (bl) continue;
            if (c2 == '{') {
                if (n++ != 0) continue;
                n2 = i;
                continue;
            }
            if (c2 != '}' || --n != 0 || n2 < 0) continue;
            arrayList.add(string.substring(n2, i + 1));
            n2 = -1;
        }
        return arrayList;
    }

    public static final class a {
        private String field_0;
        public final String field_1;
        private String field_2;
        public final String field_3;

        public a(String string, String string2, String string3, String string4) {
            this.ac = string;
            this.ad = string2;
            this.g = string3;
            this.ae = string4;
        }

        public String method_0() {
            return this.g.isEmpty() ? this.ad : this.g + " - " + this.ad;
        }
    }
}

