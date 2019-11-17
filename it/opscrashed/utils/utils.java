package it.opscrashed.utils;

import org.bukkit.Bukkit;

public class utils {

    public void toConsole(String text){

        Bukkit.getServer().getConsoleSender().sendMessage(text.replace('&', '§'));
    }
}
