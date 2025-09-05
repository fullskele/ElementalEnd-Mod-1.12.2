package com.fullskele.elementalend.item;

import com.fullskele.elementalend.ElementalEnd;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class Items {

    public static final Item FIRE_EYE = new ItemEyeBase("fire_eye");
    public static final Item WATER_EYE = new ItemEyeBase("water_eye");
    public static final Item LIGHTNING_EYE = new ItemEyeBase("lightning_eye");
    public static final Item EARTH_EYE = new ItemEyeBase("earth_eye");
    public static final Item ORDER_EYE = new ItemEyeBase("order_eye");
    public static final Item CHAOS_EYE = new ItemEyeBase("chaos_eye");
    public static final Item AETHER_EYE = new ItemEyeBase("aether_eye");
    public static final Item NETHER_EYE = new ItemEyeBase("nether_eye");
    public static final Item MAGIC_EYE = new ItemEyeBase("magic_eye");
    public static final Item VOID_EYE = new ItemEyeBase("void_eye");
    public static final Item ICY_EYE = new ItemEyeBase("icy_eye");
    public static final Item ARID_EYE = new ItemEyeBase("arid_eye");

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                FIRE_EYE,
                WATER_EYE,
                LIGHTNING_EYE,
                EARTH_EYE,
                ORDER_EYE,
                CHAOS_EYE,
                AETHER_EYE,
                NETHER_EYE,
                MAGIC_EYE,
                VOID_EYE,
                ICY_EYE,
                ARID_EYE
        );
    }
}