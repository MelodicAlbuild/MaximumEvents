package net.melodicalbuild.maximusevents.commands;

import net.melodicalbuild.maximusevents.MaximusEvents;
import net.melodicalbuild.maximusevents.events.BloodMoonEvent;
import net.melodicalbuild.maximusevents.listeners.BloodMoonListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

public class CommandBloodMoon implements CommandExecutor {
    private static final BloodMoonEvent bloodmoonEvent = new BloodMoonEvent();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Objects.requireNonNull(Bukkit.getWorld("world")).getTime() >= 12040) {
            String message = "&cYou can only schedule the event: &4Bloodmoon&c before the time change at 12040 Ticks...";
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
            return true;
        } else {
            BloodMoonListener.EventEnabled = false;
            Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MaximusEvents");
            assert plugin != null;
            Logger logger = Bukkit.getLogger();

            String message = "&3[&aMaximus Events&3]&f: &4Bloodmoon&f Scheduled for the next Night.";
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(Objects.requireNonNull(Bukkit.getServer().getWorld("world")).getTime() >= 12020) {
                        Bukkit.getPluginManager().callEvent(bloodmoonEvent);
                        this.cancel();
                    }
                }
            }.runTaskTimer(plugin, 0, 600);
            return true;
        }
    }

}
