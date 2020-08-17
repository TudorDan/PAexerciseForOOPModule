package com.codecool;

public class ChiefOrganizer extends Employee {
    public ChiefOrganizer() {
        setKind(EmployeeType.CHIEFORGANIZER);
    }

    private boolean areEnoughOrganizers(Event event) {
        System.out.println("Chief Organizer " + this.getId() + ": organizers number OK!");
        return event.getOrganizers() >= 2;
    }

    private boolean isEverythingSet(Event event) {
        if (areEnoughOrganizers(event)) {
            for (Employee employee : event.getStaff()) {
                if (employee.getKind() == EmployeeType.ORGANIZER) {
                    Organizer organizer = (Organizer) employee;
                    if (organizer.areEnoughHelpers(event) && organizer.isAppropriateCatering()) {
                        System.out.println("Chief Organizer " + this.getId() + ": everything is set, event is ready!");
                        event.setStatus(EventStatus.READY);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean startEvent(Event event) {
        if (isEverythingSet(event)) {
            System.out.println("Chief Organizer " + this.getId() + ": START " + event.getName() + " event!");
            event.setStatus(EventStatus.INPROGRESS);
            return true;
        }
        return false;
    }
}
