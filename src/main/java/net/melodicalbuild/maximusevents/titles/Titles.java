package net.melodicalbuild.maximusevents.titles;

import org.bukkit.Server;

public class Titles {
    public static class Passive {
        public static class Bloodmoon {
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
    }

    public static class Storyline {
        public static class Default {
            /**
             *  Start an Event Without Giving Away the Title
             *
             * @param server  The Server at which to Execute the Message
             * @param startTime  How long until the event in Minutes
             */
            public static void HiddenStart(Server server, String startTime) {
                server.dispatchCommand(server.getConsoleSender(), "title @a times 50 100 30");
                server.dispatchCommand(server.getConsoleSender(), "title @a title {\"text\":\"A Worldly Storyline\",\"color\":\"blue\",\"bold\":true}");
                server.dispatchCommand(server.getConsoleSender(), "title @a subtitle {\"text\":\"A New Storyline is Beginning in " + startTime + " Minutes\",\"color\":\"aqua\"}");
            }
        }
    }
}
