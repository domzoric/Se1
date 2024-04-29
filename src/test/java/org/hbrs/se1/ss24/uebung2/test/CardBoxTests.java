package org.hbrs.se1.ss24.uebung2.test;

import org.hbrs.se1.ss24.uebung2.CardBox;
import org.hbrs.se1.ss24.uebung2.CardBoxException;
import org.hbrs.se1.ss24.uebung2.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.EnduserCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardBoxTests {
    private CardBox cardBox = null;

    @BeforeEach
    void setUp() {
        this.cardBox = new CardBox();
    }

    @Test
    void testCardBox() {
        EnduserCard endUserCard1 = new EnduserCard("John", "Doe", 1, true);
        EnduserCard enduserCard2 = new EnduserCard("Jane", "Doe", 2, false);
        DeveloperCard developerCard1 = new DeveloperCard("Jim", "Jackson", 3, false);
        DeveloperCard developerCard2 = new DeveloperCard("Anna", "Müller", 4, true);

        try {
            cardBox.addPersonCard(endUserCard1);
            assertEquals(cardBox.size(), 1);
            assertEquals(cardBox.deletePersonCard(-1), "Die ID -1 gibt es nicht");

            cardBox.addPersonCard(enduserCard2);
            cardBox.addPersonCard(developerCard1);
            cardBox.addPersonCard(developerCard2);
            assertEquals(cardBox.size(), 4);

            assertEquals(cardBox.deletePersonCard(3), "ID 3 erfolgreich entfernt");
            assertEquals(cardBox.size(), 3);
            assertEquals(cardBox.deletePersonCard(3), "Die ID 3 gibt es nicht");
            assertEquals(cardBox.deletePersonCard(15), "Die ID 15 gibt es nicht");
            assertEquals(cardBox.size(), 3);

            cardBox.showContent();
        } catch (CardBoxException e) {
            fail("Exception mit unerwartetem Ergebnis: " + e.getMessage());
        }

        CardBoxException thrown = assertThrows(CardBoxException.class, () -> cardBox.addPersonCard(endUserCard1));
        CardBoxException thrown2 = assertThrows(CardBoxException.class, () -> cardBox.addPersonCard(null));
    }
}
