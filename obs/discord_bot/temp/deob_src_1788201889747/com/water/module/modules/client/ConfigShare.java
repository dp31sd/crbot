/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.client;

import com.water.gui.ConfigManagerScreen;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.ModuleManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.invoke.LambdaMetafactory;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.minecraft.class_310;
import net.minecraft.class_437;

public final class ConfigShare
extends Module {
    private static ConfigShare field_0;
    public volatile String field_1;
    public volatile String field_2;
    public volatile boolean field_3;
    public volatile boolean field_4;

    public ConfigShare() {
        super("Config Share", Category.e);
        this.c = "";
        this.d = "";
        this.e = false;
        this.f = false;
        a = this;
    }

    @Override
    public void onEnable() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null) {
            class_3102.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, d(net.minecraft.class_310 ), ()V)((ConfigShare)this, (class_310)class_3102));
        }
    }

    public static ConfigShare method_0() {
        return a;
    }

    public void method_1(Runnable runnable) {
        this.e = true;
        this.c = "";
        this.d = "";
        new Thread((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, b(java.lang.Runnable ), ()V)((ConfigShare)this, (Runnable)runnable), "water-config-export").start();
    }

    public void method_2(String string, Runnable runnable) {
        this.f = true;
        this.d = "";
        new Thread((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, b(java.lang.String java.lang.Runnable ), ()V)((ConfigShare)this, (String)string, (Runnable)runnable), "water-config-import").start();
    }

    private String method_3() {
        ModuleManager.INSTANCE.f();
        try {
            Path path = ModuleManager.INSTANCE.a();
            if (path != null && Files.isRegularFile(path, new LinkOption[0])) {
                return Files.readString(path, StandardCharsets.UTF_8);
            }
        }
        catch (IOException iOException) {}
        return "";
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void method_4(String string) {
        Path path;
        Map<String, Boolean> map;
        block13: {
            if (string == null || string.isBlank()) {
                return;
            }
            map = this.snapshotEnabled();
            path = null;
            Path path2 = ModuleManager.INSTANCE.a();
            path = path2.resolveSibling(path2.getFileName().toString() + ".import");
            Files.writeString(path, (CharSequence)string, StandardCharsets.UTF_8, new OpenOption[0]);
            if (ModuleManager.INSTANCE.a(path)) break block13;
            if (path == null) return;
            try {
                Files.deleteIfExists(path);
                return;
            }
            catch (IOException iOException) {}
            return;
        }
        this.syncModuleLifecycle(map, this.snapshotEnabled());
        if (path == null) return;
        try {
            Files.deleteIfExists(path);
            return;
        }
        catch (IOException iOException) {}
        return;
        catch (IOException iOException) {
            if (path == null) return;
            try {
                Files.deleteIfExists(path);
                return;
            }
            catch (IOException iOException2) {}
            return;
        }
        catch (Throwable throwable) {
            if (path == null) throw throwable;
            try {
                Files.deleteIfExists(path);
                throw throwable;
            }
            catch (IOException iOException) {}
            throw throwable;
        }
    }

    private Map<String, Boolean> snapshotEnabled() {
        HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
        for (Module module : ModuleManager.INSTANCE.getModules()) {
            hashMap.put(module.getName(), module.isEnabled());
        }
        return hashMap;
    }

    private void syncModuleLifecycle(Map<String, Boolean> map, Map<String, Boolean> map2) {
        for (Module module : ModuleManager.INSTANCE.getModules()) {
            boolean bl;
            boolean bl2 = map.getOrDefault(module.getName(), false);
            if (bl2 == (bl = map2.getOrDefault(module.getName(), false).booleanValue())) continue;
            try {
                if (bl) {
                    module.onEnable();
                    continue;
                }
                module.onDisable();
            }
            catch (Throwable throwable) {}
        }
    }

    private /* synthetic */ void method_5(String object, Runnable runnable) {
        try {
            object = ((String)object).trim().replaceAll("\\s+", "");
            if (((String)object).isEmpty()) {
                this.d = "Enter a code first!";
                return;
            }
            object = (HttpURLConnection)new URI("https://dpaste.com/" + (String)object + ".txt").toURL().openConnection();
            ((URLConnection)object).setConnectTimeout(6000);
            ((URLConnection)object).setReadTimeout(6000);
            Object object2 = new String(((URLConnection)object).getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();
            ((HttpURLConnection)object).disconnect();
            try {
                object = Base64.getUrlDecoder().decode((String)object2);
            }
            catch (Exception exception) {
                try {
                    object = Base64.getDecoder().decode((String)object2);
                }
                catch (Exception exception2) {
                    this.d = "Invalid code!";
                    this.f = false;
                    object = class_310.method_1551();
                    if (runnable != null && object != null) {
                        object.execute(runnable);
                    }
                    return;
                }
            }
            try {
                object2 = new GZIPInputStream(new ByteArrayInputStream((byte[])object));
                try {
                    object = new String(((InputStream)object2).readAllBytes(), StandardCharsets.UTF_8);
                }
                finally {
                    ((GZIPInputStream)object2).close();
                }
            }
            catch (Exception exception) {
                this.d = "Invalid code!";
                this.f = false;
                object = class_310.method_1551();
                if (runnable != null && object != null) {
                    object.execute(runnable);
                }
                return;
            }
            this.i((String)object);
            ModuleManager.INSTANCE.f();
        }
        catch (Exception exception) {
            this.d = "Load error: " + exception.getMessage();
        }
        finally {
            this.f = false;
            class_310 class_3102 = class_310.method_1551();
            if (runnable != null && class_3102 != null) {
                class_3102.execute(runnable);
            }
        }
    }

    private /* synthetic */ void method_6(Runnable runnable) {
        try {
            Object object = this.b();
            Object object2 = new ByteArrayOutputStream();
            try (Object object3 = new GZIPOutputStream((OutputStream)object2);){
                ((FilterOutputStream)object3).write(((String)object).getBytes(StandardCharsets.UTF_8));
            }
            object3 = Base64.getUrlEncoder().withoutPadding().encodeToString(((ByteArrayOutputStream)object2).toByteArray());
            object = (HttpURLConnection)new URI("https://dpaste.com/api/v2/").toURL().openConnection();
            ((HttpURLConnection)object).setRequestMethod("POST");
            ((URLConnection)object).setDoOutput(true);
            ((URLConnection)object).setConnectTimeout(6000);
            ((URLConnection)object).setReadTimeout(6000);
            ((URLConnection)object).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            object2 = "content=" + URLEncoder.encode((String)object3, StandardCharsets.UTF_8) + "&syntax=text&expiry_days=365";
            object3 = ((URLConnection)object).getOutputStream();
            try {
                ((OutputStream)object3).write(((String)object2).getBytes(StandardCharsets.UTF_8));
            }
            finally {
                if (object3 != null) {
                    ((OutputStream)object3).close();
                }
            }
            object3 = new String(((URLConnection)object).getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();
            ((HttpURLConnection)object).disconnect();
            this.c = object = ((String)object3).replaceAll("https?://dpaste\\.com/", "").replace("/", "").trim();
            object2 = class_310.method_1551();
            if (object2 != null) {
                object2.execute((Runnable)LambdaMetafactory.metafactory(null, null, null, ()V, a(net.minecraft.class_310 java.lang.String ), ()V)((class_310)object2, (String)object));
            }
        }
        catch (Exception exception) {
            this.d = "Upload failed: " + exception.getMessage();
        }
        finally {
            this.e = false;
            class_310 class_3102 = class_310.method_1551();
            if (runnable != null && class_3102 != null) {
                class_3102.execute(runnable);
            }
        }
    }

    private static /* synthetic */ void method_7(class_310 class_3102, String string) {
        class_3102.field_1774.method_1455(string);
    }

    private /* synthetic */ void method_8(class_310 class_3102) {
        class_3102.method_1507((class_437)new ConfigManagerScreen());
        this.setEnabled(false);
    }
}

