package ru.mrbedrockpy.snowyard.customitem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import ru.mrbedrockpy.snowyard.Plugin;

import java.util.ArrayList;
import java.util.List;

public final class CustomItemManager implements Listener {

    public static CustomItemManager MANAGER;

    private final List<CustomItem> items = new ArrayList<>();

    public CustomItemManager() {
        Plugin.getInstance().getServer().getPluginManager().registerEvents(this, Plugin.getInstance());
    }

    public void registerItem(CustomItem item) {
        items.add(item);
    }

    @EventHandler
    public void onUseOnPlayer(PlayerInteractEvent event) {
        if (event.getHand() == null) return;
        ItemStack stack = event.getPlayer().getInventory().getItem(event.getHand());
        items.forEach(item -> {if (item.is(stack)) item.use(event);});
    }

    @EventHandler
    public void onUseOnPlayer(PlayerInteractAtEntityEvent event) {
        ItemStack stack = event.getPlayer().getInventory().getItem(event.getHand());
        items.forEach(item -> {if (item.is(stack)) item.useOnPlayer(event);});
    }

}
