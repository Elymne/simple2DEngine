package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.exceptions.NoPositionNodeException;
import org.engine.nodes.PhysicsNode;
import org.engine.nodes.PositionNode;
import org.engine.tools.constants.Colors;

public class Block extends GameObject {
    protected Block(UUID key) {
        super(key);
    }

    static public Block build(double posX, double posY, double width, double height, @Nullable UUID key)
            throws NoPositionNodeException {
        final Block gameObject = new Block(key);

        final PositionNode positionNode = new PositionNode(posX, posY);
        gameObject.nodes.add(positionNode);

        final PhysicsNode simplePhysicsNode = new PhysicsNode(gameObject, width, height, false);
        gameObject.nodes.add(simplePhysicsNode);

        return gameObject;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Colors.CUSTOM_RED.darker());
        g.drawRect(
                (int) getPositionNode().posX,
                (int) getPositionNode().posY,
                (int) getPhysicsNode().width,
                (int) getPhysicsNode().heigth);
        g.setColor(Colors.CUSTOM_RED);
        g.fillRect(
                (int) getPositionNode().posX,
                (int) getPositionNode().posY,
                (int) getPhysicsNode().width,
                (int) getPhysicsNode().heigth);
    }

    private PositionNode getPositionNode() {
        return (PositionNode) nodes.get(0);
    }

    private PhysicsNode getPhysicsNode() {
        return (PhysicsNode) nodes.get(1);
    }

}
