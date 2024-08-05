package org.engine;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

import org.engine.core.constants.Colors;
import org.engine.core.level.LevelEnum;
import org.engine.core.level.LevelSelector;
import org.engine.core.physics.time.FramePerSecond;
import org.engine.core.physics.time.Time;
import org.engine.core.physics.time.TimeListener;
import org.engine.core.screen.UnitSizeManager;
import org.engine.levels.Level;

public class ScreenManager implements TimeListener {
    private final JFrame jFrame = new JFrame("Application");
    private Level currentLevel = null;

    public void startScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        jFrame.getContentPane().setBackground(Colors.CUSTOM_WHITE);
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        UnitSizeManager.generateByWidth(140);
        Time.getInstance().addNewListener(this);
    }

    public void setLevel(LevelEnum level) {
        try {
            currentLevel = LevelSelector.generateLevelFromIndex(level);
            jFrame.getContentPane().add(currentLevel);
            Time.getInstance().run(FramePerSecond.SIXTY_FPS);
        } catch (Exception e) {
            currentLevel = null;
            Time.getInstance().pause();
            e.printStackTrace();
        }
    }

    public void clearLevel() {
        jFrame.getContentPane().remove(currentLevel);
        currentLevel = null;
        Time.getInstance().pause();
    }

    @Override
    public void onNextFrame(int time) {
        if (currentLevel != null) {
            currentLevel.repaint();
            currentLevel.revalidate();
        }
    }

}
