package org.engine.presentation.PhysicsSceneTest.elements;

import java.awt.Color;
import org.engine.core.attributes.Vector2D;
import org.engine.core.elements.shapes.squads.SquadPhysicsShape;

public class FallingBlock extends SquadPhysicsShape {
    public FallingBlock(double posX, double posY) {
        super(new Vector2D(posX, posY), 40, 40, 2);
        this.backgroundColor = Color.RED;
        this.borderColor = Color.RED.darker().darker();
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }
}
