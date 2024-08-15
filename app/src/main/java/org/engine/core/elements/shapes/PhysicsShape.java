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
        return this.gravityForceDirection;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public double getGravityForce() {
        return this.gravityForce;
    }

    public double getFrictionForce() {
        return this.frictionForce;
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
        this.posX += this.xVelocity * delta;
        this.posY += this.yVelocity * delta;
        switch (this.gravityForceDirection) {
            case PhysicsShape.FORCE_DIRECTION_Y:
                applyFrictionForce(this.xVelocity, delta);
                applyGravityforce(this.yVelocity, delta);
                break;
            case PhysicsShape.FORCE_DIRECTION_X:
                applyGravityforce(this.xVelocity, delta);
                applyFrictionForce(this.yVelocity, delta);
                break;
            default:
                applyFrictionForce(this.xVelocity, delta);
                applyFrictionForce(this.yVelocity, delta);
                break;
        }
    }

    private void applyFrictionForce(double velocity, int delta) {
        if (velocity > 0 && velocity - (this.frictionForce * delta) > 0) {
            velocity -= this.frictionForce * delta;
            return;
        }
        if (velocity < 0 && velocity + (this.frictionForce * delta) < 0) {
            velocity += this.frictionForce * delta;
            return;
        }
        velocity = 0;
    }

    private void applyGravityforce(double velocity, int delta) {
        if (velocity > this.gravityForce * 10) {
            velocity = this.gravityForce * 10;
        }
        velocity += this.gravityForce * delta;
    }
}
