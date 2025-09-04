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
        if (args.length == 1) {
            if (args[0].equals("list")) {
                Controller controller = new Controller();
                controller.list();
            }
            return;
        }
        System.out.println("Hello World!");
    }
}
