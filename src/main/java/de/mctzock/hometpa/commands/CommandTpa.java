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

public class CommandTpa implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length == 0){
                sender.sendMessage(HomeTpa.prefix + "Bitte benutze /tpa <spieler>");
            }else {
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    target.sendMessage(HomeTpa.prefix + sender.getName() + " will sich zu dir teleportieren! Nutze /tpaccept um dies zu erlauben!");
                    sender.sendMessage(HomeTpa.prefix + "Die Anfrage wurde erfolgreich an " + target.getName() + " versendet!");
                    Util.tpas.put(target, (Player) sender);
                }catch (NullPointerException ex){
                    sender.sendMessage(HomeTpa.prefix + "Dieser Spieler wurde nicht gefunden!");
                }
            }
        }else {
            sender.sendMessage(HomeTpa.prefix + "Du musst ein Spieler sein!");
        }
        return true;
    }
}
