package com.batmanatorul.zagron.stuff;

import net.minecraft.world.InteractionHand;
import org.bukkit.inventory.EquipmentSlot;

public enum Hand {
    MAIN_HAND,
    OFF_HAND;

    public static Hand fromEQSlot(EquipmentSlot equipmentSlot) {
        if (equipmentSlot == EquipmentSlot.HAND)
            return MAIN_HAND;
        else if (equipmentSlot == EquipmentSlot.OFF_HAND)
            return OFF_HAND;

        return null;
    }

    public static Hand fromNMS(InteractionHand hand) {
        return switch (hand) {
            case OFF_HAND -> OFF_HAND;
            case MAIN_HAND -> MAIN_HAND;
        };
    }
}
