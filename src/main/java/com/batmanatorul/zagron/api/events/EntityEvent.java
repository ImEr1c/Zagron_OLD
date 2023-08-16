package com.batmanatorul.zagron.api.events;

import com.batmanatorul.zagron.api.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EntityEvent extends Event {
    private static final HandlerList handlerList = new HandlerList();

    protected Entity entity;

    public EntityEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public static class EntityDeathEvent extends EntityEvent {

        public EntityDeathEvent(Entity entity) {
            super(entity);
        }
    }
}
