package com.surtsev.todo;

import java.util.Arrays;

enum Status {
    TODO,
    DONE,
}

public class Task {

    private String Description;
    private Status Status;

    public Task(String description, Status status) {
        Description = description;
        Status = status;
    }

    public Task getTask() {
        return new Task(Description, Status);
    }

    public Status getStatus() {
        return Status;
    }

    public String getDescription() {
        return Description;
    }
}
