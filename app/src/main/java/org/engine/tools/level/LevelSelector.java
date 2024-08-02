package org.engine.tools.level;

import org.engine.levels.ExampleLevel;
import org.engine.levels.Level;

public final class LevelSelector {
    public static Level generateLevelFromIndex(LevelEnum level) throws Exception {
        switch (level) {
            case LevelEnum.EXAMPLE_LEVEL:
                return new ExampleLevel();
            default:
                throw new Exception("Level " + level + "doesn't exists");
        }
    }
}
