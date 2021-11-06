package net.melodicalbuild.maximusevents.doctor.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.logging.Logger;

public class AsWagner implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!args[0].isEmpty()) {
            Server server = Bukkit.getServer();
            String control = getFinalArg(args, 0);
            String message = "&6[&1Head Scientist&6] &fDr.Wagner: " + control;
            server.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));

            Logger logger = Bukkit.getLogger();
            logger.info(message);
            return true;
        } else {
            return false;
        }
    }

    public static String getFinalArg(final String[] args, final int start) {
        final StringBuilder bldr = new StringBuilder();
        for (int i = start; i < args.length; i++) {
            if (i != start) {
                bldr.append(" ");
            }
            bldr.append(args[i]);
        }
        return bldr.toString();
    }
}
