package com.fullskele.elementalend.block;

import com.fullskele.elementalend.ElementalEnd;
import com.fullskele.elementalend.item.Items;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ElementalEnd.MOD_ID)
public class ModBlocks {

    /*
    Red Fire - Blue Water
    Yellow Lightning - Green Earth
    White Order - Black Chaos
    Pink Aether - Orange Nether
    Purple Magic - Gray Void
    LBlue Icy - Orange Arid
     */
    public static final BlockCustomEndPortalFrame FIRE_FRAME = new BlockCustomEndPortalFrame(Items.FIRE_EYE);
    public static final BlockCustomEndPortalFrame WATER_FRAME = new BlockCustomEndPortalFrame(Items.WATER_EYE);
    public static final BlockCustomEndPortalFrame LIGHTNING_FRAME = new BlockCustomEndPortalFrame(Items.LIGHTNING_EYE);
    public static final BlockCustomEndPortalFrame EARTH_FRAME = new BlockCustomEndPortalFrame(Items.EARTH_EYE);
    public static final BlockCustomEndPortalFrame ORDER_FRAME = new BlockCustomEndPortalFrame(Items.ORDER_EYE);
    public static final BlockCustomEndPortalFrame CHAOS_FRAME = new BlockCustomEndPortalFrame(Items.CHAOS_EYE);
    public static final BlockCustomEndPortalFrame AETHER_FRAME = new BlockCustomEndPortalFrame(Items.AETHER_EYE);
    public static final BlockCustomEndPortalFrame NETHER_FRAME = new BlockCustomEndPortalFrame(Items.NETHER_EYE);
    public static final BlockCustomEndPortalFrame MAGIC_FRAME = new BlockCustomEndPortalFrame(Items.MAGIC_EYE);
    public static final BlockCustomEndPortalFrame VOID_FRAME = new BlockCustomEndPortalFrame(Items.VOID_EYE);
    public static final BlockCustomEndPortalFrame ICY_FRAME = new BlockCustomEndPortalFrame(Items.ICY_EYE);
    public static final BlockCustomEndPortalFrame ARID_FRAME = new BlockCustomEndPortalFrame(Items.ARID_EYE);

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(
                FIRE_FRAME.setRegistryName("fire_frame").setTranslationKey(ElementalEnd.MOD_ID + ".fire_frame"),
                WATER_FRAME.setRegistryName("water_frame").setTranslationKey(ElementalEnd.MOD_ID + ".water_frame"),
                LIGHTNING_FRAME.setRegistryName("lightning_frame").setTranslationKey(ElementalEnd.MOD_ID + ".lightning_frame"),
                EARTH_FRAME.setRegistryName("earth_frame").setTranslationKey(ElementalEnd.MOD_ID + ".earth_frame"),
                ORDER_FRAME.setRegistryName("order_frame").setTranslationKey(ElementalEnd.MOD_ID + ".order_frame"),
                CHAOS_FRAME.setRegistryName("chaos_frame").setTranslationKey(ElementalEnd.MOD_ID + ".chaos_frame"),
                AETHER_FRAME.setRegistryName("aether_frame").setTranslationKey(ElementalEnd.MOD_ID + ".aether_frame"),
                NETHER_FRAME.setRegistryName("nether_frame").setTranslationKey(ElementalEnd.MOD_ID + ".nether_frame"),
                MAGIC_FRAME.setRegistryName("magic_frame").setTranslationKey(ElementalEnd.MOD_ID + ".magic_frame"),
                VOID_FRAME.setRegistryName("void_frame").setTranslationKey(ElementalEnd.MOD_ID + ".void_frame"),
                ICY_FRAME.setRegistryName("icy_frame").setTranslationKey(ElementalEnd.MOD_ID + ".icy_frame"),
                ARID_FRAME.setRegistryName("arid_frame").setTranslationKey(ElementalEnd.MOD_ID + ".arid_frame")
        );
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                new ItemBlock(FIRE_FRAME).setRegistryName("fire_frame").setTranslationKey(ElementalEnd.MOD_ID + ".fire_frame"),
                new ItemBlock(WATER_FRAME).setRegistryName("water_frame").setTranslationKey(ElementalEnd.MOD_ID + ".water_frame"),
                new ItemBlock(LIGHTNING_FRAME).setRegistryName("lightning_frame").setTranslationKey(ElementalEnd.MOD_ID + ".lightning_frame"),
                new ItemBlock(EARTH_FRAME).setRegistryName("earth_frame").setTranslationKey(ElementalEnd.MOD_ID + ".earth_frame"),
                new ItemBlock(ORDER_FRAME).setRegistryName("order_frame").setTranslationKey(ElementalEnd.MOD_ID + ".order_frame"),
                new ItemBlock(CHAOS_FRAME).setRegistryName("chaos_frame").setTranslationKey(ElementalEnd.MOD_ID + ".chaos_frame"),
                new ItemBlock(AETHER_FRAME).setRegistryName("aether_frame").setTranslationKey(ElementalEnd.MOD_ID + ".aether_frame"),
                new ItemBlock(NETHER_FRAME).setRegistryName("nether_frame").setTranslationKey(ElementalEnd.MOD_ID + ".nether_frame"),
                new ItemBlock(MAGIC_FRAME).setRegistryName("magic_frame").setTranslationKey(ElementalEnd.MOD_ID + ".magic_frame"),
                new ItemBlock(VOID_FRAME).setRegistryName("void_frame").setTranslationKey(ElementalEnd.MOD_ID + ".void_frame"),
                new ItemBlock(ICY_FRAME).setRegistryName("icy_frame").setTranslationKey(ElementalEnd.MOD_ID + ".icy_frame"),
                new ItemBlock(ARID_FRAME).setRegistryName("arid_frame").setTranslationKey(ElementalEnd.MOD_ID + ".arid_frame")
        );
    }
}