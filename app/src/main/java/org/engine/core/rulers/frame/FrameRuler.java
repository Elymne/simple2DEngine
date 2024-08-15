package org.engine.core.rulers.frame;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameRuler extends JFrame {
    private int width, height = 0;

    public static int BORDERLESS_FULLSCREEN_MODE = 1;
    public static int WINDOWED_MODE = 2;

    private static FrameRuler instance;

    public static FrameRuler getInstance() {
        if (instance == null) {
            instance = new FrameRuler();
        }
        return instance;
    }

    public void init(JPanel panel, String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.getContentPane().setBackground(new Color(0x000000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().add(panel);
        this.setTitle(title);
    }

    public void updateTitle(String title) {
        this.setTitle(title);
    }

    public void updateViewport(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setDisplayMode(int mode) {
        if (mode == FrameRuler.WINDOWED_MODE) {
            this.setExtendedState(JFrame.NORMAL);
            this.setSize(width, height);
            return;
        }
        if (mode == FrameRuler.BORDERLESS_FULLSCREEN_MODE) {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            return;
        }
        System.err.println("Unknown display mode");
    }

    public int getScreenMode() {
        return this.isUndecorated() ? FrameRuler.BORDERLESS_FULLSCREEN_MODE : FrameRuler.WINDOWED_MODE;
    }

    public int getFrameWidth() {
        return this.getWidth();
    }

    public int getFrameHeight() {
        return this.getHeight();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}
