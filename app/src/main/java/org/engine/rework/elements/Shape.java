package org.engine.rework.elements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.annotation.Nullable;

public abstract class Shape extends Element {
    protected double posX;
    protected double posY;

    protected double width;
    protected double height;

    protected double scale = 1.0;

    protected @Nullable Color backgroundColor;
    protected @Nullable Color borderColor;
    protected @Nullable String assetPath;

    protected int zIndex;

    public Shape(String name,
            double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(name, elements);
    }

    public Shape(double posX, double posY,
            double width, double height,
            int zIndex,
            ArrayList<Element> elements) {
        super(elements);
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

    public Image getImage() {
        return null;
    }

    public void drawFrame(Graphics g) {
        if (this.backgroundColor != null) {
            g.setColor(this.backgroundColor);
            g.fillRect((int) this.getPointX(), (int) this.getPointY(), (int) this.width, (int) this.height);
        }

        if (this.assetPath != null) {
            g.drawImage(this.getImage(), (int) this.getPointX(), (int) this.getPointY(), null);
        }

        if (this.borderColor != null) {
            g.setColor(this.borderColor);
            g.drawRect((int) this.getPointX(), (int) this.getPointY(), (int) this.width, (int) this.height);
        }
    }
}
