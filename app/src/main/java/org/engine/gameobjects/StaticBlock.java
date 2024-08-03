package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.exceptions.NoPositionNodeException;
import org.engine.nodes.PhysicsNode;
import org.engine.nodes.PositionNode;
import org.engine.tools.constants.Colors;

public class StaticBlock extends GameObject {
    protected StaticBlock(UUID key) {
        super(key);
    }

    static public StaticBlock build(double posX, double posY, double width, double height, @Nullable UUID key)
            throws NoPositionNodeException {
        final StaticBlock gameObject = new StaticBlock(key);

        final PositionNode positionNode = new PositionNode(posX, posY);
        gameObject.nodes.add(positionNode);

        final PhysicsNode simplePhysicsNode = new PhysicsNode(gameObject, width, height, true);
        gameObject.nodes.add(simplePhysicsNode);

        return gameObject;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Colors.CUSTOM_BLUE.darker());
        g.drawRect(
                (int) getPositionNode().posX,
                (int) getPositionNode().posY,
                (int) getCollisionNode().width,
                (int) getCollisionNode().heigth);
        g.setColor(Colors.CUSTOM_BLUE);
        g.fillRect(
                (int) getPositionNode().posX,
                (int) getPositionNode().posY,
                (int) getCollisionNode().width,
                (int) getCollisionNode().heigth);
    }

    private PositionNode getPositionNode() {
        return (PositionNode) nodes.get(0);
    }

    private PhysicsNode getCollisionNode() {
        return (PhysicsNode) nodes.get(1);
    }
}
