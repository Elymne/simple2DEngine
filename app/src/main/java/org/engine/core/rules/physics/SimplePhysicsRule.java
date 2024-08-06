package org.engine.core.rules.physics;

import java.util.ArrayList;
import org.engine.core.characteristics.Physics;
import org.engine.core.characteristics.QuadShape;
import org.engine.core.elements.Element;
import org.engine.core.rules.time.TimeListener;
import org.engine.core.rules.time.TimeRule;

public class SimplePhysicsRule implements TimeListener {
    private static SimplePhysicsRule instance;
    private final ArrayList<Element> elements = new ArrayList<Element>();

    private SimplePhysicsRule() {
        TimeRule.getInstance().addNewListener(this);
    }

    public static SimplePhysicsRule getInstance() {
        if (instance == null) {
            instance = new SimplePhysicsRule();
        }
        return instance;
    }

    @Override
    public void onNextFrame(int timeDelta) {
        for (Element g1 : elements) {
            final Physics physics = (Physics) g1.findCharacteristic(Physics.class);
            if (physics != null && physics.isStatic() == false) {
                final ArrayList<Element> bufferCollision = new ArrayList<Element>();
                for (Element g2 : elements) {
                    if (checkCollision(g1, g2)) {
                        bufferCollision.add(g2);
                    }
                }
                physics.listenCollision(bufferCollision, timeDelta);
            }
        }
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    private boolean checkCollision(Element elem_1, Element elem_2) {
        if (elem_1 == elem_2) {
            return false;
        }

        final QuadShape shape_1 = (QuadShape) elem_1.findCharacteristic(QuadShape.class);
        final QuadShape shape_2 = (QuadShape) elem_2.findCharacteristic(QuadShape.class);

        if (shape_1 == null || shape_2 == null) {
            return false;
        }

        if (shape_1.getPointX() + shape_1.getWidth() >= shape_2.getPointX() &&
                shape_1.getPointX() <= shape_2.getPointX() + shape_2.getWidth() &&
                shape_1.getPointY() + shape_1.getHeight() >= shape_2.getPointY() &&
                shape_1.getPointY() <= shape_2.getPointY() + shape_2.getHeight()) {
            return true;
        }

        return false;
    }
}
