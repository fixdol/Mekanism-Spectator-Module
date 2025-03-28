package com.fxd927.msm.common.content.gear.mekasuit;

import com.fxd927.msm.common.MSMLang;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IModule;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class ModuleQuantumReconstructionUnit implements ICustomModule<ModuleQuantumReconstructionUnit>
{
    @Override
    public void tickServer(IModule<ModuleQuantumReconstructionUnit> module, Player player)
    {
        if (!module.isEnabled()) {
            player.noPhysics = false;
        } else {
            player.noPhysics = true;
        }
    }

    @Override
    public void tickClient(IModule<ModuleQuantumReconstructionUnit> module, Player player)
    {
        this.tickServer(module, player);
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
