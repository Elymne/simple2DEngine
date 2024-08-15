package org.engine.core.elements.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.annotation.Nullable;
import org.engine.core.elements.Element;
import org.engine.core.rulers.camera.CameraRuler;

public abstract class Shape extends Element {
    private final CameraRuler cameraRuler;

    protected double posX;
    protected double posY;
    protected double width;
    protected double height;
    protected double scale = 1.0;
    protected int zIndex;

    protected @Nullable Color backgroundColor;
    protected @Nullable Color borderColor;
    protected @Nullable String assetPath;

    public Shape(String name, double posX, double posY, double width, double height, int zIndex) {
        super(name);
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.zIndex = zIndex;
        cameraRuler = CameraRuler.getInstance();
    }

    public Shape(double posX, double posY, double width, double height, int zIndex) {
        super();
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.zIndex = zIndex;
        cameraRuler = CameraRuler.getInstance();
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getPointX() {
        return posX - (width / 2);
    }

    public double getPointY() {
        return posY + (height / 2);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getScale() {
        return scale;
    }

    public int getZIndex() {
        return zIndex;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public int getzIndex() {
        return zIndex;
    }

    @Nullable
    public Image getImage() {
        return null;
    }

    @Nullable
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    @Nullable
    public Color getBorderColor() {
        return borderColor;
    }

    public void setImage(String assetPath) {
        this.assetPath = assetPath;
    }

    public void setBackgroundColor(Color color) {
        backgroundColor = color;
    }

    public void setBorderColor(Color color) {
        borderColor = color;
    }

    public void drawFrame(Graphics g) {
        final int relPointX = (int) cameraRuler.getDrawDistance_X(getPointX());
        final int relPointY = (int) cameraRuler.getDrawDistance_Y(getPointY());
        final int relWidth = (int) getWidth();
        final int relHeight = (int) getHeight();
        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(relPointX, relPointY, relWidth, relHeight);
        }
        if (assetPath != null) {
            g.drawImage(getImage(), relPointX, relPointY, null);
        }
        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect(relPointX, relPointY, relWidth, relHeight);
        }
    }
}
