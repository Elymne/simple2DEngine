package org.engine.tools.physics.collision;

import java.util.ArrayList;

import org.engine.gameobjects.GameObject;

public interface CollisionListener {
    abstract public void onCollision(ArrayList<GameObject> gameObjects, int timeDelta);
}
