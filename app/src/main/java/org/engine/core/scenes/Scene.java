package org.engine.core.scenes;

import java.util.ArrayList;
import org.engine.core.elements.Element;

public abstract class Scene {
    protected String name;
    protected final ArrayList<Element> elements = new ArrayList<Element>();

    public String getName() {
        return name;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }
}
