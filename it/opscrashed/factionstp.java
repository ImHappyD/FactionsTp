package it.opscrashed;

import it.opscrashed.commands.teleportCommand;
import it.opscrashed.commands.teleportHash;
import it.opscrashed.dependences.dependence;
import it.opscrashed.files.conf;
import it.opscrashed.files.config;
import it.opscrashed.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class factionstp extends JavaPlugin {

   private static factionstp instance;

    public static factionstp getMClass(){

        return instance;
    }

    public void onEnable(){

        instance = this;

        new conf();
        new config();
        new teleportHash();

        utils Utils = new utils();

        Bukkit.getServer().getPluginCommand("ftp").setExecutor(new teleportCommand());

        Utils.toConsole("&7[&aFactionsTp&7] Plugin enabled!");

        new dependence();


    }

    public void onDisable(){

        utils Utils = new utils();
        config conf = new config();
        conf.saveConfig();

        Utils.toConsole("&7[&aFactionsTp&7] Disabling the plugin..");
        Utils.toConsole("&7[&aFactionsTp&7] Plugin disabled!");
    }
}
