package org.engine.tools.physics.collision;

import java.util.ArrayList;
import org.engine.gameobjects.GameObject;
import org.engine.nodes.PhysicsNode;
import org.engine.nodes.ShapeNode;
import org.engine.tools.physics.time.Time;
import org.engine.tools.physics.time.TimeListener;

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

        final ShapeNode shape1 = (ShapeNode) g1.findNode(ShapeNode.class);
        final ShapeNode shape2 = (ShapeNode) g2.findNode(ShapeNode.class);

        if (shape1 == null || shape2 == null) {
            return false;
        }

        if (shape1.posX + shape1.width >= shape2.posX &&
                shape1.posX <= shape2.posX + shape2.width &&
                shape1.posY + shape1.height >= shape2.posY &&
                shape1.posY <= shape2.posY + shape2.height) {
            return true;
        }

        return false;

    }
}
