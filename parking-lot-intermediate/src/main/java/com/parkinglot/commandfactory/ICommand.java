package com.parkinglot.commandfactory;

public interface ICommand {

    boolean validateInput(String... args);

    String execute(String... args);
}
