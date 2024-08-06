package org.engine.application.characteristics;

import org.engine.core.characteristics.Characteristic;

public class Position extends Characteristic {
    public double posX;
    public double posY;

    public Position(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }
}
