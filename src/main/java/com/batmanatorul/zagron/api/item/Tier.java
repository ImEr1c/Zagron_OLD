package com.batmanatorul.zagron.api.item;

import com.batmanatorul.zagron.items.ItemStack;

public interface Tier {
    int getDurability();

    float getSpeed();

    float getAttackDamageBonus();

    int getLevel();

    int getEnchantmentValue();

    Item getRepairItem();
}
