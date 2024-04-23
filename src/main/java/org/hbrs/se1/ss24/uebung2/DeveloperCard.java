package org.hbrs.se1.ss24.uebung2;

public class DeveloperCard implements PersonCard {
    private String firstName;
    private String lastName;
    private int id;
    private boolean hasEnoughCoffee;

    public DeveloperCard(String firstName, String lastName, int id, boolean hasEnoughCoffee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.hasEnoughCoffee = hasEnoughCoffee;
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

    public boolean hasEnoughCoffee() {
        return hasEnoughCoffee;
    }
}