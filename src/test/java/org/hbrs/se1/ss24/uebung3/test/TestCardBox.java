package org.hbrs.se1.ss24.uebung3.test;

import org.hbrs.se1.ss24.uebung3.CardBox;
import org.hbrs.se1.ss24.uebung3.CardBoxException;
import org.hbrs.se1.ss24.uebung3.CardboxStorageException;
import org.hbrs.se1.ss24.uebung3.EnduserCard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCardBox {
    private CardBox cardBox = CardBox.getInstance();

    @Test
    void testSaveAndLoad() throws CardBoxException {
        EnduserCard endUserCard1 = new EnduserCard("John", "Doe", 1, true);
        cardBox.addPersonCard(endUserCard1);

        try {
            cardBox.save();
            cardBox.load();
            assertEquals(1, cardBox.getCurrentList().size());
        } catch (CardboxStorageException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}
