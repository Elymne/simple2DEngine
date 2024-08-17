package org.engine.core.elements.shapes;

import java.util.ArrayList;

import org.engine.core.attributes.Vector2D;

abstract public class AreaShape extends CollisionShape {
    private final ArrayList<CollisionShape> collisionBuffer = new ArrayList<CollisionShape>();

    public AreaShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, width, height, zIndex);
    }

    public AreaShape(Vector2D position, double width, double height, int zIndex) {
        super(position, width, height, zIndex);
    }

    abstract public void onCollision(CollisionShape collisionShape);

    abstract public void onAreaEnter(CollisionShape collisionShape);

    abstract public void onAreaLeave(CollisionShape collisionShape);

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int timeDefinallta) {
        for (int i = 0; i < buffer.size(); i++) {
            onCollision(buffer.get(i));
            if (!collisionBuffer.contains(buffer.get(i))) {
                onAreaEnter(buffer.get(i));
                collisionBuffer.add(buffer.get(i));
            }
        }
        final ArrayList<CollisionShape> diff = new ArrayList<CollisionShape>(collisionBuffer);
        diff.removeAll(buffer);
        collisionBuffer.removeAll(diff);
        for (int i = 0; i < diff.size(); i++) {
            onAreaLeave(diff.get(i));
        }
    }
}
