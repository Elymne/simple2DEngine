package org.engine.core.screen;

import org.engine.core.constants.CustomErrors;
import org.engine.gameobjects.GameObject;
import org.engine.nodes.camera.PositionNode;
import java.awt.Toolkit;

public class CameraManager {
    private PositionNode focus;
    private static CameraManager instance;

    private CameraManager(PositionNode positionNode) {
        focus = positionNode;
    }

    public static CameraManager getInstance() {
        if (instance == null) {
            instance = new CameraManager(new PositionNode(0, 0));
        }
        return instance;
    }

    public void setFocus(GameObject gameObject) {
        final PositionNode positionNode = (PositionNode) gameObject.findNode(PositionNode.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }
        this.focus = positionNode;
    }

    public double getDistFromCamX(double posX) {
        return (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) + (posX - focus.posX);
    }

    public double getDistFromCamY(double posY) {
        return (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) + (posY - focus.posX);
    }

    public int getPxRelPosX(double posX) {
        final double pixelsPerUnit = UnitSizeManager.getInstance().getxUnitPixels();
        final double camPixelPos = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
        final double distanceFromCam = (posX - focus.posX);

        return (int) (distanceFromCam * pixelsPerUnit + camPixelPos);
    }

    public int getPxRelPosY(double posY) {
        final double pixelsPerUnit = UnitSizeManager.getInstance().getyUnitPixels();
        final double camPixelPos = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
        final double distanceFromCam = (posY - focus.posY);

        return (int) (distanceFromCam * pixelsPerUnit + camPixelPos);
    }

}
