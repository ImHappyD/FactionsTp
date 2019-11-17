package it.opscrashed.files;

import it.opscrashed.factionstp;
import it.opscrashed.utils.utils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class config extends utils {

    private File file = new File(factionstp.getMClass().getDataFolder().getAbsolutePath()+"/config.yml");

    private FileConfiguration config;

    private String prefix;
    private String sent;
    private String received;
    private String accepted;
    private String denied;
    private String no_requests;

    private boolean enemy_land;
    private String enemy_land_tp;
    private String no_members;
    private String no_faction;
    private String no_arguments;
    private String cmd_usage;
    private String reload;
    private String no_perms;

    public config() {

        loadFile();

        prefix = getFile().getString("prefix").replace('&', '§');
        sent = getFile().getString("teleport-request.sent").replace('&', '§');
        received = getFile().getString("teleport-request.received").replace('&', '§');
        accepted = getFile().getString("teleport-request.accepted").replace('&', '§');
        denied = getFile().getString("teleport-request.denied").replace('&', '§');
        no_requests = getFile().getString("teleport-request.no-requests").replace('&', '§');

        enemy_land = getFile().getBoolean("Factions.teleport-in-enemy-land");
        enemy_land_tp = getFile().getString("Factions.teleport-in-enemy-land-disabled").replace('&', '§');
        no_members = getFile().getString("Factions.no-online-members").replace('&', '§');
        no_faction = getFile().getString("Factions.no-faction").replace('&', '§');
        no_arguments = getFile().getString("Factions.no-arguments").replace('&', '§');
        cmd_usage = getFile().getString("Factions.cmd-usage").replace('&', '§');
        reload = getFile().getString("Factions.reloaded").replace('&', '§');
        no_perms = getFile().getString("Factions.reload-no-perm").replace('&', '§');
    }

    public String getPrefix(){

        return prefix;
    }

    public String getSent(){

        return sent;
    }

    public String getReceived(){

        return received;
    }

    public String getAccepted(){

        return accepted;
    }

    public String getDenied(){

        return denied;
    }

    public String getNoRequests(){

        return no_requests;
    }

    public boolean isEnemylandActivate(){

        return enemy_land;
    }

    public String getEnemylandMessage() {

        return enemy_land_tp;
    }

    public String getNoMembers(){

        return no_members;
    }

    public String getNoFaction(){

        return no_faction;
    }

    public String getNoArguments(){

        return no_arguments;
    }

    public String getUsage(){
        return cmd_usage;
    }

    public String getReload(){
        return reload;
    }

    public String getNoPerms(){
        return no_perms;
    }

    private void loadFile(){

        config = YamlConfiguration.loadConfiguration(file);

    }

    private FileConfiguration getFile(){

        return config;
    }

    public void saveConfig(){

        config = YamlConfiguration.loadConfiguration(file);
    }
    public void reloadConfig(){

        config = YamlConfiguration.loadConfiguration(file);
    }

}
