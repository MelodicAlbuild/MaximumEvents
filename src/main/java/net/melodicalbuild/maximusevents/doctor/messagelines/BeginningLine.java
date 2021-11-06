package net.melodicalbuild.maximusevents.doctor.messagelines;

import net.melodicalbuild.maximusevents.doctor.FirstEncounter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class BeginningLine {

    static List<WagnerMessage> messagelist = new ArrayList<>();
    public static int i = 0;

    public static void Start() {
        // messagelist.add(new WagnerMessage("", 9));

        // Define Messages
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: Welcome Everyone! My name is &6Dr.Wagner&f, I have been dispatched from the Maximus Government Team to conduct many experiments.", 9));
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: As you may have noticed, You all are in a very unfamiliar place, Last time I was observing you all, I found you all in factions, and developing these massive structures.", 9));
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: If you could allow me just a few moments, I will explain...", 9));
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: Your previous venture into the magical world you saw around you was a test we were conducting to determine if you all could move onto &4Phase 2&f.", 9));
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: I am pleased to say that you have passed, With flying colors might I add.", 9));
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: Now, I once again request your assistance, This time, in another experiment, I need you all to help us gather critical data on survival tactics. As such we request that you all once again, enter the Maximus SMP...", 9));
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: As for the &4Phase 2&f I mentioned before...", 9));
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: I will be introducing many of my colleagues in the Maximus Government that could use your assistance over time. Make sure to keep an eye out for my summons!", 9));
        messagelist.add(new WagnerMessage("&6[&1Head Scientist&6] &fDr.Wagner: With all that in mind, I have a lot to do so I'm going to turn over the floor to my boss, and the Programs Manager here in the Maximus Government, &2Mr.MelodicAlbuild", 9));

        // Execution Code
        Server server = Bukkit.getServer();
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("MaximusEvents");
        assert plugin != null;
        new BukkitRunnable() {
            @Override
            public void run() {
                if(i < messagelist.size()) {
                    WagnerMessage message = messagelist.get(i);
                    server.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message.message));
                    i++;
                } else {
                    FirstEncounter.Return();
                    this.cancel();
                }
            }
        }.runTaskTimer(plugin, 0, 180);
    }

    public static class WagnerMessage {
        public String message;
        public int SleepTime;

        public WagnerMessage(String message, int time) {
            this.message = message;
            this.SleepTime = time;
        }
    }

}
