package ru.mrbedrockpy.snowyard.typeplayer;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypePlayer {

    RUSHER(
            "Rusher",
            Arrays.asList(),
            Material.FEATHER,
            Arrays.asList(),
            Arrays.asList(PotionEffectType.INCREASE_DAMAGE, PotionEffectType.SPEED)
    ),

    ARCHER(
            "Archer",
            Arrays.asList(),
            Material.BOW,
            Arrays.asList(),
            Arrays.asList(PotionEffectType.INCREASE_DAMAGE, PotionEffectType.SLOW)
    ),

    SNOWMAN(
            "Snowman",
            Arrays.asList(),
            Material.PUMPKIN,
            Arrays.asList(),
            Arrays.asList(PotionEffectType.DAMAGE_RESISTANCE, PotionEffectType.SLOW)
    ),

    SUPPORT(
            "Support",
            Arrays.asList(),
            Material.GOLDEN_APPLE,
            Arrays.asList(),
            Arrays.asList(PotionEffectType.SPEED, PotionEffectType.WEAKNESS)
    ),

    DEFENDER(
            "Defender",
            Arrays.asList(),
            Material.SHIELD,
            Arrays.asList(),
            Arrays.asList(PotionEffectType.DAMAGE_RESISTANCE, PotionEffectType.WEAKNESS)
    );

    private final String displayName;

    private final List<String> description;

    private final Material material;

    private final List<ItemStack> kit;

    private final List<PotionEffectType> effects;

    private final List<Player> players = new ArrayList<>();

    TypePlayer(String displayName, List<String> description, Material material, List<ItemStack> kit, List<PotionEffectType> effects) {
        this.displayName = displayName;
        this.description = description;
        this.material = material;
        this.kit = kit;
        this.effects = effects;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getDescription() {
        return description;
    }

    public Material getMaterial() {
        return material;
    }

    public List<ItemStack> getKit() {
        return kit;
    }

    public List<PotionEffectType> getEffects() {
        return effects;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
