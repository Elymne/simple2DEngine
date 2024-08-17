package org.engine.core.attributes;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void add(Vector2D vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void addX(double x) {
        this.x += x;
    }

    public void addY(double y) {
        this.y += y;
    }

    public void update(Vector2D vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public void update(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void updateX(double x) {
        this.x = x;
    }

    public void updateY(double y) {
        this.y = y;
    }
}
