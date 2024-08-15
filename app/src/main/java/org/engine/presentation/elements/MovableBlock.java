package org.engine.presentation.elements;

import java.awt.Color;

import org.engine.core.elements.shapes.MovableShape;

public class MovableBlock extends MovableShape {
    public MovableBlock(double posX, double posY) {
        super(posX, posY, 40, 40, 1);
        this.backgroundColor = Color.RED;
        this.borderColor = Color.RED.darker().darker();
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }
}
