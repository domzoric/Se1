package org.hbrs.se1.ss24.uebung2.test;

import org.hbrs.se1.ss24.uebung2.CardBox;
import org.hbrs.se1.ss24.uebung2.CardBoxException;
import org.hbrs.se1.ss24.uebung2.DeveloperCard;
import org.hbrs.se1.ss24.uebung2.EnduserCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardBoxTests {

    @Test
    void testAddPersonCard() {
        CardBox cardBox = new CardBox();
        try {
            cardBox.addPersonCard(new EnduserCard("John", "Doe", 1, true));
            cardBox.addPersonCard(new DeveloperCard("Jane", "Smith", 2, false));
        } catch (CardBoxException e) {
            fail("Adding valid PersonCard objects should not throw an exception");
        }

        assertThrows(CardBoxException.class, () -> cardBox.addPersonCard(new EnduserCard("Alice", "Johnson", 1, true)));
    }

    @Test
    void testDeletePersonCard() {
        CardBox cardBox = new CardBox();
        cardBox.addPersonCard(new EnduserCard("John", "Doe", 1, true));

        assertEquals("Objekt mit ID 1 wurde entfernt", cardBox.deletePersonCard(1));
        assertEquals("Kein Objekt mit ID 2 gefunden", cardBox.deletePersonCard(2));
    }

    @Test
    void testShowContent() {
        CardBox cardBox = new CardBox();
        cardBox.addPersonCard(new EnduserCard("John", "Doe", 1, true));
        cardBox.addPersonCard(new DeveloperCard("Jane", "Smith", 2, false));

        cardBox.showContent(); // Should print content to console
    }

    @Test
    void testSize() {
        CardBox cardBox = new CardBox();
        assertEquals(0, cardBox.size());

        cardBox.addPersonCard(new EnduserCard("John", "Doe", 1, true));
        cardBox.addPersonCard(new DeveloperCard("Jane", "Smith", 2, false));
        assertEquals(2, cardBox.size());
    }
}