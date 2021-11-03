package net.melodicalbuild.maximusevents.storyline.lines;

import net.melodicalbuild.maximusevents.storyline.classes.MaxEvent;

import java.util.List;

public class VoidLine {
    private static List<MaxEvent> EventList;
    private static int LinePos = 0;

    public static void FinishEvent() {
        if(LinePos != EventList.size()) {
            LinePos++;
        } else {

        }
    }
}
