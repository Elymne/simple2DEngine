package org.engine.rework.elements.shapes;

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
            this.onCollision(buffer.get(i));
            if (!this.collisionShapeContacts.contains(buffer.get(i))) {
                this.onAreaEnter(buffer.get(i));
                this.collisionShapeContacts.add(buffer.get(i));
            }
        }
        final ArrayList<CollisionShape> diff = new ArrayList<CollisionShape>(this.collisionShapeContacts);
        diff.removeAll(buffer);
        this.collisionShapeContacts.removeAll(diff);
        for (int i = 0; i < diff.size(); i++) {
            this.onAreaLeave(diff.get(i));
        }
    }
}
