package org.engine.application.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.application.characteristics.PhysicsNode;
import org.engine.application.characteristics.PositionNode;
import org.engine.application.characteristics.QuadShapeNode;
import org.engine.core.Element;

public class StaticBlock extends Element {
    protected StaticBlock(UUID key) {
        super(key);
    }

    static public StaticBlock build(double posX, double posY, double width, double height, @Nullable UUID key) {
        final StaticBlock gameObject = new StaticBlock(key);

        final PositionNode positionNode = new PositionNode(posX, posY);
        gameObject.nodes.add(positionNode);

        final QuadShapeNode shapeNode = new QuadShapeNode(gameObject, width, height);
        shapeNode.backgroundColor = new Color(0x0000ff);
        gameObject.nodes.add(shapeNode);

        final PhysicsNode simplePhysicsNode = new PhysicsNode(gameObject, true);
        gameObject.nodes.add(simplePhysicsNode);

        return gameObject;
    }

    @Override
    public void paint(Graphics g) {
        final QuadShapeNode quadShapeNode = (QuadShapeNode) findNode(QuadShapeNode.class);
        if (quadShapeNode != null) {
            quadShapeNode.draw(g);
        }
    }

}
