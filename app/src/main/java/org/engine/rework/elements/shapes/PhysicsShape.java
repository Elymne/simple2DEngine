package org.engine.rework.elements.shapes;

import java.util.ArrayList;
import org.engine.rework.elements.Element;

public abstract class PhysicsShape extends CollisionShape {
    private ArrayList<CollisionShape> cacheCollision;

    private int gravityForceDirection = PhysicsShape.FORCE_DIRECTION_NONE;
    private double gravityForce = 0.0;
    private double yVelocity = 0.0;
    private double xVelocity = 0.0;

    public static int FORCE_DIRECTION_NONE = 0;
    public static int FORCE_DIRECTION_X = 1;
    public static int FORCE_DIRECTION_y = 2;

    public PhysicsShape(String name,
            double posX, double posY,
            double width, double height,
            int zIndex, boolean isRuning,
            ArrayList<Element> elements) {
        super(name, posX, posY, width, height, zIndex, elements);
    }

    public PhysicsShape(double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(posX, posY, width, height, zIndex, elements);
    }

    public void push(int xVelocity, int yVelocity) {
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

    public void changeForceDirection(int forceDirection) {
        if (this.gravityForce == forceDirection) {
            System.err.println("Same force direction.");
            return;
        }
        this.gravityForce = forceDirection;
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int delta) {
        if (this.gravityForce == PhysicsShape.FORCE_DIRECTION_NONE) {
            return;
        }

        // if (buffer.size() == 0) {
        // falling(delta);
        // return;
        // }

    }

    // private void falling(int timeDelta) {
    // shape.updatePosY(shape.getPosY() - fallingSpeed * timeDelta);
    // return;
    // }
}
