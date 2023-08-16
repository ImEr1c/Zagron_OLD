package com.batmanatorul.zagron.events;

import com.batmanatorul.zagron.api.events.EntityEvent;
import com.batmanatorul.zagron.entity.Entity;
import com.batmanatorul.zagron.entity.ItemEntity;
import com.batmanatorul.zagron.entity.LivingEntity;
import com.batmanatorul.zagron.entity.Player;
import com.batmanatorul.zagron.items.ItemStack;
import com.batmanatorul.zagron.stuff.Hand;
import com.batmanatorul.zagron.utils.transformers.EntityTransformer;
import com.batmanatorul.zagron.world.BlockState;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import org.bukkit.Bukkit;

public class Listener {

    public static void handleEntityDeath(ServerPlayer player, ClientboundRemoveEntitiesPacket packet) {

        net.minecraft.world.entity.Entity entity = player.getLevel().getEntity(packet.getEntityIds().getInt(0));

        Entity customEntity = EntityTransformer.transformEntity(entity);

        EntityEvent.EntityDeathEvent entityDeathEvent = new EntityEvent.EntityDeathEvent(customEntity);

        Bukkit.getPluginManager().callEvent(entityDeathEvent);

        if (customEntity instanceof ItemEntity item)
            item.getItemStack().onItemEntityDestroyed(item);
    }

    public static void handleEntityAttack(ServerPlayer player, ServerboundInteractPacket packet) {
        Entity target = EntityTransformer.transformEntity(packet.getTarget(player.getLevel()));

        if (!(target instanceof LivingEntity livingEntity))
            return;

        Player p = new Player(player);

        ItemStack itemStack = p.getItemInMainHand();

        itemStack.hurtEnemy(p, livingEntity);
    }

    public static void handleInteractWithLivingEntity(ServerPlayer player, ServerboundInteractPacket packet, InteractionHand hand) {

        Entity target = EntityTransformer.transformEntity(packet.getTarget(player.getLevel()));

        if (!(target instanceof LivingEntity livingEntity))
            return;

        Player p = new Player(player);

        ItemStack itemStack = p.getItemInMainHand();

        itemStack.interactWithLivingEntity(p, livingEntity, Hand.fromNMS(hand));

    }

    public static void handleUseItemStack(ServerPlayer player, ServerboundUseItemPacket packet) {

        Player p = new Player(player);

        ItemStack use = p.getItemInMainHand().use(p, p.getLevel(), Hand.fromNMS(packet.getHand()));

        p.setItemInMainHand(use);

    }

    public static void handleItemUseOn(ServerPlayer player, ServerboundUseItemOnPacket packet) {

        Player p = new Player(player);

        p.getItemInMainHand().useOn(p, p.getLevel(), Hand.fromNMS(packet.getHand()), packet.getHitResult());

    }

    public static void handleBlockBreak(ServerPlayer player, ClientboundBlockUpdatePacket packet) {

        Player p = new Player(player);

        ItemStack itemStack = p.getItemInMainHand();

        itemStack.mineBlock(p.getLevel(), new BlockState(packet.blockState.getBlock()), p);

    }

}
