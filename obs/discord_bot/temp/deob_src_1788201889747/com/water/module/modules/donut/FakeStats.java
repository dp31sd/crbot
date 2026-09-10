/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.donut;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_270;
import net.minecraft.class_274;
import net.minecraft.class_5250;
import net.minecraft.class_8646;
import net.minecraft.class_9011;
import net.minecraft.class_9015;
import net.minecraft.class_9020;
import net.minecraft.class_9022;

public final class FakeStats
extends Module {
    private static FakeStats INSTANCE;
    private static final String OBJECTIVE_NAME = "water_fake_stats";
    private static final int MAX_SIDEBAR_LINES = 15;
    private final Setting<String> money = new Setting<String>("Money", "0");
    private final Setting<String> shards = new Setting<String>("Shards", "0");
    private final Setting<String> kills = new Setting<String>("Kills", "0");
    private final Setting<String> deaths = new Setting<String>("Deaths", "0");
    private final Setting<String> playtime = new Setting<String>("Playtime", "0m");
    private final Random randomSource = new Random();
    private class_266 originalObjective;
    private String originalObjectiveName;
    private class_266 customObjective;
    private AppliedStats appliedStats;
    private Object lastWorld;
    private String lastSnapshotSignature = "";
    private boolean needsRefresh;
    private long lastRebuildMs = 0L;
    private static final long REBUILD_COOLDOWN_MS = 500L;

    public static FakeStats getInstance() {
        return INSTANCE;
    }

    public FakeStats() {
        super("FakeStats", Category.d);
        INSTANCE = this;
        this.addSetting(this.money);
        this.addSetting(this.shards);
        this.addSetting(this.kills);
        this.addSetting(this.deaths);
        this.addSetting(this.playtime);
    }

    @Override
    public void onEnable() {
        this.lastWorld = FakeStats.mc.field_1687;
        this.originalObjective = null;
        this.originalObjectiveName = null;
        this.customObjective = null;
        this.lastSnapshotSignature = "";
        this.randomizeSettings();
        this.applyCurrentValues();
        this.needsRefresh = true;
    }

    @Override
    public void onDisable() {
        this.lastWorld = null;
        this.lastSnapshotSignature = "";
        this.needsRefresh = false;
        class_266 class_2662 = this.originalObjective;
        class_266 class_2663 = this.customObjective;
        this.originalObjective = null;
        this.originalObjectiveName = null;
        this.customObjective = null;
        if (FakeStats.mc.field_1687 != null) {
            class_269 class_2692 = FakeStats.mc.field_1687.method_8428();
            try {
                if (class_2663 != null) {
                    class_2692.method_1194(class_2663);
                }
                if (class_2662 != null && class_2692.method_1151().contains(class_2662)) {
                    class_2692.method_1158(class_8646.field_45157, class_2662);
                }
            }
            catch (Exception exception) {}
        }
    }

    @Override
    public void onTick() {
        Snapshot snapshot;
        if (FakeStats.mc.field_1687 == null) {
            this.originalObjective = null;
            this.originalObjectiveName = null;
            this.customObjective = null;
            this.lastWorld = null;
            this.lastSnapshotSignature = "";
            return;
        }
        if (FakeStats.mc.field_1687 != this.lastWorld) {
            this.originalObjective = null;
            this.originalObjectiveName = null;
            this.customObjective = null;
            this.lastSnapshotSignature = "";
            this.lastWorld = FakeStats.mc.field_1687;
            this.needsRefresh = true;
        }
        this.captureOriginalObjective();
        if (this.originalObjective == null) {
            return;
        }
        class_269 class_2692 = FakeStats.mc.field_1687.method_8428();
        if (!class_2692.method_1151().contains(this.originalObjective)) {
            this.originalObjective = null;
            this.captureOriginalObjective();
            if (this.originalObjective == null) {
                return;
            }
        }
        if ((snapshot = this.createSnapshot(class_2692, this.originalObjective)) == null) {
            return;
        }
        this.syncAppliedStatsWithSettings();
        if (!snapshot.signature().equals(this.lastSnapshotSignature) || this.customObjective == null) {
            this.needsRefresh = true;
        }
        this.rebuildIfPossible(class_2692, snapshot);
        if (this.customObjective != null && class_2692.method_1189(class_8646.field_45157) != this.customObjective) {
            class_2692.method_1158(class_8646.field_45157, this.customObjective);
        }
    }

    private void randomizeSettings() {
        this.money.setValue(this.formatCompactNumber(this.randomBetweenLong(10000L, 5000000000L)));
        this.shards.setValue(this.formatCompactNumber(this.randomBetweenLong(0L, 2500000L)));
        this.kills.setValue(String.valueOf(this.randomBetweenLong(0L, 2000L)));
        this.deaths.setValue(String.valueOf(this.randomBetweenLong(0L, 1000L)));
        this.playtime.setValue(this.formatCompactPlaytime(this.randomBetweenLong(0L, 15552000L)));
    }

    private void applyCurrentValues() {
        this.appliedStats = new AppliedStats(this.sanitize(this.money.getValue(), "0"), this.sanitize(this.shards.getValue(), "0"), this.sanitize(this.kills.getValue(), "0"), this.sanitize(this.deaths.getValue(), "0"), this.sanitize(this.playtime.getValue(), "0m"));
        this.needsRefresh = true;
    }

    private void syncAppliedStatsWithSettings() {
        AppliedStats appliedStats = new AppliedStats(this.sanitize(this.money.getValue(), "0"), this.sanitize(this.shards.getValue(), "0"), this.sanitize(this.kills.getValue(), "0"), this.sanitize(this.deaths.getValue(), "0"), this.sanitize(this.playtime.getValue(), "0m"));
        if (this.appliedStats == null || !this.appliedStats.signature().equals(appliedStats.signature())) {
            this.appliedStats = appliedStats;
            this.needsRefresh = true;
        }
    }

    private void captureOriginalObjective() {
        if (FakeStats.mc.field_1687 == null) {
            return;
        }
        class_269 class_26922 = FakeStats.mc.field_1687.method_8428();
        Object object = class_26922.method_1189(class_8646.field_45157);
        if (object != null && !OBJECTIVE_NAME.equals(object.method_1113())) {
            this.originalObjective = object;
            this.originalObjectiveName = object.method_1113();
            return;
        }
        if (this.originalObjective != null && class_26922.method_1151().contains(this.originalObjective)) {
            return;
        }
        if (this.originalObjectiveName != null && (object = class_26922.method_1170(this.originalObjectiveName)) != null && !OBJECTIVE_NAME.equals(object.method_1113())) {
            this.originalObjective = object;
            return;
        }
        for (class_269 class_26922 : class_26922.method_1151()) {
            if (OBJECTIVE_NAME.equals(class_26922.method_1113())) continue;
            this.originalObjective = class_26922;
            this.originalObjectiveName = class_26922.method_1113();
            return;
        }
    }

    private Snapshot createSnapshot(class_269 object, class_266 object22) {
        Object object23;
        ArrayList<SourceLine> arrayList = new ArrayList<SourceLine>();
        class_5250 class_52502 = new ArrayList<class_9011>(object.method_1184((class_266)object22));
        class_52502.removeIf(class_9011::method_55385);
        class_52502.sort(Comparator.comparingInt(class_9011::comp_2128).reversed());
        if (class_52502.size() > 15) {
            class_52502 = new ArrayList(class_52502.subList(0, 15));
        }
        for (Object object23 : class_52502) {
            arrayList.add(new SourceLine(object23.comp_2128(), this.getVisibleLine((class_269)object, (class_9011)object23)));
        }
        class_52502 = object22.method_1114() != null ? object22.method_1114().method_27661() : class_2561.method_43470((String)"Donut SMP");
        object23 = new StringBuilder(class_52502.getString());
        for (SourceLine sourceLine : arrayList) {
            ((StringBuilder)object23).append('\n').append(sourceLine.score()).append(':').append(sourceLine.text().getString());
        }
        ((StringBuilder)object23).append('\n').append(this.appliedStats != null ? this.appliedStats.signature() : "");
        return new Snapshot((class_2561)class_52502, arrayList, ((StringBuilder)object23).toString());
    }

    private class_2561 getVisibleLine(class_269 class_2692, class_9011 class_90112) {
        if (class_90112.comp_2129() != null) {
            return class_90112.comp_2129().method_27661();
        }
        class_5250 class_52502 = class_90112.method_55387() != null ? class_90112.method_55387().method_27661() : class_2561.method_43470((String)class_90112.comp_2127());
        class_2692 = class_2692.method_1164(class_90112.comp_2127());
        return class_268.method_1142((class_270)class_2692, (class_2561)class_52502).method_27661();
    }

    private void rebuildIfPossible(class_269 class_2692, Snapshot snapshot) {
        if (!this.needsRefresh || this.appliedStats == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.lastRebuildMs < 500L) {
            return;
        }
        this.lastRebuildMs = l;
        Object object = class_2692.method_1170(OBJECTIVE_NAME);
        if (object != null) {
            class_2692.method_1194((class_266)object);
        }
        this.customObjective = class_2692.method_1168(OBJECTIVE_NAME, class_274.field_1468, (class_2561)snapshot.title().method_27661(), class_274.class_275.field_1472, true, (class_9022)class_9020.field_47557);
        class_2692.method_1158(class_8646.field_45157, this.customObjective);
        object = snapshot.lines();
        int n = 0;
        for (int i = 0; i < object.size(); ++i) {
            SourceLine sourceLine = (SourceLine)object.get(i);
            class_9015 class_90152 = class_9015.method_55422((String)("fake_stats_line_" + i));
            class_90152 = class_2692.method_1180(class_90152, this.customObjective);
            class_90152.method_55410(object.size() - i);
            String string = sourceLine.text().getString().trim();
            boolean bl = string.matches(".*\\d.*");
            if (bl) {
                class_90152.method_55411(this.replaceStatByIndex(sourceLine.text(), n));
                ++n;
            } else {
                class_90152.method_55411((class_2561)sourceLine.text().method_27661());
            }
            class_90152.method_55412((class_9022)class_9020.field_47557);
        }
        this.lastSnapshotSignature = snapshot.signature();
        this.needsRefresh = false;
    }

    private class_2561 replaceStatByIndex(class_2561 object, int n) {
        Object object2 = new String[]{this.appliedStats.money(), this.appliedStats.shards(), this.appliedStats.kills(), this.appliedStats.deaths(), this.appliedStats.playtime()};
        if (n >= ((String[])object2).length) {
            return object.method_27661();
        }
        String string = object2[n];
        object2 = this.collectSegments((class_2561)object);
        object = object.getString();
        int n2 = -1;
        for (int i = 0; i < ((String)object).length(); ++i) {
            char c2 = ((String)object).charAt(i);
            if (!Character.isDigit(c2) && (c2 != '-' || i + 1 >= ((String)object).length() || !Character.isDigit(((String)object).charAt(i + 1)))) continue;
            n2 = i;
            break;
        }
        if (n2 < 0) {
            class_5250 class_52502 = class_2561.method_43473();
            Iterator iterator = object2.iterator();
            while (iterator.hasNext()) {
                object = (TextSegment)iterator.next();
                class_52502.method_10852((class_2561)class_2561.method_43470((String)((TextSegment)object).value()).method_10862(((TextSegment)object).style()));
            }
            return class_52502;
        }
        class_5250 class_52503 = class_2561.method_43473();
        this.appendTextRange(class_52503, (List<TextSegment>)object2, n2);
        class_52503.method_10852((class_2561)class_2561.method_43470((String)string).method_10862(this.findStyleAt((List<TextSegment>)object2, n2)));
        return class_52503;
    }

    private List<TextSegment> collectSegments(class_2561 class_25612) {
        ArrayList<TextSegment> arrayList = new ArrayList<TextSegment>();
        class_25612.method_27658((class_25832, string) -> {
            if (!string.isEmpty()) {
                arrayList.add(new TextSegment(string, class_25832));
            }
            return Optional.empty();
        }, class_2583.field_24360);
        return arrayList;
    }

    private void appendTextRange(class_5250 class_52502, List<TextSegment> object, int n) {
        n = Math.max(0, n);
        object = object.iterator();
        while (object.hasNext()) {
            TextSegment textSegment = (TextSegment)object.next();
            if (n <= 0) {
                return;
            }
            String string = textSegment.value();
            int n2 = Math.min(string.length(), n);
            class_52502.method_10852((class_2561)class_2561.method_43470((String)string.substring(0, n2)).method_10862(textSegment.style()));
            n -= n2;
        }
    }

    private class_2583 findStyleAt(List<TextSegment> object, int n) {
        n = Math.max(0, n);
        class_2583 class_25832 = class_2583.field_24360;
        object = object.iterator();
        while (object.hasNext()) {
            TextSegment textSegment = (TextSegment)object.next();
            if (!textSegment.value().isEmpty()) {
                class_25832 = textSegment.style();
            }
            if (n < textSegment.value().length()) {
                return textSegment.style();
            }
            n -= textSegment.value().length();
        }
        return class_25832;
    }

    private void restoreOriginalScoreboard() {
        if (FakeStats.mc.field_1687 == null) {
            return;
        }
        class_269 class_2692 = FakeStats.mc.field_1687.method_8428();
        class_266 class_2662 = class_2692.method_1170(OBJECTIVE_NAME);
        if (class_2662 != null) {
            class_2692.method_1194(class_2662);
        }
        if (this.originalObjective != null && class_2692.method_1151().contains(this.originalObjective)) {
            class_2692.method_1158(class_8646.field_45157, this.originalObjective);
        }
    }

    private long randomBetweenLong(long l, long l2) {
        if (l >= l2) {
            return l;
        }
        return l + (long)Math.floor(this.randomSource.nextDouble() * (double)(l2 - l + 1L));
    }

    private String formatCompactNumber(long l) {
        long l2 = Math.abs(l);
        if (l2 < 1000L) {
            return Long.toString(l);
        }
        if (l2 < 1000000L) {
            return this.formatCompactValue((double)l / 1000.0, "K");
        }
        if (l2 < 1000000000L) {
            return this.formatCompactValue((double)l / 1000000.0, "M");
        }
        return this.formatCompactValue((double)l / 1.0E9, "B");
    }

    private String formatCompactValue(double d2, String string) {
        String string2 = d2 >= 100.0 ? "%.0f%s" : (d2 >= 10.0 ? "%.1f%s" : "%.2f%s");
        return String.format(Locale.US, string2, d2, string);
    }

    private String formatCompactPlaytime(long l) {
        long l2 = l / 3600L;
        long l3 = l2 / 24L;
        long l4 = l2 % 24L;
        long l5 = l % 3600L / 60L;
        if (l3 > 0L) {
            return String.format(Locale.US, "%dd %dh", l3, l4);
        }
        if (l2 > 0L) {
            return String.format(Locale.US, "%dh %dm", l2, l5);
        }
        return String.format(Locale.US, "%dm", l5);
    }

    private String sanitize(String string, String string2) {
        if (string == null) {
            return string2;
        }
        return (string = string.trim()).isEmpty() ? string2 : string;
    }

    public class_2561 fakeFooterText(class_2561 object) {
        if (this.appliedStats == null) {
            return object;
        }
        String string = object.getString();
        Object object2 = Pattern.compile("(\\$\\s*)([0-9][0-9.,]*[KkMmBbTt]?)");
        if (!((Matcher)(object2 = ((Pattern)object2).matcher(string))).find()) {
            return object;
        }
        string = string.substring(0, ((Matcher)object2).start(2)) + this.appliedStats.money() + string.substring(((Matcher)object2).end(2));
        object = (object = this.collectSegments((class_2561)object)).isEmpty() ? class_2583.field_24360 : ((TextSegment)object.get(0)).style();
        return class_2561.method_43470((String)string).method_10862((class_2583)object);
    }

    private record Snapshot(class_2561 title, List<SourceLine> lines, String signature) {
    }

    private record AppliedStats(String money, String shards, String kills, String deaths, String playtime) {
        private String signature() {
            return this.money + "|" + this.shards + "|" + this.kills + "|" + this.deaths + "|" + this.playtime;
        }
    }

    private record SourceLine(int score, class_2561 text) {
    }

    private record TextSegment(String value, class_2583 style) {
    }
}

