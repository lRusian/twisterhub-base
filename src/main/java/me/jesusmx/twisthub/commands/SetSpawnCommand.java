package me.jesusmx.twisthub.commands;

import me.jesusmx.twisthub.hub;
import me.jesusmx.twisthub.utils.CC;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

   public SetSpawnCommand() {
      hub.getInstance().getCommand("setspawn").setExecutor(this);
   }

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      Player player = (Player)sender;
      if (!player.hasPermission("hubcore.setspawn")) {
         player.sendMessage(CC.translate("&cYou dont have permission to use this command."));
         return false;
      } else {
         World world = player.getWorld();
         Location loc = player.getLocation();
         world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
         player.sendMessage(CC.translate("&aSuColoressfully set the spawn point."));
         return false;
      }
   }
}
