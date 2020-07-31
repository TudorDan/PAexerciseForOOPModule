package com.codecool;

public class Wedding extends Event {
    public Wedding(String name) {
        super(name);
        setType(EventType.WEDDING);
        setDuration(480);
    }
}
