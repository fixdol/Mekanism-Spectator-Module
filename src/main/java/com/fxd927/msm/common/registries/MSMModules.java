package com.fxd927.msm.common.registries;

import com.fxd927.msm.common.MekanismSpectatorModule;
import com.fxd927.msm.common.content.gear.mekasuit.ModuleQuantumReconstructionUnit;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import net.minecraft.world.item.Rarity;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"})
public class MSMModules {

    public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister(MekanismSpectatorModule.MODID);

    public static final ModuleRegistryObject<ModuleQuantumReconstructionUnit> QUANTUM_RECONSTRUCTION_UNIT = MODULES.register("quantum_reconstruction", ModuleQuantumReconstructionUnit::new,
            () -> MSMItems.MODULE_QUANTUM_RECONSTRUCTION.asItem(), builder -> builder.rarity(Rarity.EPIC).handlesModeChange().modeChangeDisabledByDefault().disabledByDefault());


    private MSMModules() {
    }
}
