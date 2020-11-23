package me.minigamez.minigamez;

import me.minigamez.minigamez.Boards.GameMenu;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    GameMenu menus = new GameMenu();

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

            if (sender instanceof Player){
                Player player = (Player) sender;
                menus.openMainMenu(player);
            }else{
                sender.sendMessage("You need to be a player to do this command");
            }
        return true;


    }
}
