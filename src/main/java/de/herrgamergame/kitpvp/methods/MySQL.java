package de.herrgamergame.kitpvp.methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    public static String username;
    public static String password;
    public static String database;
    public static String port;
    public static String host;
    public static Connection con;


    public static void connect() {
        if (isConnected() == false) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,username,password);
                System.out.println("MySQL Connected!");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void disconnect() {
        if(isConnected()==true){
            try {
                con.close();
                System.out.println("MySQL Disconnected");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static boolean isConnected() {
        if (con != null) {
            return true;
        } else {
            return false;
        }
    }

    public static Connection getCon(){
        return con;
    }
}
