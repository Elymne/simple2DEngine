package org.engine.core.rules.metric;

import java.awt.Toolkit;

public class MetricRule {
    private static MetricRule instance;
    private static final double DEFAULT_X_UNIT_NUMBER = 100.0;

    private double xUnitNb;
    private double yUnitNb;
    private double xPixelsByUnit;
    private double yPixelsByUnit;

    private MetricRule(double xUnitNb, double yUnitNb) {
        this.xUnitNb = xUnitNb;
        this.yUnitNb = yUnitNb;
        this.xPixelsByUnit = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / xUnitNb;
        this.yPixelsByUnit = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / yUnitNb;
    }

    public static void generate(double xUnitNb, double yUnitNb) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }
        instance = new MetricRule(xUnitNb, xUnitNb);
    }

    public static void generateByWidth(double xUnitNb) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }
        final double yUnitNb = Toolkit.getDefaultToolkit().getScreenSize().getHeight()
                / (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / xUnitNb);
        instance = new MetricRule(xUnitNb, yUnitNb);
    }

    public static void generateByHeight(double yUnitNb) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }
        final double xUnitNb = Toolkit.getDefaultToolkit().getScreenSize().getWidth()
                / (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / yUnitNb);
        instance = new MetricRule(xUnitNb, yUnitNb);
    }

    public static MetricRule getInstance() {
        if (instance == null) {
            generateByWidth(DEFAULT_X_UNIT_NUMBER);
        }
        return instance;
    }

    public void update(double xUnitNb, double yUnitNb) {
        this.xUnitNb = xUnitNb;
        this.yUnitNb = yUnitNb;
        this.xPixelsByUnit = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / xUnitNb;
        this.xPixelsByUnit = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / yUnitNb;
    }

    public void updateX(double xUnitNb) {
        this.xUnitNb = xUnitNb;
        final double yUnitNb = Toolkit.getDefaultToolkit().getScreenSize().getHeight()
                / (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / xUnitNb);

        this.xPixelsByUnit = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / xUnitNb;
        this.xPixelsByUnit = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / yUnitNb;
    }

    public void updateY(double yUnitNb) {
        this.yUnitNb = yUnitNb;
        final double xUnitNb = Toolkit.getDefaultToolkit().getScreenSize().getWidth()
                / (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / yUnitNb);

        this.xPixelsByUnit = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / xUnitNb;
        this.xPixelsByUnit = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / yUnitNb;
    }

    public double getxUnitNb() {
        return xUnitNb;
    }

    public double getyUnitNb() {
        return yUnitNb;
    }

    public double getxUnitPixels() {
        return xPixelsByUnit;
    }

    public double getyUnitPixels() {
        return yPixelsByUnit;
    }

}
