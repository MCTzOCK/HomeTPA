package de.mctzock.hometpa;

import de.mctzock.hometpa.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomeTpa extends JavaPlugin {

    public static String prefix = "[§4§lSystem§r] ";

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("tpa").setExecutor(new CommandTpa());
        getCommand("tpaccept").setExecutor(new CommandTpaccept());
        getCommand("home").setExecutor(new CommandHome());
        getCommand("sethome").setExecutor(new CommandSetHome());
        getCommand("homes").setExecutor(new CommandHomes());
        getCommand("home").setTabCompleter(new TabCompleterHome());
        getCommand("delhome").setExecutor(new CommandDelHome());
        getCommand("delhome").setTabCompleter(new TabCompleterHome());
        Config.loadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
