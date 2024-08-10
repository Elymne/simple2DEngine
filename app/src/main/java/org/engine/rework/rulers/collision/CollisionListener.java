package org.engine.rework.rulers.collision;

import java.util.ArrayList;
import org.engine.rework.elements.shapes.CollisionShape;

public interface CollisionListener {
    abstract public void listenCollision(ArrayList<CollisionShape> buffer, int timeDelta);
}
