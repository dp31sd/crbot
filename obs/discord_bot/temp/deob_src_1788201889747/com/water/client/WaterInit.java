/*
 * Decompiled with CFR 0.152.
 */
package com.water.client;

import com.water.client.ClientBootstrap;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.LoggerFactory;

public class WaterInit
implements ClientModInitializer {
    public static boolean isMenuKey(int n, int n2) {
        return ClientBootstrap.isMenuKey(n, n2);
    }

    public static void toggleClickGui() {
        ClientBootstrap.toggleClickGui();
    }

    public void onInitializeClient() {
        ClientBootstrap.a();
    }

    static {
        LoggerFactory.getLogger((String)"water");
    }
}

