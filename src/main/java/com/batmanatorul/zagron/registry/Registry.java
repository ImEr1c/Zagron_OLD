package com.batmanatorul.zagron.registry;

import com.batmanatorul.zagron.api.item.Item;

public class Registry {

    public static SpigotRegistry<Item> ITEMS = SpigotRegistry.createRegistry();

    public static <T extends IRegistryItem> T register(String id, SpigotRegistry<T> registry, T obj) {
        return registry.register(id, obj);
    }

}
