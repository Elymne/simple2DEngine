package org.engine.presentation;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import org.engine.core.levels.Level;
import org.engine.core.rules.time.TimeListener;
import org.engine.core.rules.time.TimeRule;
import org.engine.core.rules.viewport.ViewportRule;
import org.engine.presentation.levels.ExampleLevel;

public class Screen implements TimeListener {
    private final JFrame jFrame = new JFrame("Application");
    private Level currentLevel = null;

    public void setupScreen() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screenSize.getWidth();
        final int height = (int) screenSize.getHeight();
        jFrame.getContentPane().setBackground(new Color(0xffffff));
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        final ViewportRule viewport = ViewportRule.getInstance();
        viewport.setjFrame(jFrame);
        viewport.setViewport(0, 0);

        final TimeRule timeRule = TimeRule.getInstance();
        timeRule.setFrameRate(TimeRule.SIXTY_FPS);
        timeRule.addNewListener(this);
    }

    public void start() {
        try {
            currentLevel = new ExampleLevel();
            jFrame.getContentPane().add(currentLevel);
            TimeRule.getInstance().run();
        } catch (Exception e) {
            currentLevel = null;
            TimeRule.getInstance().pause();
            e.printStackTrace();
        }
    }

    public void clearLevel() {
        jFrame.getContentPane().remove(currentLevel);
        currentLevel = null;
        TimeRule.getInstance().pause();
    }

    @Override
    public void onNextFrame(int time) {
        if (currentLevel != null) {
            currentLevel.repaint();
            currentLevel.revalidate();
        }
    }

}
