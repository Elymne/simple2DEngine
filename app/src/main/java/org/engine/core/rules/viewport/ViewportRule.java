package org.engine.core.rules.viewport;

import javax.swing.JFrame;

public class ViewportRule {
    private int width, height;
    private JFrame jFrame;

    private static ViewportRule instance;

    public static ViewportRule getInstance() {
        if (instance == null) {
            instance = new ViewportRule();
        }
        return instance;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

    public void setViewport(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getScreenWidth() {
        return jFrame.getBounds().width;
    }

    public int getScreenHeight() {
        return jFrame.getBounds().height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidthScaleFactor() {
        return width / jFrame.getBounds().width;
    }

    public int getHeigthScaleFactor() {
        return height / jFrame.getBounds().height;
    }

    public int getTransformedWidth(double width) {
        return (int) (getWidthScaleFactor() * width);
    }

    public int getTransformedHeight(double height) {
        return (int) (getHeigthScaleFactor() * height);
    }
}
