package org.engine.core.elements.shapes;

import java.util.ArrayList;
import org.engine.core.attributes.Vector2D;

abstract public class MovableShape extends CollisionShape {
    private double nextDistX = 0.0;
    private double nextDistY = 0.0;
    private int totalNextPosDuration = 0;
    private int currentNextPosDuration = 0;

    public MovableShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public MovableShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }

    public void slide_to(Vector2D distance, int duration) {
        nextDistX = pos.x - distance.x;
        nextDistY = pos.y - distance.y;
        totalNextPosDuration = duration;
        currentNextPosDuration = duration;
    }

    public void slide(Vector2D distance, int duration) {
        nextDistX = distance.x;
        nextDistY = distance.y;
        totalNextPosDuration = duration;
        currentNextPosDuration = duration;
    }

    public void move_to(Vector2D pos) {
        this.pos.x = pos.x;
        this.pos.y = pos.y;
        nextDistX = 0.0;
        nextDistY = 0.0;
        totalNextPosDuration = 0;
        currentNextPosDuration = 0;
    }

    public void move(Vector2D pos) {
        this.pos.x += pos.x;
        this.pos.y += pos.y;
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
        pos.x += nextDistX / di;
        pos.y += nextDistY / di;
    }
}
