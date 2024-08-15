package org.engine.core.rulers.collision;

import java.util.ArrayList;

import org.engine.core.elements.shapes.CollisionShape;

public interface CollisionListener {
    abstract public void listenCollision(ArrayList<CollisionShape> buffer, int timeDelta);
}
