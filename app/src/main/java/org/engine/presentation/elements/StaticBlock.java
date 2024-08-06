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
        final StaticBlock element = new StaticBlock(key);

        final Position position = new Position(posX, posY);
        element.characteristic.add(position);

        final QuadShape shape = new QuadShape(element, width, height);
        shape.setBackgroundColor(new Color(0x0000ff));
        element.characteristic.add(shape);

        final Physics physics = new Physics(element, true);
        element.characteristic.add(physics);

        return element;
    }

    @Override
    public void paint(Graphics g) {
        final QuadShape quadShapeNode = (QuadShape) findCharacteristic(QuadShape.class);
        if (quadShapeNode != null) {
            quadShapeNode.draw(g);
        }
    }

}
