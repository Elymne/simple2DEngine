package org.engine.core.characteristics;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;
import org.engine.core.constants.CustomErrors;
import org.engine.core.elements.Element;
import org.engine.core.rulers.camera.CameraRuler;

public class QuadShape extends Shape {
    private double width;
    private double height;
    private @Nullable Color backgroundColor;
    private @Nullable Color borderColor;
    private @Nullable String imagePath;

    public QuadShape(Element gameObject, double width, double height) {
        final Position positionNode = (Position) gameObject.findCharacteristic(Position.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }
        this.positionNode = positionNode;
        this.width = width;
        this.height = height;
    }

    public void setBorderColor(Color color) {
        this.borderColor = color;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

    public void setImage(String path) {
        this.imagePath = path;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void updateWidth(double width) {
        this.width = width;
    }

    public void updateHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getPointX() {
        return positionNode.getPosX() - (width / 2);
    }

    public double getPointY() {
        return positionNode.getPosY() + (height / 2);
    }

    @Override
    public void drawFrame(Graphics g) {
        final CameraRuler cameraRuler = CameraRuler.getInstance();

        final int relPointX = (int) cameraRuler.getDistFromFocus_X(getPointX());
        final int relPointY = (int) cameraRuler.getDistFromFocus_Y(getPointY());
        final int relWidth = (int) getWidth();
        final int relHeight = (int) getHeight();

        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect(relPointX, relPointY, relWidth, relHeight);
        }

        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(relPointX, relPointY, relWidth, relHeight);
        }
    }
}
