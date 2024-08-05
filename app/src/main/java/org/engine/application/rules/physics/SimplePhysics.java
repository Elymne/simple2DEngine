package org.engine.application.rules.physics;

import java.util.ArrayList;
import org.engine.application.characteristics.PhysicsNode;
import org.engine.application.characteristics.QuadShapeNode;
import org.engine.application.rules.time.TimeRule;
import org.engine.core.Element;
import org.engine.application.rules.time.TimeListener;

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
            final PhysicsNode physicsNode = (PhysicsNode) g1.findNode(PhysicsNode.class);
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

        final QuadShapeNode shape1 = (QuadShapeNode) g1.findNode(QuadShapeNode.class);
        final QuadShapeNode shape2 = (QuadShapeNode) g2.findNode(QuadShapeNode.class);

        if (shape1 == null || shape2 == null) {
            return false;
        }

        if (shape1.positionNode.posX + shape1.width >= shape2.positionNode.posX &&
                shape1.positionNode.posX <= shape2.positionNode.posX + shape2.width &&
                -shape1.positionNode.posY + shape1.height >= -shape2.positionNode.posY &&
                -shape1.positionNode.posY <= -shape2.positionNode.posY + shape2.height) {
            return true;
        }

        return false;
    }
}
