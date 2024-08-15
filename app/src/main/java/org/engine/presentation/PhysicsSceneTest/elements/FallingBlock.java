package org.engine.presentation.PhysicsSceneTest.elements;

import org.engine.core.elements.shapes.PhysicsShape;

public class FallingBlock extends PhysicsShape {
    public FallingBlock(double posX, double posY) {
        super(posX, posY, 40, 40, 2);
    }

    @Override
    public void onNextFrame(int timeDelta) {
    }
}
