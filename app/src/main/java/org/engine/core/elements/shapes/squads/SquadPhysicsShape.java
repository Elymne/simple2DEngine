package org.engine.core.elements.shapes.squads;

import java.util.ArrayList;
import javax.annotation.Nullable;
import org.engine.core.attributes.Vector2D;
import org.engine.core.tools.Geometrie;

// TODO 2 Impulse process.
// TODO 3 Push process.
public abstract class SquadPhysicsShape extends SquadCollisionShape {
    private Vector2D velocity = new Vector2D(0, 0);
    private double fallingSpeedCap = 1000;
    private Vector2D lastPointPosition = new Vector2D(0, 0);

    public SquadPhysicsShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public SquadPhysicsShape(Vector2D position, double width, double height, int zIndex) {
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
    public void listenCollision(ArrayList<SquadCollisionShape> buffer, int delta) {
        final SquadCollisionShape ce = getFallingCollisionElement(buffer);

        // No collision check, add falling speed to a certain point.
        if (ce == null && velocity.getY() > -fallingSpeedCap) {
            velocity.addY(-(fallingSpeedCap * (delta / 500.0)));
        }

        // Collision exists, check if it's a Vertical impact.
        if (ce != null && this.velocity.getY() < 0) {
            final boolean ccc = Geometrie.detectCollision(
                    lastPointPosition.getX(),
                    lastPointPosition.getY() + velocity.getY() * (delta / 1_000.0),
                    getWidth(),
                    getHeight(),
                    ce.getStartPointX(),
                    ce.getStartPointY(),
                    getWidth(),
                    ce.getHeight());
            System.out.println(ccc);

            velocity.updateY(0);
            position.addY(ce.getStartPointY() - (getStartPointY() - getHeight()));
        }

        // Apply velocity.
        position.add(velocity.getX() * (delta / 1_000.0), velocity.getY() * (delta / 1_000.0));
        lastPointPosition.updateX(getStartPointX());
        lastPointPosition.updateY(getStartPointY());

    }

    private @Nullable SquadCollisionShape getFallingCollisionElement(ArrayList<SquadCollisionShape> elements) {
        for (SquadCollisionShape element : elements) {
            if (element instanceof SquadStaticShape || element instanceof SquadPhysicsShape) {
                return element;
            }
        }
        return null;
    }
}
