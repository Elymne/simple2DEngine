package org.engine.core.rules.physics;

import java.util.ArrayList;
import org.engine.application.characteristics.Physics;
import org.engine.application.characteristics.QuadShape;
import org.engine.core.elements.Element;
import org.engine.core.rules.time.TimeListener;
import org.engine.core.rules.time.TimeRule;

public class SimplePhysics implements TimeListener {
    private static SimplePhysics instance;
    private final ArrayList<Element> gameObjects = new ArrayList<Element>();

    private SimplePhysics() {
        TimeRule.getInstance().addNewListener(this);
    }

    public static SimplePhysics getInstance() {
        if (instance == null) {
            instance = new SimplePhysics();
        }
        return instance;
    }

    @Override
    public void onNextFrame(int timeDelta) {
        for (Element g1 : gameObjects) {
            final Physics physicsNode = (Physics) g1.findCharacteristic(Physics.class);
            if (physicsNode != null && physicsNode.isStatic == false) {
                final ArrayList<Element> bufferCollision = new ArrayList<Element>();
                for (Element g2 : gameObjects) {
                    if (checkCollision(g1, g2)) {
                        bufferCollision.add(g2);
                    }
                }
                physicsNode.listenCollision(bufferCollision, timeDelta);
            }
        }
    }

    public void addNewGameObject(Element gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeNewGameObject(Element gameObject) {
        gameObjects.remove(gameObject);
    }

    private boolean checkCollision(Element g1, Element g2) {
        if (g1 == g2) {
            return false;
        }

        final QuadShape shape1 = (QuadShape) g1.findCharacteristic(QuadShape.class);
        final QuadShape shape2 = (QuadShape) g2.findCharacteristic(QuadShape.class);

        if (shape1 == null || shape2 == null) {
            return false;
        }

        if (shape1.positionNode.posX + shape1.width >= shape2.positionNode.posX &&
                shape1.positionNode.posX <= shape2.positionNode.posX + shape2.width &&
                shape1.positionNode.posY + shape1.height >= shape2.positionNode.posY &&
                shape1.positionNode.posY <= shape2.positionNode.posY + shape2.height) {
            return true;
        }

        return false;
    }
}