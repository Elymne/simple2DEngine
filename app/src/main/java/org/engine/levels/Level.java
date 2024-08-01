package org.engine.levels;

import java.util.List;
import javax.swing.JPanel;
import org.engine.gameobjects.GameObject;

public abstract class Level extends JPanel {
    public final List<GameObject> gameObjects;

    public Level(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    abstract public void createPaint();
}
