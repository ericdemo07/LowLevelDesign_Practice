package com.parkinglot.commandfactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum CommandType {
    PARK("park", new ParkCommand()),
    LEAVE("leave", new LeaveCommand()),
    STATUS("status", new StatusCommand()),
    ANALYTICS_REG_NOS_OF_CARS_OF_COLOR("registration_numbers_for_cars_with_colour",
                                       new AnalyticsCommandRegNosOfCarsOfColor()),
    ANALYTICS_SLOT_NOS_OF_CARS_OF_COLOR("slot_numbers_for_cars_with_colour",
                                        new AnalyticsCommandSlotNosOfCarsOfColor()),
    ANALYTICS_SLOT_NO_OF_CARS_OF_REG_NO("slot_number_for_registration_number",
                                        new AnalyticsCommandSlotNoOfCarOfRegnNo());

    private static final Map<String, CommandType> lookup = new ConcurrentHashMap<>();

    static {
        for (CommandType type : CommandType.values()) {
            lookup.put(type.stringName, type);
        }
    }

    private final ICommand command;
    private final String   stringName;

    CommandType(String stringName, ICommand command) {
        this.command = command;
        this.stringName = stringName;
    }

    public static CommandType reverseLookup(String stringName) {
        return lookup.get(stringName);
    }

    public ICommand getInstance() {
        return command;
    }
}
