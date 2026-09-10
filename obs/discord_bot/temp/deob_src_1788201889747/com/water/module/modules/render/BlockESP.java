/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.gui.ToastManager;
import com.water.module.Category;
import com.water.module.Module;
import com.water.module.modules.render.Freecam;
import com.water.setting.BlocksSetting;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import net.minecraft.class_1297;
import net.minecraft.class_1799;
import net.minecraft.class_1923;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2672;
import net.minecraft.class_2680;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_7923;

public final class BlockESP
extends Module {
    private final BlocksSetting field_0;
    private final Setting<Boolean> field_1;
    private final Setting<Boolean> field_2;
    private final Setting<Double> field_3;
    private final Setting<Boolean> field_4;
    private final Setting<Double> field_5;
    private final Setting<Double> field_6;
    private final Setting<Integer> field_7;
    private final Map<Long, Set<class_2338>> field_8;
    private final Map<class_2338, class_2248> field_9;
    private final Map<Long, Long> field_10;
    private final ArrayDeque<Long> field_11;
    private final Set<Long> field_12;
    private final Object field_13;
    private final ConcurrentHashMap<class_2248, Color> field_14;
    private volatile Set<class_2248> field_15;
    private long field_16;
    private int field_17;
    private boolean field_18;
    private class_1923 field_19;
    private int field_20;
    private final List<a> field_21;

    public BlockESP() {
        super("Block ESP", Category.b);
        this.a = new BlocksSetting("Blocks", class_2246.field_10260);
        this.bs = new Setting<Boolean>("Notification", true);
        this.bt = new Setting<Boolean>("Tracers", true);
        this.bu = new Setting<Double>("Tracer Weight", 1.0, 0.1, 5.0);
        this.bv = new Setting<Boolean>("Filled", true);
        this.bw = new Setting<Double>("Opacity", 220.0, 0.0, 255.0);
        this.bx = new Setting<Double>("Fill Alpha", 100.0, 0.0, 255.0);
        this.by = new Setting<Integer>("Max Render", 500, 10, 2000);
        this.j = new ConcurrentHashMap();
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.a = new ArrayDeque();
        this.k = new HashSet();
        this.a = new Object();
        this.b = new ConcurrentHashMap();
        this.l = Collections.emptySet();
        this.x = -1L;
        this.k = 0;
        this.ai = true;
        this.av = -1;
        this.d = new ArrayList();
        this.addSetting(this.a);
        this.addSetting(this.bs);
        this.addSetting(this.bt);
        this.addSetting(this.bu);
        this.addSetting(this.bv);
        this.addSetting(this.bw);
        this.addSetting(this.bx);
        this.addSetting(this.by);
    }

    @Override
    public void onEnable() {
        this.av();
        this.x = -1L;
        this.ai = true;
        this.k = 0;
        this.c = null;
        this.av = -1;
    }

    @Override
    public void onDisable() {
        this.av();
        this.c = null;
        this.av = -1;
    }

    @Override
    public void onTick() {
        int n;
        if (BlockESP.mc.field_1687 == null || BlockESP.mc.field_1724 == null) {
            return;
        }
        this.au();
        if (this.l.isEmpty()) {
            this.av();
            return;
        }
        ++this.k;
        class_1923 class_19232 = BlockESP.mc.field_1724.method_31476();
        int n2 = this.p();
        int n3 = n = this.ai || this.k % 200 == 0 ? 1 : 0;
        if (n != 0 || this.c == null || !this.c.equals((Object)class_19232) || this.av != n2) {
            this.b(n != 0);
            this.ai = false;
            this.c = class_19232;
            this.av = n2;
        }
        for (int i = 0; i < 6; ++i) {
            Long l;
            Object object = this.a;
            synchronized (object) {
                l = (Long)this.a.poll();
                if (l != null) {
                    this.k.remove(l);
                }
            }
            if (l == null) break;
            n = class_1923.method_8325((long)l);
            int n4 = class_1923.method_8332((long)l);
            class_2818 class_28182 = BlockESP.mc.field_1687.method_2935().method_12126(n, n4, false);
            if (class_28182 == null) continue;
            this.a(class_28182);
        }
    }

    @Override
    public void onPacketReceive(class_2596<?> class_26722) {
        if (BlockESP.mc.field_1687 == null) {
            return;
        }
        if (class_26722 instanceof class_2672) {
            class_26722 = class_26722;
            this.a(class_1923.method_8331((int)class_26722.method_11523(), (int)class_26722.method_11524()), true);
        } else if (class_26722 instanceof class_2637) {
            class_26722 = (class_2637)class_26722;
            class_26722.method_30621((BiConsumer<class_2338, class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;Ljava/lang/Object;)V, b(net.minecraft.class_2338 net.minecraft.class_2680 ), (Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V)((BlockESP)this));
        } else if (class_26722 instanceof class_2626) {
            class_26722 = (class_2626)class_26722;
            this.a(new class_1923(class_26722.method_11309()).method_8324(), true);
        }
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        Object object;
        Object object2;
        Object object32;
        if (BlockESP.mc.field_1687 == null || BlockESP.mc.field_1724 == null || this.j.isEmpty()) {
            return;
        }
        Object object4 = this.l;
        if (object4.isEmpty()) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_243 class_2432 = RenderUtils.getCameraPos(class_41842);
        class_41842 = RenderUtils.getCameraForward(class_41842);
        class_243 class_2433 = Freecam.resolveTracerOrigin(class_2432, f);
        class_2433 = class_2433.equals((Object)class_2432) ? class_41842.method_1021(0.1) : class_2433.method_1020(class_2432);
        int n = BlockESP.i((int)((int)Math.round((Double)this.bw.getValue())));
        int n2 = BlockESP.i((int)((int)Math.round((Double)this.bx.getValue())));
        int n3 = (Integer)this.by.getValue();
        double d2 = this.b();
        double d3 = BlockESP.mc.field_1724.method_23317();
        double d4 = BlockESP.mc.field_1724.method_23318();
        double d5 = BlockESP.mc.field_1724.method_23321();
        this.d.clear();
        for (Object object32 : this.j.values()) {
            Iterator iterator = object32.iterator();
            while (iterator.hasNext()) {
                object2 = (class_2338)iterator.next();
                double d6 = object2.method_40081(d3, d4, d5);
                if (d6 > d2 || (object = (class_2248)this.k.get(object2)) == null || !object4.contains(object)) continue;
                this.d.add(new a((double)object2.method_10263() - class_2432.field_1352, (double)object2.method_10264() - class_2432.field_1351, (double)object2.method_10260() - class_2432.field_1350, this.a((class_2248)object, 255), d6));
            }
        }
        if (this.d.isEmpty()) {
            return;
        }
        this.d.sort(Comparator.comparingDouble((ToDoubleFunction<a>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)D, a(com.water.module.modules.render.BlockESP$a ), (Lcom/water/module/modules/render/BlockESP$a;)D)()));
        int n4 = Math.min(n3, this.d.size());
        object32 = RenderUtils.beginWorldBatch(class_45872);
        for (int i = n4 - 1; i >= 0; --i) {
            object2 = (a)this.d.get(i);
            Color color = BlockESP.a((Color)object2.d, (int)n);
            Color color2 = BlockESP.a((Color)object2.d, (int)255);
            object = BlockESP.a((Color)object2.d, (int)70);
            object4 = BlockESP.a((Color)object2.d, (int)145);
            ((RenderUtils.WorldBatch)object32).renderOutlineBox(object2.x + 0.0625, object2.y + 0.0625, object2.z + 0.0625, object2.x + 1.0 - 0.0625, object2.y + 1.0 - 0.0625, object2.z + 1.0 - 0.0625, color);
            if (!((Boolean)this.bt.getValue()).booleanValue()) continue;
            class_2432 = new class_243(object2.x + 0.5, object2.y + 0.5, object2.z + 0.5);
            ((RenderUtils.WorldBatch)object32).renderLine((Color)object, class_2433, class_2432, ((Double)this.bu.getValue()).floatValue() + 2.4f);
            ((RenderUtils.WorldBatch)object32).renderLine((Color)object4, class_2433, class_2432, ((Double)this.bu.getValue()).floatValue() + 1.4f);
            ((RenderUtils.WorldBatch)object32).renderLine(color2, class_2433, class_2432, ((Double)this.bu.getValue()).floatValue());
        }
        ((RenderUtils.WorldBatch)object32).flush();
        if (((Boolean)this.bv.getValue()).booleanValue() && n2 > 0) {
            RenderUtils.WorldBatch worldBatch = RenderUtils.beginWorldBatch(class_45872);
            for (int i = n4 - 1; i >= 0; --i) {
                a a2 = (a)this.d.get(i);
                worldBatch.renderFilledBox(a2.x + 0.0625, a2.y + 0.0625, a2.z + 0.0625, a2.x + 1.0 - 0.0625, a2.y + 1.0 - 0.0625, a2.z + 1.0 - 0.0625, BlockESP.a((Color)a2.d, (int)n2));
            }
            worldBatch.flush();
        }
    }

    private static int method_0(int n) {
        return Math.max(0, Math.min(255, n));
    }

    private void method_1() {
        long l = this.a.getVersion();
        if (l == this.x) {
            return;
        }
        this.x = l;
        this.l = Set.copyOf(this.a.getSelectedBlocks());
        this.av();
        this.ai = true;
    }

    public void method_2(Map<class_2248, Color> map) {
        this.b.clear();
        this.b.putAll(map);
    }

    public Map<class_2248, Color> method_3() {
        return new LinkedHashMap<class_2248, Color>(this.b);
    }

    private void method_4(boolean bl) {
        if (BlockESP.mc.field_1687 == null || BlockESP.mc.field_1724 == null) {
            return;
        }
        int n = this.p();
        class_1923 class_19232 = BlockESP.mc.field_1724.method_31476();
        ArrayList<class_2818> arrayList = new ArrayList<class_2818>();
        HashSet<Long> hashSet = new HashSet<Long>();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                class_2818 class_28182 = BlockESP.mc.field_1687.method_2935().method_12126(class_19232.field_9181 + i, class_19232.field_9180 + j, false);
                if (class_28182 == null) continue;
                arrayList.add(class_28182);
                hashSet.add(class_28182.method_12004().method_8324());
            }
        }
        arrayList.sort(Comparator.comparingInt((ToIntFunction<class_2818>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)I, a(net.minecraft.class_1923 net.minecraft.class_2818 ), (Lnet/minecraft/class_2818;)I)((BlockESP)this, (class_1923)class_19232)));
        Object object = this.a;
        synchronized (object) {
            this.a.removeIf((Predicate<Long>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(java.util.Set java.lang.Long ), (Ljava/lang/Long;)Z)(hashSet));
            this.k.retainAll(hashSet);
            for (class_2818 class_28182 : arrayList) {
                long l = class_28182.method_12004().method_8324();
                if (!bl && this.j.containsKey(l) || !this.k.add(l)) continue;
                this.a.addLast(l);
            }
        }
        this.a(class_19232, n);
    }

    private void method_5(long l, boolean bl) {
        Object object = this.a;
        synchronized (object) {
            if (bl && this.k.contains(l)) {
                this.a.remove(l);
                this.a.addFirst(l);
                return;
            }
            if (!this.k.add(l)) {
                return;
            }
            if (bl) {
                this.a.addFirst(l);
            } else {
                this.a.add(l);
            }
        }
    }

    private void method_6(class_2818 class_2826Array) {
        Set set = this.l;
        if (set.isEmpty()) {
            return;
        }
        int n = BlockESP.mc.field_1687.method_31607();
        int n2 = BlockESP.mc.field_1687.method_31607() + BlockESP.mc.field_1687.method_31605();
        int n3 = BlockESP.mc.field_1687.method_32891();
        class_1923 class_19232 = class_2826Array.method_12004();
        long l = class_19232.method_8324();
        Set set2 = (Set)this.j.get(l);
        HashSet<class_2338> hashSet = new HashSet<class_2338>();
        class_2248 class_22482 = null;
        class_2338 class_23382 = null;
        class_2826Array = class_2826Array.method_12006();
        for (int i = 0; i < class_2826Array.length; ++i) {
            int n4;
            class_2826 class_28262 = class_2826Array[i];
            if (class_28262 == null || class_28262.method_38292() || (n4 = (n3 + i) * 16) + 16 <= n || n4 >= n2 || !class_28262.method_12265().method_19526((Predicate<class_2680>)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Z, a(java.util.Set net.minecraft.class_2680 ), (Lnet/minecraft/class_2680;)Z)((Set)set))) continue;
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    for (int i2 = 0; i2 < 16; ++i2) {
                        class_2248 class_22483 = class_28262.method_12254(j, i2, k).method_26204();
                        if (!set.contains(class_22483)) continue;
                        class_2338 class_23383 = new class_2338(class_19232.method_8326() + j, n4 + i2, class_19232.method_8328() + k);
                        hashSet.add(class_23383);
                        this.k.put(class_23383, class_22483);
                        if (class_22482 != null || set2 != null && set2.contains(class_23383)) continue;
                        class_22482 = class_22483;
                        class_23382 = class_23383;
                    }
                }
            }
        }
        if (set2 != null) {
            for (class_2826 class_28262 : set2) {
                if (hashSet.contains(class_28262)) continue;
                this.k.remove(class_28262);
            }
        }
        if (hashSet.isEmpty()) {
            this.b(l);
            this.l.remove(l);
            return;
        }
        this.j.put(l, hashSet);
        if (class_22482 != null) {
            this.a(l, class_22482, class_23382, class_19232);
        }
    }

    private void method_7(long l, class_2248 class_22482, class_2338 class_23382, class_1923 class_19232) {
        long l2;
        if (!((Boolean)this.bs.getValue()).booleanValue() || BlockESP.mc.field_1724 == null) {
            return;
        }
        long l3 = System.currentTimeMillis();
        if (l3 - (l2 = this.l.getOrDefault(l, 0L).longValue()) < 750L) {
            return;
        }
        this.l.put(l, l3);
        ToastManager.INSTANCE.push(this.a(class_22482) + " found", "X " + class_23382.method_10263() + "  Y " + class_23382.method_10264() + "  Z " + class_23382.method_10260(), this.a(class_22482), this.a(class_22482, 255).getRGB());
        BlockESP.mc.field_1687.method_43128((class_1297)BlockESP.mc.field_1724, BlockESP.mc.field_1724.method_23317(), BlockESP.mc.field_1724.method_23318(), BlockESP.mc.field_1724.method_23321(), class_3417.field_14627, class_3419.field_15250, 0.6f, 0.95f);
    }

    private class_1799 method_8(class_2248 class_22482) {
        return (class_22482 = new class_1799((class_1935)class_22482.method_8389())).method_7960() ? class_1799.field_8037 : class_22482;
    }

    private int method_9(class_1923 class_19232, class_1923 class_19233) {
        int n = class_19233.field_9181 - class_19232.field_9181;
        int n2 = class_19233.field_9180 - class_19232.field_9180;
        return n * n + n2 * n2;
    }

    private int method_10() {
        return BlockESP.mc.field_1690.method_38521();
    }

    private double method_11() {
        double d2 = (double)this.p() * 16.0 + 16.0;
        return d2 * d2;
    }

    private void method_12(class_1923 class_19232, int n) {
        ArrayList<Long> arrayList = new ArrayList<Long>();
        for (Long l : this.j.keySet()) {
            class_1923 class_19233 = new class_1923(class_1923.method_8325((long)l), class_1923.method_8332((long)l));
            if (Math.abs(class_19233.field_9181 - class_19232.field_9181) <= n && Math.abs(class_19233.field_9180 - class_19232.field_9180) <= n) continue;
            arrayList.add(l);
        }
        for (Long l : arrayList) {
            this.b(l);
            this.l.remove(l);
        }
    }

    private void method_13(long l) {
        Set set = (Set)this.j.remove(l);
        if (set != null) {
            set.forEach(this.k::remove);
        }
    }

    private Color method_14(class_2248 class_22482, int n) {
        Object object = (Color)this.b.get(class_22482);
        if (object != null) {
            return new Color(((Color)object).getRed(), ((Color)object).getGreen(), ((Color)object).getBlue(), n);
        }
        object = class_7923.field_41175.method_10221((Object)class_22482);
        Object object2 = object = object == null ? "" : object.method_12832();
        if (class_22482 == class_2246.field_10260) {
            return new Color(138, 126, 166, n);
        }
        if (((String)object).contains("diamond")) {
            return new Color(0, 255, 255, n);
        }
        if (((String)object).contains("ancient_debris")) {
            return new Color(196, 120, 72, n);
        }
        if (((String)object).contains("emerald")) {
            return new Color(0, 255, 127, n);
        }
        if (((String)object).contains("gold")) {
            return new Color(255, 215, 0, n);
        }
        if (((String)object).contains("iron")) {
            return new Color(213, 213, 213, n);
        }
        if (((String)object).contains("redstone")) {
            return new Color(255, 70, 70, n);
        }
        if (((String)object).contains("lapis")) {
            return new Color(70, 110, 255, n);
        }
        return new Color(255, 255, 0, n);
    }

    private static Color method_15(Color color, int n) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), n);
    }

    private String method_16(class_2248 class_22482) {
        try {
            return class_22482.method_9518().getString();
        }
        catch (Exception exception) {
            class_22482 = class_7923.field_41175.method_10221((Object)class_22482);
            return class_22482 == null ? "Block" : class_22482.toString();
        }
    }

    private void method_17() {
        this.j.clear();
        this.k.clear();
        this.l.clear();
        Object object = this.a;
        synchronized (object) {
            this.a.clear();
            this.k.clear();
        }
    }

    private static /* synthetic */ boolean method_18(Set set, class_2680 class_26802) {
        return set.contains(class_26802.method_26204());
    }

    private static /* synthetic */ boolean method_19(Set set, Long l) {
        return !set.contains(l);
    }

    private /* synthetic */ int method_20(class_1923 class_19232, class_2818 class_28182) {
        return this.b(class_19232, class_28182.method_12004());
    }

    private static /* synthetic */ double method_21(a a2) {
        return a2.d;
    }

    private /* synthetic */ void method_22(class_2338 class_23382, class_2680 class_26802) {
        this.a(new class_1923(class_23382).method_8324(), true);
    }

    private static final class a {
        final double field_0;
        final double field_1;
        final double field_2;
        final Color field_3;
        final double field_4;

        a(double d2, double d3, double d4, Color color, double d5) {
            this.x = d2;
            this.y = d3;
            this.z = d4;
            this.d = color;
            this.d = d5;
        }
    }
}

