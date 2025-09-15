package com.surtsev.todo;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public enum Status {
        TODO,
        DONE,
    }

    public String complete = "[X]";
    public String incomplete = "[ ]";
    private Data data = new Data(
        "jdbc:postgresql://localhost:5432/",
        "todo_db",
        "postgres"
    );

    public static String doList() {
        ArrayList<Tasks> tasks = data.getTasks();
        for (Tasks task : tasks) {
            if (task.getStatus() == Status.DONE) {
                System.out.println(complete + " " + task.getDescription());
            } else {
                System.out.println(incomplete + " " + task.getDescription());
            }
        }
    }

    public static String doAdd(String description) {
        data.addTask(new Tasks(description, Status.TODO));
        return "Task added";
    }
}
