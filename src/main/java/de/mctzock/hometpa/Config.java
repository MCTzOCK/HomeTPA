/*
 * Copyright (c) 2020 Ben Siebert. All rights reserved.
 * Created on 13.12.2020
 */

package de.mctzock.hometpa;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(new File("./homes.yml"));

    public static void loadConfig(){
        if(!new File("./homes.yml").exists()){
            try {
                new File("./homes.yml").createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cfg = YamlConfiguration.loadConfiguration(new File("./homes.yml"));
    }

    public static void saveConfig(){
        try {
            cfg.save(new File("./homes.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
