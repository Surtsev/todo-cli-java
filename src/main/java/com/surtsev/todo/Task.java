package com.surtsev.todo;

public class Task {

    private String name;
    private String description;
    private Status status;

    private String complete = "[X]";
    private String incomplete = "[ ]";
    private String separator = " | ";

    public Task(String name, String description, Status status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Task(String name, String description) {
        this(name, description, Status.TODO);
    }

    public Task() {}

    public Status getStatus() {
        return this.status;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return (
            (this.status == Status.TODO ? incomplete : complete) +
            separator +
            this.getName() +
            separator +
            this.getDescription()
        );
    }
}
