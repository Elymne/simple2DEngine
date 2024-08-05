package org.engine;

import org.engine.application.Screen;
import org.engine.application.levels.tools.LevelEnum;

public class App {
    String getGreeting() {
        return "mdr";
    }

    public static void main(String[] args) {
        System.out.println("Launching App");

        final Screen screenManager = new Screen();
        screenManager.startScreen();
        screenManager.setLevel(LevelEnum.EXAMPLE_LEVEL);
    }
}