package com.doom.driverlocationservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface IDriverQueryController {

    @GetMapping("/find-drivers")
    List<UUID> findDrivers(@RequestParam("latitude") double latitude,
                           @RequestParam("longitude") double longitude);
}
