package net.melodicalbuild.maximusevents.storyline.commands;

import net.melodicalbuild.maximusevents.titles.Titles;
import org.apache.commons.lang.NullArgumentException;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnnounceEventCommand implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Server server = Bukkit.getServer();
        if(args[0].isEmpty()) {
            throw new NullArgumentException("");
        } else if(args[0].equalsIgnoreCase("silent") && args[1] != null) {
            Titles.Storyline.Default.HiddenStart(server, args[1]);
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        if(args.length == 1) {
            commands.add("silent");
            org.bukkit.util.StringUtil.copyPartialMatches(args[0], commands, completions);
        }
        Collections.sort(completions);
        return completions;
    }
}
