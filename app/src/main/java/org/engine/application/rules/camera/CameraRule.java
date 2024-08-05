package org.engine.application.rules.camera;

import org.engine.application.characteristics.PositionNode;
import org.engine.application.rules.metric.MetricRule;
import org.engine.constants.CustomErrors;
import org.engine.core.Element;

import java.awt.Toolkit;

public class CameraRule {
    private PositionNode focus;
    private static CameraRule instance;

    private CameraRule(PositionNode positionNode) {
        focus = positionNode;
    }

    public static CameraRule getInstance() {
        if (instance == null) {
            instance = new CameraRule(new PositionNode(0, 0));
        }
        return instance;
    }

    public void setFocus(Element gameObject) {
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
        final double pixelsPerUnit = MetricRule.getInstance().getxUnitPixels();
        final double camPixelPos = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
        final double distanceFromCam = (posX - focus.posX);

        return (int) (distanceFromCam * pixelsPerUnit + camPixelPos);
    }

    public int getPxRelPosY(double posY) {
        final double pixelsPerUnit = MetricRule.getInstance().getyUnitPixels();
        final double camPixelPos = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
        final double distanceFromCam = (posY - focus.posY);

        return (int) (distanceFromCam * pixelsPerUnit + camPixelPos);
    }
}
