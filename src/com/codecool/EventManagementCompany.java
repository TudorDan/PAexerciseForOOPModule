package com.codecool;

import java.util.ArrayList;
import java.util.List;

public final class EventManagementCompany {
    private List<Employee> availableEmployees = new ArrayList<>();
    private List<Event> events = new ArrayList<>();
    private static EventManagementCompany instance = null;

    public static EventManagementCompany getInstance() {
        if (instance == null) {
            instance = new EventManagementCompany();
        }
        return instance;
    }

    public List<Employee> getAvailableEmployees() {
        return availableEmployees;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEmployee(Employee employee) {
        employee.setId(availableEmployees.size() + 1);
        availableEmployees.add(employee);
    }

    public void addEvent(Event event) {
        event.setId(events.size() + 1);
        events.add(event);
    }

    public boolean areUnfinishedEvents() {
        for (Event event : events) {
            if (event.getStatus() != EventStatus.FINISHED) {
                return true;
            }
        }
        return false;
    }

    public void makeStaffAvailable() {
        for (Event event : events) {
            if (event.getStatus() == EventStatus.FINISHED) {
                // move employees from finished event back to available list
                List<Employee> eventStaff = event.getStaff();
                List<Employee> tempStaffList = new ArrayList<>(eventStaff);
                for (Employee employee : tempStaffList) {
                    availableEmployees.add(employee);
                    eventStaff.remove(employee);
                }
            }
        }
    }

    public void allocateEmployee(Employee employee, Event event) {
        event.getStaff().add(employee);
        availableEmployees.remove(employee);
    }

    public void allocateStaff(Event event) {
        int helpersNr = 0;
        int organizersNr = 0;
        int chiefOrganizerNr = 0;
        List<Employee> tempEmployeeList = new ArrayList<>(availableEmployees);
        for (Employee employee : tempEmployeeList) {
            if (employee.getKind() == EmployeeKind.HELPER && helpersNr < 10) {
                allocateEmployee(employee, event);
                helpersNr++;
            } else if (employee.getKind() == EmployeeKind.ORGANIZER && organizersNr < 2) {
                allocateEmployee(employee, event);
                organizersNr++;
            } else if (employee.getKind() == EmployeeKind.CHIEFORGANIZER && chiefOrganizerNr < 1) {
                allocateEmployee(employee, event);
                chiefOrganizerNr++;
            }
        }
    }

    public void updateEvents() {
        for (Event event : events) {
            if (event.getStatus() != EventStatus.FINISHED) {
                System.out.println("Management for (" + event.getType() + ") " + event.getName() + ":");
                event.update();
            }
        }
    }
}
