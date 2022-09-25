package com.cbre.kanban.constants;

public enum Status {
    TODO("To Do"),
    BACKLOG("Backlog"),
    DONE("Done"),
    BLOCKED("Blocked"),
    DOING("Doing");

    public final String label;

    private Status(String label) {
        this.label = label;
    }
}
