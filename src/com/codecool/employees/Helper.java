package com.codecool.employees;

import com.codecool.utilities.EmployeeType;
import com.codecool.events.Event;
import com.codecool.utilities.EventType;
import com.codecool.utilities.Preference;

import java.util.Random;

public class Helper extends Employee {
    private final Preference preference;
    boolean breakTime = false;
    int counter = 0;
    int ordinal = getRandomNumberInRange(0, 1);

    public Helper() {
        setKind(EmployeeType.HELPER);
        this.preference = Preference.values()[ordinal];
    }

    @Override
    public void performActivity(Event event) {
        // helpers have 30 minutes breaks
        if (event.getElapsed() % 120 == 0 || breakTime) {
            breakTime = true;
            counter++;
            System.out.println("Minute " + event.getElapsed() + ": "
                    + "Helper " + this.getId() + " is during break: he/she " + preference.getName());
            if (counter == 30) {
                counter = 0;
                breakTime = false;
            }
        } else if (event.getType() == EventType.COCKTAILPARTY && event.getElapsed() % 5 == 0) {
            System.out.println("Minute " + event.getElapsed() + ": "
                    + "Helper" + this.getId() + " asks guests if they want more cocktail");
        } else if (event.getType() == EventType.WEDDING && event.getElapsed() % 10 == 0) {
            System.out.println("Minute " + event.getElapsed() + ": "
                    + "Helper" + this.getId() + " offers some wedding cake");
        } else if (event.getType() == EventType.CONFERENCE && event.getElapsed() == 1) {
            System.out.println("Minute " + event.getElapsed() + ": "
                    + "Helper " + this.getId() + " informs the guests " + "about where they can find snacks");
        }
    }

    /**
     * Generates a random integer
     *
     * @param min inclusive
     * @param max inclusive
     * @return integer
     */
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
