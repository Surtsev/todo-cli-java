package com.surtsev.todo;

/**
 * Hello world!
 */
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
        if (args.length == 2) {
            if (command.equals("add")) {
                Controller controller = new Controller();
                controller.add(args[0], args[1]);
                return;
            }
            if (command.equals("delete")) {
                Controller controller = new Controller();
                controller.delete(args[0], args[1]);
                return;
            }
        }
    }
}
