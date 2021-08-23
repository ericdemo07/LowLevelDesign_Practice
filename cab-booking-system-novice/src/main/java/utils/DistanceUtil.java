package utils;

import models.CoordinateModel;

public class DistanceUtil {

    public static boolean distanceInRange(CoordinateModel coordinateModel1,
                                          CoordinateModel coordinateModel2,
                                          int distance) {
        double diff = Math.sqrt(Math.pow(coordinateModel1.getX() - coordinateModel2.getX(), 2)
                                        + (Math.pow(coordinateModel1.getY() - coordinateModel2.getY(), 2)));

        return diff <= distance;
    }
}
