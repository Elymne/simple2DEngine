package org.engine.core.elements.shapes.squads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.annotation.Nullable;
import org.engine.core.attributes.Vector2D;
import org.engine.core.elements.shapes.Shape;
import org.engine.core.rulers.camera.CameraRuler;

public abstract class SquadShape extends Shape {
    private final CameraRuler cameraRuler = CameraRuler.getInstance();

    protected double width;
    protected double height;
    protected double scale = 1.0;

    protected @Nullable Color backgroundColor;
    protected @Nullable Color borderColor;
    protected @Nullable String assetPath;

    public SquadShape(String name, Vector2D position, double width, double height, int zIndex) {
        super(name, position, zIndex);
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public SquadShape(Vector2D position, double width, double height, int zIndex) {
        super(position, zIndex);
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getStartPoint() {
        return new Vector2D(position.getX() - (width / 2), position.getY() + (height / 2));
    }

    public double getStartPointX() {
        return position.getX() - (width / 2);
    }

    public double getStartPointY() {
        return position.getY() + (height / 2);
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
        final Vector2D relativePoint = cameraRuler.getDrawVector(getStartPoint());
        final int relPoint_x = (int) relativePoint.getX();
        final int relPoint_y = (int) relativePoint.getY();
        final int relWidth = (int) getWidth();
        final int relHeight = (int) getHeight();
        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(relPoint_x, relPoint_y, relWidth, relHeight);
        }
        if (assetPath != null) {
            g.drawImage(getImage(), relPoint_x, relPoint_y, null);
        }
        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect(relPoint_x, relPoint_y, relWidth, relHeight);
        }
    }
}
