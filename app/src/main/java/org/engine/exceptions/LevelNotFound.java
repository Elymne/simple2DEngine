package org.engine.exceptions;

import org.engine.core.level.LevelEnum;

public class LevelNotFound extends Exception {
    public LevelNotFound(LevelEnum level) {
        super("The level : " + level.toString()
                + " don't have Position Node. Position node is mandatory for physics node usage.");
    }
}
