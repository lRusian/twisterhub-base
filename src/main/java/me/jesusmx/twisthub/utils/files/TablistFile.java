package me.jesusmx.twisthub.utils.files;

import me.jesusmx.twisthub.hub;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;


public class TablistFile extends YamlConfiguration {

    private File file;
    private static TablistFile config;

    public TablistFile() {
        file = new File(hub.getInstance().getDataFolder(), "tablist.yml");
        if(!file.exists()) hub.getInstance().saveResource("tablist.yml", false);
        this.reload();
    }

    public static TablistFile getConfig() {
        if(config == null) {
            config = new TablistFile();
        }
        return config;
    }

    public void save() {
        try {
            super.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            super.load(this.file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
