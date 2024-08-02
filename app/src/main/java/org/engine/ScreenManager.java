package org.engine;

import javax.annotation.Nullable;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.engine.levels.Level;
import org.engine.tools.constants.Colors;
import org.engine.tools.level.LevelEnum;
import org.engine.tools.level.LevelSelector;
import org.engine.tools.physics.FramePerSecond;
import org.engine.tools.physics.Physics;
import org.engine.tools.physics.PhysicsListener;

public class ScreenManager implements PhysicsListener {
    private final JFrame jFrame = new JFrame("Application");
    private @Nullable Level currentLevel = null;

    public void startScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        jFrame.getContentPane().setBackground(Colors.CUSTOM_WHITE);
        jFrame.setSize(width, height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        Physics.getInstance().addNewListener(this);
    }

    public void setLevel(LevelEnum level) {
        try {
            currentLevel = LevelSelector.generateLevelFromIndex(level);
            jFrame.getContentPane().add(currentLevel);
            Physics.getInstance().run(FramePerSecond.THIRTY_FPS);
        } catch (Exception e) {
            currentLevel = null;
            Physics.getInstance().pause();
            e.printStackTrace();
        }
    }

    public void clearLevel() {
        jFrame.getContentPane().remove(currentLevel);
        currentLevel = null;
        Physics.getInstance().pause();
    }

    @Override
    public void onNextFrame(int time) {
        if (currentLevel != null) {
            currentLevel.repaint();
        }
    }

}
