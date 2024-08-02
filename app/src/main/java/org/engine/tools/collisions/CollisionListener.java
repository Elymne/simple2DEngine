package org.engine.tools.collisions;

import org.engine.gameobjects.GameObject;

public interface CollisionListener {
    abstract public void onCollision(GameObject gameObject, CollisionType collisionType);
}
