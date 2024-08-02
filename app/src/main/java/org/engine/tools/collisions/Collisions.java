package org.engine.tools.collisions;

import java.util.ArrayList;
import org.engine.gameobjects.GameObject;
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

    private CollisionType checkCollision(GameObject gameObject1, GameObject gameObject2) {
        if (gameObject1 == gameObject2) {
            return CollisionType.NONE;
        }

        // TODO : SOustrait les valeurs entre elles et check.

        return CollisionType.NONE;
    }
}
