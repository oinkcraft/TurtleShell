package com.bytekangaroo.turtleshell.utils;


import com.bytekangaroo.turtleshell.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mark on 8/23/2018
 * Written for project TurtleShell
 * Please do not use or edit this code unless permission has been given (or if it's on GitHub...)
 * Contact me on Twitter, @Mobkinz78, with any questions
 * §
 */
public class ShellManager {

    private static ShellManager instance = new ShellManager();
    private String prefix = Main.getInstance().getPrefix();

    private ShellManager(){

    }

    // Seconds value for clearing the shell
    int seconds = 20 * Main.getInstance().getConfig().getInt("shell-duration");

    // ArrayLists for each material
    private HashMap<Player, ArrayList<Location>> limeGlassBlocks = new HashMap<Player, ArrayList<Location>>();
    private HashMap<Player, ArrayList<Location>> greenGlassBlocks = new HashMap<Player, ArrayList<Location>>();
    private HashMap<Player, ArrayList<Location>> limeConcreteBlocks = new HashMap<Player, ArrayList<Location>>();
    private HashMap<Player, ArrayList<Location>> greenConcreteBlocks = new HashMap<Player, ArrayList<Location>>();


    public static ShellManager getInstance(){
        return instance;
    }

    /* Layer 1 */
    private void createFirstLayer(Player player, World world, int ORIGIN_X, int ORIGIN_Y, int ORIGIN_Z){
        int x = ORIGIN_X;
        int y = ORIGIN_Y;
        int z = ORIGIN_Z;
        // No change needed to Y as it is the base layer

        // Edit x value sides
        // Positive
        greenGlassBlocks.get(player).add(new Location(world, x+3, y, z));
        greenConcreteBlocks.get(player).add(new Location(world, x+3, y, z+1));
        greenConcreteBlocks.get(player).add(new Location(world, x+3, y, z-1));
        greenConcreteBlocks.get(player).add(new Location(world, x+2, y, z+2));
        greenConcreteBlocks.get(player).add(new Location(world, x+2, y, z-2));
        // Negative
        greenGlassBlocks.get(player).add(new Location(world, x-3, y, z));
        greenConcreteBlocks.get(player).add(new Location(world, x-3, y, z+1));
        greenConcreteBlocks.get(player).add(new Location(world, x-3, y, z-1));
        greenConcreteBlocks.get(player).add(new Location(world, x-2, y, z+2));
        greenConcreteBlocks.get(player).add(new Location(world, x-2, y, z-2));
        // Edit z value sides
        // Positive
        greenGlassBlocks.get(player).add(new Location(world, x, y, z+3));
        greenConcreteBlocks.get(player).add(new Location(world, x+1, y, z+3));
        greenConcreteBlocks.get(player).add(new Location(world, x-1, y, z+3));
        // Negative
        greenGlassBlocks.get(player).add(new Location(world, x, y, z-3));
        greenConcreteBlocks.get(player).add(new Location(world, x+1, y, z-3));
        greenConcreteBlocks.get(player).add(new Location(world, x-1, y, z-3));
    }

    /* Layer 2 */
    private void createSecondLayer(Player player, World world, int ORIGIN_X, int ORIGIN_Y, int ORIGIN_Z){
        int x = ORIGIN_X;
        int y = ORIGIN_Y;
        int z = ORIGIN_Z;
        // Increment y value by one
        y++;

        // Edit x value sides
        // Positive
        limeGlassBlocks.get(player).add(new Location(world, x+3, y, z));
        limeConcreteBlocks.get(player).add(new Location(world, x+3, y, z+1));
        limeConcreteBlocks.get(player).add(new Location(world, x+3, y, z-1));
        limeConcreteBlocks.get(player).add(new Location(world, x+2, y, z+2));
        limeConcreteBlocks.get(player).add(new Location(world, x+2, y, z-2));
        // Negative
        limeGlassBlocks.get(player).add(new Location(world, x-3, y, z));
        limeConcreteBlocks.get(player).add(new Location(world, x-3, y, z+1));
        limeConcreteBlocks.get(player).add(new Location(world, x-3, y, z-1));
        limeConcreteBlocks.get(player).add(new Location(world, x-2, y, z+2));
        limeConcreteBlocks.get(player).add(new Location(world, x-2, y, z-2));
        // Edit z value sides
        // Positive
        limeGlassBlocks.get(player).add(new Location(world, x, y, z+3));
        limeConcreteBlocks.get(player).add(new Location(world, x+1, y, z+3));
        limeConcreteBlocks.get(player).add(new Location(world, x-1, y, z+3));
        // Negative
        limeGlassBlocks.get(player).add(new Location(world, x, y, z-3));
        limeConcreteBlocks.get(player).add(new Location(world, x+1, y, z-3));
        limeConcreteBlocks.get(player).add(new Location(world, x-1, y, z-3));
    }

    /* Layer 3 */
    private void createThirdLayer(Player player, World world, int ORIGIN_X, int ORIGIN_Y, int ORIGIN_Z){
        int x = ORIGIN_X;
        int y = ORIGIN_Y;
        int z = ORIGIN_Z;
        // Increment Y by 2
        y += 2;

        // Green Glass
        greenGlassBlocks.get(player).add(new Location(world, x, y, z));
        greenGlassBlocks.get(player).add(new Location(world, x+1, y, z));
        greenGlassBlocks.get(player).add(new Location(world, x-1, y, z));
        greenGlassBlocks.get(player).add(new Location(world, x, y, z+1));
        greenGlassBlocks.get(player).add(new Location(world, x, y, z-1));

        // Green concrete
        greenConcreteBlocks.get(player).add(new Location(world, x+2, y, z));
        greenConcreteBlocks.get(player).add(new Location(world, x+2, y, z+1));
        greenConcreteBlocks.get(player).add(new Location(world, x+2, y, z-1));
        greenConcreteBlocks.get(player).add(new Location(world, x+1, y, z+1));
        greenConcreteBlocks.get(player).add(new Location(world, x+1, y, z-1));


        greenConcreteBlocks.get(player).add(new Location(world, x-2, y, z));
        greenConcreteBlocks.get(player).add(new Location(world, x-2, y, z+1));
        greenConcreteBlocks.get(player).add(new Location(world, x-2, y, z-1));
        greenConcreteBlocks.get(player).add(new Location(world, x-1, y, z+1));
        greenConcreteBlocks.get(player).add(new Location(world, x-1, y, z-1));


        greenConcreteBlocks.get(player).add(new Location(world, x, y, z+2));
        greenConcreteBlocks.get(player).add(new Location(world, x+1, y, z+2));
        greenConcreteBlocks.get(player).add(new Location(world, x-1, y, z+2));


        greenConcreteBlocks.get(player).add(new Location(world, x, y, z-2));
        greenConcreteBlocks.get(player).add(new Location(world, x+1, y, z-2));
        greenConcreteBlocks.get(player).add(new Location(world, x-1, y, z-2));

    }

    // TODO: Change the check for the block being AIR to replacing the object in the HashMap with the material of the block replaced.
    private void generateBlocks(Player player, HashMap<Player, ArrayList<Location>> limeGlassBlocks, HashMap<Player, ArrayList<Location>> greenGlassBlocks, HashMap<Player, ArrayList<Location>> limeConcreteBlocks, HashMap<Player, ArrayList<Location>> greenConcreteBlocks) {
        for(Location bl : limeGlassBlocks.get(player)){
            if(bl.getBlock().getType().equals(Material.AIR)) {
                bl.getBlock().setType(Material.GREEN_STAINED_GLASS);
            }
        }
        for(Location bl : greenGlassBlocks.get(player)){
            if(bl.getBlock().getType().equals(Material.AIR)) {
                bl.getBlock().setType(Material.LIME_STAINED_GLASS);
            }
        }
        for(Location bl : limeConcreteBlocks.get(player)){
            if(bl.getBlock().getType().equals(Material.AIR)) {
                bl.getBlock().setType(Material.GREEN_CONCRETE);
            }

        }
        for(Location bl : greenConcreteBlocks.get(player)){
            if(bl.getBlock().getType().equals(Material.AIR)) {
                bl.getBlock().setType(Material.LIME_CONCRETE);
            }
        }
    }

    // Create the shell! (Yes, it's hardcoded in)
    public void generateSmallShell(Player player){

        // Define variables
        Location location = player.getLocation();
        World world = location.getWorld();
        final int ORIGIN_X = location.getBlockX();
        final int ORIGIN_Y = location.getBlockY();
        final int ORIGIN_Z = location.getBlockZ();

        // Put player in each hashmap, huzzah!
        limeGlassBlocks.put(player, new ArrayList<Location>());
        greenGlassBlocks.put(player, new ArrayList<Location>());
        limeConcreteBlocks.put(player, new ArrayList<Location>());
        greenConcreteBlocks.put(player, new ArrayList<Location>());

        // Create layers of shell
        createFirstLayer(player, world, ORIGIN_X, ORIGIN_Y, ORIGIN_Z);
        createSecondLayer(player, world, ORIGIN_X, ORIGIN_Y, ORIGIN_Z);
        createThirdLayer(player, world, ORIGIN_X, ORIGIN_Y, ORIGIN_Z);


        // Generate blocks
        generateBlocks(player, greenGlassBlocks, limeGlassBlocks, greenConcreteBlocks, limeConcreteBlocks);
        player.sendMessage(prefix + "Your turtle shell has been created!");
        player.sendMessage(prefix + "Careful, it will disappear in " + ChatColor.GREEN + ChatColor.BOLD + seconds / 20 + ChatColor.getLastColors(prefix) + " seconds!");

        // Set timer to clear the shell
        ShellClearTimer shellClearTimer = new ShellClearTimer(player);
        shellClearTimer.runTaskLater(Main.getInstance(), seconds);
    }

    // Remove the shell
    public void clearSmallShell(Player player){

        // Reset the blocks in the HashMap
        clearBlocks(player, greenGlassBlocks, limeGlassBlocks, greenConcreteBlocks, limeConcreteBlocks);

        // Remove player from the HashMaps
        limeGlassBlocks.remove(player);
        greenGlassBlocks.remove(player);
        limeConcreteBlocks.remove(player);
        greenConcreteBlocks.remove(player);
        player.sendMessage(prefix + "Your Turtle Shell has been cleared!");
    }

    // TO-DO: Just reset it to the material in the HashMap, if you followed the TO-DO ABOVE
    private void clearBlocks(Player player, HashMap<Player, ArrayList<Location>> limeGlassBlocks, HashMap<Player, ArrayList<Location>> greenGlassBlocks, HashMap<Player, ArrayList<Location>> limeConcreteBlocks, HashMap<Player, ArrayList<Location>> greenConcreteBlocks) {
        for(Location bl : limeGlassBlocks.get(player)){
            if(bl.getBlock().getType().equals(Material.GREEN_STAINED_GLASS)) {
                bl.getBlock().setType(Material.AIR);
            }
        }
        for(Location bl : greenGlassBlocks.get(player)){
            if(bl.getBlock().getType().equals(Material.LIME_STAINED_GLASS)) {
                bl.getBlock().setType(Material.AIR);
            }
        }
        for(Location bl : limeConcreteBlocks.get(player)){
            if(bl.getBlock().getType().equals(Material.GREEN_CONCRETE)) {
                bl.getBlock().setType(Material.AIR);
            }

        }
        for(Location bl : greenConcreteBlocks.get(player)){
            if(bl.getBlock().getType().equals(Material.LIME_CONCRETE)) {
                bl.getBlock().setType(Material.AIR);
            }
        }
    }

    // Get the special shell item
    public ItemStack getSpecialShell(){
        ItemStack specificShell = new ItemStack(Material.TURTLE_HELMET);
        specificShell.setAmount(1);
        ItemMeta specificShellMeta = specificShell.getItemMeta();
        specificShellMeta.setDisplayName("" + ChatColor.GREEN + ChatColor.BOLD + "TurtleShell Generator");
        specificShellMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 16, true);
        specificShell.setItemMeta(specificShellMeta);

        return specificShell;
    }

}

