package com.parkinglot.commandfactory;

import com.parkinglot.storage.ParkingDataStore;

public class StatusCommand implements ICommand {

    private final ParkingDataStore dataStore;

    public StatusCommand() {
        dataStore = ParkingDataStore.getInstance();
    }

    @Override
    public boolean validateInput(String... args) {
        return true;
    }

    @Override
    public String execute(String... args) {
        dataStore.status();
        return "";
    }
}
