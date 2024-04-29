package org.hbrs.se1.ss24.uebung3;

public class CardBoxException extends Exception {
    public CardBoxException(int id) {
        super("Das PersonCard-Objekt mit der ID " + id + " ist bereits vorhanden");
    }

    public CardBoxException() {
        super("NULL ist nicht erlaubt!");
    }
}
