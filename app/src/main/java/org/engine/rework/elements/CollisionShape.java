package org.engine.rework.elements;

import java.util.ArrayList;

import org.engine.rework.rulers.collision.CollisionListener;

abstract public class CollisionShape extends Shape implements CollisionListener {
    public CollisionShape(String name,
            double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(name, posX, posY, width, height, zIndex, elements);
    }

    public CollisionShape(double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(posX, posY, width, height, zIndex, elements);
    }

    public boolean isCollidingWith(CollisionShape element) {
        if (element == null) {
            return false;
        }

        if (this == element) {
            return false;
        }

        if (this.getPointX() <= element.getPointX() + element.getWidth() &&
                this.getPointX() + this.getWidth() >= element.getPointX() &&
                this.getPointY() >= element.getPointY() - element.getHeight() &&
                this.getPointY() - this.getHeight() <= element.getPointY()) {
            return true;
        }

        return false;
    }
}
