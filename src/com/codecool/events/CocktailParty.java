package com.codecool.events;

import com.codecool.utilities.EventType;

public class CocktailParty extends Event {
    public CocktailParty(String name) {
        super(name);
        setType(EventType.COCKTAILPARTY);
        setDuration(300);
    }
}
