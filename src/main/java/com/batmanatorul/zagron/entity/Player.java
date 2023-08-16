package com.batmanatorul.zagron.entity;

import com.batmanatorul.zagron.world.Level;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;

public class Player extends LivingEntity {

    public Player(org.bukkit.entity.Player player) {
        this(((CraftPlayer) player).getHandle());
    }

    public Player(net.minecraft.world.entity.player.Player entity) {
        super(entity);
    }

    public Level getLevel() {
        return new Level();
    }

    @Override
    public net.minecraft.world.entity.player.Player getHandle() {
        return (net.minecraft.world.entity.player.Player) super.getHandle();
    }
}
