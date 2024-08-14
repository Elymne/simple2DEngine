package org.engine.rework.elements;

import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.engine.core.rulers.time.TimeListener;

public abstract class Element implements TimeListener {
    private @Nonnull final String key;
    private final ArrayList<Element> subElements = new ArrayList<Element>();
    private @Nullable Element parent = null;

    public Element(String name) {
        this.key = name;
    }

    public Element() {
        this.key = UUID.randomUUID().toString();
    }

    public String getKey() {
        return key;
    }

    public void addSubElement(Element element) {
        element.setParent(this);
        this.subElements.add(element);
    }

    public void addSubElements(ArrayList<Element> elements) {
        for (Element element : elements) {
            element.setParent(this);
        }
        this.subElements.addAll(elements);
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

    public void removeSubElement(Element element) {
        this.subElements.remove(element);
    }

    public void removeSubElement(String key) {
        this.subElements.removeIf(element -> {
            return element.key == key;
        });
    }

    @Nullable
    public Element getParent() {
        return this.parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }
}
