package org.engine.core.elements.shapes.squads;

import java.util.ArrayList;
import org.engine.core.attributes.Vector2D;

abstract public class SquadMovableShape extends SquadCollisionShape {
    private Vector2D nextPosition = this.position;
    private int currentTravelDuration = 0;
    private int totalTravelDuration = 0;

    public SquadMovableShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public SquadMovableShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }

    public void slide_to(Vector2D position, int duration) {
        nextPosition = position;
        currentTravelDuration = duration;
        totalTravelDuration = duration;
    }

    public void slide(Vector2D distance, int duration) {
        nextPosition.add(distance);
        currentTravelDuration = duration;
        totalTravelDuration = duration;
    }

    public void move_to(Vector2D newPosition) {
        position.update(position);
        nextPosition.update(position);
        currentTravelDuration = 0;
    }

    public void move(Vector2D distance) {
        distance.add(distance);
        nextPosition.update(this.position);
        currentTravelDuration = 0;
    }

    @Override
    public void listenCollision(ArrayList<SquadCollisionShape> buffer, int delta) {
        if (currentTravelDuration <= 0) {
            return;
        }
        final double di = totalTravelDuration / delta;
        currentTravelDuration -= delta;
        position.add(new Vector2D(nextPosition.getX() / di, nextPosition.getY() / di));
    }
}
