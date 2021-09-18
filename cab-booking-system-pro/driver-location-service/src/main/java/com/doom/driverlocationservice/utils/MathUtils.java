package com.doom.driverlocationservice.utils;

public final class MathUtils {

    private MathUtils() { }

    public static double roundToTwoDecimal(double num) {
        return Math.round(num * 100.0) / 100.0;
    }
}
