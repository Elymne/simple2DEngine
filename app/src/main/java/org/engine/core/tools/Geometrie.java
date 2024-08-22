package org.engine.core.tools;

public final class Geometrie {

    public static boolean detectCollision(double posStartX_1, double posStartY_1, double width_1, double height_1,
            double posStartX_2, double posStartY_2, double width_2, double height_2) {
        if (posStartX_1 > posStartX_2 + width_2) {
            return false;
        }
        if (posStartX_1 + width_1 < posStartX_2) {
            return false;
        }
        if (posStartY_1 < posStartY_2 - height_2) {
            return false;
        }
        if (posStartY_1 - height_1 > posStartY_2) {
            return false;
        }
        return true;
    }

}
