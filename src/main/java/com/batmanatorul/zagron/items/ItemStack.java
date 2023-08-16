package com.batmanatorul.zagron.items;

import com.batmanatorul.zagron.ZagronKeys;
import com.batmanatorul.zagron.api.item.Item;
import com.batmanatorul.zagron.entity.Entity;
import com.batmanatorul.zagron.entity.ItemEntity;
import com.batmanatorul.zagron.entity.LivingEntity;
import com.batmanatorul.zagron.entity.Player;
import com.batmanatorul.zagron.stuff.Hand;
import com.batmanatorul.zagron.utils.ItemUtil;
import com.batmanatorul.zagron.world.BlockState;
import com.batmanatorul.zagron.world.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.phys.BlockHitResult;

public class ItemStack {

    private final Component name;
    private final boolean vanilla;
    private final Item item;
    private int count;
    private int durability;
    private int displayDurability;

    public ItemStack(Item item) {
        this(item, 1);
    }

    public ItemStack(Item item, int count) {
        this.vanilla = false;
        this.item = item;
        this.count = count;
        this.name = new TextComponent(item.getDefaultName());
    }

    public ItemStack(org.bukkit.inventory.ItemStack stack) {
        this(ItemUtil.toNMS(stack));
    }

    public ItemStack(net.minecraft.world.item.ItemStack itemStack) {
        this.vanilla = !ItemUtil.isValidItem(itemStack);

        this.item = !vanilla ? Item.byId(itemStack.getTag().getString(ZagronKeys.ITEM_ID)) : null;

        this.count = itemStack.getCount();

        this.name = itemStack.getDisplayName();

    }

    public Item getItem() {
        return item;
    }

    public int getCount() {
        return count;
    }

    public void shrink(int i) {
        count = Math.min(0, count - i);
    }

    public void grow(int i) {
        count = Math.min(64, count + i);
    }

    public Component getName() {
        return name;
    }

    public void hurt(int i) {
        durability -= i;

        updateDurability();
    }

    public void setDurability(int durability) {
        this.durability = durability;

        updateDurability();
    }

    public int getDurability() {
        return durability;
    }

    public int getDisplayDurability() {
        return displayDurability;
    }

    private void updateDurability() {
        this.displayDurability = (int) (this.item.getDamageCoefficient() * this.durability);
    }

    //Events

    public void onItemEntityDestroyed(ItemEntity entity) {
        if (vanilla)
            return;

        item.onItemEntityDestroyed(entity);
    }

    public ItemStack use(Player player, Level world, Hand hand) {
        if (vanilla)
            return this;

        return item.use(player, world, this, hand);
    }

    public void useOn(Player player, Level world, Hand hand, BlockHitResult result) {
        if (vanilla)
            return;

        item.useOn(player, world, this, hand, result);
    }

    public boolean canAttackBlock(Player player, BlockState block, Hand hand, Level world) {
        if (vanilla)
            return true;

        return item.canAttackBlock(player, block, hand, this, world);
    }

    public void hurtEnemy(LivingEntity damager, LivingEntity attacked) {
        if (vanilla)
            return;

        item.hurtEnemy(this, damager, attacked);
    }

    public void mineBlock(Level world, BlockState block, LivingEntity livingEntity) {
        if (vanilla)
            return;

        item.mineBlock(this, world, block, livingEntity);
    }

    public void interactWithLivingEntity(Player player, LivingEntity livingEntity, Hand hand) {
        if (vanilla)
            return;

        item.interactWithLivingEntity(this, player, livingEntity, hand);
    }

    public boolean isCorrectToolForDrops(BlockState state) {
        if (vanilla)
            return true;

        return item.isCorrectToolForDrops(state);
    }

    public void onInventoryTick(Level level, Entity entity, int slot, boolean selected) {
        if (vanilla)
            return;

        item.onInventoryTick(this, level, entity, slot, selected);
    }

    public void onCraftedBy(Level level, Player player) {
        if (vanilla)
            return;

        item.onCraftedBy(this, level, player);
    }

    public boolean isVanilla() {
        return vanilla;
    }

    public boolean isEnchanted() {
        return false;
    }
}
