package org.engine.core;

import java.util.ArrayList;
import javax.swing.JPanel;

public abstract class Level extends JPanel {
    public final ArrayList<Element> gameObjects;

    public Level(ArrayList<Element> gameObjects) {
        this.gameObjects = gameObjects;
    }

}
