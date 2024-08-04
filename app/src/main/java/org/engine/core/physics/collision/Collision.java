package org.engine.core.physics.collision;

import java.util.ArrayList;

import org.engine.core.physics.time.Time;
import org.engine.core.physics.time.TimeListener;
import org.engine.gameobjects.GameObject;
import org.engine.nodes.physics.PhysicsNode;
import org.engine.nodes.shapes.QuadShapeNode;

public class Collision implements TimeListener {
    private static Collision instance;
    private final ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    private Collision() {
        Time.getInstance().addNewListener(this);
    }

    public static Collision getInstance() {
        if (instance == null) {
            instance = new Collision();
        }
        return instance;
    }

    @Override
    public void onNextFrame(int timeDelta) {
        for (GameObject g1 : gameObjects) {
            final PhysicsNode physicsNode = (PhysicsNode) g1.findNode(PhysicsNode.class);
            if (physicsNode != null && physicsNode.isStatic == false) {
                final ArrayList<GameObject> bufferCollision = new ArrayList<GameObject>();
                for (GameObject g2 : gameObjects) {
                    if (checkCollision(g1, g2)) {
                        bufferCollision.add(g2);
                    }
                }
                physicsNode.listenCollision(bufferCollision, timeDelta);
            }
        }
    }

    public void addNewGameObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public void removeNewGameObject(GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    private boolean checkCollision(GameObject g1, GameObject g2) {
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
                shape1.positionNode.posY + shape1.height >= shape2.positionNode.posY &&
                shape1.positionNode.posY <= shape2.positionNode.posY + shape2.height) {
            return true;
        }

        return false;

    }
}
