package org.engine.rework.elements.shapes;

import java.util.ArrayList;
import org.engine.rework.elements.Element;
import org.engine.rework.rulers.collision.CollisionListener;
import org.engine.rework.rulers.collision.CollisionRuler;

abstract public class CollisionShape extends Shape implements CollisionListener {
    protected int collisionFlag;

    public CollisionShape(String name,
            double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(name, posX, posY, width, height, zIndex, elements);
        CollisionRuler.getInstance().addElement(this);
    }

    public CollisionShape(double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(posX, posY, width, height, zIndex, elements);
    }

    public int getCollisionFlag() {
        return collisionFlag;
    }

    public void setCollisionFlag(int collisionFlag) {
        this.collisionFlag = collisionFlag;
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
