package com.codecool;

public class Conference extends Event {
    public Conference(String name) {
        super(name);
        setType(EventType.CONFERENCE);
        setDuration(600);
    }
}
