package org.hbrs.se1.ss24.uebung1.businesslogic;

import java.util.Dictionary;
import java.util.Hashtable;

public class NumberFactory {
    private static final Dictionary<String, NumberTransformer> types = new Hashtable<>();

    static {
        types.put("ROMAN", new RomanNumberTransformer());
        types.put("GERMAN", new GermanFormatNumberTransformer());
    }

    public static String transformNumber(String type, int number) {
        return types.get(type).transformNumber(number);
    }
}
