package com.mycompany.app;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        System.out.println(MESSAGE);
        System.out.println("WAITING FOR TERMINATION BY USER");
        while (true) {
            try {
                Thread.sleep(1000); // Sleep for 1 second (adjust as needed)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public String getMessage() {
        return MESSAGE;
    }
}
