package com.fullskele.elementalend;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public final class Config {

    public static Configuration instance;

    public static boolean minimalistMode;

    public static void preInit(File file) {
        instance = new Configuration(file);
        instance.load();
        load();
        if (instance.hasChanged()) {
            instance.save();
        }
    }

    private static void load() {
        minimalistMode = instance.get(
                "general",
                "minimalistMode",
                false,
                "Enable minimalist mode? True to remove all trades, chest loot, and monster drops for the Elemental Eyes (but not recipes)."
        ).getBoolean();
    }

    private Config() {}
}