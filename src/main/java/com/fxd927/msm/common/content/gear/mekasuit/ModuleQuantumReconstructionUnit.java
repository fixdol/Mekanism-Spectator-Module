package com.fxd927.msm.common.content.gear.mekasuit;

import com.fxd927.msm.common.MSMLang;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IModule;
import mekanism.common.config.MekanismConfig;
import mekanism.common.content.gear.mekasuit.ModuleInhalationPurificationUnit;
import mekanism.common.tags.MekanismTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ModuleQuantumReconstructionUnit implements ICustomModule<ModuleQuantumReconstructionUnit>
{
    private static final ModuleDamageAbsorbInfo INHALATION_ABSORB_INFO = new ModuleDamageAbsorbInfo(MekanismConfig.gear.mekaSuitMagicDamageRatio,
            MekanismConfig.gear.mekaSuitEnergyUsageMagicReduce);

    @Override
    public void tickServer(IModule<ModuleQuantumReconstructionUnit> module, Player player)
    {
        if (module.isEnabled() && !player.onGround()) {
            player.noPhysics = true;
        } else {
            player.noPhysics = false;
        }
    }

    @Override
    public void tickClient(IModule<ModuleQuantumReconstructionUnit> module, Player player)
    {
        this.tickServer(module, player);
    }

    @Nullable
    @Override
    public ModuleDamageAbsorbInfo getDamageAbsorbInfo(IModule<ModuleQuantumReconstructionUnit> module, DamageSource damageSource) {
        return damageSource.is(DamageTypes.IN_WALL) ? INHALATION_ABSORB_INFO : null;
    }

    @Override
    public boolean canChangeModeWhenDisabled(IModule<ModuleQuantumReconstructionUnit> module) {
        return true;
    }

    @Override
    public void changeMode(IModule<ModuleQuantumReconstructionUnit> module, Player player, ItemStack stack, int g, boolean displayChangeMessage)
    {
        module.toggleEnabled(player, MSMLang.MODULE_PHASE_THROUGH_BLOCKS.translate());
    }
}
