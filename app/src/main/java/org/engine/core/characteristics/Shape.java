package org.engine.core.characteristics;

import java.awt.Graphics;

abstract public class Shape extends Characteristic {
    protected Position positionNode;

    public double getPosX() {
        return positionNode.getPosX();
    }

    public double getPosY() {
        return positionNode.getPosY();
    }

    public void updatePosX(double posX) {
        positionNode.setPosX(posX);
    }

    public void updatePosY(double posY) {
        positionNode.setPosY(posY);
    }

    abstract public void draw(Graphics g);
}
