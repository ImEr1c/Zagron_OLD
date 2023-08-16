package com.batmanatorul.zagron;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class ZagronKeys {

    public static String ITEM_ID;

    public static void init(JavaPlugin plugin) {
        ITEM_ID = register(plugin, "item_id");
    }

    private static String register(JavaPlugin plugin, String id) {
        return plugin.getName() + ":" + id;
    }
}
