package me.jesusmx.twisthub.permissions.type;

import me.activated.core.plugin.AquaCoreAPI;
import me.jesusmx.twisthub.permissions.PermissionCore;
import org.bukkit.entity.Player;

public class AquaCorePermissionCore implements PermissionCore {

    @Override
    public String getRankColor(Player player) {
        return AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId()).getDisplayName();
    }

    @Override
    public String getRank(Player player) {
        return AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId()).getName();
    }
}
