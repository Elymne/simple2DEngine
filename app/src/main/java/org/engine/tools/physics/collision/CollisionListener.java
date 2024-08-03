package org.engine.tools.physics.collision;

import java.util.ArrayList;

import org.engine.gameobjects.GameObject;

public interface CollisionListener {
    abstract public void listenCollision(ArrayList<GameObject> buffer, int timeDelta);
}
