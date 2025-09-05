package com.fullskele.elementalend.drops;

import com.fullskele.elementalend.item.Items;
import net.minecraft.entity.monster.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class ItemDropEvents {

    private static final Random RAND = new Random();

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntityLiving().world.isRemote) return;

        if (event.getEntityLiving() instanceof EntityElderGuardian) {
            event.getEntityLiving().entityDropItem(new ItemStack(Items.WATER_EYE), 0);
        }

        if (event.getEntityLiving() instanceof EntityCreeper) {
            EntityCreeper creeper = (EntityCreeper) event.getEntityLiving();
            if (creeper.getPowered()) {
                event.getEntityLiving().entityDropItem(new ItemStack(Items.LIGHTNING_EYE), 0);
            }
        }

        if (event.getEntityLiving() instanceof EntityWitch && RAND.nextFloat() < 0.04f) {
            event.getEntityLiving().entityDropItem(new ItemStack(Items.CHAOS_EYE), 0);
        }

        if (event.getEntityLiving() instanceof EntityEvoker) {
            event.getEntityLiving().entityDropItem(new ItemStack(Items.MAGIC_EYE), 0);
        }

        if (event.getEntityLiving() instanceof EntityStray && RAND.nextFloat() < 0.02f) {
            event.getEntityLiving().entityDropItem(new ItemStack(Items.ICY_EYE), 0);
        }

        if (event.getEntityLiving() instanceof EntityHusk && RAND.nextFloat() < 0.02f) {
            event.getEntityLiving().entityDropItem(new ItemStack(Items.ARID_EYE), 0);
        }
    }


    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        String name = event.getName().toString();

        if (name.equals("minecraft:chests/nether_bridge")) {
            addSingleChanceLoot(event, Items.FIRE_EYE, 2);
        }

        if (name.equals("minecraft:chests/jungle_temple")) {
            addSingleChanceLoot(event, Items.EARTH_EYE, 17);
        }

        if (name.equals("minecraft:chests/abandoned_mineshaft")) {
            addSingleChanceLoot(event, Items.VOID_EYE, 2);
        }
    }

    private static void addSingleChanceLoot(LootTableLoadEvent event, Item item, int weight) {
        LootPool pool = event.getTable().getPool("main");
        if (pool != null) {
            LootFunction[] functions = new LootFunction[]{
                    new SetCount(new LootCondition[0], new RandomValueRange(1, 1))
            };

            pool.addEntry(new LootEntryItem(
                    item,
                    weight,
                    0,
                    functions,
                    new LootCondition[0],
                    item.getRegistryName().toString()
            ));
        }
    }
}