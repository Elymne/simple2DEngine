package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.nodes.SimplePhysicsNode;
import org.engine.nodes.CollisionNode;
import org.engine.nodes.Node;
import org.engine.nodes.PositionNode;
import org.engine.tools.constants.Colors;

public class Block extends GameObject {
    public Block(double posX, double posY, double width, double height, @Nullable UUID key) {
        super(key);
        final PositionNode positionNode = new PositionNode(posX, posY);
        final CollisionNode collisionNode = new CollisionNode(this, width, height);
        final SimplePhysicsNode simplePhysicsNode = new SimplePhysicsNode(positionNode, collisionNode);

        this.nodes.addAll(new ArrayList<Node>(Arrays.asList(new Node[] {
                positionNode, collisionNode, simplePhysicsNode
        })));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Colors.CUSTOM_RED.darker());
        g.drawRect(
                (int) getPositionNode().posX,
                (int) getPositionNode().posY,
                (int) getCollisionNode().width,
                (int) getCollisionNode().heigth);
        g.setColor(Colors.CUSTOM_RED);
        g.fillRect(
                (int) getPositionNode().posX,
                (int) getPositionNode().posY,
                (int) getCollisionNode().width,
                (int) getCollisionNode().heigth);
    }

    private PositionNode getPositionNode() {
        return (PositionNode) nodes.get(0);
    }

    private CollisionNode getCollisionNode() {
        return (CollisionNode) nodes.get(0);
    }
}
