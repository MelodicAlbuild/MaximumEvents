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
        public static class VoidLine {
            public static void LineEnd(Server server) {
                server.dispatchCommand(server.getConsoleSender(), "title @a times 50 100 30");
                server.dispatchCommand(server.getConsoleSender(),
                        "title @a title {\"text\":\"The Void Chronicles\",\"color\":\"dark_purple\",\"bold\":true}");
                server.dispatchCommand(server.getConsoleSender(),
                        "title @a subtitle {\"text\":\"I Hope you Enjoyed this Storyline\",\"color\":\"light_purple\"}");
                server.dispatchCommand(server.getConsoleSender(),
                        "title @a actionbar {\"text\":\"The Void Will Return...\",\"color\":\"dark_red\"}");
            }
            
            public static void LineStart(Server server, String startTime) {
                server.dispatchCommand(server.getConsoleSender(), "title @a times 50 100 30");
                server.dispatchCommand(server.getConsoleSender(),
                        "title @a title {\"text\":\"The Void Chronicles\",\"color\":\"blue\",\"bold\":true}");
                server.dispatchCommand(server.getConsoleSender(),
                        "title @a subtitle {\"text\":\"The Void Will Arrive in " + startTime
                                + " Minutes\",\"color\":\"aqua\"}");
            }
        }
    }

    public static class Doctor {
        public static class Default {
            public static void Beginning(Server server) {
                server.dispatchCommand(server.getConsoleSender(), "title @a times 50 100 30");
                server.dispatchCommand(server.getConsoleSender(), "title @a title {\"text\":\"Maximus SMP\",\"color\":\"gold\",\"bold\":true}");
                server.dispatchCommand(server.getConsoleSender(), "title @a subtitle {\"text\":\"Season 2\",\"color\":\"red\"}");
            }

            public static void Ending(Server server) {
                server.dispatchCommand(server.getConsoleSender(), "title @a times 50 100 30");
                server.dispatchCommand(server.getConsoleSender(), "title @a title {\"text\":\"Blood Moon\",\"color\":\"dark_red\",\"bold\":true}");
                server.dispatchCommand(server.getConsoleSender(), "title @a subtitle {\"text\":\"The Blood Moon is Falling...\",\"color\":\"red\"}");
            }
        }
    }
}
