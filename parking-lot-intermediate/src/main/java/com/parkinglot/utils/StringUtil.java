package com.parkinglot.utils;

import com.parkinglot.models.InputModel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class StringUtil {
    private StringUtil() { }

    public static InputModel convertToInputModel(String str) {
        final StringTokenizer strings = new StringTokenizer(str, " ");
        final String commandAsStringName = strings.nextToken();

        final List<String> list = new ArrayList<>();

        while (strings.hasMoreTokens()) {
            list.add(strings.nextToken());
        }

        return new InputModel(commandAsStringName, list.toArray(new String[0]));
    }
}
