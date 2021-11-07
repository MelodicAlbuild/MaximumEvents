package net.melodicalbuild.maximusevents.doctor.commands;

import net.citizensnpcs.api.CitizensAPI;
import net.melodicalbuild.maximusevents.doctor.FirstEncounter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class Test implements CommandExecutor {
    public double xloc = -56.771;
    public int i = 0;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        World world = Bukkit.getWorld("events");

        FirstEncounter.wagner = CitizensAPI.getNPCRegistry().getById(0);
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MaximusEvents");
        assert plugin != null;
        FirstEncounter.wagner.getNavigator().setTarget(new Location(world, xloc, 86, -104.949));
        Bukkit.getLogger().info("" + FirstEncounter.wagner.getEntity().getLocation());
        return true;
    }
}
