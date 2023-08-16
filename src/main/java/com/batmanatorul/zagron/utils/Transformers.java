package com.batmanatorul.zagron.utils;

import com.batmanatorul.zagron.ZagronKeys;
import com.batmanatorul.zagron.api.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class Transformers {
    public static ItemStack transformStack(com.batmanatorul.zagron.items.ItemStack itemStack) {
        ItemStack stack = new ItemStack(itemStack.getItem().getBaseItem(), itemStack.getCount());

        stack.getOrCreateTag().putString(ZagronKeys.ITEM_ID, Item.toId(itemStack.getItem()));
        stack.setDamageValue(itemStack.getDisplayDurability());

        return stack;
    }
}
