package net.melodicalbuild.maximusevents.doctor.commands;

import net.melodicalbuild.maximusevents.doctor.listeners.PlayerChatControl;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MuteChatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        PlayerChatControl.chatEnabled = !PlayerChatControl.chatEnabled;
        // See if the chatEnabled boolean is true if it is print the string 'Unmuted the chat' if not then 'Muted the chat'
        sender.sendMessage(ChatColor.GREEN + (PlayerChatControl.chatEnabled ? "Unmuted the chat" : "Muted the chat"));
        Server server = Bukkit.getServer();
        if(!PlayerChatControl.chatEnabled) {
            String message = "&6[&1Head Scientist&6] &fDr.Wagner has Silenced the Summons Room.";
            server.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
        } else {
            server.broadcastMessage(sender.getName() + " has Opened the Summons Room to Conversation.");
        }
        return true;
    }
}
