package org.engine.levels;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.engine.gameobjects.GameObject;

public abstract class Level extends JPanel {
    public final ArrayList<GameObject> gameObjects;

    public Level(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    abstract public void createPaint();
}
