package ru.mrbedrockpy.snowyard.typeplayer;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;
import ru.mrbedrockpy.snowyard.util.ChatUtil;
import ru.mrbedrockpy.snowyard.util.Menu;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.gui.structure.Structure;
import xyz.xenondevs.invui.item.ItemProvider;
import xyz.xenondevs.invui.item.builder.ItemBuilder;
import xyz.xenondevs.invui.item.impl.AbstractItem;
import xyz.xenondevs.invui.item.impl.SimpleItem;

public class ChoiceTypeMenu extends Menu {

    @Override
    protected String getTitle() {
        return ChatUtil.format("&aВыберите класс");
    }

    @Override
    protected Gui getGui() {
        return Gui.normal()
                .setStructure(new Structure(
                        "#########",
                        "#       #",
                        "# A C E #",
                        "#  B D  #",
                        "#       #",
                        "#########"
                ))
                .addIngredient('A', new ChoiceItem(TypePlayer.RUSHER))
                .addIngredient('B', new ChoiceItem(TypePlayer.SUPPORT))
                .addIngredient('C', new ChoiceItem(TypePlayer.SNOWMAN))
                .addIngredient('D', new ChoiceItem(TypePlayer.DEFENDER))
                .addIngredient('E', new ChoiceItem(TypePlayer.ARCHER))
                .addIngredient('#', new SimpleItem(new ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setDisplayName("")))
                .build();
    }

    public static class ChoiceItem extends AbstractItem {

        private final TypePlayer typePlayer;

        public ChoiceItem(TypePlayer typePlayer) {
            this.typePlayer = typePlayer;
        }

        @Override
        public ItemProvider getItemProvider() {
            return new ItemBuilder(typePlayer.getMaterial())
                    .setDisplayName(typePlayer.getDisplayName())
                    .addLoreLines(typePlayer.getDescription().toArray(new String[0]));
        }

        @Override
        public void handleClick(@NotNull ClickType clickType, @NotNull Player player, @NotNull InventoryClickEvent inventoryClickEvent) {
            typePlayer.addPlayer(player);
            player.closeInventory();
        }

    }
}
