package org.engine.nodes;

import java.awt.Color;

public class ShapeNode extends Node {
    public double posX;
    public double posY;
    public double width;
    public double height;

    public ShapeNode(double posX, double posY, double width, double height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public void drawSingleColor(Color color) {
    }
}
