package com.doom.tripservice.controllers;

import com.doom.tripservice.models.BookingRequestModel;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface ITripBookingController {

    @PostMapping("{passengerId}/book")
    String book(@PathVariable("passengerId") UUID passengerId, @RequestBody BookingRequestModel model);
}
