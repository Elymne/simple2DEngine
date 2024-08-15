package org.engine.core.elements.shapes;

import java.util.ArrayList;

abstract public class AreaShape extends CollisionShape {
    private final ArrayList<CollisionShape> collisionShapeContacts = new ArrayList<CollisionShape>();

    public AreaShape(String name, double posX, double posY, double width, double height, int zIndex) {
        super(name, posX, posY, width, height, zIndex);
    }

    public AreaShape(double posX, double posY, double width, double height, int zIndex) {
        super(posX, posY, width, height, zIndex);
    }

    abstract public void onCollision(CollisionShape collisionShape);

    abstract public void onAreaEnter(CollisionShape collisionShape);

    abstract public void onAreaLeave(CollisionShape collisionShape);

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int timeDefinallta) {
        for (int i = 0; i < buffer.size(); i++) {
            onCollision(buffer.get(i));
            if (!collisionShapeContacts.contains(buffer.get(i))) {
                onAreaEnter(buffer.get(i));
                collisionShapeContacts.add(buffer.get(i));
            }
        }
        final ArrayList<CollisionShape> diff = new ArrayList<CollisionShape>(collisionShapeContacts);
        diff.removeAll(buffer);
        collisionShapeContacts.removeAll(diff);
        for (int i = 0; i < diff.size(); i++) {
            onAreaLeave(diff.get(i));
        }
    }
}
