package org.engine.nodes;

public class PositionNode extends Node {
    private int posX;
    private int posY;

    public PositionNode(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setNewCoord(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}
