package com.codecool;

public abstract class Employee {
    private int id;
    private EmployeeKind kind;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public EmployeeKind getKind() {
        return kind;
    }

    public void setKind(EmployeeKind kind) {
        this.kind = kind;
    }

    public void performActivity(Event event) {}
}
