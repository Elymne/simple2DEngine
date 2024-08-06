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

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth_Px() {
        return width * metric.getxUnitPixels();
    }

    public double getHeight_Px() {
        return height * metric.getyUnitPixels();
    }

    public double getPosX_Px() {
        return positionNode.posX * metric.getxUnitPixels();
    }

    public double getPosY_Px() {
        return positionNode.posY * metric.getyUnitPixels();
    }

    public double getPointX_Px() {
        return camera.getPxRelPosX(positionNode.posX) - (getWidth_Px() / 2);
    }

    public double getPointY_Px() {
        return camera.getPxRelPosY(positionNode.posY) - (getHeight_Px() / 2);
    }

    public void draw(Graphics g) {
        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect((int) getPointX_Px(), (int) getPointY_Px(), (int) getWidth_Px(),
                    (int) getHeight_Px());
        }

        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect((int) getPointX_Px(), (int) getPointY_Px(), (int) getWidth_Px(),
                    (int) getHeight_Px());
        }
    }
}
