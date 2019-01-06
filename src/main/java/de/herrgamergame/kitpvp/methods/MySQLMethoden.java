package de.herrgamergame.kitpvp.methods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MySQLMethoden {

    public static boolean userExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getCon().prepareStatement("SELECT Spielername FROM Stats WHERE UUID = ?");
            ps.setString(1,uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static void update(UUID uuid, String name, Integer kills, Integer deaths){
        PreparedStatement ps;

        if(userExists(uuid)){
            //TODO UPDATA
            try {
                ps = MySQL.getCon().prepareStatement("UPDATE Stats SET Kills = ? AND Deats = ? WHERE UUID = ? ");
                ps.setInt(1,kills);
                ps.setInt(2,deaths);
                ps.setString(3,uuid.toString());
                ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else{
            //TODO Insert

            try {
                ps = MySQL.getCon().prepareStatement("INSERT INTO Stats(UUID, Spielername, Kills, Deaths) VALUES(?,?,?,?");
                ps.setString(1,uuid.toString());
                ps.setString(2,name);
                ps.setInt(3,kills);
                ps.setInt(4,deaths);
                ps.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
    public static Integer getKills(UUID uuid){
        PreparedStatement ps;

        try {
            ps = MySQL.getCon().prepareStatement("SELECT Kills FROM Stats WHERE UUID = ?");
            ps.setString(1,uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt("Kills");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public static Integer getDeaths(UUID uuid){
        PreparedStatement ps;

        try {
            ps = MySQL.getCon().prepareStatement("SLECET Deaths FROM Stats WHERE UUID = ?");
            ps.setString(1,uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getInt("Deaths");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
