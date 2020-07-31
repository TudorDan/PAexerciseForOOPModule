package com.codecool;

import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    private int id;
    private int duration;
    private int elapsed;
    private List<Employee> staff = new ArrayList<>();
    private String name;
    private EventType type;
    private EventStatus status;

    public Event(String name) {
        this.name = name;
        this.elapsed = 0;
        this.status = EventStatus.NOTREADY;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public void setStaff(List<Employee> staff) {
        this.staff = staff;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getElapsed() {
        return elapsed;
    }

    public void setElapsed(int elapsed) {
        this.elapsed = elapsed;
    }

    public int getHelpersNumber() {
        int counter = 0;
        for (Employee employee : staff) {
            if (employee.getKind() == EmployeeKind.HELPER) {
                counter++;
            }
        }
        return counter;
    }

    public int getOrganizers() {
        int counter = 0;
        for (Employee employee : staff) {
            if (employee.getKind() == EmployeeKind.ORGANIZER) {
                counter++;
            }
        }
        return counter;
    }

    public ChiefOrganizer getChiefOrganizer() {
        for (Employee employee : staff) {
            if (employee.getKind() == EmployeeKind.CHIEFORGANIZER) {
                return (ChiefOrganizer) employee;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void update() {
        ChiefOrganizer chiefOrganizer = getChiefOrganizer();
        if (chiefOrganizer.startEvent(this)) {
            while(elapsed < duration) {
                setElapsed(elapsed + 1);
                for (Employee employee : staff) {
                    if (employee.getKind() == EmployeeKind.HELPER) {
                        Helper helper = (Helper) employee;
                        helper.performActivity(this);
                    }
                }
            }
        }
        if (elapsed == duration) {
            setStatus(EventStatus.FINISHED);
            System.out.println(name + " event has finished!");
        }
    }
}
