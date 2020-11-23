package me.minigamez.minigamez;

import me.minigamez.minigamez.Events.MenuEvents;
import me.minigamez.minigamez.Events.SnakeEvents;
import org.bukkit.plugin.java.JavaPlugin;

public  class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new MenuEvents(this),this);
        getServer().getPluginManager().registerEvents(new SnakeEvents(this),this);


        getCommand("minigamez").setExecutor(new Command());

    }


}
