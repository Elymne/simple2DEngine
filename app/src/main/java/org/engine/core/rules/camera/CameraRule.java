package org.engine.core.rules.camera;

import org.engine.application.characteristics.Position;
import org.engine.constants.CustomErrors;
import org.engine.core.elements.Element;
import org.engine.core.rules.metric.MetricRule;

import java.awt.Toolkit;

public class CameraRule {
    private Position focus;
    private static CameraRule instance;

    private CameraRule(Position positionNode) {
        focus = positionNode;
    }

    public static CameraRule getInstance() {
        if (instance == null) {
            instance = new CameraRule(new Position(0, 0));
        }
        return instance;
    }

    public void setFocus(Element gameObject) {
        final Position positionNode = (Position) gameObject.findCharacteristic(Position.class);
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
        return (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) + (-posY - focus.posY);
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
        final double distanceFromCam = (-posY + focus.posY);

        return (int) (distanceFromCam * pixelsPerUnit + camPixelPos);
    }
}
