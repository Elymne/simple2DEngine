package org.engine.levels;

import org.engine.gameobjects.GameObject;

public abstract class Level {
    public final GameObject[] gameObjects;

    public Level(GameObject[] gameObjects) {
        this.gameObjects = gameObjects;
    }

    abstract public void paint();
}
