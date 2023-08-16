package com.batmanatorul.zagron.entity;

import com.batmanatorul.zagron.items.ItemStack;
import com.batmanatorul.zagron.utils.Transformers;
import net.minecraft.world.InteractionHand;

public class LivingEntity extends Entity {
    public LivingEntity(net.minecraft.world.entity.LivingEntity entity) {
        super(entity);
    }

    public void setItemInMainHand(ItemStack itemStack) {
        getHandle().setItemInHand(InteractionHand.MAIN_HAND, Transformers.transformStack(itemStack));
    }

    public ItemStack getItemInMainHand() {
        return new ItemStack(getHandle().getItemInHand(InteractionHand.MAIN_HAND));
    }

    @Override
    public net.minecraft.world.entity.LivingEntity getHandle() {
        return (net.minecraft.world.entity.LivingEntity) super.getHandle();
    }
}
