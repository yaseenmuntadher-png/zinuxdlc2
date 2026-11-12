package com.zenux.dlc.module.impl;

import com.zenux.dlc.module.Module;

public class Fly extends Module {
    public Fly() { super("Fly"); }

    @Override
    public void onTick() {
        if (mc.player == null) return;

        if (mc.options.jumpKey.isPressed()) {
            mc.player.setVelocity(
                    mc.player.getVelocity().x,
                    0.5,
                    mc.player.getVelocity().z
            );
        }
        mc.player.fallDistance = 0f;
    }
}
