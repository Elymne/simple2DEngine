package org.engine.core.elements.shapes;

import java.util.ArrayList;

public abstract class PhysicsShape extends CollisionShape {
    private int gravityForceDirection = PhysicsShape.FORCE_DIRECTION_NONE;
    private double gravityForce = 0.0;
    private double frictionForce = 0.0;
    private double yVelocity = 0.0;
    private double xVelocity = 0.0;

    public final static int FORCE_DIRECTION_NONE = 0;
    public final static int FORCE_DIRECTION_X = 1;
    public final static int FORCE_DIRECTION_Y = 2;

    public PhysicsShape(String name, double posX, double posY, double width, double height, int zIndex) {
        super(name, posX, posY, width, height, zIndex);
    }

    public PhysicsShape(double posX, double posY, double width, double height, int zIndex) {
        super(posX, posY, width, height, zIndex);
    }

    public void push(int xVelocity, int yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public void setForces(int gravityForceDirection, double gravityForce, double frictionForce) {
        if (gravityForceDirection < 0 || gravityForceDirection > 2) {
            System.err.println("The value for gravityt force isn't correct.");
            return;
        }
        this.gravityForceDirection = gravityForceDirection;
        this.gravityForce = gravityForce;
        this.frictionForce = frictionForce;
    }

    public void setGravityForceDirection(int gravityForceDirection) {
        this.gravityForceDirection = gravityForceDirection;
    }

    public void setGravityForce(double gravityForce) {
        this.gravityForce = gravityForce;
    }

    public void setFrictionForce(double frictionForce) {
        this.frictionForce = frictionForce;
    }

    public int getGravityForceDirection() {
        return gravityForceDirection;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public double getGravityForce() {
        return gravityForce;
    }

    public double getFrictionForce() {
        return frictionForce;
    }

    public void changeForceDirection(int gravityForceDirection) {
        if (this.gravityForceDirection == gravityForceDirection) {
            System.out.println("Warning : Same force direction.");
            return;
        }
        this.gravityForce = gravityForceDirection;
    }

    public void changeGravityForce(double gravityForce) {
        if (gravityForce < 0) {
            System.out.println("Warning : Set negative gravity value");
        }
        this.gravityForce = gravityForce;
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int delta) {
        posX += xVelocity * delta;
        posY += yVelocity * delta;
        switch (gravityForceDirection) {
            case PhysicsShape.FORCE_DIRECTION_Y:
                applyFrictionForce(xVelocity, delta);
                applyGravityforce(yVelocity, delta);
                break;
            case PhysicsShape.FORCE_DIRECTION_X:
                applyGravityforce(xVelocity, delta);
                applyFrictionForce(yVelocity, delta);
                break;
            default:
                applyFrictionForce(xVelocity, delta);
                applyFrictionForce(yVelocity, delta);
                break;
        }
    }

    private void applyFrictionForce(double velocity, int delta) {
        if (velocity > 0 && velocity - (frictionForce * delta) > 0) {
            velocity -= frictionForce * delta;
            return;
        }
        if (velocity < 0 && velocity + (frictionForce * delta) < 0) {
            velocity += frictionForce * delta;
            return;
        }
        velocity = 0;
    }

    private void applyGravityforce(double velocity, int delta) {
        if (velocity > gravityForce * 10) {
            velocity = gravityForce * 10;
        }
        velocity += gravityForce * delta;
    }
}
