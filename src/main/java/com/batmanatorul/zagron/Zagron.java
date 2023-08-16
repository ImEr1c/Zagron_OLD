package com.batmanatorul.zagron;

import com.batmanatorul.zagron.api.item.DiggerItem;
import com.batmanatorul.zagron.api.item.Item;
import com.batmanatorul.zagron.api.item.Tier;
import com.batmanatorul.zagron.entity.Player;
import com.batmanatorul.zagron.events.listeners.ItemListener;
import com.batmanatorul.zagron.items.ItemStack;
import com.batmanatorul.zagron.registry.Registry;
import com.batmanatorul.zagron.stuff.Hand;
import com.batmanatorul.zagron.world.BlockState;
import com.batmanatorul.zagron.world.Level;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import net.minecraft.tags.BlockTags;
import org.bukkit.plugin.java.JavaPlugin;

public final class Zagron extends JavaPlugin {

    private static Zagron Instance;
    public static Item d;

    @Override
    public void onEnable() {
        ZagronKeys.init(this);

        Instance = this;

        d = new DiggerItem(1, 1, BlockTags.STONE_BRICKS, new Tier() {
            @Override
            public int getDurability() {
                return 10;
            }

            @Override
            public float getSpeed() {
                return 0;
            }

            @Override
            public float getAttackDamageBonus() {
                return 0;
            }

            @Override
            public int getLevel() {
                return 0;
            }

            @Override
            public int getEnchantmentValue() {
                return 0;
            }

            @Override
            public Item getRepairItem() {
                return null;
            }
        }, new Item.SpigotItemProperties().name("salut"));

        Registry.register("salut", Registry.ITEMS, d);

        getServer().getPluginManager().registerEvents(new ItemListener(), this);


        getServer().getScheduler().runTaskTimer(this, () -> {
            ItemListener.onTick(getServer());
        }, 0, 0);


        ProtocolManager manager = ProtocolLibrary.getProtocolManager();

        getCommand("test").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {

    }

    public static Zagron getInstance() {
        return Instance;
    }
}
