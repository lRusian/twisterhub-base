package me.jesusmx.twisthub.scoreboard;

import me.clip.placeholderapi.PlaceholderAPI;
import me.jesusmx.twisthub.hub;
import me.jesusmx.twisthub.utils.CC;
import me.jesusmx.twisthub.utils.files.ScoreboardFile;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardProvider implements AssembleAdapter{

    @Override
    public String getTitle(Player player) {
        return CC.translate(ScoreboardFile.getConfig().getString("scoreboard.title"));
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> toReturn = new ArrayList<>();
        if (hub.getInstance().getQueueManager().inQueue(player)) {
            ScoreboardFile.getConfig().getStringList("scoreboard.in-queue").stream()
                    .map(CC::translate)
                    .map(line -> PlaceholderAPI.setPlaceholders(player, line))
                    .map(line -> line.replace("%rank%", hub.getInstance().getPermissionCore().getRank(player)))
                    .map(line -> line.replace("%coloredrank%", hub.getInstance().getPermissionCore().getRankColor(player)))
                    .map(line -> line.replace("%server-queue%", String.valueOf(hub.getInstance().getQueueManager().getQueueIn(player))))
                    .map(line -> line.replace("%position-queue%", String.valueOf(hub.getInstance().getQueueManager().getPosition(player))))
                    .map(line -> line.replace("%size-queue%", String.valueOf(hub.getInstance().getQueueManager().getInQueue(hub.getInstance().getQueueManager().getQueueIn(player)))))
                    .forEach(toReturn::add);
        } else {
            ScoreboardFile.getConfig().getStringList("scoreboard.default").stream()
                    .map(CC::translate)
                    .map(line -> PlaceholderAPI.setPlaceholders(player, line))
                    .map(line -> line.replace("%rank%", hub.getInstance().getPermissionCore().getRank(player)))
                    .map(line -> line.replace("%coloredrank%", hub.getInstance().getPermissionCore().getRankColor(player)))
                    .forEach(toReturn::add);
        }
        return toReturn;
    }
}