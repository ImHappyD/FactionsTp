package it.opscrashed.commands;

import org.bukkit.entity.Player;
import java.util.HashMap;

public class teleportHash {

    private HashMap<Player, Player> teleport;

    private HashMap<Player, Player> getHash(){

        return teleport;
    }

    public teleportHash(){

        teleport = new HashMap<>();
    }


    private void setHash(Player p, Player p2){

        this.teleport.put(p, p2);
    }

    public void addTeleport(Player p, Player teleporter){

        setHash(p, teleporter);
    }

    public Player getTeleporter(Player p){

        return getHash().get(p);
    }

    public void cancelTeleport(Player p){

        getHash().remove(p);
    }

    public boolean hasPendingRequest(Player p){

        return getHash().containsKey(p);
    }



}
