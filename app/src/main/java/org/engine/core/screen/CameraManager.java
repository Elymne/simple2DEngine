package org.engine.core.screen;

import javax.annotation.Nullable;
import org.engine.core.constants.CustomErrors;
import org.engine.gameobjects.GameObject;
import org.engine.nodes.camera.PositionNode;

public class CameraManager {
    private @Nullable PositionNode positionNode;
    private static CameraManager instance;

    public static CameraManager getInstance() {
        if (instance == null) {
            instance = new CameraManager();
        }
        return instance;
    }

    public void setFocus(GameObject gameObject) {
        final PositionNode positionNode = (PositionNode) gameObject.findNode(PositionNode.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }
        this.positionNode = positionNode;
    }

    public double getPositionX() {
        return 0;
    }

    public double getPositionY() {
        return 0;
    }
}
