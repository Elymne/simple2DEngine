package org.engine.nodes.shapes;

import java.awt.Color;
import java.awt.Graphics;
import javax.annotation.Nullable;

import org.engine.core.constants.CustomErrors;
import org.engine.core.screen.CameraManager;
import org.engine.core.screen.UnitSizeManager;
import org.engine.gameobjects.GameObject;
import org.engine.nodes.Node;
import org.engine.nodes.camera.PositionNode;

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
        final CameraManager cameraM = CameraManager.getInstance();

        if (borderColor != null) {
            g.setColor(borderColor);
            g.drawRect(
                    (int) (positionNode.posX * unitM.getxUnitPixels() - cameraM.getPositionX()),
                    (int) (positionNode.posY * unitM.getyUnitPixels() - cameraM.getPositionY()),
                    (int) (width * unitM.getxUnitPixels() - cameraM.getPositionX()),
                    (int) (height * unitM.getyUnitPixels() - cameraM.getPositionY()));
        }

        if (backgroundColor != null) {
            g.setColor(backgroundColor);
            g.fillRect(
                    (int) (positionNode.posX * unitM.getxUnitPixels() - cameraM.getPositionX()),
                    (int) (positionNode.posY * unitM.getyUnitPixels() - cameraM.getPositionY()),
                    (int) (width * unitM.getxUnitPixels() - cameraM.getPositionX()),
                    (int) (height * unitM.getyUnitPixels() - cameraM.getPositionY()));
        }
    }
}
