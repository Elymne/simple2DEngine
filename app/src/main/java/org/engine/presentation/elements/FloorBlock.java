package org.engine.presentation.elements;

import java.awt.Color;
import java.util.ArrayList;

import org.engine.core.elements.shapes.CollisionShape;
import org.engine.core.elements.shapes.StaticShape;

public class FloorBlock extends StaticShape {
    public FloorBlock(double posX, double posY) {
        super(posX, posY, 1000, 20, 2);
        this.backgroundColor = Color.BLUE;
        this.borderColor = Color.BLUE.darker().darker();
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int timeDelta) {
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }
}
