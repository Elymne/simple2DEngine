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
    public @Nullable Color backgroundColor;
    public @Nullable Color borderColor;
    public @Nullable String imagePath;

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
