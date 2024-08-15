package org.engine.core.elements.shapes;

import org.engine.core.rulers.collision.CollisionListener;
import org.engine.core.rulers.collision.CollisionRuler;

abstract public class CollisionShape extends Shape implements CollisionListener {
    protected int collisionFlag;

    public CollisionShape(String name, double posX, double posY, double width, double height, int zIndex) {
        super(name, posX, posY, width, height, zIndex);
        CollisionRuler.getInstance().addElement(this);
    }

    public CollisionShape(double posX, double posY, double width, double height, int zIndex) {
        super(posX, posY, width, height, zIndex);
        CollisionRuler.getInstance().addElement(this);
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
        if (getPointX() <= element.getPointX() + element.getWidth() &&
                getPointX() + getWidth() >= element.getPointX() &&
                getPointY() >= element.getPointY() - element.getHeight() &&
                getPointY() - getHeight() <= element.getPointY()) {
            return true;
        }
        return false;
    }
}