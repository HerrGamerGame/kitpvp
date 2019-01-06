package de.herrgamergame.kitpvp.methods;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class MySQLFile {

    public void setStandart(){
        FileConfiguration cfg = getFileConfiguration();

        cfg.options().copyDefaults(true);
        cfg.set("username","root");
        cfg.set("password","PW");
        cfg.set("database", "plugins");
        cfg.set("port","3306");
        cfg.set("host","localhost");

        try {
            cfg.save(getFile());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readData(){
        FileConfiguration cfg = getFileConfiguration();

        MySQL.username = cfg.getString("username");
        MySQL.password = cfg.getString("password");
        MySQL.database = cfg.getString("database");
        MySQL.port = cfg.getString("port");
        MySQL.host = cfg.getString("host");

    }

    private File getFile(){
        return new File("plugins/KitPvP","mysql.yml");
    }

    private FileConfiguration getFileConfiguration(){
        return YamlConfiguration.loadConfiguration(getFile());
    }
}
