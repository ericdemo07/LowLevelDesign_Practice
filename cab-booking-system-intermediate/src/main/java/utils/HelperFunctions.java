package utils;

import com.doom.geoservice.models.Coordinates;

public final class HelperFunctions {

    private HelperFunctions() {}

    public static Double distance(Coordinates c1, Coordinates c2) {
        return Math.sqrt(Math.pow(c1.getX() - c2.getX(), 2) + Math.pow(c1.getY() - c2.getX(), 2));
    }
}
