package org.engine.rework.rulers.collision;

import java.util.ArrayList;
import org.engine.core.rulers.time.TimeListener;
import org.engine.core.rulers.time.TimeRuler;
import org.engine.rework.elements.shapes.CollisionShape;

public class CollisionRuler implements TimeListener {
    private final ArrayList<CollisionShape> elements = new ArrayList<CollisionShape>();

    private static CollisionRuler instance;

    public static CollisionRuler getInstance() {
        if (instance == null) {
            instance = new CollisionRuler();
        }
        return instance;
    }

    private CollisionRuler() {
        TimeRuler.getInstance().addNewListener(this);
    }

    public void addElement(CollisionShape element) {
        this.elements.add(element);
    }

    public void removeElement(CollisionShape element) {
        elements.remove(element);
    }

    @Override
    public void onNextFrame(int timeDelta) {
        for (int i = 0; i < this.elements.size(); i++) {
            final ArrayList<CollisionShape> bufferCollision = new ArrayList<CollisionShape>();
            for (int j = 0; j < this.elements.size(); j++) {
                if (this.elements.get(i).isCollidingWith(this.elements.get(j))) {
                    bufferCollision.add(this.elements.get(j));
                }
            }
            this.elements.get(i).listenCollision(bufferCollision, timeDelta);
        }
    }
}
