package net.melodicalbuild.maximusevents.titles;

import org.bukkit.Server;

public class BloodMoonTitles {
    public static void Starting(Server server) {
        server.dispatchCommand(server.getConsoleSender(), "title @a times 50 100 30");
        server.dispatchCommand(server.getConsoleSender(), "title @a title {\"text\":\"Blood Moon\",\"color\":\"dark_red\",\"bold\":true}");
        server.dispatchCommand(server.getConsoleSender(), "title @a subtitle {\"text\":\"The Blood Moon is Rising...\",\"color\":\"red\"}");
    }

    public static void Ending(Server server) {
        server.dispatchCommand(server.getConsoleSender(), "title @a times 50 100 30");
        server.dispatchCommand(server.getConsoleSender(), "title @a title {\"text\":\"Blood Moon\",\"color\":\"dark_red\",\"bold\":true}");
        server.dispatchCommand(server.getConsoleSender(), "title @a subtitle {\"text\":\"The Blood Moon is Falling...\",\"color\":\"red\"}");
    }
}
