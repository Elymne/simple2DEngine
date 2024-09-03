package org.engine.core.elements.shapes.squads;

import org.engine.core.attributes.Vector2D;
import org.engine.core.rulers.collision.CollisionListener;
import org.engine.core.rulers.collision.CollisionRuler;
import org.engine.core.tools.Geometrie;

abstract public class SquadCollisionShape extends SquadShape implements CollisionListener {
    protected int collisionFlag;

    public SquadCollisionShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
        CollisionRuler.getInstance().addElement(this);
    }

    public SquadCollisionShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }

    public int getCollisionFlag() {
        return collisionFlag;
    }

    public void setCollisionFlag(int collisionFlag) {
        this.collisionFlag = collisionFlag;
    }

    public boolean isCollidingWith(SquadCollisionShape element) {
        if (element == null) {
            return false;
        }
        if (this == element) {
            return false;
        }
        return Geometrie.detectCollision(getStartPointX(), getStartPointY(), getWidth(), getHeight(),
                element.getStartPointX(), element.getStartPointY(), element.getWidth(), element.getHeight());
    }
}
