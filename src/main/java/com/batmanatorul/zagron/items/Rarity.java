package com.batmanatorul.zagron.items;

import org.bukkit.ChatColor;

public enum Rarity {
    COMMON(ChatColor.WHITE),
    UNCOMMON(ChatColor.YELLOW),
    RARE(ChatColor.AQUA),
    EPIC(ChatColor.LIGHT_PURPLE);

    public final ChatColor color;

    Rarity(ChatColor color) {
        this.color = color;
    }
}
