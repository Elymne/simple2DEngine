package org.engine;

import javax.swing.*;
import java.awt.*;

// Java caca, no inheritence, more composition.
public class Test extends JFrame {

    public Test() {
    }

    void draw() {
        final Canvas canvas = new Canvas() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(Color.RED);
                g.drawRect(40, 0, 100, 100);
            }
        };
        canvas.setBackground(Color.WHITE);
        add(canvas);
        setSize(1000, 1000);
        setVisible(true);

    }

}
