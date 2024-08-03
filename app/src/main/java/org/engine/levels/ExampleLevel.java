package org.engine.levels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import org.engine.gameobjects.Block;
import org.engine.gameobjects.GameObject;

public class ExampleLevel extends Level {
    public ExampleLevel() {
        super(new ArrayList<GameObject>(Arrays.asList(new GameObject[] {
                new Block(10, 10, 40, 40, null)
        })));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GameObject gameObject : gameObjects) {
            gameObject.paint(g);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        return new Dimension(width, height);
    }
}
