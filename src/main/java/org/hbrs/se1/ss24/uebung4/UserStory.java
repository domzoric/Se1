package org.hbrs.se1.ss24.uebung4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class UserStory {
    private int id;
    private String description;
    private String priority;
    private List<Task> tasks;

    public UserStory(int id, String description, String priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append(", Beschreibung: ").append(description).append(", Priorität: ").append(priority);
        if (!tasks.isEmpty()) {
            sb.append("\nZugeordnete Tasks:");
            for (Task task : tasks) {
                sb.append("\n").append(task);
            }
        }
        return sb.toString();
    }
}

