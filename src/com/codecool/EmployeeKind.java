package com.codecool;

public enum EmployeeKind {
    ORGANIZER("Organizer"),
    CHIEFORGANIZER("Chief Organizer"),
    HELPER("Helper");

    private final String name;

    private EmployeeKind(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
