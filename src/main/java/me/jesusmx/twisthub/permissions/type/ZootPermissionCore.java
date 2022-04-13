package me.jesusmx.twisthub.permissions.type;

import com.minexd.zoot.profile.Profile;
import me.jesusmx.twisthub.permissions.PermissionCore;
import org.bukkit.entity.Player;

public class ZootPermissionCore implements PermissionCore {

    @Override
    public String getRankColor(Player player) {
        return Profile.getByUuid(player.getUniqueId()).getActiveGrant().getRank().getColor().name();
    }

    @Override
    public String getRank(Player p) {
        return Profile.getByUuid(p.getUniqueId()).getActiveGrant().getRank().getDisplayName();
    }

}
