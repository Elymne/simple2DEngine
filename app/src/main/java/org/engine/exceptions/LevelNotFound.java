package org.engine.exceptions;

import org.engine.application.levels.tools.LevelEnum;

public class LevelNotFound extends Exception {
    public LevelNotFound(LevelEnum level) {
        super("The level : " + level.toString()
                + " don't have Position Node. Position node is mandatory for physics node usage.");
    }
}
