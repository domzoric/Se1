package org.hbrs.se1.ss24.uebung3;

import java.util.List;

public class PersonCardView {
    public void showContent(List<PersonCard> liste) {
        for (PersonCard personCard : liste) {
            System.out.println(personCard.toString());
        }
    }
}

