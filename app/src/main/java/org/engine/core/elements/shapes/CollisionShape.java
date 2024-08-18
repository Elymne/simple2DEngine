package org.engine.core.elements.shapes;

import org.engine.core.attributes.Vector2D;
import org.engine.core.rulers.collision.CollisionListener;
import org.engine.core.rulers.collision.CollisionRuler;

abstract public class CollisionShape extends Shape implements CollisionListener {
    protected int collisionFlag;

    public CollisionShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
        CollisionRuler.getInstance().addElement(this);
    }

    public CollisionShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
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
        if (getDrawPosition().getX() <= element.getDrawPosition().getX() + element.getWidth() &&
                getDrawPosition().getX() + getWidth() >= element.getDrawPosition().getX() &&
                getDrawPosition().getY() >= element.getDrawPosition().getY() - element.getHeight() &&
                getDrawPosition().getY() - getHeight() <= element.getDrawPosition().getY()) {
            return true;
        }
        return false;
    }
}
