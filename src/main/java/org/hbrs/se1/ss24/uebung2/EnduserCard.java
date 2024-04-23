package org.hbrs.se1.ss24.uebung2;

public class EnduserCard implements PersonCard {
    private String firstName;
    private String lastName;
    private int id;
    private boolean isHungry;

    public EnduserCard(String firstName, String lastName, int id, boolean isHungry) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.isHungry = isHungry;
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

    public boolean isHungry() {
        return isHungry;
    }
}