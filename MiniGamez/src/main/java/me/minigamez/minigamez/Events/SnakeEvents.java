package me.minigamez.minigamez.Events;


import me.minigamez.minigamez.Boards.SnakeGameBoard;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import java.util.Objects;


public class SnakeEvents implements Listener {

    Plugin plugin;

    public SnakeEvents(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onSnakeClick(InventoryClickEvent event){
        if (event.getView().getTitle().equals(ChatColor.AQUA+""+ChatColor.BOLD+"Game Menu")){
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            SnakeGameBoard gameBoard = new SnakeGameBoard(player,plugin);
            if(event.getCurrentItem() == null || event.getSlotType() == null || event.getCurrentItem().getType() == Material.AIR) {
                event.setCancelled(true);
                return;
            }
            else if (Objects.requireNonNull(event.getCurrentItem()).getType() != null){
                if (event.getCurrentItem().getItemMeta().hasDisplayName()){
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN+"Snake")){
                        player.closeInventory();
                        gameBoard.openSnake(player);
                    }
                }
            }
        }
    }


}
