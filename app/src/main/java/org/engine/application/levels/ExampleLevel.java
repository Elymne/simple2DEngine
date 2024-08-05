package org.engine.application.levels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import org.engine.application.elements.Block;
import org.engine.application.elements.StaticBlock;
import org.engine.core.Element;
import org.engine.core.Level;

public class ExampleLevel extends Level {
    public ExampleLevel() {
        super(new ArrayList<Element>(Arrays.asList(new Element[] {
                Block.build(10, 0, 3, 3, null),
                StaticBlock.build(0, 40, 100, 4, null),
        })));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Element gameObject : gameObjects) {
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
