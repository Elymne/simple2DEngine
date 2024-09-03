package org.engine.presentation.PhysicsSceneTest.elements;

import java.awt.Color;
import java.util.ArrayList;

import org.engine.core.attributes.Vector2D;
import org.engine.core.elements.shapes.squads.SquadCollisionShape;
import org.engine.core.elements.shapes.squads.SquadStaticShape;

public class Floor extends SquadStaticShape {
    public Floor(double posX, double posY) {
        super(new Vector2D(posX, posY), 1000, 20, 2);
        this.backgroundColor = Color.BLUE;
        this.borderColor = Color.BLUE.darker().darker();
    }

    @Override
    public void listenCollision(ArrayList<SquadCollisionShape> buffer, int timeDelta) {
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }
}
