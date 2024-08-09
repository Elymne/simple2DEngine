package org.engine.rework.rulers.collision;

import java.util.ArrayList;
import org.engine.core.elements.Element;

public interface CollisionListener {
    abstract public void listenCollision(ArrayList<Element> buffer, int timeDelta);
}
