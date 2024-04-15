package org.hbrs.se1.ss24.uebung1.client;

public class Client {
    public void printTransformation(int number) {
        String result = NumberFactory.transformNumber("ROMAN", number);
        System.out.println("Die römische Schreibweise der Zahl " + number + " ist: " + result);
    }
}
