package ru.mrbedrockpy.snowyard.customitem;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import ru.mrbedrockpy.snowyard.Plugin;

import java.util.List;

public abstract class CustomItem {

    protected CustomItem() {}

    public void useOnPlayer(PlayerInteractAtEntityEvent event) {}

    public void use(PlayerInteractEvent event) {}

    public final boolean is(ItemStack item) {
        if (item == null || item.getItemMeta() == null) return false;
        ItemMeta meta = item.getItemMeta();
        String name = meta.getPersistentDataContainer().get(getNamespacedKey(), PersistentDataType.STRING);
        if (name == null) return false;
        return name.equals(getName());
    }

    public final ItemStack getItemStack(int count) {
        if (count < 0) return null;
        if (count == 0) return new ItemStack(Material.AIR);
        ItemStack item = new ItemStack(getMaterial(), count);
        if (item.getItemMeta() == null) return null;
        item.getItemMeta().setDisplayName(getDisplayName());
        item.getItemMeta().setLore(getLore());
        return item;
    }

    public abstract String getName();

    public abstract String getDisplayName();

    public List<String> getLore() {
        return null;
    }

    public abstract Material getMaterial();

    public final NamespacedKey getNamespacedKey() {
        return new NamespacedKey(Plugin.getInstance(), "customitem");
    }

}
