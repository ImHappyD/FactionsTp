package it.opscrashed.files;

import it.opscrashed.factionstp;
import it.opscrashed.utils.utils;

import java.io.*;

public class conf extends utils {

    private String path = factionstp.getMClass().getDataFolder().getAbsolutePath();

    public conf(){

        toConsole("&7[&aFactionsTp&7] Enabling plugin!");
        if(ifExists("")){
            createElement(false, "");
            toConsole("&7[&aFactionsTp&7] Creating plugin directory..");
        }
        if(ifExists("config.yml")){
            createElement(true, "config.yml");
            toConsole("&7[&aFactionsTp&7] Creating config file..");
            try {
                copy(factionstp.getMClass().getResource("config.yml"), new File(this.path+"/config.yml"));
            } catch (Exception e){
                toConsole("&c[&aFactionsTp&c] Error while creating config file!");
            }

        }
    }

    private boolean ifExists(String path){

        return !new File(this.path+"/"+path).exists();
    }

    private void createElement(Boolean file, String path){
        if(file) {
            if(ifExists(this.path+"/"+path)){
                try {
                    new File(this.path+"/"+path).createNewFile();
                } catch (Exception e){

                }
            }

        } else {
            if(ifExists(this.path+"/"+path)) {
                new File(this.path+"/"+path).mkdir();
            }
        }
    }
    private static void copy(InputStream source, File dest) throws IOException {
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = source.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            source.close();
            os.close();
        }
    }
}
