package org.engine.application.characteristics;

import org.engine.core.Characteristic;

public class PositionNode extends Characteristic {
    public double posX;
    public double posY;

    public PositionNode(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }
}
