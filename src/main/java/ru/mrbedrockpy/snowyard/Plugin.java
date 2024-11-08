package ru.mrbedrockpy.snowyard;

import org.bukkit.plugin.java.JavaPlugin;
import ru.mrbedrockpy.snowyard.customitem.CustomItemManager;

public final class Plugin extends JavaPlugin {

    public static Plugin instance;

    @Override
    public void onEnable() {
        instance = this;
        CustomItemManager.MANAGER = new CustomItemManager();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Plugin getInstance() {
        return instance;
    }
}
