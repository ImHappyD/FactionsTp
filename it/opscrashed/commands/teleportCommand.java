package it.opscrashed.commands;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import it.opscrashed.files.config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class teleportCommand extends teleportHash implements CommandExecutor{

    private Player player;
    private String command;
    private FPlayer fp;
    private Faction faction;
    private Player teleporter;
    private ArrayList<Player> players;


    public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {

        command = cmd.getName().toLowerCase();

        if (command.equalsIgnoreCase("ftp")) {
            if (sender instanceof Player) {
                config conf = new config();
                player = (Player) sender;
                fp = FPlayers.getInstance().getByPlayer(player);

                if (fp.hasFaction()) {
                    faction = fp.getFaction();
                    if(args.length > 0){

                        if(args[0].equalsIgnoreCase("accept")){
                            if(hasPendingRequest(player)){
                                teleporter = getTeleporter(player);
                                player.teleport(teleporter);
                                player.sendMessage(conf.getPrefix()+" "+conf.getAccepted().replace("{player}", teleporter.getName()));
                                cancelTeleport(player);
                                return true;
                            } else {
                                player.sendMessage(conf.getPrefix()+" "+conf.getNoRequests());
                                return true;
                            }
                        } else if(args[0].equalsIgnoreCase("deny")){
                            if(hasPendingRequest(player)){
                                cancelTeleport(player);
                                player.sendMessage(conf.getPrefix()+" "+conf.getDenied());
                                return true;
                            } else {
                                player.sendMessage(conf.getPrefix()+" "+conf.getNoRequests());
                                return true;
                            }

                        } else if(args[0].equalsIgnoreCase("reload")){

                            if(player.hasPermission("factionstp.reload")){
                                conf.reloadConfig();
                                player.sendMessage(conf.getPrefix()+" "+conf.getReload());
                                return true;
                            } else {
                                player.sendMessage(conf.getPrefix()+" "+conf.getNoPerms());
                                return true;
                            }

                        } else if (args[0].equalsIgnoreCase("here")) {

                            if (!conf.isEnemylandActivate()) {

                                if(fp.isInEnemyTerritory()){
                                    player.sendMessage(conf.getPrefix() + " " + conf.getEnemylandMessage());
                                    return true;
                                }

                                if (faction.getOnlinePlayers().size() - 1 > 0) {
                                    players = faction.getOnlinePlayers();
                                    players.remove(player);
                                    teleport(players, player);
                                    return true;

                                } else {

                                    player.sendMessage(conf.getPrefix() + " " + conf.getNoMembers());
                                    return true;
                                }
                            } else {

                                if (faction.getOnlinePlayers().size() - 1 > 0) {
                                    players = faction.getOnlinePlayers();
                                    teleport(players, player);
                                    return true;

                                } else {

                                    player.sendMessage(conf.getPrefix() + " " + conf.getNoMembers());
                                    return true;
                                }

                            }

                        } else {

                            player.sendMessage(conf.getPrefix() + " " + conf.getNoArguments());
                            return true;
                        }
                    }

                    player.sendMessage(conf.getPrefix()+" "+conf.getUsage());
                    return true;

                } else {

                    player.sendMessage(conf.getPrefix() + " " + conf.getNoFaction());
                    return true;
                }

            } else {
                sender.sendMessage("§7[§aFactionsTp§7] Commands cant be executed by the console!");
                return true;
            }
        }
        return false;
    }

    private void teleport(ArrayList<Player> players, Player player) {
        config conf = new config();
        player.sendMessage(conf.getPrefix() + " " + conf.getSent());
        players.forEach((p) -> {

            p.sendMessage(conf.getPrefix() + " " + conf.getReceived().replace("{player}", player.getName()));
            addTeleport(p, player);
        });
    }
}