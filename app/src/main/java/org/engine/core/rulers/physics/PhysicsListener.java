package org.engine.core.rulers.physics;

import java.util.ArrayList;
import org.engine.core.elements.Element;

public interface PhysicsListener {
    abstract public void listenCollision(ArrayList<Element> buffer, int timeDelta);
}
