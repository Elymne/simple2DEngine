package org.engine.presentation.HitboxSceneTest.elements;

import java.awt.Color;

import org.engine.core.attributes.Vector2D;
import org.engine.core.elements.shapes.squads.SquadMovableShape;

public class RedSquare extends SquadMovableShape {
    public RedSquare(double posX, double posY) {
        super(new Vector2D(posX, posY), 40, 40, 1);
        this.backgroundColor = Color.RED;
        this.borderColor = Color.RED.darker().darker();
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }
}
