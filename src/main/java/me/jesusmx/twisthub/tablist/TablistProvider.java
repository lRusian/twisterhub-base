package me.jesusmx.twisthub.tablist;

import me.clip.placeholderapi.PlaceholderAPI;
import me.jesusmx.twisthub.tablist.shared.entry.TabElement;
import me.jesusmx.twisthub.tablist.shared.entry.TabElementHandler;
import me.jesusmx.twisthub.utils.CC;
import me.jesusmx.twisthub.utils.files.TablistFile;
import org.bukkit.entity.Player;
import java.util.Arrays;
import java.util.List;


public class TablistProvider implements TabElementHandler {

    @Override
    public TabElement getElement(Player player) {
        TabElement element = new TabElement();
        element.setHeader(CC.translate(TablistFile.getConfig().getString("tablist.header").replace("<line>", "\n")));
        element.setFooter(CC.translate(TablistFile.getConfig().getString("tablist.footer").replace("<line>", "\n")));
        List list = Arrays.asList((Object[])new String[]{"left", "middle", "right", "far-right"});
        for (int i = 0; i < 4; ++i) {
            String s = (String)list.get(i);
            for (int l = 0; l < 20; ++l) {
                element.add(i, l, PlaceholderAPI.setPlaceholders(player, TablistFile.getConfig().getString(String.valueOf(new StringBuilder().append("tablist.").append(s).append(".").append(l + 1)))
                        .replaceAll("<player>", player.getDisplayName())));
            }
        }
        return element;
    }
}