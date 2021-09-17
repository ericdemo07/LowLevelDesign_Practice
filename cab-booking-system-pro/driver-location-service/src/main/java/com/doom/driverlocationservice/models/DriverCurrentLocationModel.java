package com.doom.driverlocationservice.models;

import java.util.UUID;

import lombok.Data;

@Data
public class DriverCurrentLocationModel {
    UUID        driverId;
    Coordinates coordinates;
}
