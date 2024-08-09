package org.engine.core.characteristics;

import java.util.ArrayList;
import org.engine.core.constants.CustomErrors;
import org.engine.core.elements.Element;
import org.engine.core.rulers.physics.PhysicsListener;
import org.engine.core.rulers.physics.SimplePhysicsRuler;

public class Physics extends Characteristic implements PhysicsListener {
    private QuadShape shape;
    private double fallingSpeed = 0.08;
    private boolean isStatic;

    public Physics(Element gameObject, boolean isStatic) {
        final QuadShape shape = (QuadShape) gameObject.findCharacteristic(QuadShape.class);
        if (shape == null) {
            System.err.println(CustomErrors.NO_QUAD_SHAPE_FOUND);
            return;
        }
        this.shape = shape;
        this.isStatic = isStatic;
        SimplePhysicsRuler.getInstance().addElement(gameObject);
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean isStatic) {
        this.isStatic = isStatic;
    }

    private void falling(int timeDelta) {
        shape.updatePosY(shape.getPosY() - fallingSpeed * timeDelta);
        return;
    }

    @Override
    public void listenCollision(ArrayList<Element> buffer, int timeDelta) {
        if (buffer.size() == 0) {
            falling(timeDelta);
            return;
        }

        final QuadShape firstShape = (QuadShape) buffer.getFirst().findCharacteristic(QuadShape.class);
        if (firstShape != null && shape.getPointY() - shape.getHeight() < firstShape.getPointY()) {
            shape.updatePosY(firstShape.getPointY() + shape.getHeight() * 0.5);
        }
    }
}
