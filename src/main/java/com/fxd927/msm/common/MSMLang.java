package com.fxd927.msm.common;

import mekanism.api.text.ILangEntry;
import mekanism.common.Mekanism;
import net.minecraft.Util;

public enum MSMLang implements ILangEntry {
    MODULE_PHASE_THROUGH_BLOCKS("module", "phase_through_blocks");

    private final String key;

    MSMLang(String type, String path) {
        this(Util.makeDescriptionId(type, MekanismSpectatorModule.rl(path)));
    }

    MSMLang(String key) {
        this.key = key;
    }

    @Override
    public String getTranslationKey() {
        return key;
    }
}
