package com.batmanatorul.zagron.entity;

import com.batmanatorul.zagron.items.ItemStack;

public class ItemEntity extends Entity {

    private final ItemStack itemStack;

    public ItemEntity(net.minecraft.world.entity.item.ItemEntity entity) {
        super(entity);

        this.itemStack = new ItemStack(entity.getItem());
    }

    @Override
    public net.minecraft.world.entity.item.ItemEntity getHandle() {
        return (net.minecraft.world.entity.item.ItemEntity) super.getHandle();
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
