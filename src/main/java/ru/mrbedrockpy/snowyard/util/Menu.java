package ru.mrbedrockpy.snowyard.util;

import org.bukkit.entity.Player;
import xyz.xenondevs.invui.gui.Gui;
import xyz.xenondevs.invui.window.Window;

public abstract class Menu {

    protected abstract String getTitle();

    protected abstract Gui getGui();

    public final void open(Player player) {
        Window.single()
                .setTitle(getTitle())
                .setGui(getGui())
                .open(player);
    }

}
