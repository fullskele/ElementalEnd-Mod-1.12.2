package com.fullskele.elementalend.proxy;

import com.fullskele.elementalend.block.ModBlocks;
import com.fullskele.elementalend.item.Items;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit() {
    }

    @Override
    public void init() {}

    @Override
    public void postInit() {}

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.AETHER_FRAME),
                0,
                new ModelResourceLocation("elementalend:aether_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.ARID_FRAME),
                0,
                new ModelResourceLocation("elementalend:arid_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.CHAOS_FRAME),
                0,
                new ModelResourceLocation("elementalend:chaos_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.EARTH_FRAME),
                0,
                new ModelResourceLocation("elementalend:earth_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.FIRE_FRAME),
                0,
                new ModelResourceLocation("elementalend:fire_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.ICY_FRAME),
                0,
                new ModelResourceLocation("elementalend:icy_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.LIGHTNING_FRAME),
                0,
                new ModelResourceLocation("elementalend:lightning_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.MAGIC_FRAME),
                0,
                new ModelResourceLocation("elementalend:magic_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.NETHER_FRAME),
                0,
                new ModelResourceLocation("elementalend:nether_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.ORDER_FRAME),
                0,
                new ModelResourceLocation("elementalend:order_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.VOID_FRAME),
                0,
                new ModelResourceLocation("elementalend:void_frame", "inventory")
        );
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ModBlocks.WATER_FRAME),
                0,
                new ModelResourceLocation("elementalend:water_frame", "inventory")
        );
    }

    @SubscribeEvent
    public static void registerTextures(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(Items.AETHER_EYE, 0, new ModelResourceLocation(Items.AETHER_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.ARID_EYE, 0, new ModelResourceLocation(Items.ARID_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.CHAOS_EYE, 0, new ModelResourceLocation(Items.CHAOS_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.EARTH_EYE, 0, new ModelResourceLocation(Items.EARTH_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.FIRE_EYE, 0, new ModelResourceLocation(Items.FIRE_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.ICY_EYE, 0, new ModelResourceLocation(Items.ICY_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.LIGHTNING_EYE, 0, new ModelResourceLocation(Items.LIGHTNING_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.MAGIC_EYE, 0, new ModelResourceLocation(Items.MAGIC_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.NETHER_EYE, 0, new ModelResourceLocation(Items.NETHER_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.ORDER_EYE, 0, new ModelResourceLocation(Items.ORDER_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.VOID_EYE, 0, new ModelResourceLocation(Items.VOID_EYE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(Items.WATER_EYE, 0, new ModelResourceLocation(Items.WATER_EYE.getRegistryName(), "inventory"));
    }
}