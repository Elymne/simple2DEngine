package org.engine.tools.screen;

import java.awt.Dimension;
import java.awt.Toolkit;

public class UnitSizeManager {
    public double xUnitNumber;
    public double yUnitNumber;

    private static UnitSizeManager instance;
    private static final double DEFAULT_X_UNIT_NUMBER = 100.0;

    private UnitSizeManager(double xUnitNumber, double yUnitNumber) {
        this.xUnitNumber = xUnitNumber;
        this.yUnitNumber = yUnitNumber;
    }

    public static void generate(double xUnitNumber, double yUnitNumber) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }
        instance = new UnitSizeManager(xUnitNumber, yUnitNumber);
    }

    public static void generateByAxisX(double xUnitNumber) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final double yUnitNumber = screenSize.getHeight() / (screenSize.getWidth() / xUnitNumber);
        instance = new UnitSizeManager(xUnitNumber, yUnitNumber);
    }

    public static void generateByAxisY(double yUnitNumber) {
        if (instance != null) {
            System.err.print("Unit size manager has already been generated.");
            return;
        }
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final double xUnitNumber = screenSize.getWidth() / (screenSize.getHeight() / yUnitNumber);
        instance = new UnitSizeManager(xUnitNumber, yUnitNumber);
    }

    public static UnitSizeManager getInstance() {
        if (instance == null) {
            generateByAxisX(DEFAULT_X_UNIT_NUMBER);
        }
        return instance;
    }

}
