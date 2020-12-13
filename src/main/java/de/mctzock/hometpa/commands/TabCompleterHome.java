/*
 * Copyright (c) 2020 Ben Siebert. All rights reserved.
 * Created on 13.12.2020
 */

package de.mctzock.hometpa.commands;

import de.mctzock.hometpa.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TabCompleterHome implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tab = new ArrayList<String>();
        Set<String> keys = Config.cfg.getConfigurationSection(sender.getName()).getKeys(false);
        for(String key : keys){
            tab.add(key);
        }
        return tab;
    }
}
