package org.engine.rework.elements.shapes;

import java.util.ArrayList;
import org.engine.rework.elements.Element;

abstract public class StaticShape extends CollisionShape {
    public StaticShape(String name,
            double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(name, posX, posY, width, height, zIndex, elements);
    }

    public StaticShape(double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(posX, posY, width, height, zIndex, elements);
    }
}
