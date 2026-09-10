/*
 * Decompiled with CFR 0.152.
 */
package com.water.gui.hud;

import com.water.module.modules.client.SpotifyHud;
import com.water.module.modules.client.WaterPlus;
import com.water.utils.renderer.GuiRenderer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;

public final class SpotifyQueueHud {
    public static int posX = 10;
    public static int posY = 200;
    public static boolean visible = true;
    private static boolean dragging = false;
    private static double dragOffX = 0.0;
    private static double dragOffY = 0.0;
    private static final int field_0 = 220;
    private static final int HEAD_H = 18;
    private static final int ROW_H = 13;
    private static final int MAX_ROWS = 12;
    private static final int PAD = 5;
    private static final int MAX_KNOWN = 300;
    private static final List<String[]> ALL_KNOWN = new ArrayList<String[]>();
    private static volatile String currentTitle = "";
    private static volatile String currentArtist = "";
    private static volatile int currentIdx = 0;
    private static int scroll = 0;
    private static final ExecutorService exec = Executors.newSingleThreadExecutor(runnable -> {
        runnable = new Thread(runnable, "spotify-queue");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    });
    private static final AtomicBoolean historyLoaded = new AtomicBoolean(false);
    private static volatile long lastClickMs = 0L;
    private static final long CLICK_DEBOUNCE_MS = 500L;

    private static void ensureLoaded() {
        if (historyLoaded.compareAndSet(false, true)) {
            SpotifyQueueHud.loadFromDisk();
        }
    }

    public static void onSongChanged(String string, String string2) {
        SpotifyQueueHud.ensureLoaded();
        if (string2 == null || string2.isEmpty()) {
            return;
        }
        if (string2.equals(currentTitle) && string.equals(currentArtist)) {
            return;
        }
        currentTitle = string2;
        currentArtist = string;
        List<String[]> list = ALL_KNOWN;
        synchronized (list) {
            int n;
            boolean bl = false;
            for (n = 0; n < ALL_KNOWN.size(); ++n) {
                if (!ALL_KNOWN.get(n)[1].equals(string2) || !ALL_KNOWN.get(n)[0].equals(string)) continue;
                currentIdx = n;
                bl = true;
                break;
            }
            if (!bl) {
                ALL_KNOWN.add(new String[]{string, string2});
                currentIdx = ALL_KNOWN.size() - 1;
                if (ALL_KNOWN.size() > 300) {
                    n = ALL_KNOWN.size() - 300;
                    for (int i = 0; i < n; ++i) {
                        ALL_KNOWN.remove(0);
                    }
                    currentIdx = Math.max(0, currentIdx - n);
                    scroll = Math.max(0, scroll - n);
                }
                exec.submit(SpotifyQueueHud::saveToDisk);
            }
        }
        SpotifyQueueHud.scrollToCurrent();
    }

    private static void scrollToCurrent() {
        if (currentIdx < scroll) {
            scroll = Math.max(0, currentIdx);
        } else if (currentIdx >= scroll + 12) {
            scroll = currentIdx - 12 + 1;
        }
    }

    private static int maxScroll() {
        List<String[]> list = ALL_KNOWN;
        synchronized (list) {
            return Math.max(0, ALL_KNOWN.size() - 12);
        }
    }

