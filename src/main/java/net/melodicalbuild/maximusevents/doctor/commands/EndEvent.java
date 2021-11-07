package net.melodicalbuild.maximusevents.doctor.commands;

import net.melodicalbuild.maximusevents.titles.Titles;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class EndEvent implements CommandExecutor {
    public int i = 0;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MaximusEvents");
        assert plugin != null;
        new BukkitRunnable() {
            @Override
            public void run() {
                switch(i) {
                    case 0:
                        Titles.Doctor.Default.Ending1(sender.getServer());
                        i++;
                        break;
                    case 1:
                        Titles.Doctor.Default.Ending2(sender.getServer());
                        i++;
                        break;
                    case 2:
                        Titles.Doctor.Default.Ending3(sender.getServer());
                        i++;
                        break;
                    case 3:
                        Titles.Doctor.Default.Ending4(sender.getServer());
                        i++;
                        break;
                    case 4:
                        this.cancel();
                        break;
                }
            }
        }.runTaskTimer(plugin, 0, 150);
        return false;
    }
}
