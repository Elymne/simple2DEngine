package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;

import org.engine.core.constants.Colors;
import org.engine.core.screen.CameraManager;
import org.engine.nodes.camera.PositionNode;
import org.engine.nodes.physics.PhysicsNode;
import org.engine.nodes.shapes.QuadShapeNode;

public class Block extends GameObject {
    protected Block(UUID key) {
        super(key);
    }

    static public Block build(double posX, double posY, double width, double height, @Nullable UUID key) {
        final Block gameObject = new Block(key);

        final PositionNode positionNode = new PositionNode(posX, posY);
        gameObject.nodes.add(positionNode);

        final QuadShapeNode shapeNode = new QuadShapeNode(gameObject, width, height);
        shapeNode.backgroundColor = Colors.CUSTOM_RED;
        gameObject.nodes.add(shapeNode);

        final PhysicsNode physicsNode = new PhysicsNode(gameObject, false);
        gameObject.nodes.add(physicsNode);

        CameraManager.getInstance().setFocus(gameObject);

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
