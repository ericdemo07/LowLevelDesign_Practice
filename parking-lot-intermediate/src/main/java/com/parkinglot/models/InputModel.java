package com.parkinglot.models;

public class InputModel {
    private String   commandAsString;
    private String[] args;

    public InputModel(String commandAsString, String[] args) {
        this.commandAsString = commandAsString;
        this.args = args;
    }

    public String getCommandAsString() {
        return commandAsString;
    }

    public String[] getArgs() {
        return args;
    }
}
