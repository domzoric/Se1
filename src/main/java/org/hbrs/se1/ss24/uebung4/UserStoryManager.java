package org.hbrs.se1.ss24.uebung4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserStoryManager {
    private static final Map<Integer, UserStory> userStories = new HashMap<>();
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) { // Überprüfe, ob eine Zeile verfügbar ist
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split("\\s+", 2);
            String command = parts[0].toLowerCase();
            String arguments = parts.length > 1 ? parts[1] : "";

            switch (command) {
                case "story":
                    addStory(arguments);
                    break;
                case "task":
                    addTask(arguments);
                    break;
                case "assign":
                    assignTask(arguments);
                    break;
                case "stories":
                    displayStories();
                    break;
                case "tasks":
                    displayTasks();
                    break;
                case "save":
                    saveToFile();
                    break;
                case "load":
                    loadFromFile();
                    break;
                default:
                    System.out.println("Unbekannter Befehl.");
                    break;
            }
        }
        scanner.close(); // Schließe den Scanner, wenn keine Eingabe mehr erwartet wird
    }


    private static void addStory(String arguments) {
        String[] parts = arguments.split("\\s+", 3);
        int id = Integer.parseInt(parts[0]);
        String description = parts[1].replaceAll("\"", "");
        String priority = parts[2];
        UserStory story = new UserStory(id, description, priority);
        userStories.put(id, story);
        System.out.println("User Story hinzugefügt.");
    }

    private static void addTask(String arguments) {
        String[] parts = arguments.split("\\s+", 3);
        int id = Integer.parseInt(parts[0]);
        String description = parts[1].replaceAll("\"", "");
        Task task = new Task(id, description);
        tasks.add(task);
        System.out.println("Task hinzugefügt.");
    }

    private static void assignTask(String arguments) {
        String[] parts = arguments.split("\\s+", 2);
        int storyId = Integer.parseInt(parts[0]);
        int taskId = Integer.parseInt(parts[1]);
        if (userStories.containsKey(storyId)) {
            UserStory story = userStories.get(storyId);
            Task task = tasks.stream().filter(t -> t.id == taskId).findFirst().orElse(null);
            if (task != null) {
                story.addTask(task);
                System.out.println("Task erfolgreich User Story zugeordnet.");
            } else {
                System.out.println("Task nicht gefunden.");
            }
        } else {
            System.out.println("User Story nicht gefunden.");
        }
    }

    private static void displayStories() {
        for (UserStory story : userStories.values()) {
            System.out.println(story);
        }
    }

    private static void displayTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("userStories.dat"))) {
            oos.writeObject(userStories);
            oos.writeObject(tasks);
            System.out.println("User Stories und Tasks wurden erfolgreich gespeichert.");
        } catch (IOException e) {
            System.out.println("Fehler beim Speichern der User Stories und Tasks: " + e.getMessage());
        }
    }

    private static void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("userStories.dat"))) {
            userStories.clear();
            tasks.clear();
            userStories.putAll((Map<Integer, UserStory>) ois.readObject());
            tasks.addAll((List<Task>) ois.readObject());
            System.out.println("User Stories und Tasks wurden erfolgreich geladen.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Fehler beim Laden der User Stories und Tasks: " + e.getMessage());
        }
    }
}
