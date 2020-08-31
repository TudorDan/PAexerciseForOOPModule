package com.codecool.events;

import com.codecool.utilities.EventType;

public class Conference extends Event {
    public Conference(String name) {
        super(name);
        setType(EventType.CONFERENCE);
        setDuration(600);
    }
}
