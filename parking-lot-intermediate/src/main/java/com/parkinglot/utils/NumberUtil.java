package com.parkinglot.utils;

public final class NumberUtil {
    private NumberUtil() { }

    public static boolean isNumeric(String str) {
        if (str.isEmpty()) {
            return false;
        }

        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }
}
