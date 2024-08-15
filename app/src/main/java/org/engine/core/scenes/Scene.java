package org.engine.core.scenes;

import java.util.ArrayList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.engine.core.elements.Element;
import org.engine.core.rulers.camera.CameraRuler;

public abstract class Scene {
    protected final CameraRuler cameraRuler = CameraRuler.getInstance();
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
        this.elements.add(element);
    }

    public void addElements(ArrayList<Element> elements) {
        this.elements.addAll(elements);
    }

    public void removeElement(Element element) {
        this.elements.remove(element);
    }

    public void removeElement(String key) {
        this.elements.removeIf(element -> {
            return element.getKey() == key;
        });
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
