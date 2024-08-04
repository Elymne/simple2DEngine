package org.engine.nodes.camera;

import org.engine.gameobjects.GameObject;
import org.engine.tools.constants.CustomErrors;

public class CameraNode {
    public PositionNode positionNode;

    public CameraNode(GameObject gameObject) {
        final PositionNode positionNode = (PositionNode) gameObject.findNode(PositionNode.class);
        if (positionNode == null) {
            System.err.println(CustomErrors.NO_POSITION_FOUND);
            return;
        }
        this.positionNode = positionNode;
    }
}
