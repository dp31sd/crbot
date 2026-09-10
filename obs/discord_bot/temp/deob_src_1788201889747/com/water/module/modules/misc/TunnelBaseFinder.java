/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.misc;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.client.WaterPlus;
import com.water.setting.ModeSetting;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.minecraft.class_1268;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2596;
import net.minecraft.class_2663;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_7923;

public final class TunnelBaseFinder
extends Module {
    private static final int[][] field_0;
    private final Setting<Integer> field_1;
    private final Setting<Integer> field_2;
    private final Setting<Integer> field_3;
    private final Setting<Integer> field_4;
    private final ModeSetting field_5;
    private final Setting<Boolean> field_6;
    private final Setting<Float> field_7;
    private final Setting<Integer> field_8;
    private final Setting<Boolean> field_9;
    private final Setting<Boolean> field_10;
    private final Setting<Boolean> field_11;
    private final Setting<Boolean> field_12;
    private final Set<class_1923> field_13;
    private final Random field_14;
    private int field_15;
    private int field_16;
    private int field_17;
    private int field_18;
    private int field_19;
    private int field_20;
    private boolean field_21;
    private class_2338 field_22;

    public TunnelBaseFinder() {
        super("Tunnel Base Finder", Category.c);
        this.aT = new Setting<Integer>("Min Y", -59, -64, 0);
        this.aU = new Setting<Integer>("Max Y", -50, -64, 0);
        this.aV = new Setting<Integer>("Storage Threshold", 8, 1, 500);
        this.aW = new Setting<Integer>("Hazard Scan", 7, 3, 14);
        this.e = new ModeSetting("Tunnel Size", "1x1", "1x1", "3x3 (Center Only)");
        this.aX = new Setting<Boolean>("Auto Pickaxe", true);
        this.aY = new Setting<Float>("Turn Speed", Float.valueOf(4.0f), Float.valueOf(0.5f), Float.valueOf(12.0f));
        this.aZ = new Setting<Integer>("Mine Delay", 3, 1, 8);
        this.bn = new Setting<Boolean>("No Pauses", false);
        this.bo = new Setting<Boolean>("Cave Bypass", true);
        this.bp = new Setting<Boolean>("Route Line", true);
        this.bq = new Setting<Boolean>("Disconnect On Totem Pop", true);
        this.j = new HashSet();
        this.c = new Random();
        this.addSetting(this.aT);
        this.addSetting(this.aU);
        this.addSetting(this.aV);
        this.addSetting(this.aW);
        this.addSetting(this.e);
        this.addSetting(this.aX);
        this.addSetting(this.aY);
        this.addSetting(this.aZ);
        this.addSetting(this.bn);
        this.addSetting(this.bo);
        this.addSetting(this.bp);
        this.addSetting(this.bq);
    }

    @Override
    public void onEnable() {
        this.ap = TunnelBaseFinder.mc.field_1724 == null ? 0 : Math.floorMod(Math.round(TunnelBaseFinder.mc.field_1724.method_36454() / 90.0f), 4);
        this.aq = 0;
        this.ar = 0;
        this.as = 0;
        this.at = 0;
        this.au = 0;
        this.ah = false;
        this.c = null;
        this.j.clear();
    }

    @Override
    public void onDisable() {
        this.at();
        this.j.clear();
    }

    @Override
    public void onTick() {
        if (TunnelBaseFinder.mc.field_1724 == null || TunnelBaseFinder.mc.field_1687 == null || TunnelBaseFinder.mc.field_1761 == null || TunnelBaseFinder.mc.field_1755 != null || this.ah) {
            this.at();
            return;
        }
        this.as();
        int n = TunnelBaseFinder.mc.field_1724.method_31478();
        if (this.ah || n < Math.min((Integer)this.aT.getValue(), (Integer)this.aU.getValue()) || n > Math.max((Integer)this.aT.getValue(), (Integer)this.aU.getValue())) {
            this.at();
            return;
        }
        if (!((Boolean)this.bn.getValue()).booleanValue() && this.aq > 0) {
            --this.aq;
            this.at();
            return;
        }
        if (((Boolean)this.bn.getValue()).booleanValue()) {
            this.aq = 0;
            this.as = 0;
        }
        if (((Boolean)this.aX.getValue()).booleanValue() && !this.x()) {
            this.t("No pickaxe found in hotbar");
            this.setEnabled(false);
            return;
        }
        if (!((Boolean)this.bn.getValue()).booleanValue() && ++this.as >= 4800) {
            this.as = 0;
            this.aq = 200;
            this.at();
            return;
        }
        if (--this.ar <= 0 || this.g(this.ap) < 0) {
            this.ap = this.o();
            this.ar = 12 + this.c.nextInt(18);
        }
        this.au = this.h(this.ap);
        class_239 class_2392 = TunnelBaseFinder.mc.field_1765;
        class_2392 = class_2392 instanceof class_3965 ? (class_2392 = (class_3965)class_2392) : null;
        if ((class_2392 = this.a((class_3965)class_2392)) == null) {
            TunnelBaseFinder.mc.field_1761.method_2925();
            TunnelBaseFinder.mc.field_1690.field_1886.method_23481(false);
            TunnelBaseFinder.mc.field_1690.field_1894.method_23481(true);
            return;
        }
        this.b((class_2338)class_2392);
        if (((Boolean)this.bn.getValue()).booleanValue()) {
            TunnelBaseFinder.mc.field_1690.field_1867.method_23481(true);
            TunnelBaseFinder.mc.field_1690.field_1894.method_23481(true);
            TunnelBaseFinder.mc.field_1724.method_5728(true);
        }
        if (!TunnelBaseFinder.mc.field_1687.method_8320((class_2338)class_2392).method_26215()) {
            if (!((Boolean)this.bn.getValue()).booleanValue()) {
                TunnelBaseFinder.mc.field_1690.field_1894.method_23481(false);
            }
            TunnelBaseFinder.mc.field_1765 = new class_3965(class_243.method_24953((class_2382)class_2392), class_2350.field_11036, (class_2338)class_2392, false);
            if (++this.at >= (Integer)this.aZ.getValue()) {
                this.at = 0;
                TunnelBaseFinder.mc.field_1761.method_2902((class_2338)class_2392, class_2350.field_11036);
                TunnelBaseFinder.mc.field_1724.method_6104(class_1268.field_5808);
            }
            TunnelBaseFinder.mc.field_1690.field_1886.method_23481(true);
        } else {
            TunnelBaseFinder.mc.field_1761.method_2925();
            this.at = 0;
            TunnelBaseFinder.mc.field_1690.field_1886.method_23481(false);
            TunnelBaseFinder.mc.field_1690.field_1894.method_23481(true);
        }
        TunnelBaseFinder.mc.field_1690.field_1913.method_23481(false);
        TunnelBaseFinder.mc.field_1690.field_1849.method_23481(false);
    }

    @Override
    public void onPacketReceive(class_2596<?> class_26632) {
        if (!((Boolean)this.bq.getValue()).booleanValue() || TunnelBaseFinder.mc.field_1687 == null || TunnelBaseFinder.mc.field_1724 == null || !(class_26632 instanceof class_2663) || (class_26632 = (class_2663)class_26632).method_11470() != 35) {
            return;
        }
        if ((class_26632 = class_26632.method_11469((class_1937)TunnelBaseFinder.mc.field_1687)) != TunnelBaseFinder.mc.field_1724) {
            return;
        }
        this.at();
        if (mc.method_1562() != null && mc.method_1562().method_48296() != null) {
            mc.method_1562().method_48296().method_10747((class_2561)class_2561.method_43470((String)("Tunnel Base Finder: totem popped at X: " + TunnelBaseFinder.mc.field_1724.method_31477() + " Y: " + TunnelBaseFinder.mc.field_1724.method_31478() + " Z: " + TunnelBaseFinder.mc.field_1724.method_31479())));
        }
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        if (!((Boolean)this.bp.getValue()).booleanValue() || TunnelBaseFinder.mc.field_1724 == null || this.ah) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        class_41842 = new class_243(TunnelBaseFinder.mc.field_1724.method_23317(), TunnelBaseFinder.mc.field_1724.method_23318() + 0.15, TunnelBaseFinder.mc.field_1724.method_23321()).method_1020((class_243)class_41842);
        Object object = a[this.ap];
        object = class_41842.method_1031((double)(object[0] * (Integer)this.aW.getValue()), (double)this.au, (double)(object[1] * (Integer)this.aW.getValue()));
        RenderUtils.renderLine(class_45872, new Color(70, 220, 255, 210), (class_243)class_41842, (class_243)object, 2.25f);
    }

    private int method_0() {
        int n = this.ap;
        int n2 = Integer.MIN_VALUE;
        for (int i = 0; i < 4; ++i) {
            if (i == (this.ap + 2 & 3)) continue;
            int n3 = this.g(i) + (i == this.ap ? 5 : 0) + this.c.nextInt(3);
            if (n3 <= n2) continue;
            n2 = n3;
            n = i;
        }
        return n;
    }

    private int method_1(int n) {
        return this.a(n, 0);
    }

    private int method_2(int n, int n2) {
        class_2338 class_23382;
        class_2338 class_23383 = TunnelBaseFinder.mc.field_1724.method_24515();
        int[] nArray = a[n];
        int n3 = 0;
        int n4 = 0;
        for (int i = 1; i <= (Integer)this.aW.getValue(); ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 2; ++k) {
                    class_2338 class_23384 = new class_2338(class_23383.method_10263() + nArray[0] * i + nArray[1] * j, class_23383.method_10264() + n2 + k, class_23383.method_10260() + nArray[1] * i - nArray[0] * j);
                    if ((class_23384 = TunnelBaseFinder.mc.field_1687.method_8320(class_23384)).method_27852(class_2246.field_10164) || !class_23384.method_26227().method_15769()) {
                        return -10000;
                    }
                    if (class_23384.method_26215()) {
                        ++n4;
                        continue;
                    }
                    ++n3;
                }
            }
        }
        if (n4 > (Integer)this.aW.getValue() * 5) {
            n3 -= n4 * 3;
        }
        if (TunnelBaseFinder.mc.field_1687.method_8320(class_23382 = class_23383.method_10069(nArray[0], n2 - 1, nArray[1])).method_26215() || !TunnelBaseFinder.mc.field_1687.method_8316(class_23382).method_15769()) {
            n3 -= 200;
        }
        return n3;
    }

    private int method_3(int n) {
        if (!((Boolean)this.bo.getValue()).booleanValue()) {
            return 0;
        }
        if (!this.a(n, 0)) {
            return 0;
        }
        int n2 = this.a(n, -2);
        int n3 = this.a(n, 2);
        n = this.a(n, 0) - 120;
        if (n2 >= n3 && n2 > n) {
            return -2;
        }
        if (n3 > n) {
            return 2;
        }
        return 0;
    }

    private boolean method_4(int n, int n2) {
        class_2338 class_23382 = TunnelBaseFinder.mc.field_1724.method_24515();
        int[] nArray = a[n];
        int n3 = 0;
        int n4 = 0;
        for (int i = 1; i <= Math.min(5, (Integer)this.aW.getValue()); ++i) {
            for (int j = -1; j <= 1; ++j) {
                for (int k = -1; k <= 2; ++k) {
                    class_2338 class_23383 = new class_2338(class_23382.method_10263() + nArray[0] * i + nArray[1] * j, class_23382.method_10264() + n2 + k, class_23382.method_10260() + nArray[1] * i - nArray[0] * j);
                    if ((class_23383 = TunnelBaseFinder.mc.field_1687.method_8320(class_23383)).method_27852(class_2246.field_10164) || !class_23383.method_26227().method_15769()) {
                        return true;
                    }
                    if (class_23383.method_26215()) {
                        ++n3;
                    }
                    ++n4;
                }
            }
        }
        return n4 > 0 && (float)n3 > (float)n4 * 0.42f;
    }

    private class_2338 method_5(class_3965 class_39652) {
        if (this.c != null && TunnelBaseFinder.mc.field_1687.method_8320(this.c).method_26215()) {
            TunnelBaseFinder.mc.field_1761.method_2925();
            this.c = null;
        }
        if (this.c != null) {
            return this.c;
        }
        Object object = a[this.ap];
        class_2338 class_23382 = TunnelBaseFinder.mc.field_1724.method_24515();
        int n = this.au;
        if (this.e.d("3x3 (Center Only)")) {
            ++n;
        }
        if (!TunnelBaseFinder.mc.field_1687.method_8320((class_2338)(object = (Object)new class_2338(class_23382.method_10263() + object[0], class_23382.method_10264() + n, class_23382.method_10260() + object[1]))).method_26215()) {
            this.c = object.method_10062();
            TunnelBaseFinder.mc.field_1761.method_2925();
            return this.c;
        }
        if (class_39652 != null && !TunnelBaseFinder.mc.field_1687.method_8320(class_39652.method_17777()).method_26215()) {
            this.c = class_39652.method_17777().method_10062();
            TunnelBaseFinder.mc.field_1761.method_2925();
            return this.c;
        }
        return null;
    }

    private void method_6(class_2338 class_23382) {
        class_243 class_2432 = TunnelBaseFinder.mc.field_1724.method_33571();
        class_23382 = class_243.method_24953((class_2382)class_23382);
        double d2 = class_23382.field_1352 - class_2432.field_1352;
        double d3 = class_23382.field_1351 - class_2432.field_1351;
        double d4 = class_23382.field_1350 - class_2432.field_1350;
        double d5 = Math.sqrt(d2 * d2 + d4 * d4);
        float f = class_3532.method_15393((float)((float)(Math.toDegrees(Math.atan2(d4, d2)) - 90.0)));
        float f2 = class_3532.method_15363((float)((float)(-Math.toDegrees(Math.atan2(d3, d5)))), (float)-75.0f, (float)75.0f);
        f = class_3532.method_15393((float)(f - TunnelBaseFinder.mc.field_1724.method_36454()));
        float f3 = Math.min(Math.abs(f), ((Float)this.aY.getValue()).floatValue() * (0.62f + this.c.nextFloat() * 0.18f));
        float f4 = Math.min(Math.abs(f2 -= TunnelBaseFinder.mc.field_1724.method_36455()), Math.max(0.35f, ((Float)this.aY.getValue()).floatValue() * 0.42f));
        f = TunnelBaseFinder.mc.field_1724.method_36454() + Math.copySign(f3, f);
        f2 = TunnelBaseFinder.mc.field_1724.method_36455() + Math.copySign(f4, f2);
        TunnelBaseFinder.mc.field_1724.method_36456(f);
        TunnelBaseFinder.mc.field_1724.method_36457(f2);
        TunnelBaseFinder.mc.field_1724.method_5847(f);
        TunnelBaseFinder.mc.field_1724.method_5636(f);
    }

    private void method_7() {
        class_1923 class_19232 = TunnelBaseFinder.mc.field_1724.method_31476();
        int n = Math.min(TunnelBaseFinder.mc.field_1690.method_38521(), 12);
        for (int i = class_19232.field_9181 - n; i <= class_19232.field_9181 + n; ++i) {
            for (int j = class_19232.field_9180 - n; j <= class_19232.field_9180 + n; ++j) {
                Object object;
                class_1923 class_19233 = new class_1923(i, j);
                if (!this.j.add(class_19233) || (object = TunnelBaseFinder.mc.field_1687.method_2935().method_12126(i, j, false)) == null) continue;
                int n2 = 0;
                object = object.method_12214().values().iterator();
                while (object.hasNext()) {
                    class_2586 class_25862 = (class_2586)object.next();
                    if (!this.a(class_25862)) continue;
                    ++n2;
                }
                if (n2 < (Integer)this.aV.getValue()) continue;
                this.ah = true;
                this.at();
                object = "Found " + n2 + " storages near X: " + class_19233.method_33940() + " Z: " + class_19233.method_33942();
                this.t((String)object);
                if (TunnelBaseFinder.mc.field_1724 != null) {
                    TunnelBaseFinder.mc.field_1724.method_7353((class_2561)class_2561.method_43470((String)("\u00a78\u00a77[Tunnel Base Finder] " + (String)object)), false);
                }
                return;
            }
        }
    }

    private boolean method_8() {
        if (this.c(TunnelBaseFinder.mc.field_1724.method_6047().method_7909())) {
            return true;
        }
        for (int i = 0; i < 9; ++i) {
            class_1799 class_17992 = TunnelBaseFinder.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || !this.c(class_17992.method_7909())) continue;
            TunnelBaseFinder.mc.field_1724.method_31548().method_61496(i);
            return true;
        }
        return false;
    }

    private boolean method_9(class_1792 class_17922) {
        return class_7923.field_41178.method_10221((Object)class_17922).method_12832().endsWith("_pickaxe");
    }

    private boolean method_10(class_2586 class_25862) {
        if (class_25862 == null) {
            return false;
        }
        return (class_25862 = class_25862.method_11010()).method_27852(class_2246.field_10034) || class_25862.method_27852(class_2246.field_10380) || class_25862.method_27852(class_2246.field_16328) || class_25862.method_27852(class_2246.field_10443) || class_25862.method_27852(class_2246.field_10603) || class_25862.method_27852(class_2246.field_10199) || class_25862.method_27852(class_2246.field_10407) || class_25862.method_27852(class_2246.field_10063) || class_25862.method_27852(class_2246.field_10203) || class_25862.method_27852(class_2246.field_10600) || class_25862.method_27852(class_2246.field_10275) || class_25862.method_27852(class_2246.field_10051) || class_25862.method_27852(class_2246.field_10140) || class_25862.method_27852(class_2246.field_10320) || class_25862.method_27852(class_2246.field_10532) || class_25862.method_27852(class_2246.field_10268) || class_25862.method_27852(class_2246.field_10605) || class_25862.method_27852(class_2246.field_10373) || class_25862.method_27852(class_2246.field_10055) || class_25862.method_27852(class_2246.field_10068) || class_25862.method_27852(class_2246.field_10371);
    }

    private void method_11(String string) {
        try {
            ToastManager.INSTANCE.push("Tunnel Base Finder", string, class_1802.field_8377.method_7854(), WaterPlus.getAccentARGB());
        }
        catch (Throwable throwable) {}
    }

    private void method_12() {
        if (TunnelBaseFinder.mc.field_1690 != null) {
            TunnelBaseFinder.mc.field_1690.field_1894.method_23481(false);
            TunnelBaseFinder.mc.field_1690.field_1913.method_23481(false);
            TunnelBaseFinder.mc.field_1690.field_1849.method_23481(false);
            TunnelBaseFinder.mc.field_1690.field_1867.method_23481(false);
            TunnelBaseFinder.mc.field_1690.field_1886.method_23481(false);
        }
        if (TunnelBaseFinder.mc.field_1761 != null) {
            TunnelBaseFinder.mc.field_1761.method_2925();
        }
        this.at = 0;
        this.c = null;
    }

    static {
        a = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    }
}

