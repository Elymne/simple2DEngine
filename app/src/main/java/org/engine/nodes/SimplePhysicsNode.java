package org.engine.nodes;

import org.engine.tools.physics.Physics;
import org.engine.tools.physics.PhysicsListener;

public class SimplePhysicsNode extends Node implements PhysicsListener {
    private PositionNode positionNode;
    private CollisionNode collisionNode;

    private double velocityThreshold = 1.0;
    private double velocity = 0;

    public SimplePhysicsNode(PositionNode positionNode, CollisionNode collisionNode) {
        Physics.getInstance().addNewListener(this);
        this.positionNode = positionNode;
        this.collisionNode = collisionNode;
    }

    @Override
    public void onNextFrame(int time) {
        falling();
        System.out.println("Added velocity : " + velocity * time);

        // positionNode.posY = positionNode.posY + velocity * (time / 100);
        // System.out.println(positionNode.posY);
    }

    private void falling() {
        if (velocity < velocityThreshold) {
            velocity += 0.2;
        } else if (velocity > velocityThreshold) {
            velocity = velocityThreshold;
        }
    }

    public double getVelocity() {
        return velocity;
    }
}
