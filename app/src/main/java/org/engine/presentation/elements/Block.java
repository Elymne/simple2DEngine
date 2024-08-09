package org.engine.presentation.elements;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;
import org.engine.core.characteristics.Physics;
import org.engine.core.characteristics.Position;
import org.engine.core.characteristics.QuadShape;
import org.engine.core.elements.Element;

public class Block extends Element {
    protected Block(String key) {
        super(key);
    }

    static public Block build(double posX, double posY, double width, double height, @Nullable String key) {
        final Block element = new Block(key);

        final Position positionNode = new Position(posX, posY);
        element.characteristic.add(positionNode);

        final QuadShape shapeNode = new QuadShape(element, width, height);
        shapeNode.setBackgroundColor(new Color(0xff0000));
        element.characteristic.add(shapeNode);

        final Physics physicsNode = new Physics(element, false);
        element.characteristic.add(physicsNode);

        return element;
    }

    @Override
    public void paint(Graphics g) {
        final QuadShape quadShapeNode = (QuadShape) findCharacteristic(QuadShape.class);
        if (quadShapeNode != null) {
            quadShapeNode.drawFrame(g);
        }
    }
}
