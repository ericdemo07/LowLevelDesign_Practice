package com.parkinglot.commandfactory;

import com.parkinglot.storage.ParkingDataStore;
import com.parkinglot.utils.NumberUtil;


public class LeaveCommand implements ICommand {

    private final String SUCCESS_TEMPLATE = "Slot number %d is free";
    private final String FAILURE_TEMPLATE = "Not found";

    private final ParkingDataStore dataStore;

    public LeaveCommand() {
        dataStore = ParkingDataStore.getInstance();
    }

    @Override
    public boolean validateInput(String... args) {
        if (args != null && args.length == 1 && NumberUtil.isNumeric(args[0])) {
            //check for negative and parking lot full
            return true;
        }
        return false;
    }

    @Override
    public String execute(String... args) {
        int slotNumber = Integer.parseInt(args[0]);
        dataStore.removeCar(slotNumber - 1);
        return String.format(SUCCESS_TEMPLATE, slotNumber);
    }
}
