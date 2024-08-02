package org.engine.nodes;

import org.engine.tools.physics.Physics;
import org.engine.tools.physics.PhysicsListener;

public class SimplePhysicsNode extends Node implements PhysicsListener {
    private PositionNode positionNode;

    private double velocity = 0;
    private double velocityThreshold = 0.2;

    public SimplePhysicsNode(PositionNode positionNode, CollisionNode collisionNode) {
        Physics.getInstance().addNewListener(this);
        this.positionNode = positionNode;
    }

    @Override
    public void onNextFrame(int time) {
        falling();
        System.out.println("Added velocity : " + velocity * time);
        positionNode.posY = positionNode.posY + velocity * time;
        System.out.println(positionNode.posY);
    }

    private void falling() {
        if (velocity < velocityThreshold) {
            velocity += 0.04;
        } else if (velocity > velocityThreshold) {
            velocity = velocityThreshold;
        }
    }

    public double getVelocity() {
        return velocity;
    }
}
