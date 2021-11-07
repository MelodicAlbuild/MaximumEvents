package net.melodicalbuild.maximusevents.doctor.commands;

import net.melodicalbuild.maximusevents.doctor.listeners.PlayerJoinListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LockServerWorld implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PlayerJoinListener.lockWorld = !PlayerJoinListener.lockWorld;
        return true;
    }
}