/* Failed attempt to create a sphere as the shell! I decided to go with a more custom approach */
    /*
    private void addToBlockLocations(Location location){
        blockLocatioks.put(location);
    }

    int radius = 12; //Main.getInstance().getConfig().getInt("radius");
    ArrayList<Location> blockLocations = new ArrayList<Location>();

    // Sphere Formula: V = (4/3)*pi*(r^3)
    public void makeShell(Location playerLocation){
        // Sphere math
        double pi = Math.PI;
        int r = radius;
        double v = (4.0/3.0) * pi * (Math.pow(r, 3));
        System.out.println(v);

        // Location stuff
        final Location centerLoc = playerLocation;
        addToBlockLocations(centerLoc);

        generateSphere(blockLocations, centerLoc, radius);
    }

    private void generateCircle(ArrayList<Location> blockLocations){
        for(Location location : blockLocations){
            location.getBlock().setType(Material.PURPLE_WOOL);
        }
    }

    private void generateSphere(ArrayList<Location> blockLocations, Location centerLoc, int radius){

        // Base coordinate values
        World world = centerLoc.getWorld();
        int xVal = centerLoc.getBlockX();
        int yVal = centerLoc.getBlockY();
        int zVal = centerLoc.getBlockZ();

        final int permRadius = radius;
        final int topYVal = yVal + radius;
        final int bottomYVal = yVal - radius;
        for(int i = yVal; i < topYVal; i++){
            // Add coordinates for center y value
            addCircleCoords(world, xVal, yVal, zVal, radius);

            radius--;
            yVal++;
        }

        radius = permRadius;

        // Generate the sphere, circle by circle
        generateCircle(blockLocations);
        System.out.println("Success... please?");
    }

    private void addCircleCoords(World world, int x0, int levelY, int z0, int radius) {
        int x = radius-1;
        int z = 0;
        int dx = 1;
        int dy = 1;
        int err = dx - (radius << 1);

        while (x >= z)
        {
            addToBlockLocations(new Location(world, x0 + x, levelY, z0 + z));
            addToBlockLocations(new Location(world, x0 + z, levelY, z0 + x));
            addToBlockLocations(new Location(world, x0 - z, levelY, z0 + x));
            addToBlockLocations(new Location(world, x0 - x, levelY, z0 + z));
            addToBlockLocations(new Location(world, x0 - x, levelY, z0 - z));
            addToBlockLocations(new Location(world, x0 - z, levelY, z0 - x));
            addToBlockLocations(new Location(world, x0 + z, levelY, z0 - x));
            addToBlockLocations(new Location(world, x0 + x, levelY, z0 - z));

            if (err <= 0) {
                z++;
                err += dy;
                dy += 2;
            }

            if (err > 0) {
                x--;
                dx += 2;
                err += dx - (radius << 1);
            }
        }
    }
    */