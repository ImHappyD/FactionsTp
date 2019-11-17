package it.opscrashed.dependences;

import it.opscrashed.factionstp;
import it.opscrashed.utils.utils;
import org.bukkit.Bukkit;

public class dependence extends utils {

    public dependence() {

        if(!Bukkit.getServer().getPluginManager().isPluginEnabled("Factions")){
            toConsole("&c[&aFactionsTp&c] Factions is required, disabling the plugin..");
            factionstp.getMClass().onDisable();
        }
    }
}
