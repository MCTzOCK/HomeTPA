/*
 * Copyright (c) 2020 Ben Siebert. All rights reserved.
 * Created on 13.12.2020
 */

package de.mctzock.hometpa.commands;

import de.mctzock.hometpa.HomeTpa;
import de.mctzock.hometpa.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTpaccept implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length == 0){
                try {
                    Player target = Util.tpas.get((Player) sender);
                    target.teleport(((Player) sender).getLocation());
                    Util.tpas.remove((Player) sender);
                }catch (NullPointerException ex){
                    sender.sendMessage(HomeTpa.prefix + "Du hast keine Anfragen!");
                }
            }else {
                sender.sendMessage(HomeTpa.prefix + "Bitte benutze /tpaccept ");
            }
        }else {
            sender.sendMessage(HomeTpa.prefix + "Du musst ein Spieler sein!");
        }
        return true;
    }
}
