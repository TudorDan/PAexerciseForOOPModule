package com.codecool;

import com.codecool.employees.ChiefOrganizer;
import com.codecool.employees.Employee;
import com.codecool.employees.Helper;
import com.codecool.employees.Organizer;
import com.codecool.events.CocktailParty;
import com.codecool.events.Conference;
import com.codecool.events.Event;
import com.codecool.events.Wedding;
import com.codecool.utilities.EventStatus;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // company singleton for the entire program
        EventManagementCompany company = EventManagementCompany.getInstance();
        // add employees to the company
        for (int i = 1; i  <= 20; i++) {
            company.addEmployee(new Helper());

        }
        for (int j = 1; j <= 3; j++) {
            company.addEmployee(new ChiefOrganizer());
        }
        for (int i = 1; i <= 5; i++) {
            company.addEmployee(new Organizer());
        }
        List<Employee> employeeList = company.getAvailableEmployees();
        for (Employee employee : employeeList) {
            System.out.println("Employee: " + employee.getKind() + " " + employee.getId());
        }

        //add events to the company
        company.addEvent(new CocktailParty("John's Party"));
        List<Event> events = company.getEvents();

        // allocate staff to events
        for(Event event : events) {
            System.out.println("Event: " + event.getName() + " " + event.getStatus());
            System.out.println("-----------------------------------------------------");
            if (event.getStatus() == EventStatus.NOTREADY) {
                company.allocateStaff(event);
            }
        }
        for (Event event : events) {
            List<Employee> employeeList1 = event.getStaff();
            System.out.println("Event: " + event.getName() + " " + event.getStatus());
            for (Employee employee : employeeList1) {
                System.out.println("Employee: " + employee.getKind() + " " + employee.getId());
            }
        }
        System.out.println("----------remaining available employees----------------");
        List<Employee> employeeList2 = company.getAvailableEmployees();
        for (Employee employee : employeeList2) {
            System.out.println("Employee: " + employee.getKind() + " " + employee.getId());
        }

        System.out.println("-------------Perform event/ events ------------------");
        if (company.areUnfinishedEvents()) {
            company.updateEvents();
        }


        System.out.println("--------other events----------------------------------");
        //add events to the company
        company.addEvent(new Wedding("Jane's Wedding"));
        List<Event> events2 = company.getEvents();
        // allocate staff to events
        for(Event event : events2) {
            System.out.println("Event: " + event.getName() + " " + event.getStatus());
            System.out.println("-----------------------------------------------------");
            if (event.getStatus() == EventStatus.NOTREADY) {
                company.allocateStaff(event);
            }
        }
        for (Event event : events2) {
            List<Employee> employeeList22 = event.getStaff();
            System.out.println("Event: " + event.getName() + " " + event.getStatus());
            for (Employee employee : employeeList22) {
                System.out.println("Employee: " + employee.getKind() + " " + employee.getId());
            }
        }
        System.out.println("----------remaining available employees----------------");
        List<Employee> employeeList33 = company.getAvailableEmployees();
        for (Employee employee : employeeList33) {
            System.out.println("Employee: " + employee.getKind() + " " + employee.getId());
        }

        System.out.println("-------------Perform event/ events ------------------");
        if (company.areUnfinishedEvents()) {
            company.updateEvents();
        }

        //add events to the company
        company.makeStaffAvailable();
        company.addEvent(new Conference("John Doe's Exegesis"));
        List<Event> events3 = company.getEvents();
        // allocate staff to events
        for(Event event : events3) {
            System.out.println("Event: " + event.getName() + " " + event.getStatus());
            System.out.println("-----------------------------------------------------");
            if (event.getStatus() == EventStatus.NOTREADY) {
                company.allocateStaff(event);
            }
        }
        for (Event event : events3) {
            List<Employee> employeeList44 = event.getStaff();
            System.out.println("Event: " + event.getName() + " " + event.getStatus());
            for (Employee employee : employeeList44) {
                System.out.println("Employee: " + employee.getKind() + " " + employee.getId());
            }
        }
        System.out.println("-------------Perform event/ events ------------------");
        if (company.areUnfinishedEvents()) {
            company.updateEvents();
        }
    }
}
