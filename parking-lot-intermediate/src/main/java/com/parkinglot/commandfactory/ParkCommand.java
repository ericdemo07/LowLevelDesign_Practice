package com.parkinglot.commandfactory;

import com.parkinglot.models.CarModel;
import com.parkinglot.storage.ParkingDataStore;

public class ParkCommand implements ICommand {

    private final String SUCCESS_TEMPLATE = "Allocated slot number: %d";
    private final String FAILURE_TEMPLATE = "Sorry, parking lot is full";

    private final ParkingDataStore dataStore;

    public ParkCommand() {
        dataStore = ParkingDataStore.getInstance();
    }

    @Override
    public boolean validateInput(String... args) {
        if (args != null && args.length == 2) {
            return true;
        }

        return false;
    }

    @Override
    public String execute(String... args) {
        if (dataStore.parkingFull()) {
            return FAILURE_TEMPLATE;
        }

        final CarModel carModel = new CarModel(args[0], args[1]);
        int slotNumber = dataStore.addCar(carModel);

        return String.format(SUCCESS_TEMPLATE, slotNumber + 1);
    }
}
