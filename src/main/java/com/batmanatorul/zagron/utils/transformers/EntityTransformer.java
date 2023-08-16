package com.batmanatorul.zagron.utils.transformers;

import com.batmanatorul.zagron.entity.Entity;
import com.batmanatorul.zagron.entity.ItemEntity;
import net.minecraft.world.entity.LivingEntity;

public class EntityTransformer {
    public static Entity transformEntity(net.minecraft.world.entity.Entity entity) {
        String id = entity.getType().getDescriptionId().replace("entity.minecraft.", "");

        Entity e = switch (id) {
            case "item" -> new ItemEntity((net.minecraft.world.entity.item.ItemEntity) entity);
            default -> null;
        };

        if (e == null) {
            if (entity instanceof LivingEntity)
                e = new com.batmanatorul.zagron.entity.LivingEntity((LivingEntity) entity);
            else
                e = new Entity(entity);
        }

        return e;
    }


}
