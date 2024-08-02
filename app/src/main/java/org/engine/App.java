package org.engine;

import org.engine.tools.level.LevelEnum;

public class App {
    String getGreeting() {
        return "mdr";
    }

    public static void main(String[] args) {
        System.out.println("Launching App");

        final ScreenManager screenManager = new ScreenManager();
        screenManager.startScreen();
        screenManager.setLevel(LevelEnum.EXAMPLE_LEVEL);

    }
}