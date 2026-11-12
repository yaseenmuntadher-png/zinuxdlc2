package com.zenux.dlc.module;

import net.minecraft.client.MinecraftClient;

public abstract class Module {
    protected final MinecraftClient mc = MinecraftClient.getInstance();
    private final String name;
    private boolean enabled;

    public Module(String name) {
        this.name = name;
        this.enabled = false;
    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (this.enabled) onEnable();
        else onDisable();
    }

    protected void onEnable() {}
    protected void onDisable() {}
    public void onTick() {}

    public String getName() { return name; }
    public boolean isEnabled() { return enabled; }
}
