package com.surtsev.todo;

public enum Status {
    TODO("TODO"),
    DONE("DONE");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
