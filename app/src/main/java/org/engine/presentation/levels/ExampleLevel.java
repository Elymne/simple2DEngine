package org.engine.presentation.levels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;

import org.engine.core.elements.Element;
import org.engine.core.levels.Level;
import org.engine.presentation.elements.Block;
import org.engine.presentation.elements.StaticBlock;

public class ExampleLevel extends Level {
    public ExampleLevel() {
        name = "Example level";
        elements = new ArrayList<Element>(Arrays.asList(new Element[] {
                Block.build(50, 60, 3, 3, null),
                StaticBlock.build(0, 0, 100, 4, null),
        }));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Element element : elements) {
            element.paint(g);
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
