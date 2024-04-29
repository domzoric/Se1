package org.hbrs.se1.ss24.uebung3;

public class DeveloperCard extends AbstractPersonCard {
    private boolean enoughCoffee;

    public DeveloperCard(String firstName, String lastName, int id, boolean enoughCoffee) {
        super(firstName, lastName, id);
        this.enoughCoffee = enoughCoffee;
    }

    public boolean hasEnoughCoffee() {
        return enoughCoffee;
    }

    @Override
    public String toString() {
        return super.toString() + ", hasEnoughCoffee = " + enoughCoffee;
    }
}
