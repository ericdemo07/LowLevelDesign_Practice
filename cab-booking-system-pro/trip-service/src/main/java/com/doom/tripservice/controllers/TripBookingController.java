package com.doom.tripservice.controllers;

import com.doom.tripservice.models.BookingRequestModel;
import com.doom.tripservice.service.TripBookingService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("trip-service")
public class TripBookingController implements ITripBookingController {

    private final TripBookingService tripBookingService;

    public TripBookingController() {
        this.tripBookingService = new TripBookingService();
    }

    @Override
    public String book(UUID passengerId, BookingRequestModel model) {
        tripBookingService.book(model.getStartCoordinates());
        return null;
    }
}
