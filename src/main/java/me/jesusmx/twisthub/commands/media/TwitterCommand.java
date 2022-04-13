package me.jesusmx.twisthub.commands.media;

import me.jesusmx.twisthub.hub;
import me.jesusmx.twisthub.utils.CC;
import me.jesusmx.twisthub.utils.files.ConfigFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class TwitterCommand implements CommandExecutor {

    public TwitterCommand() {
        hub.getInstance().getCommand("twitter").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (ConfigFile.getConfig().getBoolean("commands.twitter.enabled"))
        ConfigFile.getConfig().getStringList("commands.twitter.lines").stream().map(CC::translate).forEach(sender::sendMessage);
        return true;
    }
}
