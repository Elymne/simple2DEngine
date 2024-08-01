package org.engine;

import javax.annotation.Nullable;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import org.engine.levels.Level;
import org.engine.tools.Constants;
import org.engine.tools.LevelSelector;

public class ScreenManager {
    private final JFrame jFrame = new JFrame("Application");

    private @Nullable Level currentLevel = null;
    private @Nullable Timer currentTimer = null;

    public void startScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        jFrame.getContentPane().setBackground(Constants.CUSTOM_WHITE);
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public void setLevel(int index) {
        try {
            currentLevel = LevelSelector.generateLevelFromIndex(index);
            jFrame.getContentPane().add(currentLevel);

            currentTimer = new Timer();
            this.currentTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (currentLevel != null) {
                        currentLevel.repaint();
                        return;
                    }
                }
            }, 0, Constants.THIRTY_FPS);
        } catch (Exception e) {
            currentLevel = null;
            currentTimer = null;
            e.printStackTrace();
        }
    }

    public void clearLevel() {
        jFrame.getContentPane().remove(currentLevel);
        if (currentTimer != null) {
            currentTimer.cancel();
        }
        currentTimer = null;
        currentLevel = null;
    }

}
