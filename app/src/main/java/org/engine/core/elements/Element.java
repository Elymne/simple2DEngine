package org.engine.core.elements;

import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.engine.core.rulers.time.TimeListener;

public abstract class Element implements TimeListener {
    private @Nonnull final String key;
    private @Nullable Element parent = null;
    private final ArrayList<Element> subElements = new ArrayList<Element>();

    public Element(String key) {
        this.key = key;
    }

    public Element() {
        key = UUID.randomUUID().toString();
    }

    public String getKey() {
        return key;
    }

    public void addSubElement(Element element) {
        element.setParent(this);
        subElements.add(element);
    }

    public void addSubElements(ArrayList<Element> elements) {
        for (Element element : elements) {
            element.setParent(this);
        }
        subElements.addAll(elements);
    }

    @Nullable
    public Element findSubElement(Class<Element> elementClass) {
        for (Element element : subElements) {
            if (element.getClass() == elementClass) {
                return element;
            }
        }
        return null;
    }

    @Nullable
    public Element findSubElement(String key) {
        for (Element element : subElements) {
            if (element.key == key) {
                return element;
            }
        }
        return null;
    }

    public ArrayList<Element> getSubElements() {
        return subElements;
    }

    public void removeSubElement(Element element) {
        subElements.remove(element);
    }

    public void removeSubElement(String key) {
        subElements.removeIf(element -> {
            return element.key == key;
        });
    }

    @Nullable
    public Element getParent() {
        return parent;
    }

    public void setParent(Element parent) {
        this.parent = parent;
    }
}
