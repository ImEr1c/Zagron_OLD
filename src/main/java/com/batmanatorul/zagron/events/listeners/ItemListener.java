package com.batmanatorul.zagron.events.listeners;

import com.batmanatorul.zagron.api.item.Item;
import com.batmanatorul.zagron.entity.LivingEntity;
import com.batmanatorul.zagron.entity.Player;
import com.batmanatorul.zagron.items.ItemStack;
import com.batmanatorul.zagron.stuff.Hand;
import com.batmanatorul.zagron.utils.ItemUtil;
import com.batmanatorul.zagron.utils.transformers.EntityTransformer;
import com.batmanatorul.zagron.world.BlockState;
import com.batmanatorul.zagron.world.Level;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_18_R2.inventory.CraftItemStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

public class ItemListener implements Listener {
    @EventHandler
    public void n(BlockDamageEvent event) {

        Player player = new Player(((CraftPlayer) event.getPlayer()).getHandle());

        ItemStack itemStack = new ItemStack(event.getItemInHand());

        //send event

        if (!itemStack.canAttackBlock(player, new BlockState(event.getBlock()), Hand.MAIN_HAND, player.getLevel())) {

            event.setCancelled(true);

        }

    }

    @EventHandler
    public void d(BlockBreakEvent event) {

        Player player = new Player(((CraftPlayer) event.getPlayer()).getHandle());

        ItemStack itemStack = player.getItemInMainHand();

        if (!itemStack.isCorrectToolForDrops(new BlockState(event.getBlock())))
            event.setDropItems(false);

    }

    public static void onTick(Server server) {
        server.getOnlinePlayers().forEach(player -> {
            int selectedSlot = player.getInventory().getHeldItemSlot();

            for (int i = 0; i < player.getInventory().getSize(); i++) {
                org.bukkit.inventory.ItemStack item = player.getInventory().getItem(i);

                if (ItemUtil.isValidItem(item)) {
                    Player p = new Player(player);

                    ItemStack itemStack = new ItemStack(item);

                    itemStack.onInventoryTick(p.getLevel(), p, i, selectedSlot == i);
                }
            }
        });
    }
}
