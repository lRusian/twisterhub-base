package me.jesusmx.twisthub.tablist.shared;

import me.jesusmx.twisthub.hub;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TabRunnable extends BukkitRunnable {

    private final TabHandler handler;

    /**
     * Constructor to make a new TabThread
     *
     * @param handler the handler to register it to
     */
    public TabRunnable(TabHandler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        for (Player player : hub.getInstance().getOnlinePlayers()) {
            this.handler.sendUpdate(player);
        }
    }
}