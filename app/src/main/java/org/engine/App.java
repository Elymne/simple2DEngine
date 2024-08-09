package org.engine;

import org.engine.presentation.Controller;

public class App {

    public static void main(String[] args) {
        System.out.println("Launching App");
        final Controller screenManager = new Controller();
        screenManager.setupScreen();
        screenManager.start();
    }
}