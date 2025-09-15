package com.surtsev.todo;

public class App {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments provided.");
            return;
        }
        if (args.length > 3) {
            System.out.println("Too many arguments provided.");
            return;
        }
        String command = args[0];
        if (args.length == 1) {
            if (command.equals("list")) {
                Controller controller = new Controller();
                controller.list();
                return;
            }
            if (command.equals("delete_all")) {
                Controller controller = new Controller();
                controller.deleteAll();
                return;
            }
        }
        if (args.length == 3) {
            if (command.equals("add")) {
                Controller controller = new Controller();
                try {
                    controller.add(args[1], args[2]);
                } catch (Exception e) {
                    System.out.println("Error adding task: " + e.getMessage());
                }
                return;
            }
        }
        if (args.length == 2) {
            if (command.equals("delete")) {
                Controller controller = new Controller();
                try {
                    controller.delete(args[1]);
                } catch (Exception e) {
                    System.out.println(
                        "Error deleting task: " + e.getMessage()
                    );
                }
                return;
            }
            if (command.equals("update")) {
                Controller controller = new Controller();
                try {
                    controller.update(args[1]);
                } catch (Exception e) {
                    System.out.println(
                        "Error updating task: " + e.getMessage()
                    );
                }
                return;
            }
        }
    }
}
