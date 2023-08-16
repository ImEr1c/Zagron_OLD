package com.batmanatorul.zagron.registry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SpigotRegistry<T extends IRegistryItem> {

    private final Map<String, T> byId = new HashMap<>();
    private final Map<T, String> toId = new HashMap<>();

    private SpigotRegistry() {
    }

    public static <T extends IRegistryItem> SpigotRegistry<T> createRegistry() {
        return new SpigotRegistry<>();
    }

    public T register(String id, T obj) {
        toId.put(obj, id);
        byId.put(id, obj);

        return obj;
    }

    public Collection<T> getValues() {
        return byId.values();
    }

    public Map<String, T> getMap() {
        return byId;
    }

    public T byId(String id) {
        return byId.get(id);
    }

    public String toId(T obj) {
        return toId.get(obj);
    }
}
