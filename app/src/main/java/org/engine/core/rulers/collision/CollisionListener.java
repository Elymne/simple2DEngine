package org.engine.core.rulers.collision;

import java.util.ArrayList;

import org.engine.core.elements.shapes.squads.SquadCollisionShape;

public interface CollisionListener {
    abstract public void listenCollision(ArrayList<SquadCollisionShape> buffer, int timeDelta);
}
