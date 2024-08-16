package org.engine.core.elements.shapes;

import java.util.ArrayList;

import org.engine.core.attributes.Vector2D;

public abstract class PhysicsShape extends CollisionShape {
    private double mass = 0.0;
    private double yVel = 0.0;
    private double xVel = 0.0;

    public PhysicsShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public PhysicsShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }

    public void push(Vector2D force) {
    }

    public void impulse(Vector2D impulse) {
    }

    public double getxVel() {
        return xVel;
    }

    public double getyVel() {
        return yVel;
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int delta) {

    }

    private void applyFrictionForce(double velocity, int delta) {
    }

    private void applyGravityforce(double velocity, int delta) {
    }
}
