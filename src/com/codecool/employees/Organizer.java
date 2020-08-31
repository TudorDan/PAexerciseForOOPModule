package com.codecool.employees;

import com.codecool.utilities.EmployeeType;
import com.codecool.events.Event;

public class Organizer extends Employee {

    public Organizer() {
        setKind(EmployeeType.ORGANIZER);
    }

    protected boolean areEnoughHelpers(Event event) {
        System.out.println("Organizer " + this.getId() + ": helpers number OK!");
        return event.getHelpersNumber() >= 10;
    }

    protected boolean isAppropriateCatering() {
        System.out.println("Organizer " + this.getId() + ": catering is OK!");
        return true;
    }

}
