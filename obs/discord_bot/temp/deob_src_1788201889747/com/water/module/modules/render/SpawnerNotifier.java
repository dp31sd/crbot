/*
 * Decompiled with CFR 0.152.
 */
package com.water.module.modules.render;

import com.water.module.Category;
import com.water.module.Module;
import com.water.setting.Setting;
import com.water.utils.RenderUtils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.class_1297;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2636;
import net.minecraft.class_2818;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import org.lwjgl.opengl.GL11;

public final class SpawnerNotifier
extends Module {
    private final Setting<Color> field_0;
    private final CopyOnWriteArrayList<class_2338> field_1;
    private final Set<class_2338> field_2;
    private long field_3;
    private int field_4;

    public SpawnerNotifier() {
        super("Spawner Notifier", Category.b);
        this.co = new Setting<Color>("Color", new Color(255, 80, 80));
        this.a = new CopyOnWriteArrayList();
        this.t = ConcurrentHashMap.newKeySet();
        this.aa = 0L;
        this.k = 0;
        this.addSetting(this.co);
    }

    @Override
    public void onEnable() {
        this.a.clear();
        this.t.clear();
        this.k = 0;
    }

    @Override
    public void onDisable() {
        this.a.clear();
        this.t.clear();
    }

    @Override
    public void onTick() {
        if (SpawnerNotifier.mc.field_1687 == null || SpawnerNotifier.mc.field_1724 == null) {
            return;
        }
        ++this.k;
        if (this.k % 40 != 0) {
            return;
        }
        this.k = 0;
        class_1923 class_19232 = SpawnerNotifier.mc.field_1724.method_31476();
        int n = Math.min(SpawnerNotifier.mc.field_1690.method_38521(), 8);
        ArrayList<class_2586> arrayList = new ArrayList<class_2586>();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                class_2818 class_28182 = SpawnerNotifier.mc.field_1687.method_2935().method_12126(class_19232.field_9181 + i, class_19232.field_9180 + j, false);
                if (class_28182 == null) continue;
                for (Object object : class_28182.method_12214().values()) {
                    if (!(object instanceof class_2636)) continue;
                    object = (class_2636)object;
                    object = object.method_11016();
                    arrayList.add((class_2586)object);
                    if (this.t.contains(object)) continue;
                    this.t.add(object);
                    long l = System.currentTimeMillis();
                    if (l - this.aa > 5000L) {
                        this.aa = l;
                        SpawnerNotifier.mc.field_1687.method_43128((class_1297)SpawnerNotifier.mc.field_1724, SpawnerNotifier.mc.field_1724.method_23317(), SpawnerNotifier.mc.field_1724.method_23318(), SpawnerNotifier.mc.field_1724.method_23321(), class_3417.field_14627, class_3419.field_15250, 1.0f, 1.2f);
                    }
                    object = "\u00a7a[SpawnerNotifier] \u00a7fSpawner found at \u00a7e" + object.method_10263() + ", " + object.method_10264() + ", " + object.method_10260();
                    for (int k = 0; k < 4; ++k) {
                        SpawnerNotifier.mc.field_1705.method_1743().method_1812((class_2561)class_2561.method_43470((String)object));
                    }
                }
            }
        }
        this.t.retainAll(new HashSet(arrayList));
        this.a.clear();
        this.a.addAll(arrayList);
    }

    @Override
    public void onRender(class_4587 class_45872, float f) {
        if (SpawnerNotifier.mc.field_1687 == null || SpawnerNotifier.mc.field_1724 == null || this.a.isEmpty()) {
            return;
        }
        class_4184 class_41842 = RenderUtils.getCamera();
        if (class_41842 == null) {
            return;
        }
        class_41842 = RenderUtils.getCameraPos(class_41842);
        Object object = new ArrayList(this.a);
        class_45872.method_22903();
        GL11.glDisable((int)2929);
        try {
            object = object.iterator();
            while (object.hasNext()) {
                class_2338 class_23382 = (class_2338)object.next();
                double d2 = (double)class_23382.method_10263() + 0.5 - class_41842.field_1352;
                double d3 = (double)class_23382.method_10264() + 0.5 - class_41842.field_1351;
                double d4 = (double)class_23382.method_10260() + 0.5 - class_41842.field_1350;
                this.a(class_45872, d2, d3, d4);
            }
        }
        finally {
            GL11.glEnable((int)2929);
            class_45872.method_22909();
        }
    }

    private void method_0(class_4587 class_45872, double d2, double d3, double d4) {
        Color color = (Color)this.co.getValue();
        class_243 class_2432 = new class_243(d2, d3, d4);
        class_243 class_2433 = new class_243(d2, d3 + 500.0, d4);
        RenderUtils.renderLine(class_45872, color, class_2432, class_2433, 8.0f);
    }
}

