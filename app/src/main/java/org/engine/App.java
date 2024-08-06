package org.engine;

import org.engine.application.Screen;

public class App {

    public static void main(String[] args) {
        System.out.println("Launching App");
        final Screen screenManager = new Screen();
        screenManager.startScreen();
        screenManager.startLevel();
    }
}