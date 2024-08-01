package org.engine;

public class App {

    String getGreeting() {
        return "mdr";
    }

    public static void main(String[] args) {
        System.out.println("Ok, on test.");

        final Test cc = new Test();
        cc.draw();
    }
}