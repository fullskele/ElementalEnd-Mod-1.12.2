package com.fullskele.elementalend.item;

import com.fullskele.elementalend.ElementalEnd;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemEyeBase extends Item {

    public ItemEyeBase(String name) {
        setRegistryName(name);
        setTranslationKey(ElementalEnd.MOD_ID + "." + name);
        setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        String key = stack.getTranslationKey() + ".tooltip";
        if (I18n.canTranslate(key)) {
            tooltip.add(I18n.translateToLocal(key));
        }
    }
}