package com.fxd927.msm.mixin;

import mekanism.common.item.gear.ItemMekaSuitArmor;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = ItemMekaSuitArmor.class, remap = false)
public class MixinItemMekSuitArmor {
    @Inject(method = "getDamageAbsorbed(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/damagesource/DamageSource;FLjava/util/List;)F", at = @At(value = "HEAD"), cancellable = true)
    private static void injectCustomDamageAbsorption(Player player, DamageSource source, float amount, @Nullable List<Runnable> energyUseCallbacks, CallbackInfoReturnable<Float> cir) {
        if (player.noPhysics == true && player.isInWall() == true) {
            cir.setReturnValue(1.0F);
        }
    }
}
