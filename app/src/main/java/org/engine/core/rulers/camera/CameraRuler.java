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
        this.focus = element;
    }

    public double getDrawDistance_X(double posX) {
        if (this.frame == null) {
            System.err.println("No Frame attached to current Camera Ruler. Use init() function.");
            return 0;
        }
        if (this.focus == null) {
            return (this.frame.getWidth() / 2) + (posX - 0);
        }
        return (this.frame.getWidth() / 2) + (posX - this.focus.getPosX());
    }

    public double getDrawDistance_Y(double posY) {
        if (this.frame == null) {
            System.err.println("No Frame attached to current Camera Ruler. Use init() function.");
            return 0;
        }
        if (this.focus == null) {
            return (this.frame.getHeight() / 2) + (-posY + 0);
        }
        return (this.frame.getHeight() / 2) + (-posY + this.focus.getPosY());
    }
}
