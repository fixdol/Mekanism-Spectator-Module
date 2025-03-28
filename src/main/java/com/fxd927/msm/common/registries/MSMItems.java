package com.fxd927.msm.common.registries;

import com.fxd927.msm.common.MekanismSpectatorModule;
import mekanism.common.item.ItemModule;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;

public class MSMItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismSpectatorModule.MODID);

    public static final ItemRegistryObject<ItemModule> MODULE_QUANTUM_RECONSTRUCTION = ITEMS.registerModule(MSMModules.QUANTUM_RECONSTRUCTION_UNIT);

    private MSMItems(){
    }
}
