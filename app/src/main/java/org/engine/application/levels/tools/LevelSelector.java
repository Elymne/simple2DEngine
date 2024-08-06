package org.engine.application.levels.tools;

import java.util.ArrayList;
import org.engine.application.levels.ExampleLevel;
import org.engine.core.levels.Level;
import org.engine.exceptions.LevelNotFound;

public final class LevelSelector {
    final ArrayList<Level> levels = new ArrayList<Level>();

    public static Level generateLevelFromIndex(LevelEnum level) throws LevelNotFound {
        switch (level) {
            case LevelEnum.EXAMPLE_LEVEL:
                return new ExampleLevel();
            default:
                throw new LevelNotFound(level);
        }
    }
}
