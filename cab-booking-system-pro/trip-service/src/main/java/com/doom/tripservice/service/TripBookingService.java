package com.doom.tripservice.service;


import com.doom.tripservice.apiclients.DriverLocationServiceClient;
import com.doom.tripservice.models.Coordinates;

public class TripBookingService {

    private final DriverLocationServiceClient driverLocationServiceClient;

    public TripBookingService() {
        this.driverLocationServiceClient = new DriverLocationServiceClient();
    }

    public void book(Coordinates coordinates) {
        driverLocationServiceClient.getNearByDrivers(coordinates);
    }
}
