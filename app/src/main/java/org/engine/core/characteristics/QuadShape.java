package org.engine.core.characteristics;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;

import org.engine.core.constants.CustomErrors;
import org.engine.core.elements.Element;
import org.engine.core.rules.camera.CameraRule;
import org.engine.core.rules.metric.MetricRule;

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

    public void draw(Graphics g) {
        final MetricRule unitM = MetricRule.getInstance();
        final CameraRule cameraM = CameraRule.getInstance();

        final int posX = cameraM.getPxRelPosX(positionNode.posX);
        final int posY = cameraM.getPxRelPosY(positionNode.posY);
        final int width = (int) (this.width * unitM.getxUnitPixels());
        final int height = (int) (this.height * unitM.getyUnitPixels());

        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect(posX, posY, width, height);
        }

        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(posX, posY, width, height);
        }
    }
}
