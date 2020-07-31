package com.codecool;

public class Organizer extends Employee {

    public Organizer() {
        setKind(EmployeeKind.ORGANIZER);
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
