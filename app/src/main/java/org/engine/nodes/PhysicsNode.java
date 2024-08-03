package org.engine.nodes;

import java.util.ArrayList;
import org.engine.exceptions.NoPositionNodeException;
import org.engine.gameobjects.GameObject;
import org.engine.tools.physics.collision.Collision;
import org.engine.tools.physics.collision.CollisionListener;

public class PhysicsNode extends Node implements CollisionListener {
    public final double width;
    public final double heigth;
    public final boolean isStatic;
    private final PositionNode positionNode;

    private double velocity = 0;
    private double velocityThreshold = 0.2;
    private boolean isJumping = false;

    public PhysicsNode(GameObject gameObject, double width, double heigth, boolean isStatic)
            throws NoPositionNodeException {

        final PositionNode positionNode = (PositionNode) gameObject.findNode(PositionNode.class);
        if (positionNode == null) {
            throw new NoPositionNodeException(gameObject);
        }

        this.positionNode = positionNode;
        this.width = width;
        this.heigth = heigth;
        this.isStatic = isStatic;

        Collision.getInstance().addNewGameObject(gameObject);
    }

    public double getVelocity() {
        return velocity;
    }

    // TODO : Rework this.
    private void falling(int timeDelta) {
        if (velocity < velocityThreshold) {
            velocity += 0.04;
        } else if (velocity > velocityThreshold) {
            velocity = velocityThreshold;
        }
        positionNode.posY = positionNode.posY + velocity * timeDelta;
    }

    private void jumping(int timeDelta) {
    }

    private void moving(int deltaTime) {
    }

    @Override
    public void listenCollision(ArrayList<GameObject> buffer, int timeDelta) {
        if (isJumping) {
            jumping(timeDelta);
            return;
        }

        if (buffer.size() == 0) {
            falling(timeDelta);
            return;
        }

        final PositionNode firstCollisionPosition = (PositionNode) buffer.getFirst().findNode(PositionNode.class);
        if (firstCollisionPosition != null && positionNode.posY + heigth >= firstCollisionPosition.posY) {
            positionNode.posY = firstCollisionPosition.posY - heigth;
        }

        velocity = 0;
    }
}
