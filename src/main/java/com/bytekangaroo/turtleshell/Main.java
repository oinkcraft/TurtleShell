package com.bytekangaroo.turtleshell;

import com.bytekangaroo.turtleshell.command.BaseCommand;
import com.bytekangaroo.turtleshell.listeners.PlayerClickShellListener;
import com.bytekangaroo.turtleshell.utils.ShellManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class Main extends JavaPlugin {

    // Generate a protective shell!
    private String prefix = "§8[§2Turtle§aShell§8]§7 ";

    private static Main main;

    @Override
    public void onEnable() {
        // Get the plugin manager
        PluginManager pm = Bukkit.getServer().getPluginManager();

        // Create configuration
        createConfig();

        // Register the Main instance
        main = this;

        // Register events
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerClickShellListener(), this);

        // Register commands
        getCommand("turtleshell").setExecutor(new BaseCommand());

        getLogger().log(Level.INFO, "TurtleShell v" + getDescription().getVersion() + " has successfully been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "TurtleShell v" + getDescription().getVersion() + " has successfully been disabled!");
    }

    public void createConfig() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        File file = new File(getDataFolder(), "config.yml");
        if (!file.exists()) {
            getLogger().log(Level.INFO, "No configuration found for TurtleShell " + getDescription().getVersion());
            saveDefaultConfig();
        } else {
            getLogger().log(Level.INFO, "Configuration found for TurtleShell v" + getDescription().getVersion() + "!");
        }
    }

    public static Main getInstance() {
        return main;
    }

    public String getPrefix() {
        return prefix;
    }
}