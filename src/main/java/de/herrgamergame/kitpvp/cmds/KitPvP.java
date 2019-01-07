package de.herrgamergame.kitpvp.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KitPvP implements CommandExecutor {


    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;

        if(strings.length==0){
            //TODO Help
        }

        if(strings.length==1){
            //TODO Join, Leave, Setspawn, Set Kits
        }


        return false;
    }
}
