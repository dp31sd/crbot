/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.client;

import com.water.gui.ClickGuiScreen;
import com.water.gui.hud.SpotifyQueueHud;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.Hud;
import com.water.module.modules.client.WaterPlus;
import com.water.setting.Setting;
import com.water.utils.renderer.Blur2DRenderer;
import com.water.utils.renderer.GuiRenderer;
import com.water.utils.renderer.WaterFontRenderer;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.lang.invoke.LambdaMetafactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import net.minecraft.class_1011;
import net.minecraft.class_1043;
import net.minecraft.class_1044;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_332;

public final class SpotifyHud
extends Module {
    private static SpotifyHud field_0;
    private final Setting<Float> field_1;
    private volatile String field_2;
    private volatile String field_3;
    private volatile boolean field_4;
    private volatile boolean field_5;
    private volatile long field_6;
    private volatile long field_7;
    private volatile long field_8;
    private ScheduledExecutorService field_9;
    private ExecutorService field_10;
    private File field_11;
    private File field_12;
    private File field_13;
    private static final class_2960 field_14;
    private static final class_2960 field_15;
    private class_1043 field_16;
    private volatile long field_17;
    private volatile boolean field_18;
    private float field_19;
    private long field_20;
    private volatile boolean field_21;
    private final AtomicBoolean field_22;
    private final AtomicInteger field_23;
    private volatile float field_24;
    private volatile String field_25;

    public SpotifyHud() {
        super("Spotify HUD", Category.e);
        this.aa = new Setting<Float>("Scale", Float.valueOf(1.0f), Float.valueOf(0.6f), Float.valueOf(2.0f));
        this.f = "";
        this.g = "";
        this.h = false;
        this.i = false;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.a = null;
        this.h = 0L;
        this.j = false;
        this.a = 0.0f;
        this.i = 0L;
        this.k = false;
        this.a = new AtomicBoolean(false);
        this.a = new AtomicInteger(0);
        this.b = 0.0f;
        this.h = null;
        this.addSetting(this.aa);
        a = this;
    }

    public static boolean isActive() {
        return a != null && a.isEnabled();
    }

    public static float method_0() {
        return a == null ? 1.0f : ((Float)SpotifyHud.a.aa.getValue()).floatValue();
    }

    public static void method_1(float f) {
        float f2;
        float f3;
        if (a == null) {
            return;
        }
        Object object = SpotifyHud.a.aa.getMin();
        if (object instanceof Float) {
            object = (Float)object;
            f3 = ((Float)object).floatValue();
        } else {
            f3 = 0.6f;
        }
        float f4 = f3;
        Object t = SpotifyHud.a.aa.getMax();
        if (t instanceof Float) {
            object = (Float)t;
            f2 = ((Float)object).floatValue();
        } else {
            f2 = 2.0f;
        }
        float f5 = f2;
        SpotifyHud.a.aa.setValue(Float.valueOf(Math.max(f4, Math.min(f5, f))));
        int[] nArray = Hud.a((Hud.a)Hud.a.h);
        int n = SpotifyHud.c((int)nArray[0]);
        int n2 = SpotifyHud.d((int)nArray[1]);
        if (n != nArray[0] || n2 != nArray[1]) {
            Hud.a((Hud.a)Hud.a.h, (int)n, (int)n2);
        }
    }

    public static int method_2() {
        return Math.round(270.0f * SpotifyHud.b());
    }

    public static int method_3() {
        return Math.round(60.0f * SpotifyHud.b());
    }

    private static int method_4(int n) {
        return Math.round((float)n * SpotifyHud.b());
    }

    private static float method_5(float f) {
        return f * SpotifyHud.b();
    }

    private static int method_6(int n) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return n;
        }
        return Math.max(0, Math.min(n, class_3102.method_22683().method_4486() - SpotifyHud.a()));
    }

    private static int method_7(int n) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return n;
        }
        return Math.max(0, Math.min(n, class_3102.method_22683().method_4502() - SpotifyHud.b()));
    }

    private static int method_8() {
        return SpotifyHud.c((int)Hud.a((Hud.a)Hud.a.h)[0]);
    }

    private static int method_9() {
        return SpotifyHud.d((int)Hud.a((Hud.a)Hud.a.h)[1]);
    }

    @Override
    public void onEnable() {
        this.n();
    }

    @Override
    public void onTick() {
        if (this.a == null || this.a.isShutdown()) {
            this.n();
        }
    }

    private void method_10() {
        this.a = 0.0f;
        this.i = 0L;
        this.k = false;
        this.a.set(0);
        this.o();
        this.c = new File(System.getenv("TEMP"), "water_spotify_art.png");
        Thread thread = new Thread((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, p(), ()V)((SpotifyHud)this), "water-spotify-initial");
        thread.setDaemon(true);
        thread.start();
        this.a = Executors.newSingleThreadScheduledExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, c(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
        this.a = Executors.newSingleThreadExecutor((ThreadFactory)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Runnable;)Ljava/lang/Thread;, b(java.lang.Runnable ), (Ljava/lang/Runnable;)Ljava/lang/Thread;)());
        this.a.scheduleAtFixedRate((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, r(), ()V)((SpotifyHud)this), 1000L, 800L, TimeUnit.MILLISECONDS);
        this.a.scheduleAtFixedRate((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, p(), ()V)((SpotifyHud)this), 2L, 2L, TimeUnit.SECONDS);
    }

    @Override
    public void onDisable() {
        if (this.a != null) {
            this.a.shutdownNow();
        }
        if (this.a != null) {
            this.a.shutdownNow();
        }
        this.f = "";
        this.g = "";
        this.h = false;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.a = 0.0f;
        this.j = false;
        this.h = null;
        if (this.a != null) {
            try {
                class_310.method_1551().method_1531().method_4615(a);
            }
            catch (Exception exception) {}
            this.a = null;
        }
    }

    private void method_11() {
        try {
            this.a = File.createTempFile("water_smtc_poll_", ".ps1");
            this.a.deleteOnExit();
            try (FileWriter fileWriter = new FileWriter(this.a, StandardCharsets.UTF_8);){
                fileWriter.write("[void][System.Reflection.Assembly]::LoadFile('C:\\Windows\\Microsoft.NET\\Framework64\\v4.0.30319\\System.Runtime.WindowsRuntime.dll')\r\n$null = [Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager,Windows.Media.Control,ContentType=WindowsRuntime]\r\n$g = ([System.WindowsRuntimeSystemExtensions].GetMethods() | Where-Object { $_.Name -eq 'AsTask' -and $_.GetParameters().Count -eq 1 -and $_.GetParameters()[0].ParameterType.Name -like 'IAsyncOperation*' })[0]\r\nfunction Aw($op,$t){$m=$g.MakeGenericMethod($t);$task=$m.Invoke($null,@($op));$task.GetAwaiter().GetResult()}\r\n$asStreamForRead = [System.IO.WindowsRuntimeStreamExtensions].GetMethods() | Where-Object { $_.Name -eq 'AsStreamForRead' -and $_.GetParameters().Count -eq 1 } | Select-Object -First 1\r\ntry {\r\n  $mgr = Aw([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager]::RequestAsync()) ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager])\r\n  $s = $mgr.GetCurrentSession()\r\n  if ($s) {\r\n    $p = Aw($s.TryGetMediaPropertiesAsync()) ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionMediaProperties])\r\n    $tl = $s.GetTimelineProperties()\r\n    $pb = $s.GetPlaybackInfo()\r\n    if ($p.Title) {\r\n      if ($p.Thumbnail -and $asStreamForRead) {\r\n        try {\r\n          $stream = Aw($p.Thumbnail.OpenReadAsync()) ([Windows.Storage.Streams.IRandomAccessStreamWithContentType])\r\n          $netStream = $asStreamForRead.Invoke($null, @($stream))\r\n          $outPath = Join-Path $env:TEMP 'water_spotify_art.png'\r\n          $fs = [System.IO.File]::Create($outPath)\r\n          $netStream.CopyTo($fs)\r\n          $fs.Close()\r\n          $netStream.Close()\r\n        } catch {}\r\n      }\r\n      Write-Output ($p.Artist + '|||' + $p.Title + '|||' + [long]$tl.Position.TotalMilliseconds + '|||' + [long]$tl.EndTime.TotalMilliseconds + '|||' + ($pb.PlaybackStatus.ToString() -eq 'Playing'))\r\n    }\r\n  }\r\n} catch {}\r\n");
            }
            this.b = File.createTempFile("water_smtc_ctrl_", ".ps1");
            this.b.deleteOnExit();
            fileWriter = new FileWriter(this.b, StandardCharsets.UTF_8);
            try {
                fileWriter.write("param([string]$action)\r\n[void][System.Reflection.Assembly]::LoadFile('C:\\Windows\\Microsoft.NET\\Framework64\\v4.0.30319\\System.Runtime.WindowsRuntime.dll')\r\n$null = [Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager,Windows.Media.Control,ContentType=WindowsRuntime]\r\n$g = ([System.WindowsRuntimeSystemExtensions].GetMethods() | Where-Object { $_.Name -eq 'AsTask' -and $_.GetParameters().Count -eq 1 -and $_.GetParameters()[0].ParameterType.Name -like 'IAsyncOperation*' })[0]\r\nfunction Aw($op,$t){$m=$g.MakeGenericMethod($t);$task=$m.Invoke($null,@($op));$task.GetAwaiter().GetResult()}\r\ntry {\r\n  $mgr = Aw([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager]::RequestAsync()) ([Windows.Media.Control.GlobalSystemMediaTransportControlsSessionManager])\r\n  $s = $mgr.GetCurrentSession()\r\n  if ($s) {\r\n    switch ($action) {\r\n      'next'    { Aw($s.TrySkipNextAsync()) ([bool]) | Out-Null }\r\n      'prev'    { Aw($s.TrySkipPreviousAsync()) ([bool]) | Out-Null }\r\n      'toggle'  { Aw($s.TryTogglePlayPauseAsync()) ([bool]) | Out-Null }\r\n      'repeat'  { try { $pb2 = $s.GetPlaybackInfo(); $cur = $pb2.AutoRepeatMode; $next = if($cur -eq [Windows.Media.MediaPlaybackAutoRepeatMode]::None){'Track'} elseif($cur -eq [Windows.Media.MediaPlaybackAutoRepeatMode]::Track){'List'} else{'None'}; Aw($s.TryChangeAutoRepeatModeAsync([Windows.Media.MediaPlaybackAutoRepeatMode]::$next)) ([bool]) | Out-Null } catch {} }\r\n    }\r\n  }\r\n} catch {}\r\n");
            }
            finally {
                ((Writer)fileWriter).close();
            }
        }
        catch (Exception exception) {
            this.a = null;
            this.b = null;
        }
    }

    private void method_12() {
        if (this.a == null || !this.a.exists()) {
            this.o();
        }
        if (this.a == null) {
            this.k = true;
            return;
        }
        if (!this.a.compareAndSet(false, true)) {
            return;
        }
        try {
            String[] stringArray;
            long l = System.currentTimeMillis();
            Object object = new ProcessBuilder("powershell", "-NoProfile", "-NonInteractive", "-ExecutionPolicy", "Bypass", "-File", this.a.getAbsolutePath()).redirectErrorStream(true).start();
            boolean bl = ((Process)object).waitFor(5L, TimeUnit.SECONDS);
            if (!bl) {
                ((Process)object).destroyForcibly();
            }
            String string = null;
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(((Process)object).getInputStream(), StandardCharsets.UTF_8));){
                String string2;
                while ((string2 = bufferedReader.readLine()) != null) {
                    if (!(string2 = string2.trim()).contains("|||")) continue;
                    string = string2;
                    break;
                }
            }
            long l2 = System.currentTimeMillis();
            long l3 = (l + l2) / 2L;
            if (string != null && (stringArray = string.split("\\|\\|\\|", -1)).length >= 2 && !stringArray[1].trim().isEmpty()) {
                String string3 = stringArray[1].trim();
                object = stringArray[0].trim();
                long l4 = stringArray.length > 2 ? SpotifyHud.a((String)stringArray[2]) : 0L;
                long l5 = stringArray.length > 3 ? SpotifyHud.a((String)stringArray[3]) : 0L;
                boolean bl2 = stringArray.length > 4 && stringArray[4].trim().equalsIgnoreCase("True");
                boolean bl3 = !string3.equals(this.f);
                boolean bl4 = bl2 != this.h;
                long l6 = this.h ? this.e + Math.max(0L, l3 - this.f) : this.e;
                boolean bl5 = Math.abs(l4 - l6) > 4000L;
                this.f = string3;
                this.g = object;
                this.g = l5;
                this.h = bl2;
                if (bl3 || bl4 || bl5 || this.f == 0L) {
                    this.e = l4;
                    this.f = l3;
                }
                if (bl3) {
                    SpotifyQueueHud.onSongChanged((String)object, string3);
                }
                return;
            }
        }
        catch (Exception exception) {
        }
        finally {
            this.k = true;
            this.a.set(false);
        }
    }

    private static long method_13(String string) {
        try {
            return Long.parseLong(string.trim());
        }
        catch (Exception exception) {
            return 0L;
        }
    }

    private static float method_14(String string) {
        if (string == null) {
            return 0.0f;
        }
        return (float)(string.hashCode() % 1000) / 1000.0f;
    }

    public static void method_15(String string) {
        if (a == null || SpotifyHud.a.a == null || SpotifyHud.a.b == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if ("repeat".equals(string)) {
            boolean bl = SpotifyHud.a.i = !SpotifyHud.a.i;
        }
        if ("toggle".equals(string)) {
            if (SpotifyHud.a.h) {
                SpotifyHud.a.e += Math.max(0L, l - SpotifyHud.a.f);
                SpotifyHud.a.f = l;
                SpotifyHud.a.h = false;
            } else {
                SpotifyHud.a.f = l;
                SpotifyHud.a.h = true;
            }
        }
        SpotifyHud.a.a.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, n(java.lang.String ), ()V)((String)string));
    }

    private void method_16() {
        if (this.c == null || !this.c.exists() || this.c.length() < 200L) {
            return;
        }
        long l = this.c.lastModified();
        if (l == this.h && this.a != null) {
            return;
        }
        try {
            Object object = Files.readAllBytes(this.c.toPath());
            object = new ByteArrayInputStream((byte[])object);
            try {
                class_1011 class_10112 = class_1011.method_4309((InputStream)object);
                if (this.a != null) {
                    try {
                        class_310.method_1551().method_1531().method_4615(a);
                    }
                    catch (Exception exception) {}
                }
                this.a = new class_1043((Supplier<String>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, d(), ()Ljava/lang/String;)(), class_10112);
                class_310.method_1551().method_1531().method_4616(a, (class_1044)this.a);
                this.h = l;
                this.j = true;
            }
            finally {
                ((InputStream)object).close();
            }
        }
        catch (Exception exception) {}
    }

    public static void method_17(class_332 class_3322) {
        long l;
        int n;
        if (a == null || !a.isEnabled()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1724 == null) {
            return;
        }
        if (class_3102.field_1755 instanceof ClickGuiScreen) {
            return;
        }
        if (class_3102.method_53526().method_53536()) {
            return;
        }
        long l2 = System.nanoTime();
        float f = SpotifyHud.a.i == 0L ? 0.016f : Math.min(0.1f, (float)(l2 - SpotifyHud.a.i) / 1.0E9f);
        SpotifyHud.a.i = l2;
        SpotifyHud.a.a += (1.0f - SpotifyHud.a.a) * (1.0f - (float)Math.exp(-12.0f * f));
        f = SpotifyHud.a.a;
        if (f < 0.01f) {
            return;
        }
        a.q();
        if (SpotifyHud.a.k && SpotifyHud.a.f.isEmpty()) {
            return;
        }
        if (!Objects.equals(SpotifyHud.a.h, SpotifyHud.a.f)) {
            SpotifyHud.a.b = SpotifyHud.a((String)SpotifyHud.a.f);
            SpotifyHud.a.h = SpotifyHud.a.f;
        }
        int n2 = SpotifyHud.a();
        int n3 = SpotifyHud.b();
        int n4 = SpotifyHud.b((int)52);
        int n5 = SpotifyHud.b((int)10);
        int n6 = SpotifyHud.c();
        int n7 = SpotifyHud.d();
        WaterFontRenderer waterFontRenderer = WaterFontRenderer.INSTANCE;
        int n8 = WaterPlus.getAccentARGB();
        float f2 = WaterPlus.getEffectiveRoundness();
        float f3 = WaterPlus.getGlassIntensity();
        float f4 = WaterPlus.getAccentGlow();
        int n9 = SpotifyHud.multiplyAlpha(WaterPlus.getBackgroundARGB(), f);
        for (n = 4; n >= 1; --n) {
            GuiRenderer.a((class_332)class_3322, (float)(n6 - n), (float)(n7 - n + 2), (float)(n2 + n * 2), (float)(n3 + n * 2), (float)(f2 + (float)n), (int)((int)((float)(10 - n * 2) * f) << 24), (boolean)false);
        }
        if (f4 > 0.01f) {
            GuiRenderer.a((class_332)class_3322, (float)(n6 - 3), (float)(n7 - 3), (float)(n2 + 6), (float)(n3 + 6), (float)(f2 + 3.0f), (int)SpotifyHud.col(n8 & 0xFFFFFF, (int)(22.0f * f4 * f)), (boolean)false);
        }
        if (WaterPlus.menuBlurEnabled()) {
            Blur2DRenderer.bm();
            GuiRenderer.a((class_332)class_3322, (float)n6, (float)n7, (float)n2, (float)n3, (float)f2, (float)1.0f, (boolean)false);
        }
        GuiRenderer.a((class_332)class_3322, (float)n6, (float)n7, (float)n2, (float)n3, (float)f2, (int)n9, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n6 + 1), (float)(n7 + 1), (float)(n2 - 2), (float)SpotifyHud.b((int)18), (float)f2, (int)SpotifyHud.col(0xFFFFFF, (int)(16.0f * f3 * f)), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n6, (float)(n7 + n3 - SpotifyHud.b((int)14)), (float)n2, (float)SpotifyHud.b((int)14), (float)f2, (int)SpotifyHud.col(n8 & 0xFFFFFF, (int)(8.0f * f3 * f)), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n6, (float)n7, (float)n2, (float)n3, (float)f2, (float)1.0f, (int)SpotifyHud.col(0xFFFFFF, (int)((22.0f + 30.0f * f3) * f)), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n6 + 1), (float)(n7 + 1), (float)(n2 - 2), (float)(n3 - 2), (float)Math.max(0.0f, f2 - 1.0f), (float)0.5f, (int)SpotifyHud.col(0, (int)(28.0f * f)), (boolean)false);
        n = SpotifyHud.b((int)16);
        int n10 = n6 + n2 - n - SpotifyHud.b((int)5);
        int n11 = n7 + SpotifyHud.b((int)4);
        SpotifyHud.a((class_332)class_3322, (int)n10, (int)n11, (int)n, (float)f);
        n10 = n6 + n5;
        n11 = n7 + (n3 - n4) / 2;
        if (SpotifyHud.a.j) {
            int n12 = Math.max(0, Math.min(255, (int)(255.0f * f))) << 24 | 0xFFFFFF;
            GuiRenderer.a((class_332)class_3322, (float)n10, (float)n11, (float)n4, (class_2960)a, (int)n12, (float)SpotifyHud.a((float)4.0f), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n10, (float)n11, (float)n4, (float)n4, (float)SpotifyHud.a((float)4.0f), (float)1.0f, (int)SpotifyHud.col(0xFFFFFF, (int)(55.0f * f)), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)(n10 - 1), (float)(n11 - 1), (float)(n4 + 2), (float)(n4 + 2), (float)SpotifyHud.a((float)5.0f), (float)0.5f, (int)SpotifyHud.col(n8 & 0xFFFFFF, (int)(35.0f * f)), (boolean)false);
        } else {
            GuiRenderer.a((class_332)class_3322, (float)n10, (float)n11, (float)n4, (float)n4, (float)SpotifyHud.a((float)4.0f), (int)SpotifyHud.col(0xFFFFFF, (int)(8.0f * f)), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n10, (float)n11, (float)n4, (float)n4, (float)SpotifyHud.a((float)4.0f), (float)1.0f, (int)SpotifyHud.col(0xFFFFFF, (int)(35.0f * f)), (boolean)false);
            String string = "\u266b";
            n9 = waterFontRenderer.a(string);
            waterFontRenderer.a(class_3322, string, n10 + (n4 - n9) / 2, n11 + (n4 - 9) / 2, SpotifyHud.col(n8 & 0xFFFFFF, (int)(180.0f * f)));
        }
        int n13 = n10 + n4 + n5;
        n9 = n2 - (n13 - n6) - n5 - SpotifyHud.b((int)4);
        long l3 = System.currentTimeMillis();
        if (SpotifyHud.a.h && SpotifyHud.a.f > 0L) {
            long l4 = Math.max(0L, l3 - SpotifyHud.a.f);
            l = SpotifyHud.a.e + l4;
            if (SpotifyHud.a.g > 0L) {
                l = Math.min(SpotifyHud.a.g, l);
            }
        } else {
            l = SpotifyHud.a.e;
        }
        float f5 = SpotifyHud.a.g > 0L ? Math.min(1.0f, (float)l / (float)SpotifyHud.a.g) : 0.0f;
        int n14 = SpotifyHud.b((int)3);
        n2 = SpotifyHud.b((int)9) + SpotifyHud.b((int)3) + SpotifyHud.b((int)8) + SpotifyHud.b((int)4) + n14 + SpotifyHud.b((int)4);
        n2 = n7 + (n3 - n2) / 2 + SpotifyHud.b((int)5);
        String string = !SpotifyHud.a.k ? "" : (SpotifyHud.a.f.isEmpty() ? "No track playing" : SpotifyHud.a.f);
        waterFontRenderer.a(class_3322, SpotifyHud.a((String)string, (int)n9, (WaterFontRenderer)waterFontRenderer), n13, n2, SpotifyHud.col(0xFFFFFF, (int)(255.0f * f)));
        waterFontRenderer.a(class_3322, SpotifyHud.a((String)SpotifyHud.a.g, (int)n9, (WaterFontRenderer)waterFontRenderer), n13, n2 += SpotifyHud.b((int)11), SpotifyHud.col(0xAAAAAA, (int)(200.0f * f)));
        int n15 = n9;
        n4 = Math.max(0, Math.round((float)n15 * f5));
        GuiRenderer.a((class_332)class_3322, (float)n13, (float)(n2 += SpotifyHud.b((int)11)), (float)n15, (float)n14, (float)((float)n14 / 2.0f), (int)SpotifyHud.col(0xFFFFFF, (int)(28.0f * f)), (boolean)false);
        if (n4 > 0) {
            GuiRenderer.a((class_332)class_3322, (float)n13, (float)n2, (float)n4, (float)n14, (float)((float)n14 / 2.0f), (int)SpotifyHud.col(n8 & 0xFFFFFF, (int)(230.0f * f)), (boolean)false);
        }
        if (n4 > 0) {
            n5 = SpotifyHud.b((int)5);
            GuiRenderer.a((class_332)class_3322, (float)(n13 + n4 - n5 / 2), (float)(n2 - (n5 - n14) / 2), (float)n5, (float)n5, (float)((float)n5 / 2.0f), (int)SpotifyHud.col(0xFFFFFF, (int)(235.0f * f)), (boolean)false);
        }
        String string2 = SpotifyHud.a((long)l);
        String string3 = SpotifyHud.a.g > 0L ? SpotifyHud.a((long)SpotifyHud.a.g) : "--:--";
        n2 = n2 + n14 + SpotifyHud.b((int)2);
        waterFontRenderer.a(class_3322, string2, n13, n2, SpotifyHud.col(0x888888, (int)(155.0f * f)));
        waterFontRenderer.a(class_3322, string3, n13 + n15 - waterFontRenderer.a(string3), n2, SpotifyHud.col(0x888888, (int)(155.0f * f)));
    }

    private static void method_18(class_332 class_3322, int n, int n2, int n3, float f) {
        if (n3 >= 0) {
            int n4 = Math.max(0, Math.min(255, (int)(f * 255.0f))) << 24 | 0xFFFFFF;
            GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n3, (class_2960)b, (int)n4, (float)0.0f, (boolean)false);
            return;
        }
        int n5 = (int)(f * 255.0f);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n3, (float)n3, (float)((float)n3 / 2.0f), (int)SpotifyHud.col(1947988, n5), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n3, (float)n3, (float)((float)n3 / 2.0f), (float)0.8f, (int)SpotifyHud.col(0xFFFFFF, (int)(50.0f * f)), (boolean)false);
        f = (float)n3 * 0.18f;
        float f2 = (float)n3 * 0.09f;
        float f3 = (float)n3 * 0.115f;
        float f4 = f2 / 2.0f;
        n5 = SpotifyHud.col(0xFFFFFF, n5);
        float f5 = (float)n + f * 0.7f;
        float f6 = (float)n2 + (float)n3 * 0.3f;
        float f7 = (float)n3 - f * 1.4f;
        float f8 = (float)n + f * 1.1f;
        float f9 = f6 + f2 + f3;
        float f10 = (float)n3 - f * 2.2f;
        float f11 = (float)n + f * 1.55f;
        f3 = f9 + f2 + f3;
        float f12 = (float)n3 - f * 3.1f;
        GuiRenderer.a((class_332)class_3322, (float)((int)f5), (float)((int)f6), (float)((int)f7), (float)((int)f2), (float)f4, (int)n5, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)((int)f8), (float)((int)f9), (float)((int)f10), (float)((int)f2), (float)f4, (int)n5, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)((int)f11), (float)((int)f3), (float)((int)f12), (float)((int)f2), (float)f4, (int)n5, (boolean)false);
    }

    private static String method_19(String object, int n, WaterFontRenderer waterFontRenderer) {
        if (object == null || ((String)object).isEmpty()) {
            return "";
        }
        if (waterFontRenderer.a((String)object) <= n) {
            return object;
        }
        String string = "...";
        int n2 = waterFontRenderer.a(string);
        if (n2 >= n) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object2 : (Object)((String)object).codePoints().toArray()) {
            String string2 = stringBuilder.toString() + new String(Character.toChars((int)object2));
            if (waterFontRenderer.a(string2 + string) > n) break;
            stringBuilder.appendCodePoint((int)object2);
        }
        return stringBuilder.toString() + string;
    }

    private static String method_20(long l) {
        long l2 = l / 1000L;
        return l2 / 60L + ":" + String.format("%02d", l2 % 60L);
    }

    private static int col(int n, int n2) {
        return Math.max(0, Math.min(255, n2)) << 24 | n & 0xFFFFFF;
    }

    private static int multiplyAlpha(int n, float f) {
        int n2 = n >>> 24 & 0xFF;
        int n3 = Math.max(0, Math.min(255, Math.round((float)n2 * f)));
        return n & 0xFFFFFF | n3 << 24;
    }

    private static /* synthetic */ String method_21() {
        return "spotify_art";
    }

    private static /* synthetic */ void method_22(String object) {
        try {
            object = new ProcessBuilder(new String[]{"powershell", "-NoProfile", "-NonInteractive", "-ExecutionPolicy", "Bypass", "-File", SpotifyHud.a.b.getAbsolutePath(), "-action", object}).redirectErrorStream(true).start();
            ((Process)object).waitFor(5L, TimeUnit.SECONDS);
            if (SpotifyHud.a.a != null && !SpotifyHud.a.a.isShutdown()) {
                SpotifyHud.a.a.submit((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, p(), ()V)((SpotifyHud)a));
            }
        }
        catch (Exception exception) {}
    }

    private /* synthetic */ void method_23() {
        int n = this.a.getAndIncrement();
        if (n >= 10) {
            return;
        }
        this.p();
        if (!this.f.isEmpty()) {
            this.a.set(Integer.MAX_VALUE);
        }
    }

    private static /* synthetic */ Thread method_24(Runnable runnable) {
        runnable = new Thread(runnable, "water-spotify-ctrl");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    private static /* synthetic */ Thread method_25(Runnable runnable) {
        runnable = new Thread(runnable, "water-spotify");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    static {
        a = class_2960.method_60655((String)"water", (String)"spotify_art");
        b = class_2960.method_60655((String)"water", (String)"textures/gui/spotify_logo.png");
    }
}

