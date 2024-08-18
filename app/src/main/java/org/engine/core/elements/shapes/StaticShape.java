package org.engine.core.elements.shapes;

import org.engine.core.attributes.Vector2D;

abstract public class StaticShape extends CollisionShape {
    public StaticShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public StaticShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }
}
