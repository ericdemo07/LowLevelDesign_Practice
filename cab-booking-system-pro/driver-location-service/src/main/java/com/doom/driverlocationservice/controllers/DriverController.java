package com.doom.driverlocationservice.controllers;


import com.doom.driverlocationservice.models.Coordinates;
import com.doom.driverlocationservice.redis.RedisClient;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("driver-location-service")
public class DriverController implements IDriverLocationController {

    private final RedisClient redisClient;

    public DriverController() {
        this.redisClient = new RedisClient();
    }
    /*
    drivers uuid
    1. 30e01071-85f9-4416-9d73-ea3dcb813901
    2. 57ad86a8-a195-4e3e-baae-c19dececbbaa
    3. 305e2770-f281-43f7-8b33-6dbb68075972
    4. 750d0b9f-9907-4de4-984d-e144e6b1606f
     */

    @Override
    public String hello() {
        return "HelloWorld";
    }

    @Override
    public boolean echoLocation(UUID driverId, Coordinates coordinates) {
        boolean success = false;

        try {
            redisClient.updateDriverLocation(driverId, coordinates);
            success = true;
        }
        catch (JsonProcessingException e) {
            System.out.println("error occoured on echoLocation");
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean updateAvailability(UUID driverId, boolean isAvailable) {
        boolean success = false;

        try {
            redisClient.updateDriverAvailability(driverId, isAvailable);
            success = true;
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return success;
    }
}
