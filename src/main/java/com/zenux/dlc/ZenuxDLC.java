package com.zenux.dlc;

import com.zenux.dlc.module.ModuleManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZenuxDLC implements ClientModInitializer {
    public static final String MOD_ID = "zenuxdlc";
    public static final Logger LOGGER = LoggerFactory.getLogger("ZenuxDLC");
    public static ModuleManager MODULE_MANAGER;

    @Override
    public void onInitializeClient() {
        MODULE_MANAGER = new ModuleManager();
        LOGGER.info("[Zenux DLC] loaded for 1.21.4 — modules: {}", MODULE_MANAGER.getModules().size());

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;
            MODULE_MANAGER.onTick();
        });
    }
}
