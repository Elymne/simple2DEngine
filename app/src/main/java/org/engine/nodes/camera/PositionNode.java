package org.engine.nodes.camera;

import org.engine.nodes.Node;

public class PositionNode extends Node {
    public double posX;
    public double posY;

    public PositionNode(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }
}
