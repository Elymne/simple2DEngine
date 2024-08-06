package org.engine.core.rules.camera;

import org.engine.core.characteristics.Position;
import org.engine.core.constants.CustomErrors;
import org.engine.core.elements.Element;
import org.engine.core.rules.viewport.ViewportRule;

public class CameraRule {
    private Position focus = new Position(0, 0);
    private static CameraRule instance;

    public static CameraRule getInstance() {
        if (instance == null) {
            instance = new CameraRule();
        }
        return instance;
    }

    public void setFocus(Element gameObject) {
        final Position positionNode = (Position) gameObject.findCharacteristic(Position.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }
        focus = positionNode;
        System.out.println("test");
    }

    public double getDistFromFocus_X(double posX) {
        final ViewportRule viewPort = ViewportRule.getInstance();
        return (viewPort.getScreenWidth() / 2) + (posX - focus.getPosX());
    }

    public double getDistFromFocus_Y(double posY) {
        final ViewportRule viewPort = ViewportRule.getInstance();
        return (viewPort.getScreenHeight() / 2) + (-posY + focus.getPosY());
    }
}
