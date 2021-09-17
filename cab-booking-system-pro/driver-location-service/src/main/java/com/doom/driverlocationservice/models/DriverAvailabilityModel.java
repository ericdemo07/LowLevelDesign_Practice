package com.doom.driverlocationservice.models;

import lombok.Data;

@Data
public class DriverAvailabilityModel {
    Coordinates currentCoordinates;
    Boolean     isAvailable;
}
