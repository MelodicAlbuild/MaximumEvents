package net.melodicalbuild.maximusevents;

import net.melodicalbuild.maximusevents.commands.CommandBloodMoon;
import net.melodicalbuild.maximusevents.listeners.BloodMoonListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class MaximusEvents extends JavaPlugin {
    public static Plugin maxPlugin = Bukkit.getServer().getPluginManager().getPlugin("MaximusEvents");
    @Override
    public void onEnable() {
        //Commands
        Objects.requireNonNull(this.getCommand("bloodmoon")).setExecutor(new CommandBloodMoon());

        //Listeners
        getServer().getPluginManager().registerEvents(new BloodMoonListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
