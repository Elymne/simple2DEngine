package org.engine.core.rules.viewport;

import java.awt.Color;
import javax.swing.JFrame;
import org.engine.core.levels.Level;

public class ViewportRule {
    private JFrame frame;

    public static int BORDERLESS_FULLSCREEN_MODE = 1;
    public static int WINDOWED_MODE = 2;
    private static ViewportRule instance;

    private ViewportRule() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0x000000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public static ViewportRule getInstance() {
        if (instance == null) {
            instance = new ViewportRule();
        }
        return instance;
    }

    public void setScreenMode(int mode) {
        if (mode == ViewportRule.WINDOWED_MODE) {
            frame.setExtendedState(JFrame.NORMAL);
            frame.setUndecorated(false);
            return;
        }

        if (mode == ViewportRule.BORDERLESS_FULLSCREEN_MODE) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            return;
        }

        System.err.println("Unknown screen mode");
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

    public void setViewport(int width, int height) {
        frame.setSize(width, height);
    }

    public void hide() {
        frame.setVisible(false);
    }

    public void start() {
        frame.setVisible(true);
    }

    // TODO Wrong place.
    public void renderLevel(Level level) {
        frame.getContentPane().add(level);
    }

    // TODO Wrong place.
    public void clearLevel(Level level) {
        frame.getContentPane().remove(level);
    }

    public int getScreenMode() {
        return frame.isUndecorated() ? ViewportRule.BORDERLESS_FULLSCREEN_MODE : ViewportRule.WINDOWED_MODE;
    }

    public int getFrameWidth() {
        return frame.getBounds().width;
    }

    public int getFrameHeight() {
        return frame.getBounds().height;
    }

    public int getWidth() {
        return frame.getWidth();
    }

    public int getHeight() {
        return frame.getHeight();
    }

    public double getScaleFactor() {
        return (double) frame.getBounds().width / getWidth();
    }

    public double getTransformedWidth(double width) {
        return (1 * width);
    }

    public double getTransformedHeight(double height) {
        return (int) (1 * height);
    }
}
