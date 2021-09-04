package com.doom.driverlocationservice.controllers;

import com.doom.driverlocationservice.models.Coordinates;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController implements IDriverLocationController {

    @Override
    public String hello() {
        return "HelloWorld";
    }

    @Override
    public boolean echoLocation(Coordinates coordinates) {
        return false;
    }

    @Override
    public boolean updateAvailability(boolean isAvailable) {
        return false;
    }
}
