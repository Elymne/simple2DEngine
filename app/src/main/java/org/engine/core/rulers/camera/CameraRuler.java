package org.engine.core.rulers.camera;

import org.engine.core.characteristics.Position;
import org.engine.core.constants.CustomErrors;
import org.engine.core.elements.Element;
import org.engine.core.rulers.viewport.ViewportRuler;

public class CameraRuler {
    private ViewportRuler viewportRuler = ViewportRuler.getInstance();
    private static CameraRuler instance;
    private Position focus = new Position(0, 0);

    public static CameraRuler getInstance() {
        if (instance == null) {
            instance = new CameraRuler();
        }
        return instance;
    }

    public void setFocus(Element element) {
        final Position positionNode = (Position) element.findCharacteristic(Position.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }
        focus = positionNode;
    }

    public double getDistFromFocus_X(double posX) {
        return (viewportRuler.getFrameWidth() / 2) + (posX - focus.getPosX());
    }

    public double getDistFromFocus_Y(double posY) {
        return (viewportRuler.getFrameHeight() / 2) + (-posY + focus.getPosY());
    }
}
