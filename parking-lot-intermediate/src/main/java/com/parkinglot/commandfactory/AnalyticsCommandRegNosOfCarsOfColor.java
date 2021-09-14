package com.parkinglot.commandfactory;

import com.parkinglot.storage.ParkingDataStore;

public class AnalyticsCommandRegNosOfCarsOfColor implements ICommand {

    private final String SUCCESS_TEMPLATE = "Slot number %d is free";
    private final String FAILURE_TEMPLATE = "Not found";

    private final ParkingDataStore dataStore;

    public AnalyticsCommandRegNosOfCarsOfColor() {
        dataStore = ParkingDataStore.getInstance();
    }

    @Override
    public boolean validateInput(String... args) {
        if (args != null && args.length == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String execute(String... args) {
        return dataStore.getRegistrationNumberOfCarsOfGivenColor(args[0]);
    }
}
