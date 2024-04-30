package org.hbrs.se1.ss24.uebung3.test;

import org.hbrs.se1.ss24.uebung3.CardBox;
import org.hbrs.se1.ss24.uebung3.CardBoxException;
import org.hbrs.se1.ss24.uebung3.CardboxStorageException;
import org.hbrs.se1.ss24.uebung3.EnduserCard;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCardBox {
    private CardBox cardBox = CardBox.getInstance();

    @BeforeAll
    static void setUp() {
        CardBox.getInstance().getCurrentList().clear();
    }

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

    @Test
    void testSaveAndEmptyListAndLoadAgain() {

        try {
            cardBox.save();
            cardBox.addPersonCard(new EnduserCard("John", "Doe", 3, true));
            cardBox.load();
            assertEquals(1, cardBox.getCurrentList().size());
            assertEquals(1, cardBox.getCurrentList().get(0).getId());
        } catch (CardboxStorageException e) {
            fail("Exception thrown: " + e.getMessage());
        } catch (CardBoxException e) {
            throw new RuntimeException(e);
        }
    }
}
