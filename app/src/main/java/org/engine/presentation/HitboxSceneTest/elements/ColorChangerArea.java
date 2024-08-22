package org.engine.presentation.HitboxSceneTest.elements;

import java.awt.Color;
import org.engine.core.attributes.Vector2D;
import org.engine.core.elements.shapes.squads.SquadAreaShape;
import org.engine.core.elements.shapes.squads.SquadCollisionShape;

public class ColorChangerArea extends SquadAreaShape {

    public ColorChangerArea(double posX, double posY) {
        super(new Vector2D(posX, posY), 100, 60, 2);
        this.setBorderColor(Color.RED);
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }

    @Override
    public void onCollision(SquadCollisionShape collisionShape) {
    }

    @Override
    public void onAreaEnter(SquadCollisionShape collisionShape) {
        collisionShape.setBackgroundColor(Color.BLACK);
    }

    @Override
    public void onAreaLeave(SquadCollisionShape collisionShape) {
        collisionShape.setBackgroundColor(Color.RED);

    }

}
