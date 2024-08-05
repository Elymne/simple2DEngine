package org.engine.application.characteristics;

import java.util.ArrayList;

import org.engine.application.rules.physics.PhysicsListener;
import org.engine.application.rules.physics.SimplePhysics;
import org.engine.constants.CustomErrors;
import org.engine.core.Characteristic;
import org.engine.core.Element;

public class PhysicsNode extends Characteristic implements PhysicsListener {
    public boolean isStatic;

    private QuadShapeNode shapeNode;

    private double velocityY = 0;
    private double velocityX = 0;

    private double fallingAdditivity = 0.002;
    private double fallingThreshold = 0.08;

    private boolean isJumping = false;
    private boolean isMoving = false;

    public PhysicsNode(Element gameObject, boolean isStatic) {
        final QuadShapeNode shapeNode = (QuadShapeNode) gameObject.findNode(QuadShapeNode.class);
        if (shapeNode == null) {
            System.err.println(CustomErrors.NO_QUAD_SHAPE_FOUND);
            return;
        }

        this.shapeNode = shapeNode;
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

        shapeNode.positionNode.posY = shapeNode.positionNode.posY + velocityY * timeDelta;
        return;

    }

    private void jumping(int timeDelta) {
    }

    private void moving(int deltaTime) {
    }

    @Override
    public void listenCollision(ArrayList<Element> buffer, int timeDelta) {
        if (isMoving) {
            moving(timeDelta);
        }

        if (isJumping) {
            jumping(timeDelta);
            return;
        }

        if (buffer.size() == 0) {
            falling(timeDelta);
            return;
        }

        final QuadShapeNode firstCollisionShape = (QuadShapeNode) buffer.getFirst().findNode(QuadShapeNode.class);

        // if (firstCollisionShape != null
        // && -shapeNode.positionNode.posY + shapeNode.height <=
        // -firstCollisionShape.positionNode.posY) {
        // shapeNode.positionNode.posY = -firstCollisionShape.positionNode.posY -
        // shapeNode.height;
        // }

        velocityY = 0;
    }
}
