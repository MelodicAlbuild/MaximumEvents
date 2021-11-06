package net.melodicalbuild.maximusevents;

import net.melodicalbuild.maximusevents.classes.YamlConfig;
import net.melodicalbuild.maximusevents.doctor.commands.AsWagner;
import net.melodicalbuild.maximusevents.doctor.commands.ParticleTest;
import net.melodicalbuild.maximusevents.doctor.commands.StartFirstEncounter;
import net.melodicalbuild.maximusevents.passive.commands.CommandBloodMoon;
import net.melodicalbuild.maximusevents.passive.commands.CommandBossBarDrop;
import net.melodicalbuild.maximusevents.passive.listeners.BloodMoonListener;
import net.melodicalbuild.maximusevents.storyline.commands.AnnounceEventCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class MaximusEvents extends JavaPlugin {
    public static Plugin maxPlugin = Bukkit.getServer().getPluginManager().getPlugin("MaximusEvents");
    public YamlConfig config = new YamlConfig(this.getDataFolder(), "config.yml");
    public static boolean prerelease = false;
    public static String version = "";

    @Override
    public void onEnable() {
        // Versioning
        PluginDescriptionFile pdf = this.getDescription();
        version = pdf.getVersion();
        prerelease = version.contains("Pre");

        // Startup Logging
        Logger log = Bukkit.getLogger();

        if(prerelease) {
            log.warning(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_RED + "~~~ Maximus Warning ~~~");

            log.warning(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_RED + "The Maximus Events Plugin is currently in a Pre-Release Version: " + version);

            log.warning(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_RED + "Some Objects may be Unstable, Please Report all Bugs.");

            log.warning(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_RED + "The Most Recent Stable Version can be found at: " + ChatColor.WHITE + "https://github.com/MelodicAlbuild/MaximumEvents/releases/latest");

            log.warning(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_RED + "~~~~~~~~~~~~~~~~~~~~~~~");
        } else {
            log.info(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_AQUA + "~~~ Maximus Events ~~~");

            log.info(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_AQUA + "The Maximus Events Plugin is running in Version: " + version);

            log.info(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_AQUA + "Maximus Events Thanks you for your Download");

            log.info(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_AQUA + "The Most Recent Stable Version can be found at: " + ChatColor.WHITE + "https://github.com/MelodicAlbuild/MaximumEvents/releases/latest");

            log.info(ChatColor.GOLD + "[" + ChatColor.GREEN + "Maximus Events" + ChatColor.GOLD + "]" + ChatColor.WHITE + ": " + ChatColor.DARK_AQUA + "~~~~~~~~~~~~~~~~~~~~~~~");
        }

        //Other
        SetupConfig();

        //Commands
        Objects.requireNonNull(this.getCommand("bloodmoon")).setExecutor(new CommandBloodMoon());
        Objects.requireNonNull(this.getCommand("bossbardrop")).setExecutor(new CommandBossBarDrop());
        Objects.requireNonNull(this.getCommand("announceevent")).setExecutor(new AnnounceEventCommand());
        Objects.requireNonNull(this.getCommand("doctor")).setExecutor(new StartFirstEncounter());
        Objects.requireNonNull(this.getCommand("asdoctor")).setExecutor(new AsWagner());
        Objects.requireNonNull(this.getCommand("particletest")).setExecutor(new ParticleTest());

        //Listeners
        getServer().getPluginManager().registerEvents(new BloodMoonListener(this), this);
    }

    private void SetupConfig() {
        if(config.getConfig().get("VoidEventPosition") == null) {
            config.getConfig().set("VoidEventPosition", 0);
        }
    }

    @Override
    public void onDisable() {

    }
}
