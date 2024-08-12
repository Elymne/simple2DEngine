package org.engine.rework.elements.shapes;

import java.util.ArrayList;
import org.engine.rework.elements.Element;

abstract public class StaticShape extends CollisionShape {
    private final ArrayList<CollisionShape> collisionShapeContacts = new ArrayList<CollisionShape>();

    private double nextDistX = 0.0;
    private double nextDistY = 0.0;
    private int totalNextPosDuration = 0;
    private int currentNextPosDuration = 0;

    public StaticShape(String name,
            double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(name, posX, posY, width, height, zIndex, elements);
    }

    public StaticShape(double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(posX, posY, width, height, zIndex, elements);
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

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int delta) {
        this.collisionShapeContacts.clear();
        this.collisionShapeContacts.addAll(buffer);
    }

    @Override
    public void onNextFrame(int delta) {
        if (this.currentNextPosDuration <= 0) {
            return;
        }

        final double di = this.totalNextPosDuration / delta;
        this.currentNextPosDuration -= delta;
        this.posX += this.nextDistX / di;
        this.posY += this.nextDistY / di;

        // TODO Manage with elems contacts.

    }
}
