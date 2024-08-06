package org.engine.core.characteristics;

import java.util.ArrayList;

import org.engine.core.constants.CustomErrors;
import org.engine.core.elements.Element;
import org.engine.core.rules.physics.PhysicsListener;
import org.engine.core.rules.physics.SimplePhysics;

public class Physics extends Characteristic implements PhysicsListener {
    public boolean isStatic;

    private QuadShape shape;

    private double velocityY = 0;
    private double fallingAdditivity = 0.002;
    private double fallingThreshold = 0.08;

    public Physics(Element gameObject, boolean isStatic) {
        final QuadShape shape = (QuadShape) gameObject.findCharacteristic(QuadShape.class);
        if (shape == null) {
            System.err.println(CustomErrors.NO_QUAD_SHAPE_FOUND);
            return;
        }

        this.shape = shape;
        this.isStatic = isStatic;
        SimplePhysics.getInstance().addNewGameObject(gameObject);
    }

    public double getVelocityY() {
        return velocityY;
    }

    private void falling(int timeDelta) {
        if (velocityY > -fallingThreshold) {
            velocityY -= fallingAdditivity;
        }

        if (velocityY < -fallingThreshold) {
            velocityY = -fallingThreshold;
        }

        shape.positionNode.posY = shape.positionNode.posY + velocityY * timeDelta;
        return;

    }

    @Override
    public void listenCollision(ArrayList<Element> buffer, int timeDelta) {
        if (buffer.size() == 0) {
            falling(timeDelta);
            return;
        }

        final QuadShape firstShape = (QuadShape) buffer.getFirst().findCharacteristic(QuadShape.class);
        if (firstShape != null && shape.positionNode.posY + shape.height <= firstShape.positionNode.posY) {
            shape.positionNode.posY = firstShape.positionNode.posY + shape.height;
        }

        velocityY = 0;
    }
}
