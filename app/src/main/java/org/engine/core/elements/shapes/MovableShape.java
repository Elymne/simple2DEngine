package org.engine.core.elements.shapes;

import java.util.ArrayList;

abstract public class MovableShape extends CollisionShape {
    private double nextDistX = 0.0;
    private double nextDistY = 0.0;
    private int totalNextPosDuration = 0;
    private int currentNextPosDuration = 0;

    public MovableShape(String name, double posX, double posY, double width, double height, int zIndex) {
        super(name, posX, posY, width, height, zIndex);
    }

    public MovableShape(double posX, double posY, double width, double height, int zIndex) {
        super(posX, posY, width, height, zIndex);
    }

    public void slide_to(double posX, double posY, int duration) {
        nextDistX = posX - posX;
        nextDistY = posY - posY;
        totalNextPosDuration = duration;
        currentNextPosDuration = duration;
    }

    public void slide(double distX, double distY, int duration) {
        nextDistX = distX;
        nextDistY = distY;
        totalNextPosDuration = duration;
        currentNextPosDuration = duration;
    }

    public void move_to(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        nextDistX = 0.0;
        nextDistY = 0.0;
        totalNextPosDuration = 0;
        currentNextPosDuration = 0;
    }

    public void move(double distX, double distY) {
        posX += distX;
        posY += distY;
        nextDistX = 0.0;
        nextDistY = 0.0;
        totalNextPosDuration = 0;
        currentNextPosDuration = 0;
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int delta) {
        if (currentNextPosDuration <= 0) {
            return;
        }
        final double di = totalNextPosDuration / delta;
        currentNextPosDuration -= delta;
        posX += nextDistX / di;
        posY += nextDistY / di;
    }
}
