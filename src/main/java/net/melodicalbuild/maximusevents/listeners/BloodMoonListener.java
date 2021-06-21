package net.melodicalbuild.maximusevents.listeners;

import net.melodicalbuild.maximusevents.MaximusEvents;
import net.melodicalbuild.maximusevents.events.BloodMoonEvent;
import net.melodicalbuild.maximusevents.runnables.BloodMoonEnd;
import net.melodicalbuild.maximusevents.titles.BloodMoonTitles;
import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;
import java.util.logging.Logger;

public class BloodMoonListener implements Listener{
    private final MaximusEvents plugin;
    public static boolean EventEnabled = false;

    public BloodMoonListener(MaximusEvents plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBloodMoonEvent(BloodMoonEvent event) throws InterruptedException {
        Server server = Bukkit.getServer();
        BloodMoonTitles.Starting(server);

        World world = Bukkit.getWorld("world");

        assert world != null;
        int object = world.getAmbientSpawnLimit();
        world.setAmbientSpawnLimit(45000);
        world.setDifficulty(Difficulty.HARD);
        world.setTime(18000L);
        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);

        Logger logger = Bukkit.getLogger();

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            BloodMoonTitles.Ending(server);
            world.setAmbientSpawnLimit(object);
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);

            String message = "&6[&4Broadcast&6]&f The Bloodmoon is Over... For Now...";
            server.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
        }, 100);

    }
}
