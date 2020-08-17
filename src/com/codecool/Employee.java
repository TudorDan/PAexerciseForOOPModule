package com.codecool;

public abstract class Employee {
    private int id;
    private EmployeeType kind;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public EmployeeType getKind() {
        return kind;
    }

    public void setKind(EmployeeType kind) {
        this.kind = kind;
    }

    public void performActivity(Event event) {}
}
