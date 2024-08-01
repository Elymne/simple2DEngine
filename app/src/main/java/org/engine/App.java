package org.engine;

import org.engine.tools.LevelSelector;

public class App {
    String getGreeting() {
        return "mdr";
    }

    public static void main(String[] args) {
        System.out.println("Launching App");

        final ScreenManager screenManager = new ScreenManager();
        screenManager.startScreen();
        screenManager.setLevel(LevelSelector.EXAMPLE_LEVEL);

    }
}