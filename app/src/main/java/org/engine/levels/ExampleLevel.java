package org.engine.levels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import org.engine.exceptions.NoPositionNodeException;
import org.engine.gameobjects.Block;
import org.engine.gameobjects.GameObject;
import org.engine.gameobjects.StaticBlock;

public class ExampleLevel extends Level {
    public ExampleLevel() throws NoPositionNodeException {
        super(new ArrayList<GameObject>(Arrays.asList(new GameObject[] {
                Block.build(10, 10, 40, 40, null),
                StaticBlock.build(0, 600, 200, 20, null),
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
