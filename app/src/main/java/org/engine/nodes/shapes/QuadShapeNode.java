package org.engine.nodes.shapes;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;
import org.engine.gameobjects.GameObject;
import org.engine.nodes.Node;
import org.engine.nodes.camera.PositionNode;
import org.engine.tools.constants.CustomErrors;
import org.engine.tools.screen.UnitSizeManager;

public class QuadShapeNode extends Node {
    public PositionNode positionNode;
    public double width;
    public double height;

    @Nullable
    public Color backgroundColor;

    @Nullable
    public Color borderColor;

    @Nullable
    public String imagePath;

    public QuadShapeNode(GameObject gameObject, double width, double height) {
        final PositionNode positionNode = (PositionNode) gameObject.findNode(PositionNode.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }

        this.positionNode = positionNode;
        this.width = width;
        this.height = height;
    }

    public QuadShapeNode(GameObject gameObject, double width, double height, Color... colors) {
        final PositionNode positionNode = (PositionNode) gameObject.findNode(PositionNode.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }

        this.positionNode = positionNode;
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

    public QuadShapeNode(GameObject gameObject, double width, double height, String imageUri) {
        final PositionNode positionNode = (PositionNode) gameObject.findNode(PositionNode.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }

        this.positionNode = positionNode;
        this.width = width;
        this.height = height;
        this.imagePath = imageUri;
    }

    public void draw(Graphics g) {
        final UnitSizeManager unitM = UnitSizeManager.getInstance();

        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect(
                    (int) (positionNode.posX * unitM.getxUnitPixels()),
                    (int) (positionNode.posY * unitM.getyUnitPixels()),
                    (int) (width * unitM.getxUnitPixels()),
                    (int) (height * unitM.getyUnitPixels()));
        }

        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(
                    (int) (positionNode.posX * unitM.getxUnitPixels()),
                    (int) (positionNode.posY * unitM.getyUnitPixels()),
                    (int) (width * unitM.getxUnitPixels()),
                    (int) (height * unitM.getyUnitPixels()));
        }
    }
}
