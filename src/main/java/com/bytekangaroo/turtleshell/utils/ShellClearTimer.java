package com.bytekangaroo.turtleshell.utils;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Mark on 8/23/2018
 * Written for project TurtleShell
 * Please do not use or edit this code unless permission has been given (or if it's on GitHub...)
 * Contact me on Twitter, @Mobkinz78, with any questions
 * §
 */
public class ShellClearTimer extends BukkitRunnable {

    ShellManager manager = ShellManager.getInstance();
    Player player;

    public ShellClearTimer(Player player){
        this.player = player;
    }

    public void run(){
        manager.clearSmallShell(player);
    }

}
