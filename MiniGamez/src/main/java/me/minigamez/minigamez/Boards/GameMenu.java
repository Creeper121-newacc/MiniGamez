package me.minigamez.minigamez.Boards;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GameMenu {





    public void openMainMenu(Player player){
        Inventory mainMenu = Bukkit.createInventory(player,9,ChatColor.AQUA+""+ChatColor.BOLD+"Game Menu");



        //Snake
        ItemStack snake = new ItemStack(Material.GREEN_STAINED_GLASS);
        ItemMeta snakeMeta = snake.getItemMeta();
        snakeMeta.setDisplayName(ChatColor.GREEN+"Snake");
        snakeMeta.addEnchant(Enchantment.DAMAGE_ALL,3,true);
        List snakelore = new ArrayList();
        snakelore.add(ChatColor.BLUE+""+ChatColor.ITALIC+"Choose here to play Snake");
        snakeMeta.setLore(snakelore);
        snake.setItemMeta(snakeMeta);

        mainMenu.setItem(0,snake);


        player.openInventory(mainMenu);
    }
}
