package org.engine.presentation.HitboxSceneTest.elements;

import java.awt.Color;
import org.engine.core.elements.shapes.AreaShape;
import org.engine.core.elements.shapes.CollisionShape;

public class ColorChangerArea extends AreaShape {

    public ColorChangerArea(double posX, double posY) {
        super(posX, posY, 100, 60, 2);
        this.setBorderColor(Color.RED);
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }

    @Override
    public void onCollision(CollisionShape collisionShape) {
    }

    @Override
    public void onAreaEnter(CollisionShape collisionShape) {
        collisionShape.setBackgroundColor(Color.BLACK);
    }

    @Override
    public void onAreaLeave(CollisionShape collisionShape) {
        collisionShape.setBackgroundColor(Color.RED);

    }

}
