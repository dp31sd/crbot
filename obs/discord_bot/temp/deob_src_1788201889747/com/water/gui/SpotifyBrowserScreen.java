/*
 * Decompiled with CFR 0.152.
 */
package com.water.gui;

import com.water.module.modules.client.WaterPlus;
import com.water.spotify.SpotifyApi;
import com.water.spotify.SpotifyAuth;
import com.water.utils.renderer.GuiRenderer;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.minecraft.class_11905;
import net.minecraft.class_11908;
import net.minecraft.class_11909;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;

public final class SpotifyBrowserScreen
extends class_437 {
    private static final int field_0 = 420;
    private static final int field_1 = 360;
    private static final int field_2 = 10;
    private static final int PAD = 10;
    private static final int HEAD_H = 44;
    private static final int FOOT_H = 44;
    private static final int ROW_H = 22;
    private static final int SRCH_H = 24;
    private static final int TABS_H = 28;
    private final class_437 parent;
    private String search = "";
    private int scroll = 0;
    private int hoverRow = -1;
    private long openNs = 0L;
    private int tab = 0;
    private static final List<SpotifyApi.a> QUEUE_CACHE = new ArrayList<SpotifyApi.a>();
    private static final List<String[]> PLAYLISTS_CACHE = new ArrayList<String[]>();
    private static final List<SpotifyApi.a> TRACKS_CACHE = new ArrayList<SpotifyApi.a>();
    private static volatile String selectedPlaylist = null;
    private static volatile String selectedPlaylistName = "";
    private List<Object> filtered = new ArrayList<Object>();
    private volatile boolean loading = false;
    private volatile String status = "";
    private final ExecutorService exec = Executors.newSingleThreadExecutor(runnable -> {
        runnable = new Thread(runnable, "spotify-browser");
        ((Thread)runnable).setDaemon(true);
        return runnable;
    });
    private boolean enteringClientId = false;
    private String clientIdInput = "";

    public SpotifyBrowserScreen(class_437 class_4372) {
        super((class_2561)class_2561.method_43470((String)""));
        this.parent = class_4372;
    }

    private int method_0() {
        return (this.field_22789 - 420) / 2;
    }

    private int method_1() {
        return (this.field_22790 - 360) / 2;
    }

    private int listY() {
        return this.py() + 44 + 28 + 24 + 10;
    }

    private int listH() {
        return 200;
    }

    private int maxRows() {
        return this.listH() / 22;
    }

    private int maxScroll() {
        return Math.max(0, this.filtered.size() - this.maxRows());
    }

    public void method_25426() {
        String string = WaterPlus.getSpotifyClientId();
        if (string != null && !string.isBlank()) {
            SpotifyAuth.v((String)string);
        }
        if (!SpotifyAuth.ad()) {
            this.enteringClientId = true;
            this.clientIdInput = "";
            this.status = "Enter your Spotify Client ID";
            return;
        }
        if (!SpotifyAuth.ae()) {
            this.status = "Click CONNECT to login";
            return;
        }
        this.loadQueue();
    }

    private void loadQueue() {
        this.loading = true;
        this.status = "Loading queue...";
        this.exec.submit(() -> {
            List list = SpotifyApi.b();
            List<SpotifyApi.a> list2 = QUEUE_CACHE;
            synchronized (list2) {
                QUEUE_CACHE.clear();
                QUEUE_CACHE.addAll(list);
            }
            this.status = list.isEmpty() ? "Queue is empty" : list.size() + " tracks";
            this.loading = false;
            this.field_22787.execute(this::rebuild);
        });
    }

    private void loadPlaylists() {
        this.loading = true;
        this.status = "Loading playlists...";
        this.exec.submit(() -> {
            List list = SpotifyApi.c();
            List<String[]> list2 = PLAYLISTS_CACHE;
            synchronized (list2) {
                PLAYLISTS_CACHE.clear();
                PLAYLISTS_CACHE.addAll(list);
            }
            this.status = list.size() + " playlists";
            this.loading = false;
            this.field_22787.execute(this::rebuild);
        });
    }

    private void loadPlaylistTracks(String string, String string2) {
        selectedPlaylist = string;
        selectedPlaylistName = string2;
        this.loading = true;
        this.status = "Loading " + string2 + "...";
        this.tab = 2;
        this.exec.submit(() -> {
            string = SpotifyApi.b((String)string);
            List<SpotifyApi.a> list = TRACKS_CACHE;
            synchronized (list) {
                TRACKS_CACHE.clear();
                TRACKS_CACHE.addAll((Collection<SpotifyApi.a>)((Object)string));
            }
            this.status = string.size() + " tracks in " + string2;
            this.loading = false;
            this.field_22787.execute(this::rebuild);
        });
    }

    private void rebuild() {
        String string = this.search.trim().toLowerCase();
        this.filtered = new ArrayList<Object>();
        Object object = switch (this.tab) {
            case 0 -> QUEUE_CACHE;
            case 1 -> PLAYLISTS_CACHE;
            case 2 -> TRACKS_CACHE;
            default -> new ArrayList();
        };
        ArrayList arrayList = object;
        synchronized (arrayList) {
            object = object.iterator();
            while (object.hasNext()) {
                String[] stringArray;
                Object e2 = object.next();
                if (e2 instanceof SpotifyApi.a) {
                    stringArray = (SpotifyApi.a)e2;
                    v1 = stringArray.r();
                } else if (e2 instanceof String[]) {
                    stringArray = (String[])e2;
                    v1 = stringArray[1];
                } else {
                    v1 = stringArray = "";
                }
                if (!string.isEmpty() && !stringArray.toLowerCase().contains(string)) continue;
                this.filtered.add(e2);
            }
        }
        this.scroll = Math.max(0, Math.min(this.maxScroll(), this.scroll));
    }

    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        int n3;
        if (this.openNs == 0L) {
            this.openNs = System.nanoTime();
        }
        f = this.easeOut(Math.min(1.0f, (float)(System.nanoTime() - this.openNs) / 1.8E8f));
        int n4 = this.px();
        int n5 = this.py();
        int n6 = WaterPlus.getAccentARGB();
        class_3322.method_25294(0, 0, this.field_22789, this.field_22790, this.alphaScale(-2013265920, f));
        GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)420.0f, (float)360.0f, (float)10.0f, (int)this.alphaScale(-234353645, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)420.0f, (float)360.0f, (float)10.0f, (float)1.5f, (int)this.col(n6 &= 0xFFFFFF, (int)(80.0f * f)), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n4, (float)n5, (float)420.0f, (float)44.0f, (float)10.0f, (float)10.0f, (float)0.0f, (float)0.0f, (boolean)false, (int[])new int[]{this.alphaScale(-871756264, f)});
        class_3322.method_25294(n4, n5 + 44, n4 + 420, n5 + 44 + 1, this.alphaScale(0x20FFFFFF, f));
        class_3322.method_25294(n4, n5 + 10, n4 + 3, n5 + 44 - 10, this.col(n6, (int)(255.0f * f)));
        class_3322.method_51433(this.field_22793, "SPOTIFY", n4 + 10 + 8, n5 + 10, this.col(15659767, (int)(255.0f * f)), false);
        String string = this.enteringClientId ? "Enter Client ID to connect" : (!SpotifyAuth.ad() ? "Not configured" : (!SpotifyAuth.ae() ? (SpotifyAuth.af() ? "Connecting..." : "Click CONNECT") : this.status));
        class_3322.method_51433(this.field_22793, string, n4 + 10 + 8, n5 + 25, this.col(6320256, (int)(180.0f * f)), false);
        if (!SpotifyAuth.ae() && !this.enteringClientId) {
            int n7 = n4 + 420 - 10 - 80;
            n3 = n5 + 22 - 9;
            boolean bl = this.hov(n, n2, n7, n3, 80, 18);
            GuiRenderer.a((class_332)class_3322, (float)n7, (float)n3, (float)80.0f, (float)18.0f, (float)4.0f, (int)this.col(n6, bl ? (int)(50.0f * f) : (int)(20.0f * f)), (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n7, (float)n3, (float)80.0f, (float)18.0f, (float)4.0f, (float)1.0f, (int)this.col(n6, (int)(150.0f * f)), (boolean)false);
            String string2 = SpotifyAuth.ad() ? "CONNECT" : "SETUP";
            class_3322.method_51433(this.field_22793, string2, n7 + (80 - this.field_22793.method_1727(string2)) / 2, n3 + 5, this.col(n6, (int)(220.0f * f)), false);
        }
        if (this.enteringClientId) {
            this.renderClientIdSetup(class_3322, n4, n5, n, n2, f, n6);
            return;
        }
        if (!SpotifyAuth.ae()) {
            class_3322.method_51433(this.field_22793, "Click CONNECT to login with Spotify", n4 + (420 - this.field_22793.method_1727("Click CONNECT to login with Spotify")) / 2, n5 + 180 - 4, this.col(6320256, (int)(180.0f * f)), false);
            this.renderFooter(class_3322, n4, n5, n, n2, f, n6);
            return;
        }
        this.renderTabs(class_3322, n4, n5, n, n2, f, n6);
        int n8 = n5 + 44 + 28 + 4;
        n3 = n4 + 10;
        int n9 = !this.search.isEmpty() ? 1 : 0;
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n8, (float)400.0f, (float)24.0f, (float)6.0f, (int)this.alphaScale(-16183784, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)n8, (float)400.0f, (float)24.0f, (float)6.0f, (float)1.0f, (int)this.col(n9 != 0 ? n6 : 0x30FFFFFF, n9 != 0 ? (int)(120.0f * f) : (int)(50.0f * f)), (boolean)false);
        class_3322.method_51433(this.field_22793, n9 != 0 ? "\u2315  " + this.search + "_" : "\u2315  Search...", n3 + 8, n8 + 12 - 4, this.col(n9 != 0 ? 15659767 : 6320256, (int)(200.0f * f)), false);
        n8 = this.listY();
        n9 = this.listH();
        GuiRenderer.a((class_332)class_3322, (float)n3, (float)(n8 - 2), (float)400.0f, (float)(n9 + 4), (float)6.0f, (int)this.alphaScale(-1442444784, f), (boolean)false);
        this.hoverRow = -1;
        if (this.loading && this.filtered.isEmpty()) {
            class_3322.method_51433(this.field_22793, this.status, n3 + (400 - this.field_22793.method_1727(this.status)) / 2, n8 + n9 / 2 - 4, this.col(6320256, (int)(180.0f * f)), false);
        } else if (this.filtered.isEmpty()) {
            String string3 = this.search.isEmpty() ? "Nothing here yet" : "No results for \"" + this.search + "\"";
            class_3322.method_51433(this.field_22793, string3, n3 + (400 - this.field_22793.method_1727(string3)) / 2, n8 + n9 / 2 - 4, this.col(6320256, (int)(180.0f * f)), false);
        } else {
            int n10;
            int n11;
            int n12 = Math.min(this.scroll + this.maxRows(), this.filtered.size());
            for (n11 = this.scroll; n11 < n12; ++n11) {
                SpotifyApi.a a2;
                boolean bl;
                String[] stringArray = this.filtered.get(n11);
                int n13 = n8 + (n11 - this.scroll) * 22;
                boolean bl2 = this.hov(n, n2, n3, n13, 400, 22);
                if (bl2) {
                    this.hoverRow = n11;
                }
                boolean bl3 = bl = stringArray instanceof SpotifyApi.a && (a2 = (SpotifyApi.a)stringArray) == this.filtered.get(0) && this.tab == 0;
                if (bl) {
                    GuiRenderer.a((class_332)class_3322, (float)n3, (float)n13, (float)400.0f, (float)21.0f, (float)4.0f, (int)this.col(n6, (int)(25.0f * f)), (boolean)false);
                    GuiRenderer.a((class_332)class_3322, (float)n3, (float)n13, (float)400.0f, (float)21.0f, (float)4.0f, (float)1.0f, (int)this.col(n6, (int)(80.0f * f)), (boolean)false);
                } else if (bl2) {
                    GuiRenderer.a((class_332)class_3322, (float)n3, (float)n13, (float)400.0f, (float)21.0f, (float)4.0f, (int)this.alphaScale(0x15FFFFFF, f), (boolean)false);
                }
                int n14 = n3 + 8;
                if (bl) {
                    class_3322.method_25294(n3 + 3, n13 + 5, n3 + 5, n13 + 22 - 5, this.col(n6, (int)(255.0f * f)));
                    n14 = n3 + 10;
                }
                String string4 = n11 + 1 + ".";
                class_3322.method_51433(this.field_22793, string4, n14, n13 + 11 - 4, this.col(5267568, (int)(160.0f * f)), false);
                n14 += this.field_22793.method_1727(string4) + 4;
                if (stringArray instanceof String[]) {
                    string4 = ">";
                    class_3322.method_51433(this.field_22793, string4, n3 + 400 - 14, n13 + 11 - 4, this.col(n6, (int)(160.0f * f)), false);
                }
                if (stringArray instanceof SpotifyApi.a) {
                    stringArray = (SpotifyApi.a)stringArray;
                    v1 = this.field_22793.method_27523(stringArray.r(), 400 - n14 - 18);
                } else if (stringArray instanceof String[]) {
                    stringArray = stringArray;
                    v1 = this.field_22793.method_27523(stringArray[1], 400 - n14 - 18);
                } else {
                    v1 = string4 = "";
                }
                n10 = bl ? this.col(n6, (int)(255.0f * f)) : this.col(bl2 ? 15659767 : 10531008, (int)(220.0f * f));
                class_3322.method_51433(this.field_22793, string4, n14, n13 + 11 - 4, n10, false);
            }
            if (this.filtered.size() > this.maxRows()) {
                n11 = n3 + 400 + 2;
                n10 = n9;
                float f2 = Math.max(20.0f, (float)n10 * ((float)this.maxRows() / (float)this.filtered.size()));
                float f3 = (float)n8 + ((float)n10 - f2) * ((float)this.scroll / (float)Math.max(1, this.maxScroll()));
                GuiRenderer.a((class_332)class_3322, (float)n11, (float)n8, (float)3.0f, (float)n10, (float)1.5f, (int)this.alphaScale(0x12FFFFFF, f), (boolean)false);
                GuiRenderer.a((class_332)class_3322, (float)n11, (float)((int)f3), (float)3.0f, (float)((int)f2), (float)1.5f, (int)this.col(n6, (int)(150.0f * f)), (boolean)false);
            }
        }
        this.renderFooter(class_3322, n4, n5, n, n2, f, n6);
    }

    private void renderTabs(class_332 class_3322, int n, int n2, int n3, int n4, float f, int n5) {
        n2 = n2 + 44 + 4;
        String[] stringArray = new String[]{"QUEUE", "PLAYLISTS", this.tab == 2 ? selectedPlaylistName : "TRACKS"};
        for (int i = 0; i < 3; ++i) {
            int n6 = n + 10 + i * 135;
            boolean bl = this.tab == i;
            int n7 = this.hov(n3, n4, n6, n2, 133, 22);
            n7 = bl ? this.col(n5, (int)(35.0f * f)) : this.col(0xFFFFFF, n7 != 0 ? (int)(18.0f * f) : (int)(8.0f * f));
            int n8 = bl ? this.col(n5, (int)(150.0f * f)) : this.col(0xFFFFFF, (int)(30.0f * f));
            GuiRenderer.a((class_332)class_3322, (float)n6, (float)n2, (float)133.0f, (float)22.0f, (float)5.0f, (int)n7, (boolean)false);
            GuiRenderer.a((class_332)class_3322, (float)n6, (float)n2, (float)133.0f, (float)22.0f, (float)5.0f, (float)1.0f, (int)n8, (boolean)false);
            String string = this.field_22793.method_27523(stringArray[i], 125);
            class_3322.method_51433(this.field_22793, string, n6 + (133 - this.field_22793.method_1727(string)) / 2, n2 + 11 - 4, bl ? this.col(n5, (int)(255.0f * f)) : this.col(10531008, (int)(200.0f * f)), false);
        }
    }

    private void renderClientIdSetup(class_332 class_3322, int n, int n2, int n3, int n4, float f, int n5) {
        n2 = n2 + 180 - 40;
        class_3322.method_51433(this.field_22793, "Setup Spotify (free on developer.spotify.com)", n + (420 - this.field_22793.method_1727("Setup Spotify (free on developer.spotify.com)")) / 2, n2 - 20, this.col(10531008, (int)(200.0f * f)), false);
        class_3322.method_51433(this.field_22793, "Enter Client ID:", n + 10, n2, this.col(15659767, (int)(255.0f * f)), false);
        GuiRenderer.a((class_332)class_3322, (float)(n + 10), (float)(n2 + 14), (float)400.0f, (float)22.0f, (float)5.0f, (int)this.alphaScale(-16183784, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n + 10), (float)(n2 + 14), (float)400.0f, (float)22.0f, (float)5.0f, (float)1.0f, (int)this.col(n5, (int)(150.0f * f)), (boolean)false);
        String string = this.clientIdInput.isEmpty() ? "Paste Client ID here..." : this.clientIdInput + "_";
        class_3322.method_51433(this.field_22793, string, n + 10 + 6, n2 + 19, this.col(this.clientIdInput.isEmpty() ? 6320256 : 15659767, (int)(200.0f * f)), false);
        boolean bl = this.hov(n3, n4, n + 10, n2 += 46, 80, 22);
        this.hov(n3, n4, n + 420 - 10 - 80, n2, 80, 22);
        GuiRenderer.a((class_332)class_3322, (float)(n + 10), (float)n2, (float)80.0f, (float)22.0f, (float)5.0f, (int)this.col(n5, bl ? (int)(50.0f * f) : (int)(20.0f * f)), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)(n + 10), (float)n2, (float)80.0f, (float)22.0f, (float)5.0f, (float)1.0f, (int)this.col(n5, (int)(150.0f * f)), (boolean)false);
        class_3322.method_51433(this.field_22793, "SAVE & CONNECT", n + 10 + 6, n2 + 7, this.col(n5, (int)(220.0f * f)), false);
        class_3322.method_51433(this.field_22793, "developer.spotify.com \u2192", n + 420 - 10 - this.field_22793.method_1727("developer.spotify.com \u2192"), n2 + 7, this.col(6320256, (int)(160.0f * f)), false);
    }

    private void renderFooter(class_332 class_3322, int n, int n2, int n3, int n4, float f, int n5) {
        GuiRenderer.a((class_332)class_3322, (float)n, (float)(n2 + 360 - 44), (float)420.0f, (float)44.0f, (float)0.0f, (float)0.0f, (float)10.0f, (float)10.0f, (boolean)false, (int[])new int[]{this.alphaScale(-871756264, f)});
        class_3322.method_25294(n, n2 + 360 - 44, n + 420, n2 + 360 - 44 + 1, this.alphaScale(0x20FFFFFF, f));
        n2 = n2 + 360 - 44 + 9;
        this.drawBtn(class_3322, n + 10, n2, 64, 26, "\u23ee PREV", n3, n4, f, n5);
        this.drawBtn(class_3322, n + 10 + 68, n2, 80, 26, "\u23f8 PAUSE", n3, n4, f, n5);
        this.drawBtn(class_3322, n + 10 + 152, n2, 64, 26, "NEXT \u23ed", n3, n4, f, n5);
        n = n + 420 - 10 - 64;
        n3 = this.hov(n3, n4, n, n2, 64, 26) ? 1 : 0;
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)64.0f, (float)26.0f, (float)6.0f, (int)this.alphaScale(n3 != 0 ? 0x25FFFFFF : 0x10FFFFFF, f), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)64.0f, (float)26.0f, (float)6.0f, (float)1.0f, (int)this.alphaScale(0x20FFFFFF, f), (boolean)false);
        class_3322.method_51433(this.field_22793, "CLOSE", n + (64 - this.field_22793.method_1727("CLOSE")) / 2, n2 + 9, this.col(10531008, (int)(200.0f * f)), false);
    }

    private void drawBtn(class_332 class_3322, int n, int n2, int n3, int n4, String string, int n5, int n6, float f, int n7) {
        n5 = this.hov(n5, n6, n, n2, n3, n4) ? 1 : 0;
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n3, (float)n4, (float)6.0f, (int)this.col(n7, n5 != 0 ? (int)(45.0f * f) : (int)(18.0f * f)), (boolean)false);
        GuiRenderer.a((class_332)class_3322, (float)n, (float)n2, (float)n3, (float)n4, (float)6.0f, (float)1.0f, (int)this.col(n7, n5 != 0 ? (int)(180.0f * f) : (int)(60.0f * f)), (boolean)false);
        class_3322.method_51433(this.field_22793, string, n + (n3 - this.field_22793.method_1727(string)) / 2, n2 + n4 / 2 - 4, this.col(n5 != 0 ? n7 : 10531008, (int)(220.0f * f)), false);
    }

    public boolean method_25402(class_11909 class_119092, boolean bl) {
        int n;
        int n2;
        int n3 = (int)class_119092.comp_4798();
        int n4 = (int)class_119092.comp_4799();
        int n5 = this.px();
        int n6 = this.py();
        if (this.enteringClientId) {
            int n7 = n6 + 180 - 40;
            int n8 = n7 + 46;
            if (this.hov(n3, n4, n5 + 10, n8, 80, 22) && !this.clientIdInput.isBlank()) {
                SpotifyAuth.v((String)this.clientIdInput);
                this.enteringClientId = false;
                this.method_25426();
            }
            return true;
        }
        if (!SpotifyAuth.ae()) {
            int n9 = n5 + 420 - 10 - 80;
            int n10 = n6 + 22 - 9;
            if (this.hov(n3, n4, n9, n10, 80, 18)) {
                if (!SpotifyAuth.ad()) {
                    this.enteringClientId = true;
                    this.clientIdInput = "";
                } else {
                    SpotifyAuth.a(() -> {
                        this.status = "Connected!";
                        this.loadQueue();
                    }, () -> {
                        this.status = "Auth failed.";
                    });
                }
            }
            this.renderFooterClick(n3, n4, n5, n6);
            return true;
        }
        int n11 = n6 + 44 + 4;
        for (n2 = 0; n2 < 3; ++n2) {
            n = n5 + 10 + n2 * 135;
            if (!this.hov(n3, n4, n, n11, 133, 22)) continue;
            if (n2 == 0 && this.tab != 0) {
                this.tab = 0;
                this.search = "";
                this.loadQueue();
            } else if (n2 == 1 && this.tab != 1) {
                this.tab = 1;
                this.search = "";
                if (PLAYLISTS_CACHE.isEmpty()) {
                    this.loadPlaylists();
                } else {
                    this.rebuild();
                }
            } else if (n2 == 2 && this.tab != 2 && selectedPlaylist != null) {
                this.tab = 2;
                this.search = "";
                this.rebuild();
            }
            return true;
        }
        if (this.renderFooterClick(n3, n4, n5, n6)) {
            return true;
        }
        n2 = n5 + 10;
        n = this.listY();
        if (n3 >= n2 && n3 < n2 + 400 && n4 >= n && n4 < n + this.listH()) {
            int n12 = (n4 - n) / 22 + this.scroll;
            if (n12 >= 0 && n12 < this.filtered.size()) {
                String[] stringArray = this.filtered.get(n12);
                if (stringArray instanceof SpotifyApi.a) {
                    stringArray = (SpotifyApi.a)stringArray;
                    this.exec.submit(() -> this.lambda$mouseClicked$7((SpotifyApi.a)stringArray));
                } else if (stringArray instanceof String[]) {
                    stringArray = stringArray;
                    this.loadPlaylistTracks(stringArray[0], stringArray[1]);
                }
            }
            return true;
        }
        return super.method_25402(class_119092, bl);
    }

    private boolean renderFooterClick(int n, int n2, int n3, int n4) {
        if (this.hov(n, n2, n3 + 420 - 10 - 64, n4 = n4 + 360 - 44 + 9, 64, 26)) {
            this.field_22787.method_1507(this.parent);
            return true;
        }
        if (this.hov(n, n2, n3 + 10, n4, 64, 26)) {
            this.exec.submit((Callable<Boolean>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, ac(), ()Ljava/lang/Boolean;)());
            return true;
        }
        if (this.hov(n, n2, n3 + 10 + 68, n4, 80, 26)) {
            this.exec.submit((Callable<Boolean>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, aa(), ()Ljava/lang/Boolean;)());
            return true;
        }
        if (this.hov(n, n2, n3 + 10 + 152, n4, 64, 26)) {
            this.exec.submit((Callable<Boolean>)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, ab(), ()Ljava/lang/Boolean;)());
            return true;
        }
        return false;
    }

    public boolean method_25400(class_11905 class_119052) {
        String string = class_119052.method_74226();
        if (string != null && !string.isEmpty()) {
            if (this.enteringClientId) {
                this.clientIdInput = this.clientIdInput + string;
            } else {
                this.search = this.search + string;
                this.rebuild();
            }
            return true;
        }
        return super.method_25400(class_119052);
    }

    public boolean method_25404(class_11908 class_119082) {
        if (class_119082.method_74228() == 259) {
            if (this.enteringClientId && !this.clientIdInput.isEmpty()) {
                this.clientIdInput = this.clientIdInput.substring(0, this.clientIdInput.length() - 1);
            } else if (!this.search.isEmpty()) {
                this.search = this.search.substring(0, this.search.length() - 1);
                this.rebuild();
            }
            return true;
        }
        if (class_119082.method_74231()) {
            this.field_22787.method_1507(this.parent);
            return true;
        }
        return super.method_25404(class_119082);
    }

    public boolean method_25401(double d2, double d3, double d4, double d5) {
        int n = this.px() + 10;
        int n2 = this.listY();
        if (d2 >= (double)n && d2 < (double)(n + 400) && d3 >= (double)n2 && d3 < (double)(n2 + this.listH())) {
            this.scroll = Math.max(0, Math.min(this.maxScroll(), this.scroll + (d5 > 0.0 ? -1 : 1)));
            return true;
        }
        return super.method_25401(d2, d3, d4, d5);
    }

    public boolean method_25421() {
        return false;
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    private int alphaScale(int n, float f) {
        return Math.max(0, Math.min(255, (int)((float)(n >> 24 & 0xFF) * f))) << 24 | n & 0xFFFFFF;
    }

    private int col(int n, int n2) {
        return Math.max(0, Math.min(255, n2)) << 24 | n & 0xFFFFFF;
    }

    private float easeOut(float f) {
        return 1.0f - (float)Math.pow(1.0f - Math.min(1.0f, f), 3.0);
    }

    private boolean hov(int n, int n2, int n3, int n4, int n5, int n6) {
        return n >= n3 && n <= n3 + n5 && n2 >= n4 && n2 <= n4 + n6;
    }

    private /* synthetic */ void lambda$mouseClicked$7(SpotifyApi.a a2) {
        boolean bl = SpotifyApi.e((String)a2.ae);
        if (!bl && selectedPlaylist != null) {
            SpotifyApi.a((String)("spotify:playlist:" + selectedPlaylist), (String)a2.ae);
        }
        this.field_22787.execute(() -> {
            this.status = "Playing: " + a2.ad;
            this.loadQueue();
        });
    }
}

