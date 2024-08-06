package org.engine.presentation.elements;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;

import org.engine.core.characteristics.Physics;
import org.engine.core.characteristics.Position;
import org.engine.core.characteristics.QuadShape;
import org.engine.core.elements.Element;

public class StaticBlock extends Element {
    protected StaticBlock(String key) {
        super(key);
    }

    static public StaticBlock build(double posX, double posY, double width, double height, @Nullable String key) {
        final StaticBlock gameObject = new StaticBlock(key);

        final Position positionNode = new Position(posX, posY);
        gameObject.characteristic.add(positionNode);

        final QuadShape shapeNode = new QuadShape(gameObject, width, height);
        shapeNode.backgroundColor = new Color(0x0000ff);
        gameObject.characteristic.add(shapeNode);

        final Physics simplePhysicsNode = new Physics(gameObject, true);
        gameObject.characteristic.add(simplePhysicsNode);

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
