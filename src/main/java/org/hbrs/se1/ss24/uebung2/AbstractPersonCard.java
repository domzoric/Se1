package org.hbrs.se1.ss24.uebung2;

public abstract class AbstractPersonCard implements PersonCard {
    private String firstName;
    private String lastName;
    private int id;

    public AbstractPersonCard(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID = " + id + ", Vorname = " + firstName + ", Nachname = " + lastName;
    }
}

