package org.engine.core.elements.shapes;

import java.util.ArrayList;
import javax.annotation.Nullable;
import org.engine.core.attributes.Vector2D;

// TODO 2 Impulse process.
// TODO 3 Push process.
public abstract class PhysicsShape extends CollisionShape {
    private Vector2D lastPosition = new Vector2D(position.getX(), position.getY());
    private Vector2D velocity = new Vector2D(0, 0);
    private double fallingSpeedCap = 400;

    public PhysicsShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public PhysicsShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public void push(Vector2D direction, double velocity) {
    }

    public void impulse(Vector2D direction, double force) {
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int delta) {
        final CollisionShape collisionElement = getFallingCollisionElement(buffer);
        if (collisionElement == null) {
            velocity.addY(-(fallingSpeedCap * (delta / 500.0)));
        } else {
            if (this.velocity.getY() < 0) {
                velocity.updateY(0);
                position.addY(collisionElement.getDrawPointY() - (getDrawPointY() - getHeight()));
            } else if (this.velocity.getY() > 0) {
                velocity.updateY(0);
                position.addY((collisionElement.getDrawPointY() - collisionElement.getHeight()) - getDrawPointY());
            }
            if (this.velocity.getX() < 0) {
                velocity.updateY(0);
                position.addX((collisionElement.getDrawPointX() - collisionElement.getWidth()) - getDrawPointX());
            } else if (this.velocity.getX() > 0) {
                velocity.updateX(0);
                position.addX(collisionElement.getDrawPointX() - (getDrawPointX() - getWidth()));
            }
        }
        lastPosition.update(position);
        position.add(0, (velocity.getY() * (delta / 1_000.0)));
    }

    private @Nullable CollisionShape getFallingCollisionElement(ArrayList<CollisionShape> elements) {
        for (CollisionShape element : elements) {
            if (element instanceof StaticShape || element instanceof PhysicsShape) {
                return element;
            }
        }
        return null;
    }
}
