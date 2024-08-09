package org.engine.core.rulers.viewport;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.engine.core.rulers.scene.SceneRuler;

public class ViewportRuler {
    private static ViewportRuler instance;
    private final JFrame frame = new JFrame();
    private final JPanel panel = SceneRuler.getInstance();
    private int width, height = 0;

    public static int BORDERLESS_FULLSCREEN_MODE = 1;
    public static int WINDOWED_MODE = 2;

    private ViewportRuler() {
        frame.getContentPane().setBackground(new Color(0x000000));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(panel);
    }

    public static ViewportRuler getInstance() {
        if (instance == null) {
            instance = new ViewportRuler();
        }
        return instance;
    }

    public void setScreenMode(int mode) {
        if (mode == ViewportRuler.WINDOWED_MODE) {
            frame.setExtendedState(JFrame.NORMAL);
            frame.setSize(width, height);
            return;
        }

        // TODO update screen scaling.
        if (mode == ViewportRuler.BORDERLESS_FULLSCREEN_MODE) {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            return;
        }

        System.err.println("Unknown screen mode");
    }

    public void setTitle(String title) {
        frame.setTitle(title);
    }

    public void setViewport(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void hide() {
        frame.setVisible(false);
    }

    public void start() {
        frame.setVisible(true);
    }

    public int getScreenMode() {
        return frame.isUndecorated() ? ViewportRuler.BORDERLESS_FULLSCREEN_MODE : ViewportRuler.WINDOWED_MODE;
    }

    public int getFrameWidth() {
        return frame.getWidth();
    }

    public int getFrameHeight() {
        return frame.getHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getScaleFactor() {
        return frame.getHeight() / height;
    }
}
