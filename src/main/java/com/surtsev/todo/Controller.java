package com.surtsev.todo;

public class Controller {

    private Data data = new Data(
        "jdbc:postgresql://localhost:5432/",
        "todo_db",
        "todo_user",
        "mypassword"
    );

    public void list() {
        data.getTasks();
    }

    public void add(String name, String description) {
        try {
            data.addTask(new Task(name, description, Status.TODO));
            System.out.println("Task added");
        } catch (Exception e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public void delete(String name) {
        try {
            data.deleteTask(name);
            System.out.println("Task deleted");
        } catch (Exception e) {
            System.out.println("Error deleting task: " + e.getMessage());
        }
    }

    public void update(String name) {
        try {
            data.updateTask(name);
            System.out.println("Task updated");
        } catch (Exception e) {
            System.out.println("Error updating task: " + e.getMessage());
        }
    }

    public void deleteAll() {
        data.deleteAllTasks();
    }
}
