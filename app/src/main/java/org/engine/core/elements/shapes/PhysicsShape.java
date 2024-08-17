package org.engine.core.elements.shapes;

import java.util.ArrayList;
import org.engine.core.attributes.Vector2D;

// TODO 2 Impulse process.
// TODO 3 Push process.
public abstract class PhysicsShape extends CollisionShape {
    private Vector2D lastPosition = new Vector2D(position.getX(), position.getY());
    private Vector2D velocity = new Vector2D(0, 0);
    private double fallingSpeedCap = 200;

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
        if (buffer.size() == 0) {
            addFallingForce(delta);
        }

        if (buffer.size() > 0 && this.velocity.getY() < 0) {
            processImpact(delta);
        }

        processMovement(delta);
    }

    private void processMovement(int delta) {
        lastPosition.update(position);
        position.add(0, (velocity.getY() * (delta / 1_000.0)));
    }

    private void processImpact(int delta) {
        velocity.updateY(0);
        position.update(lastPosition);
    }

    private void addFallingForce(int delta) {
        if (velocity.getY() <= -fallingSpeedCap) {
            return;
        }
        velocity.addY(-(fallingSpeedCap * (delta / 500.0)));
    }
}
