package org.engine.nodes;

import org.engine.gameobjects.GameObject;
import org.engine.tools.collisions.CollisionListener;
import org.engine.tools.collisions.CollisionType;
import org.engine.tools.collisions.Collisions;

public class CollisionNode extends Node implements CollisionListener {
    private double width;
    private double heigth;

    public CollisionNode(GameObject gameObject, double width, double heigth) {
        Collisions.getInstance().addNewGameObject(this, gameObject);
        this.width = width;
        this.heigth = heigth;
    }

    @Override
    public void onCollision(GameObject gameObject, CollisionType collisionType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onCollision'");
    }
}
