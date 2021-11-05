package net.melodicalbuild.maximusevents.doctor.commands;

import net.melodicalbuild.maximusevents.doctor.FirstEncounter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StartFirstEncounter implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!args[0].isEmpty()) {
            switch(args[0]) {
                case "start":
                    FirstEncounter.Begin(sender.getServer().getPlayer(sender.getName()));
                    return true;
                case "stop":
                    return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        if(args.length == 1) {
            commands.add("start");
            commands.add("stop");
            org.bukkit.util.StringUtil.copyPartialMatches(args[0], commands, completions);
        }
        Collections.sort(completions);
        return completions;
    }
}
