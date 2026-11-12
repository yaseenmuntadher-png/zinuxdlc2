package com.zenux.dlc.mixin;

import com.zenux.dlc.ZenuxDLC;
import com.zenux.dlc.module.Module;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class MixinClientPlayerEntity {

    @Inject(method = "tickMovement", at = @At("HEAD"))
    private void zenux$onTickMovement(CallbackInfo ci) {
        if (ZenuxDLC.MODULE_MANAGER == null) return;
        Module fly = ZenuxDLC.MODULE_MANAGER.getModule("Fly");
        if (fly != null && fly.isEnabled()) {
            ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
            player.getAbilities().flying = true;
            player.getAbilities().allowFlying = true;
        }
    }
}
