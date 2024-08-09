package org.engine.rework.elements;

import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.engine.core.rulers.time.TimeListener;

public abstract class Element implements TimeListener {
    private @Nonnull final String key;
    private @Nonnull final ArrayList<Element> subElements;

    public Element(String name, ArrayList<Element> elements) {
        this.key = name;
        this.subElements = elements;
    }

    public Element(ArrayList<Element> elements) {
        this.key = UUID.randomUUID().toString();
        this.subElements = elements;
    }

    public String getKey() {
        return key;
    }

    @Nullable
    public Element findSubElement(Class<Element> elementClass) {
        for (Element element : this.subElements) {
            if (element.getClass() == elementClass) {
                return element;
            }
        }
        return null;
    }

    @Nullable
    public Element findSubElement(String key) {
        for (Element element : this.subElements) {
            if (element.key == key) {
                return element;
            }
        }
        return null;
    }

    public ArrayList<Element> getSubElements() {
        return this.subElements;
    }

    public void addSubElement(Element element) {
        this.subElements.add(element);
    }

    public void removeSubElement(Element element) {
        this.subElements.remove(element);
    }

    public void removeSubElement(String key) {
        this.subElements.removeIf(element -> {
            return element.key == key;
        });
    }
}
