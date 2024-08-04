package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.nodes.PhysicsNode;
import org.engine.nodes.ShapeNode;
import org.engine.tools.constants.Colors;

public class StaticBlock extends GameObject {
    protected StaticBlock(UUID key) {
        super(key);
    }

    static public StaticBlock build(double posX, double posY, double width, double height, @Nullable UUID key) {
        final StaticBlock gameObject = new StaticBlock(key);

        final ShapeNode shapeNode = new ShapeNode(posX, posY, width, height);
        gameObject.nodes.add(shapeNode);

        final PhysicsNode simplePhysicsNode = new PhysicsNode(gameObject, true);
        gameObject.nodes.add(simplePhysicsNode);

        return gameObject;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Colors.CUSTOM_BLUE.darker());
        g.drawRect(
                (int) getPositionNode().posX,
                (int) getPositionNode().posY,
                (int) getPositionNode().width,
                (int) getPositionNode().height);
        g.setColor(Colors.CUSTOM_BLUE);
        g.fillRect(
                (int) getPositionNode().posX,
                (int) getPositionNode().posY,
                (int) getPositionNode().width,
                (int) getPositionNode().height);
    }

    private ShapeNode getPositionNode() {
        return (ShapeNode) nodes.get(0);
    }

}
