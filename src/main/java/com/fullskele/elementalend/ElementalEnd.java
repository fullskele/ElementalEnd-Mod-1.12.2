package com.fullskele.elementalend;

import com.fullskele.elementalend.drops.ItemDropEvents;
import com.fullskele.elementalend.drops.VillagerTrades;
import com.fullskele.elementalend.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ElementalEnd.MOD_ID, name = "Elemental End Portal", version = "1.0", dependencies = "before:ee")
public class ElementalEnd {
    public static final String MOD_ID = "elementalend";

    @SidedProxy(clientSide = "com.fullskele.elementalend.proxy.ClientProxy",
            serverSide = "com.fullskele.elementalend.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.preInit(event.getSuggestedConfigurationFile());
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
        if (!Config.minimalistMode) {
            MinecraftForge.EVENT_BUS.register(VillagerTrades.class);
            MinecraftForge.EVENT_BUS.register(ItemDropEvents.class);
        }
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}