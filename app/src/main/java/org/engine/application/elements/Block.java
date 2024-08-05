package org.engine.application.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.application.characteristics.PhysicsNode;
import org.engine.application.characteristics.PositionNode;
import org.engine.application.characteristics.QuadShapeNode;
import org.engine.application.rules.camera.CameraRule;
import org.engine.core.Element;

public class Block extends Element {
    protected Block(UUID key) {
        super(key);
    }

    static public Block build(double posX, double posY, double width, double height, @Nullable UUID key) {
        final Block gameObject = new Block(key);

        final PositionNode positionNode = new PositionNode(posX, posY);
        gameObject.nodes.add(positionNode);

        final QuadShapeNode shapeNode = new QuadShapeNode(gameObject, width, height);
        shapeNode.backgroundColor = new Color(0xff0000);
        gameObject.nodes.add(shapeNode);

        final PhysicsNode physicsNode = new PhysicsNode(gameObject, false);
        gameObject.nodes.add(physicsNode);

        CameraRule.getInstance().setFocus(gameObject);

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
