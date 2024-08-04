package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.nodes.physics.PhysicsNode;
import org.engine.nodes.shapes.QuadShapeNode;
import org.engine.tools.constants.Colors;

public class Block extends GameObject {
    protected Block(UUID key) {
        super(key);
    }

    static public Block build(double posX, double posY, double width, double height, @Nullable UUID key) {
        final Block gameObject = new Block(key);

        final QuadShapeNode shapeNode = new QuadShapeNode(posX, posY, width, height, Colors.CUSTOM_RED);
        gameObject.nodes.add(shapeNode);

        final PhysicsNode physicsNode = new PhysicsNode(gameObject, false);
        gameObject.nodes.add(physicsNode);

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
