package org.hbrs.se1.ss24.uebung3;

public class EnduserCard extends AbstractPersonCard {
    private boolean hungry;

    public EnduserCard(String firstName, String lastName, int id, boolean hungry) {
        super(firstName, lastName, id);
        this.hungry = hungry;
    }

    public boolean isHungry() {
        return hungry;
    }

    @Override
    public String toString() {
        return super.toString() + ", isHungry = " + hungry;
    }
}
