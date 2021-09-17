package com.doom.tripservice.controllers;

import com.doom.tripservice.models.BookingRequestModel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("trip-service")
public class TripBookingController implements ITripBookingController {

    @Override
    public String book(UUID passengerId, BookingRequestModel model) {
        return null;
    }
}
