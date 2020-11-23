package me.minigamez.minigamez.Events;

import me.minigamez.minigamez.Boards.SnakeGameBoard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class MenuEvents implements Listener {
    Player player;
    Plugin plugin;

    public MenuEvents(Plugin plugin){
        this.plugin = plugin;
    }


    public  HashMap<Integer, ItemStack> playerItems = new HashMap<>();
    public int inventoryItemsCount;
    public SnakeGameBoard snakeGameBoard = new SnakeGameBoard(player,plugin);
    //saving and returning items to inventory
    @EventHandler
    public void onMenuStart(InventoryOpenEvent event){

        player = (Player) event.getPlayer();

        ItemStack[] items = player.getInventory().getContents();
        inventoryItemsCount = items.length;
        if (event.getView().getTitle().equals(ChatColor.AQUA+""+ChatColor.BOLD+"Game Menu")) {
            for (Integer i = 0; i < items.length; i++) {
                ItemStack item = items[i];
                            playerItems.put(i, item);
            }
            player.getInventory().clear();
            player.sendMessage("open");

        }
    }

    @EventHandler
    public void onMenuStop(InventoryCloseEvent event) {
        player = (Player) event.getPlayer();
        if (event.getView().getTitle().equals(ChatColor.AQUA+""+ChatColor.BOLD+"Game Menu")) {
            for (Integer i = 0; i < inventoryItemsCount; i++) {

                player.getInventory().setItem(i, playerItems.get(i));
            }
            player.sendMessage("Closed");
        }
    }


}
