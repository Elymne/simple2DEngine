package org.engine.tools.physics.collision;

import java.util.ArrayList;
import org.engine.gameobjects.GameObject;
import org.engine.nodes.PhysicsNode;
import org.engine.nodes.PositionNode;
import org.engine.tools.physics.time.Time;
import org.engine.tools.physics.time.TimeListener;

public class Collision implements TimeListener {
    private static Collision instance;
    private final ArrayList<CollisionListener> collisionListeners = new ArrayList<CollisionListener>();
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
        for (int i = 0; i < gameObjects.size(); i++) {
            final ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
            for (int j = 0; i < gameObjects.size(); i++) {
                if (checkCollision(gameObjects.get(i), gameObjects.get(j))) {
                    gameObjects.add(gameObjects.get(j));
                }
            }
            collisionListeners.get(i).onCollision(gameObjects, timeDelta);
        }
    }

    public void addNewListener(CollisionListener collisionListener) {
        collisionListeners.add(collisionListener);
    }

    public void removeNewListener(CollisionListener collisionListener) {
        collisionListeners.remove(collisionListener);
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

        final PositionNode positionNode1 = (PositionNode) g1.findNode(PositionNode.class);
        final PositionNode positionNode2 = (PositionNode) g2.findNode(PositionNode.class);

        final PhysicsNode physicsNode1 = (PhysicsNode) g1.findNode(PhysicsNode.class);
        final PhysicsNode physicsNode2 = (PhysicsNode) g2.findNode(PhysicsNode.class);

        if (physicsNode1 == null || physicsNode2 == null || positionNode1 == null || positionNode2 == null) {
            return false;
        }

        if (positionNode1.posX < positionNode2.posX + physicsNode2.width &&
                positionNode1.posX + physicsNode1.width > positionNode2.posX &&
                positionNode1.posY < positionNode2.posY + physicsNode2.heigth &&
                positionNode1.posY + physicsNode1.heigth > positionNode2.posY) {
            return false;
        }

        return false;
    }
}
