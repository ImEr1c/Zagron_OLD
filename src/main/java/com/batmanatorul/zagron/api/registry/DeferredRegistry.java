package com.batmanatorul.zagron.api.registry;

import com.batmanatorul.zagron.registry.IRegistryItem;
import com.batmanatorul.zagron.registry.SpigotRegistry;

import java.util.HashMap;
import java.util.Map;

public class DeferredRegistry<T extends IRegistryItem> {

    private boolean finished;
    private final String id;
    private final SpigotRegistry<T> registry;
    private final Map<String, T> map = new HashMap<>();

    private DeferredRegistry(String id, SpigotRegistry<T> registry) {
        this.id = id;
        this.registry = registry;
    }

    public static <T extends IRegistryItem> DeferredRegistry<T> create(SpigotRegistry<T> registry, String id) {
        return new DeferredRegistry<>(id, registry);
    }

    public void register(String id, T obj) {

        if (finished)
            throw new RuntimeException("Deferred Registry already finished");

        this.map.put(id, obj);
    }

    public void finish() {
        this.finished = true;
        map.forEach((s, t) -> {
            registry.register(id + ":" + s, t);
        });
    }

}
