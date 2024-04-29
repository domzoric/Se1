package org.hbrs.se1.ss24.uebung3;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // Erzeuge eine Instanz der CardBox
        CardBox cardBox = CardBox.getInstance();

        // Erzeuge mehrere PersonCard-Objekte
        PersonCard person1 = new EnduserCard("John", "Doe", 1, true);
        PersonCard person2 = new EnduserCard("Jane", "Doe", 2, false);
        PersonCard person3 = new DeveloperCard("Jim", "Jackson", 3, false);
        PersonCard person4 = new DeveloperCard("Anna", "Müller", 4, true);

        // Füge die PersonCard-Objekte der CardBox hinzu
        try {
            cardBox.addPersonCard(person1);
            cardBox.addPersonCard(person2);
            cardBox.addPersonCard(person3);
            cardBox.addPersonCard(person4);
        } catch (CardBoxException e) {
            System.out.println("Fehler beim Hinzufügen von PersonCard-Objekten: " + e.getMessage());
        }

        // Lese die Liste der PersonCard-Objekte aus der CardBox
        List<PersonCard> personList = cardBox.getCurrentList();

        // Erzeuge eine Instanz der PersonCardView und übergebe ihr die Liste zur Ausgabe
        PersonCardView view = new PersonCardView();
        view.showContent(personList);
    }
}
