package com.batmanatorul.zagron.api.item;

import com.batmanatorul.zagron.entity.Entity;
import com.batmanatorul.zagron.entity.ItemEntity;
import com.batmanatorul.zagron.entity.LivingEntity;
import com.batmanatorul.zagron.entity.Player;
import com.batmanatorul.zagron.items.ItemStack;
import com.batmanatorul.zagron.items.Rarity;
import com.batmanatorul.zagron.registry.IRegistryItem;
import com.batmanatorul.zagron.registry.Registry;
import com.batmanatorul.zagron.stuff.Hand;
import com.batmanatorul.zagron.world.BlockState;
import com.batmanatorul.zagron.world.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.BlockHitResult;
import org.bukkit.Material;

import static com.batmanatorul.zagron.items.Rarity.EPIC;
import static com.batmanatorul.zagron.items.Rarity.RARE;

public class Item implements IRegistryItem {

    private final int maxStackSize;
    private final int maxDamage;
    private float damageCoefficient;
    private final Rarity rarity;
    //Food properties
    private final boolean isFireResistant;
    private final String name;

    public static Item byId(String id) {
        return Registry.ITEMS.byId(id);
    }

    public static String toId(Item item) {
        return Registry.ITEMS.toId(item);
    }

    public Item(SpigotItemProperties spigotItemProperties) {
        this.maxDamage = spigotItemProperties.maxDamage;
        this.maxStackSize = spigotItemProperties.stackSize;
        this.rarity = spigotItemProperties.rarity;
        this.isFireResistant = spigotItemProperties.isFireResistant;
        this.name = spigotItemProperties.name;

        if (this.maxDamage != 0)
            this.damageCoefficient = this.getBaseItem().getMaxDamage() / this.maxDamage;
    }

    public ItemStack createItemStack() {
        return new ItemStack(this);
    }

    public void onItemEntityDestroyed(ItemEntity entity) {
    }

    public ItemStack use(Player player, Level level, ItemStack itemStack, Hand hand) {
        //if Food stuff eat else do this

        return itemStack;
    }

    public void useOn(Player player, Level level, ItemStack itemStack, Hand hand, BlockHitResult result) {
    }

    public boolean canAttackBlock(Player player, BlockState block, Hand hand, ItemStack itemStack, Level level) {
        return true;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void hurtEnemy(ItemStack itemStack, LivingEntity damager, LivingEntity attacked) {
    }

    public void mineBlock(ItemStack itemStack, Level level, BlockState block, LivingEntity livingEntity) {
    }

    public boolean isCorrectToolForDrops(BlockState state) {
        return false;
    }

    public void interactWithLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, Hand hand) {
    }

    public net.minecraft.world.item.Item getBaseItem() {
        return Items.FLINT;
    }

    public String getDefaultName() {
        return name;
    }

    public float getBreakSpeed(ItemStack stack, BlockState state) {
        return 1.0F;
    }

    public void onInventoryTick(ItemStack itemStack, Level level, Entity entity, int slot, boolean inHand) {
    }

    public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
    }

    public float getDamageCoefficient() {
        return damageCoefficient;
    }

    public Rarity getRarity(ItemStack itemStack) {
        if (!itemStack.isEnchanted()) {
            return rarity;
        } else {
            return switch (rarity) {
                case UNCOMMON, COMMON -> RARE;
                case RARE -> EPIC;
                default -> this.rarity;
            };
        }
    }

    public boolean isFireResistant() {
        return isFireResistant;
    }

    public static class SpigotItemProperties {
        int stackSize = 64;
        int maxDamage;
        Rarity rarity = Rarity.COMMON;
        //Food properties
        boolean isFireResistant;
        String name;

        public SpigotItemProperties stackSize(int stackSize) {
            if (stackSize > 64)
                throw new RuntimeException("Custom stack size can't be bigger than 64");
            else if (maxDamage > 0)
                throw new RuntimeException("Can't have both durability and stack size");
            else {
                this.stackSize = stackSize;
                return this;
            }
        }

        public SpigotItemProperties durability(int durability) {
            this.stackSize = 1;
            this.maxDamage = durability;
            return this;
        }

        public SpigotItemProperties rarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public SpigotItemProperties fireResistant() {
            this.isFireResistant = true;
            return this;
        }

        public SpigotItemProperties name(String name) {
            this.name = name;
            return this;
        }
    }

}
