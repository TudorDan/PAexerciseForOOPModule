package com.codecool.employees;

import com.codecool.utilities.EmployeeType;
import com.codecool.events.Event;

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
