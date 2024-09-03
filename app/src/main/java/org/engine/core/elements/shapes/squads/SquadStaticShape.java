package org.engine.core.elements.shapes.squads;

import org.engine.core.attributes.Vector2D;

abstract public class SquadStaticShape extends SquadCollisionShape {
    public SquadStaticShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public SquadStaticShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }
}
