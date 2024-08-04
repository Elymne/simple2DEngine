package org.engine.nodes.physics;

import java.util.ArrayList;
import org.engine.gameobjects.GameObject;
import org.engine.nodes.Node;
import org.engine.nodes.shapes.QuadShapeNode;
import org.engine.tools.physics.collision.Collision;
import org.engine.tools.physics.collision.CollisionListener;

public class PhysicsNode extends Node implements CollisionListener {
    private QuadShapeNode shapeNode;
    public boolean isStatic;

    private double velocity = 0;
    private double velocityThreshold = 0.2;
    private boolean isJumping = false;
    private boolean isMoving = false;

    public PhysicsNode(GameObject gameObject, boolean isStatic) {
        final QuadShapeNode shapeNode = (QuadShapeNode) gameObject.findNode(QuadShapeNode.class);
        if (shapeNode == null) {
            System.err.println(
                    "Physics Node hasn't been set, you have to use a shape node to the game object to be able to use physics.");
            return;
        }

        this.shapeNode = shapeNode;
        this.isStatic = isStatic;
        Collision.getInstance().addNewGameObject(gameObject);
    }

    public double getVelocity() {
        return velocity;
    }

    private void falling(int timeDelta) {
        if (velocity < velocityThreshold) {
            velocity += 0.04;
        } else if (velocity > velocityThreshold) {
            velocity = velocityThreshold;
        }
        shapeNode.posY = shapeNode.posY + velocity * timeDelta;
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

        if (isMoving) {
            moving(timeDelta);
            return;
        }

        if (buffer.size() == 0) {
            falling(timeDelta);
            return;
        }

        final QuadShapeNode firstCollisionShape = (QuadShapeNode) buffer.getFirst().findNode(QuadShapeNode.class);
        if (firstCollisionShape != null && shapeNode.posY + shapeNode.height >= firstCollisionShape.posY) {
            shapeNode.posY = firstCollisionShape.posY - shapeNode.height;
        }

        velocity = 0;
    }
}