    public static void render(class_332 class_3322, double d2, double d3) {
        ArrayList<String[]> arrayList;
        if (!visible) {
            return;
        }
        SpotifyQueueHud.ensureLoaded();
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return;
        }
        class_3102 = class_3102.field_1772;
        int n = WaterPlus.getAccentARGB();
        n &= 0xFFFFFF;
        List<String[]> list = ALL_KNOWN;
        synchronized (list) {
            arrayList = new ArrayList<String[]>(ALL_KNOWN);
        }
        int n2 = Math.max(1, Math.min(12, arrayList.size()));
        int n3 = 18 + n2 * 13 + 2;
        GuiRenderer.a((class_332)class_3322, (float)posX, (float)posY, (float)220.0f, (float)n3, (float)8.0f, (int)-871556572, (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)posX, (float)posY, (float)220.0f, (float)n3, (float)8.0f, (float)1.0f, (int)(0x40000000 | n), (boolean)false);
        class_3322.method_25294(posX + 1, posY + 1, posX + 220 - 1, posY + 2, 0x15FFFFFF);
        class_3322.method_25294(posX, posY, posX + 220, posY + 18, 0x22FFFFFF);
        class_3322.method_25294(posX, posY + 3, posX + 3, posY + 18 - 3, 0xFF000000 | n);
        String string = "QUEUE  " + (arrayList.isEmpty() ? "play a song" : arrayList.size() + " songs");
        class_3322.method_51433((class_327)class_3102, string, posX + 5 + 5, posY + 9 - 4, -1117449, false);
        if (arrayList.isEmpty()) {
            class_3322.method_51433((class_327)class_3102, "Play a song to start", posX + 5, posY + 18 + 4, 0x55FFFFFF, false);
        } else {
            int n4;
            int n5;
            int n6 = Math.min(scroll + 12, arrayList.size());
            for (n5 = scroll; n5 < n6; ++n5) {
                boolean bl;
                Object object = (String[])arrayList.get(n5);
                n4 = posY + 18 + (n5 - scroll) * 13;
                boolean bl2 = object[1].equals(currentTitle) && object[0].equals(currentArtist);
                int n7 = d2 >= (double)posX && d2 < (double)(posX + 220) && d3 >= (double)n4 && d3 < (double)(n4 + 13) ? 1 : 0;
                boolean bl3 = bl = n5 < currentIdx;
                if (bl2) {
                    class_3322.method_25294(posX, n4, posX + 220, n4 + 13, 0x25000000 | n);
                    class_3322.method_25294(posX, n4, posX + 3, n4 + 13, 0xFF000000 | n);
                } else if (n7 != 0) {
                    class_3322.method_25294(posX, n4, posX + 220, n4 + 13, 0x15FFFFFF);
                }
                n7 = bl2 ? 0xFF000000 | n : (bl ? -10456960 : -5588020);
                object = (object[0].isEmpty() ? "" : object[0] + " - ") + object[1];
                object = class_3102.method_27523((String)object, 210 - (bl2 ? 6 : 2));
                class_3322.method_51433((class_327)class_3102, (String)object, posX + 5 + (bl2 ? 5 : 2), n4 + 6 - 4, n7, false);
            }
            if (arrayList.size() > 12) {
                n5 = posX + 220 - 3;
                int n8 = posY + 18;
                n4 = n2 * 13;
                float f = Math.max(16.0f, (float)n4 * (12.0f / (float)arrayList.size()));
                float f2 = (float)n8 + ((float)n4 - f) * ((float)scroll / (float)Math.max(1, SpotifyQueueHud.maxScroll()));
                class_3322.method_25294(n5, n8, n5 + 3, n8 + n4, 0x15FFFFFF);
                class_3322.method_25294(n5, (int)f2, n5 + 3, (int)(f2 + f), Integer.MIN_VALUE | n);
            }
        }
    }

    public static boolean onMouseClick(double d2, double d3, int n) {
        int n2;
        ArrayList<String[]> arrayList;
        if (!visible) {
            return false;
        }
        List<String[]> list = ALL_KNOWN;
        synchronized (list) {
            arrayList = new ArrayList<String[]>(ALL_KNOWN);
        }
        int n3 = Math.max(1, Math.min(12, arrayList.size()));
        int n4 = 18 + n3 * 13 + 2;
        if (d2 < (double)posX || d2 > (double)(posX + 220) || d3 < (double)posY || d3 > (double)(posY + n4)) {
            return false;
        }
        if (d3 < (double)(posY + 18)) {
            if (n == 0) {
                dragging = true;
                dragOffX = d2 - (double)posX;
                dragOffY = d3 - (double)posY;
            }
            return true;
        }
        if (n == 0 && d3 < (double)(posY + 18 + n3 * 13) && (n2 = ((int)d3 - posY - 18) / 13 + scroll) >= 0 && n2 < arrayList.size()) {
            SpotifyQueueHud.skipTo(((String[])arrayList.get(n2))[0], ((String[])arrayList.get(n2))[1], n2);
            return true;
        }
        return true;
    }

    public static boolean onMouseDrag(double d2, double d3) {
        if (!dragging) {
            return false;
        }
        posX = (int)(d2 - dragOffX);
        posY = (int)(d3 - dragOffY);
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null) {
            posX = Math.max(0, Math.min(class_3102.method_22683().method_4486() - 220, posX));
            posY = Math.max(0, Math.min(class_3102.method_22683().method_4502() - 50, posY));
        }
        return true;
    }

    public static void onMouseRelease() {
        dragging = false;
    }

    public static boolean isDragging() {
        return dragging;
    }

    public static boolean onScroll(double d2, double d3, double d4) {
        ArrayList<String[]> arrayList;
        if (!visible) {
            return false;
        }
        List<String[]> list = ALL_KNOWN;
        synchronized (list) {
            arrayList = new ArrayList<String[]>(ALL_KNOWN);
        }
        int n = Math.max(1, Math.min(12, arrayList.size()));
        int n2 = 18 + n * 13 + 2;
        if (d2 < (double)posX || d2 > (double)(posX + 220) || d3 < (double)posY || d3 > (double)(posY + n2)) {
            return false;
        }
        scroll = Math.max(0, Math.min(SpotifyQueueHud.maxScroll(), scroll + (d4 > 0.0 ? -1 : 1)));
        return true;
    }

    private static void skipTo(String string, String string2, int n) {
        if (string2.equals(currentTitle) && string.equals(currentArtist)) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - lastClickMs < 500L) {
            return;
        }
        lastClickMs = l;
        int n2 = n - currentIdx;
        if (n2 == 0) {
            return;
        }
        SpotifyHud.m((String)(n2 > 0 ? "next" : "prev"));
    }

    private static Path queueFile() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1697 == null) {
            return null;
        }
        return class_3102.field_1697.toPath().resolve("water_spotify_history.txt");
    }

    private static void loadFromDisk() {
        try {
            Object object = SpotifyQueueHud.queueFile();
            if (object == null || !Files.isRegularFile((Path)object, new LinkOption[0])) {
                return;
            }
            object = Files.readAllLines((Path)object, StandardCharsets.UTF_8);
            List<String[]> list = ALL_KNOWN;
            synchronized (list) {
                ALL_KNOWN.clear();
                object = object.iterator();
                while (object.hasNext()) {
                    int n;
                    String string = (String)object.next();
                    if (string == null || string.isBlank() || (n = string.indexOf(9)) < 0) continue;
                    String string2 = string.substring(0, n);
                    if ((string = string.substring(n + 1)).isEmpty()) continue;
                    ALL_KNOWN.add(new String[]{string2, string});
                }
                if (ALL_KNOWN.size() > 300) {
                    int n = ALL_KNOWN.size() - 300;
                    for (int i = 0; i < n; ++i) {
                        ALL_KNOWN.remove(0);
                    }
                }
            }
        }
        catch (Exception exception) {}
    }

    private static void saveToDisk() {
        try {
            ArrayList<String[]> object2;
            Path path = SpotifyQueueHud.queueFile();
            if (path == null) {
                return;
            }
            Object object = ALL_KNOWN;
            synchronized (object) {
                object2 = new ArrayList<String[]>(ALL_KNOWN);
            }
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            object = Files.newBufferedWriter(path, StandardCharsets.UTF_8, new OpenOption[0]);
            try {
                for (String[] stringArray : object2) {
                    String string = SpotifyQueueHud.clean(stringArray[0]);
                    String string2 = SpotifyQueueHud.clean(stringArray[1]);
                    ((Writer)object).write(string);
                    ((BufferedWriter)object).write(9);
                    ((Writer)object).write(string2);
                    ((BufferedWriter)object).newLine();
                }
            }
            finally {
                if (object != null) {
                    ((BufferedWriter)object).close();
                }
            }
        }
        catch (IOException iOException) {}
    }

    private static String clean(String string) {
        if (string == null) {
            return "";
        }
        return string.replace('\t', ' ').replace('\n', ' ').replace('\r', ' ');
    }
}

