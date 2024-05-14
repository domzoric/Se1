package org.hbrs.se1.ss24.uebung4;

import java.io.Serializable;

class Task implements Serializable {
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
