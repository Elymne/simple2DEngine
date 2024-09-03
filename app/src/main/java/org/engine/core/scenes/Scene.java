package org.engine.core.scenes;

import java.util.ArrayList;
import javax.annotation.Nonnull;
import org.engine.core.elements.Element;
import org.engine.core.elements.shapes.squads.SquadCollisionShape;
import org.engine.core.rulers.collision.CollisionRuler;

public abstract class Scene {
    private @Nonnull final String key;
    private final ArrayList<Element> elements = new ArrayList<Element>();

    public Scene(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void addElement(Element element) {
        if (element instanceof SquadCollisionShape) {
            CollisionRuler.getInstance().addElement((SquadCollisionShape) element);
        }
        this.elements.add(element);
    }

    public void removeElement(Element element) {
        if (element instanceof SquadCollisionShape) {
            CollisionRuler.getInstance().removeElement((SquadCollisionShape) element);
        }
        this.elements.remove(element);
    }
}
