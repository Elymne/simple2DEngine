package org.engine.application.rules.physics;

import java.util.ArrayList;

import org.engine.core.Element;

public interface PhysicsListener {
    abstract public void listenCollision(ArrayList<Element> buffer, int timeDelta);
}
