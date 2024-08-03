package org.engine.exceptions;

import org.engine.gameobjects.GameObject;

public class NoPositionNodeException extends Exception {
    public NoPositionNodeException(GameObject gameObject) {
        super("GameObject with ID : " + gameObject.getKey()
                + " don't have Position Node. Position node is mandatory for physics node usage.");
    }
}
