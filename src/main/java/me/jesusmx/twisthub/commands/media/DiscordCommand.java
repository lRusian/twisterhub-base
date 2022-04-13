package me.jesusmx.twisthub.commands.media;

import me.jesusmx.twisthub.hub;
import me.jesusmx.twisthub.utils.CC;
import me.jesusmx.twisthub.utils.files.ConfigFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordCommand implements CommandExecutor {

    public DiscordCommand() {
        hub.getInstance().getCommand("discord").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (ConfigFile.getConfig().getBoolean("commands.discord.enabled"))
            ConfigFile.getConfig().getStringList("commands.discord.lines").stream().map(CC::translate).forEach(sender::sendMessage);
        return true;
    }
}
