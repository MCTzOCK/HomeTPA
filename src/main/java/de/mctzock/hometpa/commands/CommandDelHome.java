/*
 * Copyright (c) 2020 Ben Siebert. All rights reserved.
 * Created on 13.12.2020
 */

package de.mctzock.hometpa.commands;

import de.mctzock.hometpa.Config;
import de.mctzock.hometpa.HomeTpa;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDelHome implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length == 0){
                sender.sendMessage(HomeTpa.prefix + "Bitte nutze /delhome <name>");
            }else {
                Config.cfg.set(sender.getName() + "." + args[0], null);
                Config.saveConfig();
                sender.sendMessage(HomeTpa.prefix + "Dein Zuhause wurde erfolgreich gelöscht!");
            }
        }else {
            sender.sendMessage(HomeTpa.prefix + "Du musst ein Spieler sein!");
        }
        return true;
    }
}
