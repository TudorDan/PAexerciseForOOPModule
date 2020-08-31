package com.codecool.utilities;

public enum EmployeeType {
    ORGANIZER("Organizer"),
    CHIEFORGANIZER("Chief Organizer"),
    HELPER("Helper");

    private final String name;

    private EmployeeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
