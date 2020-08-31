package com.codecool.utilities;

public enum Preference {
    SMOKE("smokes"),
    DRINKCOFFEE("drinks coffee");

    private final String name;

    private Preference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
