package org.engine.core.levels;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.engine.core.elements.Element;

public abstract class Level extends JPanel {
    public final ArrayList<Element> gameObjects;

    public Level(ArrayList<Element> gameObjects) {
        this.gameObjects = gameObjects;
    }

}
