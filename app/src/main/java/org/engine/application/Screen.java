package org.engine.application;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import org.engine.application.levels.tools.LevelEnum;
import org.engine.application.levels.tools.LevelSelector;
import org.engine.application.rules.time.TimeRule;
import org.engine.core.Level;
import org.engine.application.rules.metric.MetricRule;
import org.engine.application.rules.time.TimeListener;

public class Screen implements TimeListener {
    private final JFrame jFrame = new JFrame("Application");
    private Level currentLevel = null;

    public void startScreen() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screenSize.getWidth();
        final int height = (int) screenSize.getHeight();

        jFrame.getContentPane().setBackground(new Color(0xffffff));
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        MetricRule.generateByWidth(140);
        TimeRule.getInstance().changeFpsCap(TimeRule.SIXTY_FPS);
        TimeRule.getInstance().addNewListener(this);
    }

    public void setLevel(LevelEnum level) {
        try {
            currentLevel = LevelSelector.generateLevelFromIndex(level);
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
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize().width);
        if (currentLevel != null) {
            currentLevel.repaint();
            currentLevel.revalidate();
        }
    }

}
