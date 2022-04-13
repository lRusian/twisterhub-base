package me.jesusmx.twisthub;

import lombok.Getter;
import me.jesusmx.twisthub.commands.SetSpawnCommand;
import me.jesusmx.twisthub.commands.media.*;
import me.jesusmx.twisthub.permissions.PermissionCore;
import me.jesusmx.twisthub.permissions.type.*;
import me.jesusmx.twisthub.queues.QueueManager;
import me.jesusmx.twisthub.scoreboard.Assemble;
import me.jesusmx.twisthub.scoreboard.AssembleStyle;
import me.jesusmx.twisthub.scoreboard.ScoreboardProvider;
import me.jesusmx.twisthub.tablist.TablistProvider;
import me.jesusmx.twisthub.tablist.shared.TabHandler;
import me.jesusmx.twisthub.tablist.v1_7_R4.v1_7_R4TabAdapter;
import me.jesusmx.twisthub.tablist.v1_8_R3.v1_8_R3TabAdapter;
import me.jesusmx.twisthub.utils.files.ConfigFile;
import me.jesusmx.twisthub.utils.files.ScoreboardFile;
import me.jesusmx.twisthub.utils.files.TablistFile;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;

@Getter
public final class hub extends JavaPlugin {

    private QueueManager queueManager;
    private PermissionCore permissionCore;

    @Override
    public void onEnable() {
        this.commands();
        this.listeners();
        this.permissions();
        this.bungee();
        this.scoreboard();
        this.tablist();
        queueManager = new QueueManager();
    }

    private void scoreboard() {
        if (ScoreboardFile.getConfig().getBoolean("SCOREBOARD.ENABLED")) {
            Assemble assemble = new Assemble(this, new ScoreboardProvider());
            assemble.setTicks(2);
            assemble.setAssembleStyle(AssembleStyle.CUSTOM.descending(true).startNumber(16));
        }
    }

    private void permissions() {
        String system = ConfigFile.getConfig().getString("system.rank");
        switch (system) {
            case "AquaCore":
                permissionCore = new AquaCorePermissionCore();
                break;
            case "Vault":
                permissionCore = new VaultPermissionCore();
                break;
            case "Mizu":
                permissionCore = new MizuPermissionCore();
                break;
            case "Hestia":
                permissionCore = new HestiaPermissionCore();
                break;
            case "Zoom":
                permissionCore = new ZoomPermissionCore();
                break;
            case "Zoot":
                permissionCore = new ZootPermissionCore();
                break;
        }
    }

    private void commands() {
        new DiscordCommand();
        new StoreCommand();
        new TeamspeakCommand();
        new TelegramCommand();
        new TwitterCommand();
        new WebsiteCommand();
        new SetSpawnCommand();
    }

    private void listeners() {
    }

    private void bungee() {
    }

    private void tablist() {
        if (TablistFile.getConfig().getBoolean("tablist.enabled")) {
            if (Bukkit.getVersion().contains("1.7")) {
                new TabHandler(new v1_7_R4TabAdapter(), new TablistProvider(), this, 20L);
            }
            if (Bukkit.getVersion().contains("1.8")) {
                new TabHandler(new v1_8_R3TabAdapter(), new TablistProvider(), this, 20L);
            }
        }
    }

    @Override
    public void onDisable() {
    }

    public static hub getInstance() {
        return hub.getPlugin(hub.class);
    }
    public Collection<? extends Player> getOnlinePlayers() {
        Collection<Player> collection = new ArrayList<>();
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            collection.add(player);
        }
        return collection;
    }
}
