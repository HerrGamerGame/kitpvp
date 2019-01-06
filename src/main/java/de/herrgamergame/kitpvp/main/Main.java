package de.herrgamergame.kitpvp.main;

import de.herrgamergame.kitpvp.methods.MySQL;
import de.herrgamergame.kitpvp.methods.MySQLFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        super.onEnable();

        instance = this;
        System.out.println("[KitPvP] Online");

        MySQLFile file = new MySQLFile();


        file.readData();

        MySQL.connect();
        try {
            PreparedStatement ps = MySQL.getCon().prepareStatement("CREATE TABLE IF NOT EXISTS Stats(UUID VARCHAR(100), Spielername VARCHAR(100), Kills INT(100), Deaths INT(100)");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();

        System.out.println("[KitPvP] Offline");

        MySQL.disconnect();
    }

}
