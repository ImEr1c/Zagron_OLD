package com.batmanatorul.zagron;

import com.batmanatorul.zagron.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = new Player((org.bukkit.entity.Player) sender);

        player.setItemInMainHand(Zagron.d.createItemStack());

        return true;
    }
}
