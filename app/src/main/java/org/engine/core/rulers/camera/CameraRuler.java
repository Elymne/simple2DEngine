package org.engine.core.rulers.camera;

import javax.swing.JFrame;
import org.engine.core.elements.shapes.Shape;

public class CameraRuler {
    private Shape focus;
    private JFrame frame;

    private static CameraRuler instance;

    public static CameraRuler getInstance() {
        if (instance == null) {
            instance = new CameraRuler();
        }
        return instance;
    }

    public void init(JFrame frame) {
        this.frame = frame;
    }

    public void setFocus(Shape element) {
        focus = element;
    }

    public double getDrawDistance_X(double posX) {
        if (frame == null) {
            System.err.println("No Frame attached to current Camera Ruler. Use init() function.");
            return 0;
        }
        if (focus == null) {
            return (frame.getWidth() / 2) + (posX - 0);
        }
        return (frame.getWidth() / 2) + (posX - focus.getPosX());
    }

    public double getDrawDistance_Y(double posY) {
        if (frame == null) {
            System.err.println("No Frame attached to current Camera Ruler. Use init() function.");
            return 0;
        }
        if (focus == null) {
            return (this.frame.getHeight() / 2) + (-posY + 0);
        }
        return (frame.getHeight() / 2) + (-posY + focus.getPosY());
    }
}
