package net.melodicalbuild.maximusevents.doctor.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    public static boolean lockWorld = false;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        if(!event.getPlayer().getWorld().getName().equals("events")) {
            if(lockWorld) {
                Server server = Bukkit.getServer();
                server.dispatchCommand(server.getConsoleSender(), "mv tp " + event.getPlayer().getName() + " events");
                server.dispatchCommand(server.getConsoleSender(), "tp " + event.getPlayer().getName() + " -66 86 -108");
            }
        }
    }
}
