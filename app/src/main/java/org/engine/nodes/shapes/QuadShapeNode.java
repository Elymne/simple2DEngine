package org.engine.nodes.shapes;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;
import org.engine.nodes.Node;
import org.engine.tools.screen.UnitSizeManager;

public class QuadShapeNode extends Node {
    public double posX;
    public double posY;
    public double width;
    public double height;

    @Nullable
    public Color backgroundColor;

    @Nullable
    public Color borderColor;

    @Nullable
    public String imagePath;

    public QuadShapeNode(double posX, double posY, double width, double height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public QuadShapeNode(double posX, double posY, double width, double height, Color... colors) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;

        if (colors.length == 1) {
            this.borderColor = colors[0];
        }

        if (colors.length == 2) {
            this.borderColor = colors[0];
            this.backgroundColor = colors[1];
        }
    }

    public QuadShapeNode(double posX, double posY, double width, double height, String imageUri) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.imagePath = imageUri;
    }

    public void draw(Graphics g) {
        final UnitSizeManager unitM = UnitSizeManager.getInstance();

        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect(
                    (int) (posX * unitM.getxUnitPixels()),
                    (int) (posY * unitM.getyUnitPixels()),
                    (int) (width * unitM.getxUnitPixels()),
                    (int) (height * unitM.getyUnitPixels()));
        }

        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(
                    (int) (posX * unitM.getxUnitPixels()),
                    (int) (posY * unitM.getyUnitPixels()),
                    (int) (width * unitM.getxUnitPixels()),
                    (int) (height * unitM.getyUnitPixels()));
        }

    }
}
