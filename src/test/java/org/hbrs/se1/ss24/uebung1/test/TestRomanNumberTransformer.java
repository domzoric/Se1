package org.hbrs.se1.ss24.uebung1.test;

import org.hbrs.se1.ss24.uebung1.businesslogic.RomanNumberTransformer;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

class TestRomanNumberTransformer {

    @Test
    void TestRomanNumbers() {
        RomanNumberTransformer transformer = new RomanNumberTransformer();
        assertEquals("CXXIII", transformer.transformNumber(123));
        assertEquals("MMXXI", transformer.transformNumber(2021));
        assertEquals("MMM", transformer.transformNumber(3000));
        assertEquals("Zahl außerhalb des Wertebereich", transformer.transformNumber(0));
        assertEquals("Zahl außerhalb des Wertebereich", transformer.transformNumber(3001));
    }
}
