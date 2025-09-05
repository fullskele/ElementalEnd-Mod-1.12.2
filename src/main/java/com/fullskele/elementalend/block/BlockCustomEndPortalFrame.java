package com.fullskele.elementalend.block;

import net.minecraft.item.Item;

public class BlockCustomEndPortalFrame extends AbstractBlockEndPortalFrame {
    private final Item activationItem;

    public BlockCustomEndPortalFrame(Item activationItem) {
        this.activationItem = activationItem;
    }

    @Override
    protected Item getActivationItem() {
        return activationItem;
    }

}