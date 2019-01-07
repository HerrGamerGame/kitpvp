package de.herrgamergame.kitpvp.events;

import de.herrgamergame.kitpvp.methods.MySQL;
import de.herrgamergame.kitpvp.methods.MySQLMethoden;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathKill implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Player killer = player.getKiller();
        int deahtsPlayer = MySQLMethoden.getDeaths(Bukkit.getServer().getOfflinePlayer(player.getName()).getUniqueId()) + 1;
        int killsPlayer = MySQLMethoden.getKills(Bukkit.getServer().getOfflinePlayer(killer.getName()).getUniqueId()) + 1;
        //UPDATE Deaths

        if(player.getKiller()instanceof  Player) {


            MySQLMethoden.update(Bukkit.getServer().getOfflinePlayer(player.getName()).getUniqueId(),player.getName(),MySQLMethoden.getKills(Bukkit.getServer().getOfflinePlayer(player.getName()).getUniqueId()),deahtsPlayer);

            //UPDATE Kills
            MySQLMethoden.update(Bukkit.getServer().getOfflinePlayer(killer.getName()).getUniqueId(),killer.getName(),killsPlayer,MySQLMethoden.getDeaths(Bukkit.getServer().getOfflinePlayer(killer.getName()).getUniqueId()));

        }else{
            MySQLMethoden.update(Bukkit.getServer().getOfflinePlayer(player.getName()).getUniqueId(),player.getName(),MySQLMethoden.getKills(Bukkit.getServer().getOfflinePlayer(player.getName()).getUniqueId()),deahtsPlayer);
        }


    }
}
