package com.batmanatorul.zagron.api.item;

import com.batmanatorul.zagron.entity.LivingEntity;
import com.batmanatorul.zagron.items.ItemStack;
import com.batmanatorul.zagron.world.BlockState;
import com.batmanatorul.zagron.world.Level;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class DiggerItem extends TieredItem {

    private final float speed;
    private final float attackDamage;
    private final TagKey<Block> blocks;

    //Attributes

    public DiggerItem(float attackDamage, float attackSpeed, TagKey<Block> blocks, Tier tier, SpigotItemProperties spigotItemProperties) {
        super(tier, spigotItemProperties.durability(tier.getDurability()));

        this.speed = attackSpeed;
        this.attackDamage = attackDamage;
        this.blocks = blocks;
    }

    @Override
    public float getBreakSpeed(ItemStack itemStack, BlockState state) {
        return 0; //state.is(blocks) ? tier.getSpeed() : 1.0F;
    }

    @Override
    public void hurtEnemy(ItemStack itemStack, LivingEntity damager, LivingEntity attacked) {
        itemStack.hurt(2);
    }

    @Override
    public void mineBlock(ItemStack itemStack, Level level, BlockState block, LivingEntity livingEntity) {
        if (itemStack.getItem().getBreakSpeed(itemStack, block) != 0) {
            itemStack.hurt(1);
        }
    }

    @Override
    public Item getBaseItem() {
        return Items.DIAMOND_PICKAXE;
    }
}
