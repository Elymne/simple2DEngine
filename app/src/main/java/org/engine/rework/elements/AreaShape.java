package org.engine.rework.elements;

import java.util.ArrayList;

abstract public class AreaShape extends CollisionShape {
    public AreaShape(String name,
            double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(name, posX, posY, width, height, zIndex, elements);
    }

    public AreaShape(double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(posX, posY, width, height, zIndex, elements);
    }

    abstract public void onCollision(CollisionShape collisionShape);

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int timeDefinallta) {
        for (int i = 0; i < buffer.size(); i++) {
            this.onCollision(buffer.get(i));
        }
    }
}
