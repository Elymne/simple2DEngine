package org.engine.presentation.elements;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;

import org.engine.core.characteristics.Physics;
import org.engine.core.characteristics.Position;
import org.engine.core.characteristics.QuadShape;
import org.engine.core.elements.Element;
import org.engine.core.rules.camera.CameraRule;

public class Block extends Element {
    protected Block(String key) {
        super(key);
    }

    static public Block build(double posX, double posY, double width, double height, @Nullable String key) {
        final Block gameObject = new Block(key);

        final Position positionNode = new Position(posX, posY);
        gameObject.characteristic.add(positionNode);

        final QuadShape shapeNode = new QuadShape(gameObject, width, height);
        shapeNode.backgroundColor = new Color(0xff0000);
        gameObject.characteristic.add(shapeNode);

        final Physics physicsNode = new Physics(gameObject, false);
        gameObject.characteristic.add(physicsNode);

        CameraRule.getInstance().setFocus(gameObject);

        return gameObject;
    }

    @Override
    public void paint(Graphics g) {
        final QuadShape quadShapeNode = (QuadShape) findCharacteristic(QuadShape.class);
        if (quadShapeNode != null) {
            quadShapeNode.draw(g);
        }
    }
}
