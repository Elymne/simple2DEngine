package org.engine.tools.screen;

import java.awt.Dimension;
import java.awt.Toolkit;

public class UnitSizeManager {
    private static UnitSizeManager instance;
    private static final double DEFAULT_X_UNIT_NUMBER = 100.0;

    private double xUnitNumber;
    private double yUnitNumber;
    private double xPixels;
    private double yPixels;

    private UnitSizeManager(double xUnitNumber, double yUnitNumber, Dimension screenSize) {
        this.xUnitNumber = xUnitNumber;
        this.yUnitNumber = yUnitNumber;
        this.xPixels = screenSize.getWidth() / xUnitNumber;
        this.yPixels = screenSize.getHeight() / yUnitNumber;
    }

    public static void generate(double xUnitNumber, double yUnitNumber) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        instance = new UnitSizeManager(xUnitNumber, yUnitNumber, screenSize);
    }

    public static void generateByAxisX(double xUnitNumber) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final double yUnitNumber = screenSize.getHeight() / (screenSize.getWidth() / xUnitNumber);
        instance = new UnitSizeManager(xUnitNumber, yUnitNumber, screenSize);
    }

    public static void generateByAxisY(double yUnitNumber) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final double xUnitNumber = screenSize.getWidth() / (screenSize.getHeight() / yUnitNumber);
        instance = new UnitSizeManager(xUnitNumber, yUnitNumber, screenSize);
    }

    public static UnitSizeManager getInstance() {
        if (instance == null) {
            generateByAxisX(DEFAULT_X_UNIT_NUMBER);
        }
        return instance;
    }

    public double getxUnitNumber() {
        return xUnitNumber;
    }

    public double getyUnitNumber() {
        return yUnitNumber;
    }

    public double getxUnitPixels() {
        return xPixels;
    }

    public double getyUnitPixels() {
        return yPixels;
    }

}
