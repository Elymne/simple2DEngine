package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.exceptions.NoPositionNodeException;
import org.engine.nodes.PhysicsNode;
import org.engine.nodes.ShapeNode;
import org.engine.tools.constants.Colors;

public class Block extends GameObject {
    protected Block(UUID key) {
        super(key);
    }

    static public Block build(double posX, double posY, double width, double height, @Nullable UUID key)
            throws NoPositionNodeException {
        final Block gameObject = new Block(key);

        final ShapeNode shapeNode = new ShapeNode(posX, posY, width, height);
        gameObject.nodes.add(shapeNode);

        final PhysicsNode physicsNode = new PhysicsNode(gameObject, false);
        gameObject.nodes.add(physicsNode);

        return gameObject;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Colors.CUSTOM_RED.darker());
        g.drawRect(
                (int) getShapeNode().posX,
                (int) getShapeNode().posY,
                (int) getShapeNode().width,
                (int) getShapeNode().height);
        g.setColor(Colors.CUSTOM_RED);
        g.fillRect(
                (int) getShapeNode().posX,
                (int) getShapeNode().posY,
                (int) getShapeNode().width,
                (int) getShapeNode().height);
    }

    private ShapeNode getShapeNode() {
        return (ShapeNode) nodes.get(0);
    }

}
