package com.bytekangaroo.turtleshell.command;

import com.bytekangaroo.turtleshell.Main;
import com.bytekangaroo.turtleshell.utils.ShellManager;
import org.bukkit.ChatColor;
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

        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("turtleshell")){
            if(!player.hasPermission("turtleshell.use.command")){
                player.sendMessage(prefix + "Sorry, you don't have permission to do that.\n" +
                        prefix + "Required Permission: " + ChatColor.RED + "turtleshell.use.command");
                return true;
            }
            if(args.length == 0){
                player.sendMessage(prefix + "Please provide an argument!");
                player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell generate" + ChatColor.GRAY + " - Creates a shell.");
                player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell item" + ChatColor.GRAY + " - Spawns shell item.");
                player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell reload" + ChatColor.GRAY + " - Reloads the configuration.");
                return true;
            }
            if(args.length > 1){
                player.sendMessage(prefix + "Ahh! Too many arguments!");
                player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell generate" + ChatColor.GRAY + " - Creates a shell.");
                player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell item" + ChatColor.GRAY + " - Spawns shell item.");
                player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell reload" + ChatColor.GRAY + " - Reloads the configuration.");
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
            if(args[0].equalsIgnoreCase("reload")){
                if(!player.hasPermission("turtleshell.reload")){
                    player.sendMessage(prefix + "Sorry, that's an admin command!" + ChatColor.RED + " turtleshell.reload");
                    return true;
                }
                Main.getInstance().reloadConfig();
                manager.resetConfigProperties();
                player.sendMessage(prefix + ChatColor.GREEN + "Configuration reloaded!");
                player.sendMessage(prefix + ChatColor.GRAY + "Shell Duration: " + ChatColor.GREEN + ChatColor.BOLD + Main.getInstance().getConfig().getInt("shell-duration"));
                return true;
            }

            player.sendMessage(prefix + "Argument not recognized!");
            player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell generate" + ChatColor.GRAY + " - Creates a shell.");
            player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell item" + ChatColor.GRAY + " - Spawns shell item.");
            player.sendMessage(prefix + ChatColor.GREEN + "/turtleshell reload" + ChatColor.GRAY + " - Reloads the configuration.");
        }
        return true;
    }

}
