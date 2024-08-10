package org.engine.rework.elements.shapes;

import java.util.ArrayList;

import org.engine.rework.elements.Element;

public abstract class RigidShape extends CollisionShape {
    protected int state = UNDEFINED_STATE;

    public static int UNDEFINED_STATE = 0;
    public static int WAITING_STATE = 1;
    public static int RUNNING_STATE = 2;

    public RigidShape(String name,
            double posX, double posY,
            double width, double height,
            int zIndex, boolean isRuning,
            ArrayList<Element> elements) {
        super(name, posX, posY, width, height, zIndex, elements);
    }

    public RigidShape(double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(posX, posY, width, height, zIndex, elements);
    }

    public void push(int posX, int posY) {

    }

    public void updateState(int state) {
        if (state == this.state) {
            System.err.println("Same state.");
            return;
        }
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int delta) {
        if (this.state == RigidShape.UNDEFINED_STATE || this.state == RigidShape.WAITING_STATE) {
            return;
        }
    }
}
