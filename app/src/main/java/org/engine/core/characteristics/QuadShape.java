package org.engine.core.characteristics;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;
import org.engine.core.constants.CustomErrors;
import org.engine.core.elements.Element;

public class QuadShape extends Shape {
    public double width;
    public double height;
    public @Nullable Color backgroundColor;
    public @Nullable Color borderColor;
    public @Nullable String imagePath;

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

    private double getWidthPixels() {
        return width * metric.getxUnitPixels();
    }

    private double getHeightPixels() {
        return height * metric.getyUnitPixels();
    }

    private double getPosXPixels() {
        return camera.getPxRelPosX(positionNode.posX) - (getWidthPixels() / 2);
    }

    private double getPosYPixels() {
        return camera.getPxRelPosY(positionNode.posY) - (getHeightPixels() / 2);
    }

    public void draw(Graphics g) {
        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect((int) getPosXPixels(), (int) getPosYPixels(), (int) getWidthPixels(), (int) getHeightPixels());
        }

        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect((int) getPosXPixels(), (int) getPosYPixels(), (int) getWidthPixels(), (int) getHeightPixels());
        }
    }
}
