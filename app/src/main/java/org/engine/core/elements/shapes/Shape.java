package org.engine.core.elements.shapes;

import org.engine.core.attributes.Vector2D;
import org.engine.core.elements.Element;

abstract public class Shape extends Element {
    protected Vector2D position;
    protected int zIndex;

    public Shape(String key, Vector2D position, int zIndex) {
        super(key);
        this.position = position;
        this.zIndex = zIndex;
    }

    public Shape(Vector2D position, int zIndex) {
        super();
        this.position = position;
        this.zIndex = zIndex;
    }

}
