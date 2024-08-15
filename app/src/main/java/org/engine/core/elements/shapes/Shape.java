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
        this.cameraRuler = CameraRuler.getInstance();
    }

    public Shape(double posX, double posY, double width, double height, int zIndex) {
        super();
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.zIndex = zIndex;
        this.cameraRuler = CameraRuler.getInstance();
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public double getPointX() {
        return this.posX - (width / 2);
    }

    public double getPointY() {
        return this.posY + (height / 2);
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getScale() {
        return this.scale;
    }

    public int getZIndex() {
        return this.zIndex;
    }

    @Nullable
    public Image getImage() {
        return null;
    }

    @Nullable
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public Color getBorderColor() {
        return this.borderColor;
    }

    public void move_to(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void move(double distX, double distY) {
        this.posX += distX;
        this.posY += distY;
    }

    public void drawFrame(Graphics g) {
        final int relPointX = (int) this.cameraRuler.getDrawDistance_X(getPointX());
        final int relPointY = (int) this.cameraRuler.getDrawDistance_Y(getPointY());
        final int relWidth = (int) this.getWidth();
        final int relHeight = (int) this.getHeight();
        if (this.backgroundColor != null) {
            g.setColor(this.backgroundColor);
            g.fillRect(relPointX, relPointY, relWidth, relHeight);
        }
        if (this.assetPath != null) {
            g.drawImage(this.getImage(), relPointX, relPointY, null);
        }
        if (this.borderColor != null) {
            g.setColor(this.borderColor);
            g.drawRect(relPointX, relPointY, relWidth, relHeight);
        }
    }
}
