package com.bytekangaroo.turtleshell.command;

import com.bytekangaroo.turtleshell.Main;
import com.bytekangaroo.turtleshell.utils.ShellManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Mark on 8/22/2018
 * Written for project HotSauce
 * Please do not use or edit this code unless permission has been given (or if it's on GitHub...)
 * Contact me on Twitter, @Mobkinz78, with any questions
 * §
 */
public class BaseCommand implements CommandExecutor {

    String prefix = Main.getInstance().getPrefix();
    ShellManager manager = ShellManager.getInstance();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(prefix + "Sorry, this command is only meant for players!");
            return true;
        }

        // TODO: Permissions! Also, flesh this out quite a bit...
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("turtleshell")){
            if(args.length == 0){
                player.sendMessage(prefix + "Please provide an argument!");
                return true;
            }
            if(args[0].equalsIgnoreCase("generate")){
                manager.generateSmallShell(player);
                return true;
            }
            if(args[0].equalsIgnoreCase("item")){
                player.getInventory().addItem(manager.getSpecialShell());
                return true;
            }
        }
        return true;
    }

}
