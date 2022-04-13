package me.jesusmx.twisthub.listeners;

import me.jesusmx.twisthub.utils.CC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class DeveloperListener implements Listener {

    @EventHandler
    public void onDevJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getName().equals("JesusMX")) {
            player.sendMessage(CC.translate("&7&oThis server is using your hubcore"));
        }
    }
}
