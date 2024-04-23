package org.hbrs.se1.ss24.uebung2;

import java.util.ArrayList;
import java.util.List;

public class CardBox {
    private List<PersonCard> cards;

    public CardBox() {
        cards = new ArrayList<>();
    }

    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        for (PersonCard card : cards) {
            if (card.getId() == personCard.getId()) {
                throw new CardBoxException("Das CardBox-Objekt mit der ID " + personCard.getId() + " ist bereits vorhanden");
            }
        }
        cards.add(personCard);
    }

    // Beantwortung Frage FA2
    // Bei einer Rückgabe via Exception ist dem Nutzer bewusst das ein Fehler kommt
    public String deletePersonCard(int id) {
        for (PersonCard card : cards) {
            if (card.getId() == id) {
                cards.remove(card);
                return "Objekt mit ID " + id + " wurde entfernt";
            }
        }
        return "Kein Objekt mit ID " + id + " gefunden";
    }

    public void showContent() {
        for (PersonCard card : cards) {
            System.out.println(card.toString());
        }
    }

    public int size() {
        return cards.size();
    }
}