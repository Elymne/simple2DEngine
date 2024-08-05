package org.engine.application.levels.tools;

import org.engine.application.levels.ExampleLevel;
import org.engine.core.Level;
import org.engine.exceptions.LevelNotFound;

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
