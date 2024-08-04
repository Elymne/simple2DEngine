package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;

import org.engine.nodes.camera.PositionNode;
import org.engine.nodes.physics.PhysicsNode;
import org.engine.nodes.shapes.QuadShapeNode;
import org.engine.tools.constants.Colors;

public class StaticBlock extends GameObject {
    protected StaticBlock(UUID key) {
        super(key);
    }

    static public StaticBlock build(double posX, double posY, double width, double height, @Nullable UUID key) {
        final StaticBlock gameObject = new StaticBlock(key);

        final PositionNode positionNode = new PositionNode(posX, posY);
        gameObject.nodes.add(positionNode);

        final QuadShapeNode shapeNode = new QuadShapeNode(gameObject, width, height);
        shapeNode.backgroundColor = Colors.CUSTOM_BLUE;
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
