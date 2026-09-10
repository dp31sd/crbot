/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.client;

import com.water.module.Category;
import com.water.module.Module;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.invoke.LambdaMetafactory;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import net.minecraft.class_310;

public final class DiscordRPC
extends Module {
    private ScheduledExecutorService field_0;
    private volatile boolean field_1;
    private volatile long field_2;
    private volatile long field_3;
    private Socket field_4;
    private OutputStream field_5;
    private InputStream field_6;

    public DiscordRPC() {
        super("DiscordRPC", Category.e);
        this.g = false;
        this.a = 0L;
        this.b = 0L;
    }

    @Override
    public void onEnable() {
        if (this.a != null && !this.a.isShutdown()) {
            return;
        }
        if (this.a == 0L) {
            this.a = System.currentTimeMillis() / 1000L;
        }
        this.a = Executors.newSingleThreadScheduledExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, a(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
        this.a.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, i(), ()V)((DiscordRPC)this));
        this.a.scheduleAtFixedRate((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, l(), ()V)((DiscordRPC)this), 5L, 15L, TimeUnit.SECONDS);
    }

    @Override
    public void onTick() {
        if (!this.isEnabled()) {
            return;
        }
        if (this.a == null || this.a.isShutdown()) {
            this.onEnable();
        }
    }

    @Override
    public void onDisable() {
        if (this.a != null) {
            this.a.shutdownNow();
        }
        this.m();
        this.j();
    }

    private void method_0() {
        long j1 = System.currentTimeMillis();
        if (this.g || j1 - this.b < 5000L) {
            return;
        }
        this.b = j1;
        this.j();
        for (int i1 = 0; i1 <= 9; ++i1) {
            try {
                String v2 = this.a(i1);
                if (v2 == null) break;
                this.j(v2);
                if (!this.g) continue;
                this.k();
                this.l();
                return;
            }
            catch (Exception exception) {}
        }
    }

    private String method_1(int index) {
        String[] v2 = System.getProperty("os.name", "").toLowerCase();
        if (v2.contains("win")) {
            return "\\\\.\\pipe\\discord-ipc-" + index;
        }
        v2 = new String[]{System.getenv("XDG_RUNTIME_DIR"), System.getenv("TMPDIR"), System.getenv("TMP"), System.getenv("TEMP"), "/tmp"};
        int cfr_ignored_0 = v2.length;
        for (int i3 = 0; i3 < 5; ++i3) {
            Object v4 = v2[i3];
            if (v4 == null || !((File)(v4 = new File((String)v4, "discord-ipc-" + index))).exists()) continue;
            return ((File)v4).getAbsolutePath();
        }
        return null;
    }

    private void method_2(String path) {
        try {
            String v2 = System.getProperty("os.name", "").toLowerCase();
            if (v2.contains("win")) {
                this.k(path);
            } else {
                this.l(path);
            }
        }
        catch (Exception exception) {
            this.g = false;
        }
    }

    private void method_3(String path) throws Exception {
        path = new RandomAccessFile((String)path, "rw");
        this.a = new FileOutputStream(((RandomAccessFile)path).getFD());
        this.a = new InputStream(this, (RandomAccessFile)path){
            private /* synthetic */ RandomAccessFile field_0;
            {
                this.a = randomAccessFile;
            }

            @Override
            public int read() throws IOException {
                return this.a.read();
            }

            @Override
            public int read(byte[] byArray, int n, int n2) throws IOException {
                return this.a.read(byArray, n, n2);
            }
        };
        this.g = true;
    }

    private void method_4(String path) throws Exception {
        try {
            Class<?> v2 = Class.forName("java.net.UnixDomainSocketAddress");
            path = v2.getMethod("of", String.class).invoke(null, path);
            v2 = Class.forName("java.nio.channels.SocketChannel");
            Object v3 = v2.getMethod("open", Class.forName("java.net.ProtocolFamily")).invoke(null, Enum.valueOf(Class.forName("java.net.StandardProtocolFamily"), "UNIX"));
            v2.getMethod("connect", Class.forName("java.net.SocketAddress")).invoke(v3, path);
            this.a = (Socket)v2.getMethod("socket", new Class[0]).invoke(v3, new Object[0]);
            this.a = this.a.getOutputStream();
            this.a = this.a.getInputStream();
            this.g = true;
        }
        catch (Exception exception) {
            this.g = false;
        }
    }

    private void method_5() {
        this.g = false;
        try {
            if (this.a != null) {
                this.a.close();
            }
        }
        catch (Exception exception) {}
        try {
            if (this.a != null) {
                this.a.close();
            }
        }
        catch (Exception exception) {}
        try {
            if (this.a != null) {
                this.a.close();
            }
        }
        catch (Exception exception) {}
        this.a = null;
        this.a = null;
        this.a = null;
    }

    private void method_6() throws Exception {
        String v1 = "{\"v\":1,\"client_id\":\"1529221242077450381\"}";
        this.a(0, v1);
    }

    private void method_7(int opcode, String json) throws Exception {
        json = ((String)json).getBytes(StandardCharsets.UTF_8);
        byte[] v3 = new byte[8];
        v3[0] = (byte)(opcode & 0xFF);
        v3[1] = (byte)(opcode >> 8 & 0xFF);
        v3[2] = (byte)(opcode >> 16 & 0xFF);
        v3[3] = (byte)(opcode >> 24 & 0xFF);
        opcode = ((Object)json).length;
        v3[4] = (byte)(opcode & 0xFF);
        v3[5] = (byte)(opcode >> 8 & 0xFF);
        v3[6] = (byte)(opcode >> 16 & 0xFF);
        v3[7] = (byte)(opcode >> 24 & 0xFF);
        this.a.write(v3);
        this.a.write((byte[])json);
        this.a.flush();
    }

    private void method_8() {
        if (!this.g) {
            this.i();
            return;
        }
        try {
            Object v1 = class_310.method_1551();
            String v2 = "Playing on Fashion styles water crack";
            v1 = v1 != null && v1.method_1558() != null ? v1.method_1558().field_3761 : "Singleplayer";
            String v3 = String.valueOf(System.currentTimeMillis());
            v1 = "{\"cmd\":\"SET_ACTIVITY\",\"args\":{\"pid\":" + ProcessHandle.current().pid() + ",\"activity\":{\"details\":\"" + DiscordRPC.c((String)v2) + "\",\"state\":\"" + DiscordRPC.c((String)v1) + "\",\"timestamps\":{\"start\":" + this.a + "},\"assets\":{\"large_image\":\"content\",\"large_text\":\"Water Client\",\"small_image\":\"minecraft\",\"small_text\":\"Minecraft\"}}},\"nonce\":\"" + v3 + "\"}";
            this.a(1, (String)v1);
        }
        catch (Exception exception) {
            this.j();
        }
    }

    private void method_9() {
        if (!this.g) {
            return;
        }
        try {
            String v1 = String.valueOf(System.currentTimeMillis());
            v1 = "{\"cmd\":\"SET_ACTIVITY\",\"args\":{\"pid\":" + ProcessHandle.current().pid() + ",\"activity\":null},\"nonce\":\"" + v1 + "\"}";
            this.a(1, v1);
        }
        catch (Exception exception) {}
    }

    private static String method_10(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
    }

    private static /* synthetic */ Thread method_11(Runnable r) {
        r = new Thread(r, "water-drpc");
        ((Thread)r).setDaemon(true);
        return r;
    }
}

