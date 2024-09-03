package org.engine.core.elements.shapes.squads;

import java.util.ArrayList;
import org.engine.core.attributes.Vector2D;
import org.engine.core.tools.Geometrie;

public abstract class SquadPhysicsShape extends SquadCollisionShape {
    private Vector2D lastPointPosition = new Vector2D(position.getX(), position.getY());
    private Vector2D velocity = new Vector2D(0, 0);

    private double fallingSpeedCap = 1_000;

    public SquadPhysicsShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public SquadPhysicsShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public double getFallingSpeedCap() {
        return fallingSpeedCap;
    }

    public void setFallingSpeedCap(double fallingSpeedCap) {
        this.fallingSpeedCap = fallingSpeedCap;
    }

    public void push(Vector2D direction, double velocity) {
    }

    public void impulse(Vector2D direction, double force) {
    }

    @Override
    public void listenCollision(ArrayList<SquadCollisionShape> buffer, int delta) {
        if (buffer.size() == 0) {
            if (velocity.getY() > -fallingSpeedCap) {
                velocity.addY(-(fallingSpeedCap * (delta / 500.0)));
            }
        } else {
            for (SquadCollisionShape ce : buffer) {
                if (ce instanceof SquadStaticShape || ce instanceof SquadPhysicsShape) {
                    if (velocity.getY() != 0) {
                        if (Geometrie.detectCollision(
                                lastPointPosition.getX(),
                                lastPointPosition.getY() + velocity.getY() * (delta / 1_000.0),
                                getWidth(),
                                getHeight(),
                                ce.getStartPointX(),
                                ce.getStartPointY(),
                                ce.getWidth(),
                                ce.getHeight())) {
                            if (velocity.getY() < 0) {
                                position.addY(ce.getStartPointY() - (getStartPointY() - getHeight()));
                            } else {
                                position.addY(ce.getStartPointY() - ce.getHeight() - getStartPointY());
                            }
                            velocity.updateY(0);
                        }
                    }
                    if (this.velocity.getX() != 0) {
                        if (Geometrie.detectCollision(
                                lastPointPosition.getX() + velocity.getX() * (delta / 1_000.0),
                                lastPointPosition.getY(),
                                getWidth(),
                                getHeight(),
                                ce.getStartPointX(),
                                ce.getStartPointY(),
                                ce.getWidth(),
                                ce.getHeight())) {
                            if (velocity.getX() > 0) {
                                position.addX(ce.getStartPointX() - (getStartPointX() + getWidth()));
                            } else {
                                position.addX(ce.getStartPointX() + ce.getWidth() - getStartPointX() - getWidth());
                            }
                            velocity.updateX(0);
                        }
                    }
                }
            }
        }
        lastPointPosition.updateX(getStartPointX());
        lastPointPosition.updateY(getStartPointY());
        position.add(velocity.getX() * (delta / 1_000.0), velocity.getY() * (delta / 1_000.0));
    }
}
