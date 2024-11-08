package ru.mrbedrockpy.snowyard.game;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import ru.mrbedrockpy.snowyard.Plugin;

import java.util.ArrayList;
import java.util.List;

public final class GameManager {

    public static final GameManager MANAGER = new GameManager();

    private final List<Player> players = new ArrayList<>();

    private final World world = Bukkit.getWorld("world");

    private final GameRunnable runnable = new GameRunnable();

    private GameManager() {}

    public void start() {
        log("Game starting...");
        this.players.addAll(Bukkit.getOnlinePlayers());
        this.runnable.runTaskTimer(Plugin.getInstance(), 0L, 20L);
        this.players.forEach(player -> {
            AttributeInstance healthAttribute = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
            if (healthAttribute == null) stop();
            healthAttribute.setBaseValue(60);
            player.setHealth(60);
        });
    }

    public void stop() {
        log("Game stopping...");
        this.runnable.cancel();
        this.players.clear();
    }

    private void log(String message) {
        Bukkit.getOperators().forEach(offlinePlayer -> {if (offlinePlayer.getPlayer() != null) offlinePlayer.getPlayer().sendMessage(message);});
    }

    public List<Player> getPlayers() {
        return players;
    }

    public World getWorld() {
        return world;
    }

    private class GameRunnable extends BukkitRunnable {

        @Override
        public void run() {

        }

    }

}
