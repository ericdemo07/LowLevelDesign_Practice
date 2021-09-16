package com.doom.driverlocationservice.controllers;


import com.doom.driverlocationservice.models.Coordinates;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface IDriverLocationController {

    @GetMapping("hello")
    String hello();

    @PostMapping("{id}/echo-location")
    boolean echoLocation(@PathVariable("id") UUID driverId, @RequestBody Coordinates coordinates);

    @PostMapping("{id}/availability")
    boolean updateAvailability(@PathVariable("id") UUID driverId, @RequestBody boolean isAvailable);
}
