package org.engine.core.rulers.collision;

import java.util.ArrayList;

import org.engine.core.elements.shapes.squads.SquadCollisionShape;
import org.engine.core.rulers.time.TimeListener;
import org.engine.core.rulers.time.TimeRuler;

public class CollisionRuler implements TimeListener {
    private final ArrayList<SquadCollisionShape> elements = new ArrayList<SquadCollisionShape>();

    private static CollisionRuler instance;

    public static CollisionRuler getInstance() {
        if (instance == null) {
            instance = new CollisionRuler();
            TimeRuler.getInstance().addNewListener(instance);
        }
        return instance;
    }

    public void addElement(SquadCollisionShape element) {
        this.elements.add(element);
    }

    public void removeElement(SquadCollisionShape element) {
        this.elements.remove(element);
    }

    @Override
    public void onNextFrame(int delta) {
        for (int i = 0; i < elements.size(); i++) {
            final ArrayList<SquadCollisionShape> bufferCollision = new ArrayList<SquadCollisionShape>();
            for (int j = 0; j < elements.size(); j++) {
                if (elements.get(i).isCollidingWith(elements.get(j))) {
                    bufferCollision.add(elements.get(j));
                }
            }
            elements.get(i).listenCollision(bufferCollision, delta);
        }
    }
}
