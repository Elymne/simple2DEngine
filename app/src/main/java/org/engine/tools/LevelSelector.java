package org.engine.tools;

import org.engine.levels.ExampleLevel;
import org.engine.levels.Level;

public final class LevelSelector {
    final static public int EXAMPLE_LEVEL = 0;

    public static Level generateLevelFromIndex(int index) throws Exception {
        switch (index) {
            case EXAMPLE_LEVEL:
                return new ExampleLevel();
            default:
                throw new Exception("Level " + index + "doesn't exists");
        }
    }

}
