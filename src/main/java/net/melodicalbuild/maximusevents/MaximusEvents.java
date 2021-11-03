package net.melodicalbuild.maximusevents;

import net.melodicalbuild.maximusevents.passive.commands.CommandBloodMoon;
import net.melodicalbuild.maximusevents.passive.commands.CommandBossBarDrop;
import net.melodicalbuild.maximusevents.passive.listeners.BloodMoonListener;
import net.melodicalbuild.maximusevents.storyline.commands.AnnounceEventCommand;
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
        Objects.requireNonNull(this.getCommand("bossbardrop")).setExecutor(new CommandBossBarDrop());
        Objects.requireNonNull(this.getCommand("announceevent")).setExecutor(new AnnounceEventCommand());

        //Listeners
        getServer().getPluginManager().registerEvents(new BloodMoonListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
