package org.engine.rework.elements.shapes;

abstract public class StaticShape extends CollisionShape {
    public StaticShape(String name, double posX, double posY, double width, double height, int zIndex) {
        super(name, posX, posY, width, height, zIndex);
    }

    public StaticShape(double posX, double posY, double width, double height, int zIndex) {
        super(posX, posY, width, height, zIndex);
    }
}
