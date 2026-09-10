/*
 * Decompiled with CFR 0.152.
 */
package com.water.spotify;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.invoke.LambdaMetafactory;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class SpotifyAuth {
    private static String field_0;
    private static final Path field_1;
    private static volatile String field_2;
    private static volatile String field_3;
    private static volatile long field_4;
    private static volatile boolean field_5;
    private static final ExecutorService field_6;

    public static void method_0(String string) {
        if (string != null && !string.isBlank() && !string.equals(af)) {
            af = string.trim();
            try {
                Files.deleteIfExists(a);
            }
            catch (Exception exception) {}
            ag = null;
            ah = null;
            ab = 0L;
        }
    }

    public static String method_1() {
        return af;
    }

    public static boolean method_2() {
        return !af.isBlank();
    }

    public static boolean method_3() {
        if (ag != null && System.currentTimeMillis() < ab - 30000L) {
            return true;
        }
        SpotifyAuth.bi();
        return ag != null && System.currentTimeMillis() < ab - 30000L;
    }

    public static String method_4() {
        if (!SpotifyAuth.ae()) {
            return null;
        }
        if (System.currentTimeMillis() > ab - 60000L) {
            f.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, bg(), ()V)());
        }
        return ag;
    }

    public static void method_5(Runnable runnable, Runnable runnable2) {
        if (!SpotifyAuth.ad() || ax) {
            return;
        }
        ax = true;
        f.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, b(java.lang.Runnable java.lang.Runnable ), ()V)((Runnable)runnable2, (Runnable)runnable));
    }

    private static String method_6(String string) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8888);){
            String string2;
            Socket socket;
            block19: {
                block20: {
                    Object object;
                    block17: {
                        block18: {
                            serverSocket.setSoTimeout(120000);
                            socket = serverSocket.accept();
                            object = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                            string2 = ((BufferedReader)object).readLine();
                            if (string2 != null) break block17;
                            if (socket == null) break block18;
                            socket.close();
                        }
                        return null;
                    }
                    try {
                        object = string2.split(" ")[1];
                        object = ((String)object).contains("?") ? ((String)object).split("\\?", 2)[1] : "";
                        string2 = null;
                        String string3 = null;
                        for (String string4 : ((String)object).split("&")) {
                            String[] stringArray = string4.split("=", 2);
                            if (stringArray.length != 2) continue;
                            if (stringArray[0].equals("code")) {
                                string2 = URLDecoder.decode(stringArray[1], StandardCharsets.UTF_8);
                            }
                            if (!stringArray[0].equals("state")) continue;
                            string3 = URLDecoder.decode(stringArray[1], StandardCharsets.UTF_8);
                        }
                        object = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n<html><body style='background:#0a0e18;color:#5be6d0;font-family:sans-serif;text-align:center;padding:50px'><h2>\u2713 Water Client connected to Spotify</h2><p>You can close this tab and return to Minecraft.</p></body></html>";
                        socket.getOutputStream().write(((String)object).getBytes(StandardCharsets.UTF_8));
                        if (string.equals(string3)) break block19;
                        if (socket == null) break block20;
                    }
                    catch (Throwable throwable) {
                        if (socket != null) {
                            try {
                                socket.close();
                            }
                            catch (Throwable throwable2) {
                                throwable.addSuppressed(throwable2);
                            }
                        }
                        throw throwable;
                    }
                    socket.close();
                }
                return null;
            }
            String string4 = string2;
            if (socket != null) {
                socket.close();
            }
            return string4;
        }
    }

    private static String method_7(String charSequence, String object) throws Exception {
        charSequence = "grant_type=authorization_code&code=" + URLEncoder.encode((String)charSequence, StandardCharsets.UTF_8) + "&redirect_uri=" + URLEncoder.encode("http://localhost:8888/callback", StandardCharsets.UTF_8) + "&client_id=" + URLEncoder.encode(af, StandardCharsets.UTF_8) + "&code_verifier=" + URLEncoder.encode((String)object, StandardCharsets.UTF_8);
        object = new URL("https://accounts.spotify.com/api/token");
        object = (HttpURLConnection)((URL)object).openConnection();
        ((HttpURLConnection)object).setRequestMethod("POST");
        ((URLConnection)object).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ((URLConnection)object).setDoOutput(true);
        ((URLConnection)object).setConnectTimeout(10000);
        ((URLConnection)object).setReadTimeout(10000);
        try (Closeable closeable = ((URLConnection)object).getOutputStream();){
            ((OutputStream)closeable).write(((String)charSequence).getBytes(StandardCharsets.UTF_8));
        }
        if (((HttpURLConnection)object).getResponseCode() != 200) {
            return null;
        }
        closeable = new BufferedReader(new InputStreamReader(((URLConnection)object).getInputStream(), StandardCharsets.UTF_8));
        try {
            charSequence = new StringBuilder();
            while ((object = ((BufferedReader)closeable).readLine()) != null) {
                ((StringBuilder)charSequence).append((String)object);
            }
            charSequence = ((StringBuilder)charSequence).toString();
            return charSequence;
        }
        finally {
            ((BufferedReader)closeable).close();
        }
    }

    private static void method_8() {
        if (ah == null) {
            return;
        }
        try {
            CharSequence charSequence = "grant_type=refresh_token&refresh_token=" + URLEncoder.encode(ah, StandardCharsets.UTF_8) + "&client_id=" + URLEncoder.encode(af, StandardCharsets.UTF_8);
            Object object = new URL("https://accounts.spotify.com/api/token");
            object = (HttpURLConnection)((URL)object).openConnection();
            ((HttpURLConnection)object).setRequestMethod("POST");
            ((URLConnection)object).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            ((URLConnection)object).setDoOutput(true);
            ((URLConnection)object).setConnectTimeout(10000);
            ((URLConnection)object).setReadTimeout(10000);
            try (Closeable closeable = ((URLConnection)object).getOutputStream();){
                ((OutputStream)closeable).write(((String)charSequence).getBytes(StandardCharsets.UTF_8));
            }
            if (((HttpURLConnection)object).getResponseCode() != 200) {
                return;
            }
            closeable = new BufferedReader(new InputStreamReader(((URLConnection)object).getInputStream(), StandardCharsets.UTF_8));
            try {
                charSequence = new StringBuilder();
                while ((object = ((BufferedReader)closeable).readLine()) != null) {
                    ((StringBuilder)charSequence).append((String)object);
                }
                SpotifyAuth.w((String)((StringBuilder)charSequence).toString());
            }
            finally {
                ((BufferedReader)closeable).close();
            }
        }
        catch (Exception exception) {}
    }

    private static void method_9(String string) {
        ag = SpotifyAuth.f((String)string, (String)"access_token");
        String string2 = SpotifyAuth.f((String)string, (String)"refresh_token");
        if (string2 != null) {
            ah = string2;
        }
        long l = (string = SpotifyAuth.f((String)string, (String)"expires_in")) != null ? Long.parseLong(string) : 3600L;
        ab = System.currentTimeMillis() + l * 1000L;
        SpotifyAuth.bh();
    }

    private static void method_10() {
        try {
            String string = ag + "\n" + ah + "\n" + ab;
            Files.writeString(a, (CharSequence)string, StandardCharsets.UTF_8, new OpenOption[0]);
        }
        catch (Exception exception) {}
    }

    private static void method_11() {
        try {
            if (!Files.exists(a, new LinkOption[0])) {
                return;
            }
            String[] stringArray = Files.readString(a, StandardCharsets.UTF_8).split("\n");
            if (stringArray.length >= 3) {
                ag = stringArray[0].trim();
                ah = stringArray[1].trim();
                ab = Long.parseLong(stringArray[2].trim());
                if (System.currentTimeMillis() > ab - 30000L && ah != null) {
                    SpotifyAuth.bg();
                }
            }
        }
        catch (Exception exception) {}
    }

    private static String method_12(String string, String string2) {
        int n;
        string2 = "\"" + string2 + "\":";
        int n2 = string.indexOf(string2);
        if (n2 < 0) {
            return null;
        }
        n2 += string2.length();
        while (n2 < string.length() && (string.charAt(n2) == ' ' || string.charAt(n2) == '\"')) {
            ++n2;
        }
        for (n = n2; n < string.length() && string.charAt(n) != '\"' && string.charAt(n) != ',' && string.charAt(n) != '}'; ++n) {
        }
        return string.substring(n2, n).trim();
    }

    public static boolean method_13() {
        return ax;
    }

    private static /* synthetic */ void method_14(Runnable runnable, Runnable runnable2) {
        try {
            Object object = new byte[64];
            new SecureRandom().nextBytes((byte[])object);
            object = Base64.getUrlEncoder().withoutPadding().encodeToString((byte[])object);
            Object object2 = MessageDigest.getInstance("SHA-256");
            object2 = ((MessageDigest)object2).digest(((String)object).getBytes(StandardCharsets.US_ASCII));
            object2 = Base64.getUrlEncoder().withoutPadding().encodeToString((byte[])object2);
            Object object3 = new byte[16];
            new SecureRandom().nextBytes((byte[])object3);
            object3 = Base64.getUrlEncoder().withoutPadding().encodeToString((byte[])object3);
            object2 = "https://accounts.spotify.com/authorize?client_id=" + URLEncoder.encode(af, StandardCharsets.UTF_8) + "&response_type=code&redirect_uri=" + URLEncoder.encode("http://localhost:8888/callback", StandardCharsets.UTF_8) + "&scope=" + URLEncoder.encode("user-read-playback-state user-modify-playback-state user-read-currently-playing playlist-read-private playlist-read-collaborative", StandardCharsets.UTF_8) + "&state=" + (String)object3 + "&code_challenge_method=S256&code_challenge=" + (String)object2;
            Desktop.getDesktop().browse(new URI((String)object2));
            object2 = SpotifyAuth.k((String)object3);
            if (object2 == null) {
                if (runnable != null) {
                    runnable.run();
                }
                return;
            }
            if ((object = SpotifyAuth.e((String)object2, (String)object)) == null) {
                if (runnable != null) {
                    runnable.run();
                }
                return;
            }
            SpotifyAuth.w((String)object);
            if (runnable2 != null) {
                runnable2.run();
            }
        }
        catch (Exception exception) {
            if (runnable != null) {
                runnable.run();
            }
        }
        finally {
            ax = false;
        }
    }

    static {
        af = "";
        a = Paths.get(System.getProperty("user.home"), ".water_spotify_token");
        ag = null;
        ah = null;
        ab = 0L;
        ax = false;
        f = Executors.newSingleThreadExecutor(runnable -> {
            runnable = new Thread(runnable, "spotify-auth");
            ((Thread)runnable).setDaemon(true);
            return runnable;
        });
    }
}

