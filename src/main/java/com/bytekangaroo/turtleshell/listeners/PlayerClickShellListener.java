package com.bytekangaroo.turtleshell.listeners;

import com.bytekangaroo.turtleshell.utils.ShellManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Mark on 8/23/2018
 * Written for project TurtleShell
 * Please do not use or edit this code unless permission has been given (or if it's on GitHub...)
 * Contact me on Twitter, @Mobkinz78, with any questions
 * §
 */
public class PlayerClickShellListener implements Listener {

    ShellManager manager = ShellManager.getInstance();

    @EventHandler
    public void onShellClick(PlayerInteractEvent event){
        if(!(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) return;
        if(event.getHand().equals(EquipmentSlot.OFF_HAND)) return;
        if(!event.getItem().getType().equals(Material.TURTLE_HELMET)) return;

        Player player = event.getPlayer();
        ItemStack turtleShell = event.getItem();
        if(turtleShell.equals(manager.getSpecialShell())){
            event.setCancelled(true);
            manager.generateSmallShell(player);
        }
    }

}
