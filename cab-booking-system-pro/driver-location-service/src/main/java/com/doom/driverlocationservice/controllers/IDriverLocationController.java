package com.doom.driverlocationservice.controllers;


import com.doom.driverlocationservice.models.Coordinates;
import com.doom.driverlocationservice.models.DriverAvailabilityModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface IDriverLocationController {

    @GetMapping("hello")
    String hello();

    /*
    curl --location --request POST 'localhost:50005/driver-location-service/30e01071-85f9-4416-9d73-ea3dcb813901/echo-location' \
--header 'Content-Type: application/json' \
--header 'Cookie: _csrf=NSsgXiCLEjb1KhsAdeN3s0Wf; b=68d6a460-bd0a-11e8-a1fb-9955323fe3e0; division=chicago; search_loc=%257B%2522expired%2522%253Atrue%257D' \
--data-raw '{
    "latitude" : 11.14,
    "longitude": 19.45
}'
     */
    @PostMapping("{id}/echo-location")
    boolean echoLocation(@PathVariable("id") UUID driverId, @RequestBody Coordinates coordinates);


    /*
curl --location --request POST 'localhost:50005/driver-location-service/57ad86a8-a195-4e3e-baae-c19dececbbaa/availability' \
--header 'Content-Type: application/json' \
--header 'Cookie: _csrf=NSsgXiCLEjb1KhsAdeN3s0Wf; b=68d6a460-bd0a-11e8-a1fb-9955323fe3e0; division=chicago; search_loc=%257B%2522expired%2522%253Atrue%257D' \
--data-raw '{
    "currentCoordinates": {
        "latitude": 11.12,
        "longitude": 11.11
    },
    "isAvailable": true
}'
     */
    @PostMapping("{id}/availability")
    boolean updateAvailability(@PathVariable("id") UUID driverId,
                               @RequestBody DriverAvailabilityModel driverAvailability);
}
