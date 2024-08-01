package org.engine.levels;

import org.engine.gameobjects.Block;
import org.engine.gameobjects.GameObject;

public class ExampleLevel extends Level {
    ExampleLevel(GameObject[] gameObjects) {
        super(gameObjects);
        // TODO Auto-generated constructor stub
    }

    public static ExampleLevel createDefault() {
        final GameObject[] gameObjects = {
                new Block(10, 10, null)
        };
        return new ExampleLevel(gameObjects);
    }

    @Override
    public void paint() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'paint'");
    }

}
