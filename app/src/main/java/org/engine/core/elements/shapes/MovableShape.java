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
        this.nextDistX = posX - this.posX;
        this.nextDistY = posY - this.posY;
        this.totalNextPosDuration = duration;
        this.currentNextPosDuration = duration;
    }

    public void slide(double distX, double distY, int duration) {
        this.nextDistX = distX;
        this.nextDistY = distY;
        this.totalNextPosDuration = duration;
        this.currentNextPosDuration = duration;
    }

    public void move_to(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
        this.nextDistX = 0.0;
        this.nextDistY = 0.0;
        this.totalNextPosDuration = 0;
        this.currentNextPosDuration = 0;
    }

    public void move(double distX, double distY) {
        this.posX += distX;
        this.posY += distY;
        this.nextDistX = 0.0;
        this.nextDistY = 0.0;
        this.totalNextPosDuration = 0;
        this.currentNextPosDuration = 0;
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int delta) {
        if (this.currentNextPosDuration <= 0) {
            return;
        }
        final double di = this.totalNextPosDuration / delta;
        this.currentNextPosDuration -= delta;
        this.posX += this.nextDistX / di;
        this.posY += this.nextDistY / di;

    }
}
