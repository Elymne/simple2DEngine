package org.engine.core.elements.shapes.squads;

import java.util.ArrayList;
import org.engine.core.attributes.Vector2D;

abstract public class SquadAreaShape extends SquadCollisionShape {
    private final ArrayList<SquadCollisionShape> collisionBuffer = new ArrayList<SquadCollisionShape>();

    public SquadAreaShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public SquadAreaShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }

    abstract public void onCollision(SquadCollisionShape collisionShape);

    abstract public void onAreaEnter(SquadCollisionShape collisionShape);

    abstract public void onAreaLeave(SquadCollisionShape collisionShape);

    @Override
    public void listenCollision(ArrayList<SquadCollisionShape> buffer, int timeDefinallta) {
        for (int i = 0; i < buffer.size(); i++) {
            onCollision(buffer.get(i));
            if (!collisionBuffer.contains(buffer.get(i))) {
                onAreaEnter(buffer.get(i));
                collisionBuffer.add(buffer.get(i));
            }
        }
        final ArrayList<SquadCollisionShape> diff = new ArrayList<SquadCollisionShape>(collisionBuffer);
        diff.removeAll(buffer);
        collisionBuffer.removeAll(diff);
        for (int i = 0; i < diff.size(); i++) {
            onAreaLeave(diff.get(i));
        }
    }
}
