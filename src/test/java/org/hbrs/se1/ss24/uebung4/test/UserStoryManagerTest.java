package org.hbrs.se1.ss24.uebung4.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.hbrs.se1.ss24.uebung4.UserStoryManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserStoryManagerTest {

    private final InputStream sysInBackup = System.in;
    private final PrintStream sysOutBackup = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }

    @Test
    void testAddUserStory() {
        String input = "story 1 \"Erste User Story\" should-have\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserStoryManager.main(new String[0]);

        String output = outContent.toString();
        assertTrue(output.contains("User Story hinzugefügt."));
    }

    @Test
    void testAddTask() {
        String input = "task 10 \"Task für erste User Story\"\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserStoryManager.main(new String[0]);

        // Check output immediately after adding the task
        String output = outContent.toString();
        assertTrue(output.contains("Task hinzugefügt."));
    }


    // Weitere Tests für andere Methoden und Szenarien

    @Test
    void testEndToEndScenario() {
        String input = "story 1 \"Erste User Story\" should-have\n" +
                "task 10 \"Task für erste User Story\"\n" +
                "task 20 \"Noch ein Task für erste User Story\"\n" +
                "assign 1 10\n" +
                "assign 1 20\n" +
                "save\n" +
                "load\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        UserStoryManager.main(new String[0]);

        String output = outContent.toString();
        System.out.println("Tatsächliche Ausgabe:");
        System.out.println(output);

        assertTrue(output.contains("User Stories und Tasks wurden erfolgreich gespeichert."));
        assertTrue(output.contains("User Stories und Tasks wurden erfolgreich geladen."));
    }



}
