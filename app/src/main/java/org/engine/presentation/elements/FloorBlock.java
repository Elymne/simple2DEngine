package org.engine.presentation.elements;

import java.awt.Color;
import java.util.ArrayList;

import org.engine.core.elements.shapes.CollisionShape;
import org.engine.core.elements.shapes.StaticShape;

public class FloorBlock extends StaticShape {
    public FloorBlock(double posX, double posY) {
        super(posX, posY, 1000, 20, 2);
        this.backgroundColor = new Color(0xf0f0f0);
        this.borderColor = new Color(0xf1f1f1);
    }

    @Override
    public void listenCollision(ArrayList<CollisionShape> buffer, int timeDelta) {
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }
}
