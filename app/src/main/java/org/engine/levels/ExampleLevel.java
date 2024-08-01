package org.engine.levels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Arrays;
import org.engine.gameobjects.Block;
import org.engine.gameobjects.GameObject;

public class ExampleLevel extends Level {
    public ExampleLevel() {
        super(Arrays.asList(new GameObject[] {
                new Block(10, 10, null)
        }));
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

    @Override
    public void createPaint() {
        throw new UnsupportedOperationException("Unimplemented method 'createPaint'");
    }

}
