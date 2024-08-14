package org.engine.rework.scenes;

import java.util.ArrayList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.engine.rework.elements.Element;

public abstract class Scene {
    protected @Nonnull final String key;
    protected final ArrayList<Element> elements = new ArrayList<Element>();

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
        this.elements.add(element);
    }

    public void addElements(ArrayList<Element> elements) {
        this.elements.addAll(elements);
    }

    @Nullable
    public Element findElement(Class<Element> elementClass) {
        for (Element element : this.elements) {
            if (element.getClass() == elementClass) {
                return element;
            }
        }
        return null;
    }

    @Nullable
    public Element findSubElement(String key) {
        for (Element element : this.elements) {
            if (element.getKey() == key) {
                return element;
            }
        }
        return null;
    }
}