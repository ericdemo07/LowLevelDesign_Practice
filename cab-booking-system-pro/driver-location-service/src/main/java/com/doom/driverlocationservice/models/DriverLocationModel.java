package com.doom.driverlocationservice.models;

import java.util.UUID;

import lombok.Data;

@Data
public class DriverLocationModel {
    UUID        driverId;
    String      currentGridId;
    String      previousGridId;
    Coordinates position;
    boolean     isAvailable;
}
