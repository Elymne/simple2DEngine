package org.engine.tools.collisions;

import java.util.ArrayList;

import org.engine.gameobjects.Block;
import org.engine.gameobjects.GameObject;
import org.engine.gameobjects.StaticBlock;
import org.engine.tools.physics.Physics;
import org.engine.tools.physics.PhysicsListener;

public class Collisions implements PhysicsListener {
    private static Collisions instance;
    private final ArrayList<CollisionListener> collisionListeners = new ArrayList<CollisionListener>();
    private final ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    private Collisions() {
        Physics.getInstance().addNewListener(this);
    }

    public static Collisions getInstance() {
        if (instance == null) {
            instance = new Collisions();
        }
        return instance;
    }

    @Override
    public void onNextFrame(int time) {
        for (int i = 0; i < gameObjects.size(); i++) {
            for (int j = 0; i < gameObjects.size(); i++) {
                final CollisionType collisionType = checkCollision(gameObjects.get(i), gameObjects.get(j));
                if (collisionType != CollisionType.NONE) {
                    collisionListeners.get(i).onCollision((GameObject) collisionListeners.get(j), CollisionType.BOTTOM);
                }
            }
        }
    }

    public void addNewGameObject(CollisionListener collisionListener, GameObject gameObject) {
        collisionListeners.add(collisionListener);
        gameObjects.add(gameObject);
    }

    public void removeGameObject(CollisionListener collisionListener, GameObject gameObject) {
        collisionListeners.remove(collisionListener);
        gameObjects.remove(gameObject);
    }

    private CollisionType checkCollision(GameObject g1, GameObject g2) {
        if (g1 == g2) {
            return CollisionType.NONE;
        }

        if (g1 instanceof Block == false && g1 instanceof StaticBlock == false) {
            return CollisionType.NONE;
        }

        if (g2 instanceof Block == false && g2 instanceof StaticBlock == false) {
            return CollisionType.NONE;
        }

        // final boolean c1 = g1.

        return CollisionType.NONE;
    }
}
