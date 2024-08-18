package org.engine.core.rulers.camera;

import javax.swing.JFrame;
import org.engine.core.attributes.Vector2D;

public class CameraRuler {
    private Vector2D focus;
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

    public void setFocus(Vector2D position) {
        focus = position;
    }

    public Vector2D getDrawVector(Vector2D position) {
        if (frame == null) {
            System.err.println("No Frame attached to camera. Use init() function.");
            return new Vector2D(0, 0);
        }
        if (focus == null) {
            System.err.println("No Focus attached to camera. Use setFocus() function.");
            return new Vector2D(0, 0);
        }
        return new Vector2D((frame.getWidth() / 2) + (position.getX() - focus.getX()),
                (frame.getHeight() / 2) + (-position.getY() + focus.getY()));

    }
}
