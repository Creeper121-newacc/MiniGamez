package me.minigamez.minigamez.Boards;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Timer;
import java.util.TimerTask;

public class SnakeGameBoard {
    Player player;
    Plugin plugin;
    Timer timer;
    public SnakeGameBoard(Player player,Plugin plugin){
        this.player = player;
        this.plugin = plugin;
        timer = new Timer();
    }

    public Inventory gameBoard = Bukkit.createInventory(player,54,"Snake");
    public int snakePos = 31;
    public char direction = 'l';
    public int applsPos ;
    public boolean running = false;




    public void openSnake(Player player){
        ItemStack head = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta headMeta = head.getItemMeta();
        assert headMeta != null;
        headMeta.setDisplayName(ChatColor.BLUE+"Snake's Head");
        head.setItemMeta(headMeta);

        ItemStack body = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta bodyMeta = head.getItemMeta();
        bodyMeta.setDisplayName(ChatColor.BLUE+"Snake's body");
        body.setItemMeta(headMeta);

        gameBoard.setItem(31,head);
        gameBoard.setItem(snakePos-1,body);

        player.openInventory(gameBoard);
        startGame(head,body);
    }

    public void startGame(ItemStack snakeHead, ItemStack snakeBody){
        running = true;
        move(snakeHead,snakeBody);


    }
    public void move(ItemStack snakeHead, ItemStack snakeBody){



        TimerTask move = new TimerTask() {
            @Override
            public void run() {
                gameBoard.clear();
                synchronized (this) {
                    player.closeInventory();
                }
                snakePos+=1;
                if (hasCollided(snakePos)){
                    running= false;
                }

                gameBoard.setItem(snakePos, snakeHead);
                gameBoard.setItem(snakePos - 1, snakeBody);
                player.openInventory(gameBoard);
                if (running==false){
                    timer.cancel();
                }
            }
        };
        timer.schedule(move,0,1000);





    }

    public boolean hasCollided(int snakePos){
        if (direction=='l') {
            if (snakePos == 8) {
                return true;
            } else if (snakePos == 17){
                return true;
            }else if (snakePos==26){
                return true;
            }else if (snakePos==35){
                return true;
            }else if (snakePos==44){
                return true;
            }else return snakePos == 53;
        }else if (direction=='r'){
            if (snakePos == 0) {
                return true;
            } else if (snakePos == 9){
                return true;
            }else if (snakePos==18){
                return true;
            }else if (snakePos==27){
                return true;
            }else if (snakePos==36){
                return true;
            }else return snakePos == 45;
        }else if (direction=='u'){
            if (snakePos == 0) {
                return true;
            } else if (snakePos == 1){
                return true;
            }else if (snakePos==2){
                return true;
            }else if (snakePos==3){
                return true;
            }else if (snakePos==4){
                return true;
            }else if (snakePos==5){
                return true;
            }else if (snakePos==6){
                return true;
            }else if (snakePos==7){
                return true;
            }else return snakePos == 8;

        }else if (direction=='d'){
            if (snakePos == 45) {
                return true;
            } else if (snakePos == 46){
                return true;
            }else if (snakePos==47){
                return true;
            }else if (snakePos==48){
                return true;
            }else if (snakePos==49){
                return true;
            }else if (snakePos==50){
                return true;
            }else if (snakePos==51){
                return true;
            }else if (snakePos==52){
                return true;
            }else return snakePos == 53;
        }


        return false;
    }




}


