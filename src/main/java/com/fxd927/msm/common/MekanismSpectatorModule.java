package com.fxd927.msm.common;

import com.fxd927.msm.common.registries.MSMItems;
import com.fxd927.msm.common.registries.MSMModules;
import com.mojang.logging.LogUtils;
import mekanism.api.MekanismIMC;
import mekanism.common.Mekanism;
import mekanism.common.registries.MekanismCreativeTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@SuppressWarnings("removal")
@Mod(MekanismSpectatorModule.MODID)
public class MekanismSpectatorModule
{
    public static final String MODID = "msm";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MekanismSpectatorModule() {
        this(FMLJavaModLoadingContext.get());
    }

    public MekanismSpectatorModule(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::imcQueue);
        modEventBus.addListener(this::buildCreativeModeTabContents);

        MSMItems.ITEMS.register(modEventBus);
        MSMModules.MODULES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MekanismSpectatorModule.MODID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void imcQueue(InterModEnqueueEvent event)
    {
        MekanismIMC.addMekaSuitBodyarmorModules(MSMModules.QUANTUM_RECONSTRUCTION_UNIT);
    }

    private void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTab() == MekanismCreativeTabs.MEKANISM.get())
        {
            MSMItems.ITEMS.getAllItems().stream().forEach(event::accept);
        }

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
