package org.hbrs.se1.ss24.uebung4;

class Task {
    protected int id;
    private String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String toString() {
        return "ID: " + id + ", Beschreibung: " + description;
    }
}
