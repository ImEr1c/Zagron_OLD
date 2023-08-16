package com.batmanatorul.zagron.entity;

public class Entity implements com.batmanatorul.zagron.api.entity.Entity {

    private final net.minecraft.world.entity.Entity entity;

    public Entity(net.minecraft.world.entity.Entity entity) {
        this.entity = entity;
    }

    public net.minecraft.world.entity.Entity getHandle() {
        return entity;
    }
}
