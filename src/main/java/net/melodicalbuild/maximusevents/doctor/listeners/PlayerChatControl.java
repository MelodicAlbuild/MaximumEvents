package net.melodicalbuild.maximusevents.doctor.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatControl implements Listener {
    public static boolean chatEnabled = true;

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        if (!chatEnabled) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("Chat is currently Disabled...");
        }
    }
}
