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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommandHomes implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            sender.sendMessage(HomeTpa.prefix + "Deine Homes:");
            String msg = "";
            Set<String> keys = Config.cfg.getConfigurationSection(sender.getName()).getKeys(false);
            for(String key : keys){
                msg += key + ",";
            }
            sender.sendMessage(msg);
        }else {
            sender.sendMessage(HomeTpa.prefix + "Du musst ein Spieler sein!");
        }
        return true;
    }
}
