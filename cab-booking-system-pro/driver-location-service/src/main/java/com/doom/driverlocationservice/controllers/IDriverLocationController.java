package com.doom.driverlocationservice.controllers;

import com.doom.driverlocationservice.models.Coordinates;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface IDriverLocationController {

    @GetMapping("hello")
    String hello();

    @PostMapping("echo-location")
    boolean echoLocation(Coordinates coordinates);

    @PostMapping("availability")
    boolean updateAvailability(boolean isAvailable);
}
