package org.engine.core.characteristics;

import java.awt.Graphics;

import org.engine.core.rulers.viewport.ViewportRuler;

abstract public class Shape extends Characteristic {
    protected ViewportRuler viewportRule = ViewportRuler.getInstance();
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

    abstract public void drawFrame(Graphics g);
}
