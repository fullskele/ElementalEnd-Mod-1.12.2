package com.fullskele.elementalend.drops;

import com.fullskele.elementalend.item.Items;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

import javax.annotation.Nonnull;
import java.util.Random;

public final class VillagerTrades {

    private VillagerTrades() {}

    @SubscribeEvent
    public static void onRegisterVillagers(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event) {

        VillagerRegistry.VillagerProfession priest = event.getRegistry().getValue(new ResourceLocation("minecraft:priest"));
        if (priest != null) {
            VillagerRegistry.VillagerCareer cleric = priest.getCareer(0);

            cleric.addTrade(4, new BackpackTrade());
        }


    }
    public static class BackpackTrade implements EntityVillager.ITradeList {

        @Override
        public void addMerchantRecipe(@Nonnull IMerchant merchant, @Nonnull MerchantRecipeList recipeList, @Nonnull Random random) {
            recipeList.add(new MerchantRecipe(new ItemStack(net.minecraft.init.Items.EMERALD, 20), new ItemStack(net.minecraft.init.Items.ENDER_PEARL, 1), new ItemStack(Items.ORDER_EYE)));
        }
    }
}