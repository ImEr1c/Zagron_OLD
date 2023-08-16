package com.batmanatorul.zagron.utils;

import com.batmanatorul.zagron.ZagronKeys;
import com.batmanatorul.zagron.api.item.Item;
import net.minecraft.world.item.ItemStack;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftItemStack;

public class ItemUtil {

    public static boolean isValidItem(org.bukkit.inventory.ItemStack stack) {
        return isValidItem(toNMS(stack));
    }

    public static boolean isValidItem(ItemStack stack) {
        return stack.hasTag() && stack.getTag().contains(ZagronKeys.ITEM_ID);
    }

    public static ItemStack toNMS(org.bukkit.inventory.ItemStack stack) {
        return CraftItemStack.asNMSCopy(stack);
    }

}
