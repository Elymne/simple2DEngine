package org.engine.core.level;

import org.engine.exceptions.LevelNotFound;
import org.engine.levels.ExampleLevel;
import org.engine.levels.Level;

public final class LevelSelector {
    public static Level generateLevelFromIndex(LevelEnum level) throws LevelNotFound {
        switch (level) {
            case LevelEnum.EXAMPLE_LEVEL:
                return new ExampleLevel();
            default:
                throw new LevelNotFound(level);
        }
    }
}
