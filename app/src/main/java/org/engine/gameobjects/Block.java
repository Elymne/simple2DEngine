package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;

import org.engine.nodes.SimplePhysicsNode;
import org.engine.nodes.CollisionNode;
import org.engine.nodes.PositionNode;
import org.engine.tools.constants.Colors;

public class Block extends GameObject {
    public final PositionNode positionNode;
    public final CollisionNode collisionNode;
    public final SimplePhysicsNode physicsNode;

    public Block(int posX, int posY, @Nullable UUID key) {
        super(key);
        positionNode = new PositionNode(posX, posY);
        collisionNode = new CollisionNode();
        physicsNode = new SimplePhysicsNode(positionNode, collisionNode);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Colors.CUSTOM_RED.darker());
        g.drawRect((int) positionNode.posX, (int) positionNode.posY, 40, 40);
        g.setColor(Colors.CUSTOM_RED);
        g.fillRect((int) positionNode.posX, (int) positionNode.posY, 40, 40);
    }
}
