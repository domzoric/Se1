package org.hbrs.se1.ss24.uebung3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class CardBox {
    private static CardBox instance = null;
    private List<PersonCard> innerList = new ArrayList<>();

    public CardBox() {
    }

    public static CardBox getInstance() {
        if (instance == null) {
            instance = new CardBox();
        }
        return instance;
    }

    private boolean contains(PersonCard personCard) {
        int id = personCard.getId();
        for (PersonCard record : innerList) {
            if (record.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addPersonCard(PersonCard personCard) throws CardBoxException {
        if (personCard == null) {
            throw new CardBoxException(0);
        }
        if (contains(personCard)) {
            CardBoxException e = new CardBoxException(personCard.getId());
            throw e;
        }
        innerList.add(personCard);
    }

    private PersonCard getPersonCard(int id) {
        for (PersonCard record : innerList) {
            if (id == record.getId()) {
                return record;
            }
        }
        return null;
    }

    public String deletePersonCard(int id) {
        PersonCard personCard = getPersonCard(id);
        if (personCard == null) {
            return "Die ID " + id + " gibt es nicht";
        } else {
            innerList.remove(personCard);
            return "ID " + id + " erfolgreich entfernt";
        }
    }

    public void showContent() {
        for (PersonCard personCard : innerList) {
            System.out.println(personCard.toString());
        }
    }

    public int size() {
        return innerList.size();
    }

    public void save() throws CardboxStorageException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cardbox.ser"))) {
            oos.writeObject(innerList);
        } catch (IOException e) {
            throw new CardboxStorageException("Fehler beim Speichern der CardBox: " + e.getMessage());
        }
    }

    public void load() throws CardboxStorageException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cardbox.ser"))) {
            innerList = (List<PersonCard>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new CardboxStorageException("Fehler beim Laden der CardBox: " + e.getMessage());
        }
    }

    public List<PersonCard> getCurrentList() {
        return innerList;
    }
}
