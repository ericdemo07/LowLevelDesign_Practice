package com.parkinglot.commandfactory;

public class CommandFactory {

    public static ICommand getInstance(String stringName) {
        return CommandType.reverseLookup(stringName).getInstance();
    }
}
