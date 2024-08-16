package org.engine.core.elements.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.annotation.Nullable;
import org.engine.core.attributes.Vector2D;
import org.engine.core.elements.Element;
import org.engine.core.rulers.camera.CameraRuler;

public abstract class Shape extends Element {
    private final CameraRuler cameraRuler = CameraRuler.getInstance();

    protected Vector2D pos;
    protected double width;
    protected double height;
    protected double scale = 1.0;
    protected int zIndex;

    protected @Nullable Color backgroundColor;
    protected @Nullable Color borderColor;
    protected @Nullable String assetPath;

    public Shape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name);
        this.pos = position;
        this.width = width;
        this.height = height;
        this.zIndex = zIndex;
    }

    public Shape(Vector2D position, double width, double height, int zIndex) {
        super();
        this.pos = position;
        this.width = width;
        this.height = height;
        this.zIndex = zIndex;
    }

    public Vector2D getPosition() {
        return pos;
    }

    public double getPointX() {
        return pos.x - (width / 2);
    }

    public double getPointY() {
        return pos.y + (height / 2);
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

    public void updateWidth(double width) {
        this.width = width;
    }

    public void updateHeight(double height) {
        this.height = height;
    }

    public void updateScale(double scale) {
        this.scale = scale;
    }

    public void updateZIndex(int zIndex) {
        this.zIndex = zIndex;
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

    public void setImage(@Nullable String assetPath) {
        this.assetPath = assetPath;
    }

    public void setBackgroundColor(@Nullable Color color) {
        backgroundColor = color;
    }

    public void setBorderColor(@Nullable Color color) {
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
